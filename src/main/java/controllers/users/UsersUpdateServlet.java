package controllers.users;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.validators.UserValidator;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class UsersUpdateServlet
 */
public class UsersUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            User u = em.find(User.class, (Integer)(request.getSession().getAttribute("user_id")));
            Boolean password_check_flag = true;
            String password = request.getParameter("password");
            if(password == null || password.equals("")) {
                password_check_flag = false;
            } else {
                u.setPassword(
                        EncryptUtil.getPasswordEncrypt(
                                password,
                                (String)this.getServletContext().getAttribute("salt")
                                )
                        );
            }

            u.setName(request.getParameter("name"));
            u.setMax(Integer.parseInt(request.getParameter("max")));
            u.setColor(request.getParameter("color"));

            String tmp_book = request.getParameter("book");
            String book = null;
            if(tmp_book != null && !tmp_book.equals("")) {
                book = String.join(",", request.getParameterValues("book"));
            }
            u.setBook(book);

            u.setAdmin_flag(Integer.parseInt(request.getParameter("admin_flag")));
            u.setDelete_flag(0);

            List<String> errors = UserValidator.validate(u, password_check_flag);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("user", u);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "It has been complieted.");

                request.getSession().removeAttribute("user_id");

                response.sendRedirect(request.getContextPath() + "/users/index");
            }

        }
	}

}

package controllers.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("hasError", false);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean check_result = false;

        String name = request.getParameter("name");
        String plain_pass = request.getParameter("password");

        User u = null;

        if(name != null && !name.equals("") && plain_pass != null && !plain_pass.equals("")) {
            EntityManager em = DBUtil.createEntityManager();

            String password = EncryptUtil.getPasswordEncrypt(
                    plain_pass,
                    (String)this.getServletContext().getAttribute("salt")
                    );
         try {
             u = em.createNamedQuery("checkLoginNameAndPassword", User.class)
                     .setParameter("name", name)
                     .setParameter("pass", password)
                     .getSingleResult();
         } catch(NoResultException ex) {}

         em.close();

         if(u != null){
             check_result = true;
         }

       }

        if(!check_result) {
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("hasError", true);
            request.setAttribute("name", name);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("login_user", u);
            request.getSession().setAttribute("flush", "You have logged.");
            response.sendRedirect(request.getContextPath() + "/top");
        }
	}

}

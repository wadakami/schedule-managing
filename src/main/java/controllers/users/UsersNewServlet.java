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
import utils.DBUtil;

/**
 * Servlet implementation class UsersNewServlet
 */
public class UsersNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("user", new User());

          EntityManager em = DBUtil.createEntityManager();//ユーザー情報をすべて取得

            List<String> allbooks = em.createNamedQuery("getBookName", String.class)
                    .getResultList();

            em.close();

            request.setAttribute("allbooks", allbooks);


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/new.jsp");
        rd.forward(request, response);
	}

}

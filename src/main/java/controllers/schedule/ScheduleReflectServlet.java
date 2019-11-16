package controllers.schedule;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class ScheduleReflectServlet
 */
public class ScheduleReflectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleReflectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<User> users = em.createNamedQuery("getAllUsers", User.class)
                             .getResultList();
        User u;

        if(!request.getParameter("student_1").equals("")) {
            u = em.createNamedQuery("getUser", User.class)
                    .setParameter("name", request.getParameter("student_1"))
                    .getSingleResult();
            String[] books_1 = u.getBook().split(",");
            request.setAttribute("student_1", request.getParameter("student_1"));
            request.setAttribute("books_1", books_1);
            request.setAttribute("time_1", request.getParameter("time_1"));
        }

        if(!request.getParameter("student_2").equals("")) {
            u = em.createNamedQuery("getUser", User.class)
                    .setParameter("name", request.getParameter("student_2"))
                    .getSingleResult();
            String[] books_2 = u.getBook().split(",");
            request.setAttribute("student_2", request.getParameter("student_2"));
            request.setAttribute("books_2", books_2);
            request.setAttribute("time_2", request.getParameter("time_2"));
        }

        if(!request.getParameter("student_3").equals("")) {
            u = em.createNamedQuery("getUser", User.class)
                .setParameter("name", request.getParameter("student_3"))
                .getSingleResult();
            String[] books_3 = u.getBook().split(",");
            request.setAttribute("student_3", request.getParameter("student_3"));
            request.setAttribute("books_3", books_3);
            request.setAttribute("time_3", request.getParameter("time_3"));
        }

        if(!request.getParameter("student_4").equals("")) {
            u = em.createNamedQuery("getUser", User.class)
                    .setParameter("name", request.getParameter("student_4"))
                    .getSingleResult();
            String[] books_4 = u.getBook().split(",");
            request.setAttribute("student_4", request.getParameter("student_4"));
            request.setAttribute("books_4", books_4);
            request.setAttribute("time_4", request.getParameter("time_4"));
        }

        if(!request.getParameter("student_5").equals("")) {
             u = em.createNamedQuery("getUser", User.class)
                     .setParameter("name", request.getParameter("student_5"))
                     .getSingleResult();
             String[] books_5 = u.getBook().split(",");
             request.setAttribute("student_5", request.getParameter("student_5"));
             request.setAttribute("books_5", books_5);
             request.setAttribute("time_5", request.getParameter("time_5"));
        }

        if(!request.getParameter("student_6").equals("")) {
             u = em.createNamedQuery("getUser", User.class)
                     .setParameter("name", request.getParameter("student_6"))
                     .getSingleResult();
             String[] books_6 = u.getBook().split(",");
             request.setAttribute("student_6", request.getParameter("student_6"));
             request.setAttribute("books_6", books_6);
             request.setAttribute("time_6", request.getParameter("time_6"));
        }

        if(!request.getParameter("student_7").equals("")) {
             u = em.createNamedQuery("getUser", User.class)
                     .setParameter("name", request.getParameter("student_7"))
                     .getSingleResult();
             String[] books_7 = u.getBook().split(",");
             request.setAttribute("student_7", request.getParameter("student_7"));
             request.setAttribute("books_7", books_7);
             request.setAttribute("time_7", request.getParameter("time_7"));
        }

        if(!request.getParameter("student_8").equals("")) {
             u = em.createNamedQuery("getUser", User.class)
                     .setParameter("name", request.getParameter("student_8"))
                     .getSingleResult();
             String[] books_8 = u.getBook().split(",");
             request.setAttribute("student_8", request.getParameter("student_8"));
             request.setAttribute("books_8", books_8);
             request.setAttribute("time_8", request.getParameter("time_8"));
        }

       em.close();
       request.setAttribute("main", request.getParameter("main"));

       request.setAttribute("users", users);
       request.setAttribute("date", Date.valueOf(request.getParameter("date")));
       request.setAttribute("teacher", request.getParameter("teacher"));
       request.setAttribute("_token", request.getParameter("_token"));

       request.setAttribute("reflect", "1");

       if(request.getSession().getAttribute("edit") == null) {

           RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/new.jsp");
           rd.forward(request, response);

       } else {

           request.setAttribute("edit", request.getSession().getAttribute("edit"));
           request.getSession().removeAttribute("edit");

           RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/edit.jsp");
           rd.forward(request, response);

       }
	}

}

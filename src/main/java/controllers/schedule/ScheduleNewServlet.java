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

import models.Schedule;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleNewServlet
 */
public class ScheduleNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //一番最初に先生情報が取得できるようになっているものとす。
        request.setAttribute("_token", request.getSession().getId());

        Schedule s = new Schedule();
        request.setAttribute("schedule", s);
        request.setAttribute("date", Date.valueOf(request.getParameter("d")));

        EntityManager em = DBUtil.createEntityManager();//DB情報アクセス開始

        List<User> users = em.createNamedQuery("getAllUsers", User.class)
                  .getResultList();

        em.close();

        request.setAttribute("users", users);
        request.setAttribute("main", request.getParameter("main"));


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/new.jsp");
        rd.forward(request, response);
	}

}

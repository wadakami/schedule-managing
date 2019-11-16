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
 * Servlet implementation class ScheduleEditServlet
 */
public class ScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date date = Date.valueOf(request.getParameter("d"));

        EntityManager em = DBUtil.createEntityManager();

        List<Schedule> schedules;
        if(request.getParameter("main").equals("student")){

            schedules = em.createNamedQuery("getStudentSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("student", request.getParameter("t"))
                    .getResultList();
            request.setAttribute("student", request.getParameter("t"));

        } else {

            schedules = em.createNamedQuery("getTeacherSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("teacher", request.getParameter("t"))
                    .getResultList();
            request.setAttribute("teacher", request.getParameter("t"));

        }

        List<User> users = em.createNamedQuery("getAllUsers", User.class)
                .getResultList();

        String[] books = null;
        for(User one: users) {
            if(one.getName().equals(request.getParameter("t"))) {//生徒の教科書or教師の教科書
             books = one.getBook().split(",");
             System.out.println(one.getBook());
             }
         }


        for(Schedule itme : schedules) {
            System.out.println(itme.getTime());
            switch(itme.getTime()) {
            case 1:
                request.setAttribute("book_1", itme.getBook());
                request.setAttribute("books_01", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_1", itme.getTeacher());
                } else {
                    request.setAttribute("user_1", itme.getStudent());
                }
                break;
            case 2:
                request.setAttribute("book_2", itme.getBook());
                request.setAttribute("books_02", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_2", itme.getTeacher());
                } else {
                    request.setAttribute("user_2", itme.getStudent());
                }
                break;
            case 3:
                request.setAttribute("book_3", itme.getBook());
                request.setAttribute("books_03", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_3", itme.getTeacher());
                } else {
                    request.setAttribute("user_3", itme.getStudent());
                }
                break;
            case 4:
                request.setAttribute("book_4", itme.getBook());
                request.setAttribute("books_04", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_4", itme.getTeacher());
                } else {
                    request.setAttribute("user_4", itme.getStudent());
                }
                break;
            case 5:
                request.setAttribute("book_5", itme.getBook());
                request.setAttribute("books_05", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_5", itme.getTeacher());
                } else {
                    request.setAttribute("user_5", itme.getStudent());
                }
                break;
            case 6:
                request.setAttribute("book_6", itme.getBook());
                request.setAttribute("books_06", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_6", itme.getTeacher());
                } else {
                    request.setAttribute("user_6", itme.getStudent());
                }
                break;
            case 7:
                request.setAttribute("book_7", itme.getBook());
                request.setAttribute("books_07", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_7", itme.getTeacher());
                } else {
                    request.setAttribute("user_7", itme.getStudent());
                }
                break;
            case 8:
                request.setAttribute("book_8", itme.getBook());
                request.setAttribute("books_08", books);
                if(request.getParameter("main").equals("student")) {
                    request.setAttribute("user_8", itme.getTeacher());
                } else {
                    request.setAttribute("user_8", itme.getStudent());
                }
                break;
            }

        }

         em.close();

        request.setAttribute("main", request.getParameter("main"));
        request.setAttribute("schedules", schedules);
        request.setAttribute("users", users);
        request.setAttribute("date", date);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("edit", "1");//?

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/edit.jsp");
        rd.forward(request, response);
	}

}

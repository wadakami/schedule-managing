package controllers.schedule;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleShowServlet
 */
public class ScheduleShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Date date = Date.valueOf(request.getParameter("date"));
        int login_id = (int) request.getSession().getAttribute("login_id");

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);

        if(1 == cal1.get(Calendar.DAY_OF_WEEK) || 7 == cal1.get(Calendar.DAY_OF_WEEK)) {
            int holiday = 9;
            request.setAttribute("holiday", holiday);
        }

        if(login_id == 0) {


                List<Schedule> schedules = em.createNamedQuery("getStudentSchedule", Schedule.class)
                        .setParameter("date", date)
                        .setParameter("student", request.getParameter("name"))
                        .getResultList();

                em.close();

                request.setAttribute("date", date);
                request.setAttribute("schedules", schedules);
                request.setAttribute("name", request.getParameter("name"));
                request.setAttribute("_token", request.getSession().getId());

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index_usual.jsp");
                rd.forward(request, response);



        } else if(login_id == 1) {

            List<Schedule> schedules = em.createNamedQuery("getTeacherSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("teacher", request.getParameter("name"))
                    .getResultList();

            em.close();

            request.setAttribute("date", date);
            request.setAttribute("schedules", schedules);
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("_token", request.getSession().getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index_usual.jsp");
            rd.forward(request, response);

        } else if(login_id == 2) {//管理者

            if(request.getParameter("action").equals("check")) {
                //日付で検索
            List<Schedule> schedules = em.createNamedQuery("getThenSchedules", Schedule.class)
                                 .setParameter("date", date)
                                 .getResultList();
            List<Schedule> time_1 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 1)
                    .getResultList();
            List<Schedule> time_2 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 2)
                    .getResultList();
            List<Schedule> time_3 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 3)
                    .getResultList();
            List<Schedule> time_4 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 4)
                    .getResultList();
            List<Schedule> time_5 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 5)
                    .getResultList();
            List<Schedule> time_6 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 6)
                    .getResultList();
            List<Schedule> time_7 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 7)
                    .getResultList();
            List<Schedule> time_8 = em.createNamedQuery("getTime", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("time", 8)
                    .getResultList();
            List<String> allTeacher = em.createNamedQuery("getThenAllTeacher", String.class)
                    .setParameter("date", date)
                    .getResultList();

            em.close();

            for(int i = 0; allTeacher.size() > i; i++) {
                String teacher = null;
                try {
                    teacher = time_1.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_1.add(i, null);
                }
                try {
                    teacher = time_2.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_2.add(i, null);
                }
                try {
                    teacher = time_3.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_3.add(i, null);
                }
                try {
                    teacher = time_4.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_4.add(i, null);
                }
                try {
                    teacher = time_5.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_5.add(i, null);
                }
                try {
                    teacher = time_6.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_6.add(i, null);
                }
                try {
                    teacher = time_7.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_7.add(i, null);
                }
                try {
                    teacher = time_8.get(i).getTeacher();
                } catch (IndexOutOfBoundsException e) {
                    teacher = "None";
                }
                if(!allTeacher.get(i).equals(teacher)) {
                    time_8.add(i, null);
                }
            }
            request.setAttribute("time_1", time_1);
            request.setAttribute("time_2", time_2);
            request.setAttribute("time_3", time_3);
            request.setAttribute("time_4", time_4);
            request.setAttribute("time_5", time_5);
            request.setAttribute("time_6", time_6);
            request.setAttribute("time_7", time_7);
            request.setAttribute("time_8", time_8);

            request.setAttribute("schedules", schedules);
            request.setAttribute("date", date);
            request.setAttribute("_token", request.getSession().getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index2.jsp");
            rd.forward(request, response);

            } else if(request.getParameter("action").equals("copy")) {

                List<Schedule> schedules = em.createNamedQuery("getThenSchedules", Schedule.class)
                        .setParameter("date", date)
                        .getResultList();
                em.close();

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, 1);
                java.util.Date date_1 = cal.getTime();

                cal.add(Calendar.DATE, 1);
                java.util.Date date_2 = cal.getTime();

                request.setAttribute("date", date);
                request.setAttribute("date_1", date_1);
                request.setAttribute("date_2", date_2);
                request.setAttribute("schedules", schedules);
                request.setAttribute("_token", request.getSession().getId());

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/duplicate/edit.jsp");
                rd.forward(request, response);

            }

        }
	}

}

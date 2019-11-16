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
 * Servlet implementation class ScheduleIndexServlet
 */
public class ScheduleIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("flush") != null) {
        request.setAttribute("flush", request.getSession().getAttribute("flush"));
        request.getSession().removeAttribute("flush");
        }

        EntityManager em = DBUtil.createEntityManager();

        Date date = new Date(System.currentTimeMillis());
        request.setAttribute("date", date);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);

        if(1 == cal1.get(Calendar.DAY_OF_WEEK) || 7 == cal1.get(Calendar.DAY_OF_WEEK)) {
            int holiday = 9;
            request.setAttribute("holiday", holiday);
        }

        request.getSession().removeAttribute("edit");

        String id_proof = request.getParameter("id");
        int login_id;
        if(id_proof != null && !id_proof.equals("")) {
            login_id = Integer.parseInt(request.getParameter("id"));//it's about admin_flag
            request.getSession().setAttribute("login_id", login_id);
        } else {
            login_id = (int) request.getSession().getAttribute("login_id");
        }



        request.setAttribute("name", request.getParameter("name"));//user.name

        if(login_id == 0) {//student

            List<Schedule> schedules = em.createNamedQuery("getStudentSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("student", request.getParameter("name"))
                    .getResultList();

            em.close();

            request.setAttribute("schedules", schedules);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index_usual.jsp");
            rd.forward(request, response);

        } else if(login_id == 1) {//teacher

            List<Schedule> schedules = em.createNamedQuery("getTeacherSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("teacher", request.getParameter("name"))
                    .getResultList();

            em.close();

            request.setAttribute("schedules", schedules);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index_usual.jsp");
            rd.forward(request, response);

        } else if(login_id == 2) {//Administrator
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
            //getThenAllTeacher
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

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index2.jsp");
            rd.forward(request, response);

        }



	}

}

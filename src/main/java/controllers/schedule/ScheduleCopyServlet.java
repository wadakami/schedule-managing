package controllers.schedule;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import models.validators.DuplicateValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleCopyServlet
 */
public class ScheduleCopyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleCopyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Schedule> schedules = em.createNamedQuery("getThenSchedules", Schedule.class)
                .setParameter("date", Date.valueOf(request.getParameter("date")))
                .getResultList();

        List<String> teachers = em.createNamedQuery("getThenAllTeacher", String.class)
                .setParameter("date", Date.valueOf(request.getParameter("date")))
                .getResultList();




        Schedule s1 = new Schedule();
        Schedule s2 = new Schedule();

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(Date.valueOf(request.getParameter("date_1")));

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(Date.valueOf(request.getParameter("date_2")));

        long diffTime = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        int difDayMillis = 1000 * 60 * 60 * 24;
        int diffDays = (int)(diffTime / difDayMillis);


        List<String> allcal = new ArrayList<String>(); //initialize

        if(1 == cal1.get(Calendar.DAY_OF_WEEK) || 7 == cal1.get(Calendar.DAY_OF_WEEK)) {
        } else {
            allcal.add(request.getParameter("date_1"));
        }
        String done;

        for(int g = 0; g < diffDays; g++) {
            cal1.add(Calendar.DATE, 1);

            if(1 == cal1.get(Calendar.DAY_OF_WEEK) || 7 == cal1.get(Calendar.DAY_OF_WEEK)) {
                //1=Sunday, 7=Saturday
            } else {
                done = new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime());
                allcal.add(done);
            }
        }

        List<String> errors = DuplicateValidator.validate(diffDays, schedules, teachers);

        if(errors.size() > 0) {

            request.setAttribute("errors", errors);
            request.setAttribute("date", Date.valueOf(request.getParameter("date")));
            request.setAttribute("date_1", Date.valueOf(request.getParameter("date_1")));
            request.setAttribute("date_2", Date.valueOf(request.getParameter("date_2")));
            request.setAttribute("_token", request.getSession().getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/duplicate/edit.jsp");
            rd.forward(request, response);

        } else {

            em.getTransaction().begin();

            for(int p =0; p < allcal.size(); p++) {

                    for(int i = 0; i < schedules.size(); i++ ) {//only 1 day copy

                    s1 = schedules.get(i);

                    s2.setDate(Date.valueOf(allcal.get(p)));
                    s2.setAbsent(s1.getAbsent());
                    s2.setBook(s1.getBook());
                    s2.setStudent(s1.getStudent());
                    s2.setTeacher(s1.getTeacher());
                    s2.setTime(s1.getTime());
                    s2.setUser(s1.getUser());

                    em.merge(s2);
                    em.flush();
                    em.clear();

                    }
            }

            em.getTransaction().commit();
            em.close();

            request.getSession().setAttribute("flush", "You have completed the duplicate .");
            response.sendRedirect(request.getContextPath() + "/schedule/index");

        }
	}

}

package secret;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SecretIndex
 */
public class SecretIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecretIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Schedule> time_1 = new ArrayList<Schedule>();
        List<Schedule> time_2 = new ArrayList<Schedule>();
        List<Schedule> time_3 = new ArrayList<Schedule>();
        List<Schedule> time_4 = new ArrayList<Schedule>();
        List<Schedule> time_5 = new ArrayList<Schedule>();
        List<Schedule> time_6 = new ArrayList<Schedule>();
        List<Schedule> time_7 = new ArrayList<Schedule>();
        List<Schedule> time_8 = new ArrayList<Schedule>();
        List<String> anTeacher = new ArrayList<String>();

        Date date = new Date(System.currentTimeMillis());
        request.setAttribute("date", date);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);

        if(1 == cal1.get(Calendar.DAY_OF_WEEK) || 7 == cal1.get(Calendar.DAY_OF_WEEK)) {
            int holiday = 9;
            request.setAttribute("holiday", holiday);
        }

        EntityManager em = DBUtil.createEntityManager();

        List<Schedule> schedules = em.createNamedQuery("getThenSchedules", Schedule.class)
                .setParameter("date", date)
                .getResultList();

        em.close();

        for(Schedule item : schedules) {
            anTeacher.add(item.getTeacher());//in all teachers

            switch(item.getTime()){
            case 1:
                time_1.add(item);
                break;
            case 2:
                time_2.add(item);
                break;
            case 3:
                time_3.add(item);
                break;
            case 4:
                time_4.add(item);
                break;
            case 5:
                time_5.add(item);
                break;
            case 6:
                time_6.add(item);
                break;
            case 7:
                time_7.add(item);
                break;
            case 8:
                time_8.add(item);
                break;
            }
        }

        List<String> allTeacher = anTeacher.stream().distinct().collect(Collectors.toList());
        System.out.println(allTeacher.size());
        for(int i = 0; allTeacher.size() > i; i++) {
            System.out.println(allTeacher.get(i));
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

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/secret/index.jsp");
            rd.forward(request, response);


	}

}

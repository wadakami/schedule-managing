package controllers.schedule;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import models.User;
import models.validators.ShcheduleValidator;
import models.validators.StudentValidator;
//import models.validators.StudentValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleUpdateServlet
 */
public class ScheduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            System.out.println(request.getParameter("date"));

            Date date = Date.valueOf(request.getParameter("date"));



            EntityManager em = DBUtil.createEntityManager();

            List<Schedule> schedules = em.createNamedQuery("getTeacherSchedule", Schedule.class)
                    .setParameter("date", date)
                    .setParameter("teacher", request.getParameter("teacher"))
                    .getResultList();

            List<User> users = em.createNamedQuery("getAllUsers", User.class)
                    .getResultList();

            Schedule s = new Schedule();

            s.setDate(date);
            s.setTeacher(request.getParameter("teacher"));

            Boolean check_update = true;//when it true, ignore teacher validation

            String[] students = {request.getParameter("student_1"), request.getParameter("student_2"),
                    request.getParameter("student_3"), request.getParameter("student_4"), request.getParameter("student_5"),
                    request.getParameter("student_6"), request.getParameter("student_7"), request.getParameter("student_8")};

            String[] allbooks = {request.getParameter("book_1"), request.getParameter("book_2"),
                    request.getParameter("book_3"), request.getParameter("book_4"), request.getParameter("book_5"),
                    request.getParameter("book_6"), request.getParameter("book_7"), request.getParameter("book_7")};

            List<String> errors = ShcheduleValidator.validate(s, check_update);

            errors.addAll(StudentValidator.validate(s, students, 1, request.getParameter("student_1"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 2, request.getParameter("student_2"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 3, request.getParameter("student_3"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 4, request.getParameter("student_4"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 5, request.getParameter("student_5"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 6, request.getParameter("student_6"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 7, request.getParameter("student_7"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 8, request.getParameter("student_8"), check_update));
            errors.addAll(StudentValidator.validate_max(s, students, allbooks, check_update));

            if(errors.size() > 0) {

                request.setAttribute("user_1", request.getParameter("user_1"));
                request.setAttribute("user_2", request.getParameter("user_2"));
                request.setAttribute("user_3", request.getParameter("user_3"));
                request.setAttribute("user_4", request.getParameter("user_4"));
                request.setAttribute("user_5", request.getParameter("user_5"));
                request.setAttribute("user_6", request.getParameter("user_6"));
                request.setAttribute("user_7", request.getParameter("user_7"));
                request.setAttribute("user_8", request.getParameter("user_8"));
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("errors", errors);
                request.setAttribute("schedules", schedules);
                request.setAttribute("users", users);
                request.setAttribute("date", date);
                request.setAttribute("teacher", request.getParameter("teacher"));
                request.getSession().setAttribute("edit", "1");

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/edit.jsp");
                rd.forward(request, response);

            } else {

                em.getTransaction().begin();

                Schedule s1 = null;
                Boolean c1 = false;
                try {
                    s1 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 1)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c1 = true;//Nothing contain
                }
                if(!request.getParameter("student_1").equals("")) {//DBあり登録あり
                    s1.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_1"))
                            .getSingleResult());
                    s1.setStudent(request.getParameter("student_1"));
                    s1.setBook(request.getParameter("book_1"));
                    s1.setAbsent(0);
                    if(c1) {//DBなし登録あり
                        em.merge(s1);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c1) {//DBあり登録なし
                        em.remove(s1);
                    }
                }

                Schedule s2 = null;
                Boolean c2 = false;
                try {
                    s2 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 2)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c2 = true;//Nothing contain
                }
                if(!request.getParameter("student_2").equals("")) {//DBあり登録あり
                    s2.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_2"))
                            .getSingleResult());
                    s2.setStudent(request.getParameter("student_2"));
                    s2.setBook(request.getParameter("book_2"));
                    s2.setAbsent(0);
                    if(c2) {//DBなし登録あり
                        em.merge(s2);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c2) {//DBあり登録なし
                        em.remove(s2);
                    }
                }

                Schedule s3 = null;
                Boolean c3 = false;
                try {
                    s3 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 3)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c3 = true;//Nothing contain
                }
                if(!request.getParameter("student_3").equals("")) {//DBあり登録あり
                    s3.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_3"))
                            .getSingleResult());
                    s3.setStudent(request.getParameter("student_3"));
                    s3.setBook(request.getParameter("book_3"));
                    s3.setAbsent(0);
                    if(c3) {//DBなし登録あり
                        em.merge(s3);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c3) {//DBあり登録なし
                        em.remove(s3);
                    }
                }

                Schedule s4 = null;
                Boolean c4 = false;
                try {
                    s4 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 4)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c4 = true;//Nothing contain
                }
                if(!request.getParameter("student_4").equals("")) {//DBあり登録あり
                    s4.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_4"))
                            .getSingleResult());
                    s4.setStudent(request.getParameter("student_4"));
                    s4.setBook(request.getParameter("book_4"));
                    s4.setAbsent(0);
                    if(c4) {//DBなし登録あり
                        em.merge(s4);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c4) {//DBあり登録なし
                        em.remove(s4);
                    }
                }

                Schedule s5 = null;
                Boolean c5 = false;
                try {
                    s5 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 5)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c5 = true;//Nothing contain
                }
                if(!request.getParameter("student_5").equals("")) {//DBあり登録あり
                    s5.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_5"))
                            .getSingleResult());
                    s5.setStudent(request.getParameter("student_5"));
                    s5.setBook(request.getParameter("book_5"));
                    s5.setAbsent(0);
                    if(c5) {//DBなし登録あり
                        em.merge(s5);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c5) {//DBあり登録なし
                        em.remove(s5);
                    }
                }

                Schedule s6 = null;
                Boolean c6= false;
                try {
                    s6 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 6)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c6 = true;//Nothing contain
                }
                if(!request.getParameter("student_6").equals("")) {//DBあり登録あり
                    s6.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_6"))
                            .getSingleResult());
                    s6.setStudent(request.getParameter("student_6"));
                    s6.setBook(request.getParameter("book_6"));
                    s6.setAbsent(0);
                    if(c6) {//DBなし登録あり
                        em.merge(s6);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c6) {//DBあり登録なし
                        em.remove(s6);
                    }
                }

                Schedule s7 = null;
                Boolean c7 = false;
                try {
                    s7 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 7)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c7 = true;//Nothing contain
                }
                if(!request.getParameter("student_7").equals("")) {//DBあり登録あり
                    s7.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_7"))
                            .getSingleResult());
                    s7.setStudent(request.getParameter("student_7"));
                    s7.setBook(request.getParameter("book_7"));
                    s7.setAbsent(0);
                    if(c7) {//DBなし登録あり
                        em.merge(s7);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c7) {//DBあり登録なし
                        em.remove(s7);
                    }
                }

                Schedule s8 = null;
                Boolean c8 = false;
                try {
                    s8 = em.createNamedQuery("getExactTime", Schedule.class)
                            .setParameter("date", Date.valueOf(request.getParameter("date")))
                            .setParameter("teacher", request.getParameter("teacher"))
                            .setParameter("time", 8)
                            .getSingleResult();
                } catch (NoResultException e) {
                    c8 = true;//Nothing contain
                }
                if(!request.getParameter("student_8").equals("")) {//DBあり登録あり
                    s8.setUser(em.createNamedQuery("getUser", User.class)
                            .setParameter("name", request.getParameter("student_8"))
                            .getSingleResult());
                    s8.setStudent(request.getParameter("student_8"));
                    s8.setBook(request.getParameter("book_8"));
                    s8.setAbsent(0);
                    if(c8) {//DBなし登録あり
                        em.merge(s8);
                        em.flush();
                        em.clear();
                    }
                } else {//DBなし登録なし
                    if(!c8) {//DBあり登録なし
                        em.remove(s8);
                    }
                }

                em.getTransaction().commit();
                em.close();


                request.getSession().setAttribute("flush", "You have been updated.");
                response.sendRedirect(request.getContextPath() + "/schedule/index");
            }

        }
	}

}

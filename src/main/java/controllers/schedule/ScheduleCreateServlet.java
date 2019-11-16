package controllers.schedule;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import models.User;
import models.validators.ShcheduleValidator;
import models.validators.StudentValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleCreateServlet
 */
public class ScheduleCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleCreateServlet() {
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

            EntityManager em = DBUtil.createEntityManager();

            List<User> users = em.createNamedQuery("getAllUsers", User.class)
                    .getResultList();

            Schedule s = new Schedule();
            //main = student
            if(request.getParameter("main").equals("student")) {
                s.setUser(em.createNamedQuery("getUser", User.class)
                        .setParameter("name", request.getParameter("main_user"))
                        .getSingleResult());
                s.setStudent(request.getParameter("main_user"));
            } else {// main = teacher
                s.setTeacher(request.getParameter("main_user"));
            }

            s.setDate(Date.valueOf(request.getParameter("date")));

            request.setAttribute("date", s.getDate());
            request.setAttribute("teacher", s.getTeacher());//needs to change

            Boolean check_update = false;
            String[] students = {request.getParameter("user_1"), request.getParameter("user_2"),
                    request.getParameter("user_3"), request.getParameter("user_4"), request.getParameter("user_5"),
                    request.getParameter("user_6"), request.getParameter("user_7"), request.getParameter("user_8")};

            String[] allbooks = {request.getParameter("book_1"), request.getParameter("book_2"),
                    request.getParameter("book_3"), request.getParameter("book_4"), request.getParameter("book_5"),
                    request.getParameter("book_6"), request.getParameter("book_7"), request.getParameter("book_7")};
            List<String> errors = ShcheduleValidator.validate(s, check_update);
            errors.addAll(StudentValidator.validate(s, students, 1, request.getParameter("user_1"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 2, request.getParameter("user_2"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 3, request.getParameter("user_3"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 4, request.getParameter("user_4"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 5, request.getParameter("user_5"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 6, request.getParameter("user_6"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 7, request.getParameter("user_7"), check_update));
            errors.addAll(StudentValidator.validate(s, students, 8, request.getParameter("user_8"), check_update));
            errors.addAll(StudentValidator.validate_max(s, students, allbooks, check_update));
            List<String> errors_a = errors.stream().distinct().collect(Collectors.toList());//Listの重複を消す

            if(errors_a.size() > 0) {
                em.close();
                request.setAttribute("errors", errors_a);
                //error出た用
                request.setAttribute("user_1", request.getParameter("user_1"));
                request.setAttribute("user_2", request.getParameter("user_2"));
                request.setAttribute("user_3", request.getParameter("user_3"));
                request.setAttribute("user_4", request.getParameter("user_4"));
                request.setAttribute("user_5", request.getParameter("user_5"));
                request.setAttribute("user_6", request.getParameter("user_6"));
                request.setAttribute("user_7", request.getParameter("user_7"));
                request.setAttribute("user_8", request.getParameter("user_8"));
                request.setAttribute("main", request.getParameter("main"));
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("schedule", s);
                request.setAttribute("users", users);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/new.jsp");
                rd.forward(request, response);
            } else {

                em.getTransaction().begin();

                if(!request.getParameter("user_1").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_1"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_1"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_1"));
                    }
                    s.setTime(1);
                    s.setBook(request.getParameter("book_1"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_2").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_2"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_2"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_2"));
                    }

                    s.setTime(2);
                    s.setBook(request.getParameter("book_2"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_3").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_3"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_3"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_3"));
                    }

                    s.setTime(3);
                    s.setBook(request.getParameter("book_3"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_4").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_4"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_4"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_4"));
                    }

                    s.setTime(4);
                    s.setBook(request.getParameter("book_4"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_5").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_5"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_5"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_5"));
                    }

                    s.setTime(5);
                    s.setBook(request.getParameter("book_5"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_6").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_6"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_6"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_6"));
                    }

                    s.setTime(6);
                    s.setBook(request.getParameter("book_6"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_7").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_7"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_7"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_7"));
                    }

                    s.setTime(7);
                    s.setBook(request.getParameter("book_7"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                if(!request.getParameter("user_8").equals("")) {
                    if(request.getParameter("main").equals("student")) {
                        s.setTeacher(request.getParameter("user_8"));
                    } else { //main_user = teacher
                        s.setUser(em.createNamedQuery("getUser", User.class)
                                .setParameter("name", request.getParameter("user_8"))
                                .getSingleResult());
                        s.setStudent(request.getParameter("user_8"));
                    }

                    s.setTime(8);
                    s.setBook(request.getParameter("book_8"));
                    s.setAbsent(0);

                    em.merge(s);
                    em.flush();
                    em.clear();
                }
                    em.getTransaction().commit();
                    em.close();

                    request.getSession().setAttribute("flush", "You have been registered.");
                    response.sendRedirect(request.getContextPath() + "/schedule/index");

            }

        }
	}

}

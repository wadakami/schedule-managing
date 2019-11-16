package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import models.Schedule;
import models.User;
import utils.DBUtil;


public class StudentValidator {

    public static List<String> validate(Schedule s, String[] students, Integer time, String student, Boolean check_update) {
        List<String> errors = new ArrayList<String>();

        String student_error = _ValidateStudent(s.getDate(), time, student, check_update);
        if(!student_error.equals("")) {
            errors.add(student_error);
        }

        String student_class = _ValidateClass(s.getDate(), students, student);
        if(!student_class.equals("")){
            errors.add(student_class);
        }

        return errors;
    }

    private static String _ValidateStudent(Date date, Integer time, String student, Boolean check_update) {
        EntityManager em = DBUtil.createEntityManager();

        //日付で検索
        long student_exist = (long)em.createNamedQuery("getOverWrap", Long.class)
                             .setParameter("date", date)
                             .setParameter("student", student)
                             .setParameter("time", time)
                             .getSingleResult();

        //valiUpdate

        em.close();

        if(check_update = true) {//if it's update.

            if(student_exist > 1) {
                return student + " already have a class the time.";
            }

        } else {

            if(student_exist > 0) {
                return student + " already have a class the time.";
            }

        }


        return "";
    }

    private static String _ValidateClass(Date date, String[] students, String student) {

        if(!student.equals("")) {

        EntityManager em = DBUtil.createEntityManager();

        //日付と生徒名で授業数を出力
        long student_classes= (long)em.createNamedQuery("getStudentCount", Long.class)
                             .setParameter("date", date)
                             .setParameter("student", student)
                             .getSingleResult();

        //生徒情報ゲット
        User student_data = em.createNamedQuery("getUser", User.class)
                             .setParameter("name", student)
                             .getSingleResult();

        em.close();

        int student_maximum = student_data.getMax();
        int count = 0;
            for(int i = 0; i < students.length; i++) {
                if(students[i].equals(student)) {
                    count = count + 1;
                }
            }

        if(student_classes + count > student_maximum) {
            return student + " exceed maximum class. " + student + " can have " + student_maximum + " class.";
        }

        }

        return "";
    }



//check max classes
    public static List<String> validate_max(Schedule s, String[] students, String[] allbooks, Boolean check_update) {

        List<String> errors = new ArrayList<String>();

        String maximum_error = _ValidateMaximum(s.getTeacher(), students);
        if(!maximum_error.equals("")) {
            errors.add(maximum_error);
        }

        String book_error = _ValidateAllBook(s.getTeacher(), allbooks);
        if(!book_error.equals("")) {
            errors.add(book_error);
        }

        return errors;
    }

    private static String _ValidateAllBook(String teacher, String[] allbooks) {

        List<String> error_book = new ArrayList<String>();

        EntityManager em = DBUtil.createEntityManager();

        User u = em.createNamedQuery("getUser", User.class)
                    .setParameter("name", teacher)
                    .getSingleResult();
        em.close();

        String[] teacher_books = u.getBook().split(",");

        for(int i = 0; i < allbooks.length; i++) {
            if(!Arrays.asList(teacher_books).contains(allbooks[i]) && !allbooks[i].equals("")) {
                error_book.add(allbooks[i]);
            }
        }

        String books = String.join(", ", error_book);

        if(error_book.size() > 0) {
            return teacher + " can't use " + books +".";
        }

    return "";
}

    private static String _ValidateMaximum(String teacher, String[] time) {

        List<String> count_class = new ArrayList<String>();
        if(!time[0].equals("")){
            count_class.add(time[0]);
        }
        if(!time[1].equals("")){
            count_class.add(time[1]);
        }
        if(!time[2].equals("")){
            count_class.add(time[2]);
        }
        if(!time[3].equals("")){
            count_class.add(time[3]);
        }
        if(!time[4].equals("")){
            count_class.add(time[4]);
        }
        if(!time[5].equals("")){
            count_class.add(time[5]);
        }
        if(!time[6].equals("")){
            count_class.add(time[6]);
        }
        if(!time[7].equals("")){
            count_class.add(time[7]);
        }


        EntityManager em = DBUtil.createEntityManager();

        //教師情報ゲット
        User teacher_data = em.createNamedQuery("getUser", User.class)
                             .setParameter("name", teacher)
                             .getSingleResult();

        em.close();

        int max_classes = teacher_data.getMax();


        if(count_class.size() > max_classes) {
            return "Exceeded maximum teacher's classes.";
        }

        return "";
    }

}

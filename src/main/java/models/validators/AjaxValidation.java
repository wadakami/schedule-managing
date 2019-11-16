package models.validators;

import java.util.Date;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class AjaxValidation {

    public static String[] valifySchedule(User user, int classTime, Date today,String main_user ,String main) {

        String[] errors = {"", "", "", ""};

        if(main.equals("teacher")) {

            //メインが教師で生徒の授業に被りがないかどうか
            String error = student(user.getName(), classTime, today);
            if(!error.equals("")){
                errors[0] = error;
            }

        } else if(main.equals("student")) {

            //メインが生徒で教師の授業に被りがないかどうか
            String error = teacher(user.getName(), classTime, today);
            if(!error.equals("")){
                errors[0] = error;
            }

        }

        return errors;
    }


    private static String student(String student, int time, Date date) {

        EntityManager em = DBUtil.createEntityManager();

        long student_exist = (long)em.createNamedQuery("getOverWrap", Long.class)//getOverWrapT
                .setParameter("date", date)
                .setParameter("student", student)
                .setParameter("time", time)
                .getSingleResult();
         em.close();

         if(student_exist > 0){
             return student + " is alrady have a class this time.";
         } else {
             return "";
         }
    }

    private static String teacher(String teacher, int time, Date date) {
        EntityManager em = DBUtil.createEntityManager();

        long teacher_exist = (long)em.createNamedQuery("getOverWrapT", Long.class)//getOverWrapT
                .setParameter("date", date)
                .setParameter("teacher", teacher)
                .setParameter("time", time)
                .getSingleResult();
         em.close();

         if(teacher_exist > 0){
             return teacher + " is alrady have a class this time.";
         } else {
             return "";
         }

    }


}

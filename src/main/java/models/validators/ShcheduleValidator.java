package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Schedule;
import utils.DBUtil;


public class ShcheduleValidator {
    public static List<String> validate(Schedule s, Boolean check_update) {
        List<String> errors = new ArrayList<String>();

        String teacher_error = _ValidateTeacher(s.getTeacher(), s.getDate(), check_update);
        if(!teacher_error.equals("")) {
            errors.add(teacher_error);
        }

        return errors;
    }

    private static String _ValidateTeacher(String teacher, Date date, Boolean check_update) {

        if(!check_update) {
            EntityManager em = DBUtil.createEntityManager();

            //日付で検索
            long teacher_exist = (long)em.createNamedQuery("getThenTeacher", Long.class)
                                 .setParameter("date", date)
                                 .setParameter("teacher", teacher)
                                 .getSingleResult();

            em.close();

            if(teacher_exist > 0) {
                return "The teacher already registered.";
            }
        }

        return "";


    }

}

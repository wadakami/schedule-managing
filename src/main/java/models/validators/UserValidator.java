package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
    public static List<String> validate(User u, Boolean password_check_flag) {

        List<String> errors = new ArrayList<String>();

        String name_error = _ValidateName(u.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _ValidatePassword(u.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        String color_error = _ValidateColor(u.getColor(), u.getAdmin_flag(), u.getName());
        if(!color_error.equals("")) {
            errors.add(color_error);
        }


        return errors;

    }

    private static String _ValidateName(String name) {
        if(name == null || name.equals("")) {
            return "You must enter Name column.";
        }
        return "";
    }

    private static String _ValidatePassword(String password, Boolean password_check_flag) {
        if(password_check_flag && (password == null || password.equals(""))) {
            return "You must enter Password column.";
        }
        return "";
    }

    private static String _ValidateColor(String color, Integer admin, String name) {

        EntityManager em = DBUtil.createEntityManager();


        String mycolor = em.createNamedQuery("checkMyColor", String.class)
                .setParameter("color", color)
                .setParameter("admin", admin)
                .getSingleResult();

        long color_check = (long)em.createNamedQuery("checkUserColor", Long.class)
                .setParameter("color", color)
                .setParameter("admin", admin)
                .getSingleResult();

        em.close();

        if(!name.equals(mycolor)) {

            if(color_check > 0) {
                return "Its color already used.";
            }

        }

        return "";
    }

}

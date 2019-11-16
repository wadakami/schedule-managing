package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Schedule;


public class DuplicateValidator {
    public static List<String> validate(int diffDays, List<Schedule> schedules, List<String> teachers) {
        List<String> errors = new ArrayList<String>();

        String order_error = _ValidateOrder(diffDays);
        if(!order_error.equals("")) {
            errors.add(order_error);
        }

        String nothing_error = _ValidateExist(schedules);
        if(!nothing_error.equals("")) {
            errors.add(nothing_error);
        }

        String overwrap_error = _ValidateOverWrap(teachers);
        if(!overwrap_error.equals("")) {
            errors.add(overwrap_error);
        }

        return errors;
    }


    private static String _ValidateOverWrap(List<String> teachers) {



        for(int i = 0; i < teachers.size(); i++) {
            teachers.get(i);
        }
        return "";
    }


    private static String _ValidateOrder(int diffDays) {
        if(diffDays < 0) {
            return "Day of order is incorrect.";
        }
        return "";
    }

    private static String _ValidateExist(List<Schedule> schedules) {
        if(schedules.size() == 0) {
            return "Couldn't find original schedule.";
        }
        return "";
    }

}

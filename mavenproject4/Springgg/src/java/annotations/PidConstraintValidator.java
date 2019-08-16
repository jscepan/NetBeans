package annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PidConstraintValidator implements ConstraintValidator<Pid, String> {

    @Override
    public void initialize(Pid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String pidValue, ConstraintValidatorContext context) {

        //pid must be exactly 12 digits
        if (!(pidValue.length() == 12)) {
            return false;
        }

        //split string to array of chars
        char[] letters = pidValue.toCharArray();

        //check each char is digit
        for (int i = 0; i < letters.length; i++) {
            if (!(Character.isDigit(letters[i]))) {
                return false;
            }
        }

        //get day
        String day_s = String.valueOf(letters[0]) + String.valueOf(letters[1]);

        int day_i = Integer.valueOf(day_s);

        //get month
        String month_s = String.valueOf(letters[2]) + String.valueOf(letters[3]);

        int month_i = Integer.valueOf(month_s);

        //get year
        String year_s = String.valueOf(letters[4]) + String.valueOf(letters[5]) + String.valueOf(letters[6]);

        int year_i = Integer.valueOf(year_s);

        //day can not be greater than 31 or less than 1
        if (day_i > 31 || day_i < 1) {
            return false;
        }

        //month can be greater than 12 or less than 1
        if (month_i > 12 || month_i < 1) {
            return false;
        }

        //year can not be greater than 16 (2016 - current year)
        //max life expectancy 166 year
        if (year_i < 850 && year_i > 16) {
            return false;
        }
        return true;
    }

}

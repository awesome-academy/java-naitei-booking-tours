package app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.dao.UserDao;
import app.entity.User;

public class LoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "fullname.empty", "Fullname is mandatory.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password is mandatory.");

        User user = (User) target;
        
    }

}

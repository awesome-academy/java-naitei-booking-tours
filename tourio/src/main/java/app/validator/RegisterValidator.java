package app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.dao.UserDao;
import app.entity.User;

@Component
public class RegisterValidator implements Validator {

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

        if (user.getFullname().length() < 5) {
            errors.rejectValue("fullname", "fullname.tooShort", "Fullname must be at least 5 characters.");
        }
        validateEmail(user.getEmail(), errors);
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "password.tooShort", "Password must be at least 8 characters.");
        }
    }

    private void validateEmail(String email, Errors errors) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!email.matches(emailRegex)) {
            errors.rejectValue("email", "email.invalid", "Please provide a valid email address.");
        } else {
            if (userDao.get(email) != null) {
                errors.rejectValue("email", "email.duplicate", "Email address already exists.");
            }
        }
    }
}

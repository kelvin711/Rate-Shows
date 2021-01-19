package com.kelvinarauz.exam.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kelvinarauz.exam.models.User;
import com.kelvinarauz.exam.services.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService uServ;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        User user = (User) target;
        //check to see if passwords are matching
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        //check to see if emails are unique
        if(uServ.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("duplicate", "Dupe");
        }
    }
	
}
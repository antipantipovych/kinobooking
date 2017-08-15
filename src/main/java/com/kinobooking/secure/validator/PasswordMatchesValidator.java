package com.kinobooking.secure.validator;

import com.kinobooking.secure.entity.Client;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Екатерина on 16.08.2017.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
       Client client = (Client) obj;
        return client.getPassword().equals(client.getConfirmPass());
    }
}

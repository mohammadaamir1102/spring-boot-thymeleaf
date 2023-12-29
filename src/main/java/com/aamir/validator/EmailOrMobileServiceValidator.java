package com.aamir.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailOrMobileServiceValidator implements ConstraintValidator<ValidEmailOrPhone, String> {

    private static final String EMAIL_ID_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private static final String MOBILE_NO_REGEX = "^[6-9]\\d{9}$";


    @Override
    public void initialize(ValidEmailOrPhone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValidEmailId(value) || isValidMobileNo(value);
    }

    private boolean isValidEmailId(String value) {
        return value.matches(EMAIL_ID_REGEX);
    }

    private boolean isValidMobileNo(String value) {
        return value.matches(MOBILE_NO_REGEX);
    }

}

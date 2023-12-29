package com.aamir.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailOrMobileServiceValidator.class)
@Documented
public @interface ValidEmailOrPhone {

    String message() default "Invalid Email or Phone no.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

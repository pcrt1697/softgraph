package com.pcrt.softgraph.validation;

import com.pcrt.softgraph.validation.validator.NotEmptyCollectionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyCollectionValidator.class)
@Documented
public @interface NotEmptyCollection {
    String message() default "Collection cannot be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

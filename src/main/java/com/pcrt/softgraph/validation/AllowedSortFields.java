package com.pcrt.softgraph.validation;

import com.pcrt.softgraph.validation.validator.SortFieldsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SortFieldsValidator.class)
@Documented
public @interface AllowedSortFields {

    String[] value() default {"id"};
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

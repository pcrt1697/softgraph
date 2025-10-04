package com.pcrt.softgraph.validation;

import com.pcrt.softgraph.validation.validator.CronExpressionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CronExpressionValidator.class)
@Documented
public @interface ValidCronExpression {

    boolean nullable() default true;
    String message() default "Cron expression is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

package com.pcrt.softgraph.validation.validator;

import com.pcrt.softgraph.validation.ValidCronExpression;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.scheduling.support.CronExpression;

public class CronExpressionValidator implements ConstraintValidator<ValidCronExpression, String> {

    private boolean nullable;

    @Override
    public void initialize(ValidCronExpression constraintAnnotation) {
        this.nullable = constraintAnnotation.nullable();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return this.nullable;
        }
        return CronExpression.isValidExpression(value);
    }

}

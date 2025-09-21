package com.pcrt.softgraph.validation.validator;

import com.pcrt.softgraph.validation.NotEmptyCollection;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class NotEmptyCollectionValidator implements ConstraintValidator<NotEmptyCollection, Collection<?>> {

    private String message;

    @Override
    public void initialize(NotEmptyCollection constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Collection<?> object, ConstraintValidatorContext context) {
        if (object == null || !object.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(this.message);
        return false;
    }

}

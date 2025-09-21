package com.pcrt.softgraph.validation.validator;

import com.pcrt.softgraph.exception.InvalidInputException;
import com.pcrt.softgraph.validation.ExactlyOneRequired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class ExactlyOneRequiredValidator implements ConstraintValidator<ExactlyOneRequired, Object> {

    private static final String DEFAULT_MESSAGE_TEMPLATE = "Expected exactly one non-null field, found: %s";
    private String[] fieldNames;
    private String message;

    @Override
    public void initialize(ExactlyOneRequired constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fields();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true;
        }
        Object fieldValue;
        Set<String> nonNullFields = new HashSet<>();
        for (String fieldName : this.fieldNames) {
            fieldValue = this.getFieldValue(object, fieldName);
            if (fieldValue != null) {
                nonNullFields.add(fieldName);
            }
        }
        if (nonNullFields.size() == 1) {
            return true;
        }
        if (StringUtils.isEmpty(this.message)) {
            context.buildConstraintViolationWithTemplate(String.format(DEFAULT_MESSAGE_TEMPLATE, nonNullFields));
        } else {
            context.buildConstraintViolationWithTemplate(this.message);
        }
        return false;
    }

    private Object getFieldValue(Object object, String fieldName) {
        try {
            return PropertyUtils.getProperty(object, fieldName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new InvalidInputException(
                    e,
                    "Failed to get value from field `%s` of class %s",
                    fieldName, object.getClass()
            );
        }
    }
}

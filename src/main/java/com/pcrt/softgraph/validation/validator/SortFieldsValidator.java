package com.pcrt.softgraph.validation.validator;


import com.pcrt.softgraph.validation.AllowedSortFields;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashSet;
import java.util.Set;

public class SortFieldsValidator implements ConstraintValidator<AllowedSortFields, Pageable> {

    private static final String DEFAULT_MESSAGE_TEMPLATE = "Sort fields `%s` are not allowed. Available fields are: %s";
    private Set<String> fieldNames;
    private String message;

    @Override
    public void initialize(AllowedSortFields constraintAnnotation) {
        this.fieldNames = Set.of(constraintAnnotation.value());
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        if (pageable.getSort().isEmpty()) {
            context.buildConstraintViolationWithTemplate("At least one sort order is required");
            return false;
        }
        Set<String> invalidFields = new HashSet<>();
        for (Sort.Order order : pageable.getSort()) {
            if (!this.fieldNames.contains(order.getProperty())) {
                invalidFields.add(order.getProperty());
            }
        }
        if (invalidFields.isEmpty()) {
            return true;
        }
        if (StringUtils.isEmpty(this.message)) {
            context.buildConstraintViolationWithTemplate(String.format(DEFAULT_MESSAGE_TEMPLATE, invalidFields, this.fieldNames));
        } else {
            context.buildConstraintViolationWithTemplate(this.message);
        }
        return false;
    }

}

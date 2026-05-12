package com.lughtech.validator.validators;

import com.lughtech.validator.annotations.Email;
import com.lughtech.validator.annotations.MinLength;
import com.lughtech.validator.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectValidator {

    public ValidationResult validate(Object object) {
        var fields = object.getClass().getDeclaredFields();
        List<ValidationError> validationErrors = new ArrayList<>();
        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);
            var value = getFieldValue(field, object, validationErrors);
            if (field.isAnnotationPresent(NotNull.class)) {
                if (value == null) {
                    validationErrors.add(new ValidationError(field.getName(), field.getName() + " cannot be null"));
                    return;
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                if (value instanceof String stringValue) {
                    var annotationValue = field.getAnnotation(MinLength.class).value();
                    if (stringValue.length() < annotationValue) {
                        validationErrors.add(new ValidationError(field.getName(), field.getName() + " length must be greater than " + annotationValue));
                    }
                }
            }
            if (field.isAnnotationPresent(Email.class)) {
                if (value instanceof String stringValue && !stringValue.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    validationErrors.add(new ValidationError(field.getName(), field.getName() + " must be a valid email"));
                }
            }
        });
        return new ValidationResult(validationErrors.isEmpty(), validationErrors);
    }


    private Object getFieldValue(Field field, Object object, List<ValidationError> validationErrors) {
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get value from field " + field.getName());
        }
    }
}

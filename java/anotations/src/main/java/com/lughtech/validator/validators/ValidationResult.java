package com.lughtech.validator.validators;

import java.util.List;

public record ValidationResult(boolean isValid, List<ValidationError> errors) {
}

package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {

    @Override
    public void initialize(ValidMinMax constraintAnnotation) {
        // No initialization required
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part == null) {
            return true; // Validation passes if the part is null
        }

        // Perform validation logic
        return part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv();
    }
}


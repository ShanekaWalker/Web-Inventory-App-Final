package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;
    @Override
    public void initialize(ValidMinMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (context==null)return true;
        if(context!=null)myContext=context;

        return (part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv());
    }
}

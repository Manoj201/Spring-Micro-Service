package com.cal.sca.validation.validatorImpl;

import com.cal.sca.repository.ProductRepository;
import com.cal.sca.validation.validator.ProductMustExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductMustExistsValidator implements ConstraintValidator<ProductMustExists, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        return productRepository.findById(value).block() != null ;
    }
}

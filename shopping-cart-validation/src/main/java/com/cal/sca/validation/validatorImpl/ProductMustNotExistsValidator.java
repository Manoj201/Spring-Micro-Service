package com.cal.sca.validation.validatorImpl;

import com.cal.sca.repository.ProductRepository;
import com.cal.sca.validation.validator.ProductMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductMustNotExistsValidator implements ConstraintValidator<ProductMustNotExists, String>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductMustNotExists productMustNotExists) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        boolean data = productRepository.existsById(value).block() == Boolean.FALSE;
        return data;
    }
}

package com.cal.sca.validation.validators;

import com.cal.sca.repository.CartRepository;
import com.cal.sca.validation.CartMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CartMustNotExistsValidator implements ConstraintValidator<CartMustNotExists, String> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(CartMustNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        return cartRepository.existsById(value).block() == Boolean.FALSE;
    }
}

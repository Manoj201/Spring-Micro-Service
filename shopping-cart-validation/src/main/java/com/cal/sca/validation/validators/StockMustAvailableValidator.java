package com.cal.sca.validation.validators;

import com.cal.sca.entity.CartItem;
import com.cal.sca.repository.CartRepository;
import com.cal.sca.repository.ProductRepository;
import com.cal.sca.validation.StockMustAvailable;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.atomic.AtomicInteger;

public class StockMustAvailableValidator implements ConstraintValidator<StockMustAvailable, Object> {

    private String productIdFieldName;
    private String quantityFieldName;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(StockMustAvailable constraintAnnotation) {
        this.productIdFieldName = constraintAnnotation.productId();
        this.quantityFieldName = constraintAnnotation.quantity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            String productId = (String) PropertyUtils.getProperty(value, this.productIdFieldName);
            Integer quantity = (Integer) PropertyUtils.getProperty(value, this.quantityFieldName);

            AtomicInteger productCountInCarts = new AtomicInteger();

            cartRepository.findAll().toStream()
                    .forEach(cart -> cart.getItems()
                            .stream()
                            .filter(cartItem -> cartItem.getId().equals(productId))
                            .forEach(cartItem -> productCountInCarts.addAndGet(cartItem.getQuantity()))
            );

            int stock = productRepository.findById(productId).block().getStock();


            return  stock > (productCountInCarts.get() + quantity);


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}

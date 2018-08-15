package com.cal.sca.validation;

import com.cal.sca.validation.validators.StockMustAvailableValidator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StockMustAvailableValidator.class})
@Document
public @interface StockMustAvailable {

    String message() default "Stock Must Available";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

    String productId();

    String quantity();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Document
    @interface List {
        StockMustAvailable[] value();
    }
}

package com.cal.sca.validation;

import com.cal.sca.validation.validators.CartMustNotExistsValidator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CartMustNotExistsValidator.class})
@Document
public @interface CartMustNotExists {
    String message() default "Cart Must Not Exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}

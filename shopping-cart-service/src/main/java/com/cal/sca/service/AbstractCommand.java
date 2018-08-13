package com.cal.sca.service;

import com.cal.sca.service.exception.CommandValidationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public abstract class AbstractCommand<RESULT, REQUEST> implements Command<RESULT, REQUEST>,
        ApplicationContextAware, InitializingBean {

    protected Validator validator;

    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        this.validator = applicationContext.getBean(Validator.class);
    }

    public abstract Mono<RESULT> doExecute(REQUEST request);

    public abstract Mono<List<RESULT>> doExecuteList(REQUEST request);

    @Override
    public final Mono<RESULT> execute(REQUEST request) {
        Set<ConstraintViolation<REQUEST>> constraintViolations = validator.validate(request);
        if (constraintViolations.isEmpty()) {
            return doExecute(request);
        } else {
            return Mono.error(new CommandValidationException(constraintViolations));
        }
    }

    @Override
    public Mono<List<RESULT>> executeList(REQUEST request) {
//        Set<ConstraintViolation<REQUEST>> constraintViolations = validators.validate(controller);
//        if (constraintViolations.isEmpty()) {
            return doExecuteList(request);
//        } else {
//            return Flux.error(new CommandValidationException(constraintViolations));
//        }
    }
}

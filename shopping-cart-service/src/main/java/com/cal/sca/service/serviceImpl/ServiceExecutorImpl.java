package com.cal.sca.service.serviceImpl;

import com.cal.sca.service.Command;
import com.cal.sca.service.ServiceExecutor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ServiceExecutorImpl implements ServiceExecutor, ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public <T, R> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request) {
        Command<T, R> command = applicationContext.getBean(commandClass);
        return command.execute(request);
    }

    @Override
    public <T, R> Mono<List<T>> executeList(Class<? extends Command<T, R>> commandClass, R request) {
        Command<T, R> command = applicationContext.getBean(commandClass);
        Mono<List<T>> data = command.executeList(request);
        return data;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

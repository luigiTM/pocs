package com.lughtech.springcore.config.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        System.out.println("Creating Custom Bean Post Processor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Running Post processor before initialization for bean: " + bean.getClass() + "  " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Running Post processor after initialization for bean: " + bean.getClass() + "  " + beanName);
        return bean;
    }
}

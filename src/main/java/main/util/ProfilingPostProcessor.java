package main.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ProfilingPostProcessor implements BeanPostProcessor {

    private static final Logger logger = Logger.getLogger(ProfilingPostProcessor.class);

    private Set<String> beanNames = new HashSet<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Annotation annotation = beanClass.getAnnotation(Profiling.class);
        if (annotation != null) {
            beanNames.add(beanName);
            logger.debug("Bean registered for profiling " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (true) {
            return bean;
        }

        if (beanNames.contains(beanName)) {
            Class<?> beanClass = bean.getClass();
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getAnnotation(Profiling.class) != null) {
                        logger.debug("profiling...");
                        long startTime = System.nanoTime();
                        Object result = method.invoke(proxy, args);
                        long endTime = System.nanoTime();
                        logger.debug("profiling time: " + (endTime - startTime));
                        return result;
                    } else {
                        return method.invoke(proxy, args);
                    }
                }
            });
        } else {
            return bean;
        }
    }
}

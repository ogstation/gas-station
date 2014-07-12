package com.github.ogstation.gas.station.helper;

import com.github.ogstation.gas.station.controller.RestExceptionHandlerAdvice;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

public class ExceptionHandlerHelper
{
    public static ExceptionHandlerExceptionResolver exceptionResolver(final MessageSource messageSource)
    {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver()
        {
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception)
            {
                Method method = new ExceptionHandlerMethodResolver(RestExceptionHandlerAdvice.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new RestExceptionHandlerAdvice(messageSource), method);
            }
        };
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }
}

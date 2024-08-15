package com.jc.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{  

    private static final Logger Logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    


    @Override
    public void postHandle( HttpServletRequest request,  HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        Logger.info("LoadingTimerInterceptor: postHandler() saliendo .... " + ((HandlerMethod) handler).getMethod().getName());
    }

    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        HandlerMethod controller =((HandlerMethod) handler);
        Logger.info("LoadingTimerInterceptor: preHandler() entrando .... "  + controller.getMethod().getName());
        return true;
    }

    

}

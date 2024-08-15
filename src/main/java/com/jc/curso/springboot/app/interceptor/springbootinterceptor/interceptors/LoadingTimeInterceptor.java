package com.jc.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

import java.util.Random;

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

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        HandlerMethod controller =((HandlerMethod) handler);
        logger.info("LoadingTimerInterceptor: preHandler() entrando .... "  + controller.getMethod().getName());
        
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        Random random = new Random();
        int delay = random.nextInt(500);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle( HttpServletRequest request,  HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
         long end = System.currentTimeMillis();
         long start = (long) request.getAttribute("start");
         long result = end - start;
         logger.info("Tiempo transcurrido: " + result + " milisegundos!");
         logger.info("LoadingTimerInterceptor: postHandler() saliendo .... " + ((HandlerMethod) handler).getMethod().getName());
    }

}

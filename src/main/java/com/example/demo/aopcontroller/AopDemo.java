package com.example.demo.aopcontroller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.context.annotation.Configuration;

/**
 * Created by beyondLi on 2017/7/31.
 */
//证明是一个配置文件(使用@Component也可以,因为点入后会发现@Configuration还是使用了@Component)
@Configuration
//证明是一个切面
@Aspect
public class AopDemo {
    //环绕aop
    //execution表达式 此表达式表示扫描controller下所有类的所有方法都执行此aop
    @After("execution (* com.example.demo.controller.helloworld(..))")
    public Object testAop(ProceedingJoinPoint pro) throws Throwable {
        //获取request请求提(需要时备用)
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //进入方法前执行的代码
        System.out.println("进入方法前执行的代码beginAround");
        //执行调用的方法
        Object proceed = pro.proceed();
        //方法执行完成后执行的方法
        System.out.println("方法执行完成后执行的方法endAround");
        return proceed;
    }
    
    @Before("execution (* com.example.demo.controller.helloworld(..))")
    public Object testAop2(ProceedingJoinPoint pro) throws Throwable {
        //获取request请求提(需要时备用)
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //进入方法前执行的代码
        System.out.println("进入方法前执行的代码beginAround2");
        //执行调用的方法
        Object proceed = pro.proceed();
        //方法执行完成后执行的方法
        System.out.println("方法执行完成后执行的方法endAround2");
        return proceed;
    }

} 
package com.example.demo.aopcontroller;
 
import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect // 表示该类是一个通知类
@Component // 交给spring管理
public class MyAdvice {

    // 定义一个空方法，借用其注解抽取切点表达式
    @Pointcut("execution(* com.example.demo.*ServiceImpl.*(..))")
    public void pc() {
    }

    // 前置通知
    @Before("MyAdvice.pc()")
    public void before(JoinPoint joinPoint) throws Exception {
        System.out.println("---------------前置通知开始(注解)~~~~~~~~~~~");
        // 获取到类名
        String targetName = joinPoint.getTarget().getClass().getName();
        System.out.println("代理的类是:" + targetName);
        // 获取到方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("增强的方法是:" + methodName);
        // 获取到参数
        Object[] parameter = joinPoint.getArgs();
        System.out.println("传入的参数是:" + Arrays.toString(parameter));
        // 获取字节码对象
        Class<?> targetClass = Class.forName(targetName);
        // 获取所有的方法
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == parameter.length) {
                    System.out.println("找到这个方法");
                    break;
                }
            }
        }
        System.out.println("---------------前置通知结束(注解)~~~~~~~~~~~");
    }

    // 后置通知(异常发生后不会调用)
    @AfterReturning("MyAdvice.pc()")
    public void afterRunning() {
        System.out.println("这是后置通知(异常发生后不会调用)。。。。(注解)");
    }

    // 环绕通知
    @Around("MyAdvice.pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----------------环绕通知之前 的部分(注解)----------------");
        // 获取到类名
        String targetName = pjp.getTarget().getClass().getName();
        System.out.println("代理的类是:" + targetName);
        // 获取到参数
        Object[] parameter = pjp.getArgs();
        System.out.println("传入的参数是:" + Arrays.toString(parameter));
        // 获取到方法签名，进而获得方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        System.out.println("增强的方法名字是:" + method.getName());
        // 获取参数类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        System.out.println("参数类型是:" + parameterTypes.toString());
        
        //让方法执行(proceed是拦截的方法的执行返回值，可以针对返回值做一些处理)
        System.out.println("--------------方法开始执行-----------------");
        Object proceed = pjp.proceed();
        
        //环绕通知之后的业务逻辑部分
        System.out.println("----------------环绕通知之后的部分(注解)----------------");
        return proceed;
    }

    // 异常通知
    @AfterThrowing("MyAdvice.pc()")
    public void afterException() {
        System.out.println("这是异常通知(发生异常后调用)~~~~~~~~~~~(注解)");
    }

    // 最终通知(发生异常也会在最终调用)
    @After("MyAdvice.pc()")
    public void after() {
        System.out.println("这是最终通知(发生异常也会在最终调用)........(注解)");
    }
}
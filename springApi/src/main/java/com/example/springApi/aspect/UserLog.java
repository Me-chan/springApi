package com.example.springApi.aspect;

import java.util.Date;

import org.apache.logging.log4j.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserLog {
    private static Logger LOGGER = LogManager.getLogger(UserLog.class);
    /**
     * Permits to call function when the anotation UserLogExecutionTime is used
     */
    @Pointcut("@annotation(com.example.springApi.aspect.UserLogExecutionTime)")  
    public void UserLogExecutionTimePointcut(){  
    } 
    
    
    /** 
     * Display a message before each use of a methods
     * @param joinpoint
     * @throws Throwable
     */
    @Before("UserLogExecutionTimePointcut") 
    public void userBeforeAspect(final JoinPoint joinpoint) throws Throwable {
        final Object[] args = joinpoint.getArgs();
        final StringBuffer sb = new StringBuffer();
        sb.append(joinpoint.getSignature().toString());
        sb.append(" with the parameters: (");
        for (int i =0; i < args.length; i++){
            sb.append(args[i]);
            if (i< args.length -1){
                sb.append(", ");
            }
        }
        sb.append(")");
        LOGGER.info("Start of the methode : "+sb);
    }

    
    /** 
     * Display a message after each use of a methods
     * @param staticPart
     * @param result
     * @throws Throwable
     */
    @After("UserLogExecutionTimePointcut")
    public void userAfterAspect(final StaticPart staticPart, final Object result) throws Throwable {
        String methodeName = staticPart.getSignature().toLongString();
        LOGGER.info("End of the methode :  " + methodeName+ " return=" + result);
    }

    
    /** 
     * Display a message after throwing an exception
     * @param exception
     */
    @AfterThrowing(pointcut = "UserLogExecutionTimePointcut", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("Not Printed @AfterReturning:"+new Date());
        System.out.println("Exception caught:"+ exception.getMessage());
    }
}

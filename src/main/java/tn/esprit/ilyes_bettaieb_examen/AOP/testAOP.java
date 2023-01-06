package tn.esprit.ilyes_bettaieb_examen.AOP;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class testAOP {

    @AfterReturning("execution(* tn.esprit.ilyes_bettaieb_examen.services.Myservice.montantApayer (..))")
    public void logMethodEntry() {
        //String name = joinPoint.getSignature().getName();
        log.info("Montant facturé calculé");
    }

//    @Around("execution(* tn.esprit.ilyes_bettaieb_examen.services.Myservice.* (..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable
//    {
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return obj;
//    }
}

package com.pvt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceTransactionAspect {

    private PlatformTransactionManager transactionManager;

    public ServiceTransactionAspect() {
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void saveAround(ProceedingJoinPoint joinPoint) {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    joinPoint.proceed();
                    System.out.println("Save success");
                } catch (Throwable throwable) {
                    System.out.println(throwable.getMessage());
                    status.setRollbackOnly();
                    System.out.println("Transaction was rolled back");
                }
            }
        });

    }

    public void deleteAround(ProceedingJoinPoint joinPoint) throws Throwable {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    joinPoint.proceed();
                    System.out.println("Delete success");
                } catch (Throwable throwable) {
                    System.out.println(throwable.getMessage());
                    status.setRollbackOnly();
                    System.out.println("Transaction was rolled back");
                }
            }
        });
    }
}

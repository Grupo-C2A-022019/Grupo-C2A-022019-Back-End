package ar.edu.unq.dapp.c2a.aspects.authorization;

import ar.edu.unq.dapp.c2a.services.authorization.AuthorizationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class AuthorizationAspect {
    private AuthorizationService authService;

    @Autowired
    public AuthorizationAspect(AuthorizationService authService) {
        this.authService = authService;
    }

    @Pointcut("execution(* ar.edu.unq.dapp.c2a.webServices.controllers..*.*(..))")
    public static void controllerMethods() {}

    @Pointcut(value = "args(token, ..)", argNames = "token")
    public static void tokenMethods(String token) {}

    @Pointcut("@annotation(ar.edu.unq.dapp.c2a.aspects.authorization.Authorized)")
    public static void authorizedMethods() {
    }

    @Pointcut(value = "tokenMethods(token) && controllerMethods() && authorizedMethods()", argNames = "token")
    public static void authorizedControllerMethods(String token) {
    }

    @Before(value = "authorizedControllerMethods(token)", argNames = "jp,token")
    public void authorize(JoinPoint jp, String token) {
        String[] requiredPermissions = ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(Authorized.class).value();
        System.out.println("permissions annottation");
        for(String permission : requiredPermissions) {
            authService.isAuthorized(token, permission);
        }
    }
}
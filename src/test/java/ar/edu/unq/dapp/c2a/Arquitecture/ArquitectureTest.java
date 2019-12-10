package ar.edu.unq.dapp.c2a.Arquitecture;

import static org.junit.Assert.assertNotNull;
import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;

import com.google.common.base.Predicates;

public class ArquitectureTest {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testAllClasesInPackageHaveAnEmptyConstructor() throws NoSuchMethodException {
        Reflections reflections = new Reflections("ar.edu.unq.dapp.c2a.model");
        Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
        for (Class myClass : allClasses) {
            myClass.getConstructor();
        }
    }


}

package com.lughtech.reflection.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static com.lughtech.reflection.utils.Utils.getFieldNames;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonReflectionTest {

    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object person = new Kid();
        Class<?> clazz = person.getClass();

        assertEquals("Kid", clazz.getSimpleName());
        assertEquals("com.lughtech.reflection.model.Kid", clazz.getName()); // Returns the binary name
        assertEquals("com.lughtech.reflection.model.Kid", clazz.getCanonicalName()); // his returns the name you would typically use in Java source code.
    }

    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Kid();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);

        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }

    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> kidClass = Class.forName("com.lughtech.reflection.model.Kid");
        Class<?> personClass = Class.forName("com.lughtech.reflection.model.Person");

        int kidMods = kidClass.getModifiers();
        int personMods = personClass.getModifiers();

        assertTrue(Modifier.isPublic(kidMods));
        assertTrue(Modifier.isAbstract(personMods));
        assertTrue(Modifier.isPublic(personMods));
    }

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Kid kid = new Kid();
        Class<?> goatClass = kid.getClass();
        Package pkg = goatClass.getPackage();

        assertEquals("com.lughtech.reflection.model", pkg.getName());
    }

    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Kid goat = new Kid();
        String str = "any string";

        Class<?> goatClass = goat.getClass();
        Class<?> goatSuperClass = goatClass.getSuperclass();

        assertEquals("Person", goatSuperClass.getSimpleName());
        assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
    }

    @Test
    public void givenClass_whenGetsImplementedInterfaces_thenCorrect() throws ClassNotFoundException {
        Class<?> kidClass = Class.forName("com.lughtech.reflection.model.Kid");
        Class<?> personClass = Class.forName("com.lughtech.reflection.model.Person");

        Class<?>[] kidInterfaces = kidClass.getInterfaces();
        Class<?>[] personInterfaces = personClass.getInterfaces();

        assertEquals(1, kidInterfaces.length);
        assertEquals(1, personInterfaces.length);
        assertEquals("Working", personInterfaces[0].getSimpleName());
        assertEquals("Playing", kidInterfaces[0].getSimpleName());
    }
}

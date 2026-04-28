package com.lughtech.reflection.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import static com.lughtech.reflection.utils.Utils.getFieldNames;
import static com.lughtech.reflection.utils.Utils.getMethodNames;
import static org.junit.jupiter.api.Assertions.*;

public class PersonReflectionTest {

    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object person = new Kid("Matthew", 1);
        Class<?> clazz = person.getClass();

        assertEquals("Kid", clazz.getSimpleName());
        assertEquals("com.lughtech.reflection.model.Kid", clazz.getName()); // Returns the binary name
        assertEquals("com.lughtech.reflection.model.Kid", clazz.getCanonicalName()); // his returns the name you would typically use in Java source code.
    }

    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Kid("Matthew", 1);
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
        Kid kid = new Kid("Matthew", 1);
        Class<?> goatClass = kid.getClass();
        Package pkg = goatClass.getPackage();

        assertEquals("com.lughtech.reflection.model", pkg.getName());
    }

    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Kid goat = new Kid("Matthew", 1);
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
        assertEquals("Work", personInterfaces[0].getSimpleName());
        assertEquals("Playing", kidInterfaces[0].getSimpleName());
    }

    @Test
    public void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
        Class<?> kidClass = Class.forName("com.lughtech.reflection.model.Kid");

        Constructor<?>[] constructors = kidClass.getConstructors();

        assertEquals(1, constructors.length);
        assertEquals("com.lughtech.reflection.model.Kid", constructors[0].getName());
    }

    @Test
    public void givenClass_whenGetsFields_thenCorrect() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.lughtech.reflection.model.Person");
        Field[] fields = personClass.getDeclaredFields();

        List<String> actualFields = getFieldNames(fields);

        assertEquals(2, actualFields.size());
        assertTrue(actualFields.containsAll(Arrays.asList("name", "age")));
    }

    @Test
    public void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("com.lughtech.reflection.model.Person");
        Method[] methods = animalClass.getDeclaredMethods();
        List<String> actualMethods = getMethodNames(methods);

        assertEquals(3, actualMethods.size());
        assertTrue(actualMethods.containsAll(Arrays.asList("getName",
                "setName", "getAge")));
    }

    @Test
    public void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException {
        Class<?> adultClass = Class.forName("com.lughtech.reflection.model.Adult");
        Constructor<?>[] constructors = adultClass.getConstructors();

        assertEquals(3, constructors.length);
    }

    @Test
    public void givenClass_whenGetsEachConstructorByParamTypes_thenCorrect() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> birdClass = Class.forName("com.lughtech.reflection.model.Adult");

        // There is no need for assertion since we’ll get a NoSuchMethodException and the test will automatically
        // fail when a constructor with given parameter types in the given order does not exist.
        Constructor<?> cons1 = birdClass.getConstructor();
        Constructor<?> cons2 = birdClass.getConstructor(int.class);
        Constructor<?> cons3 = birdClass.getConstructor(String.class, int.class);
    }

    @Test
    public void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect()
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<?> adultClass = Class.forName("com.lughtech.reflection.model.Adult");
        Constructor<?> cons1 = adultClass.getConstructor();
        Constructor<?> cons2 = adultClass.getConstructor(int.class);
        Constructor<?> cons3 = adultClass.getConstructor(String.class, int.class);

        Adult adult1 = (Adult) cons1.newInstance();
        Adult adult2 = (Adult) cons2.newInstance(30);
        Adult adult3 = (Adult) cons3.newInstance("Mark Doe", 30);

        assertEquals("John Doe", adult1.getName());
        assertEquals(30, adult1.getAge());

        assertEquals("John Doe", adult2.getName());
        assertEquals(30, adult2.getAge());

        assertEquals("Mark Doe", adult3.getName());
        assertEquals(30, adult3.getAge());
    }
}

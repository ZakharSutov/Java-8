import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ReflectionDemoTest {

    @Test
    public void getCountClassHuman() {
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, new Human("Shutov", "Zakhar", "Andreevich", 20),
                new Student("Shutov", "Zakhar", "Andreevich", 20, "MPB-003"),
                new Human("Shutov", "Zakhar", "Andreevich", 20));
        assertEquals(3, ReflectionDemo.getCountClassHuman(list));
    }

    @Test
    synchronized public void getListNameOfPublicMethods() {
        List<String> expected = new ArrayList<>();
        Human human = new Student("Shutov", "Zakhar", "Andreevich", 20, "imit");
        Collections.addAll(expected, "setName", "getAge", "getClass", "wait", "getName", "notifyAll", "setFaculty", "getLastName",
                "setPatronymic", "notify", "setLastName", "getFaculty", "hashCode", "equals", "toString", "getPatronymic", "setAge");
        assertEquals(new HashSet<>(expected), new HashSet<>(ReflectionDemo.getListNameOfPublicMethods(human)));
    }

    @Test
    public void getListOfNameAllSuperClass() {
        List<String> expected = new ArrayList<>();
        Student student = new Student("Shutov", "Zakhar", "Andreevich", 20, "MPB-003");
        Collections.addAll(expected, "Human", "Object");
        assertEquals(new HashSet<>(expected), new HashSet<>(ReflectionDemo.getListOfNameAllSuperClass(student)));
    }
}
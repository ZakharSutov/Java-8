import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class ReflectionDemo {
    public static int getCountClassHuman(List<Object> list) {
        int count = 0;
        for (Object cl : list) {
            if (cl instanceof Human) count++;
        }
        return count;
    }

    public static List<String> getListNameOfPublicMethods(Object obj) {
        List<String> listOfNamePublicMethods = new ArrayList<>();
        for (Method method : obj.getClass().getMethods()) {              //getDeclaredMethods()) {
            int mods = method.getModifiers();
            if (!Modifier.isPrivate(mods)) listOfNamePublicMethods.add(method.getName());
        }
        return listOfNamePublicMethods;
    }

    public static List<String> getListOfNameAllSuperClass(Object obj) {
        List<String> listOfNameAllSuperClass = new ArrayList<>();
        Class<?> cl = obj.getClass().getSuperclass();
        while (cl != null) {
            listOfNameAllSuperClass.add(cl.getSimpleName());
            cl = cl.getSuperclass();
        }
        return listOfNameAllSuperClass;
    }
}


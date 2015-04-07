package bmo5.bmo5tests.tools;

import java.lang.reflect.Field;


public class ReflectionUtils {

    public static Object getFieldValue(Class<?> clazz, String fieldName, Object object) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    public static void setFieldValue(Class<?> clazz, String fieldName, Object object, Object value) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}

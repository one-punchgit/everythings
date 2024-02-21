package com.zb.thing.basic.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

public class ListUtils {
    public static <T> void sortByField(List<T> list, String fieldName) {
        list.sort((o1, o2) -> {
            try {
                Method method = o1.getClass().getMethod(getGetterMethodName(fieldName));
                Comparable fieldValue1 = (Comparable) method.invoke(o1);
                Comparable fieldValue2 = (Comparable) method.invoke(o2);
                return fieldValue1.compareTo(fieldValue2);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return 0;
            }
        });
    }

    private static String getGetterMethodName(String fieldName) {
        return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

    public <T> void sortByField1(List<T> list, String fieldName) {
        try {
            Method method = list.get(0).getClass().getMethod("get" + capitalize(fieldName));
            list.sort(Comparator.comparing((T obj) -> {
                try {
                    return (Comparable) method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                }
            }));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

package com.zy.utils;

import java.util.Collection;

public class CollectionUtil {

    public static  <T> void showCollection(Collection<T> collection){
        for(T t:collection){
            System.out.println(t);
        }
    }
}

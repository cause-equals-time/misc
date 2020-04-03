package com.company;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedOccurrenceFinder {

    public Object find(Object [] n){

        Set <Object> checker = new HashSet<>();

        for (Object o : n){
            if (checker.contains(o)) return o;
            else checker.add(o);
        }
        return null;
    }
}

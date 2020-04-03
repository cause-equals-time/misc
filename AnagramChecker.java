package com.company;

import java.util.HashMap;

public class AnagramChecker {

    public boolean check(String s1, String s2){

        if (s1.length()!=s2.length()) return false;

        HashMap <Character,Integer> maps1 = new HashMap<>();
        HashMap <Character,Integer> maps2 = new HashMap<>();

        for (int i=0; i<s1.length(); i++){
            maps1.put(s1.charAt(i),maps1.getOrDefault(s1.charAt(i), 0)+1);
            maps2.put(s2.charAt(i),maps2.getOrDefault(s2.charAt(i), 0)+1);
        }
        return maps1.equals(maps2);
    }
}

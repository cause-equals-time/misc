package com.company;

public class PalindromeChecker {

    public boolean check(String s){

        int low=0;
        int high=s.length()-1;
        boolean equal = true;
        while(low<high && equal){
            if (s.charAt(low)!=s.charAt(high)) equal=false;
            low++;
            high--;
        }
        return equal;
    }

    public boolean check(int n){

        int current = Math.abs(n);
        if (current<10) return true;
        int reverse = 0;

        while (current>0){
            reverse=reverse*10 + current%10;
            current/=10;
        }
        return reverse==n;
    }

    public boolean lazycheck(String s){

        StringBuilder sb = new StringBuilder(s);
        return sb.equals(sb.reverse());

    }

    public boolean lazycheck(int n){

        StringBuilder sb = new StringBuilder(n);
        return sb.equals(sb.reverse());

    }


}

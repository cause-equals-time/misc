package com.company;

import java.util.ArrayList;

public class nStair {

    public void calculate(int n){

        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        get(l,n);
        System.out.println("Number of ways = " + l.size() + "\n" + l);
    }

    private ArrayList<ArrayList<Integer>> get(ArrayList<ArrayList<Integer>> listOfWays, int n){

        if (n==0) return listOfWays;
        int i = listOfWays.size();
        while (i>0){
            ArrayList<Integer> holder1 = new ArrayList<>(listOfWays.get(0));
            holder1.add(1);
            listOfWays.add(holder1);
            if (holder1.size()>1 && holder1.get(holder1.size()-1)==1 && holder1.get(holder1.size()-2)==1){
                ArrayList<Integer> holder2 = new ArrayList<>(listOfWays.get(0));
                holder2.set(holder2.size()-1,2);
                listOfWays.add(holder2);
            }
            listOfWays.remove(0);
            i--;
        }
        return get(listOfWays,n-1);
    }
}

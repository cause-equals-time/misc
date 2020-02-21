package com.company;

import java.util.ArrayList;
import java.util.Collections;

// Given range and n generate a list containing n values in the interval {-range, range} that add up to zero
public class ZeroSumArray {

    private int n;
    private int range;
    private ArrayList <Integer> nlist = new ArrayList<Integer>();
    private ArrayList <Integer> numbers= new ArrayList<Integer>();

    public ZeroSumArray(int n, int range) {
        this.n = n;
        this.range = range;
    }

    private int getRandom(int lower, int upper) {
        return (int)(Math.random() * ((upper-lower)+1)+lower);
    }

    private void initvalidnums(){
        for (int i=-range; i<=range; i++){
            numbers.add(i);
        }
    }

    private void fill(){
        int i=1;
        int zeroindex = range;
        int rand;
        while (i<=n/4+1){
            rand = getRandom(1,numbers.size()-1-zeroindex);
            nlist.add(numbers.remove(zeroindex+rand));
            nlist.add(numbers.remove(zeroindex-rand));
            i++;
            zeroindex--;
        }
    }

    private int findnextavailable(int value){

        int inc = value/Math.abs(value); //According to the value received by the method, establishes if the next available number is meant to be higher or lower
        int iterator = value - range*inc - inc; //Establishes what is the limit value which will still verify the condition, ex: for range=10, [-10...10], for value = -3 the limit value is 7, as anything higher will make it impossible to have -range + iterator = -3
        boolean indexnotfound = true;
        while (Math.abs(iterator)<=range && indexnotfound){
            iterator = iterator + inc;
            if (numbers.contains(iterator)) indexnotfound = false;
        }
        return numbers.indexOf(iterator);
    }

    private void replace(int index){

        int valuetoreplace = nlist.get(index);
        boolean notreplaced = true;
        ArrayList <Integer> sub; //auxiliary arraylist that will hold a subarray of numbers, containing the range of values that can lead to the desired replacement, as defined by findnextavailable() method

        if (valuetoreplace > 0) sub = new ArrayList<Integer>(numbers.subList(findnextavailable(valuetoreplace),numbers.size()));
        else{
            sub = new ArrayList<Integer>(numbers.subList(0,findnextavailable(valuetoreplace)+1));
        }

        while (notreplaced && sub.size()>1){
            int rand = getRandom(0,sub.size()-1);
            int aux = valuetoreplace-sub.get(rand);

            //if aux = 8 - (-1) = 9 then we need to check if sub contains 9, and if it does, we know that we can replace 8 with 9 and -1 in nlist.
            //aux!=sub.get(rand) is there to avoid 8 - 4 = 4, where 4 would be added to nlist twice.
            if (sub.contains(aux) && aux!=sub.get(rand)){
                nlist.remove(Integer.valueOf(valuetoreplace));
                nlist.add(sub.get(rand));
                nlist.add(aux);
                numbers.add(valuetoreplace);
                Collections.sort(numbers);
                numbers.remove(sub.get(rand));
                numbers.remove(Integer.valueOf(aux));
                notreplaced=false;
            }
            sub.remove(rand);
        }
    }

    private void create(int delta){

        for (int i=1; i<=range; i++){
            nlist.add(i);
            nlist.add(-i);
        }

        for (int i=1; i<=delta; i++){
            int rand = getRandom(0,(nlist.size()-1)/2)*2;
            nlist.remove(rand);
            nlist.remove(rand);
        }

        if (n%2!=0) nlist.add(0);
    }

    public ArrayList<Integer> generate() {

        if (n<1 || n>range*2+1){
            throw new IllegalArgumentException();
        }

        nlist.clear();
        numbers.clear();

        if (n==1){
            nlist.add(0);
            return nlist;
        }

        if (n >= range*2 -1) {

            create((int) Math.ceil ((double) (range*2-n)/2));

        } else {

            initvalidnums();
            fill();

            while (nlist.size() != n) {
                replace(getRandom(0, nlist.size() - 1));
            }

        }
        return nlist;
    }

    public boolean check(){

        int sumcheck = 0;
        for (Integer integer : nlist) {
            sumcheck += integer;
        }
        System.out.println(nlist.size() + " elements sum up to " + sumcheck);
        return sumcheck==0;
    }
}

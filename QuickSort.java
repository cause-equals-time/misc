package com.company;

import java.util.Arrays;

public class QuickSort {


    public void sort(int [] n){

        sort(n,0,n.length-1);

    }

    public void sort(int [] n, int left, int right) {

        if (left < right) {

            int pivot = n[right];
            int cnt = left;


            for (int i = left; i < right; i++) {

                if (n[i] <= pivot) {
                    int holder = n[cnt];
                    n[cnt] = n[i];
                    n[i] = holder;
                    cnt++;
                }
            }

            int holder = n[cnt];
            n[cnt] = n[right];
            n[right] = holder;


            sort(n, left, cnt - 1);
            sort(n, cnt+1, right);
        }
    }

}

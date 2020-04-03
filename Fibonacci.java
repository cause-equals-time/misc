package com.company;

public class Fibonacci {

    public int getN(int n){

        if (n<2) return n;

        int n1 = 0;
        int n2 = 1;
        int holder;

        for (int i=2; i<=n; i++){
            holder = n1;
            n1 = n2;
            n2 += holder;
        }
        return n2;
    }

    public int [] getSequence(int n){

        int [] seq = new int[n+1];
        seq[0]=0;
        seq[1]=1;

        for (int i=2; i<=n; i++){
            seq[i]=seq[i-1]+seq[i-2];
        }
        return seq;
    }

    public int getNrec(int n){
        if (n<2) return n;
        return get(0,1,n);
    }

    private int get(int n1, int n2, int n){
        if (n<2) return n2;
        return get(n2,n1+n2,n-1);
    }

}

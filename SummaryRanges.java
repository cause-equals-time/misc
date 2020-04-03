package com.company;

import java.util.ArrayList;

public class SummaryRanges {

    public ArrayList<String> get(int [] ar){

        ArrayList <String> ranges = new ArrayList<>();
        int startrange = ar[0];
        String merger;
        for (int i=1; i<ar.length; i++){

            if (ar[i]!=ar[i-1]+1) {
                //int endrange = ar[i-1+(i/(ar.length-1))];
                merger = startrange==ar[i-1]? String.valueOf(startrange) : startrange + " > " + ar[i-1];
                ranges.add(merger);
                startrange=ar[i];
            }
        }
        merger = startrange==ar[ar.length-1]? String.valueOf(startrange) : startrange + " > " + ar[ar.length-1];
        ranges.add(merger);
        return ranges;
    }

}

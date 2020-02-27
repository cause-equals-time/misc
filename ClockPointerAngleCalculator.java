package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClockPointerAngleCalculator {

    private static final String validtimepattern ="([01]?[0-9]|2[0-3]):[0-5][0-9]";

    public double getAngle(String time){
        Pattern p = Pattern.compile(validtimepattern);
        Matcher m = p.matcher(time);

        if(m.matches()){
            /*int hour = Integer.parseInt(time.substring(0, time.indexOf(':')));
            int minutes = Integer.parseInt(time.substring(time.indexOf(':')+1, time.length()));*/

            String[] hm = time.split(":",2);
            int hour = Integer.parseInt(hm[0]);
            int minutes = Integer.parseInt(hm[1]);
            hour = hour>12 ? hour-12 : hour;
            double angle = Math.abs((hour*30) + (minutes*0.5) - (minutes*6));
            return (angle>180 ? 360-angle : angle);
        }
        throw new IllegalArgumentException();
    }
}

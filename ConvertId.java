package com.jmiller.mentorcount;

public class ConvertId {

    public String convert(String s){

        int [] bounds = new int[2];


        //parse string and look for the initial '8' that the banner ID begins with
        //end when the first '?' appears;
        //store the index of both in the array called 'bounds'
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '8') {
                bounds[0] = i;
            }//end if
            if (s.charAt(i) == '?') {
                bounds[1] = i;
                break;
            }//end if

        }//end for




        //cut the string and store it as a new string
        //idReal is just the student ID number.
        return s.substring(bounds[0], bounds[1]);

    }
}

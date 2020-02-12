package com.allwayz.freeseed.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringToArrayUtil {
    public static ArrayList<String> StringToArray(String inputString,String delim){
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString,delim,false);
        while (stringTokenizer.hasMoreTokens()){
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    @Test
    public void testStringToArray(){
        String string = "Hello,World,!";
        ArrayList arrayList = StringToArrayUtil.StringToArray(string,",");
        arrayList.forEach(System.out::println);
    }

}
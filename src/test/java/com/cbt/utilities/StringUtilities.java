package com.cbt.utilities;

import org.apache.hc.core5.util.Asserts;

public class StringUtilities {

    public static void verifyEquals(String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}

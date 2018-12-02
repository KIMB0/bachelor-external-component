package com.company;

public class Main {


    public static void main(String[] args) {
        String envString = System.getenv("SENTENCE");
        String reverseString = reverseString(envString);
        System.out.println(reverseString);
        // write your code here
    }

    public static String reverseString(String sentence){
        String newString = new StringBuilder(sentence).reverse().toString();
        return newString;
    }
}

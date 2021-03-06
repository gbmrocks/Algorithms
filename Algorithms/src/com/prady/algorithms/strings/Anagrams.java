package com.prady.algorithms.strings;

import java.util.Scanner;
public class Anagrams {
    public static int numberNeeded(String first, String second) {
        int[] firstArr  = new int[26];
        int[] secondArr = new int[26];
        int i = 0;
        int counter = 0;

        for(; i<first.length(); i++){
            int c       = (int)first.charAt(i)-97;
            firstArr[c] = firstArr[c]+1;
        }
        for(i=0; i<second.length(); i++){
            int c           = (int)second.charAt(i)-97;
            secondArr[c]    = secondArr[c]+1;
        }
        for(i=0; i<26; i++){
            counter += Math.abs(firstArr[i]-secondArr[i]);
        }
        return counter;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

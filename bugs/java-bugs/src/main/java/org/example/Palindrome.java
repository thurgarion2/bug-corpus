package org.example;

import java.util.Set;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("otto"));
        System.out.println(isPalindrome("otot"));
    }

    public static boolean isPalindrome(String sentence){

//        StringBuilder alphabetical = new StringBuilder();
//        sentence.chars()
//                .filter(Palindrome::isAlphabetical)
//                .forEach(alphabetical::appendCodePoint);
//        String lowercase = alphabetical.toString().toLowerCase();
//
//        for(int idx=0; idx<lowercase.length(); ++idx){
//            if(lowercase.charAt(idx)!=lowercase.charAt(lowercase.length()-idx-1)){
//                return false;
//            }
//        }
        return true;
    }

    public static boolean isAlphabetical(int c){
        return true;//Set.of(' ', ',', '-','\'').contains(c);
    }


}

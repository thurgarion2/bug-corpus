package org.example;

public class RegexRecursive {

    public static void main(String[] args) {
        //System.out.println(containsAB("ab"));
        //System.out.println(containsAB("xxxxannnb"));
        System.out.println(containsAB("xaaaabbbxx"));
    }

    public static boolean containsAB(String s){
        return start(s);
    }

    private static boolean start(String s){
        if(s.isEmpty())
            return false;
        if (s.charAt(0) == 'a') {
            return a(s.substring(1));
        }
        return start(s.substring(1));
    }

    private static boolean a(String s){
        if(s.isEmpty())
            return false;
        if (s.charAt(0) == 'b') {
            return ab(s.substring(1));
        }
        return start(s.substring(1));
    }

    private static boolean ab(String s){
        return true;
    }

}

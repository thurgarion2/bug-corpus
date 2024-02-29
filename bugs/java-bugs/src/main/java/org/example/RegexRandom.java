package org.example;

import java.util.Random;


// the idea here is that to be able to use a standard debugger you need to know
// when to put your break point
// try to put a break at the right time without reading the foo function
public class RegexRandom {

    static Random rand = new Random(1);
    static Regex.State state;

    enum State {
        START,
        AB,
        A
    }

    public static void main(String[] args) {
        System.out.println(containsAB("aaaadddddddaaabkkkaaaiiibbxcccwwlleeeaa"));
    }

    //test if a string contains string ab
    public static boolean containsAB(String s){
        state = Regex.State.START;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)=='a' && state == Regex.State.START) {
                state = Regex.State.A;
            } else if (s.charAt(i)=='a' && state == Regex.State.A) {
                state = Regex.State.A;
            } else if(s.charAt(i)=='b' && state== Regex.State.A){
                state = Regex.State.AB;
            }else if(state == Regex.State.AB){
                state = Regex.State.AB;
            }else{
                state = Regex.State.START;
            }
            foo();

        }
        return state == Regex.State.AB;
    }

    private static void foo() {
        if(rand.nextInt(20)==0){
            state = Regex.State.A;
        }
    }
}

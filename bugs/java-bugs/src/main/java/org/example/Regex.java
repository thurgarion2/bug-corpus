package org.example;

public class Regex {

    enum State {
        START,
        AB,
        A
    }

    public static void main(String[] args) {
        System.out.println(containsAB("ab"));
        System.out.println(containsAB("xxxxannnb"));
        System.out.println(containsAB("xaaaabbbxx"));
    }

    //test if a string contains string ab
    public static boolean containsAB(String s){
        State state = State.START;
        for(int i=0; i<s.length(); ++i){ // the transition a&A -> A is missing
            if(s.charAt(i)=='a' && state==State.START){
                state = State.A;
            }else if(s.charAt(i)=='b' && state==State.A){
                state = State.AB;
            }else if(state == State.AB){
                state = State.AB;
            }else{
                state = State.START;
            }

        }
        return state == State.AB;
    }
}

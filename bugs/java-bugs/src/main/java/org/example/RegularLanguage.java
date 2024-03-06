package org.example;

public class RegularLanguage {
    enum STATE {
        START,
        EVEN_ODD,
        ODD_EVEN,
        EVEN_EVEN

    }

    public static void main(String[] args) {
        System.out.println(recognizeLanguage("aabbaababa"));
    }

    // recognize language with even numbers of a and b
    public static boolean recognizeLanguage(String s){
        STATE state = STATE.START;

        for(char c : s.toCharArray()){
            if(c=='a' && state==STATE.START){
                state = STATE.EVEN_ODD;
            }else if(c=='b' && state==STATE.START){
                state = STATE.ODD_EVEN;
            }else if(c=='a' && state==STATE.EVEN_ODD){
                state = STATE.START;
            }else if(c=='b' && state==STATE.EVEN_ODD){
                state = STATE.EVEN_EVEN;
            }else if(c=='a' && state==STATE.ODD_EVEN){
                state = STATE.EVEN_EVEN;
            }else if(c=='a' && state==STATE.EVEN_EVEN){
                state = STATE.ODD_EVEN;
            }else if(c=='b' && state==STATE.EVEN_EVEN){
                state = STATE.EVEN_ODD;
            }
        }
        return state==STATE.EVEN_EVEN;
    }
}

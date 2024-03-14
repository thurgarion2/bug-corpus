package org.example;

import java.util.function.Supplier;

public class Bitwise {
    public static void main(String[] args) {
        System.out.println(bitCounter(0));
        System.out.println(bitCounter(1));
        System.out.println(bitCounter(2));
        System.out.println(bitCounter(3));
        System.out.println(bitCounter(-1));
    }

    public static int bitCounter(int x){
        int bits = 0;
        while(x != 0){
            bits += x%2;
            x = x >> 1; // if x is negative we have an infinite loop
        }
        return bits;
    }
}

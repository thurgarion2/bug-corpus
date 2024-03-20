package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Shuffle {
    static Random rand = new Random(9);
    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        shuffle(l);
    }

    public static void shuffle(List<Integer> l){
        for(int i=0; i<l.size(); ++i){
            swap(l, i, rand.nextInt(l.size()+1));
        }
    }

    public static void swap(List<Integer> l, int src, int dst){
        int srcElem = l.get(src);
        l.set(src,l.get(dst));
        l.set(dst, srcElem);
    }
}

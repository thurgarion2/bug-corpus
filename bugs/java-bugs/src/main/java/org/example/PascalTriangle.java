package org.example;

import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(pascalTerm(2, 4));
        System.out.println(pascalTerm(1, 3));
        System.out.println(pascalTerm(3, 6));
    }

    public static int pascalTerm(int p, int n){
        if(p<0 || p>n)
            throw new IllegalArgumentException();

        int[][] pascalTerms = new int[p+1][n+1];
        fill(pascalTerms, -1);

        return pascalTermHelper(p, n, pascalTerms);
    }

    public static void fill(int[][] array, int value){
        for (int[] ints : array) {
            Arrays.fill(ints, value);
        }
    }

    public static int pascalTermHelper(int p, int n, int[][] pascalTerms){
        if(p<0 || p>n)
            throw new IllegalArgumentException();

        if(p==0 || p==n)
            return 1;

        if(pascalTerms[p][n]==-1)
            pascalTerms[p][n] = pascalTermHelper(p-1, n-1, pascalTerms)+pascalTermHelper(p-1, n-1, pascalTerms); // should be p-1, n-1 and p, n-1
        return pascalTerms[p][n];
    }


}

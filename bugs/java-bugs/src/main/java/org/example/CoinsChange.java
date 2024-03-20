package org.example;

import java.util.List;

public class CoinsChange {
    public static void main(String[] args) {
        //List<Integer> coins = List.of(1,2,5);
//        System.out.println(count(0, coins));
//        System.out.println(count(1, coins));
//        System.out.println(count(2, coins));
//        System.out.println(count(4, coins));
    }

    public static int count(int sum, List<Integer> coins){
        if(sum==0)
            return 1;
        if(coins.isEmpty())
            return 0;

        int coin = coins.get(0);
        return count(sum-coin, coins) + count(sum, coins.subList(1, coins.size()));
    }
}

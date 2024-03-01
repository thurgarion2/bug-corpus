from typing import List 
import snoop


@snoop(depth=4)
def count(sum : int, coins : List[int]) -> int:
    if sum == 0:
        return 1
    
    if len(coins)==0: ### bad base case, we should also check that coins<0
        return 0
    
    coin = coins[0]
    return count(sum-coin, coins)+count(sum, coins[1:])

coins = [1,2,5]
print(count(1,coins))
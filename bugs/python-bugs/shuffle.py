from typing import List 
import random
import snoop
from snoop import pp


def swap(l, src, dst):
    l[src], l[dst] = l[dst], l[src]

@snoop(depth=1)
def shuffle(l: List[int]):

    for i in range(len(l)):
        pp.deep(lambda: swap(l, i, random.randint(i, len(l)))) #### should be len(l)-1

l = [1,2,3,4,5]
random.seed(1)
shuffle(l)
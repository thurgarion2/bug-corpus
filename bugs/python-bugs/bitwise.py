#### inspired from https://github.com/secureIT-project/extendingAPR/blob/main/Bugs/termination/Missing_Corner-case_Handling_2_NT.c/src/code.c
import snoop

@snoop
def bit_counter(x : int):
    bits = 0
    while x!=0:
        bits += x%2
        x >>= 1
    return bits

x = int(input())
print(bit_counter(x))
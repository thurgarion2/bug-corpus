import snoop

@snoop(depth=2)
def explore():
    x = foo() + foo() + 2

def foo():
    return 0

explore()
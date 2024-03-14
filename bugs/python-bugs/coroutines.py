import snoop

def iterList(list):
    for x in list:
        yield x

def testYield():
    yield 1
    yield 2
    yield 3
    yield 4  
    
@snoop(depth=2)
def test():
    for x in iterList([1,2,3,4]):
        print(x)


test()
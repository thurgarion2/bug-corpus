import snoop

def foo(x,y,z):
    return x

class aClass:
    x = 0


    def __init__(self):
        print("x")

    def foo(self,a, b):
        return a + b

#### java enums ???


@snoop(depth=2) 
def simple_stmt():
    global a
    clazz = aClass()
    clazz.x = 10
    clazz.foo(1,2)


    class inner:
        def __init__(self):
            pass
    
    a = 10
    x = 1
    y, z = 1, 2
    b = x + y + a - 10
    1 if z == 20 else 4
    function = lambda x: 10
    function(2)
    i = foo(x,y,z+10)


    if a+x+clazz.x==0:
        print("hello")
    else:
        print("world")

    while a<20:
        a+=1
        if a==12:
            continue
        if a==15:
            break
    
    for idx in range(5):
        b += 1

    ##java switch statement


    ###yield 1
    assert(True)
    return 4

@snoop()
def exceptions():

    try:
        raise Exception("an excep")
    except Exception as e:
        print("nothing")
    finally:
        print("finally")   

    with open('hello.txt', 'w') as file:
        file.write('hello world !')

    
simple_stmt()
exceptions()

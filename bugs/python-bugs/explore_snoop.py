import snoop

class Foo:
    def __init__(self) -> None:
        self.a = 0
        self.b = 1

@snoop()
def bar():
    x = Foo()
    return x 

bar()

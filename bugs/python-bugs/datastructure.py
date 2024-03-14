import snoop

class bar:

    def __init__(self):
        self.x = 0
        self.y = 1

    def something(self):
        self.x += 1


@snoop()
def foo():
    a, b, c = 1, 2, 3
    x = {'a' : 1, 'b':2}
    z = [1,2,3]
    x['c'] = 3
    y = bar()
    y.something()
    z.append(4)
    x.update({'d':4})

foo()


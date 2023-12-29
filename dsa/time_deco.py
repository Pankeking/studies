import time

def deco(func):
    def inner():
        start = time.time()
        func()
        print((time.time() - start) * 1000)
    return inner
  
@deco
def exec():
    for i in range(10):
      print(i)

exec()
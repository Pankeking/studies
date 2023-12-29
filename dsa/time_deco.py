import time

def deco(func):
    def wrapper(*args):
        start = time.time()
        r = func(*args)
        print((time.time() - start) * 1000)
        return r
    return wrapper
  
@deco
def exec():
    for i in range(10):
      print(i)

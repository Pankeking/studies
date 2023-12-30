class SymbolTable(object):
    def __init__(self):
        keys = "symbolkeys"
        self.keys = sorted(keys)
        self.values = [0,1,2,3,4,5,6,7,8,9]

    def get(self, key):
        rank = self.rank(key)
        if rank < len(self.keys) and self.keys[rank] == key:
            return self.values[rank]
        else:
            return None
    
    def rank(self, key: str) -> int: 
        lo = 0
        hi = len(self.keys) - 1
        while (lo <= hi):
            mid = lo + (hi - lo) // 2
            if key > self.keys[mid]:
                lo = mid
            elif key < self.keys[mid]:
                hi = mid   
            else:
                return mid
        return lo    
        
st = SymbolTable()
eeee = st.get('s')
print(st.keys)
print(st.values)
print(eeee)

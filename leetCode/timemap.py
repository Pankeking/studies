from collections import defaultdict

class TimeMap:

    def __init__(self):
        self.maps = defaultdict(list)
      
    def set(self, key: str, value: str, timestamp: int) -> None:
        self.maps[key].append([value,timestamp])

    def get(self, key: str, timestamp: int) -> str:
        print(self.maps)
        if key in self.maps:
          res = self.search(self.maps[key],timestamp)
          return self.maps[key][res][0]
        
        else:
          return ""

    def search(self, nums: list[int], target: int) -> int:
      lo = 0
      hi = len(nums)
      while lo < hi:
        mid = lo + (hi - lo) // 2 
        needle = nums[mid][1]
        if needle > target:
          hi = mid
        else:
          lo = mid + 1
      return lo - 1
          

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
obj = TimeMap()
obj.set("foo", "bar", 1);  # store the key "foo" and value "bar" along with timestamp = 1.
obj.get("foo", 1)         # return "bar"
obj.get("foo", 3)         # return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2,
                           # then the only value is at timestamp 1 is "bar".
obj.set("foo", "bar2", 4); # store the key "foo" and value "bar2" along with timestamp = 4.
obj.get("foo", 4)         # return "bar2"
obj.get("foo", 5)         # return "bar2"

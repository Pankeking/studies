import math    
def minEatingSpeed(piles: list[int], h: int) -> int:
        
        def check(speed) -> bool:
            return sum(math.ceil(pile / speed) for pile in piles) <= h
            return sum((pile - 1) / (speed + 1) for pile in piles) <= h

        lo = 1
        hi = max(piles)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if check(mid):
                hi = mid
            else: 
                lo = mid + 1
        return lo



def qs(array: list[int], lo: int, hi: int) -> None:
    if lo >= hi:
        return
    pivotIdx = partition(array, lo, hi)
    qs(array, lo, pivotIdx - 1)
    qs(array, pivotIdx + 1, hi)

def partition(array: list[int], lo: int, hi: int) -> int:
    
    pivot = array[hi]
    idx = lo - 1
    for i in range(lo, hi):
        if array[i] <= pivot:
            idx += 1
            array[i], array[idx] = array[idx], array[i]
    idx += 1
    array[hi] = array[idx]
    array[idx] = pivot
  
    return idx
      
def quicksort(array: list[int], ) -> None:
    qs(array, 0, len(array) - 1)
    
nums = [1,23,1,51,24,1,4,125,1,6,6,135,1,25,2,41,1412,5,125,5,12,512,4]

quicksort(nums)

print(nums)

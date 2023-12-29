from quicksort import quicksort
import unittest
from itertools import pairwise
import random

class QuickSortTest(unittest.TestCase):
    def test_empty_array(self):
        array = []
        quicksort(array)
        self.assertListEqual(array, [])

    def test_single_element_array(self):
        array = [1]
        quicksort(array)
        self.assertListEqual(array, [1])

    def test_sorted_array(self):
        array = [1, 2, 3, 4, 5]
        quicksort(array)
        self.assertListEqual(array, array)

    def test_unsorted_array(self):
        array = [5, 2, 4, 1, 3]
        quicksort(array)
        self.assertListEqual(array, [1, 2, 3, 4, 5])
        
    def test_big_unsorted_array(self):
        array = [1,23,1,51,24,1,4,125,1,6,6,135,1,25,2,41,1412,5,125,5,12,512,4]
        quicksort(array)
        
        self.assertListEqual(array, [1, 1, 1, 1, 1, 2, 4, 4, 5, 5, 6, 6, 12, 23, 24, 25, 41, 51, 125, 125, 135, 512, 1412])
    def test_million_unsorted_array(self):
        array = generate_random_array(1000000)
        quicksort(array)
        for pair in pairwise(array):
            if pair[0] > pair[1]:
                raise Exception("Array is not sorted at" + pair[0] + ", " + pair[1])
        
def generate_random_array(size):
    return [random.randint(0,size) for _ in range(size)]
    
if __name__ == '__main__':
    unittest.main()

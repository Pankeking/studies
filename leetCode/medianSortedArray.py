def findMedianSortedArrays(nums1: list[int], nums2: list[int]) -> float:
        def search(nums, target):
            lo = 0
            hi = len(nums)
            while lo < hi:
                mid = lo + (hi - lo) // 2
                if nums[mid] > target:
                    hi = mid
                else:
                    lo = mid + 1
            return lo - 1
        
        first = search(nums2, nums1[0])
        last  = search(nums1, nums2[0])
        return (nums2[first] + nums1[last]) / 2
      
nums = [[1,2], [3,4]]
nums1 = [[1,3], [2]]

print(findMedianSortedArrays(nums[0], nums[1]))
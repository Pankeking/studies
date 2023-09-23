def merge(arr1, m, arr2, n):
    
    i = m - 1
    j = n - 1
    k = m + n - 1
    
    while i >= 0:
        if j >= 0 and arr1[i] < arr2[j]:
            arr1[k] = arr2[j]
            j -= 1
        else:
            arr1[k] = arr1[j]
            
            
    
    print(arr1)

nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [4,5,6]
n = 3

merge(nums1,m,nums2,n)

print(nums1)
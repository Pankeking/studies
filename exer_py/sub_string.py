class Solution(object):
    def longestContinuousSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        temp = 1
        result = 1
        for i in range(len(s) - 1):
            if ord(s[i]) + 1 == ord(s[i + 1]):
                temp += 1
            else:
                result = max(result, temp)
                temp = 1
                
        return max(result, temp)
                

test = Solution()
print(test.longestContinuousSubstring("abacaba"))
print(test.longestContinuousSubstring("abcde"))


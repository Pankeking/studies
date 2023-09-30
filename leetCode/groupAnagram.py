class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        
        anagram_map = {}
        
        for word in strs:
            sorted_word = ''.join(sorted(word))
            if sorted_word in anagram_map:
                anagram_map[sorted_word].append(word)
            else:
                anagram_map[sorted_word] = [word]
        
        return list(anagram_map.values())
        
        
        
'''
identify anagram
    Standardize words
    compare
group them
'''

test = Solution()
result = test.groupAnagrams(["eat","tea","tan","ate","nat","bat"])
print(result)

def maxVowels(s: str, k: int) -> int:
    def isvowel(char: str) -> bool:
        return char in ['a','e','i','o','u']
            
    current = sum(1 for i in range(k) if isvowel(s[i]))
    for i in range(1, len(s) - k):
        prev = current
        if isvowel(s[i - 1]):
            current -= 1
        if isvowel(s[i + k - 1]):
            current += 1
        current = max(prev, current)
    return max(prev, current)

print(f"answer is: {maxVowels('abciiidef', 3)}")
# print(f"answer is: {maxVowels('leetcode', 3)}")
# print(f"answer is: {maxVowels('aeiou', 2)}")


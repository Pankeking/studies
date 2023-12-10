'''
Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

'''
def isValid(s: str) -> bool:
      left = []
      pairs = {"}":"{",  "]":"[",  ")":"("}
      
      for char in s:
          if char not in pairs:
              left.append(char)
              continue
          if not left or pairs[char] != left[-1]:
              return False
          left.pop()
      return not left



print(isValid("()"))
print(isValid('()[]{}'))
print(isValid('(}'))
print(isValid('}'))
print(isValid('('))



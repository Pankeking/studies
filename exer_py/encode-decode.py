def encode(strs:list[str]) -> str:
    res = ""
    for s in strs:
        res += str(len(s)) + "#" + s
    return res
  
def decode(str: str) -> list[str]:
    i = 0
    res = []
    
    while i < len(str):
        j = i
        while str[j] != '#':
            j += 1
        length = int(str[i:j])
        res.append(str[j + 1 : j + 1 + length])
        i = j + 1 + length
    return res

random_strings = [
    "Aurelius",
    "Legionnaire",
    "Gladiator",
    "Imperator",
    "Centurion",
    "Colosseum",
    "Germanicus",
    "Praetorian",
    "Maximus",
    "Decimus"
]

#    8#Aurelius11#Legionnaire9#Gladiator9#Imperator9#Centurion9#Colosseum10#Germanicus10#Praetorian7#Maximus7#Decimus
print(random_strings)
print(encode(random_strings))
encoded = encode(random_strings)
print(decode(encoded))

      
target = 12
position = [10,8,0,5,3]
speed = [2,4,1,1,3]

pairs = [(p,s) for p, s in zip(position, speed)]
stack = []

pairs.sort(reverse=True)
for p, s in pairs:
    delta = (target - p) / s
    if not stack:
        stack.append(delta)
    elif delta > stack[-1]:
        stack.append(delta)
print(stack)
    
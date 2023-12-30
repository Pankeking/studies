def evalRPN(tokens: list[str]) -> int:
    operands = []
    operators = []
    for token in tokens:
        if token == "+":
            right = operands.pop()
            left = operands.pop()
            operands.append(left + right)
        elif token == "-":
            right = operands.pop()
            left = operands.pop()
            operands.append(left - right)
        elif token == "/":
            right = operands.pop()
            left = operands.pop()
            operands.append(left // right)
        elif token == "*":
            right = operands.pop()
            left = operands.pop()
            operands.append(left * right)
        else:
            operands.append(int(token))
        print(operands)
    return operands.pop()
      
      
tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
  
evalRPN(tokens)
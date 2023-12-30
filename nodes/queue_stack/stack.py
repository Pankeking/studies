from node import Node

class Stack:
    def __init__(self):
        self.length = 0
        self.head = None
    
    def peek(self) -> int:
        return self.head.val if self.head else None
    
    def pop(self) -> Node:
        if not self.head or self.length == 0:
            return None
        
        self.length -= 1
        
        head = self.head
        self.head = self.head.next
        
        # Free Memory
        head.next = None
        if self.length == 0:
            self.head = None
            
        return head.val
    
    def push(self, item) -> None:
        node = Node(item)
        self.length += 1
        
        if not self.head:
            self.head = node
            return
        
        node.next = self.head
        self.head = node
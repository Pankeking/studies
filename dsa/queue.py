from node import Node
class Queue:
	def __init__(self) -> None:
		self.length = 0
		self.head = None
		self.tail = None
	
	def Enqueue(self, item) -> None:
		self.length += 1
		node = Node(item)
		if not self.tail:
			self.tail = self.head = node
			return

		self.tail.next = node
		self.tail = node

	def Deque(self) -> int:
		if not self.head:
			return None
		self.length -= 1
  
		head = self.head
		self.head = self.head.next

		# Free Memory 
		head.next = None
		if self.length == 0:
			self.tail = None

		return head.val
	
	def peek(self) -> int:
		return self.head.val if self.head else None


from queue import Queue
from node import Node
import unittest

class NodeTest(unittest.TestCase):
    def test_node_creation(self):
        node = Node(1)
        self.assertEqual(node.val, 1)
        self.assertEqual(node.next, None)

class QueueTest(unittest.TestCase):
    def test_enqueue(self):
        queue = Queue()
        queue.Enqueue(1)
        queue.Enqueue(2)
        queue.Enqueue(3)
        self.assertEqual(queue.Deque(), 1)
        self.assertEqual(queue.Deque(), 2)
        self.assertEqual(queue.Deque(), 3)
        self.assertEqual(queue.Deque(), None)

    def test_peek(self):
        queue = Queue()
        queue.Enqueue(1)
        queue.Enqueue(2)
        queue.Enqueue(3)
        self.assertEqual(queue.peek(), 1)
        self.assertEqual(queue.Deque(), 1)
        self.assertEqual(queue.peek(), 2)
        self.assertEqual(queue.Deque(), 2)
        self.assertEqual(queue.peek(), 3)
        self.assertEqual(queue.Deque(), 3)
        self.assertEqual(queue.peek(), None)
        
if __name__ == "__main__":
    unittest.main()

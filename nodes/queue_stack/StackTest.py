from stack import Stack
import unittest

class StackTest(unittest.TestCase):
    def test_empty_stack(self):
        stack = Stack()
        self.assertEqual(stack.peek(), None)
        self.assertEqual(stack.pop(), None)

    def test_push_pop(self):
        stack = Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        self.assertEqual(stack.peek(), 3)
        self.assertEqual(stack.pop(), 3)
        self.assertEqual(stack.peek(), 2)
        self.assertEqual(stack.pop(), 2)
        self.assertEqual(stack.peek(), 1)
        self.assertEqual(stack.pop(), 1)

    def test_peek_empty(self):
        stack = Stack()
        self.assertEqual(stack.peek(), None)

    def test_multiple_peek(self):
        stack = Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        self.assertEqual(stack.peek(), 3)
        self.assertEqual(stack.peek(), 3)
        self.assertEqual(stack.peek(), 3)

    def test_multiple_pop(self):
        stack = Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        self.assertEqual(stack.pop(), 3)
        self.assertEqual(stack.pop(), 2)
        self.assertEqual(stack.pop(), 1)

if __name__ == "__main__":
    unittest.main()

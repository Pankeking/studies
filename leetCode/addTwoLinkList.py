# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        current = l1
        num1 = 0
        digit = 1
        while current:
            num1 += (current.val * digit)
            digit *= 10
            current = current.next
        current = l2
        digit = 1
        num2 = 0
        while current:
            num2 += current.val * digit
            digit *= 10
            current = current.next
        num = num1 + num2
        head = ListNode(0, None)
        current = head
        while num != 0:
            digit = num % 10
            num //= 10
            current.val = digit
            current = current.next
        return head
        

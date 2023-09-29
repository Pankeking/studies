class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = None

    def add_to_head(self, value):
        new_node = ListNode(value)
        new_node.next = self.head
        self.head = new_node

    def add(self, value):
        if not self.head:
            self.head = ListNode(value)
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = ListNode(value)

    def display(self):
        current = self.head
        while current:
            print(current.value, end=" -> ")
            current = current.next
        print("None")


def merge_sort(head):
    if not head or not head.next:
        return head  # Base case: empty or single-node list

    # Find the middle of the list
    middle = find_middle(head)

    # Split the list into two halves
    left_half = head
    right_half = middle.next
    middle.next = None

    # Recursively sort both halves
    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)

    # Merge the sorted halves
    return merge(left_half, right_half)

def find_middle(head):
    slow = head
    fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    return slow

def merge(left, right):
    dummy = ListNode()
    current = dummy

    while left and right:
        if left.value < right.value:
            current.next = left
            left = left.next
        else:
            current.next = right
            right = right.next
        current = current.next

    if left:
        current.next = left
    if right:
        current.next = right

    return dummy.next

# Example usage:
link_list = LinkedList()
link_list.add(3)
link_list.add(4)
link_list.add(1)
link_list.add(1)
link_list.add(1)
link_list.add_to_head(2)
link_list.add_to_head(3)
link_list.add_to_head(4)
link_list.add_to_head(1)
link_list.add_to_head(17)
link_list.add(1)
link_list.add(2)

head = link_list.head

sorted_head = merge_sort(head)
link_list.head = sorted_head
link_list.display()
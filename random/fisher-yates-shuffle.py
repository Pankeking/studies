class ListNode:
    def __init__(self, value):
        self.value = value
        self.next = None

def random_shuffle_linked_list(head):
    # Convert the linked list to an array
    array = []
    current = head
    while current:
        array.append(current)
        current = current.next

    n = len(array)

    # Fisher-Yates shuffle
    for i in range(n - 1, 0, -1):
        j = random.randint(0, i)
        array[i], array[j] = array[j], array[i]

    # Reconstruct the shuffled linked list
    for i in range(n - 1):
        array[i].next = array[i + 1]
    array[-1].next = None

    return array[0]  # Return the new head of the shuffled linked list

import random

# Example usage:
# Construct a singly-linked list
head = ListNode(1)
current = head
for i in range(2, 11):
    current.next = ListNode(i)
    current = current.next

shuffled_head = random_shuffle_linked_list(head)

# Print the shuffled linked list
current = shuffled_head
while current:
    print(current.value, end=" -> ")
    current = current.next
print("None")

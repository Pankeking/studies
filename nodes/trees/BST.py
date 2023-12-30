class Bst:  
    class Node:
        def __init__(self, key=None):
            self.key = key
            self.right = None
            self.left = None
            
    def __init__(self):
        self.diameter = 0
        self.root = None
  
    def search(self, key):
        current = self.root
        while current:
            if current.key == key:
                return True
            if current.key > key:
                current = current.left
                continue
            if current.key < key:
                current = current.right
                continue
        return False
  
    def insert(self, key):
        if not self.root:
            self.root = self.Node(key)
            return
        current = self.root
        while current:
            if current.key == key:
                return
            if current.key > key:
                if not current.left:
                    current.left = self.Node(key)
                    return
                current = current.left
            elif current.key < key:
                if not current.right:
                    current.right = self.Node(key)  
                    return
                current = current.right

    def get_depth(self, node):
        if not node:
            return 0
        left = self.get_depth(node.left)
        right = self.get_depth(node.right)
        return 1 + max(left, right)

    def check_balance(self, node):
        if not node:
            return True
        left = self.get_depth(node.left)
        right = self.get_depth(node.right)
        diff = max(left - right, right - left)
        return diff <= 1 and self.check_balance(node.left) and self.check_balance(node.right)
        
    def breadth_fs(self, node):
        queue = []
        queue.append(node)
        while queue:
            current = queue.pop(0)
            print(current.key)
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)
  
    def depth_fs(self, node):
        if not node:
            return  
        # print(node.key) Pre-Order Traversal
        self.depth_fs(node.left)
        print(node.key) # In-Order Traversal
        self.depth_fs(node.right)
        # print(node.key) Post-Order Traversal
        
    def get_diameter(self, node):
        if not node:
            return 0
        left_height  = self.get_diameter(node.left)
        right_height = self.get_diameter(node.right)
        
        new_diameter = 1 + left_height + right_height
        
        self.diameter = max(self.diameter, new_diameter)
        
        return 1 + max(left_height, right_height)
        
    



tree = Bst()
tree.insert(5)
tree.insert(2)
tree.insert(1)
tree.insert(4)
tree.insert(7)
tree.insert(6)
tree.insert(-6)
tree.insert(8)

head = tree.root

print(tree.get_diameter(head))



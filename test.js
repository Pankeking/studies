class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}


class LinkedList {
  constructor() {
    this.head = null;
  }

  add(data) {
    if (!this.head) {
      this.head = new Node(data);
      return
    }
    let current = this.head;
    while (current.next) {
      current = current.next;
    }
    current.next = new Node(data);
  }

  traverse() {
    let current = this.head;
    while (current) {
      console.log(current.data + " -> ");
      current = current.next;
      
    }
  }

}

list = new LinkedList();

list.add(5)
list.add(4)
list.add(3)
list.add(7)
list.traverse();
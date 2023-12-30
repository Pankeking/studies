public class Queue<Item> {
    
    private Node first = null;
    private Node last = null;

    private class Node {
        Item item;
        Node next;
    }

    public void enQueue(Item item) {
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
    }

    public Item deQueue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
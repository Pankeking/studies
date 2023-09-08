public class Queue {
    
    private Node first = null;
    private Node last = null;

    private class Node {
        String item;
        Node next;
    }

    public void enQueue(String item) {
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
    }

    public String deQueue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
import edu.princeton.cs.algs4.StdOut;

public class Successor {
    private Parent[] id;
    // private Node head;

    public Successor(int N) {
        id = new Parent[N];
        Node prevNode = new Node(0);

        for(int i = 1; i < N; i++) {
            Node newNode = new Node(i);

            prevNode.next = newNode;
            newNode.prev = prevNode;
            id[i] = new Parent(newNode);
            prevNode = newNode;
        }
    }

    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static class Parent {
        Node child;
        Parent(Node child) {
            this.child = child;
        }
    }

    public void remove(int i) {
        if(id[i].child.data == i) {
            if (i >= id.length - 1) {
                return;
            }
            else {
                // Skip the removed node in the list
                id[i].child.prev.next = id[i].child.next;
                id[i].child.next.prev = id[i].child.prev;
                int newI = id[i].child.next.data;
                id[i] = id[newI];
            }
        }
        return;
            
    }

    public int find(int i) {
        int current = id[i].child.data;
        while(current != id[current].child.data) {
            id[i] = id[current];
            current = id[i].child.data;
        }
        return id[i].child.data;
    }
    

    public static void main(String[] args) {
        Successor list = new Successor(101);
        // for (int i = 1; i < list.id.length; i = i + 2) {
        //     list.remove(i);
        //     list.remove(i+1);
        //     StdOut.println(list.find(i));
        // }
        // StdOut.println(list.find(100));
        // list.remove(100);
        // StdOut.println(list.find(100));
        // StdOut.println(list.find(4));
        // list.remove(5);
        // StdOut.println(list.find(5));
        // StdOut.println(list.find(4));
        StdOut.println(list.find(60));
        list.remove(61);
        list.remove(62);
        list.remove(60);
        list.remove(63);
        list.remove(63);
        list.remove(63);
        StdOut.println("test next 60: "+list.id[60].child.next.data);
        StdOut.println("test id[60]: "+list.id[60].child.data);
        StdOut.println("test id[63]: "+list.id[63].child.data);
        list.remove(64);
        StdOut.println("test id[64]: "+list.id[64].child.data);
        StdOut.println("test id[60]: "+list.id[60].child.data);
        list.remove(65);
        list.remove(66);
        list.remove(67);
        list.remove(70);
        list.remove(68);
        list.remove(69);
        list.remove(69);
        StdOut.println("Find 60: " + list.find(60));
        StdOut.println("Find 64: " + list.find(64));
        StdOut.println(list.find(69));
        list.remove(69);
        StdOut.println("test: "+list.id[60].child.next.data);
        StdOut.println("test id[60]: "+list.id[60].child.data);
        StdOut.println(list.find(66));
    }
}
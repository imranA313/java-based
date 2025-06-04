package doublylinkedlist;

public class DoublyLinkedList {
    private Node head;

    private int size;

    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node curr = head;
            head = newNode;
            head.next = curr;
            curr.prev = head;
            size += 1;
        }

    }

    public int getSize() {
        return size;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.data + "]" + "-->");
            curr = curr.next;
        }
        System.out.print("[null]");
        System.out.println();
    }


    private static class Node {

        private final int data;
        private Node next;
        private Node prev;

        private Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

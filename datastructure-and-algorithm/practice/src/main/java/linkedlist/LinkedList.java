package linkedlist;

public class LinkedList {
    private Node head;
    private int size;

    public void insertAtFront(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node node = head;
            head = newNode;
            head.next = node;
            size += 1;
        }
    }

    public void insertAtLast(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node curr = head.next;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;
            size += 1;

        }
    }

    public String addAtPosition(int pos, int data) {

        Node newNode = new Node(data);

        if (pos > size || pos < 1) return "Invalid Integer Number";

        if (pos == 1) insertAtFront(data);

        if (pos == getSize()) insertAtLast(data);

        else {
            Node curr = head;
            Node prev = null;
            for (int i = 2; i <= pos; i++) {
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr;
            assert prev != null;
            prev.next = newNode;
            size += 1;
        }
        return String.valueOf(newNode.data);
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

    public int getSize() {
        return size;
    }

    static class Node {
        final int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
}

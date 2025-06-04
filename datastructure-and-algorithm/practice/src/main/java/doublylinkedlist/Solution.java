package doublylinkedlist;

public class Solution {

    public static void main(String[] args) {

        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insertAtFront(1);
        dl.insertAtFront(2);
        dl.insertAtFront(3);
        dl.insertAtFront(4);
        dl.insertAtFront(5);
        dl.print();

        System.out.println(dl.getSize());

    }
}

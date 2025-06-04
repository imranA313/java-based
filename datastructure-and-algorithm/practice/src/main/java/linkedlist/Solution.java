package linkedlist;

public class Solution {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtFront(1);
        ll.insertAtFront(2);
        ll.insertAtFront(3);
        ll.insertAtFront(4);
        ll.insertAtFront(5);
        //ll.print();
        //System.out.println(ll.getSize());
        ll.insertAtLast(6);
        //ll.print();
        //System.out.println(ll.getSize());
        System.out.println(ll.addAtPosition(4, 9));
        ll.print();
        System.out.println(ll.getSize());
    }
}

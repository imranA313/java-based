package tree.binarytree;

public class BinaryTree {

    private Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }
    private Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) root.left = insertRec(root.left, key);
        if (key > root.key) root.right = insertRec(root.right, key);

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(int searchKey) {
       return searchRec(root, searchKey);
    }

    private boolean searchRec(Node root, int searchKey) {

        if (root == null) return false;

        if (root.key == searchKey)  return true;

        if (searchKey < root.key) return searchRec(root.left, searchKey);
        else return searchRec(root.right, searchKey);
    }

    private static class Node {
        private final int key;
        private Node left, right;

        Node(int data) {
            this.key = data;
            this.left = right = null;
        }
    }
}

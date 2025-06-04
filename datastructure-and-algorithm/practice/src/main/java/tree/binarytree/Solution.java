package tree.binarytree;

public class Solution {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        int searchKey = 40;
        System.out.println();
        if (tree.search(searchKey)) System.out.println("Key " + searchKey + " found in the tree.");
        else System.out.println("Key " + searchKey + " not found in the tree.");
    }
}

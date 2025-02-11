/*
 * BST implementation
 * Le Tan Phuc
 * Oct 31, 2024
 */

public class BinarySearchTree {
    // node class
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root = null;
    //public delete API
    public void delete(int value){
        root = deleteRec(root, value);
    }
    private Node findMin(Node root){   //find the minimum node in the right subtree
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    private Node deleteRec(Node root, int value){
        if(root == null) //if the value is null (not found), then the tree is empty
            return null;
        else if(value > root.value){
            root.right = deleteRec(root.right, value); //recursively call deleteRec for right child to find value
        }
        else if (value < root.value){
            root.left = deleteRec(root.left, value); //recursively call deleteRec for left child to find value
        }
        else{
            if (root.right == null && root.left == null){
                return null; //node has no children (leaf node) just delete the node and does not replace it
            }
            else if(root.right != null && root.left == null){
                return root.right; //if there is still right child, replace the node with its right child
            }
            else if(root.right == null && root.left != null){
                return root.left;//if there is still left child, replace the node with its left child
            }
            else { //if the node to be deleted has 2 children find the in-order successor (smallest node in right subtree) and copy it into the node to be deleted, then the successor node is deleted from the right subtree.
                Node successor = findMin(root.right);
                root.value = successor.value;
                root.right = deleteRec(root.right, successor.value);
            }
            
        }
        return root;

    }
    // public insert API
    public void insert(int value) {
        root = insertRec(root, value);
    }
    // private recursive insert method
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // public search API
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // private recursive search method
    private boolean searchRec(Node root, int value) {
    if (root == null) {
        return false;
    }
    if (value == root.value) {
        return true; 
    }
    if (value < root.value) {
        return searchRec(root.left, value); // search the left subtree
    } 
    return searchRec(root.right, value); // search the right subtree
}       
        // public in-order API
        public void inOrder() {
            inOrderRec(root);
            System.out.println();
        }
        // recursive in-order traversal
        private void inOrderRec(Node root) {
            if (root != null) {
                inOrderRec(root.left);
                System.out.print(root.value + " ");
                inOrderRec(root.right);
            }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        System.out.println("In-order traversal:");
        bst.inOrder();

        System.out.println("Searching for 4: " + bst.search(4)); 
        System.out.println("Searching for 6: " + bst.search(6)); 
        
        // delete 8 and return tree
        bst.delete(8);
        bst.inOrder();
    }
}
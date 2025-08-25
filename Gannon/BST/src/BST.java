/*
 * BST implementation
 * Gia Nghi Dang
 * Oct 31, 2024
 */

public class BST {
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

    public void delete(int value){   //public delete method
        root = deleteRec(root, value);
    }

    private Node findMin(Node root){   //find the minimum node in the right subtree
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    private Node deleteRec(Node root, int value){
        if (root == null){   //if the value is null (not found), then the tree is empty
            return null;
        }
        else if (value < root.value){   //find the value in the left subtree
            root.left = deleteRec(root.left, value);
        }
        else if (value > root.value){   //find the value in the right subtree
            root.right = deleteRec(root.right, value);
        }
        else{   //when the value is found
            if (root.left == null && root.right == null){   //case 1: the node doesn't have any child
                return null;
            }
            else if (root.left != null && root.right == null){   //case 2: the node has one child
                return root.left;
            }
            else if (root.right != null && root.left == null){
                return root.right;
            }
            //case 3: the node has both left and right children
            Node successor = findMin(root.right);   //find the min node of the right subtree
            root.value = successor.value;
            root.right = deleteRec(root.right, successor.value);   //delete the successor
        }
        return root;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(8);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        System.out.println("In-order traversal:");
        bst.inOrder();

        System.out.println("Searching for 4: " + bst.search(4));
        System.out.println("Searching for 6: " + bst.search(6));

        System.out.println("Delete 7. Tree:");
        bst.delete(7);
        bst.inOrder();
    }
}
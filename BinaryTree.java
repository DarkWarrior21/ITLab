class Node {
    int data;
    Node rightChild;
    Node leftChild;

    public Node(int data) {
        this.data = data;
        this.rightChild = null;
        this.leftChild = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.leftChild = insert(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = insert(root.rightChild, data);
        }

        return root;
    }

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.leftChild = delete(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = delete(root.rightChild, data);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            root.data = findMinimum(root.rightChild).data;
            root.rightChild = delete(root.rightChild, root.data);
        }

        return root;
    }

    public Node findMinimum(Node root) {
        if (root == null || root.leftChild == null) {
            return root;
        }
        return findMinimum(root.leftChild);
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.leftChild);
            System.out.print(root.data + " ");
            inorder(root.rightChild);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 20);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 45);
        tree.insert(tree.root, 42);

        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.delete(tree.root, 1);
        tree.root = tree.delete(tree.root, 40);
        tree.root = tree.delete(tree.root, 45);
        tree.root = tree.delete(tree.root, 9);

        tree.inorder(tree.root);
        System.out.println();
    }
}
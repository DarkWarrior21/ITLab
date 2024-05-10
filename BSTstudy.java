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

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data > root.data) {
            root.leftChild = insert(root.leftChild, data);
        } else if (data < root.data) {
            root.rightChild = insert(root.rightChild, data);
        }

        return root;
    }

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data > root.data) {
            root.leftChild = delete(root.leftChild, data);
        } else if (data < root.data) {
            root.rightChild = delete(root.rightChild, data);
        } else {
            if (root.rightChild == null) {
                return root.leftChild;
            } else if (root.leftChild == null) {
                return root.rightChild;
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

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.leftChild);
            int rightHeight = height(node.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);

        int leftDiameter = diameter(root.leftChild);
        int rightDiameter = diameter(root.rightChild);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }

        if (data > root.data) {
            return search(root.leftChild, data);
        } else {
            return search(root.rightChild, data);
        }
    }
}

public class BSTstudy {
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

        int treeDiameter = tree.diameter(tree.root);
        System.out.println("Diameter of the tree: " + treeDiameter);

        Node searchNode = tree.search(tree.root, 30);
        if (searchNode != null) {
            System.out.println("Node found: " + searchNode.data);
        } else {
            System.out.println("Node not found.");
        }
    }
}
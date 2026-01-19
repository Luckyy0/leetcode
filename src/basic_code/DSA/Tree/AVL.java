package basic_code.DSA.Tree;

public class AVL {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    /**
     * Get the height of the node.
     * Lấy chiều cao của nút.
     */
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    /**
     * Get maximum of two integers.
     * Lấy giá trị lớn nhất trong 2 số nguyên.
     */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Right Rotate helper.
     * Hàm phụ trợ Xoay Phải.
     *
     * Time Complexity: O(1)
     */
    Node rightRotate(Node y) {
        Node yLeft = y.left;
        Node yLeftRight = yLeft.right;

        // Perform rotation / Thực hiện xoay
        yLeft.right = y;
        y.left = yLeftRight;

        // Update heights / Cập nhật chiều cao
        y.height = max(height(y.left), height(y.right)) + 1;
        yLeft.height = max(height(yLeft.left), height(yLeft.right)) + 1;

        // Return new root / Trả về gốc mới
        return yLeft;
    }

    /**
     * Left Rotate helper.
     * Hàm phụ trợ Xoay Trái.
     *
     * Time Complexity: O(1)
     */
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation / Thực hiện xoay
        y.left = x;
        x.right = T2;

        // Update heights / Cập nhật chiều cao
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root / Trả về gốc mới
        return y;
    }

    /**
     * Get Balance factor of node N.
     * Lấy hệ số cân bằng của nút N.
     */
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    /**
     * Insert a key into the AVL tree.
     * Chèn một khóa vào cây AVL.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) (Recursion stack)
     */
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node node, int key) {
        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insertRec(node.left, key);
        else if (key > node.key)
            node.right = insertRec(node.right, key);
        else // Duplicate keys not allowed / Không cho phép trùng khóa
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));

        /*
         * 3. Get the balance factor of this ancestor node to check whether
         * this node became unbalanced
         */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    /**
     * Print Pre-order traversal.
     * In duyệt Tiền thứ tự.
     */
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /*
         * The constructed AVL Tree would be
         * 30
         * / \
         * 20 40
         * / \ \
         * 10 25 50
         */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root); // Expected: 30 20 10 25 40 50
    }
}

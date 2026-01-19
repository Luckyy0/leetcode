package basic_code.DSA.Tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BST {
    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return this.right;
        }

        /**
         * Search for a node with the given data.
         * Tìm kiếm một nút với dữ liệu đã cho.
         *
         * Time Complexity: O(h) where h is height of BST (Worst case O(n))
         * Giải thích: Trong trường hợp tệ nhất, chúng ta phải duyệt từ gốc tới nút lá
         * (chiều cao h).
         * Space Complexity: O(h) for recursion stack
         * Giải thích: Độ sâu của ngăn xếp đệ quy tương ứng với chiều cao của cây.
         */
        public Node searchNode(int data) {
            if (this.data == data) {
                return this;
            }

            if (data < this.data) {
                return (this.left != null) ? this.left.searchNode(data) : null;
            }

            return (this.right != null) ? this.right.searchNode(data) : null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * Recursive function to insert a new key in BST.
     * Hàm đệ quy để chèn khóa mới vào BST.
     *
     * Time Complexity: O(h)
     * Giải thích: Ta cần duyệt một đường dẫn từ gốc đến vị trí cần chèn, độ dài tối
     * đa là chiều cao h.
     * Space Complexity: O(h) for recursion stack
     * Giải thích: Do sử dụng đệ quy, hệ thống cần lưu trữ stack frame cho mỗi lần
     * gọi, tối đa là h.
     */
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    /**
     * Recursive function to delete a key from BST.
     * Hàm đệ quy để xóa một khóa khỏi BST.
     *
     * Time Complexity: O(h)
     * Giải thích: Phải tìm nút cần xóa (O(h)) và có thể tìm nút nhỏ nhất bên phải
     * (O(h)), tổng thể vẫn là O(h).
     * Space Complexity: O(h) for recursion stack
     * Giải thích: Sử dụng đệ quy để duyệt cây, tốn không gian stack theo chiều cao
     * cây.
     */
    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(deleteRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteRec(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setData(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getData()));
        }
        return root;
    }

    /**
     * Helper function to find minimum value node in a subtree.
     * Hàm phụ trợ để tìm nút có giá trị nhỏ nhất trong cây con.
     *
     * Time Complexity: O(h)
     * Giải thích: Vòng lặp chạy liên tục sang nhánh trái cho đến khi hết, tối đa đi
     * qua h nút.
     * Space Complexity: O(1) iterative
     * Giải thích: Sử dụng vòng lặp thay vì đệ quy nên chỉ tốn bộ nhớ hằng số cho
     * biến tạm.
     */
    private int minValue(Node root) {
        int minv = root.getData();
        while (root.getLeft() != null) {
            minv = root.getLeft().getData();
            root = root.getLeft();
        }
        return minv;
    }

    public Node getParent(int x) {
        return getParentRec(root, null, x);
    }

    /**
     * Recursive function to find the parent of a node with value x.
     * Hàm đệ quy để tìm cha của nút có giá trị x.
     *
     * Time Complexity: O(h)
     * Giải thích: Quá trình tìm kiếm cha tương tự tìm kiếm nút, duyệt theo chiều
     * cao cây.
     * Space Complexity: O(h) for recursion stack
     * Giải thích: Đệ quy sử dụng stack của hệ thống, độ sâu tối đa là chiều cao h
     * của cây.
     */
    private Node getParentRec(Node curr, Node parent, int x) {
        if (curr == null) {
            return null;
        }
        if (curr.getData() == x) {
            return parent;
        }
        if (x < curr.getData()) {
            return getParentRec(curr.getLeft(), curr, x);
        } else {
            return getParentRec(curr.getRight(), curr, x);
        }
    }

    /**
     * Compute the maximum depth of the tree (Height).
     * Tính độ sâu lớn nhất của cây (Chiều cao).
     *
     * Time Complexity: O(n)
     * Giải thích: Phải duyệt qua tất cả các nút để tìm đường dài nhất.
     * Space Complexity: O(h) (h is height, worst case n)
     * Giải thích: Đệ quy sử dụng stack theo chiều cao cây.
     */
    public int maxDepthRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthRec(root.getLeft()), maxDepthRec(root.getRight()));
    }

    /**
     * Compute max depth using iteration (Level Order Traversal).
     * Tính độ sâu lớn nhất dùng khử đệ quy (Duyệt theo mức).
     *
     * Time Complexity: O(n)
     * Giải thích: Duyệt qua tất cả các nút.
     * Space Complexity: O(w) (w is max width of tree, worst case n/2)
     * Giải thích: Hàng đợi lưu trữ các nút ở mức hiện tại.
     */
    public int maxDepthIterative(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.getLeft() != null)
                    q.add(temp.getLeft());
                if (temp.getRight() != null)
                    q.add(temp.getRight());
            }
        }
        return depth;
    }

    /**
     * Compute the minimum depth of the tree (Shortest path to leaf).
     * Tìm độ sâu nhỏ nhất của cây (Đường ngắn nhất tới nút lá).
     *
     * Time Complexity: O(n)
     * Giải thích: Trong trường hợp tệ nhất (cây lệch), vẫn phải duyệt hết, nhưng
     * thường dừng sớm hơn.
     * Space Complexity: O(h)
     * Giải thích: Stack đệ quy.
     */
    public int minDepthRec(Node root) {
        if (root == null)
            return 0;
        if (root.getLeft() == null && root.getRight() == null)
            return 1;
        if (root.getLeft() == null)
            return 1 + minDepthRec(root.getRight());
        if (root.getRight() == null)
            return 1 + minDepthRec(root.getLeft());
        return 1 + Math.min(minDepthRec(root.getLeft()), minDepthRec(root.getRight()));
    }

    /**
     * Compute min depth using iteration (BFS - Level Order).
     * Tính độ sâu nhỏ nhất dùng khử đệ quy (BFS).
     *
     * Time Complexity: O(n)
     * Giải thích: Duyệt cây theo mức, dừng ngay khi gặp lá đầu tiên.
     * Space Complexity: O(w) (w is max width)
     * Giải thích: Hàng đợi lưu các nút cùng mức.
     */
    public int minDepthIterative(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.getLeft() == null && temp.getRight() == null)
                    return depth;
                if (temp.getLeft() != null)
                    q.add(temp.getLeft());
                if (temp.getRight() != null)
                    q.add(temp.getRight());
            }
            depth++;
        }
        return depth;
    }

    }

    /**
     * Check if the tree is a valid Binary Search Tree (Recursive).
     * Kiểm tra xem cây có phải là Cây Nhị Phân Tìm Kiếm hợp lệ không (Đệ quy).
     *
     * Time Complexity: O(n)
     * Giải thích: Phải duyệt qua tất cả các nút để kiểm tra tính hợp lệ.
     * Space Complexity: O(h)
     * Giải thích: Sử dụng stack của đệ quy.
     */
    public boolean isValidBST(Node root) {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper for recursive BST validation.
     * Hàm phụ trợ kiểm tra BST đệ quy.
     * Use long to handle cases where node data is Integer.MIN_VALUE or
     * Integer.MAX_VALUE.
     * Sử dụng long để xử lý trường hợp giá trị nút là Integer.MIN_VALUE hoặc
     * Integer.MAX_VALUE.
     */
    private boolean isValidBSTRec(Node node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.getData() <= min || node.getData() >= max) {
            return false;
        }

        return isValidBSTRec(node.getLeft(), min, node.getData()) &&
                isValidBSTRec(node.getRight(), node.getData(), max);
    }

    /**
     * Temp
     * Check if the tree is a valid BST (Iterative - In-order Traversal).
     * Kiểm tra xem cây có phải là BST hợp lệ không (Khử đệ quy - Duyệt trung thứ
     * tự).
     *
     * Time Complexity: O(n)
     * Giải thích: Duyệt trung thứ tự qua tất cả các nút, nếu đúng là BST thì thứ tự
     * phải tăng dần.
     * Space Complexity: O(h)
     * Giải thích: Sử dụng Stack để mô phỏng đệ quy.
     */
    public boolean isValidBSTIterative(Node root) {
        if (root == null)
            return true;
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }

            curr = stack.pop();
            // If next element in inorder traversal is smaller than the previous one, that's
            // not BST.
            // Nếu phần tử tiếp theo trong duyệt trung thứ tự nhỏ hơn phần tử trước đó, đó
            // không phải là BST.
            if (prev != null && curr.getData() <= prev.getData()) {
                return false;
            }
            prev = curr;
            curr = curr.getRight();
        }
        return true;
    }

    /**
     * Find Lowest Common Ancestor (LCA) of two nodes with values n1 and n2
     * (Recursive).
     * Tìm Tổ tiên chung gần nhất (LCA) của 2 nút có giá trị n1 và n2 (Đệ quy).
     *
     * Time Complexity: O(h)
     * Giải thích: Chiều cao của cây xác định số bước duyệt tối đa.
     * Space Complexity: O(h)
     * Giải thích: Stack đệ quy.
     */
    public Node findLCA(int n1, int n2) {
        return findLCARec(root, n1, n2);
    }

    private Node findLCARec(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left.
        // Nếu cả n1 và n2 đều nhỏ hơn root, thì LCA nằm bên trái.
        if (root.getData() > n1 && root.getData() > n2) {
            return findLCARec(root.getLeft(), n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right.
        // Nếu cả n1 và n2 đều lớn hơn root, thì LCA nằm bên phải.
        if (root.getData() < n1 && root.getData() < n2) {
            return findLCARec(root.getRight(), n1, n2);
        }

        // Otherwise, root is the LCA (or one of the nodes is the LCA of the other).
        // Ngược lại, root là LCA.
        return root;
    }

    /**
     * Find LCA of two nodes Iteratively.
     * Tìm LCA của 2 nút bằng cách Khử đệ quy.
     *
     * Time Complexity: O(h)
     * Giải thích: Duyệt từ gốc xuống, không bao giờ quay lui.
     * Space Complexity: O(1)
     * Giải thích: Không dùng stack hay đệ quy, chỉ biến tạm.
     */
    public Node findLCAIterative(int n1, int n2) {
        Node temp = root;
        while (temp != null) {
            if (temp.getData() > n1 && temp.getData() > n2) {
                temp = temp.getLeft();
            } else if (temp.getData() < n1 && temp.getData() < n2) {
                temp = temp.getRight();
            } else {
                break;
            }
        }
        return temp;
    }

    /**
     * Find LCA of N nodes.
     * Tìm LCA của N nút.
     *
     * Problem Extension: LCA of a set of nodes in BST is determined by the Min and
     * Max values in that set.
     * Mở rộng bài toán: LCA của một tập hợp các nút trong BST được xác định bởi giá
     * trị Nhỏ nhất và Lớn nhất trong tập đó.
     *
     * Time Complexity: O(k + h) where k is size of list.
     * Giải thích: O(k) để tìm min/max trong danh sách, O(h) để tìm LCA của min/max.
     * Space Complexity: O(1) (Iterative LCA)
     */
    public Node findLCA(List<Integer> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }

        int min = nodes.get(0);
        int max = nodes.get(0);

        for (int val : nodes) {
            if (val < min)
                min = val;
            if (val > max)
                max = val;
        }

        return findLCAIterative(min, max);
    }

    // ================= TREE TRAVERSAL METHODS / CÁC PHƯƠNG THỨC DUYỆT CÂY
    // =================

    /**
     * Pre-order Traversal (Root -> Left -> Right) (Recursive).
     * Duyệt Tiền thứ tự (Gốc -> Trái -> Phải) (Đệ quy).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void printPreOrder() {
        System.out.print("Pre-order: ");
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            printPreOrderRec(root.getLeft());
            printPreOrderRec(root.getRight());
        }
    }

    /**
     * Pre-order Traversal (Iterative).
     * Duyệt Tiền thứ tự (Khử đệ quy).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void printPreOrderIterative() {
        System.out.print("Pre-order (Iterative): ");
        if (root == null) {
            System.out.println();
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.getData() + " ");

            // Push right first so left is processed first
            // Push phải trước để trái được xử lý trước
            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }
        System.out.println();
    }

    /**
     * In-order Traversal (Left -> Root -> Right) (Recursive).
     * Duyệt Trung thứ tự (Trái -> Gốc -> Phải) (Đệ quy).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void printInOrder() {
        System.out.print("In-order: ");
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node root) {
        if (root != null) {
            printInOrderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            printInOrderRec(root.getRight());
        }
    }

    /**
     * In-order Traversal (Iterative).
     * Duyệt Trung thứ tự (Khử đệ quy).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void printInOrderIterative() {
        System.out.print("In-order (Iterative): ");
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }
            curr = stack.pop();
            System.out.print(curr.getData() + " ");
            curr = curr.getRight();
        }
        System.out.println();
    }

    /**
     * Post-order Traversal (Left -> Right -> Root) (Recursive).
     * Duyệt Hậu thứ tự (Trái -> Phải -> Gốc) (Đệ quy).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void printPostOrder() {
        System.out.print("Post-order: ");
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(Node root) {
        if (root != null) {
            printPostOrderRec(root.getLeft());
            printPostOrderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * Post-order Traversal (Iterative - 2 stacks).
     * Duyệt Hậu thứ tự (Khử đệ quy - dùng 2 stack).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (Stack 2 holds all nodes)
     */
    public void printPostOrderIterative() {
        System.out.print("Post-order (Iterative): ");
        if (root == null) {
            System.out.println();
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.getLeft() != null) {
                s1.push(temp.getLeft());
            }
            if (temp.getRight() != null) {
                s1.push(temp.getRight());
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().getData() + " ");
        }
        System.out.println();
    }

    /**
     * Find the kth smallest element in the BST.
     * Tìm phần tử nhỏ thứ k trong BST.
     *
     * Time Complexity: O(h + k)
     * Giải thích: Duyệt trung thứ tự dừng lại sau khi thăm k phần tử.
     * Space Complexity: O(h)
     * Giải thích: Stack để duyệt cây.
     */
    public int kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.getData();
            }

            curr = curr.getRight();
        }

        // If k is out of bounds (larger than number of nodes)
        // Nếu k nằm ngoài phạm vi (lớn hơn số lượng nút)
        throw new IllegalArgumentException("k is larger than the number of nodes in BST");
    }

    /**
     * Find the kth largest element in the BST.
     * Tìm phần tử lớn thứ k trong BST.
     *
     * Time Complexity: O(h + k)
     * Giải thích: Duyệt trung thứ tự ngược (Reverse In-order: Phải -> Gốc -> Trái)
     * dừng lại sau khi thăm k phần tử.
     * Space Complexity: O(h)
     */
    public int kthLargest(int k) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            // Go to the rightmost node
            // Đi tới nút ngoài cùng bên phải
            while (curr != null) {
                stack.push(curr);
                curr = curr.getRight();
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.getData();
            }

            // Move to left subtree
            // Di chuyển sang cây con trái
            curr = curr.getLeft();
        }

        throw new IllegalArgumentException("k is larger than the number of nodes in BST");
    }

    /**
     * Calculate the sum of values in the range [low, high].
     * Tính tổng các giá trị nằm trong khoảng [low, high].
     *
     * Time Complexity: O(n)
     * Giải thích: Trong trường hợp tệ nhất, phải duyệt qua tất cả các nút.
     * Thuật toán tối ưu bằng cách cắt bỏ các nhánh không nằm trong khoảng.
     * Space Complexity: O(h)
     * Giải thích: Stack đệ quy.
     */
    public int rangeSumBST(int low, int high) {
        return rangeSumBSTRec(root, low, high);
    }

    private int rangeSumBSTRec(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // If current node is smaller than low, the range is strictly in the right
        // subtree.
        // Nếu nút hiện tại nhỏ hơn low, khoảng cần tìm nằm hoàn toàn bên phải.
        if (root.getData() < low) {
            return rangeSumBSTRec(root.getRight(), low, high);
        }

        // If current node is larger than high, the range is strictly in the left
        // subtree.
        // Nếu nút hiện tại lớn hơn high, khoảng cần tìm nằm hoàn toàn bên trái.
        if (root.getData() > high) {
            return rangeSumBSTRec(root.getLeft(), low, high);
        }

        // Current node is in range, add it and check both sides.
        // Nút hiện tại nằm trong khoảng, cộng giá trị và kiểm tra cả hai bên.
        return root.getData() + rangeSumBSTRec(root.getLeft(), low, high) + rangeSumBSTRec(root.getRight(), low, high);
    }

    /**
     * Convert Sorted Array to Balanced BST.
     * Chuyển đổi Mảng đã sắp xếp thành Cây Nhị Phân Tìm Kiếm cân bằng.
     *
     * Time Complexity: O(n)
     * Giải thích: Mỗi phần tử trong mảng được thăm một lần để tạo nút.
     * Space Complexity: O(log n) (Recursion stack)
     * Giải thích: Chiều cao của cây là log n vì cây cân bằng.
     */
    public void sortedArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            root = null;
            return;
        }
        root = sortedArrayToBSTRec(arr, 0, arr.length - 1);
    }

    private Node sortedArrayToBSTRec(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        // Lấy phần tử ở giữa và làm gốc
        int mid = start + (end - start) / 2;
        Node node = new Node(arr[mid]);

        // Recursively construct the left subtree and make it left child of root
        // Đệ quy xây dựng cây con trái và gán làm con trái của gốc
        node.setLeft(sortedArrayToBSTRec(arr, start, mid - 1));

        // Recursively construct the right subtree and make it right child of root
        // Đệ quy xây dựng cây con phải và gán làm con phải của gốc
        node.setRight(sortedArrayToBSTRec(arr, mid + 1, end));

        return node;
    }

    /**
     * Find the smallest node value that is strictly greater than x.
     * Tìm nút có giá trị nhỏ nhất mà lớn hơn x (Successor).
     *
     * Time Complexity: O(h)
     * Giải thích: Duyệt một đường từ gốc xuống lá, loại bỏ một nửa không gian tìm
     * kiếm ở mỗi bước.
     * Space Complexity: O(1)
     * Giải thích: Sử dụng vòng lặp (Iterative), chỉ tốn bộ nhớ cho biến tạm.
     */
    public Node findSmallestGreaterThan(int x) {
        Node successor = null;
        Node curr = root;

        while (curr != null) {
            if (curr.getData() > x) {
                successor = curr;
                curr = curr.getLeft(); // Try to find a smaller value in the left subtree / Thử tìm giá trị nhỏ hơn ở
                                       // cây con trái
            } else {
                curr = curr.getRight(); // Go right to find a larger value / Đi sang phải để tìm giá trị lớn hơn
            }
        }
        return successor;
    }

    /**
     * Check if the tree is an AVL Tree.
     * Kiểm tra xem cây có phải là cây AVL không.
     *
     * An AVL tree is a BST where the difference between heights of left and right
     * subtrees
     * cannot be more than one for all nodes.
     * Cây AVL là cây BST mà sự chênh lệch độ cao giữa cây con trái và phải
     * không quá 1 ở tất cả các nút.
     *
     * Time Complexity: O(n)
     * Giải thích: Chúng ta duyệt qua từng nút một lần để tính chiều cao và kiểm tra
     * cân bằng.
     * Space Complexity: O(h)
     * Giải thích: Sử dụng stack đệ quy.
     */
    public boolean isAVL() {
        return checkAVLHeight(root) != -1;
    }

    /**
     * Helper function to check height and balance of AVL tree.
     * Returns height of tree if balanced, otherwise -1.
     * Hàm phụ trợ để kiểm tra chiều cao và độ cân bằng của cây AVL.
     * Trả về chiều cao của cây nếu cân bằng, ngược lại trả về -1.
     */
    private int checkAVLHeight(Node node) {
        if (node == null) {
            return 0; // Height of empty tree is 0 / Chiều cao cây rỗng là 0
        }

        int leftHeight = checkAVLHeight(node.getLeft());
        if (leftHeight == -1)
            return -1; // Left subtree is not valid / Cây con trái không hợp lệ

        int rightHeight = checkAVLHeight(node.getRight());
        if (rightHeight == -1)
            return -1; // Right subtree is not valid / Cây con phải không hợp lệ

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced / Không cân bằng
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Get all leaf nodes in the BST (Recursive).
     * Lấy tất cả các nút lá trong BST (Đệ quy).
     *
     * Time Complexity: O(n)
     * Giải thích: Phải duyệt qua tất cả các nút để kiểm tra xem có phải lá không.
     * Space Complexity: O(h)
     * Giải thích: Stack đệ quy.
     */
    public List<Integer> getLeafNodes() {
        List<Integer> leaves = new ArrayList<>();
        getLeafNodesRec(root, leaves);
        return leaves;
    }

    private void getLeafNodesRec(Node node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            leaves.add(node.getData());
        }
        getLeafNodesRec(node.getLeft(), leaves);
        getLeafNodesRec(node.getRight(), leaves);
    }

    /**
     * Get all leaf nodes in the BST (Iterative).
     * Lấy tất cả các nút lá trong BST (Khử đệ quy).
     *
     * Time Complexity: O(n)
     * Giải thích: Duyệt qua toàn bộ cây (Pre-order traversal).
     * Space Complexity: O(h)
     * Giải thích: Sử dụng Stack.
     */
    public List<Integer> getLeafNodesIterative() {
        List<Integer> leaves = new ArrayList<>();
        if (root == null) {
            return leaves;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            // Check if leaf / Kiểm tra xem có phải lá không
            if (curr.getLeft() == null && curr.getRight() == null) {
                leaves.add(curr.getData());
            }

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }
        return leaves;
    }

    public static void main(String[] args) {
        BST tree = new BST();

        /*
         * Let us create following BST
         * 50
         * / \
         * 30 70
         * / \ / \
         * 20 40 60 80
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("--- Traversals ---");
        tree.printInOrder(); // Expected: 20 30 40 50 60 70 80
        tree.printPreOrder();
        tree.printPostOrder();
        tree.printInOrderIterative();

        System.out.println("\n--- Search ---");
        System.out.println("Search 40: " + (tree.root.searchNode(40) != null ? "Found" : "Not Found"));
        System.out.println("Search 90: " + (tree.root.searchNode(90) != null ? "Found" : "Not Found"));

        System.out.println("\n--- Validation ---");
        System.out.println("Is Valid BST: " + tree.isValidBST(tree.root));

        System.out.println("\n--- Height/Depth ---");
        System.out.println("Max Depth: " + tree.maxDepthRec(tree.root));
        System.out.println("Min Depth: " + tree.minDepthRec(tree.root));

        System.out.println("\n--- Kth Smallest ---");
        System.out.println("3rd Smallest: " + tree.kthSmallest(3)); // Expected: 40
        System.out.println("2nd Largest: " + tree.kthLargest(2)); // Expected: 70

        System.out.println("\n--- Range Sum ---");
        System.out.println("Range Sum [35, 65]: " + tree.rangeSumBST(35, 65)); // 40 + 50 + 60 = 150

        System.out.println("\n--- LCA ---");
        Node lca = tree.findLCA(20, 40);
        System.out.println("LCA of 20 and 40: " + (lca != null ? lca.getData() : "null")); // 30
        lca = tree.findLCAIterative(20, 80);
        System.out.println("LCA of 20 and 80: " + (lca != null ? lca.getData() : "null")); // 50

        System.out.println("\n--- Smallest > X ---");
        Node successor = tree.findSmallestGreaterThan(65);
        System.out.println("Smallest > 65: " + (successor != null ? successor.getData() : "null")); // 70

        System.out.println("\n--- Delete 20 (Leaf) ---");
        tree.delete(20);
        tree.printInOrder();

        System.out.println("\n--- Delete 30 (One Child) ---");
        tree.delete(30);
        tree.printInOrder();

        System.out.println("\n--- Delete 50 (Two Children) ---");
        tree.delete(50);
        tree.printInOrder();

        System.out.println("\n--- Sorted Array to BST ---");
        BST tree2 = new BST();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        tree2.sortedArrayToBST(arr);
        System.out.print("In-order of built tree: ");
        tree2.printInOrder(); // Should be 1 2 3 4 5 6 7
        System.out.println("Root of built tree: " + tree2.root.getData()); // Should be 4

        System.out.println("\n--- AVL Check ---");
        System.out.println("Tree 1 Is AVL: " + (tree.isAVL() ? "Yes" : "No"));
        System.out.println("Tree 2 Is AVL: " + (tree2.isAVL() ? "Yes" : "No"));

        System.out.println("\n--- Leaf Nodes ---");
        // Re-create a simple tree for clearer leaf testing
        // Tạo lại một cây đơn giản để kiểm tra lá rõ ràng hơn
        BST tree3 = new BST();
        tree3.insert(50);
        tree3.insert(30);
        tree3.insert(70);
        tree3.insert(20);
        tree3.insert(40);
        tree3.insert(60);
        tree3.insert(80);
        // Leaves should be: 20, 40, 60, 80
        System.out.println("Leaf Nodes (Recursive): " + tree3.getLeafNodes());
        System.out.println("Leaf Nodes (Iterative): " + tree3.getLeafNodesIterative());
    }
}

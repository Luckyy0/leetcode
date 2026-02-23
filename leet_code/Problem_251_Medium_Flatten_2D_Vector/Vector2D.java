package leet_code.Problem_251_Medium_Flatten_2D_Vector;

public class Vector2D {

    private int[][] vector;
    private int row;
    private int col;

    /**
     * Initializes the Vector2D iterator.
     * Time: O(1).
     */
    public Vector2D(int[][] vec) {
        this.vector = vec;
        this.row = 0;
        this.col = 0;
        advanceToNextValid();
    }

    /**
     * Returns the next element from the 2D vector.
     * Time: O(1) Amortized.
     */
    public int next() {
        // Optimization: hasNext() call could be skipped if caller guarantees validity,
        // but robust implementation checks it or relies on advanceToNextValid state.
        // Tối ưu hóa: gọi hasNext() có thể bỏ qua nếu người gọi đảm bảo tính hợp lệ,
        // nhưng triển khai mạnh mẽ nên kiểm tra hoặc dựa vào trạng thái
        // advanceToNextValid.
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        int val = vector[row][col];
        col++;
        advanceToNextValid();
        return val;
    }

    /**
     * Checks if there are more elements.
     * Time: O(1) Amortized.
     */
    public boolean hasNext() {
        advanceToNextValid();
        return row < vector.length;
    }

    // Moves pointers to the next valid element
    // Di chuyển con trỏ đến phần tử hợp lệ tiếp theo
    private void advanceToNextValid() {
        while (row < vector.length) {
            // If col is within bounds of current row, we found a valid element
            // Nếu col nằm trong giới hạn của hàng hiện tại, ta tìm thấy phần tử hợp lệ
            if (col < vector[row].length) {
                return;
            }
            // Otherwise, move to next row and reset col
            // Ngược lại, chuyển sang hàng tiếp theo và reset col
            row++;
            col = 0;
        }
    }

    public static void main(String[] args) {
        int[][] vec = { { 1, 2 }, { 3 }, { 4 } };
        Vector2D iterator = new Vector2D(vec);

        System.out.println("next: " + iterator.next()); // 1
        System.out.println("next: " + iterator.next()); // 2
        System.out.println("next: " + iterator.next()); // 3
        System.out.println("hasNext: " + iterator.hasNext()); // true
        System.out.println("hasNext: " + iterator.hasNext()); // true (still pointing to 4)
        System.out.println("next: " + iterator.next()); // 4
        System.out.println("hasNext: " + iterator.hasNext()); // false
    }
}

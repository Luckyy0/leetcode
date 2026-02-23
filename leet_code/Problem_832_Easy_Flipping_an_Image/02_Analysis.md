# Analysis for Flipping an Image
# *Phân tích cho bài toán Lật và Nghịch đảo Hình ảnh*

## 1. Problem Essence & Operations
## *1. Bản chất vấn đề & Các thao tác*

### THE CHALLENGE
### *Thách thức*
We have a binary matrix. We need to perform two sequential operations on each row:
1.  **Reverse** the row (horizontal flip).
2.  **Invert** each bit (0 becomes 1, 1 becomes 0).
*Chúng ta có một ma trận nhị phân. Cần thực hiện hai thao tác tuần tự trên mỗi hàng: Đảo ngược hàng (lật ngang) và nghịch đảo từng bit (0 thành 1, 1 thành 0).*

---

## 2. Strategy: Two-Pointer & Bitwise Inversion
## *2. Chiến lược: Hai con trỏ & Nghịch đảo Bit*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate through each row:** Process the row using two pointers (`left` and `right`) moving towards the center.
    *   **Duyệt từng hàng:** Xử lý hàng bằng hai con trỏ (`left` và `right`) di chuyển vào giữa.*

2.  **Swap and Invert Simultaneously:**
    - If `row[left] == row[right]`:
        - Bitwise XOR with 1 (or $1 - val$) to invert both.
        - Because they are the same, flipping their positions (reversing) and then inverting them is the same as just inverting them in place.
    - If `row[left] != row[right]`:
        - After flipping and inverting, they stay the same! (e.g., 0 and 1 flipped is 1 and 0, inverted is 0 and 1). So we do nothing.
    *   **Hoán đổi và Nghịch đảo đồng thời:** Nếu hai giá trị tại `left` và `right` giống nhau, ta nghịch đảo cả hai. Nếu khác nhau, sau khi lật và nghịch đảo chúng sẽ không đổi giá trị, nên ta không cần làm gì.*

3.  **Middle Element:** If the row has an odd number of elements, the middle element always needs to be inverted.
    *   **Phần tử ở giữa:** Nếu hàng có số phần tử lẻ, phần tử ở giữa luôn cần được nghịch đảo.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    for (int[] row : image) {
        int left = 0, right = n - 1;
        while (left <= right) {
            if (row[left] == row[right]) {
                // Same values flip and invert -> results in inverted values
                int temp = row[left] ^ 1;
                row[left] = temp;
                row[right] = temp;
            }
            // Different values flip and invert -> no change needed
            left++;
            right--;
        }
    }
    return image;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the side of the matrix. We visit each element once.
    *   **Độ phức tạp thời gian:** $O(N^2)$, với $N$ là cạnh của ma trận.*
*   **Space Complexity:** $O(1)$ extra space, modifying the matrix in place.
    *   **Độ phức tạp không gian:** $O(1)$, sửa đổi trực tiếp trên ma trận.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Row:** `[1, 1, 0]`
1. Left=0 (1), Right=2 (0). Different. No change.
2. Left=1 (1), Right=1 (1). Same. Invert both: `row[1] = 0`.
**Result:** `[1, 0, 0]`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Observing that bits only change if they are the same at opposite ends of the row allows for a more efficient single-pass implementation of both flipping and inverting.
*Việc nhận thấy các bit chỉ thay đổi nếu chúng giống nhau ở hai đầu đối diện của hàng cho phép thực hiện đồng thời cả lật và nghịch đảo một cách hiệu quả chỉ trong một lượt duyệt.*

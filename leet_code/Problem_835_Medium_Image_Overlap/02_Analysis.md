# Analysis for Image Overlap
# *Phân tích cho bài toán Chồng lấp Hình ảnh*

## 1. Problem Essence & Translation
## *1. Bản chất vấn đề & Phép dịch chuyển*

### THE CHALLENGE
### *Thách thức*
We need to find the maximum number of overlapping `1`s between two $N \times N$ binary matrices when one matrix is shifted by an arbitrary vertical and horizontal offset. A brute-force approach trying all possible shifts $(dx, dy)$ would check $(2N-1) \times (2N-1)$ shifts, and for each shift, it would compare $N \times N$ cells. This is $O(N^4)$. For $N=30$, $30^4 = 810,000$, which is feasible.
*Chúng ta cần tìm số lượng ô `1` chồng lên nhau tối đa giữa hai ma trận nhị phân $N \times N$ khi một ma trận được dịch chuyển theo một độ lệch ngang và dọc bất kỳ. Cách tiếp cận duyệt trâu thử mọi độ lệch $(dx, dy)$ rồi so sánh $N \times N$ ô sẽ có độ phức tạp $O(N^4)$. Với $N=30$, con số này hoàn toàn khả thi.*

---

## 2. Strategy: Frequency Check of Shift Vectors
## *2. Chiến lược: Kiểm tra tần suất của các Vector dịch chuyển*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Extract 1s:** Create two lists, `list1` and `list2`, containing the coordinates `(r, c)` of every `1` in `img1` and `img2` respectively.
    *   **Trích xuất các số 1:** Tạo hai danh sách lưu tọa độ `(r, c)` của tất cả các ô có giá trị `1` trong `img1` và `img2`.*

2.  **Calculate Vectors:** For every pair of points $(r_1, c_1)$ from `list1` and $(r_2, c_2)$ from `list2`:
    - The shift vector required to align them is $(r_2 - r_1, c_2 - c_1)$.
    *   **Tính toán Vector:** Với mỗi cặp điểm từ hai danh sách, vector dịch chuyển để chúng khớp nhau là hiệu tọa độ tương ứng.*

3.  **Count Vector Frequencies:** Use a `HashMap` or a 2D array to count how many pairs of `1`s share the same shift vector.
    *   **Đếm tần suất Vector:** Sử dụng `HashMap` để đếm xem có bao nhiêu cặp số `1` có cùng vector dịch chuyển.*

4.  **Find the Max:** The most frequent vector represents the shift that produces the maximum overlap.
    *   **Tìm giá trị lớn nhất:** Vector xuất hiện nhiều nhất đại diện cho độ lệch mang lại số điểm chồng lấp lớn nhất.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int largestOverlap(int[][] img1, int[][] img2) {
    int n = img1.length;
    List<int[]> la = new ArrayList<>(), lb = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (img1[i][j] == 1) la.add(new int[]{i, j});
            if (img2[i][j] == 1) lb.add(new int[]{i, j});
        }
    }
    
    Map<String, Integer> counts = new HashMap<>();
    int maxOverlap = 0;
    for (int[] pa : la) {
        for (int[] pb : lb) {
            String s = (pa[0] - pb[0]) + " " + (pa[1] - pb[1]);
            counts.put(s, counts.getOrDefault(s, 0) + 1);
            maxOverlap = Math.max(maxOverlap, counts.get(s));
        }
    }
    return maxOverlap;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^4)$ in the worst case (if most cells are 1s). However, in practice, it is $O(L_1 \cdot L_2)$ where $L$ are the count of 1s.
    *   **Độ phức tạp thời gian:** $O(N^4)$ trong trường hợp xấu nhất (nếu hầu hết các ô là 1). Thực tế là $O(L_1 \cdot L_2)$ với $L$ là số lượng ô có giá trị 1.*
*   **Space Complexity:** $O(L1 + L2)$ or $O(N^2)$ extra space for lists and the map.
    *   **Độ phức tạp không gian:** $O(N^2)$ để lưu trữ danh sách tọa độ và bảng băm.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**img1:** `(0,0), (0,1), (1,1)`. **img2:** `(1,1), (1,2), (2,2)`.
1. Pair `(0,0)` and `(1,1)`: Vector = `(1, 1)`.
2. Pair `(0,1)` and `(1,2)`: Vector = `(1, 1)`.
3. Pair `(1,1)` and `(2,2)`: Vector = `(1, 1)`.
Count for vector `(1,1)` becomes 3.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Calculating the counts based on shared translation vectors is much more efficient than iterating through all possible spatial shifts, especially if the binary matrices are sparse (contain few 1s).
*Tính toán dựa trên các vector dịch chuyển dùng chung hiệu quả hơn nhiều so với việc duyệt qua tất cả các độ lệch không gian, đặc biệt nếu các ma trận nhị phân thưa thớt (ít số 1).*

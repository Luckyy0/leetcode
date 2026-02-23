# Analysis for Positions of Large Groups
# *Phân tích cho bài toán Vị trí của các Nhóm Lớn*

## 1. Problem Essence & Linear Scanning
## *1. Bản chất vấn đề & Duyệt tuyến tính*

### THE CHALLENGE
### *Thách thức*
We need to find contiguous segments of the same character that have a length of at least 3. This is a basic group-finding problem that can be solved by iterating through the string once and identifying the start and end of each unique run of characters.
*Chúng ta cần tìm các đoạn liên tiếp có cùng một ký tự với độ dài ít nhất là 3. Đây là bài toán tìm nhóm cơ bản có thể giải quyết bằng cách duyệt qua chuỗi một lần và xác định điểm bắt đầu, kết thúc của mỗi chuỗi ký tự.*

---

## 2. Strategy: Two-Pointer / Single-Pass Scan
## *2. Chiến lược: Hai con trỏ / Quét một lượt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate with Starting Point:**
    - Use a variable `i` to track the start of the current group.
    - Use a second pointer `j` to find the end of the group (where `s[j] != s[i]`).
    *   **Duyệt với điểm bắt đầu:** Dùng biến `i` theo dõi điểm bắt đầu của nhóm. Dùng con trỏ thứ hai `j` để tìm điểm kết thúc (nơi `s[j] != s[i]`).*

2.  **Calculate Length:**
    - The length of the group is `j - i`.
    *   **Tính độ dài:** Độ dài nhóm là `j - i`.*

3.  **Check Large Condition:**
    - If `j - i >= 3`, store the interval `[i, j - 1]` in the results list.
    *   **Kiểm tra điều kiện nhóm lớn:** Nếu `j - i >= 3`, lưu khoảng `[i, j - 1]` vào danh sách kết quả.*

4.  **Update Starting Point:**
    - Move `i` to `j` and repeat.
    *   **Cập nhật điểm bắt đầu:** Di chuyển `i` đến `j` và lặp lại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new ArrayList<>();
    int n = s.length();
    int i = 0;
    
    while (i < n) {
        int j = i;
        // Move j until the character changes or we reach end of string
        while (j < n && s.charAt(j) == s.charAt(i)) {
            j++;
        }
        
        // Group length is j - i
        if (j - i >= 3) {
            result.add(Arrays.asList(i, j - 1));
        }
        
        i = j; // Move to the next group
    }
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string. Each character is visited once by the pointers.
    *   **Độ phức tạp thời gian:** $O(N)$, vì mỗi ký tự được duyệt qua đúng một lần.*
*   **Space Complexity:** $O(1)$ extra space, excluding the output list.
    *   **Độ phức tạp không gian:** $O(1)$ không tính danh sách kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `s = "abbxxxxzzy"`
1. i=0 ('a'): j moves to 1. Len 1. i=1.
2. i=1 ('b'): j moves to 3. Len 2. i=3.
3. i=3 ('x'): j moves to 7. Len 4 $\ge$ 3. Add `[3, 6]`. i=7.
4. i=7 ('z'): j moves to 9. Len 2. i=9.
5. i=9 ('y'): j moves to 10. Len 1. i=10.
**Result:** `[[3, 6]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple linear scanning with a nested while loop is the cleanest way to implement grouping logic. It prevents index errors and handles the end-of-string condition naturally.
*Duyệt tuyến tính đơn giản với vòng lặp while lồng nhau là cách triển khai logic nhóm sạch sẽ nhất. Nó giúp tránh lỗi chỉ số và xử lý điều kiện kết thúc chuỗi một cách tự nhiên.*

# Analysis for Shortest Distance to a Character
# *Phân tích cho bài toán Khoảng cách ngắn nhất đến một ký tự*

## 1. Problem Essence & Multi-pass Strategy
## *1. Bản chất vấn đề & Chiến lược Duyệt nhiều lượt*

### The Challenge
### *Thách thức*
We need to find the distance to the *nearest* character `c`. For each position, the nearest `c` could be to its left or to its right.
*Chúng ta cần tìm khoảng cách đến ký tự `c` gần nhất. Tại mỗi vị trí, ký tự `c` gần nhất có thể nằm ở bên trái hoặc bên phải của nó.*

---

## 2. Strategy: Two-pass Scanning
## *2. Chiến lược: Quét hai lượt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Left-to-Right Pass:**
    - Traverse the string from left to right.
    - Keep track of the last seen position of `c` (let's call it `prev`).
    - For each position `i`, if `s[i] == c`, update `prev = i`.
    - `answer[i] = i - prev`.
    *   **Lượt từ trái sang phải:** Duyệt chuỗi từ trái sang phải. Theo dõi vị trí cuối cùng thấy `c`. Khoảng cách là `i - prev`.*

2.  **Right-to-Left Pass:**
    - Traverse the string from right to left.
    - Keep track of the last seen position of `c` (let's call it `prev`).
    - For each position `i`, if `s[i] == c`, update `prev = i`.
    - `answer[i] = min(answer[i], prev - i)`.
    *   **Lượt từ phải sang trái:** Duyệt từ phải sang trái. Cập nhật `prev` và chọn giá trị nhỏ nhất giữa khoảng cách hiện tại và `prev - i`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] shortestToChar(String s, char c) {
    int n = s.length();
    int[] ans = new int[n];
    int prev = -10001; // Small enough to not affect min initially
    
    // First pass: Left to Right
    for (int i = 0; i < n; i++) {
        if (s.charAt(i) == c) prev = i;
        ans[i] = i - prev;
    }
    
    // Second pass: Right to Left
    prev = 20002; // Large enough
    for (int i = n - 1; i >= 0; i--) {
        if (s.charAt(i) == c) prev = i;
        ans[i] = Math.min(ans[i], prev - i);
    }
    
    return ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string. We scan the string twice.
    *   **Độ phức tạp thời gian:** $O(N)$, vì ta duyệt chuỗi hai lần.*
*   **Space Complexity:** $O(1)$ extra space (excluding the output array).
    *   **Độ phức tạp không gian:** $O(1)$ không tính mảng kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `s = "loveleetcode", c = 'e'`
1. **L -> R:**
   - Indices of 'e': 3, 5, 6, 11
   - `ans`: [10000, 10001, 10002, 0, 1, 0, 0, 1, 2, 3, 4, 0] (approx)
2. **R -> L:**
   - `ans[11] = 0`
   - `ans[10] = min(4, 11-10) = 1`
   - `ans[9] = min(3, 11-9) = 2`
   - ...
**Final Result:** `[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The two-pass technique is the most standard and efficient way to solve "distance to nearest" problems in 1D arrays or strings.
*Kỹ thuật quét hai lượt là cách tiêu chuẩn và hiệu quả nhất để giải quyết các bài toán "khoảng cách gần nhất" trong mảng 1D hoặc chuỗi.*

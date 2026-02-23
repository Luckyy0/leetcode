# Analysis for Orderly Queue
# *Phân tích cho bài toán Hàng đợi Có Trật tự*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a string `s`, we can move one of the first `k` characters to the end. What is the lexicographically smallest string possible?
*Cho một chuỗi `s`, chúng ta có thể di chuyển một trong `k` ký tự đầu tiên xuống cuối. Chuỗi nhỏ nhất theo thứ tự từ điển có thể đạt được là gì?*

### KEY INSIGHT
### *Nhận xét quan trọng*
- **Case `k = 1`:** We can only move the first character to the end. This is a cyclic shift (rotation). The answer is simply the smallest rotation of the string.
  Ex: "cba" -> "bac" -> "acb" -> "cba". Smallest is "acb".
  *Trường hợp `k = 1`: Ta chỉ có thể di chuyển ký tự đầu tiên xuống cuối. Đây là phép xoay vòng. Đáp án đơn giản là phép xoay nhỏ nhất của chuỗi.*

- **Case `k > 1`:** We can swap adjacent characters (simulating Bubble Sort).
  By moving the 2nd character to the end, then the 1st, we can effectively swap them. With enough moves, we can achieve **any permutation** of the characters.
  The answer is simply the sorted string.
  *Trường hợp `k > 1`: Ta có thể hoán đổi các ký tự liền kề (mô phỏng Bubble Sort). Với đủ số bước, ta có thể đạt được **bất kỳ hoán vị nào** của các ký tự. Đáp án đơn giản là chuỗi đã được sắp xếp.*

---

## 2. Strategy: Branching Logic
## *2. Chiến lược: Logic Phân nhánh*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Check `k`:**
    - If `k > 1`: Sort the string and return it.
    - If `k == 1`: Find the lexicographically smallest rotation.
    *   **Kiểm tra `k`:** Nếu `k > 1`, sắp xếp chuỗi và trả về. Nếu `k == 1`, tìm phép xoay nhỏ nhất.*

2.  **Implementation for `k = 1`:**
    - Iterate `i` from 0 to `n-1`.
    - Construct rotated string: `s.substring(i) + s.substring(0, i)`.
    - Or simply append `s` to itself: `ss = s + s`. Then check all substrings of length `n`.
    - Keep track of the minimum string found.
    *   **Triển khai cho `k = 1`:** Duyệt qua các phép xoay. Theo dõi chuỗi nhỏ nhất tìm thấy.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String orderlyQueue(String s, int k) {
    if (k > 1) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    } else {
        String ans = s;
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (temp.compareTo(ans) < 0) {
                ans = temp;
            }
        }
        return ans;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - If `k > 1`: $O(N \log N)$ for sorting.
    - If `k = 1`: $O(N^2)$ to generate and compare rotations. Since $N \le 1000$, $10^6$ operations is fine.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ hoặc $O(N^2)$.*
*   **Space Complexity:** $O(N)$ to store new strings.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Identifying the distinct behavior between $k=1$ (rotation only) and $k>1$ (full permutation) is the crucial insight that makes this hard problem very simple.
*Việc nhận ra sự khác biệt hành vi giữa $k=1$ (chỉ xoay) và $k>1$ (hoán vị toàn phần) là nhận xét quan trọng khiến bài toán khó này trở nên rất đơn giản.*

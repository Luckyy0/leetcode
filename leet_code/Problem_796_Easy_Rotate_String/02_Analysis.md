# Analysis for Rotate String
# *Phân tích cho bài toán Xoay Chuỗi*

## 1. Problem Essence & Concatenation Trick
## *1. Bản chất vấn đề & Mẹo Nối chuỗi*

### The Challenge
### *Thách thức*
Checking if `goal` is a rotation of `s` involves standard string matching with offsets.
Naive check: Try all N rotations. $O(N^2)$.
*Kiểm tra ngây thơ: Thử tất cả N lần xoay. $O(N^2)$.*

### The Trick
### *Mẹo*
All rotations of `s` are substrings of `s + s`.
e.g. `s="abcde"`, `s+s="abcdeabcde"`.
Substrings of length 5: `abcde`, `bcdea`, `cdeab`, `deabc`, `eabcd`.
These are exactly the rotations.
*Tất cả các lần xoay của `s` là chuỗi con của `s + s`.*

So, just check:
1.  `s.length()` == `goal.length()`
2.  `(s + s).contains(goal)`
*Vậy chỉ cần kiểm tra độ dài và `contains`.*

---

## 2. Strategy: String Concatenation
## *2. Chiến lược: Nối Chuỗi*

### Algorithm
### *Thuật toán*

1.  Check Lengths. If mismatch, false.
2.  Create `bigS = s + s`.
3.  Return `bigS.contains(goal)`.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean rotateString(String s, String goal) {
    return s.length() == goal.length() && (s + s).contains(goal);
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$ usually for `contains` (or $O(N)$ with KMP). Given strings length 100, extremely fast.
    *   **Độ phức tạp thời gian:** $O(N^2)$ hoặc $O(N)$.*
*   **Space Complexity:** $O(N)$ for `s+s`.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**S:** "abcde", **Goal:** "cdeab"
- Lengths 5 == 5. OK.
- S+S: "abcdeabcde".
- Contains "cdeab"? Yes, index 2.
**Result:** True.

**S:** "abcde", **Goal:** "abced"
- S+S: "abcdeabcde".
- Contains "abced"? No.
**Result:** False.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The `s + s` trick is the standard one-line solution.
*Mẹo `s + s` là giải pháp một dòng tiêu chuẩn.*

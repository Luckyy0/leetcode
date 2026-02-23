# Analysis for First Unique Character in a String
# *Phân tích cho bài toán Ký tự Duy nhất Đầu tiên trong Chuỗi*

## 1. Problem Essence & Multi-pass Scanning
## *1. Bản chất vấn đề & Quét nhiều lần*

### The Challenge
### *Thách thức*
Identifying the first character that appears exactly once. A single pass is not enough because we don't know if a character will repeat later until we see the whole string.

### Strategy: Frequency Counting
### *Chiến lược: Đếm Tần suất*
1.  **First Pass:** Traverse the string and count the frequency of each character using an array of size 26.
2.  **Second Pass:** Traverse the string again from left to right.
3.  **Check:** For each character at index $i$, check its count in the frequency array.
4.  **Terminate:** The first character with a count of `1` is the result. Return its index $i$.
5.  If no such character is found, return `-1`.

---

## 2. Approach: Simple Hashing (Array)
## *2. Hướng tiếp cận: Băm đơn giản (Mảng)*

### Logic
### *Logic*
(See above). Using an array `int[26]` is the most efficient way to handle fixed English alphabets.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Efficiency:** Two passes mean $O(2N)$, which simplifies to $O(N)$.
    *Hiệu quả tuyến tính: Hai lần duyệt có nghĩa là $O(2N)$, rút gọn thành $O(N)$.*
*   **Constant Space:** Only $O(1)$ extra space for the 26-integer array.
    *Không gian hằng số: Chỉ tốn $O(1)$ không gian phụ cho mảng 26 số nguyên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "leetcode"`
1. **Pass 1:**
   `l:1, e:3, t:1, c:1, o:1, d:1`
2. **Pass 2:**
   - `i=0 ('l')`: count is 1. Found! Return 0.
Result: 0.

**Input:** `s = "aabb"`
1. **Pass 1:**
   `a:2, b:2`
2. **Pass 2:**
   - `i=0 ('a')`: count is 2. Skip.
   - `i=1 ('a')`: count is 2. Skip.
   - ...
Result: -1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two-pass approach with frequency array.
*Cách tiếp cận hai lần duyệt với mảng tần suất.*
---
*Kẻ cô độc đầu tiên (first unique character) thường ẩn mình sau đám đông. Để tìm thấy họ, ta cần một cái nhìn tổng quát (first pass) để biết ai là ai, rồi sau đó mới quay lại tìm kiếm một cách trình tự (second pass). Sự kiên nhẫn trong quan sát luôn dẫn ta tới câu trả lời đúng.*
The first unique character (first unique character) is often hidden behind the crowd. To find them, we need an overview (first pass) to know who is who, and then go back to search in order (second pass). Patience in observation always leads us to the right answer.

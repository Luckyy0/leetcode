# Analysis for Ransom Note
# *Phân tích cho bài toán Bản tin Tống tiền*

## 1. Problem Essence & Character Counting
## *1. Bản chất vấn đề & Đếm Ký tự*

### The Challenge
### *Thách thức*
Checking if a collection of characters (magazine) has enough "inventory" to fulfill a "request" (ransom note).

### Strategy: Frequency Counter
### *Chiến lược: Bộ đếm Tần suất*
1.  **Inventory Check:** Use an integer array of size 26 (for 'a' to 'z').
2.  **Fill Inventory:** Iterate through the `magazine` string and increment the count for each character.
3.  **Consume Inventory:** Iterate through the `ransomNote` string.
    - For each character, decrement its count in the array.
    - If the count drops below 0, it means the `magazine` lacks that required character. Return `false`.
4.  If the loop finishes, return `true`.

---

## 2. Approach: Frequency Array (Hashing)
## *2. Hướng tiếp cận: Mảng Tần suất (Băm)*

### Logic
### *Logic*
(See above). A simple array is faster and more memory-efficient than a `HashMap` for a fixed set of 26 characters.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N + M) Time:** Linear scan of both strings once.
    *Hiệu quả O(N + M): Quét tuyến tính cả hai chuỗi một lần.*
*   **O(1) Extra Space:** Only a 26-integer array is used, regardless of input size.
    *Không gian phụ O(1): Chỉ sử dụng mảng 26 số nguyên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$.
    *Độ phức tạp thời gian: $O(N + M)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**magazine:** `aab`, **ransomNote:** `aa`
1. Counts: `a=2, b=1`.
2. Check `aa`:
   - First `a`: `count[a]` becomes 1. OK.
   - Second `a`: `count[a]` becomes 0. OK.
Result: True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Array-based frequency counter for fixed alphabet.
*Bộ đếm tần suất dựa trên mảng cho bảng chữ cái cố định.*
---
*Đôi khi yêu cầu (ransom note) có vẻ phức tạp, nhưng tất cả đều bắt nguồn từ những mảnh ghép nhỏ nhất (characters). Nếu chúng ta biết cách kiểm kê nguồn lực (inventory) một cách chính xác, ta sẽ biết mình có đủ khả năng để hoàn thành nhiệm vụ hay không.*
Sometimes requirements (ransom note) seem complex, but they all stem from the smallest pieces (characters). If we know how to inventory our resources correctly, we will know if we have enough ability to complete the task.

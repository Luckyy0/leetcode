# Analysis for Flatten 2D Vector
# *Phân tích cho bài toán Làm phẳng Vector 2D*

## 1. Problem Essence & Iterator Design
## *1. Bản chất vấn đề & Thiết kế Iterator*

### The Challenge
### *Thách thức*
A 2D array is a list of lists. Some inner lists might be empty (e.g., `[[1], [], [2]]`).
The iterator must seamlessly jump over empty inner lists to find the next valid element.
*Mảng 2D là danh sách của các danh sách. Một số danh sách con có thể rỗng. Iterator phải tự động nhảy qua các danh sách rỗng.*

### Strategy
### *Chiến lược*
Maintain two pointers:
1.  `row`: Current inner list index.
2.  `col`: Current element index within `vec[row]`.

The key is the `advance()` or `hasNext()` logic. Whenever called, we must ensure `(row, col)` points to a valid element. If `vec[row]` is exhausted or empty, increment `row` and reset `col` to 0, repeating until valid or end of outer list.

---

## 2. Approach: Two Pointers
## *2. Hướng tiếp cận: Hai con trỏ*

### Logic
### *Logic*
- **Constructor:** Store the 2D array. Call `advanceToNext()` to prepare for the first `next()` or `hasNext()`.
- **advanceToNext():**
    - While `row < vec.length`:
        - If `col < vec[row].length`: We have a valid element. Stop.
        - Else (inner list exhausted or empty): `row++`, `col = 0`.
- **next():**
    - Ensure valid (implicit via `hasNext` contract, but good to check).
    - Get `val = vec[row][col]`.
    - `col++`.
    - `advanceToNext()` (Prepare for future).
    - Return `val`.
- **hasNext():**
    - `advanceToNext()`.
    - Return `row < vec.length`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Lazy Evaluation:** We only seek the next element when asked.
    *Đánh giá lười: Chỉ tìm phần tử tiếp theo khi được yêu cầu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Constructor: $O(1)$.
    - `next()` / `hasNext()`: Amortized $O(1)$. In worst case (many empty lists), we iterate them, but across all calls, we traverse each list once.
    *Độ phức tạp thời gian: Khấu hao O(1).*
*   **Space Complexity:** $O(1)$ (Store reference and pointers).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1, 2], [], [3]]`

1.  **Init:** `row=0, col=0`. `vec[0]` is `[1, 2]`. `col < len`. Valid.
2.  **next():** Return `vec[0][0]` (1). `col` becomes 1. `advance()`: `col(1) < len(2)`. Valid.
3.  **next():** Return `vec[0][1]` (2). `col` becomes 2. `advance()`:
    - `col(2) == len(2)`. `row` becomes 1. `col` becomes 0.
    - `vec[1]` is `[]`. `col(0) == len(0)`. `row` becomes 2. `col` becomes 0.
    - `vec[2]` is `[3]`. `col(0) < len(1)`. Valid. Stop.
4.  **next():** Return `vec[2][0]` (3). `col` becomes 1. `advance()`:
    - `col(1) == len(1)`. `row` becomes 3. `col` becomes 0.
    - `row` out of bounds. Stop.
5.  **hasNext():** `row (3) >= len (3)`. False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Key is `advanceToNext` helper method. Don't check for validity inside `next` without advancing first.
*Chìa khóa là phương thức bổ trợ advancenToNext. Đừng kiểm tra tính hợp lệ trong next mà không tiến lên trước.*
---
*Cuộc sống (2D vector) có những ngày bận rộn (danh sách đầy) và những ngày trống rỗng (danh sách rỗng). Điều quan trọng là biết cách lướt qua những khoảng lặng để tìm thấy ý nghĩa tiếp theo.*
Life (2D vector) has busy days (full lists) and empty days (empty lists). The key is knowing how to skip the silence to find the next meaning.

# Analysis for Different Ways to Add Parentheses
# *Phân tích cho bài toán Các cách thêm dấu ngoặc khác nhau*

## 1. Problem Essence & Divide and Conquer
## *1. Bản chất vấn đề & Chia để trị*

### The Idea
### *Ý tưởng*
Whenever we see an operator (like `+`, `-`, `*`), it splits the expression into two parts: Left and Right.
The total result is: `(Result(Left)) op (Result(Right))`.
Since `Left` and `Right` can also be split further, this suggests a recursive solution.
*Bất cứ khi nào thấy toán tử, nó chia biểu thức thành hai phần: Trái và Phải. Kết quả tổng là `Trái op Phải`. Có thể đệ quy.*

### Memoization
### *Ghi nhớ*
Sub-expressions like `3-4*5` might appear multiple times if the structure allows. Since `expression` length is small (20), recursion with memoization is fast enough.
*Sử dụng ghi nhớ (memoization) để tránh tính toán lại các biểu thức con.*

---

## 2. Approach: Recursive with Memoization
## *2. Hướng tiếp cận: Đệ quy với Ghi nhớ*

### Algorithm
### *Thuật toán*
function `diffWaysToCompute(input)`:
1.  Check `memo`. Return if exists.
2.  `results = []`.
3.  Iterate through `input` string:
    - If char `c` is operator:
        - `part1 = input.substring(0, i)`
        - `part2 = input.substring(i+1)`
        - `leftList = diffWaysToCompute(part1)`
        - `rightList = diffWaysToCompute(part2)`
        - For `l` in `leftList`, `r` in `rightList`:
            - Add `l op r` to `results`.
4.  If `results` is empty (no operator found), it means `input` is just a number. Parse and add to `results`.
5.  Store in `memo` and return.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Flexibility:** Naturally generates all groupings by splitting at every possible operator.
    *Linh hoạt: Tự nhiên tạo ra tất cả các nhóm bằng cách chia tại mọi toán tử có thể.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Catalan number growth, but with N=20 very small. Roughly $O(2^N)$? Actually related to the number of ways to parenthesize (Catalan).
    *Độ phức tạp thời gian: Tăng trưởng theo số Catalan, nhưng N rất nhỏ.*
*   **Space Complexity:** $O(N)$ for stack and memo.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `2-1-1`
1.  Split at first `-`: Left `2`, Right `1-1`.
    - Right `1-1` -> splits at `-` -> Left `1`, Right `1` -> Res `0`.
    - Combine: `2 - 0 = 2`.
2.  Split at second `-`: Left `2-1`, Right `1`.
    - Left `2-1` -> splits at `-` -> Left `2`, Right `1` -> Res `1`.
    - Combine: `1 - 1 = 0`.
Output: `[2, 0]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Divide & Conquer. Use `Map<String, List<Integer>>` for memoization.
*Chia để trị tiêu chuẩn. Dùng Map để ghi nhớ.*
---
*Một vấn đề lớn (biểu thức) thường chỉ là tổng hòa của những vấn đề nhỏ hơn được kết nối bởi những hành động (toán tử).*
A big problem (expression) is often just the sum of smaller problems connected by actions (operators).

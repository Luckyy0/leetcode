# Analysis for Happy Number
# *Phân tích cho bài toán Số hạnh phúc*

## 1. Problem Essence & Cycle Detection
## *1. Bản chất vấn đề & Phát hiện chu kỳ*

### The Limits
### *Các giới hạn*
Will the number grow indefinitely? No.
Consider the largest possible `int` (approx 2 billion).
The maximum sum of squares for a number up to $2,147,483,647$ is for $1,999,999,999$ -> $1^2 + 9 \times 9^2 = 1 + 729 = 730$.
For a 3-digit number like 999, max sum is $3 \times 81 = 243$.
So, any number will eventually fall into a range below 730 (or even smaller, 162). Once in this small range, it must either hit 1 or repeat a number it has seen before.
*Liệu số có tăng vô hạn không? Không. Số lớn nhất có thể là 2 tỷ. Tổng bình phương lớn nhất cho số này chỉ khoảng 730. Vì vậy, mọi số cuối cùng sẽ rơi vào một phạm vi nhỏ. Khi ở trong phạm vi này, nó hoặc sẽ gặp số 1 hoặc lặp lại một số đã thấy trước đó.*

### The Two Outcomes
### *Hai kết quả*
1.  Reach 1 (Success/Happy).
2.  Enter a cycle (Failure/Unhappy).
    - Example cycle: $4 \rightarrow 16 \rightarrow 37 \rightarrow 58 \rightarrow 89 \rightarrow 145 \rightarrow 42 \rightarrow 20 \rightarrow 4$.

---

## 2. Approach: Floyd's Cycle-Finding Algorithm
## *2. Hướng tiếp cận: Thuật toán phát hiện chu kỳ Floyd*

### Logic
### *Logic*
We can treat this sequence generation as a Linked List traversal.
- `next(n)` is the "next node".
- We check for a cycle using two pointers:
    - **Slow:** Computes `next(n)` once per step.
    - **Fast:** Computes `next(next(n))` twice per step.
- If `fast` reaches 1, return true.
- If `slow == fast` (and not 1), we are stuck in a cycle, return false.

*Chúng ta có thể coi việc tạo chuỗi này như duyệt Danh sách liên kết. Sử dụng hai con trỏ: **Chậm** tính `next(n)` một lần mỗi bước, **Nhanh** tính hai lần. Nếu `nhanh` gặp 1, trả về true. Nếu `chậm == nhanh`, bị kẹt trong chu kỳ, trả về false.*

### Alternative: HashSet
### *Cách thay thế: HashSet*
Store every number we encounter in a Set. If we see a number already in the Set, we have a cycle. Return false. If we reach 1, return true.
*Lưu mọi số vào Set. Nếu gặp lại số đã có trong Set, có chu kỳ -> false. Nếu gặp 1 -> true.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Floyd's Algorithm:** Uses $O(1)$ space. This is technically superior if memory is tight, though the "HashSet" approach is perfectly fine here since the cycle range is very small (< 1000 numbers).
    *Thuật toán Floyd: Sử dụng không gian $O(1)$. Về mặt kỹ thuật là vượt trội nếu bộ nhớ hạn hẹp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log n)$. Calculating the next number takes logarithmic time (based on digits). finding the cycle takes constant time because the cycle length is bounded by a small constant.
    *Độ phức tạp thời gian: $O(\log n)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 19`

1.  **Slow:** 19. **Fast:** 19.
2.  **Step 1:**
    - Slow = $1^2 + 9^2 = 82$.
    - Fast = $82 \rightarrow (8^2 + 2^2) = 68$.
3.  **Step 2:**
    - Slow = $68$.
    - Fast = $68 \rightarrow 100 \rightarrow 1$.
4.  **Fast is 1.** Return True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Happy Number is a standard cycle detection problem hidden under a math disguise. Recognizing that the sequence is deterministic makes it solvable via HashSet or Floyd's Algorithm. The constraint analysis (proving it doesn't go to infinity) is the key theoretical insight.
*Số hạnh phúc là một bài toán phát hiện chu kỳ tiêu chuẩn ẩn dưới vỏ bọc toán học. Việc nhận ra chuỗi là tất định giúp giải quyết bằng HashSet hoặc Thuật toán Floyd. Phân tích ràng buộc (chứng minh nó không tăng vô tận) là kiến thức lý thuyết then chốt.*
---
*Hạnh phúc là điểm đến duy nhất (số 1), còn bất hạnh là cứ mãi loanh quanh trong những vòng lặp cũ kỹ.*
Happiness is the unique destination, while unhappiness is wandering endlessly in old loops.

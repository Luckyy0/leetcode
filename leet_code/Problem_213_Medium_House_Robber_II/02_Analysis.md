# Analysis for House Robber II
# *Phân tích cho bài toán Kẻ trộm nhà II*

## 1. Problem Essence & Circular Dependency
## *1. Bản chất vấn đề & Sự phụ thuộc vòng tròn*

### The Cycle Problem
### *Vấn đề chu kỳ*
Unlike House Robber I, the houses here form a circle. The only new constraint is: **House 0 and House N-1 are adjacent.**
You cannot rob *both* the first and the last house.
*Không giống Kẻ trộm nhà I, các ngôi nhà ở đây tạo thành một vòng tròn. Ràng buộc mới duy nhất là: **Nhà 0 và Nhà N-1 là liền kề.** Bạn không thể trộm *cả* nhà đầu tiên và nhà cuối cùng.*

### Breaking the Circle
### *Phá vỡ vòng tròn*
Since we can't rob both, we have two distinct scenarios:
1.  **Scenario A:** Rob houses from index `0` to `n-2` (Ignore the last house).
2.  **Scenario B:** Rob houses from index `1` to `n-1` (Ignore the first house).
*Vì chúng ta không thể chọn cả hai, chúng ta có hai kịch bản riêng biệt: 1. Kịch bản A: Trộm từ `0` đến `n-2` (Bỏ qua nhà cuối). 2. Kịch bản B: Trộm từ `1` đến `n-1` (Bỏ qua nhà đầu).*

The answer is simply `max(solve(0, n-2), solve(1, n-1))`.
*Câu trả lời đơn giản là `max(kết_quả_A, kết_quả_B)`.*

---

## 2. Approach: Reusing House Robber I Logic
## *2. Hướng tiếp cận: Tái sử dụng Logic Kẻ trộm nhà I*

### Logic
### *Logic*
We already have an efficient $O(N)$ solution for a linear street (House Robber I).
We just encapsulate that logic into a helper function `robLinear(int[] nums, int start, int end)`.

Edge Case: If there is only 1 house, rob it (since it has no neighbors in a "circle" of size 1).
*Chúng ta đã có giải pháp $O(N)$ hiệu quả cho phố thẳng. Chỉ cần đóng gói logic đó vào hàm trợ giúp. Trường hợp biên: Nếu chỉ có 1 ngôi nhà, trộm nó.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Decomposition:** By breaking the circular dependency into two linear problems, we reduce a "Hard-looking" problem into two "Medium/Easy" problems.
    *Phân rã: Bằng cách chia sự phụ thuộc vòng tròn thành hai bài toán tuyến tính, ta giảm bài toán "có vẻ Khó" thành hai bài toán "Trung bình/Dễ".*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We run the linear solver twice.
    *Độ phức tạp thời gian: $O(N)$. Chạy giải pháp tuyến tính hai lần.*
*   **Space Complexity:** $O(1)$. Just storing `prev1`, `prev2`.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[2, 3, 2]`

1.  **Case 1 (0 to n-2):** Array `[2, 3]`.
    - Rob 2. Skip 3. Max = 2.
    - Or Skip 2. Rob 3. Max = 3.
    - Result A = 3.
2.  **Case 2 (1 to n-1):** Array `[3, 2]`.
    - Rob 3. Skip 2. Max = 3.
    - Or Skip 3. Rob 2. Max = 2.
    - Result B = 3.

**Result:** `max(3, 3) = 3`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic example of "removing a constraint by verifying all mutually exclusive cases". Whenever you see a circular array problem where index 0 affects index N-1, ask yourself: "What happens if I strictly exclude 0? What happens if I strictly exclude N-1?".
*Đây là ví dụ điển hình của việc "loại bỏ ràng buộc bằng cách kiểm tra tất cả các trường hợp loại trừ lẫn nhau". Bất cứ khi nào bạn thấy bài toán mảng vòng tròn, hãy tự hỏi: "Điều gì xảy ra nếu tôi loại trừ hẳn 0? Điều gì xảy ra nếu tôi loại trừ hẳn N-1?".*
---
*Vòng tròn không có điểm đầu hay điểm cuối, nhưng để giải quyết vấn đề, ta buộc phải cắt nó ra ở đâu đó.*
A circle has no beginning or end, but to solve the problem, we must cut it somewhere.

# Analysis for Next Greater Element II
# *Phân tích cho bài toán Phần tử Lớn hơn Tiếp theo II*

## 1. Problem Essence & Circular Array
## *1. Bản chất vấn đề & Mảng vòng*

### The Challenge
### *Thách thức*
Finding the next greater element in a circular array.
- Standard stack approach works for linear scan.
- Circularity means `nums[i]` can be a candidate for `nums[k]` even if `i < k` (wrapped around).
- Effectively, this is equivalent to searching in `nums + nums` (concatenated array).

### Strategy: Monotonic Stack with Double Pass
### *Chiến lược: Ngăn xếp Đơn điệu với Hai lần Duyệt*

1.  **Virtual Concatenation:** Imagine iterating indices $0$ to $2N-1$. The element at query index $i$ corresponds to `nums[i % N]`.
2.  **Stack Logic:**
    - Standard decreasing stack stores indices.
    - When we encounter `nums[i % N]`, pop all indices `pre` from stack where `nums[pre] < nums[i % N]`.
    - Set `result[pre] = nums[i % N]`.
    - Push `i % N` onto stack (if $i < N$ or simply check if valid candidate later? - actually we only need to fill results for $0..N-1$, so we only really care about updating indices $< N$ that are on stack).
3.  **Result Initialization:** Initialize with `-1`. Indices left on stack after doubled pass have no greater element.

---

## 2. Approach: Loop 2N
## *2. Hướng tiếp cận: Vòng lặp 2N*

### Logic
### *Logic*
(See above). Indices stored in stack should be mod N? No, indices in result array are unique. Actually, we push indices 0..N-1 on stack. When iterating second pass, we check against `nums[i % N]` but we don't necessarily push indices $\ge N$ unless needed for chain reaction?
Actually, pushing indices in second pass is redundant if we only care about finding next greater for first pass. Wait...
Example `[5, 4, 3, 2, 1]`.
Pass 1: Stack `[0, 1, 2, 3, 4]`.
Pass 2: Value at 0 is 5. 5 > 1 (top). Pop 4, res[4]=5. Pop 3...
So we DO need values from second pass to resolve stack. But do we need to *push* indices from second pass?
No, the problem asks for result array of size N. The elements from second pass only act as potential "next greater" values. They don't need their own "next greater" found.
Correct logic: Push index `i % N` only if `i < N`. In second pass ($i \ge N$), just use `nums[i%N]` to pop stack, don't push.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Virtual Expansion:** Using modulo avoids allocating $2N$ array.
    *Mở rộng ảo: Sử dụng modulo tránh cấp phát mảng 2N.*
*   **Monotonic Property:** Efficiently finds next greater element in one go (conceptually).
    *Tính chất đơn điệu: Tìm phần tử lớn hơn tiếp theo hiệu quả trong một lần chạy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element pushed/popped at most once (or twice if logic simplified).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for stack and result.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 1]`
1. Res: `[-1, -1, -1]`. Stack `[]`.
2. $i=0$ (val 1): Push 0. Stack `[0]`.
3. $i=1$ (val 2): `2 > nums[0](1)`. Pop 0. `res[0] = 2`. Push 1. Stack `[1]`.
4. $i=2$ (val 1): `1 < nums[1](2)`. Push 2. Stack `[1, 2]`.
5. $i=3$ (val 1): `1 not > 1`.
6. $i=4$ (val 2): `2 > nums[2](1)`. Pop 2. `res[2] = 2`. `2 not > nums[1](2)`.
7. End. `res` is `[2, -1, 2]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterate $2N$ times using index % N, maintaining a monotonic stack of indices.
*Duyệt $2N$ lần sử dụng chỉ số % N, duy trì ngăn xếp đơn điệu các chỉ số.*
---
*Cuộc sống là một vòng tuần hoàn (circular array). Đôi khi câu trả lời cho hiện tại (next greater) không nằm ở phía trước, mà lại nằm ở sự khởi đầu mới của chu kỳ tiếp theo. Bằng cách nhìn xa hơn giới hạn thông thường (2N iteration), ta có thể tìm thấy những cơ hội mà cái nhìn ngắn hạn bỏ lỡ.*
Life is a cycle (Circular Array). Sometimes the answer for the present (Next Greater) is not ahead, but lies at the new beginning of the next cycle. By looking beyond the usual limits (2N Iteration), we can find opportunities that short -term views missed.

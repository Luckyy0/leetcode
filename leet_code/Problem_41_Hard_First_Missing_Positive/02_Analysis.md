# Analysis for First Missing Positive
# *Phân tích cho bài toán Số Dương Đầu Tiên Còn Thiếu*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Unsorted integer array `nums`. *Mảng số nguyên chưa được sắp xếp `nums`.*
*   **Output:** Smallest missing positive integer. *Số nguyên dương nhỏ nhất còn thiếu.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Time Complexity:** $O(n)$.
*   **Space Complexity:** $O(1)$ auxiliary space.
*   The answer must be in the range $[1, n + 1]$, where $n$ is the length of the array.
*   *Độ phức tạp thời gian: $O(n)$.*
*   *Độ phức tạp không gian: $O(1)$ phụ trợ.*
*   *Câu trả lời phải nằm trong khoảng $[1, n + 1]$, với $n$ là độ dài của mảng.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Index Hashing (Cyclic Sort)
### *Hướng tiếp cận: Băm Chỉ Số (Sắp xếp Vòng lặp)*

*   **Intuition:** Since the answer is within $[1, n + 1]$, we can try to place each number `x` at its target index `x - 1` (e.g., number 1 at index 0, number 2 at index 1). We ignore numbers that are negative or greater than $n$.
*   *Ý tưởng: Vì câu trả lời nằm trong khoảng $[1, n + 1]$, chúng ta có thể thử đặt mỗi số `x` vào chỉ số đích của nó là `x - 1` (ví dụ: số 1 ở chỉ số 0, số 2 ở chỉ số 1). Chúng ta bỏ qua các số âm hoặc lớn hơn $n$.*

*   **Algorithm Steps:**
    1.  Iterate through the array. For each index `i`, while `nums[i]` is in the range $[1, n]$ and it is not at its correct position (`nums[i] != nums[nums[i] - 1]`), swap `nums[i]` with the element at its target index.
    2.  After the transformation, iterate through the array again. The first index `i` where `nums[i] != i + 1` indicates that the number `i + 1` is missing.
    3.  If all elements are at their correct positions, the missing number is `n + 1`.

*   **Complexity:**
    *   Time: $O(n)$. Although there is a `while` loop inside a `for` loop, each swap moves at least one element to its final correct position. There are at most $n$ such swaps.
    *   Space: $O(1)$ as we modify the input array in-place.

### Dry Run
### *Chạy thử*
`nums = [3, 4, -1, 1]`
1.  `i = 0`: `nums[0] = 3`. 3 should be at index 2. Swap `nums[0]` with `nums[2]`. Array: `[-1, 4, 3, 1]`.
2.  `i = 0`: `nums[0] = -1`. Out of range. Move to next.
3.  `i = 1`: `nums[1] = 4`. 4 should be at index 3. Swap `nums[1]` with `nums[3]`. Array: `[-1, 1, 3, 4]`.
4.  `i = 1`: `nums[1] = 1`. 1 should be at index 0. Swap `nums[1]` with `nums[0]`. Array: `[1, -1, 3, 4]`.
5.  Check:
    *   `nums[0] = 1` (Correct)
    *   `nums[1] = -1` (Expected 2, mismatch!)
6.  Result: 2.

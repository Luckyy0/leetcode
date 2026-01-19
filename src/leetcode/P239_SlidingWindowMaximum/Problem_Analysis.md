# 239. Sliding Window Maximum / Giá Trị Lớn Nhất Trong Cửa Sổ Trượt

## Problem Description / Mô tả bài toán
You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.
Bạn được cung cấp một mảng số nguyên `nums`, có một cửa sổ trượt kích thước `k` di chuyển từ bên trái cùng của mảng sang bên phải cùng. Bạn chỉ có thể nhìn thấy `k` số trong cửa sổ. Mỗi lần cửa sổ trượt di chuyển sang phải một vị trí.

Return the max sliding window.
Trả về danh sách các giá trị lớn nhất trong cửa sổ trượt.

### Example 1:
```text
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

### Example 2:
```text
Input: nums = [1], k = 1
Output: [1]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Monotonic Deque / Deque Đơn Điệu
To find the maximum in a sliding window in `O(N)` time, we need a data structure that:
1.  Gives quick access to the current maximum.
2.  Efficiently removes elements that fall out of the window.
3.  Efficiently updates when new elements come in.

A **Deque** (Double Ended Queue) can store **indices** of potential maximums in **decreasing order** of their corresponding values.
- `deque.peekFirst()` always holds the index of the maximum element in the current window.
- When sliding the window:
    - Remove indices from the **front** if they are too old (`index <= i - k`).
    - Remove indices from the **back** if the corresponding value `nums[index] <= nums[i]`. (Why? Because `nums[i]` is newer and larger/equal, so `nums[index]` can never be the maximum again).
    - Add `i` to the **back**.

---

## Analysis / Phân tích

### Approach: Monotonic Deque

**Algorithm**:
1.  Initialize `Deque<Integer>` (storing indices) and `result` array.
2.  Iterate `i` from `0` to `n-1`:
    - Remove out-of-bound indices from front: `while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();`
    - Maintain decreasing order: `while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();`
    - Add current index: `deque.offerLast(i);`
    - If window is full (`i >= k - 1`), record result: `result[i - k + 1] = nums[deque.peekFirst()];`

### Complexity / Độ phức tạp
- **Time**: O(N) - Each element is added to the Deque once and removed at most once.
- **Space**: O(K) - The Deque can hold at most `k` indices elements. (Actually, could be close to N in weird cases like increasing array? No, window constraint purges them, so max K).

---

## Edge Cases / Các trường hợp biên
1.  **k = 1**: Result is copy of `nums`.
2.  **k = n**: Result has 1 element (max of array).
3.  **Increasing array**: Deque has 1 element always (current max).
4.  **Decreasing array**: Deque has up to K elements.

# 162. Find Peak Element / Tìm Phần Tử Đỉnh

## Problem Description / Mô tả bài toán
A peak element is an element that is strictly greater than its neighbors.
Một phần tử đỉnh là một phần tử lớn hơn hẳn các phần tử láng giềng của nó.

Given a **0-indexed** integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to **any of the peaks**.
Cho một mảng số nguyên `nums` **được đánh chỉ số từ 0**, hãy tìm một phần tử đỉnh và trả về chỉ số của nó. Nếu mảng chứa nhiều đỉnh, hãy trả về chỉ số của **bất kỳ đỉnh nào**.

You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
Bạn có thể tưởng tượng rằng `nums[-1] = nums[n] = -∞`. Nói cách khác, một phần tử luôn được coi là lớn hơn hẳn một phần tử láng giềng nằm ngoài mảng.

You must write an algorithm that runs in **O(log n)** time.
Bạn phải viết một thuật toán chạy trong thời gian **O(log n)**.

### Example 1:
```text
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and its index is 2.
```

### Example 2:
```text
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index 1 where the peak element is 2, or index 5 where the peak element is 6.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `nums[i] != nums[i + 1]` for all valid `i`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Why Binary Search? / Tại sao là Tìm kiếm Nhị phân?
Even though the array is not sorted, we can use the property of "climbing" to find a peak in O(log N):
Ngay cả khi mảng không được sắp xếp, chúng ta có thể sử dụng tính chất "leo núi" để tìm một đỉnh trong O(log N):

1.  Consider a random index `mid`. 
2.  If `nums[mid] < nums[mid + 1]`, it means we are in an **uphill** slope. There MUST be a peak to the right (at least the last element could be a peak if it keeps increasing).
3.  If `nums[mid] > nums[mid + 1]`, we are in a **downhill** slope. There MUST be a peak to the left (including `mid` itself).

### Local vs Global / Địa phương vs Toàn cục
Binary search works here because we only need to find **any** peak, not necessarily the highest one.
Tìm kiếm nhị phân hoạt động ở đây vì chúng ta chỉ cần tìm **bất kỳ** đỉnh nào, không nhất thiết phải là đỉnh cao nhất.

---

## Analysis / Phân tích

### Approach: Binary Search (Slope Climb)

**Algorithm**:
1. `left = 0`, `right = nums.length - 1`
2. While `left < right`:
    - `mid = left + (right - left) / 2`
    - If `nums[mid] < nums[mid + 1]`: `left = mid + 1` (move uphill)
    - Else: `right = mid` (current could be peak, or peak is to the left)
3. Return `left`.

### Complexity / Độ phức tạp
- **Time**: O(log N) - binary search.
- **Space**: O(1) - iteration over indices.

---

## Edge Cases / Các trường hợp biên
1.  **Single element array**: `left = 0, right = 0`, loop doesn't run, returns 0. Correct.
2.  **Monotonically increasing**: Returns last index.
3.  **Monotonically decreasing**: Returns first index.
4.  **Peak in the middle**: Returns the index correctly.

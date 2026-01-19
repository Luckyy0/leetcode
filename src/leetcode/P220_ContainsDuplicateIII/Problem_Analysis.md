# 220. Contains Duplicate III / Chứa Phần Tử Trùng Lặp III

## Problem Description / Mô tả bài toán
You are given an integer array `nums` and two integers `indexDiff` and `valueDiff`.
Bạn được cung cấp một mảng số nguyên `nums` và hai số nguyên `indexDiff` và `valueDiff`.

Find a pair of indices `(i, j)` such that:
Tìm một cặp chỉ số `(i, j)` sao cho:
- `i != j`
- `abs(i - j) <= indexDiff`
- `abs(nums[i] - nums[j]) <= valueDiff`

Return `true` if such pair exists, otherwise return `false`.
Trả về `true` nếu cặp như vậy tồn tại, nếu không trả về `false`.

### Example 1:
```text
Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy abs(0 - 3) <= 3 and abs(1 - 1) <= 0.
```

### Example 2:
```text
Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
Explanation: No pair satisfies the conditions.
```

## Constraints / Ràng buộc
- `2 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `1 <= indexDiff <= 10^5`
- `0 <= valueDiff <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bucketing Approach (O(N)) / Phương pháp Chia Thùng
We can think of this as putting numbers into buckets of width `w = valueDiff + 1`.
Chúng ta có thể coi điều này như việc đặt các số vào các thùng có độ rộng `w = valueDiff + 1`.

- `bucketID = nums[i] / w`.
- If two numbers fall into the **same bucket**, their difference is definitely `< w`, i.e., `<= valueDiff`.
- If two numbers fall into **adjacent buckets**, their difference *might* be `<= valueDiff`.
- We maintain a window of size `indexDiff` (similar to P219).
- For each number:
    1.  Compute `bucketID`.
    2.  Check checking `buckets[bucketID]`, `buckets[bucketID - 1]`, `buckets[bucketID + 1]`.
    3.  If found in same bucket: Return true.
    4.  If found in adjacent bucket: Check exact difference.
    5.  Add current to bucket.
    6.  Remove `nums[i - indexDiff]` from its bucket.

**Wait, handling negatives**:
For negative numbers, integer division rounds towards zero, which messes up bucket logic (e.g., -1 and 0 might map to different buckets but should be close).
Correct mapping: `getID(x) = x < 0 ? (x + 1) / w - 1 : x / w`.

### TreeSet Approach (O(N log K))
Use a BST (Treeset) to store window elements.
For `nums[i]`, search for elements in range `[nums[i] - valueDiff, nums[i] + valueDiff]`.
`floor(nums[i] + valueDiff)` or `ceiling(nums[i] - valueDiff)`.

---

## Analysis / Phân tích

### Approach: Bucketing (Bucket Sort Logic)

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Map operations are O(1) on average.
- **Space**: O(k) - Max entries in map is `indexDiff`.

---

## Edge Cases / Các trường hợp biên
1.  **valueDiff = 0**: Duplicate detection.
2.  **Large numbers**: overflow when calculating `num + valueDiff`. Use `long`.
3.  **Negative numbers**: Bucket mapping logic must handle this.
4.  **valueDiff large**: `w` can be large.

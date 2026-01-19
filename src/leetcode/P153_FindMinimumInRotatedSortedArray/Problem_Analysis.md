# 153. Find Minimum in Rotated Sorted Array / Tìm Giá Trị Nhỏ Nhất Trong Mảng Được Xoay

## Problem Description / Mô tả bài toán
Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:
- `[4,5,6,7,0,1,2]` if it was rotated 4 times.
- `[0,1,2,4,5,6,7]` if it was rotated 7 times.

Notice that rotating an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return the minimum element of this array.
Cho mảng `nums` đã được sắp xếp và xoay, chứa các phần tử **duy nhất**, hãy trả về phần tử nhỏ nhất của mảng này.

You must write an algorithm that runs in **O(log n)** time.

### Example 1:
```text
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
```

### Example 2:
```text
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
```

### Example 3:
```text
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- All the integers in `nums` are **unique**.
- `nums` is sorted and rotated between `1` and `n` times.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search in Rotated Arrays / Tìm kiếm Nhị phân trong Mảng được Xoay
Since the array is partially sorted, we can use binary search to reach O(log N).
The minimum element is the only element that is smaller than its previous element (or it's at index 0 if the array is not rotated/rotated N times).

**Key Observation**:
In a sorted rotated array `[left ... mid ... right]`:
- If `nums[mid] > nums[right]`, the minimum must be in the **right** half (`mid + 1` to `right`).
- If `nums[mid] < nums[right]`, the minimum is in the **left** half including `mid` itself (`left` to `mid`).

---

## Analysis / Phân tích

### Approach: Binary Search

**Algorithm**:
1.  Initialize `left = 0`, `right = nums.length - 1`.
2.  While `left < right`:
    - `mid = left + (right - left) / 2`.
    - Compare `nums[mid]` with `nums[right]`.
    - If `nums[mid] > nums[right]`, then `left = mid + 1`.
    - Else, `right = mid`.
3.  Return `nums[left]`.

### Complexity / Độ phức tạp
- **Time**: O(log N) - binary search.
- **Space**: O(1) - iteration over indices.

---

## Edge Cases / Các trường hợp biên
1.  **Array is not rotated** (or rotated N times): `nums[0]` is min.
2.  **Array has 1 element**: `nums[0]` is min.
3.  **Array has 2 elements**: Compare the two.

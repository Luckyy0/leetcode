# 31. Next Permutation / Hoán Vị Tiếp Theo

## Problem Description / Mô tả bài toán
A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.
Một **hoán vị** của một mảng số nguyên là sự sắp xếp các thành viên của nó thành một chuỗi hoặc thứ tự tuyến tính.

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer.
**Hoán vị tiếp theo** của một mảng số nguyên là hoán vị lớn hơn tiếp theo theo thứ tự từ điển của các số nguyên của nó.
- If such an arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
- Nếu sự sắp xếp như vậy không thể thực hiện được, mảng phải được sắp xếp lại theo thứ tự thấp nhất có thể (tức là sắp xếp theo thứ tự tăng dần).

The replacement must be **in-place** and use only constant extra memory.
Việc thay thế phải diễn ra **tại chỗ** và chỉ sử dụng bộ nhớ phụ hằng số.

### Example 1:
```text
Input: nums = [1,2,3]
Output: [1,3,2]
```

### Example 2:
```text
Input: nums = [3,2,1]
Output: [1,2,3]
```

### Example 3:
```text
Input: nums = [1,1,5]
Output: [1,5,1]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`

---

## Analysis / Phân tích

### Approach: Single Pass / Một Lần Duyệt
- **Idea**: To find the next greater permutation, we want to increase the number as little as possible. This means we want to change a digit as far to the right as possible.
- **Ý tưởng**: Để tìm hoán vị lớn hơn tiếp theo, ta muốn tăng số lên ít nhất có thể. Điều này có nghĩa là ta muốn thay đổi một chữ số càng về phía bên phải càng tốt.
- **Algorithm**:
    1.  Find the largest index `k` such that `nums[k] < nums[k + 1]`. If no such index exists, the permutation is the last one (descending). Reverse the whole list.
    2.  Find the largest index `l > k` such that `nums[k] < nums[l]`.
    3.  Swap `nums[k]` and `nums[l]`.
    4.  Reverse the sub-array `nums[k + 1:]` (which is currently descending) to make it ascending (smallest possible suffix).
- **Time Complexity**: O(n). In worst case, two scans of the array.
- **Space Complexity**: O(1). In-place operations.

---

## Edge Cases / Các trường hợp biên
1.  **Sorted Ascending**: `[1, 2, 3]` -> `[1, 3, 2]`. pivot at 1 (`2`), swap with `3`.
2.  **Sorted Descending**: `[3, 2, 1]` -> `[1, 2, 3]`. pivot not found, reverse all.
3.  **Duplicates**: `[1, 1, 5]` -> `[1, 5, 1]`. `[5, 1, 1]` -> `[1, 1, 5]`.

# 80. Remove Duplicates from Sorted Array II / Loại Bỏ Các Phần Tử Trùng Lặp Từ Mảng Đã Sắp Xếp II

## Problem Description / Mô tả bài toán
Given an integer array `nums` sorted in **non-decreasing order**, remove some duplicates **in-place** such that each unique element appears **at most twice**. The relative order of the elements should be kept the same.
Cho một mảng số nguyên `nums` được sắp xếp theo **thứ tự không giảm**, hãy loại bỏ một số phần tử trùng lặp **tại chỗ** sao cho mỗi phần tử duy nhất xuất hiện **tối đa hai lần**. Thứ tự tương đối của các phần tử nên được giữ nguyên.

Return `k` after placing the final result in the first `k` slots of `nums`.
Trả về `k` sau khi đặt kết quả cuối cùng vào `k` vị trí đầu tiên của `nums`.

### Example 1:
```text
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2, and 3 respectively.
```

### Example 2:
```text
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in non-decreasing order.

---

## Analysis / Phân tích

### Approach: Two Pointers / Hai Con Trỏ
- **Idea**: Use a pointer `i` for current write position, and iterate `n` through the array.
- **Ý tưởng**: Sử dụng một con trỏ `i` cho vị trí ghi hiện tại, và duyệt `n` qua mảng.
- **Rule**: We allow a number if it is greater than `nums[i-2]`.
- **Constraint**: Since it's sorted, duplicates are adjacent. If `n > nums[i-2]`, it means `n` is different from the number at `i-2`, or `i` is less than 2 (first two elements always kept).
- **Algorithm**:
    - Init `i` = 0.
    - Iterate `n` in `nums`:
        - If `i < 2` OR `n > nums[i-2]`:
            - `nums[i] = n`
            - `i++`
- **Time Complexity**: O(N).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Length < 3**: Keep all.
2.  **All Same**: Keep first 2. `[1, 1, 1]` -> `[1, 1]`.

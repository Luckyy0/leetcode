# 26. Remove Duplicates from Sorted Array / Xóa Các Phần Tử Trùng Lặp Khỏi Mảng Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only **once**. The relative order of the elements should be kept the same.
Cho một mảng số nguyên `nums` được sắp xếp theo **thứ tự không giảm**, hãy xóa các phần tử trùng lặp **tại chỗ** sao cho mỗi phần tử duy nhất chỉ xuất hiện **một lần**. Thứ tự tương đối của các phần tử nên được giữ nguyên.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.
Vì không thể thay đổi chiều dài của mảng trong một số ngôn ngữ, thay vào đó bạn phải đặt kết quả vào **phần đầu** của mảng `nums`. Trang trọng hơn, nếu có `k` phần tử sau khi xóa các phần tử trùng lặp, thì `k` phần tử đầu tiên của `nums` nên chứa kết quả cuối cùng. Không quan trọng bạn để lại gì sau `k` phần tử đầu tiên.

Return `k` after placing the final result in the first `k` slots of `nums`.
Trả về `k` sau khi đặt kết quả cuối cùng vào `k` vị trí đầu tiên của `nums`.

Do not allocate extra space for another array. You must do this by modifying the input array **in-place** with O(1) extra memory.
Không cấp phát thêm không gian cho mảng khác. Bạn phải thực hiện việc này bằng cách sửa đổi mảng đầu vào **tại chỗ** với O(1) bộ nhớ thêm.

### Example 1:
```text
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

### Example 2:
```text
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order.

---

## Analysis / Phân tích

### Approach: Two Pointers / Hai Con Trỏ
- **Idea**: Use a pointer `insertIndex` to mark where the next unique element should go.
- **Ý tưởng**: Sử dụng một con trỏ `insertIndex` để đánh dấu nơi phần tử duy nhất tiếp theo sẽ được đặt.
    - Start `insertIndex` at 1 (since the first element is always unique).
    - Iterate `i` from 1 to `nums.length - 1`.
    - If `nums[i] != nums[i-1]`, copy `nums[i]` to `nums[insertIndex]` and increment `insertIndex`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Array**: (Constraint says len >= 1).
2.  **No Duplicates**: `[1, 2, 3]` -> `k = 3`.
3.  **All Duplicates**: `[1, 1, 1]` -> `k = 1`.

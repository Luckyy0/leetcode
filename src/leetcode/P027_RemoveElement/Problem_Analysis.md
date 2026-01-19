# 27. Remove Element / Xóa Phần Tử

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` **in-place**. The relative order of the elements may be changed.
Cho một mảng số nguyên `nums` và một số nguyên `val`, hãy xóa tất cả các lần xuất hiện của `val` trong `nums` **tại chỗ**. Thứ tự tương đối của các phần tử có thể thay đổi.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.
Vì không thể thay đổi chiều dài của mảng trong một số ngôn ngữ, thay vào đó bạn phải đặt kết quả vào **phần đầu** của mảng `nums`. Trang trọng hơn, nếu có `k` phần tử sau khi xóa, thì `k` phần tử đầu tiên của `nums` nên chứa kết quả cuối cùng. Không quan trọng bạn để lại gì sau `k` phần tử đầu tiên.

Return `k` after placing the final result in the first `k` slots of `nums`.
Trả về `k` sau khi đặt kết quả cuối cùng vào `k` vị trí đầu tiên của `nums`.

Do not allocate extra space for another array. You must do this by modifying the input array **in-place** with O(1) extra memory.
Không cấp phát thêm không gian cho mảng khác. Bạn phải thực hiện việc này bằng cách sửa đổi mảng đầu vào **tại chỗ** với O(1) bộ nhớ thêm.

### Example 1:
```text
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
```

### Example 2:
```text
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
```

## Constraints / Ràng buộc
- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

---

## Analysis / Phân tích

### Approach: Two Pointers / Hai Con Trỏ
- **Idea**: Use a pointer `k` to track the position of the last non-`val` element.
- **Ý tưởng**: Sử dụng một con trỏ `k` để theo dõi vị trí của phần tử không phải `val` cuối cùng.
    - Iterate `i` through the array.
    - If `nums[i] != val`, put `nums[i]` at `nums[k]` and increment `k`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Array**: `[]` -> `k = 0`.
2.  **All Elements match Val**: `[3,3], 3` -> `k = 0`.
3.  **No Elements match Val**: `[1,2], 3` -> `k = 2`.

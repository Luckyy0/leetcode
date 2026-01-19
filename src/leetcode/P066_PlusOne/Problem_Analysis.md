# 66. Plus One / Cộng Một

## Problem Description / Mô tả bài toán
You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the `i-th` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s.
Bạn được cho một số nguyên lớn được biểu diễn dưới dạng mảng số nguyên `digits`, trong đó mỗi `digits[i]` là chữ số thứ `i` của số nguyên. Các chữ số được sắp xếp từ quan trọng nhất đến ít quan trọng nhất theo thứ tự từ trái sang phải. Số nguyên lớn không chứa bất kỳ số `0` nào ở đầu.

Increment the large integer by one and return the resulting array of digits.
Tăng số nguyên lớn thêm một và trả về mảng các chữ số kết quả.

### Example 1:
```text
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```

### Example 2:
```text
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
```

### Example 3:
```text
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
```

## Constraints / Ràng buộc
- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading 0's.

---

## Analysis / Phân tích

### Approach: Iterate Backwards / Duyệt Ngược
- **Idea**: Add 1 to the last digit. Carry over if needed.
- **Ý tưởng**: Cộng 1 vào chữ số cuối cùng. Nhớ sang hàng tiếp theo nếu cần.
- **Logic**:
    - Loop `i` from `n-1` to `0`.
    - If `digits[i] < 9`, `digits[i]++` and return immediately.
    - Else (it's 9), set `digits[i] = 0` and continue.
    - If loop ends, it means all digits were 9. Create new array of size `n+1`, sets first digit to 1.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1) (or O(n) if resize needed).

---

## Edge Cases / Các trường hợp biên
1.  **Only 9s**: `[9, 9]` -> `[1, 0, 0]`.
2.  **No Carry**: `[1, 2]` -> `[1, 3]`.

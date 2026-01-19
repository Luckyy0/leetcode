# 167. Two Sum II - Input Array Is Sorted / Hai Số Tổng II - Mảng Đầu Vào Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given a **1-indexed** array of integers `numbers` that is already **sorted in non-decreasing order**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.
Cho một mảng các số nguyên `numbers` **bắt đầu từ chỉ số 1** đã được **sắp xếp theo thứ tự không giảm**, hãy tìm hai số sao cho tổng của chúng bằng một số `target` cụ thể. Gọi hai số này là `numbers[index1]` và `numbers[index2]` trong đó `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, added by one as an integer array `[index1, index2]` of length 2.
Trả về các chỉ số của hai số đó, `index1` và `index2`, được cộng thêm 1, dưới dạng một mảng số nguyên `[index1, index2]` có độ dài 2.

The tests are generated such that there is **exactly one solution**. You **may not** use the same element twice.
Các bộ kiểm tra được tạo ra sao cho có **đúng một giải pháp**. Bạn **không được** sử dụng cùng một phần tử hai lần.

Your solution must use only **constant extra space**.
Giải pháp của bạn chỉ được sử dụng **không gian bổ sung hằng số**.

### Example 1:
```text
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
```

### Example 2:
```text
Input: numbers = [2,3,4], target = 6
Output: [1,3]
```

### Example 3:
```text
Input: numbers = [-1,0], target = -1
Output: [1,2]
```

## Constraints / Ràng buộc
- `2 <= numbers.length <= 3 * 10^4`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in **non-decreasing order**.
- `-1000 <= target <= 1000`
- The tests are generated such that there is **exactly one solution**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointer Technique / Kỹ thuật Hai Con Trỏ
Since the array is sorted, we can use two pointers at the ends of the range:
Vì mảng đã được sắp xếp, chúng ta có thể sử dụng hai con trỏ ở hai đầu của phạm vi:

1.  Initialize `left = 0` and `right = n - 1`.
2.  Calculate `sum = numbers[left] + numbers[right]`.
3.  If `sum > target`, we need a smaller sum. Since the array is sorted, only decreasing `right` can yield a smaller sum.
4.  If `sum < target`, we need a larger sum. Increasing `left` will yield a larger sum.
5.  If `sum == target`, we found the solution.

This approach works in **O(N)** time and **O(1)** space.

---

## Analysis / Phân tích

### Approach: Two Pointers (Converging)

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass.
- **Space**: O(1) - only two pointers.

---

## Edge Cases / Các trường hợp biên
1.  **Solution at the very ends**: `2, 7, 11, 15` with `target = 17`.
2.  **Negative numbers**: `-1, 0` with `target = -1`.
3.  **Smallest array size**: `[x, y]` with `target = x + y`.

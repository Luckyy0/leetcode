# 645. Set Mismatch / Sai Lệch Tập Hợp

## Problem Description / Mô tả bài toán
You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number in the set, which results in repetition of one number and loss of another number.
Bạn có một tập hợp các số nguyên `s`, ban đầu chứa tất cả các số từ `1` đến `n`. Thật không may, do một số lỗi, một trong các số trong `s` đã bị trùng lặp với một số khác trong tập hợp, dẫn đến việc lặp lại một số và mất một số khác.

You are given an integer array `nums` representing the data status of this set after the error.
Bạn được cho một mảng số nguyên `nums` đại diện cho trạng thái dữ liệu của tập hợp này sau khi xảy ra lỗi.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
Tìm số xuất hiện hai lần và số bị thiếu và trả về chúng dưới dạng một mảng.

### Example 1:
```text
Input: nums = [1,2,2,4]
Output: [2,3]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cyclic Sort / Index Marking / Math / Sắp Xếp Vòng / Đánh Dấu Chỉ Mục / Toán Học
Approach 1: Marking.
Iterate array. Use `abs(nums[i]) - 1` as index.
Negate value at that index.
If value at index is already negative, then `abs(nums[i])` is the duplicate.
After iteration, the index `i` where `nums[i]` is positive corresponds to the missing number `i + 1`.

Approach 2: Sort (n log n).
Approach 3: Math (Sum and SumSquares).
`Sum(nums) - Sum(1..n) = dup - missing`
`SumSq(nums) - SumSq(1..n) = dup^2 - missing^2 = (dup - missing)(dup + missing)`
Solve system of equations.
Caveat: SumSq can overflow int. Use long.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (Marking) or O(1) (Math).

---

## Analysis / Phân tích

### Approach: Index Marking (In-place)

**Algorithm**:
1.  Iterate to identify duplicate by flipping signs.
2.  Iterate again to find index with positive value (missing).

---

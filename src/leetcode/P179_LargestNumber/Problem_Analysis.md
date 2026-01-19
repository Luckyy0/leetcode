# 179. Largest Number / Số Lớn Nhất

## Problem Description / Mô tả bài toán
Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.
Cho một danh sách các số nguyên không âm `nums`, hãy sắp xếp chúng sao cho chúng tạo thành số lớn nhất và trả về số đó.

Since the result may be very large, you need to return a string instead of an integer.
Vì kết quả có thể rất lớn, bạn cần trả về một chuỗi thay vì một số nguyên.

### Example 1:
```text
Input: nums = [10,2]
Output: "210"
```

### Example 2:
```text
Input: nums = [3,30,34,5,9]
Output: "9534330"
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Comparison / So sánh Tham lam
To form the largest number, we cannot simply sort numbers by their magnitude or their lexicographical order (e.g., `3` vs `30` -> `303` is smaller than `330`).
Để tạo ra số lớn nhất, chúng ta không thể chỉ đơn giản là sắp xếp các số theo độ lớn hoặc theo thứ tự từ điển.

**The Logic**:
For any two numbers `A` and `B`, we decide their order by comparing the concatenated strings:
1.  Form `S1 = A + B`.
2.  Form `S2 = B + A`.
3.  If `S1 > S2`, then `A` should come before `B`.
4.  If `S2 > S1`, then `B` should come before `A`.

This custom comparator ensures that any local ordering choice contributes to the globally optimal largest number.

---

## Analysis / Phân tích

### Approach: Custom Comparator String Sorting

**Algorithm**:
1. Convert all integers in `nums` to `String`.
2. Sort the string array using the custom comparator: `(a, b) -> (b + a).compareTo(a + b)`.
3. Join the sorted strings.
4. **Edge Case**: If the resulting string starts with "0" (e.g., `[0, 0]`), return "0".

### Complexity / Độ phức tạp
- **Time**: O(N log N * L) - where L is the average length of strings (due to string concatenation in comparison).
- **Space**: O(N * L) - to store the strings.

---

## Edge Cases / Các trường hợp biên
1.  **Multiple zeros**: `[0, 0]` should return "0", not "00".
2.  **Numbers with same prefix**: `[3, 30, 34]` -> `34, 3, 30`.
3.  **Large numbers**: Strings handle the size.
4.  **Single element**.

# 137. Single Number II / Số Độc Nhất II

## Problem Description / Mô tả bài toán
Given an integer array `nums` where every element appears **three times** except for one, which appears **exactly once**. Find the single element and return it.
Cho một mảng số nguyên `nums` trong đó mỗi phần tử xuất hiện **ba lần** ngoại trừ một phần tử xuất hiện **đúng một lần**. Hãy tìm phần tử độc nhất đó và trả về.

You must implement a solution with a linear runtime complexity and use only constant extra space.
Bạn phải triển khai một giải pháp với độ phức tạp thời gian tuyến tính và chỉ sử dụng không gian bổ sung hằng số.

### Example 1:
```text
Input: nums = [2,2,3,2]
Output: 3
```

### Example 2:
```text
Input: nums = [0,1,0,1,0,1,99]
Output: 99
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 3 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
- Each element in `nums` appears exactly three times except for one element which appears once.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Counting / Đếm Bit
For each bit position (from 0 to 31):
Đối với mỗi vị trí bit (từ 0 đến 31):
- We can sum up the number of times that bit is set (`1`) across all numbers in the array.
- Since most numbers appear 3 times, their bits will contribute a multiple of 3 to the total count at that position.
- The single number (appearing once) will make the count at a position either `3k` or `3k + 1`.
- If the count is `3k + 1`, it means the single number has that bit set.

### State Machine Approach (Digital Logic) / Tiếp cận Máy Trạng thái (Logic Kỹ thuật số)
We can track the counts of bits mod 3 using two variables `ones` and `twos`:
Chúng ta có thể theo dõi số lượng bit mod 3 bằng hai biến `ones` và `twos`:
- `ones`: bits that have appeared `1` (mod 3) times.
- `twos`: bits that have appeared `2` (mod 3) times.
- When a bit appears for the `3rd` time, it should be removed from both `ones` and `twos`.

---

## Analysis / Phân tích

### Approach: Bitwise State Logic / Logic Trạng thái Bitwise

**Algorithm (Digital Design)**:
```java
ones = (ones ^ num) & ~twos;
twos = (twos ^ num) & ~ones;
```
1.  `ones ^ num`: flips the bit if it exists in `num`.
2.  `& ~twos`: ensures that if a bit is already in `twos` (appeared twice before), it's not added to `ones`.
3.  Similar logic for `twos`.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass.
- **Space**: O(1) - only two variables.

---

## Edge Cases / Các trường hợp biên
1.  **Single number is negative**: Bitwise logic handles sign bits correctly.
2.  **Array length 1**: Handled correctly.
3.  **Zeros in array**: Handled correctly.

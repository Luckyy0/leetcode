# 1073. Adding Two Negabinary Numbers / Cộng Hai Số Negabinary (Cơ số -2)

## Problem Description / Mô tả bài toán
Given two numbers `arr1` and `arr2` in base -2, return the result of adding them in the same format.
The numbers are given as arrays of 0s and 1s, from most significant bit to least significant bit.
Cho hai số `arr1` và `arr2` ở cơ số -2, hãy trả về kết quả của việc cộng chúng ở cùng định dạng.
Các số được đưa ra dưới dạng mảng gồm các số 0 và 1, từ bit quan trọng nhất đến bit ít quan trọng nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Base -2 Arithmetic / Số học Cơ số -2
Similar to standard addition, but carry logic is different.
Value at position `i` is `(-2)^i`.
Sum = `d1 + d2 + carry`.
Result digit `r` and new carry `c`.
Relation: `sum = r + c * (-2)`.
Where `r` must be 0 or 1.

Check cases for `sum`:
- 0: `r=0, c=0`
- 1: `r=1, c=0`
- 2: `r=0, c=-1`  (since `0 + (-1)*(-2) = 2`)
- 3: `r=1, c=-1`  (since `1 + (-1)*(-2) = 3`)
- -1: `r=1, c=1`  (since `1 + 1*(-2) = -1`)
- -2: `r=0, c=1`  (since `0 + 1*(-2) = -2`)

Basically:
`carry = - (sum >> 1)`?
Let's check.
Sum 2: `2/-2 = -1`. `2 % -2 = 0`. Correct.
Sum 3: `3/-2 = -1`. `3 % -2 = 1`. Correct.
Sum -1: `(-1)/-2 = 0`. `(-1)%(-2) = -1`. Remainder is negative. Need adjustment.
Standard division: `-1 = 1 * (-2) + 1`. So `c=1, r=1`.
Logic: `carry = - floor(sum / 2)`? No this is base 2 logic reversed.

Simple Logic:
If `sum >= 2`: `sum -= 2`, `carry = -1`.
If `sum < 0`: `sum += 2`, `carry = 1`.

Algorithm:
1. Iterate from LSB to MSB (pointers at end of arrays).
2. `sum = carry + arr1[i] + arr2[j]`.
3. Calculate bit and carry.
4. Add bit to result.
5. While result has leading zeros (and length > 1), remove them.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Negabinary Carry Logic
Process addition bit by bit from LSB to MSB. The core difference from standard binary addition lies in the carry handling. Since the base is -2, a surplus of 2 at position $i$ ($2 \times (-2)^i$) is equivalent to $-1 \times (-2)^{i+1}$, meaning a carry of -1 to the next position. Conversely, a negative sum implies borrowing, effectively generating a positive carry ($-1 = 1 + 1 \times (-2)$).
Xử lý phép cộng từng bit từ LSB đến MSB. Sự khác biệt cốt lõi so với phép cộng nhị phân tiêu chuẩn nằm ở việc xử lý số dư. Vì cơ số là -2, thặng dư 2 tại vị trí $i$ ($2 \times (-2)^i$) tương đương với $-1 \times (-2)^{i+1}$, nghĩa là số nhớ là -1 cho thặng dư tiếp theo. Ngược lại, tổng âm ngụ ý vay mượn, tạo ra số nhớ dương một cách hiệu quả ($-1 = 1 + 1 \times (-2)$).

---

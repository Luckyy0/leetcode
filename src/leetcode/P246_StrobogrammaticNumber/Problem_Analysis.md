# 246. Strobogrammatic Number / Số Strobogrammatic

## Problem Description / Mô tả bài toán
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Một số strobogrammatic là một số trông giống như nhau khi xoay 180 độ (nhìn ngược từ trên xuống dưới).

Given a string `num` which represents an integer, return `true` if `num` is a **strobogrammatic number**.
Cho một chuỗi `num` đại diện cho một số nguyên, hãy trả về `true` nếu `num` là một **số strobogrammatic**.

### Example 1:
```text
Input: num = "69"
Output: true
```

### Example 2:
```text
Input: num = "88"
Output: true
```

### Example 3:
```text
Input: num = "962"
Output: false
```

## Constraints / Ràng buộc
- `1 <= num.length <= 50`
- `num` consists of only digits.
- `num` does not contain any leading zeros except for zero itself.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Symmetry Map / Bản đồ Đối xứng
We need to check pairs of digits from the outside in.
Valid pairs:
- `0` <-> `0`
- `1` <-> `1`
- `8` <-> `8`
- `6` <-> `9`
- `9` <-> `6`

Any other digit (2, 3, 4, 5, 7) invalidates the property immediately if it appears, unless it maps to something else which isn't possible in this restricted set. Pairs must match specific complements.

**Algorithm**:
1.  Two pointers: `left = 0`, `right = n - 1`.
2.  While `left <= right`:
    - `c1 = num[left]`, `c2 = num[right]`.
    - Check if pair `(c1, c2)` is valid.
    - Loop logic: Map `c1` to its rotated version. If rotated version != `c2`, return false.

---

## Analysis / Phân tích

### Approach: Two Pointers

**Algorithm**:
1.  Define a map or switch logic for rotation.
    - `0->0, 1->1, 6->9, 8->8, 9->6`. Others -> Invalid.
2.  Iterate `left` from 0, `right` from `n-1`.
3.  Compare `map(num[left])` with `num[right]`.

Note strictly: if `left == right` (middle digit), it must map to itself (0, 1, 8 are valid; 6, 9 are valid mappings but only map to each other, so a single 6 or 9 in the middle is invalid because it becomes 9 or 6 upon rotation).
Wait, 6 rotates to 9. If number is "6", rotated is "9". Not same. So middle digit must be 0, 1, or 8.
The pair logic handles this naturally: `map('6') == '9'`. If `left == right`, check `map(c) == c`. '6' != '9', so false. Correct.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single digit**: `0`, `1`, `8` -> True. `6`, `9`, `2`... -> False.
2.  **Even length**: "69" -> True.

# 696. Count Binary Substrings / Đếm các Chuỗi con Nhị phân

## Problem Description / Mô tả bài toán
Give a binary string `s`, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
Cho một chuỗi nhị phân `s`, hãy trả về số lượng các chuỗi con không rỗng có cùng số lượng số 0 và số 1, đồng thời tất cả các số 0 và tất cả các số 1 trong các chuỗi con này được nhóm liên tiếp nhau.

Substrings that occur multiple times are counted the number of times they occur.
Các chuỗi con xuất hiện nhiều lần được tính bằng số lần chúng xuất hiện.

### Example 1:
```text
Input: s = "00110011"
Output: 6
Ex: "0011", "01", "1100", "10", "0011", "01"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Counting Consecutive Groups / Đếm các nhóm Liên tiếp
First, group the consecutive identical characters and count their occurrences.
Đầu tiên, hãy nhóm các ký tự giống nhau liên tiếp và đếm số lần xuất hiện của chúng.

Example: `"0011100"` becomes `[2, 3, 2]`.
For any two adjacent groups with counts `a` and `b`, the number of valid substrings between them is `min(a, b)`.
Đối với bất kỳ hai nhóm liền kề nào có số lượng `a` và `b`, số lượng các chuỗi con hợp lệ giữa chúng là `min(a, b)`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the string.
- **Space**: O(1) if we keep track of current and previous group counts incrementally.

---

## Analysis / Phân tích

### Approach: Linear Pass with Group Tracking
Iterate through the string. Track the count of the previous contiguous character group and the current contiguous character group. Whenever the character changes, add the minimum of the two counts to the total result.
Lặp lại qua chuỗi. Theo dõi số lượng của nhóm ký tự liền kề trước đó và nhóm ký tự liền kề hiện tại. Bất cứ khi nào ký tự thay đổi, hãy thêm giá trị nhỏ nhất của hai số lượng vào tổng kết quả.

---

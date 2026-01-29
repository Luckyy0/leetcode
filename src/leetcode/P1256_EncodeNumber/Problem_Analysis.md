# 1256. Encode Number / Mã hóa Số

## Problem Description / Mô tả bài toán
Given a non-negative integer `num`, return its "encoded" string.
Encoding:
0 -> ""
1 -> "0"
2 -> "1"
3 -> "00"
4 -> "01"
5 -> "10"
6 -> "11"
7 -> "000"

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Representation Shift / Dịch chuyển Biểu diễn Nhị phân
Pattern:
0: len 0
1,2: len 1 ("0", "1")
3,4,5,6: len 2 ("00", "01", "10", "11")
7...: len 3
This is basically binary representation of `num + 1` but without the leading '1'.
Example `num = 2`. `num + 1 = 3` -> `11` binary. Remove leading `1` -> `1`.
Example `num = 5`. `num + 1 = 6` -> `110` binary. Remove leading `1` -> `10`.
Example `num = 0`. `num + 1 = 1` -> `1` binary. Remove leading `1` -> ``.
Why?
Typically binary string of length `L` creates `2^L` values.
Total values with length < `L` is `2^0 + 2^1 + ... + 2^(L-1) = 2^L - 1`.
So values with length `L` start at index `2^L - 1`.
If we have `num`, let length be `L`.
`num` corresponds to offset `num - (2^L - 1)` within the `L`-length binary strings.
Actually mapping `num` to `num+1` aligns indices perfectly with binary natural order starting from 1.
`1 -> 1` (binary 1, remove prefix -> empty? No, 1 is index 1. Wait.)
Indices:
0 -> "" (len 0)
1 -> "0" (len 1)
2 -> "1" (len 1)
3 -> "00" (len 2)
Formula `bin(num + 1).substring(1)` works perfectly.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Binary Trick
The sequence follows the pattern of binary representations. Notice that there are $2^k$ strings of length $k$. The cumulative count of strings with length $< k$ is $2^k - 1$. This means the strings of length $k$ correspond to numbers in the range $[2^k - 1, 2^{k+1} - 2]$. By adding 1 to `num`, we shift the range to $[2^k, 2^{k+1} - 1]$, which corresponds exactly to standard binary numbers of length $k+1$ (all starting with 1). Removing the leading '1' gives the desired encoding.
Dãy tuân theo mẫu biểu diễn nhị phân. Lưu ý rằng có $2^k$ chuỗi có độ dài $k$. Số đếm tích lũy của các chuỗi có độ dài $< k$ là $2^k - 1$. Điều này có nghĩa là các chuỗi có độ dài $k$ tương ứng với các số trong phạm vi $[2^k - 1, 2^{k+1} - 2]$. Bằng cách thêm 1 vào `num`, chúng ta chuyển phạm vi sang $[2^k, 2^{k+1} - 1]$, tương ứng chính xác với các số nhị phân tiêu chuẩn có độ dài $k+1$ (tất cả bắt đầu bằng 1). Xóa số '1' đầu tiên sẽ cho kết quả mã hóa mong muốn.

---

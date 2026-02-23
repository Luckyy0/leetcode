# Result for Valid Word Square
# *Kết quả cho bài toán Hình vuông Từ vựng Hợp lệ*

## Description
## *Mô tả*

Given a sequence of strings, check whether it forms a valid word square.
*Cho một dãy các chuỗi, hãy kiểm tra xem nó có tạo thành một hình vuông từ vựng hợp lệ hay không.*

A sequence of strings forms a valid word square if the $k^{th}$ row and $k^{th}$ column read the exact same string, where $0 \le k < \max(\text{numRows, numColumns})$.
*Một dãy các chuỗi tạo thành một hình vuông từ vựng hợp lệ nếu hàng thứ $k$ và cột thứ $k$ đọc ra cùng một chuỗi văn bản, trong đó $0 \le k < \max(\text{numRows, numColumns})$.*

**Note:**
1. The number of words is between 1 and 500.
2. The length of each word is between 1 and 500.
3. Each word contains only lowercase English alphabet `a-z`.

## Example 1:
## *Ví dụ 1:*

**Input:**
```
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
```
**Output:** `true`
**Explanation:**
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crmy".
The 4th row and 4th column both read "dtye".
Therefore, it is a valid word square.

## Example 2:
## *Ví dụ 2:*

**Input:**
```
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
```
**Output:** `true`
**Explanation:**
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crm".
The 4th row and 4th column both read "dt".
Therefore, it is a valid word square.

## Example 3:
## *Ví dụ 3:*

**Input:**
```
[
  "ball",
  "area",
  "read",
  "lady"
]
```
**Output:** `false`
**Explanation:**
The 3rd row reads "read" while the 3rd column reads "lead".
Therefore, it is NOT a valid word square.

# Result for Word Squares
# *Kết quả cho bài toán Hình vuông Từ vựng*

## Description
## *Mô tả*

Given a set of words **(without duplicates)**, find all combinations of words that form a valid word square.
*Cho một tập hợp các từ **(không trùng lặp)**, hãy tìm tất cả các tổ hợp từ tạo thành một hình vuông từ vựng hợp lệ.*

A sequence of words forms a valid word square if the $k^{th}$ row and $k^{th}$ column read the exact same string, where $0 \le k < \max(\text{numRows, numColumns})$.
*Một dãy các từ tạo thành một hình vuông từ vựng hợp lệ nếu hàng thứ $k$ và cột thứ $k$ đọc ra cùng một chuỗi văn bản, trong đó $0 \le k < \max(\text{numRows, numColumns})$.*

All words in the sequence must have the **same length**.
*Tất cả các từ trong dãy phải có **cùng độ dài**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `["area","lead","wall","lady","ball"]`
**Output:**
```
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]
```

## Example 2:
## *Ví dụ 2:*

**Input:** `["abat","baba","atan","atal"]`
**Output:**
```
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]
```

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 1000`
*   `1 <= words[i].length <= 5`
*   All `words[i]` have the same length.
*   `words[i]` consists of only lowercase English letters.
*   All `words[i]` are unique.

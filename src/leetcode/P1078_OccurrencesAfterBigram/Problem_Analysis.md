# 1078. Occurrences After Bigram / Số lần Xuất hiện Sau Bigram

## Problem Description / Mô tả bài toán
Given two strings `first` and `second`, consider the bigram `first second`. Return all the words `third` such that `first second third` occurs in the text `text`, where `first`, `second`, and `third` are single words.
Cho hai chuỗi `first` và `second`, hãy xem xét bigram `first second`. Trả về tất cả các từ `third` sao cho `first second third` xuất hiện trong văn bản `text`, trong đó `first`, `second` và `third` là các từ đơn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Split and Loop / Tách Chuỗi và Vòng lặp
Algorithm:
1. Split `text` by spaces into words array.
2. Iterate `i` from 0 to `words.length - 3`.
3. If `words[i].equals(first) && words[i+1].equals(second)`, add `words[i+2]` to result.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Token Scan
Tokenize the input text into a sequence of words. Iterate through the token list to identify consecutive occurrences of the `first` and `second` target words. Whenever this specific bigram pattern is found, capture the immediately following word as a valid "third" component.
Token hóa văn bản đầu vào thành một chuỗi các từ. Lặp qua danh sách token để xác định các lần xuất hiện liên tiếp của các từ mục tiêu `first` và `second`. Bất cứ khi nào mẫu bigram cụ thể này được tìm thấy, hãy lấy từ ngay sau đó làm thành phần "thứ ba" hợp lệ.

---

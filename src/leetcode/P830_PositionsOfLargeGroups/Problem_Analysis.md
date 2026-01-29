# 830. Positions of Large Groups / Vị trí của các Nhóm Lớn

## Problem Description / Mô tả bài toán
In a string `s` of lowercase letters, these letters form groups of consecutive identical characters.
Trong một chuỗi `s` gồm các chữ cái thường, các chữ cái này tạo thành các nhóm ký tự giống nhau liên tiếp.

A group is considered **large** if it has 3 or more characters. Return the intervals `[start, end]` of every large group, sorted by their start positions.
Một nhóm được coi là **lớn** nếu nó có từ 3 ký tự trở lên. Trả về các khoảng `[start, end]` của mọi nhóm lớn, được sắp xếp theo vị trí bắt đầu của chúng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two-Pointer Linear Scan / Quét Tuyến tính Hai con trỏ
This is a standard grouping problem.
Đây là một bài toán phân nhóm tiêu chuẩn.

Algorithm:
1. Initialize `i = 0`.
2. While `i < n`:
   - Initialize `j = i`.
   - While `j < n` and `s[j] == s[i]`, increment `j`.
   - If `j - i >= 3`, the interval `[i, j - 1]` is a large group.
   - Set `i = j`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) beyond the result storage.

---

## Analysis / Phân tích

### Approach: Segment Identification
Scan the string and detect boundaries between different characters. Whenever a segment spans at least three identical characters, record its indices.
Quét chuỗi và phát hiện ranh giới giữa các ký tự khác nhau. Bất cứ khi nào một đoạn kéo dài ít nhất ba ký tự giống nhau, hãy ghi lại các chỉ số của nó.

---

# 1100. Find K-Length Substrings With No Repeated Characters / Tìm Chuỗi con Độ dài K Không có Ký tự Lặp lại

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, return the number of substrings of length `k` with no repeated characters.
Cho một chuỗi `s` và một số nguyên `k`, hãy trả về số lượng các chuỗi con có độ dài `k` không có ký tự lặp lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
1. If `k > 26`, return 0 (Pigeonhole principle).
2. Maintain a window of size `k`.
3. Count frequencies in window.
4. If map/set size == k (or all counts are 1), valid.

Algorithm:
- Use array `count[26]`.
- Keep track of `repeats` (number of chars with count > 1).
- Initialize window [0, k-1].
- Update `repeats`. Check if `repeats == 0`.
- Slide window: adding new char, removing old char. Update `repeats`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Window Uniqueness Check
Use a sliding window of fixed length `k`. Maintain frequency counts of characters within the window. Track how many characters have duplicates (`count > 1`). If no characters are duplicated, the current window is valid. Slide one character at a time, updating counts and duplicate statuses efficiently.
Sử dụng cửa sổ trượt có độ dài cố định `k`. Duy trì số lượng tần suất của các ký tự trong cửa sổ. Theo dõi xem có bao nhiêu ký tự có bản sao (`count > 1`). Nếu không có ký tự nào bị trùng lặp, cửa sổ hiện tại là hợp lệ. Trượt từng ký tự một, cập nhật số lượng và trạng thái trùng lặp một cách hiệu quả.

---

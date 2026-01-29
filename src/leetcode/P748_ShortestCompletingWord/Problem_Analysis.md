# 748. Shortest Completing Word / Từ Hoàn thành Ngắn nhất

## Problem Description / Mô tả bài toán
Given a string `licensePlate` and an array of strings `words`, find the shortest completing word in `words`.
Cho một chuỗi `licensePlate` và một mảng các chuỗi `words`, hãy tìm từ hoàn thành ngắn nhất trong `words`.

A completing word is a word that contains all the letters in `licensePlate`. Ignore numbers and spaces. The comparison is case-insensitive.
Một từ hoàn thành là một từ chứa tất cả các chữ cái trong `licensePlate`. Bỏ qua số và dấu cách. Việc so sánh không phân biệt chữ hoa chữ thường.

If there are multiple shortest completing words, return the first one that occurs in `words`.
Nếu có nhiều từ hoàn thành ngắn nhất, hãy trả về từ đầu tiên xuất hiện trong `words`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Counting / Đếm Tần suất
1. Count frequencies of all lowercase English letters in the `licensePlate`.
2. For each word in `words`:
   - Count its character frequencies.
   - Check if the word satisfies all counts required by the `licensePlate`.
   - Update the shortest valid word.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N is number of words and L is average length.
- **Space**: O(1) for frequency counts (26 characters).

---

## Analysis / Phân tích

### Approach: Character Requirements Check
Extract necessary letters from the license plate. Then, for each candidate word, verify if its character "budget" covers the license plate "cost".
Trích xuất các chữ cái cần thiết từ biển số xe. Sau đó, đối với mỗi từ ứng cử viên, hãy xác minh xem "nguồn lực" ký tự của nó có bao phủ "chi phí" của biển số xe hay không.

---

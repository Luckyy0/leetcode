# 819. Most Common Word / Từ Thông dụng nhất

## Problem Description / Mô tả bài toán
Given a string `paragraph` and a list of `banned` words, return the most frequent word that is **not** in the banned list.
Cho một chuỗi `paragraph` và một danh sách các từ bị cấm (`banned`), hãy trả về từ xuất hiện thường xuyên nhất **không** nằm trong danh sách bị cấm.

The paragraph is not case sensitive and ignore punctuation.
Đoạn văn không phân biệt chữ hoa chữ thường và bỏ qua các dấu câu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Cleaning and Hashing / Làm sạch Chuỗi và Hashing
1. Convert the entire paragraph to lowercase and replace all punctuation with spaces.
2. Split the paragraph into words using whitespace.
3. Use a `HashSet` to store banned words for fast lookup.
4. Use a `HashMap` to count free word frequencies.
5. Track the maximum frequency.

### Complexity / Độ phức tạp
- **Time**: O(P + B) where P is length of paragraph and B is total characters in banned words.
- **Space**: O(P + B).

---

## Analysis / Phân tích

### Approach: Frequency Counting after Normalization
Normalize the input by removing noise (punctuation, case). Then, count valid candidates and select the winner.
Chuẩn hóa đầu vào bằng cách loại bỏ nhiễu (dấu câu, kiểu chữ). Sau đó, đếm các ứng viên hợp lệ và chọn từ thắng cuộc.

---

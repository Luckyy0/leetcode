# 917. Reverse Only Letters / Chỉ Đảo ngược Chữ cái

## Problem Description / Mô tả bài toán
Given a string `s`, reverse the string according to the following rules:
Cho một chuỗi `s`, hãy đảo ngược chuỗi theo các quy tắc sau:
- All the characters that are not English letters remain in the same position.
Tất cả các ký tự không phải là chữ cái tiếng Anh vẫn ở nguyên vị trí cũ.
- All the English letters should be reversed in their positions.
Tất cả các chữ cái tiếng Anh phải được đảo ngược vị trí của chúng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
Algorithm:
1. Initialize `left = 0`, `right = n - 1`.
2. While `left < right`:
   - If `s[left]` is not a letter, `left++`.
   - Else if `s[right]` is not a letter, `right--`.
   - Else: swap `s[left]` and `s[right]`, then `left++, right--`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for result string builder/char array.

---

## Analysis / Phân tích

### Approach: Selective Symmetry
Navigate from both ends toward the middle. Non-alphabetic characters act as stationary anchors, while letters are exchanged to form a mirrored sequence within the available slots.
Điều hướng từ cả hai đầu về phía giữa. Các ký tự không phải chữ cái đóng vai trò là các mốc cố định, trong khi các chữ cái được trao đổi để tạo thành một chuỗi đối xứng trong các vị trí có sẵn.

---

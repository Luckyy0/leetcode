# 717. 1-bit and 2-bit Characters / Ký tự 1-bit và 2-bit

## Problem Description / Mô tả bài toán
We have two special characters:
- The first character can be represented by one bit `0`.
- The second character can be represented by two bits (`10` or `11`).

Given a binary array `bits` that ends with `0`, return `true` if the last character must be a one-bit character.
Chúng ta có hai loại ký tự đặc biệt:
- Ký tự thứ nhất có thể được biểu diễn bằng một bit `0`.
- Ký tự thứ hai có thể được biểu diễn bằng hai bit (`10` hoặc `11`).

Cho một mảng nhị phân `bits` kết thúc bằng `0`, hãy trả về `true` nếu ký tự cuối cùng bắt buộc phải là ký tự một bit.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Traversal / Duyệt Tham lam
The encoding is prefix-free in a sense: if we see a `1`, it **must** be the start of a 2-bit character. If we see a `0`, it **must** be a 1-bit character.
Mã hóa này về một mặt nào đó là không có tiền tố: nếu chúng ta thấy số `1`, nó **phải** là điểm bắt đầu của một ký tự 2 bit. Nếu chúng ta thấy số `0`, nó **phải** là một ký tự 1 bit.

Algorithm:
1. Start at `index = 0`.
2. If `bits[index] == 1`, skip two indices (`index += 2`).
3. If `bits[index] == 0`, skip one index (`index += 1`).
4. At the end, check if the index stopped at `n - 1`. If it did, the last character was a 1-bit character.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `bits`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Greedy Scan
Sweep through the array from the beginning. The logic of jumping 1 or 2 steps mimics the decoding process perfectly. If you land exactly on the last element, that element was decoded as a 1-bit character.
Quét qua mảng từ đầu. Logic nhảy 1 hoặc 2 bước mô phỏng hoàn hảo quá trình giải mã. Nếu bạn dừng lại đúng ở phần tử cuối cùng, phần tử đó đã được giải mã dưới dạng ký tự 1 bit.

---

# 1010. Pairs of Songs With Total Durations Divisible by 60 / Các cặp Bài hát có Tổng thời lượng Chia hết cho 60

## Problem Description / Mô tả bài toán
Given a list of song durations `time`, return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Cho một danh sách thời lượng bài hát `time`, hãy trả về số lượng các cặp bài hát mà tổng thời lượng của chúng tính bằng giây chia hết cho 60.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modulo Arithmetic and Frequency Array / Số học Modulo và Mảng Tần suất
Problem boils down to Two Sum with modulo.
Bài toán quy về bài toán Hai Tổng (Two Sum) với modulo.
`(a + b) % 60 == 0` implies `(a % 60 + b % 60) % 60 == 0`.

Algorithm:
1. Maintain `count` array of size 60.
2. For each `t`:
   - `remainder = t % 60`.
   - `target = (60 - remainder) % 60`.
   - `res += count[target]`.
   - `count[remainder]++`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (size 60).

---

## Analysis / Phân tích

### Approach: Modular Complement Matching
Reduce each duration to its remainder modulo 60. For each song, identify the required complementary remainder that sums to a multiple of 60. Using a frequency map of past remainders allows for O(1) pairing.
Giảm mỗi thời lượng xuống số dư modulo 60 của nó. Đối với mỗi bài hát, xác định số dư bổ sung cần thiết để tổng là bội số của 60. Sử dụng bản đồ tần suất của các số dư trong quá khứ cho phép ghép cặp trong O(1).

---

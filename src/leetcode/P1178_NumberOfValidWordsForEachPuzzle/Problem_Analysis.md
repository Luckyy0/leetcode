# 1178. Number of Valid Words for Each Puzzle / Số lượng Từ Hợp lệ cho Mỗi Câu đố

## Problem Description / Mô tả bài toán
Find number of valid words for each puzzle.
Criteria:
- Word contains first letter of puzzle.
- Every letter in word is in puzzle.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask / Submask Enumeration / Bitmask / Liệt kê Mặt nạ con
Words and puzzles only depend on set of characters.
1. Convert each word to bitmask. Filter words with > 7 unique chars (puzzle limit). Also store count of each mask.
   - `wordCounts[mask]`.
2. For each puzzle:
   - `puzzleMask` (7 bits max set, but actual mask is 26-bit int).
   - `firstCharBit`.
   - Iterate all submasks of `puzzleMask`.
   - If submask contains `firstCharBit`, add `wordCounts[submask]` to result.
   - Submask enumeration: `s = m; s = (s-1) & m;`.

### Complexity / Độ phức tạp
- **Time**: O(W * L + P * 2^7). Puzzles have length 7, so 2^7 = 128. Very fast.
- **Space**: O(2^26) or using HashMap. HashMap is better since words are sparse.

---

## Analysis / Phân tích

### Approach: Submask Iteration
Represent each word as a bitmask (ignoring duplicates within the word). Store the frequency of each word mask in a map. For each puzzle, generate its bitmask. Since the puzzle length is small (7), we can iterate through all submasks of the puzzle mask (up to $2^7 = 128$). A valid word mask must be a submask of the puzzle mask and must include the "first letter" bit. Sum the precomputed frequencies of all valid submasks.
Biểu diễn mỗi từ dưới dạng bitmask (bỏ qua các bản sao trong từ). Lưu trữ tần suất của mỗi mặt nạ từ trong một bản đồ. Đối với mỗi câu đố, hãy tạo bitmask của nó. Vì độ dài câu đố nhỏ (7), chúng ta có thể lặp qua tất cả các mặt nạ con của mặt nạ câu đố (tối đa $2^7 = 128$). Một mặt nạ từ hợp lệ phải là một mặt nạ con của mặt nạ câu đố và phải bao gồm bit "chữ cái đầu tiên". Tổng hợp các tần suất đã tính toán trước của tất cả các mặt nạ con hợp lệ.

---

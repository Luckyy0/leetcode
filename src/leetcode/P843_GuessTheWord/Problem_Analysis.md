# 843. Guess the Word / Đoán Từ

## Problem Description / Mô tả bài toán
This is an interactive problem. You are given a list of unique strings `wordlist` where all words are 6 letters long, and one word is the secret word.
Đây là một bài toán tương tác. Bạn được cho một danh sách các chuỗi duy nhất `wordlist` trong đó tất cả các từ đều dài 6 chữ cái và một từ là từ bí mật.

You can call `master.guess(word)` which returns how many letters in your guess match the secret word in both character and position.
Bạn có thể gọi `master.guess(word)`, hàm này trả về số lượng chữ cái trong dự đoán của bạn khớp với từ bí mật về cả ký tự và vị trí.

Find the secret word within 10 guesses.
Tìm từ bí mật trong vòng 10 lần dự đoán.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Minimax or Random Sampling / Minimax hoặc Lấy mẫu ngẫu nhiên
Every time you guess a word `W` and get a score `S`, the secret word **must** have exactly `S` matches with `W`.
Mỗi khi bạn đoán một từ `W` và nhận được điểm `S`, từ bí mật **phải** có đúng `S` ký tự khớp với `W`.

Algorithm:
1. Pick a candidate word (can be random or heuristic).
2. Call `guess(word)` to get result `S`.
3. Filter the `wordlist`: keep only words that have exactly `S` matches with the guessed word.
4. Repeat.

Heuristic (Minimax):
- Pick the word that minimizes the maximum possible size of the remaining candidates for any result from 0 to 6.

### Complexity / Độ phức tạp
- **Time**: O(Guesses * WordlistLength).
- **Space**: O(WordlistLength).

---

## Analysis / Phân tích

### Approach: Possibility Pruning
Each guess provides a constraint. By iteratively removing words from the list that no longer satisfy the accumulated constraints, we narrow down the search space until only the secret word (or a few candidates) remains.
Mỗi lần đoán cung cấp một ràng buộc. Bằng cách lặp lại việc loại bỏ các từ khỏi danh sách không còn thỏa mãn các ràng buộc tích lũy, chúng ta thu hẹp không gian tìm kiếm cho đến khi chỉ còn từ bí mật (hoặc một vài ứng cử viên).

---

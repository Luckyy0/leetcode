# 676. Implement Magic Dictionary / Triển khai Từ điển Ma thuật

## Problem Description / Mô tả bài toán
Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
Thiết kế một cấu trúc dữ liệu được khởi tạo bằng một danh sách các từ khác nhau. Cung cấp một chuỗi, bạn nên xác định xem mình có thể thay đổi đúng một ký tự trong chuỗi này để khớp với bất kỳ từ nào trong cấu trúc dữ liệu hay không.

Implement the `MagicDictionary` class:
- `void buildDict(String[] dictionary)`: Initializes the object with the `dictionary`.
- `boolean search(String searchWord)`: Returns `true` if you can change exactly one character in `searchWord` to match any word in the dictionary, and `false` otherwise.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie or HashMap / Trie hoặc HashMap
We can store the dictionary in a Trie or simply a list of strings grouped by length.
Chúng ta có thể lưu trữ từ điển trong một Trie hoặc đơn giản là một danh sách các chuỗi được nhóm theo độ dài.

For `search(word)`, we check every word in the dictionary of the same length and count the number of differing characters. If exactly one character differs, return `true`.
Đối với `search(word)`, chúng ta kiểm tra mọi từ trong từ điển có cùng độ dài và đếm số lượng ký tự khác nhau. Nếu chính xác một ký tự khác nhau, hãy trả về `true`.

### Complexity / Độ phức tạp
- **Time**: `buildDict`: O(N*L), `search`: O(K*L) where K is number of words of length L.
- **Space**: O(N*L).

---

## Analysis / Phân tích

### Approach: Word Comparison
Since the dictionary constraints are usually manageable, comparing words of equal length is simple and efficient.
Vì các ràng buộc của từ điển thường có thể quản lý được, việc so sánh các từ có độ dài bằng nhau là đơn giản và hiệu quả.

---

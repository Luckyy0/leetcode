# 1032. Stream of Characters / Luồng Ký tự

## Problem Description / Mô tả bài toán
Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings `words`.
Thiết kế một thuật toán chấp nhận một luồng ký tự và kiểm tra xem một hậu tố của các ký tự này có phải là một chuỗi trong mảng chuỗi `words` đã cho hay không.

Methods:
- `StreamChecker(words)`: Constructor.
- `query(letter)`: Returns true if some suffix of the stream matches any word.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Trie / Trie Ngược
We are checking suffixes. Suffixes of a stream are prefixes of the reversed stream.
Chúng ta đang kiểm tra các hậu tố. Hậu tố của một luồng là tiền tố của luồng bị đảo ngược.

Algorithm:
1. Build a Trie containing all reversed words from `words`.
2. Maintain a buffer (StringBuilder) of characters received so far.
3. `query(letter)`:
   - Append `letter` to buffer.
   - Walk down the Trie from the end of the buffer backwards.
   - If we reach a node marked `isEnd`, return true.
   - If we find no path, stop.

### Complexity / Độ phức tạp
- **Time**: `query` is O(W) where W is max length of words.
- **Space**: O(Total Chars).

---

## Analysis / Phân tích

### Approach: Suffix-to-Prefix Transformation
Since queries arrive one by one and we care about the end of the stream, looking backwards is natural. By storing the dictionary words in reverse order within a Trie, checking if the current stream suffix matches a dictionary word becomes equivalent to traversing the Trie from the root using the stream's characters in reverse order (LIFO).
Vì các truy vấn đến từng cái một và chúng ta quan tâm đến phần cuối của luồng, việc nhìn ngược là tự nhiên. Bằng cách lưu trữ các từ trong từ điển theo thứ tự ngược trong một Trie, việc kiểm tra xem hậu tố luồng hiện tại có khớp với một từ trong từ điển hay không trở nên tương đương với việc duyệt Trie từ gốc bằng cách sử dụng các ký tự của luồng theo thứ tự ngược (LIFO).

---

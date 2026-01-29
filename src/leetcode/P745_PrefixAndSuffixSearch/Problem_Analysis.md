# 745. Prefix and Suffix Search / Tìm kiếm Tiền tố và Hậu tố

## Problem Description / Mô tả bài toán
Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.
Thiết kế một từ điển đặc biệt với một số từ cho phép tìm kiếm các từ đó bằng một tiền tố và một hậu tố.

Implement the `WordFilter` class:
- `WordFilter(string[] words)` Initializes the object with the `words` in the dictionary.
- `int f(string prefix, string suffix)` Returns the index of the word which has the prefix `prefix` and the suffix `suffix`. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combined Trie / Trie kết hợp
A simple Trie for prefix and another for suffix would be hard to intersect efficiently.
Một Trie đơn giản cho tiền tố và một Trie khác cho hậu tố sẽ khó giao nhau một cách hiệu quả.

Trick: Store the word in a Trie as `suffix + "{" + word`.
For example, for word `apple`, store all versions:
- `e{apple`
- `le{apple`
- `ple{apple`
- ...
- `apple{apple`

Querying `f(prefix, suffix)` becomes searching for the prefix `suffix + "{" + prefix`.
Truy vấn `f(prefix, suffix)` trở thành việc tìm kiếm tiền tố `suffix + "{" + prefix`.

Note: `'{'` is the character after `'z'`.

### Complexity / Độ phức tạp
- **Time**: `Constructor`: O(N * L^2) where L is avg length. `f`: O(PrefixLen + SuffixLen).
- **Space**: O(N * L^2).

---

## Analysis / Phân tích

### Approach: Wrapped Trie
By prepending every suffix to the word, we transform the dual search into a single prefix search in a trie. Each node in the trie stores the maximum index encountered during insertion.
Bằng cách thêm mọi hậu tố vào trước từ đó, chúng ta chuyển đổi việc tìm kiếm kép thành một lần tìm kiếm tiền tố duy nhất trong trie. Mỗi nút trong trie lưu trữ chỉ số tối đa gặp phải trong khi chèn.

---

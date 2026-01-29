# 820. Short Encoding of Words / Mã hóa Ngắn gọn các Từ

## Problem Description / Mô tả bài toán
A valid encoding of an array of `words` is a reference string `s` and a list of indices such that:
Mã hóa hợp lệ của một mảng các từ `words` là một chuỗi tham chiếu `s` và một danh sách các chỉ số sao cho:

- For each index `i`, the substring of `s` starting from `indices[i]` up to the next `#` character is equal to `words[i]`.
Đối với mỗi chỉ số `i`, chuỗi con của `s` bắt đầu từ `indices[i]` cho đến ký tự `#` tiếp theo bằng `words[i]`.

Return the length of the shortest reference string `s` possible.
Trả về độ dài của chuỗi tham chiếu `s` ngắn nhất có thể.

### Example:
`words = ["time", "me", "bell"]`
Possible encoding: `s = "time#bell#"`, `indices = [0, 2, 5]`.
Length = 10.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Suffix Redundancy / Sự dư thừa Hậu tố
A word `w1` can be encoded within the same `#` section as `w2` if `w1` is a suffix of `w2`.
Một từ `w1` có thể được mã hóa trong cùng một phần `#` với `w2` nếu `w1` là hậu tố của `w2`.

Algorithm:
1. Deduplicate the words using a `Set`.
2. For each word, generate all its proper suffixes and remove them from the `Set`.
3. The remaining words in the `Set` are the ones that need to be explicitly written in the reference string.
4. Result = `sum(length(word) + 1)` for all words in the `Set`.

Alternatively:
- Insert all words into a **Trie** in reversed order.
- The number of leaves in the Trie determines the number of separated sections.
- Root-to-leaf path lengths determine the total count.

### Complexity / Độ phức tạp
- **Time**: O(Σ L_i^2) for the Set-based approach.
- **Space**: O(Σ L_i).

---

## Analysis / Phân tích

### Approach: Set-based Suffix Pruning
Identify words that are contained within others as suffixes. By removing these redundant words, we are left with only the "tails" of the encoding, plus the necessary `#` separators.
Xác định các từ nằm trong các từ khác dưới dạng hậu tố. Bằng cách loại bỏ các từ dư thừa này, chúng ta chỉ còn lại "phần đuôi" của mã hóa, cộng với các dấu phân cách `#` cần thiết.

---

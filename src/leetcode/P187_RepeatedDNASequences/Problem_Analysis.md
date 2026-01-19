# 187. Repeated DNA Sequences / Chuỗi DNA Lặp lại

## Problem Description / Mô tả bài toán
The DNA sequence is composed of a series of nucleotides abbreviated as `'A'`, `'C'`, `'G'`, and `'T'`.
Chuỗi DNA được cấu tạo từ một loạt các nucleotide viết tắt là `'A'`, `'C'`, `'G'`, và `'T'`.

- For example, `"ACGTACGTACGT"` is a DNA sequence.
- Ví dụ, `"ACGTACGTACGT"` là một chuỗi DNA.

When studying DNA, it is useful to identify repeated sequences within the DNA.
Khi nghiên cứu DNA, việc xác định các chuỗi lặp lại trong DNA là rất hữu ích.

Given a string `s` that represents a DNA sequence, return all the **10-letter-long** sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in **any order**.
Cho một chuỗi `s` đại diện cho một chuỗi DNA, hãy trả về tất cả các chuỗi (chuỗi con) **dài 10 ký tự** xuất hiện nhiều hơn một lần trong một phân tử DNA. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
```

### Example 2:
```text
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s[i]` is either `'A'`, `'C'`, `'G'`, or `'T'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Substring Hashing / Hashing Chuỗi con
To find repeated substrings of a fixed length `L = 10`, we can slide a window across the string and store the seen sequences.
Để tìm các chuỗi con lặp lại có độ dài cố định `L = 10`, chúng ta có thể trượt một cửa sổ qua chuỗi và lưu trữ các chuỗi đã thấy.

**Approach**:
1.  Use a `HashSet` named `seen` to store all substrings of length 10.
2.  Use another `HashSet` named `repeated` to store substrings encountered more than once.
3.  Iterate from `i = 0` to `n - 10`.
4.  Extract substring `s[i...i+10]`.
5.  If it's already in `seen`, add it to `repeated`.
6.  Else, add it to `seen`.

---

## Analysis / Phân tích

### Approach: Hash Set with Sliding Window

**Complexity / Độ phức tạp**:
- **Time**: O((N - L) * L) - where N is string length and L = 10. For each window, we perform a substring operation and hashing which take O(L).
- **Space**: O((N - L) * L) - to store the substrings in the set.

---

## Edge Cases / Các trường hợp biên
1.  **s.length < 10**: Return empty list.
2.  **All identical characters**: e.g., "AAAAAAAAAAAAA".
3.  **No repeats**: Empty list.
4.  **Overlap**: "AAAAAAAAAAA" has two "AAAAAAAAAA" sequences that overlap. These should be counted if they appear at different indices.

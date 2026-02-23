# Result for Repeated DNA Sequences
# *Kết quả cho bài toán Chuỗi DNA lặp lại*

## Description
## *Mô tả*

The DNA sequence is composed of a series of nucleotides abbreviated as `'A'`, `'C'`, `'G'`, and `'T'`.
*Chuỗi DNA bao gồm một loạt các nucleotide được viết tắt là `'A'`, `'C'`, `'G'`, và `'T'`.*

*   For example, `"ACGTACGTACGT"` is a DNA sequence.
    *Ví dụ, `"ACGTACGTACGT"` là một chuỗi DNA.*

When studying DNA, it is useful to identify repeated sequences within the DNA.
*Khi nghiên cứu DNA, việc xác định các chuỗi lặp lại trong DNA là rất hữu ích.*

Given a string `s` that represents a DNA sequence, return all the **10-letter-long** sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in **any order**.
*Cho một chuỗi `s` đại diện cho một chuỗi DNA, hãy trả về tất cả các chuỗi (chuỗi con) **dài 10 ký tự** xuất hiện nhiều hơn một lần trong phân tử DNA. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`
**Output:** `["AAAAACCCCC","CCCCCAAAAA"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "AAAAAAAAAAAAA"`
**Output:** `["AAAAAAAAAA"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is either `'A'`, `'C'`, `'G'`, or `'T'`.

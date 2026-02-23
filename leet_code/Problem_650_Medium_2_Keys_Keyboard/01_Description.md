# Result for 2 Keys Keyboard
# *Kết quả cho bài toán Bàn phím 2 Phím*

## Description
## *Mô tả*

There is only one character `'A'` on the screen of a notepad. You can perform one of two operations on this notepad for each step:
*Chỉ có duy nhất một ký tự `'A'` trên màn hình của một trình soạn thảo văn bản. Bạn có thể thực hiện một trong hai thao tác trên trình soạn thảo này cho mỗi bước:*

1.  **Copy All:** You can copy all the characters present on the screen (a partial copy is not allowed).
    *   *  **Sao chép Tất cả (Copy All):** Bạn có thể sao chép tất cả các ký tự hiện có trên màn hình (không cho phép sao chép một phần).*
2.  **Paste:** You can paste the characters which are copied last time.
    *   *  **Dán (Paste):** Bạn có thể dán các ký tự đã được sao chép lần trước đó.*

Given an integer `n`, return the minimum number of steps to get **exactly** `n` `'A'` on the screen.
*Cho một số nguyên `n`, hãy trả về số bước tối thiểu để có được **chính xác** `n` chữ `'A'` trên màn hình.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3
**Output:** 3
**Explanation:** Initially, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`

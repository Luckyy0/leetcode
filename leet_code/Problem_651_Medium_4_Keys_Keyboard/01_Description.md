# Result for 4 Keys Keyboard
# *Kết quả cho bài toán Bàn phím 4 Phím*

## Description
## *Mô tả*

Imagine you have a special keyboard with the following four keys:
*Hãy tưởng tượng bạn có một bàn phím đặc biệt với bốn phím sau:*
1.  **Key 1: (A):** Print one 'A' on screen.
    *   *  **Phím 1: (A):** In một chữ 'A' lên màn hình.*
2.  **Key 2: (Ctrl-A):** Select the whole screen.
    *   *  **Phím 2: (Ctrl-A):** Chọn toàn bộ màn hình.*
3.  **Key 3: (Ctrl-C):** Copy selection to buffer.
    *   *  **Phím 3: (Ctrl-C):** Sao chép phần đã chọn vào bộ đệm.*
4.  **Key 4: (Ctrl-V):** Print buffer on screen appending it after what has already been printed.
    *   *  **Phím 4: (Ctrl-V):** Dán bộ đệm lên màn hình sau những gì đã in.*

Now, you can only press the keyboard for `n` times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
*Bây giờ, bạn chỉ có thể nhấn bàn phím `n` lần (với bốn phím trên), hãy tìm số lượng chữ 'A' tối đa bạn có thể in trên màn hình.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3
**Output:** 3
**Explanation:** We can at most get 3 A's on screen by pressing following key sequence:
A, A, A

## Example 2:
## *Ví dụ 2:*

**Input:** n = 7
**Output:** 9
**Explanation:** We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl-A, Ctrl-C, Ctrl-V, Ctrl-V

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 50`

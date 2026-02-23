# Result for Stickers to Spell Word
# *Kết quả cho bài toán Nhãn dán để tạo Từ*

## Description
## *Mô tả*

We are given `n` different types of `stickers`, each sticker has a lowercase English word on it.
*Chúng ta được cho `n` loại `stickers` (nhãn dán) khác nhau, mỗi nhãn dán có một từ tiếng Anh viết thường trên đó.*

You would like to spell out the given `target` string by cutting individual letters from your collection of stickers and rearranging them. You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
*Bạn muốn tạo ra chuỗi `target` cho trước bằng cách cắt từng chữ cái từ bộ sưu tập nhãn dán của mình và sắp xếp lại chúng. Bạn có thể sử dụng mỗi nhãn dán nhiều lần nếu muốn, và bạn có số lượng vô hạn cho mỗi loại nhãn dán.*

Return the minimum number of stickers that you need to spell out `target`. If the task is impossible, return `-1`.
*Hãy trả về số lượng nhãn dán tối thiểu bạn cần để tạo ra `target`. Nếu nhiệm vụ là bất khả thi, hãy trả về `-1`.*

**Note:** In all test cases, all words were chosen from the 26 lowercase English letters.
*Lưu ý: Trong tất cả các trường hợp kiểm thử, tất cả các từ đều được chọn từ 26 chữ cái tiếng Anh viết thường.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stickers = ["with","example","science"], target = "thehat"
**Output:** 3
**Explanation:**
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary.

## Example 2:
## *Ví dụ 2:*

**Input:** stickers = ["notice","possible"], target = "basicbasic"
**Output:** -1
**Explanation:**
We cannot form the target "basicbasic" from the letters on the given stickers.

---

## Constraints:
## *Ràng buộc:*

*   `n == stickers.length`
*   `1 <= n <= 50`
*   `1 <= stickers[i].length <= 10`
*   `1 <= target.length <= 15`
*   `stickers[i]` and `target` consist of lowercase English letters.

# Longest String Chain
# *Chuỗi Ký Tự Nối Tiếp Dài Nhất*

## Description
## *Mô tả*

You are given an array of `words` where each word consists of lowercase English letters.
*Bạn được cấp một mảng chứa hàng loạt các từ ngữ `words`, trong đó mỗi từ đều chỉ bao gồm các chữ cái tiếng Anh in thường.*

`wordA` is a **predecessor** of `wordB` if and only if we can insert **exactly one** letter anywhere in `wordA` without changing the order of the other characters to make it equal to `wordB`.
*Từ `wordA` được vinh danh là **Tiền Bối** (predecessor) của từ `wordB` NẾU VÀ CHỈ NẾU ta có thể lén lút nạo nhét vào chèn bổ sung **Đúng Duy Nhất** một chữ cái lạ lọt thỏm vào bất cứ ngóc ngách khe hở nào của `wordA` (miễn là không đảo lộn lộn phèo trật tự vốn dĩ của các chữ cái gốc) để bóp nặn ra Y Xì Khuôn Mặt Giống Hệt Thằng `wordB`.*

- For example, `"abc"` is a predecessor of `"abac"`, while `"cba"` is not a predecessor of `"bcad"`.
- *Ví dụ, `"abc"` Dẫn Đầu là Tiền bối của `"abac"` (vì nhét chữ `a` vào giữa `b` và `c`). Còn `"cba"` thì Móm 100% không thể là Tiền Bối của `"bcad"` vì chỏi trật tự quá nhiều.*

A **word chain** is a sequence of words `[word_1, word_2, ..., word_k]` with `k >= 1`, where `word_1` is a predecessor of `word_2`, `word_2` is a predecessor of `word_3`, and so on. A single word is trivially a word chain with `k == 1`.
*Khái niệm **Chuỗi Liên Tục Từ Ngữ** (word chain) là một cái băng dắt dây tròng trọc dằng nhằng kiểu như `[word_1, word_2, ..., word_k]` với độ dắt dây `k >= 1`, mà trong đó thằng lớp dưới `word_1` phải là Tiền Bối của thằng lớp trên `word_2`, và vắt lên nữa thằng `word_2` lại là Tiền Mốc Cũ của Sếp `word_3`, v.v... Nếu chỉ đứng Cô Độc 1 thân 1 mình 1 mẩu Cắt Chữ thì Vẫn Miễn Cưỡng Mang Tiếng Chuỗi dài Tròn Trĩnh với `k == 1`.*

Return the **length** of the longest possible word chain with words chosen from the given list of `words`.
*Mệnh Lệnh Xét Dài: Hãy rạch Cọc Tìm Ra Số Lượng Mứt Độ Dài ($K$) Dài Nhất Khủng Chiếu Đỉnh Cao Nhất có thể Khâu Vá Bắt Móc được Một Cái Dây Sinh Trưởng Liên Hoàn thông qua Khối Lô các Hạt Giống `words` có sẵn trên Kho Từ.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["a","b","ba","bca","bda","bdca"]
**Output:** 4
**Explanation:** 
*Giải thích:*
One of the longest word chains is ["a","ba","bda","bdca"].
*Một trong những hệ sinh thái dây xích Tiền Giao Hậu Khớp Cao Cấp Khủng dài nhất rút Móc nối ra là: Khởi nguyên ["a"], Tiến Hóa Tới ["ba"], Gắn Nhét Thấy ["bda"], Nở Nứt Thành ["bdca"]. Dài trọn 4 Chóp Cột Nốc!*

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
**Output:** 5
**Explanation:** 
*Giải thích:*
All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
*Không chừa Thằng Hàng Xóm Nào. Chơi Bỏ Túi Tất Cả Từng Thằng Một Xỏ Thẳng 1 Phát Dọc Luôn Móng Chuỗi: Dài Quét Trọn K=5! ["xb" -> "xbc" -> "cxbc" -> "pcxbc" -> "pcxbcf"].*

## Example 3:
## *Ví dụ 3:*

**Input:** words = ["abcd","dbqca"]
**Output:** 1
**Explanation:** 
*Giải thích:*
The trivial word chain ["abcd"] is one of the longest word chains.
*Không có Lấy Một Phép Nhiệm Màu Tiền Hậu nào Vắt chéo 2 Tòa này cả. Rơi Vãi Chỏng Chơ Cô Mộng Tự Nằm 1 Mình. Chuỗi Đơn Tẻ Max bằng 1 ("abcd" hoặc "dbqca").*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 1000`
*   `1 <= words[i].length <= 16`
*   `words[i]` only consists of lowercase English letters.
*   *Mỗi hạt tử `words[i]` đều Thuần Quần Chúng Dân Cày Tiếng Anh In Thường.*

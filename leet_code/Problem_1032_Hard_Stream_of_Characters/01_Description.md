# Result for Stream of Characters
# *Kết quả cho bài toán Luồng Ký Tự*

## Description
## *Mô tả*

Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings `words`.
*Hãy thiết kế một thuật toán có khả năng tiếp nhận một luồng các ký tự (một dòng chảy vào liên tục từng chữ một) và kiểm tra xem liệu phần **hậu tố** (phần đuôi) của những ký tự vừa chảy vào này có khớp trùng với bất kỳ từ nào nằm trong một mảng danh sách cho trước `words` hay không.*

For example, if `words = ["abc", "xyz"]` and the stream added the four characters (one by one) `'a'`, `'x'`, `'y'`, and `'z'`, your algorithm should detect that the suffix `"xyz"` of the characters `"axyz"` matches `"xyz"` from `words`.
*Ví dụ, nếu `words = ["abc", "xyz"]` và luồng ký tự vừa đổ vào 4 chữ cái (rót từng giọt một) lần lượt là `'a'`, `'x'`, `'y'`, và cuối cùng là `'z'` (thành cuộn "axyz"). Thuật toán của bạn phải nhạy bén phát hiện ra cái đuôi hạ màn `"xyz"` của mớ hỗn độn `"axyz"` vừa khít y đúc với từ `"xyz"` trong bộ từ điển `words`.*

Implement the `StreamChecker` class:
*Bắt tay xây dựng lớp `StreamChecker`:*
*   `StreamChecker(String[] words)` Initializes the object with the strings array `words`.
    *   *Hàm khởi tạo nhét vô mảng `words` làm bộ từ điển nền móng.*
*   `boolean query(char letter)` Accepts a new character from the stream and returns `true` if any non-empty suffix from the stream forms a word that is in `words`.
    *   *`query(char letter)` Rót thêm một giọt ký tự `letter` mới vào luồng chảy và trả về cờ `true` nếu bất kỳ khúc đuôi (hậu tố) nào của cái vũng nước lũ này tạo ra được một từ vựng nằm trong quyển `words`.*

---

## Example 1:
## *Ví dụ 1:*

**Input**
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
**Output**
[null, false, false, false, true, false, true, false, false, false, false, false, true]

**Explanation:** 
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
*Giải thích: Đưa cho hệ thống danh thiếp 3 chữ: "cd", "f", "kl". Rót a, b, c $\to$ (đuôi a, ab, abc.. không khớp). Rót tiếp d (cái đuôi lúc này tạo thành "abcd", móc ngược ra cái đuôi gốc "cd" trùng mảng! Trả true!). Rót e (đuôi "abcde" sai). Rót f (đuôi "abcdef", lòi đuôi con "f" đúng mảng! Trả true!). Rót g,h,i,j,k $\to$ trễ. Góc chót rót l $\to$ nắp ráp đuôi tột cùng "kl" $\to$ True!.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 2000`
*   `1 <= words[i].length <= 200`
*   `words[i]` consists of lowercase English letters.
*   `letter` is a lowercase English letter.
*   At most `4 * 10^4` calls will be made to `query`.

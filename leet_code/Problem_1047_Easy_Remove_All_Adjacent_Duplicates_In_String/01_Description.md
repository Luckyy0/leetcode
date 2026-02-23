# Remove All Adjacent Duplicates In String
# *Xóa Tất Cả Các Ký Tự Lặp Cạnh Nhau Trong Chuỗi*

## Description
## *Mô tả*

You are given a string `s` consisting of lowercase English letters. A **duplicate removal** consists of choosing two adjacent and equal letters and removing them.
*Bạn được cấp một chuỗi ký tự `s` chỉ bao gồm các chữ cái tiếng Anh in thường. Một phép **xóa lặp** được định nghĩa là việc chọn ra hai chữ cái y hệt nhau đứng sát cạnh nhau và thẳng tay loại bỏ chúng khỏi chuỗi.*

We repeatedly make duplicate removals on `s` until we no longer can.
*Chúng ta cứ liên tục thực hiện hành động xóa lặp chồng chéo này trên chuỗi `s` cho đến khi không còn cặp đôi nào để xóa được nữa thì thôi.*

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
*Hãy trả về chuỗi cuối cùng sót lại sau khi tất cả các phép xóa lặp đã được thực thi. Toán học đã chứng minh được rằng đáp án cuối cùng sinh ra là độc nhất thiết lập.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abbaca"
**Output:** "ca"
**Explanation:** 
*Giải thích:*
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move. 
*Ví dụ, trong chuỗi gốc "abbaca", chúng ta tóm sống cặp cạ cứng "bb" do hai chữ cái này giống nhau y đúc và đứng kè kè nhau. Đây cũng là nước đi khả thi duy nhất ban đầu.*
The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
*Hệ quả sau nhát chém cặp "bb" là hai khúc hai đầu chập lại tạo thành chuỗi "aaca". Kéo theo đó, cặp anh em "aa" giáp mặt nhau tự kích nổ nốt. Khói tan rã, chuỗi cuối cùng xót lại là "ca".*

## Example 2:
## *Ví dụ 2:*

**Input:** s = "azxxzy"
**Output:** "ay"
**Explanation:** 
*Giải thích:*
"azxxzy" -> "azzy" -> "ay"
*Ban đầu "azxxzy" nổ cặp giữa "xx" thành "azzy". "azzy" tiếp tục nhồi nổ cặp giữa "zz" tiêu biến trơ trọi lại "ay".*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of lowercase English letters.
*   *Chuỗi `s` chỉ chứa duy nhất các chữ cái tiếng Anh in thường.*

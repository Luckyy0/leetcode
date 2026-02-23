# Result for Camelcase Matching
# *Kết quả cho bài toán Khớp mẫu Kiểu lạc đà (Camelcase)*

## Description
## *Mô tả*

Given an array of strings `queries` and a string `pattern`, return a boolean array `answer` where `answer[i]` is `true` if `queries[i]` matches `pattern`, and `false` otherwise.
*Bạn được cung cấp một mảng chuỗi các câu hỏi `queries` và một chuỗi mẫu `pattern`. Đi tìm mảng logic `answer` trả về `true` cho nhãn `queries[i]` nếu nó khớp y chang mẫu `pattern`, sai lệch nhét `false`.*

A query word `queries[i]` matches `pattern` if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
*Một từ hỏi `queries[i]` được cho là **khớp** với mẫu `pattern` nếu bạn có khả năng chèn chắp vá **chỉ được phép xài các chữ cái tiếng Anh in thường** vào trong lòng cái mẫu để biến mẫu ấy giống tuyệt đối y đúc khối ghép tạo thành từ hỏi kia. Chèn vô hạn cũng được, nhồi góc nào tùy thích, nhưng chèn xong phải y như đúc!*

---

## Example 1:
## *Ví dụ 1:*

**Input:** queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
**Output:** [true,false,true,true,false]
**Explanation:** 
"FooBar" can be generated like this: "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this: "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this: "F" + "rame" + "B" + "uffer".
*Giải thích: Chữ "FB" mẫu đút chữ thường "oo" + "ar" (vô giữa, đằng sau mặt chữ) sẽ ra "FooBar" hợp pháp! Ngược lại "FooBarTest" hắt hủi vì nó dư thừa ký tự IN HOA "T" chẳng chịu gộp vô khuôn.*

## Example 2:
## *Ví dụ 2:*

**Input:** queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
**Output:** [true,false,true,false,false]
**Explanation:** 
"FooBar" can be generated like this: "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this: "Fo" + "ot" + "Ba" + "ll".
*Giải thích: Quá nhạy bén, FrameBuffer ("Fr" vs "Fo") gẫy bánh khớp ngay từ cái nụ o đầu, văng khỏi cuộc chơi.*

## Example 3:
## *Ví dụ 3:*

**Input:** queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
**Output:** [false,true,false,false,false]
**Explanation:** 
"FooBarTest" can be generated like this: "Fo" + "o" + "Ba" + "r" + "T" + "est".
*Giải thích: Lần này mẫu lòi ra chữ Hoa "T", chỉ có 1 ứng viên "FooBarTest" mới gánh được đủ bộ chữ Hoa kiêu kỳ ấy.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= pattern.length, queries.length <= 100`
*   `1 <= queries[i].length <= 100`
*   `queries[i]` and `pattern` consist of English letters.

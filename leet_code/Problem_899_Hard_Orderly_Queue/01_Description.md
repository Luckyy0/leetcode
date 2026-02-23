# Result for Orderly Queue
# *Kết quả cho bài toán Hàng đợi Có Trật tự*

## Description
## *Mô tả*

You are given a string `s` and an integer `k`. You can choose one of the first `k` letters of `s` and append it at the end of the string.
*Bạn được cho một chuỗi `s` và một số nguyên `k`. Bạn có thể chọn một trong `k` chữ cái đầu tiên của `s` và thêm nó vào cuối chuỗi.*

Return *the lexicographically smallest string you can could have after applying the mentioned step any number of moves*.
*Hãy trả về *chuỗi nhỏ nhất theo thứ tự từ điển mà bạn có thể có sau khi thực hiện bước được đề cập bất kỳ số lần nào*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "cba", k = 1
**Output:** "acb"
**Explanation:** 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the string "acb".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "baaca", k = 3
**Output:** "aaabc"
**Explanation:** 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the string "aaabc".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= s.length <= 1000`
*   `s` consist of lowercase English letters.

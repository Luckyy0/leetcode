# Result for Split Concatenated Strings
# *Kết quả cho bài toán Cắt Chuỗi Liên kết*

## Description
## *Mô tả*

You are given an array of strings `strs`. You could concatenate these strings together into a loop, where for each string, you could choose to reverse it or not. Among all the possible loops, you need to find the lexicographically largest string after cutting the loop, which will make the looped string become a regular one.
*Bạn được cho một mảng các chuỗi `strs`. Bạn có thể liên kết các chuỗi này lại thành một vòng lặp, trong đó đối với mỗi chuỗi, bạn có thể chọn đảo ngược nó hoặc không. Trong tất cả các vòng lặp có thể có, bạn cần tìm chuỗi lớn nhất theo thứ tự từ điển sau khi cắt vòng lặp, điều này sẽ làm cho chuỗi vòng lặp trở thành một chuỗi bình thường.*

Specifically, to find the lexicographically largest string, you should experience two phases:
*Cụ thể, để tìm chuỗi lớn nhất theo thứ tự từ điển, bạn nên trải qua hai giai đoạn:*

1.  Concatenate all strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
    *Liên kết tất cả các chuỗi thành một vòng lặp, trong đó bạn có thể đảo ngược một số chuỗi hoặc không và nối chúng theo đúng thứ tự đã cho.*
2.  Cut and make one breakpoint in any place of the loop, which can make the looped string into a regular one starting from the character at the cutpoint.
    *Cắt và tạo một điểm ngắt ở bất kỳ vị trí nào của vòng lặp, điều này có thể làm cho chuỗi vòng lặp thành một chuỗi bình thường bắt đầu từ ký tự tại điểm cắt.*

And your job is to find the lexicographically largest one among all the possible regular strings.
*Và nhiệm vụ của bạn là tìm chuỗi lớn nhất theo thứ tự từ điển trong tất cả các chuỗi bình thường có thể có.*

## Example 1:
## *Ví dụ 1:*

**Input:** `strs = ["abc","xyz"]`
**Output:** `"zyxcba"`
**Explanation:** You can get the loop "abcxyz", "abczyx", "cbaxyz", "cbazyx" in which "cbazyx" has the max lexicographical order.
Then you can cut the loop at any character, like "zyxcba", "yxcbaz", "xcbazy", "cbazyx", "bazyxc", "azyxcb".
Among all the possible strings, "zyxcba" is the lexicographically largest one.

## Example 2:
## *Ví dụ 2:*

**Input:** `strs = ["abc"]`
**Output:** `"cba"`

## Constraints:
## *Ràng buộc:*

*   `1 <= strs.length <= 1000`
*   `1 <= sum(strs[i].length) <= 1000`

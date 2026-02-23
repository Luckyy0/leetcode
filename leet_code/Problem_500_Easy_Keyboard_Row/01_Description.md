# Result for Keyboard Row
# *Kết quả cho bài toán Hàng Bàn phím*

## Description
## *Mô tả*

Given an array of strings `words`, return *the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below*.
*Cho một mảng các chuỗi `words`, hãy trả về *các từ có thể được gõ bằng các chữ cái trong bảng chữ cái chỉ trên một hàng của bàn phím Mỹ như hình bên dưới*.*

In the **American keyboard**:
*Trong **bàn phím Mỹ**:*

*   the first row consists of the characters `"qwertyuiop"`,
    *hàng đầu tiên bao gồm các ký tự `"qwertyuiop"`,*
*   the second row consists of the characters `"asdfghjkl"`, and
    *hàng thứ hai bao gồm các ký tự `"asdfghjkl"`, và*
*   the third row consists of the characters `"zxcvbnm"`.
    *hàng thứ ba bao gồm các ký tự `"zxcvbnm"`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["Hello","Alaska","Dad","Peace"]`
**Output:** `["Alaska","Dad"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["omk"]`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `words = ["adsdf","sfd"]`
**Output:** `["adsdf","sfd"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 20`
*   `1 <= words[i].length <= 100`
*   `words[i]` consists of English letters (both lowercase and uppercase).

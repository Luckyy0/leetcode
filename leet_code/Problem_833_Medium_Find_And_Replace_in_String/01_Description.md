# Result for Find And Replace in String
# *Kết quả cho bài toán Tìm và Thay thế trong Chuỗi*

## Description
## *Mô tả*

You are given a **0-indexed** string `s` that you must perform `k` replacement operations on. The operations are given as three arrays of length `k`: `indices`, `sources`, and `targets`.
*Bạn được cho một chuỗi `s` và cần thực hiện `k` thao tác thay thế. Các thao tác được cho dưới dạng ba mảng độ dài `k`: `indices`, `sources`, và `targets`.*

To perform the `i`-th replacement operation:
*Để thực hiện thao tác thay thế thứ `i`:*

1.  Check if the **substring** `s[indices[i] : indices[i] + sources[i].length]` matches `sources[i]`.
2.  If it does not match, **do nothing**.
3.  If it does match, **replace** that substring with `targets[i]`.

All replacement operations must occur **simultaneously**, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will **not overlap**.
*Tất cả các thao tác thay thế phải diễn ra **đồng thời**, nghĩa là các thao tác không được ảnh hưởng đến chỉ số của nhau. Các trường hợp kiểm thử đảm bảo rằng các phần thay thế **không chồng lấp** lên nhau.*

Return *the resulting string after performing all replacement operations*.
*Trả về *chuỗi kết quả sau khi thực hiện tất cả các thao tác thay thế*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
**Output:** "eeebffff"
**Explanation:**
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abcd", indices = [0, 2], sources = ["ab", "ec"], targets = ["eee", "ffff"]
**Output:** "eeecd"
**Explanation:**
"ab" occurs at index 0 in s, so we replace it with "eee".
"ec" does not occur at index 2 in s, so we do nothing.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `k == indices.length == sources.length == targets.length`
*   `1 <= k <= 100`
*   `0 <= indices[i] < s.length`
*   `1 <= sources[i].length, targets[i].length <= 50`
*   `s` and `targets[i]` consist of lowercase English letters.
*   `sources[i]` consists of lowercase English letters.

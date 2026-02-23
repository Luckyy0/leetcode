# Result for Groups of Special-Equivalent Strings
# *Kết quả cho bài toán Nhóm các Chuỗi có Tính chất Đẳng trị Đặc biệt*

## Description
## *Mô tả*

You are given an array of strings of the same length `words`.
*Bạn được cho một mảng các chuỗi có cùng độ dài `words`.*

In one **move**, you can swap any two even indexed characters or any two odd indexed characters of a string `words[i]`.
*Trong một **bước**, bạn có thể hoán đổi hai ký tự ở vị trí chẵn bất kỳ hoặc hai ký tự ở vị trí lẻ bất kỳ của một chuỗi `words[i]`.*

Two strings `words[i]` and `words[j]` are **special-equivalent** if after any number of moves, `words[i] == words[j]`.
*Hai chuỗi `words[i]` và `words[j]` được gọi là **đẳng trị đặc biệt** nếu sau một số bước di chuyển bất kỳ, `words[i] == words[j]`.*

-   For example, `words[i] = "zzxy"` and `words[j] = "xyzz"` are special-equivalent because we may make the moves `"zzxy" -> "xzzy" -> "xyzz"`.
    *Ví dụ, `words[i] = "zzxy"` và `words[j] = "xyzz"` là đẳng trị đặc biệt vì chúng ta có thể thực hiện các bước di chuyển `"zzxy" -> "xzzy" -> "xyzz"`.*

A **group of special-equivalent strings** from `words` is a non-empty subset of `words` such that:
*Một **nhóm các chuỗi đẳng trị đặc biệt** từ `words` là một tập con không rỗng của `words` sao cho:*

1.  Every pair of strings in the group are special equivalent, and
    *Mọi cặp chuỗi trong nhóm đều đẳng trị đặc biệt, và*
2.  The group is the largest size possible (i.e., there is not a string `words[i]` not in the group that is special equivalent to every string in the group).
    *Nhóm có kích thước lớn nhất có thể (tức là không có chuỗi `words[i]` nào không nằm trong nhóm mà đẳng trị đặc biệt với mọi chuỗi trong nhóm).*

Return *the number of groups of special-equivalent strings from `words`*.
*Hãy trả về *số lượng nhóm các chuỗi đẳng trị đặc biệt từ `words`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
**Output:** 3
**Explanation:** 
One group is ["abcd", "cdab", "cbad"], since they are all special-equivalent, and none of the other strings are all special-equivalent to these.
The other two groups are ["xyzz", "zzxy"] and ["zzyx"].
Note that in string "zzxy", at even indices we have 'z' and 'x', and at odd indices we have 'z' and 'y'. In "zzyx", at even indices we have 'z' and 'y', which doesn't match.

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["abc","acb","bac","bca","cab","cba"]
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 1000`
*   `1 <= words[i].length <= 20`
*   All `words[i]` have the same length.
*   All `words[i]` consist of only lowercase English letters.

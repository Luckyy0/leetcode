# Result for Similar String Groups
# *Kết quả cho bài toán Các Nhóm Chuỗi Tương đồng*

## Description
## *Mô tả*

Two strings, `x` and `y`, are considered **similar** if either they are identical, or we can make them identical by swapping at most two letters in one of the strings.
*Hai chuỗi `x` và `y` được coi là **tương đồng** nếu chúng giống hệt nhau, hoặc chúng ta có thể làm cho chúng giống hệt nhau bằng cách tráo đổi tối đa hai chữ cái trong một chuỗi.*

- For example, `"tars"` and `"rats"` are similar (swapping `'t'` and `'r'`), and `"rats"` and `"arts"` are similar, but `"star"` is not similar to `"tars"`, `"rats"`, or `"arts"`.

Together, these form groups of similar strings where a string is in a group if it is similar to at least one other string in the group. Formally, a group is a subset of strings such that for every pair of strings `a` and `b` in the subset, there is a sequence of strings `s1, s2, ..., sk` such that `s1 = a`, `sk = b`, and each `si` is similar to `si+1`.
*Các chuỗi này tạo thành các nhóm chuỗi tương đồng, trong đó một chuỗi thuộc một nhóm nếu nó tương đồng với ít nhất một chuỗi khác trong nhóm đó. Nói cách khác, một nhóm là một tập con các chuỗi sao cho giữa hai chuỗi bất kỳ luôn có một đường dẫn các chuỗi tương đồng kết nối chúng.*

You are given an array of strings `strs`. Every string in `strs` is an anagram of every other string in `strs`. Return *the number of groups*.
*Bạn được cho một mảng chuỗi `strs`. Mọi chuỗi trong mảng đều là phép hoán vị (anagram) của nhau. Trả về *số lượng nhóm*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** strs = ["tars","rats","arts","star"]
**Output:** 2

## Example 2:
## *Ví dụ 2:*

**Input:** strs = ["omv","ovm"]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= strs.length <= 300`
*   `1 <= strs[i].length <= 300`
*   `strs[i]` consists of lowercase English letters only.
*   All strings in `strs` are anagrams of each other.

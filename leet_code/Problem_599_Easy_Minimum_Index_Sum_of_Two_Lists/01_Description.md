# Result for Minimum Index Sum of Two Lists
# *Kết quả cho bài toán Tổng Chỉ số Tối thiểu của Hai Danh sách*

## Description
## *Mô tả*

Given two arrays of strings `list1` and `list2`, find the common strings with the **least index sum**.
*Cho hai mảng chuỗi `list1` và `list2`, hãy tìm các chuỗi chung có **tổng chỉ số nhỏ nhất**.*

A **common string** is a string that appears in both `list1` and `list2`.
*Một **chuỗi chung** là một chuỗi xuất hiện trong cả `list1` và `list2`.*

A **least index sum** is the minimum of the sum of the index of each common string in `list1` and the index of the same string in `list2`.
* **Tổng chỉ số nhỏ nhất** là giá trị nhỏ nhất của tổng chỉ số của mỗi chuỗi chung trong `list1` và chỉ số của cùng chuỗi đó trong `list2`.*

Return all the common strings with the least index sum. Return the answer in **any order**.
*Trả về tất cả các chuỗi chung có tổng chỉ số nhỏ nhất. Trả về câu trả lời theo **bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
**Output:** ["Shogun"]
**Explanation:** The only common string is "Shogun".

## Example 2:
## *Ví dụ 2:*

**Input:** list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
**Output:** ["Shogun"]
**Explanation:** The common strings are "Shogun", "Burger King", and "KFC".
The index sums are:
- "Shogun": 0 (list1) + 1 (list2) = 1
- "Burger King": 2 (list1) + 2 (list2) = 4
- "KFC": 3 (list1) + 0 (list2) = 3
The minimum index sum is 1, so return ["Shogun"].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= list1.length, list2.length <= 1000`
*   `1 <= list1[i].length, list2[i].length <= 30`
*   `list1[i]` and `list2[i]` consist of spaces `' '` and English letters.
*   All the strings of `list1` are **unique**.
*   All the strings of `list2` are **unique**.

# Result for Flatten Nested List Iterator
# *Kết quả cho bài toán Bộ lặp Làm phẳng Danh sách Lồng nhau*

## Description
## *Mô tả*

You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
*Bạn được cho một danh sách các số nguyên lồng nhau `nestedList`. Mỗi phần tử là một số nguyên hoặc một danh sách mà các phần tử của nó cũng có thể là số nguyên hoặc danh sách khác. Hãy thực hiện một bộ lặp để làm phẳng nó.*

Implement the `NestedIterator` class:
*Thực hiện lớp `NestedIterator`:*

*   `NestedIterator(List<NestedInteger> nestedList)` Initializes the iterator with the nested list `nestedList`.
    *`NestedIterator(List<NestedInteger> nestedList)` Khởi tạo bộ lặp với danh sách lồng nhau `nestedList`.*
*   `int next()` Returns the next integer in the nested list.
    *`int next()` Trả về số nguyên tiếp theo trong danh sách lồng nhau.*
*   `boolean hasNext()` Returns `true` if there are still some integers in the nested list and `false` otherwise.
    *`boolean hasNext()` Trả về `true` nếu vẫn còn một số số nguyên trong danh sách lồng nhau và `false` nếu ngược lại.*

Your code will be tested with the following pseudocode:
*Mã của bạn sẽ được kiểm tra với mã giả sau:*

```java
initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to res
return res
```

If `res` matches the expected flattened list, then your code will be judged as correct.

## Example 1:
## *Ví dụ 1:*

**Input:** `nestedList = [[1,1],2,[1,1]]`
**Output:** `[1,1,2,1,1]`
**Explanation:** By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

## Example 2:
## *Ví dụ 2:*

**Input:** `nestedList = [1,[4,[6]]]`
**Output:** `[1,4,6]`
**Explanation:** By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

## Constraints:
## *Ràng buộc:*

*   `1 <= nestedList.length <= 500`
*   The values of the integers in the nested list is in the range `[-10^6, 10^6]`.

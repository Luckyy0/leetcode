# 341. Flatten Nested List Iterator / Làm Phẳng Trình Duyệt Danh Sách Lồng Nhau

## Problem Description / Mô tả bài toán
You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists.
Bạn được cung cấp một danh sách lồng nhau các số nguyên `nestedList`.

Implement an iterator to flatten it.
Thực hiện một trình duyệt để làm phẳng nó.

- `next()` Returns the next integer in the nested list.
- `hasNext()` Returns `true` if there are still some integers in the nested list and `false` otherwise.

### Example 1:
```text
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
```

### Example 2:
```text
Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
```

## Constraints / Ràng buộc
- `1 <= nestedList.length <= 500`
- The values of the integers in the nested list is in the range `[-10^6, 10^6]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack Iteration / Duyệt Bằng Stack
Instead of flattening the entire list upfront (which might be heavy if list is large), we can lazily flatten using a Stack.
Stack stores `Iterators` or `Lists`.
Or simply Stack stores `NestedInteger` elements in **reverse order**.
To ensure `hasNext()` works correctly (i.e., finds the next integer):
- In `hasNext()`:
    - While stack not empty:
        - Peek top.
        - If top is Integer: return true.
        - If top is List: Pop, push all elements of list to stack in **reverse order** (so first element is at top).
    - Return false.

`next()`:
- Ensure `hasNext()` is true.
- Pop and return Integer.

### Complexity / Độ phức tạp
- **Time**:
    - `hasNext()`: Amortized O(1). Or O(N) total across all operations. Each nested list is expanded once.
    - `next()`: O(1).
- **Space**: O(D) where D is sum of sizes of nested lists in stack, or simply proportional to nesting depth structure.

---

## Analysis / Phân tích

### Approach: Stack of NestedIntegers

**Algorithm**:
1.  Stack `s`.
2.  Constructor: Push all elements of `nestedList` in reverse order.
3.  `hasNext()`:
    - While `!s.isEmpty()`:
        - `top = s.peek()`.
        - If `top.isInteger()`: return true.
        - Else: `s.pop()`, list = `top.getList()`, push `list` elements in reverse.
    - return false.
4.  `next()`:
    - Return `s.pop().getInteger()`.

---

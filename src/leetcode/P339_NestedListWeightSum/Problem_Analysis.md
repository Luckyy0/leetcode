# 339. Nested List Weight Sum / Tổng Trọng Số Danh Sách Lồng Nhau

## Problem Description / Mô tả bài toán
You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists.
Bạn được cung cấp một danh sách lồng nhau các số nguyên `nestedList`. Mỗi phần tử là một số nguyên hoặc một danh sách mà các phần tử của nó cũng có thể là số nguyên hoặc danh sách khác.

The **depth** of an integer is the number of lists that it is inside of. For example, the nested list `[1,[2,2],[[3],2],1]` has each integer's value set to its depth.
**Độ sâu** của một số nguyên là số danh sách mà nó nằm trong đó.

Return the sum of each integer in `nestedList` multiplied by its depth.
Trả về tổng của mỗi số nguyên trong `nestedList` nhân với độ sâu của nó.

### Example 1:
```text
Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
```

### Example 2:
```text
Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
```

## Constraints / Ràng buộc
- `1 <= nestedList.length <= 50`
- The values of the integers in the nested list is in the range `[-100, 100]`.
- The maximum depth of any integer is less than or equal to `50`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS / Duyệt Theo Chiều Sâu
Traverse the structure. Keep track of current `depth`.
- If element is Integer: `sum += val * depth`.
- If element is List: `dfs(list, depth + 1)`.
Start `depth = 1`.

### Complexity / Độ phức tạp
- **Time**: O(N), where N is total number of integers.
- **Space**: O(D) where D is max depth (recursion stack).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  `dfs(list, depth)`.
2.  Iterate list.
3.  Type check (using NestedInteger interface usually provided in problem).

Note: This problem usually requires a `NestedInteger` interface mock for local testing.

---

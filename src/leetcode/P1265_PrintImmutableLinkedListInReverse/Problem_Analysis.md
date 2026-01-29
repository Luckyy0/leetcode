# 1265. Print Immutable Linked List in Reverse / In Danh sách Liên kết Bất biến theo Thứ tự Ngược lại

## Problem Description / Mô tả bài toán
Interface `ImmutableListNode`.
Methods: `printValue()`, `getNext()`.
Print reverse.
Constant space complexity? Or Linear?
Constraints: O(N) time.
Space? "You are required to use less than O(n) space complexity?"
Usually standard recursion is O(N) stack space.
Is it possible to do O(Sqrt(N)) or O(1)?
If O(N) stack not allowed, how?
Usually O(N) stack allowed if recursive. But maybe challenge is less.
If small recursion limit, split list?
Approach 1: Recursion (O(N) space).
Approach 2: Stack (O(N) space).
Approach 3: Square root decomposition (store checkpoints).
If problem says "Use less than O(n) space", likely means better than linear. O(sqrt(N)) is possible.
But problem statement usually allows recursion stack for simple/medium.
Let's check constraints. If N ~ 10000, recursion fine.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursion / Divide and Conquer
Recursion:
`print(head)`:
  `if head null return`
  `print(head.next)`
  `head.printValue()`
This uses O(N) stack.

Square Root Decomposition (Space Optimization):
Split list into chunks of size `sqrt(N)`. Store pointers `p_0, p_sqrt, p_2sqrt...`.
Iterate blocks in reverse.
For each block, simple recursion (depth sqrt(N)).
Total space: O(sqrt(N)) for pointers + O(sqrt(N)) stack = O(sqrt(N)).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(sqrt(N)) or O(N) depending on method. Standard recursion is O(N).

---

## Analysis / Phân tích

### Approach: Recursion
The most straightforward way is recursion. Traverse to the end, then print on the way back.
`void printLinkedListInReverse(ImmutableListNode head) { if (head != null) { printLinkedListInReverse(head.getNext()); head.printValue(); } }`
This uses O(N) stack space.
Given typical constraints and complexity allowances, if O(N) space is acceptable, this is best. If stricter (e.g., O(sqrt(N)) or O(log N)), we'd need more complex logic like decomposition. Assuming standard difficulty, recursion is the intended solution.
Cách đơn giản nhất là đệ quy. Duyệt đến cuối, sau đó in trên đường quay lại.
Cái này sử dụng không gian ngăn xếp O(N).
Với các ràng buộc và sai số phức tạp điển hình, nếu không gian O(N) được chấp nhận, thì đây là cách tốt nhất. Nếu nghiêm ngặt hơn (ví dụ: O(sqrt(N)) hoặc O(log N)), chúng ta sẽ cần logic phức tạp hơn như phân rã. Giả sử độ khó tiêu chuẩn, đệ quy là giải pháp dự kiến.

---

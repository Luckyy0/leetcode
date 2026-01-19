# 147. Insertion Sort List / Sắp Xếp Chèn Danh Sách

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list, sort the list using **insertion sort**, and return the sorted list's head.
Cho `head` của một danh sách liên kết đơn, hãy sắp xếp danh sách bằng thuật toán **sắp xếp chèn (insertion sort)**, và trả về đầu của danh sách đã sắp xếp.

The steps of the **insertion sort** algorithm:
1.  Insertion sort consumes one input element each repetition and grows a sorted output list.
2.  At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
3.  It repeats until no input elements remain.

### Example 1:
```text
Input: head = [4,2,1,3]
Output: [1,2,3,4]
```

### Example 2:
```text
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[1, 5000]`.
- `-5000 <= Node.val <= 5000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Insertion Sort on Linked List / Sắp xếp Chèn trên Danh sách Liên kết
Unlike an array where shifting elements is costly, in a linked list, insertion is efficient once the position is found.
Không giống như mảng nơi việc di chuyển các phần tử tốn kém, trong danh sách liên kết, việc chèn rất hiệu quả một khi tìm thấy vị trí.

**Algorithm Logic**:
1.  Create a `dummy` node to point to the start of the sorted list.
2.  Iterate through the original list (named `curr`).
3.  For each `curr`:
    - Start from `dummy` and scan the sorted list to find a node `prev` such that `prev.next.val > curr.val`.
    - Insert `curr` between `prev` and `prev.next`.
4.  Move to the next node in the original list.

---

## Analysis / Phân tích

### Approach: Linear Scan Insertion

**Complexity / Độ phức tạp**:
- **Time**: O(N^2) - Worst case (reverse sorted list).
- **Space**: O(1) - Only pointers are used.

---

## Edge Cases / Các trường hợp biên
1.  **Already sorted**: Takes O(N) if optimized to check `prev_sorted` value, but O(N^2) in basic version.
2.  **Reverse sorted**: O(N^2).
3.  **All identical values**: O(N^2).

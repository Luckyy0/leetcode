# 148. Sort List / Sắp Xếp Danh Sách

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, return the list after sorting it in **ascending order**.
Cho `head` của một danh sách liên kết, hãy trả về danh sách sau khi được sắp xếp theo **thứ tự tăng dần**.

Can you sort the linked list in **O(n log n)** time and **O(1)** memory (i.e. constant space)?
Bạn có thể sắp xếp danh sách liên kết trong thời gian **O(n log n)** và bộ nhớ **O(1)** (không gian hằng số) không?

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
- The number of nodes in the list is in the range `[0, 5 * 10^4]`.
- `-10^5 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Merge Sort on Linked List / Sắp xếp Trộn trên Danh sách Liên kết
Merge Sort is naturally suited for linked lists because:
1.  Finding the middle is O(N).
2.  Splitting is O(1) (just change one pointer).
3.  Merging is O(N) and can be done in-place (O(1) excluding recursion).

**Algorithm Steps**:
1.  **Base Case**: If list is empty or has one node, return.
2.  **Split**: Use slow and fast pointers to find the middle. Sever the list into two.
3.  **Recursion**: Call `sortList` on both halves.
4.  **Merge**: Use a helper function to merge two sorted lists.

---

## Analysis / Phân tích

### Approach: Recursive Merge Sort

**Complexity / Độ phức tạp**:
- **Time**: O(N log N) - standard Merge Sort complexity.
- **Space**: O(log N) - due to the recursion stack. (O(1) iterative version possible but requires complex bottom-up logic).

---

## Edge Cases / Các trường hợp biên
1.  **Empty list**.
2.  **Single node**.
3.  **Already sorted**.
4.  **Reverse sorted**.

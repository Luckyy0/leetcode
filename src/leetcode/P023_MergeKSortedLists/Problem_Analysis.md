# 23. Merge k Sorted Lists / Hợp Nhất k Danh Sách Đã Sắp Xếp

## Problem Description / Mô tả bài toán
You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.
Bạn được cho một mảng `k` danh sách liên kết `lists`, mỗi danh sách liên kết được sắp xếp theo thứ tự tăng dần.

Merge all the linked-lists into one sorted linked-list and return it.
Hợp nhất tất cả các danh sách liên kết thành một danh sách liên kết đã sắp xếp và trả về nó.

### Example 1:
```text
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```

### Example 2:
```text
Input: lists = []
Output: []
```

### Example 3:
```text
Input: lists = [[]]
Output: []
```

## Constraints / Ràng buộc
- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- `lists[i]` is sorted in ascending order.
- The sum of `lists[i].length` will not exceed `10^4`.

---

## Analysis / Phân tích

### Approach 1: Min Heap (Priority Queue) / Hàng Đợi Ưu Tiên
- **Idea**: Use a min-heap to keep track of the smallest node among the `k` heads.
- **Ý tưởng**: Sử dụng min-heap để theo dõi nút nhỏ nhất trong số `k` nút đầu.
    - Add the head of each list to the heap.
    - While heap is not empty:
        - Pop the smallest node `minNode`.
        - Add `minNode` to result.
        - If `minNode.next` exists, add it to the heap.
- **Time Complexity**: O(N log k), where N is the total number of nodes. Insertion/Deletion in heap is O(log k).
- **Space Complexity**: O(k) for the heap.

### Approach 2: Divide and Conquer / Chia Để Trị
- **Idea**: Merge pairs of lists iteratively.
- **Ý tưởng**: Hợp nhất từng cặp danh sách một cách lặp lại.
    - Merge `lists[0]` and `lists[1]`, `lists[2]` and `lists[3]`, etc.
    - Repeat until only one list remains.
- **Time Complexity**: O(N log k).
- **Space Complexity**: O(1) if iterative merge is used.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Lists**: `[]` -> `[]`.
2.  **Lists with Empty Lists**: `[[], []]` -> `[]`.
3.  **Single List**: `[[1,2]]` -> `[1,2]`.

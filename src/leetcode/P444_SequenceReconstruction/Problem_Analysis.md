# 444. Sequence Reconstruction / Tái Cấu Trúc Dãy Số

## Problem Description / Mô tả bài toán
Determine whether there is a **unique** shortest common supersequence for a list of `sequences`. A shortest common supersequence is a sequence such that all `sequences` are subsequences of it and there is no shorter such sequence.
Hãy xác định xem có tồn tại một siêu dãy chung **duy nhất** ngắn nhất cho một danh sách các `sequences` hay không. Một siêu dãy chung ngắn nhất là một dãy sao cho tất cả các `sequences` đều là các dãy con của nó và không có dãy nào ngắn hơn thỏa mãn điều kiện đó.

You are given an integer array `nums` and a 2D integer array `sequences`. Check if `nums` is the **unique** shortest common supersequence of all `sequences`.
Bạn được cho một mảng số nguyên `nums` và một mảng số nguyên 2 chiều `sequences`. Hãy kiểm tra xem `nums` có phải là siêu dãy chung ngắn nhất **duy nhất** của tất cả các `sequences` hay không.

### Example 1:
```text
Input: nums = [1,2,3], sequences = [[1,2],[1,3]]
Output: false
Explanation: [1,2,3] and [1,3,2] are both shortest common supersequences.
```

### Example 2:
```text
Input: nums = [1,2,3], sequences = [[1,2]]
Output: false
Explanation: The shortest common supersequence is [1,2], not [1,2,3].
```

### Example 3:
```text
Input: nums = [1,2,3], sequences = [[1,2],[2,3]]
Output: true
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `1 <= sequences.length <= 10^4`
- `1 <= sequences[i].length <= 10^4`
- `1 <= sum(sequences[i].length) <= 10^5`
- `1 <= nums[i], sequences[i][j] <= n`
- All integers in `nums` are unique.
- All integers in `sequences[i]` are unique.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Topological Sort / Sắp xếp Tô-pô
This problem can be modeled as finding if there is a **unique** topological sort order for a directed graph defined by the `sequences`.
A unique topological sort exists if and only if at each step of Kahn's algorithm, there is **exactly one** node with an in-degree of 0.

Algorithm:
1. Build a directed graph where an edge `u -> v` exists if `u` appears before `v` in any sequence.
2. Build an `in-degree` map.
3. Use Kahn's algorithm (BFS-based topological sort):
   - Add all nodes with in-degree 0 to a `Queue`.
   - While the queue is not empty:
     - **Check**: If there is more than one node in the queue, the topological sort is **not unique**. Return `false`.
     - Poll a node `curr`.
     - For each neighbor of `curr`:
       - Decrement its in-degree.
       - If its in-degree becomes 0, add to queue.
4. Verify that the number of nodes processed equals the number of nodes in `nums`, and they follow the order in `nums`.

### Complexity / Độ phức tạp
- **Time**: O(V + E) where V is the number of nodes and E is the total number of consecutive pairs in `sequences`.
- **Space**: O(V + E) for the adjacency list and in-degree array.

---

## Analysis / Phân tích

### Approach: Unique Path Kahn's Algorithm

**Algorithm**:
1.  Verify basic node set matches `nums`.
2.  Perform Topological Sort.
3.  Strictly watch queue size.

---

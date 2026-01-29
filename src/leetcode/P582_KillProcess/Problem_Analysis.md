# 582. Kill Process / Diệt Quy Trình

## Problem Description / Mô tả bài toán
You have `n` processes forming a rooted tree structure. You are given two integer arrays `pid` and `ppid`, where `pid[i]` is the ID of the `i-th` process and `ppid[i]` is the ID of the `i-th` process's parent process.
Bạn có `n` quy trình tạo thành cấu trúc cây có gốc. Bạn được cho hai mảng số nguyên `pid` và `ppid`, trong đó `pid[i]` là ID của quy trình thứ `i` và `ppid[i]` là ID của quy trình cha của quy trình thứ `i`.

Each process has only one parent process but may have multiple children processes. One of the processes is the **root** node, which has a `ppid` of `0`.
Mỗi quy trình chỉ có một quy trình cha nhưng có thể có nhiều quy trình con. Một trong các quy trình là nút **gốc**, có `ppid` là `0`.

When a process is killed, all of its children processes will also be killed.
Khi một quy trình bị diệt, tất cả các quy trình con của nó cũng sẽ bị diệt.

Given an integer `kill` representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed. You may return the answer in any order.
Cho một số nguyên `kill` đại diện cho ID của một quy trình bạn muốn diệt, hãy trả về danh sách các ID của quy trình sẽ bị diệt. Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.

### Example 1:
```text
Input: pid = [1, 3, 10, 5], ppid = [3, 0, 5, 3], kill = 5
Output: [5, 10]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Adjacency List + BFS/DFS / Danh Sách Kề HashMap + BFS/DFS
Build the tree explicitly using a HashMap: `Map<Integer, List<Integer>> tree`.
Key is parent ID, Value is list of children IDs.

Algorithm:
1. Construct the graph (adjacency list) `ppid[i] -> list of children`.
2. Perform BFS or DFS starting from `kill` node.
3. Collect all visited nodes in a list.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Graph Traversal

**Algorithm**:
1.  Map parent ID to children nodes list.
2.  Start traversals (BFS/DFS) from the target `kill` node.
3.  Accumulate all reachable descendants into result list.

---

# 851. Loud and Rich / Ồn ào và Giàu có

## Problem Description / Mô tả bài toán
There is a group of `n` people. You are given `richer`, where `richer[i] = [ai, bi]` means `ai` is richer than `bi`.
Có một nhóm gồm `n` người. Bạn được cho `richer`, trong đó `richer[i] = [ai, bi]` có nghĩa là `ai` giàu hơn `bi`.

You are also given `quiet`, where `quiet[i]` is the quietness of the `ith` person. Lower `quiet` means the person is more quiet.
Bạn cũng được cung cấp `quiet`, trong đó `quiet[i]` là độ yên lặng của người thứ `i`. `quiet` thấp hơn có nghĩa là người đó yên lặng hơn.

Return an array `answer` where `answer[x]` is the person who has the least quietness (more quiet) among all people who are **definitely** as rich as or richer than `x`.
Trả về một mảng `answer` trong đó `answer[x]` là người có độ yên lặng thấp nhất (yên lặng hơn) trong số tất cả những người **chắc chắn** giàu bằng hoặc giàu hơn `x`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graphic Reachability and Memoization / Khả năng tiếp cận Đồ thị và Memoization
This is a problem of finding minimum values in a Directed Acyclic Graph (DAG) starting from each node.
Đây là bài toán tìm các giá trị cực tiểu trong một đồ thị có hướng không chu trình (DAG) bắt đầu từ mỗi nút.

Algorithm:
1. Build a graph where an edge `u -> v` means `u` is richer than `v`. (Actually, to propagate minimum quietness, we need to look "up" at richer people).
2. For each person `x`, explore all people richer than `x`.
3. Use DFS with memoization to avoid redundant searches.
`solve(x) = min(quiet[x], solve(all neighbors richer than x))`.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: DAG Traversal with Cache
Each "richer" relationship forms a link in the social hierarchy. By using a depth-first search combined with result caching, we can efficiently find the quietest ancestor for every person in the hierarchy.
Mỗi mối quan hệ "giàu hơn" tạo thành một liên kết trong hệ thống phân cấp xã hội. Bằng cách sử dụng tìm kiếm theo chiều sâu kết hợp với lưu kết quả (caching), chúng ta có thể tìm thấy tổ tiên yên lặng nhất cho mọi người trong hệ thống phân cấp một cách hiệu quả.

---

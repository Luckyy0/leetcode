# 773. Sliding Puzzle / Trò chơi Trượt

## Problem Description / Mô tả bài toán
On a `2 x 3` board, there are five tiles labeled from `1` to `5`, and an empty square represented by `0`. A move consists of choosing `0` and a 4-directionally adjacent number and swapping it.
Trên một bảng `2 x 3`, có năm viên gạch được đánh số từ `1` đến `5` và một ô trống được đại diện bởi số `0`. Một nước đi bao gồm việc chọn `0` và một số lân cận theo 4 hướng và hoán đổi chúng.

The state of the board is solved if and only if the board is `[[1,2,3],[4,5,0]]`.
Trạng thái của bảng được giải quyết khi và chỉ khi bảng là `[[1,2,3],[4,5,0]]`.

Given the `board`, return the least number of moves required so that the state of the board is solved. If it is impossible, return -1.
Cho `board`, hãy trả về số nước đi ít nhất cần thiết để trạng thái của bảng được giải quyết. Nếu không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Breadth First Search (BFS) / Tìm kiếm theo Chiều rộng
This is a shortest path problem in the state space.
Đây là một bài toán tìm đường đi ngắn nhất trong không gian trạng thái.

1. Represent the `2x3` board as a string of length 6.
2. The target state is `"123450"`.
3. From any string state, find the index of `'0'`.
4. Identify possible swaps based on 2D adjacency rules applied to the 1D string:
   - Index 0 can swap with 1, 3.
   - Index 1 can swap with 0, 2, 4.
   - ... and so on.
5. Use BFS and a `Set` to track visited states.

### Complexity / Độ phức tạp
- **Time**: O(V + E) where V is total permutations (6! = 720).
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: String-based BFS
Flatten the board and treat each permutation as a node in a graph. Explore all possible swaps to reach the target sequence.
Làm phẳng bảng và coi mỗi hoán vị là một nút trong đồ thị. Khám phá tất cả các hoán đổi khả thi để đạt được chuỗi mục tiêu.

---

# 838. Push Dominoes / Đẩy Domino

## Problem Description / Mô tả bài toán
You are given a string `dominoes` representing the initial state.
Bạn được cho một chuỗi `dominoes` đại diện cho trạng thái ban đầu.
- 'L': Domino pushed to the left.
- 'R': Domino pushed to the right.
- '.': Standing vertical.

When a domino falls, it pushes the next one. If a standing domino is pushed from both sides simultaneously, it stays vertical.
Khi một quân domino đổ, nó sẽ đẩy quân tiếp theo. Nếu một quân domino đang đứng bị đẩy từ cả hai phía cùng một lúc, nó vẫn đứng dọc.

Return the final state of the dominoes.
Trả về trạng thái cuối cùng của các quân domino.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Force Simulation or Segment Analysis / Mô phỏng Lực hoặc Phân tích Đoạn
Each '.', find the distance to the nearest 'R' on the left and 'L' on the right.
Đối với mỗi dấu '.', hãy tìm khoảng cách đến 'R' gần nhất bên trái và 'L' gần nhất bên phải.

Algorithm:
1. Pass left to right: Track the force from 'R'. If encounter 'L', force reset to 0.
2. Pass right to left: Track the force from 'L'. If encounter 'R', force reset to 0.
3. For each index:
   - if `forceR > forceL`, mark 'R'.
   - if `forceL > forceR`, mark 'L'.
   - else mark '.'.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Force Decay Model
Treat the movement as a decaying force. 'R' pushes right with strength $N, N-1, ...$ and 'L' pushes left. The net direction depends on which force reaches a certain index with more strength.
Coi chuyển động như một lực suy giảm. 'R' đẩy sang phải với cường độ $N, N-1, ...$ và 'L' đẩy sang trái. Hướng ròng phụ thuộc vào lực nào truyền đến một chỉ số nhất định với cường độ lớn hơn.

---

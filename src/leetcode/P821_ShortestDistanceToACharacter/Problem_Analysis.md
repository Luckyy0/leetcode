# 821. Shortest Distance to a Character / Khoảng cách Ngắn nhất đến một Ký tự

## Problem Description / Mô tả bài toán
Given a string `s` and a character `c`, return an array of integers representing the shortest distance from each character in `s` to the character `c`.
Cho một chuỗi `s` và một ký tự `c`, hãy trả về một mảng các số nguyên đại diện cho khoảng cách ngắn nhất từ mỗi ký tự trong `s` đến ký tự `c`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two-Pass Traversal / Duyệt hai lượt
For each character at index `i`, the closest character `c` can be either to its left or its right.
Đối với mỗi ký tự tại chỉ số `i`, ký tự `c` gần nhất có thể nằm ở bên trái hoặc bên phải của nó.

Algorithm:
1. Pass from left to right: Track the position of the last seen `c`. Calculate `i - last_c`.
2. Pass from right to left: Track the position of the last seen `c`. Calculate `last_c - i`.
3. The result at each index is the minimum of these two distances.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) to store result.

---

## Analysis / Phân tích

### Approach: Marginal Distance Propagation
Calculate distances in two passes to cover both directions. The "left" pass handles distances to the nearest `c` before the current index, and the "right" pass handles distances to the nearest `c` after the current index.
Tính toán khoảng cách trong hai lượt để bao phủ cả hai hướng. Lượt "trái" xử lý khoảng cách đến `c` gần nhất trước chỉ số hiện tại và lượt "phải" xử lý khoảng cách đến `c` gần nhất sau chỉ số hiện tại.

---

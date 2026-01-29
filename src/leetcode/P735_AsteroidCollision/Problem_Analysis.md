# 735. Asteroid Collision / Va chạm Thiên thạch

## Problem Description / Mô tả bài toán
We are given an array `asteroids` of integers representing asteroids in a row.
Chúng ta được cho một mảng `asteroids` gồm các số nguyên đại diện cho các thiên thạch trên một hàng.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Đối với mỗi thiên thạch, giá trị tuyệt đối đại diện cho kích thước của nó và dấu đại diện cho hướng của nó (dương nghĩa là sang phải, âm nghĩa là sang trái). Mỗi thiên thạch di chuyển với tốc độ như nhau.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
Tìm trạng thái của các thiên thạch sau tất cả các vụ va chạm. Nếu hai thiên thạch gặp nhau, cái nhỏ hơn sẽ phát nổ. Nếu cả hai có cùng kích thước, cả hai sẽ phát nổ. Hai thiên thạch di chuyển cùng chiều sẽ không bao giờ gặp nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack Data Structure / Cấu trúc dữ liệu Ngăn xếp
We can use a stack to process asteroids one by one.
Chúng ta có thể sử dụng ngăn xếp để xử lý từng thiên thạch một.

Collision rules:
- Collision only happens if a **positive** asteroid is followed by a **negative** one.
Va chạm chỉ xảy ra nếu một thiên thạch **dương** được theo sau bởi một thiên thạch **âm**.

Algorithm:
1. For each `asteroid`:
   - If it's negative, it might collide with positive asteroids currently at the top of the stack.
   - Loop: Enquanto stack top is positive and smaller than `|asteroid|`, pop stack (destroy smaller one).
   - Resolve tie (both explode) or block (asteroid destroyed).

### Complexity / Độ phức tạp
- **Time**: O(N) where N is number of asteroids.
- **Space**: O(N) for stack.

---

## Analysis / Phân tích

### Approach: Stack-based Simulation
A stack effectively captures the order of potential collisions. Only `[positive, negative]` asteroid pairs collide.
Ngăn xếp nắm bắt hiệu quả thứ tự của các vụ va chạm tiềm năng. Chỉ những cặp thiên thạch `[dương, âm]` mới va chạm.

---

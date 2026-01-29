# 858. Mirror Reflection / Phản chiếu Gương

## Problem Description / Mô tả bài toán
There is a square room with walls of length `p` and mirrors on all four walls. There is a laser at `(0, 0)`.
Có một căn phòng hình vuông với các bức tường dài `p` và có gương ở cả bốn bức tường. Có một tia laser tại `(0, 0)`.

The laser reflects off walls until it hits one of three receptors:
Tia laser phản xạ khỏi các bức tường cho đến khi nó chạm vào một trong ba bộ thu:
0: `(p, 0)`
1: `(p, p)`
2: `(0, p)`

Return the number of the receptor it hits.
Trả về số hiệu của bộ thu mà nó chạm vào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Room Unfolding / Mở rộng Căn phòng
Rather than simulating reflections, imagine the room reflects infinitely in a grid.
Thay vì mô phỏng sự phản xạ, hãy tưởng tượng căn phòng được phản chiếu vô tận trong một lưới.

The laser travels in a straight line with a slope such that it hits a corner when `total_y = m * p` and `total_x = n * q`.
Here, `total_x` will always be a multiple of `p`. Let the distance travelled in Y be `y`.
`y = m * p`, and it happens when `x = n * p`.
The first time it hits a corner is when `n * q = m * p` for the smallest integers `n, m`.
This implies `n * q = LCM(p, q)`.

Algorithm:
1. Divide `p` and `q` by their GCD until one of them is odd.
2. If `p` is even, it hits receptor 2.
3. If `p` is odd and `q` is even, it hits receptor 0.
4. If `p` is odd and `q` is odd, it hits receptor 1.

### Complexity / Độ phức tạp
- **Time**: O(log P) due to GCD.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Parity-based Corner Selection
The final destination depends on how many vertical and horizontal flips the beam undergoes. By simplifying the problem using GCD, we can determine the terminal receptor based on the parity of the counts.
Điểm đến cuối cùng phụ thuộc vào việc chùm tia trải qua bao nhiêu lần lật dọc và ngang. Bằng cách đơn giản hóa bài toán bằng GCD, chúng ta có thể xác định bộ thu cuối cùng dựa trên tính chẵn lẻ của số lượng lần lật.

---

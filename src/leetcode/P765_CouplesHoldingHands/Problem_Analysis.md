# 765. Couples Holding Hands / Những Cặp đôi Nắm tay

## Problem Description / Mô tả bài toán
There are `n` couples sitting in `2n` seats arranged in a row. The people and seats are represented by an integer array `row` where `row[i]` is the ID of the person sitting in the `ith` seat.
Có `n` cặp đôi ngồi trên `2n` ghế được xếp thành một hàng. Mọi người và chỗ ngồi được đại diện bởi một mảng số nguyên `row` trong đó `row[i]` là ID của người ngồi ở ghế thứ `i`.

The couples are `(0, 1), (2, 3), (4, 5), ...`.
Các cặp đôi là `(0, 1), (2, 3), (4, 5), ...`.

In each move, you may choose any two people and they swap seats. Return the minimum number of swaps so that every couple is sitting side by side.
Trong mỗi lần di chuyển, bạn có thể chọn bất kỳ hai người nào và họ hoán đổi chỗ ngồi. Hãy trả về số lần hoán đổi tối thiểu để mọi cặp đôi đều ngồi cạnh nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy of Union-Find / Tham lam hoặc Union-Find
This is a cycle-finding problem in a graph.
Đây là một bài toán tìm chu trình trong đồ thị.

Greedy approach:
1. Iterate through the row two by two (`0, 2, 4...`).
2. For each pair of seats `(i, i+1)`:
   - Identify the partner of the person at `row[i]`. `partner = row[i] ^ 1`.
   - If `row[i+1]` is not the partner:
     - Find where the partner is sitting.
     - Swap the partner with whoever is at `row[i+1]`.
     - Increment swap count.

### Complexity / Độ phức tạp
- **Time**: O(N^2) for the simple greedy with search, or O(N) if we use a map for positions.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Swap with Position Map
Track the current position of every person. Iterate through pairs and swap correctly to unite the current person with their partner.
Theo dõi vị trí hiện tại của mọi người. Lặp qua các cặp và hoán đổi chính xác để kết hợp người hiện tại với đối tác của họ.

---

# 1535. Find the Winner of an Array Game / Tìm Người chiến thắng của Trò chơi Mảng

## Problem Description / Mô tả bài toán
Array `arr`. Distinct integers.
Compare `arr[0]` and `arr[1]`. Larger stays at 0, smaller moves to end.
Winner wins `k` consecutive rounds.
Return winner.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / One Pass
Simulate process without moving array (expensive).
Maintain `currentWinner` and `winCount`.
Iterate through array from index 1.
Compare `currentWinner` vs `arr[i]`.
If `currentWinner` wins: `winCount++`.
If `arr[i]` wins: `currentWinner = arr[i]`, `winCount = 1`.
If `winCount == k`, return `currentWinner`.
If iteration ends, `currentWinner` (max element so far) is the winner (because max element will never lose and eventually reach k or be the only one left).
Actually max element will definitely win infinitely.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Initialize `curr = arr[0]`, `streak = 0`.
Loop `i` 1 to n-1.
Compare `curr` and `arr[i]`.
Update streak.
Return `curr` if `streak == k`.
If loop ends, `curr` is the MAX element, so it wins.
Khởi tạo `curr = arr[0]`, `streak = 0`.
Lặp `i` từ 1 đến n-1.
So sánh `curr` và `arr[i]`. `streak` cập nhật.

---

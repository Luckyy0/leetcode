# 905. Sort Array By Parity / Sắp xếp Mảng theo tính Chẵn lẻ

## Problem Description / Mô tả bài toán
Given an integer array `nums`, move all the even integers at the beginning of the array followed by all the odd integers.
Cho một mảng số nguyên `nums`, hãy chuyển tất cả các số nguyên chẵn lên đầu mảng, sau đó là tất cả các số nguyên lẻ.

Return any array that satisfies this condition.
Trả về bất kỳ mảng nào thỏa mãn điều kiện này.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
Algorithm:
1. Initialize `left = 0`, `right = n - 1`.
2. While `left < right`:
   - If `nums[left]` is odd and `nums[right]` is even:
     - Swap `nums[left]` and `nums[right]`.
   - If `nums[left]` is even: `left++`.
   - If `nums[right]` is odd: `right--`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Converging Pointers
Use two reference points moving toward each other. Every time an "out of place" pair (an odd number on the left and an even one on the right) is found, swap them to incrementally restore the desired order.
Sử dụng hai điểm tham chiếu di chuyển về phía nhau. Mỗi khi phát hiện một cặp "sai vị trí" (một số lẻ ở bên trái và một số chẵn ở bên phải), hãy hoán đổi chúng để khôi phục dần thứ tự mong muốn.

---

# 985. Sum of Even Numbers After Queries / Tổng các Số chẵn sau các Truy vấn

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an array of `queries` where `queries[i] = [val_i, index_i]`.
Cho một mảng số nguyên `nums` và một mảng các `queries` trong đó `queries[i] = [val_i, index_i]`.

For each query, add `val_i` to `nums[index_i]`. Then, return the sum of the even values of `nums`.
Đối với mỗi truy vấn, hãy cộng `val_i` vào `nums[index_i]`. Sau đó, trả về tổng các giá trị chẵn của `nums`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Delta Optimization / Tối ưu hóa Delta
Calculating the sum from scratch for each query is $O(N * Q)$, which is too slow.
Tính toán lại tổng từ đầu cho mỗi truy vấn là $O(N * Q)$, quá chậm.

Algorithm:
1. Precompute `totalEvenSum`: sum of all even numbers in `nums`.
2. For each query `val, idx`:
   - If `nums[idx]` was even, subtract it from `totalEvenSum`.
   - Update `nums[idx] += val`.
   - If `nums[idx]` is now even, add it to `totalEvenSum`.
3. Record `totalEvenSum` for each step.

### Complexity / Độ phức tạp
- **Time**: O(N + Q).
- **Space**: O(Q) for result array.

---

## Analysis / Phân tích

### Approach: Incremental Update
Manage the global even sum by observing only the changes caused by each query. By "undoing" the previous contribution of a modified element and "doing" its new contribution based on parity, we maintain an accurate sum without redundant recalculations.
Quản lý tổng số chẵn toàn cục bằng cách chỉ quan sát những thay đổi do mỗi truy vấn gây ra. Bằng cách "hoàn tác" đóng góp trước đó của một phần tử bị thay đổi và "thực hiện" đóng góp mới của nó dựa trên tính chẵn lẻ, chúng ta duy trì một tổng chính xác mà không cần tính toán lại dư thừa.

---

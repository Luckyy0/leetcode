# 1399. Count Largest Group / Đếm Nhóm Lớn nhất

## Problem Description / Mô tả bài toán
Integers 1 to `n`. Group them by "sum of digits".
Count how many groups have the largest size.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit Sum Calculation
Max `n` = 10000. Sum of digits for 9999 is 36.
Map `sum -> count`.
Iterate 1 to `n`. Compute sum of digits. Update map.
Find Max Size `maxS`.
Count groups with size `maxS`.

### Complexity / Độ phức tạp
- **Time**: O(N * log10(N)).
- **Space**: O(log10(N)).

---

## Analysis / Phân tích

### Approach: Hash Map Counting
Create a map (or array since max sum is small) to store the size of each group (where group ID is the digit sum). Iterate from 1 to `n`. For each number, calculate its digit sum and increment the corresponding group size. Keep track of the maximum group size found. Finally, iterate through the map/array to count how many groups have that maximum size.
Tạo một bản đồ (hoặc mảng vì tổng tối đa nhỏ) để lưu trữ kích thước của mỗi nhóm (trong đó ID nhóm là tổng chữ số). Lặp lại từ 1 đến `n`. Đối với mỗi số, tính tổng chữ số của nó và tăng kích thước nhóm tương ứng. Theo dõi kích thước nhóm tối đa được tìm thấy. Cuối cùng, lặp qua bản đồ/mảng để đếm xem có bao nhiêu nhóm có kích thước tối đa đó.

---

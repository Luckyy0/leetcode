# 952. Largest Component Size by Common Factor / Kích thước Thành phần Lớn nhất theo Ước chung

## Problem Description / Mô tả bài toán
Given an array `nums`, a shared factor `x > 1` exists between `nums[i]` and `nums[j]` if they share a common divisor. Draw an edge if they share a factor.
Cho một mảng `nums`, một ước chung `x > 1` tồn tại giữa `nums[i]` và `nums[j]` nếu chúng có chung ước số. Vẽ một cạnh nếu chúng có chung một ước số.

Return the size of the largest connected component in the graph.
Hãy trả về kích thước của thành phần kết nối lớn nhất trong đồ thị.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Connected Components (Union-Find) and Prime Factorization / Thành phần Kết nối (Union-Find) và Phân tích Thừa số Nguyên tố
Directly drawing edges is $O(N^2)$, too slow.
Việc vẽ các cạnh trực tiếp là $O(N^2)$, quá chậm.

Algorithm:
1. For each number `num` in `nums`:
   - Find all its prime factors.
   - For each factor, union `num` with its prime factors.
   - It's better to union all prime factors of `num` with `num` itself using a DSU.
2. Use a persistent DSU where each number `num` is mapped to its prime factors' representatives.
3. Count sizes of the components in the DSU.

### Complexity / Độ phức tạp
- **Time**: O(N * sqrt(maxVal)).
- **Space**: O(maxVal).

---

## Analysis / Phân tích

### Approach: Indirect Connection via Factors
Instead of linking numbers directly, use their prime factors as intermediate hubs. By grouping all numbers that share a prime factor into the same set, we effectively identify clusters of interconnected values through the Union-Find structure.
Thay vì liên kết trực tiếp các số, hãy sử dụng các thừa số nguyên tố của chúng làm trung tâm trung gian. Bằng cách nhóm tất cả các số có chung một thừa số nguyên tố vào cùng một tập hợp, chúng ta xác định hiệu quả các cụm giá trị liên kết với nhau thông qua cấu trúc Union-Find.

---

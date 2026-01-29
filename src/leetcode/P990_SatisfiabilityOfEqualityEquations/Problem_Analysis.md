# 990. Satisfiability of Equality Equations / Tính thỏa đáng của các Phương trình Đẳng thức

## Problem Description / Mô tả bài toán
Given an array of `equations` (each `a==b` or `a!=b`), return `true` if it's possible to assign values to variables to satisfy all equations.
Cho một mảng các `equations` (mỗi phương trình có dạng `a==b` hoặc `a!=b`), hãy trả về `true` nếu có thể gán giá trị cho các biến để thỏa mãn tất cả các phương trình.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Connected Components (Union-Find) / Thành phần Kết nối (Union-Find)
Algorithm:
1. Process all `==` equations first.
   - For `a==b`, union `a` and `b` into the same set.
2. After processing all `==`, process all `!=` equations.
   - For `a!=b`, if `find(a) == find(b)`, return `false` (inconsistency).
3. If no inconsistency is found, return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (fixed alphabet size 26).

---

## Analysis / Phân tích

### Approach: Constraint Conflict detection
Use a Union-Find structure as a "source of truth" for equality. By first establishing all equivalence classes and then verifying that inequality constraints do not cross these established boundaries, we effectively detect logical contradictions.
Sử dụng cấu trúc Union-Find làm "nguồn sự thật" cho các đẳng thức. Bằng cách trước tiên thiết lập tất cả các lớp tương đương và sau đó xác minh rằng các ràng buộc bất đẳng thức không vi phạm các ranh giới đã thiết lập này, chúng ta sẽ phát hiện các mâu thuẫn logic một cách hiệu quả.

---

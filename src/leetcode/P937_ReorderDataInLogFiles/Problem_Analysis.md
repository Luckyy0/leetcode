# 937. Reorder Data in Log Files / Sắp xếp Dữ liệu trong Tệp Nhật ký

## Problem Description / Mô tả bài toán
You are given an array of `logs`. Each log is a space-delimited string of words, where the first word is the **identifier**.
Bạn được cho một mảng các `logs`. Mỗi nhật ký là một chuỗi các từ được phân tách bằng dấu cách, trong đó từ đầu tiên là **định danh**.

Two types of logs:
1. **Letter-logs**: identifier followed by lowercase English letters.
2. **Digit-logs**: identifier followed by digits.

Sorting rules:
- Letter-logs come before digit-logs.
- Letter-logs are sorted lexicographically by their contents. If contents are equal, sort by identifier.
- Digit-logs maintain their relative order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Custom Comparator / Bộ so sánh Tùy chỉnh
Algorithm:
1. Define a comparator for logs.
2. For two logs `a` and `b`:
   - Split each into `(id, content)`.
   - Check if they are digit-logs or letter-logs.
   - If both are letter-logs: compare contents. If same, compare ids.
   - If one is letter and one is digit: letter-log comes first.
   - If both are digits: maintain relative order (return 0 in comparator).

### Complexity / Độ phức tạp
- **Time**: O(M * N log N), where N is number of logs and M is max length of a log.
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Rule-based Classification
Segment the data based on character types in the payload. Applying a composite sorting logic allows us to implement the hierarchical priority (Letters > Digits) and internal lexicographical ordering simultaneously while preserving stable positioning for digit entries.
Phân đoạn dữ liệu dựa trên các loại ký tự trong tải trọng. Việc áp dụng logic sắp xếp tổng hợp cho phép chúng ta thực hiện đồng thời mức ưu tiên thứ bậc (Chữ cái > Số) và thứ tự từ điển nội bộ trong khi vẫn duy trì vị trí ổn định cho các mục nhập số.

---

# 916. Word Subsets / Các Tập con của Từ

## Problem Description / Mô tả bài toán
You are given two string arrays `words1` and `words2`.
Bạn được cấp hai mảng chuỗi `words1` và `words2`.

A string `b` is a subset of string `a` if every letter in `b` occurs in `a`, including multiplicity.
Chuỗi `b` là tập con của chuỗi `a` nếu mọi chữ cái trong `b` đều xuất hiện trong `a`, tính cả số lượng xuất hiện.

A string `a` in `words1` is **universal** if for every string `b` in `words2`, `b` is a subset of `a`.
Một chuỗi `a` trong `words1` được gọi là **phổ quát (universal)** nếu với mọi chuỗi `b` trong `words2`, `b` là tập con của `a`.

Return all universal strings in `words1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Merging / Hợp nhất Tần suất
To satisfy all strings in `words2`, string `a` must have at least the maximum frequency of each character required by *any* string in `words2`.
Để thỏa mãn tất cả các chuỗi trong `words2`, chuỗi `a` phải có ít nhất là tần suất tối đa của mỗi ký tự được yêu cầu bởi *bất kỳ* chuỗi nào trong `words2`.

Algorithm:
1. Create a `maxFreq` array (size 26).
2. For each string `b` in `words2`:
   - Count frequencies of chars in `b`.
   - Update `maxFreq[c] = max(maxFreq[c], count_in_b[c])`.
3. For each string `a` in `words1`:
   - Count frequencies of chars in `a`.
   - If `count_in_a[c] >= maxFreq[c]` for all `c`, `a` is universal.

### Complexity / Độ phức tạp
- **Time**: O(Total chars in `words1` + Total chars in `words2`).
- **Space**: O(1) auxiliary (arrays of size 26).

---

## Analysis / Phân tích

### Approach: Compressed Requirement Profile
Construct a single "master requirement" by aggregating the peak demands for each character across all target words. Then, filter the source list by verifying if each word meets this cumulative character budget.
Xây dựng một "yêu cầu chính" duy nhất bằng cách tổng hợp các nhu cầu cao điểm cho từng ký tự trên tất cả các từ mục tiêu. Sau đó, lọc danh sách nguồn bằng cách xác minh xem mỗi từ có đáp ứng ngân sách ký tự tích lũy này hay không.

---

# 763. Partition Labels / Phân vùng Nhãn

## Problem Description / Mô tả bài toán
You are given a string `s`. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Bạn được cho một chuỗi `s`. Chúng ta muốn chia chuỗi thành nhiều phần nhất có thể sao cho mỗi chữ cái chỉ xuất hiện trong tối đa một phần.

Return a list of integers representing the size of these parts.
Trả về một danh sách các số nguyên đại diện cho kích thước của các phần này.

### Example:
```text
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Ex: "ababcbaca", "defegde", "hijhklij"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Strategy / Chiến lược Tham lam
Each letter must be contained entirely within a single partition.
Mỗi chữ cái phải nằm hoàn toàn trong một phân vùng duy nhất.

Algorithm:
1. Find the last index of each character in the string.
2. Iterate through the string, maintaining `furthestEnd` which is the maximum last index of all characters seen in the current partition.
3. When the current index `i` reaches `furthestEnd`, it means all characters in the current range `[start, i]` do not appear outside this range.
4. Record the length `i - start + 1` and update `start = i + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1) for character occurrences (26 characters).

---

## Analysis / Phân tích

### Approach: Furthest Occurrence Tracking
By knowing where each character ends, we know the "minimum" boundary of the current partition. The partition only closes when we've processed every character up to its respective last occurrence.
Bằng cách biết vị trí kết thúc của mỗi ký tự, chúng ta biết được ranh giới "tối thiểu" của phân vùng hiện tại. Phân vùng chỉ đóng lại khi chúng ta đã xử lý mọi ký tự cho đến lần xuất hiện cuối cùng tương ứng của nó.

---

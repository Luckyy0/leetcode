# 846. Hand of Straights / Bộ bài Liên tiếp

## Problem Description / Mô tả bài toán
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size `groupSize`, and consists of `groupSize` consecutive cards.
Alice có một số lượng quân bài và cô ấy muốn sắp xếp lại các quân bài đó thành các nhóm sao cho mỗi nhóm có kích thước `groupSize` và bao gồm `groupSize` quân bài liên tiếp.

Given an integer array `hand` and an integer `groupSize`, return `true` if she can rearrange the cards, or `false` otherwise.
Cho mảng số nguyên `hand` và số nguyên `groupSize`, trả về `true` nếu cô ấy có thể sắp xếp lại các quân bài, ngược lại trả về `false`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with TreeMap / Tham lam với TreeMap
We want to always start with the smallest card available to form a straight.
Chúng ta muốn luôn bắt đầu với quân bài nhỏ nhất hiện có để tạo thành một dãy liên tiếp.

Algorithm:
1. Count frequency of each card using a `TreeMap` (sorted by key).
2. While the map is not empty:
   - Pick the smallest card `first`.
   - For each card from `first` to `first + groupSize - 1`:
     - If the card is not in the map, return `false`.
     - Decrement its count. If count reaches 0, remove it.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N log UniqueCards).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Frequency-based sequential extraction
Always attempt to satisfy the smallest requirement first. Since any card must eventually be part of a group, starting with the minimum ensures a deterministic path for checking consecutive sequences.
Luôn cố gắng đáp ứng yêu cầu nhỏ nhất trước. Vì bất kỳ lá bài nào cuối cùng cũng phải thuộc về một nhóm, nên việc bắt đầu với giá trị tối thiểu sẽ đảm bảo một con đường xác định để kiểm tra các dãy liên tiếp.

---

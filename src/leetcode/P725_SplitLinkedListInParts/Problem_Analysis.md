# 725. Split Linked List in Parts / Chia Danh sách Liên kết thành các Phần

## Problem Description / Mô tả bài toán
Given the `head` of a singly linked list and an integer `k`, split the linked list into `k` consecutive linked list parts.
Cho `head` của một danh sách liên kết đơn và một số nguyên `k`, hãy chia danh sách liên kết thành `k` phần danh sách liên kết liên tiếp.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
Độ dài của mỗi phần phải bằng nhau nhất có thể: không có hai phần nào có kích thước chênh lệch quá một. Điều này có thể dẫn đến một số phần bị null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
Các phần phải theo thứ tự xuất hiện trong danh sách đầu vào và các phần xuất hiện sớm hơn phải luôn có kích thước lớn hơn hoặc bằng các phần xuất hiện sau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### List Traversal / Duyệt Danh sách
1. Calculate the total length `N` of the list.
2. The base size of each part is `N / k`.
3. The first `N % k` parts will have an extra node (`baseSize + 1`).

Algorithm:
- Split the list by severing the `next` pointer at appropriate indices.

### Complexity / Độ phức tạp
- **Time**: O(N + K) where N is the length of the list and K is the number of parts.
- **Space**: O(K) to store the result array (not counting the list nodes themselves).

---

## Analysis / Phân tích

### Approach: Proportional Splitting
Calculate the count of items per bucket. Traverse and disconnect the list at each bucket boundary.
Tính số lượng các mục trên mỗi thùng chứa (bucket). Duyệt qua và ngắt kết nối danh sách tại mỗi ranh giới thùng chứa.

---

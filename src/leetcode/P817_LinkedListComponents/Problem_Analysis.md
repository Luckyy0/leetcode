# 817. Linked List Components / Các Thành phần trong Danh sách liên kết

## Problem Description / Mô tả bài toán
You are given the `head` of a linked list containing unique integer values and an integer array `nums` that is a subset of the values in the linked list.
Bạn được cấp `head` của một danh sách liên kết chứa các giá trị nguyên duy nhất và một mảng số nguyên `nums` là tập hợp con của các giá trị trong danh sách liên kết đó.

Return the number of connected components in `nums`, where two values are connected if they appear consecutively in the linked list.
Trả về số lượng các thành phần được kết nối trong `nums`, trong đó hai giá trị được kết nối nếu chúng xuất hiện liên tiếp trong danh sách liên kết.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Traversal with Membership Checking / Duyệt tuyến tính với Kiểm tra Tư cách Thành viên
A "component" is a sequence of one or more nodes in the linked list whose values are all present in `nums`.
Một "thành phần" là một chuỗi gồm một hoặc nhiều nút trong danh sách liên kết mà các giá trị của chúng đều có mặt trong `nums`.

Algorithm:
1. Store all elements of `nums` in a `HashSet` for O(1) lookup.
2. Traverse the linked list.
3. Identify the start of a component:
   - Current node `val` is in `Set`.
   - Previous node `val` was NOT in `Set` (or current is the head).
4. Increment component count.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N is list length and M is nums length.
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Consecutive Block Detection
Iterate through the linked list while checking if the current value exists in the target set. A new component begins only when we transition from a non-member (or start of list) to a member.
Duyệt qua danh sách liên kết đồng thời kiểm tra xem giá trị hiện tại có tồn tại trong tập hợp mục tiêu hay không. Một thành phần mới chỉ bắt đầu khi chúng ta chuyển đổi từ một giá trị không thuộc tập hợp (hoặc đầu danh sách) sang một giá trị thuộc tập hợp.

---

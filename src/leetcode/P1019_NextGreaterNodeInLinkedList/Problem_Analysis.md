# 1019. Next Greater Node In Linked List / Nút Lớn hơn Tiếp theo trong Danh sách Liên kết

## Problem Description / Mô tả bài toán
Given the `head` of a linked list, return an integer array `answer` where `answer[i]` is the value of the next greater node of the `i-th` node. If no such node exists, `answer[i]` is 0.
Cho `head` của một danh sách liên kết, hãy trả về một mảng số nguyên `answer`, trong đó `answer[i]` là giá trị của nút lớn hơn tiếp theo của nút thứ `i`. Nếu không tồn tại nút như vậy, `answer[i]` là 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
Standard Next Greater Element algorithm.
Thuật toán Phần tử Lớn hơn Tiếp theo tiêu chuẩn.

Algorithm:
1. Convert LinkedList to ArrayList (for index access or easier mapping).
2. Stack stores *indices*.
3. Iterate through values:
   - While stack not empty and `vals[stack.peek()] < currentVal`:
     - `index = stack.pop()`
     - `res[index] = currentVal`
   - `stack.push(currentIndex)`
4. Remaining indices in stack have no next greater node (default 0).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linearization and Stack Processing
First, linearize the linked list into an array to allow random access and result filling. Then, utilize a monotonic decreasing stack to resolve the "next greater" queries efficiently in a single pass, matching waiting elements with their first subsequent larger value.
Đầu tiên, tuyến tính hóa danh sách liên kết thành một mảng để cho phép truy cập ngẫu nhiên và điền kết quả. Sau đó, sử dụng ngăn xếp giảm đơn điệu để giải quyết các truy vấn "lớn hơn tiếp theo" một cách hiệu quả trong một lần duyệt, khớp các phần tử đang chờ với giá trị lớn hơn tiếp theo đầu tiên của chúng.

---

# 1213. Intersection of Three Sorted Arrays / Giao của Ba Mảng đã Sắp xếp

## Problem Description / Mô tả bài toán
Given three integer arrays `arr1`, `arr2`, and `arr3`, sorted in strictly increasing order, return a sorted array of only integers that appeared in all three arrays.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Three Pointers / Ba con trỏ
Iterate three arrays. `i, j, k`.
- If `arr1[i] == arr2[j] == arr3[k]`: Add to result, increment all.
- Else: increment pointer corresponding to the minimal value.
Sorted property allows this O(N).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Three-Pointer Traversal
Since all three arrays are strictly increasing, use three pointers (`p1, p2, p3`), initially at the start of each array. Compare the values pointed to by the three pointers. If they are equal, add the value to the result and advance all pointers. Otherwise, identify the minimum value among the three and advance its corresponding pointer to "catch up". Continue until any pointer reaches the end of its array. This finds the intersection in linear time.
Vì cả ba mảng đều tăng nghiêm ngặt, hãy sử dụng ba con trỏ (`p1, p2, p3`), ban đầu ở đầu mỗi mảng. So sánh các giá trị được trỏ bởi ba con trỏ. Nếu chúng bằng nhau, hãy thêm giá trị vào kết quả và nâng cao tất cả các con trỏ. Nếu không, xác định giá trị tối thiểu trong ba giá trị và nâng cao con trỏ tương ứng của nó để "bắt kịp". Tiếp tục cho đến khi bất kỳ con trỏ nào đến cuối mảng của nó. Điều này tìm thấy giao điểm trong thời gian tuyến tính.

---

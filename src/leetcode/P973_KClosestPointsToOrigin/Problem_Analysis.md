# 973. K Closest Points to Origin / K Điểm gần Gốc tọa độ nhất

## Problem Description / Mô tả bài toán
Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.
Cho một mảng các `points` trong đó `points[i] = [xi, yi]` đại diện cho một điểm trên mặt phẳng X-Y và một số nguyên `k`, hãy trả về `k` điểm gần gốc tọa độ `(0, 0)` nhất.

The distance between two points is the Euclidean distance: $\sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$.
Khoảng cách giữa hai điểm là khoảng cách Euclide: $\sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting or Heap or QuickSelect / Sắp xếp hoặc Heap hoặc QuickSelect
Algorithm:
1. **Sorting**: Sort all points by distance squared. $O(N \log N)$.
2. **Max-Heap**: Maintain a heap of size `k`. $O(N \log k)$.
3. **QuickSelect**: Average $O(N)$, worst $O(N^2)$.

### Complexity / Độ phức tạp
- **Time**: O(N log K) using a Max-Heap or O(N log N) using sorting.
- **Space**: O(K) for Heap or O(N) for sorting.

---

## Analysis / Phân tích

### Approach: Partial Magnitude Ordering
Maintain a selection of the $K$ best candidates encountered so far. By using a max-priority queue, we can efficiently prune points that are further than our current $K$-th best distance, ensuring only the closest points remain in the buffer.
Duy trì một lựa chọn gồm $K$ ứng viên tốt nhất đã gặp cho đến nay. Bằng cách sử dụng hàng đợi ưu tiên cực đại, chúng ta có thể loại bỏ hiệu quả các điểm ở xa hơn khoảng cách tốt thứ $K$ hiện tại, đảm bảo chỉ những điểm gần nhất mới được giữ lại trong bộ nhớ đệm.

---

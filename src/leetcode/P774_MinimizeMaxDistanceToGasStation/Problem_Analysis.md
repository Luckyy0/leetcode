# 774. Minimize Max Distance to Gas Station / Giảm thiểu Khoảng cách Tối đa đến Trạm xăng

## Problem Description / Mô tả bài toán
You are given an integer array `stations` that represents the positions of gas stations on a 1D line. You are also given an integer `k`.
Bạn được cho một mảng số nguyên `stations` đại diện cho vị trí của các trạm xăng trên một trục số 1D. Bạn cũng được cho một số nguyên `k`.

You want to add `k` new gas stations. You can add the stations anywhere on the line, but you must minimize the **maximum distance** between adjacent stations after adding all `k` stations.
Bạn muốn thêm `k` trạm xăng mới. Bạn có thể thêm các trạm ở bất kỳ đâu trên đường thẳng, nhưng bạn phải giảm thiểu **khoảng cách tối đa** giữa các trạm lân cận sau khi thêm tất cả `k` trạm.

Return the minimum possible maximum distance.
Trả về khoảng cách tối đa tối thiểu có thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm kiếm Nhị phân trên Kết quả
The answer (max distance) is in range `[0, 10^8]`.
Kết quả (khoảng cách tối đa) nằm trong phạm vi `[0, 10^8]`.

If we propose that the max distance is `D`, how many stations do we need to add?
Nếu chúng ta đề xuất khoảng cách tối đa là `D`, chúng ta cần thêm bao nhiêu trạm?

Between stations at positions `A` and `B`, the distance is `L = B - A`.
To ensure gaps are `<= D`, we need `ceil(L / D) - 1` additional stations.
Để đảm bảo các khoảng trống `<= D`, chúng ta cần thêm `ceil(L / D) - 1` trạm bổ sung.

Algorithm:
1. Binary search for `D` in `[0, MaxDistance]`.
2. For each `mid`:
   - Calculate total stations needed.
   - If `needed <= k`, search smaller (`high = mid`).
   - Else search larger (`low = mid`).

### Complexity / Độ phức tạp
- **Time**: O(N log(Range/Precision)) where N is number of initial stations.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search with Constraint Verification
Find the optimal distance by treating it as the decision variable. At each step, calculate the required overhead to satisfy that distance.
Tìm khoảng cách tối ưu bằng cách coi nó là một biến quyết định. Ở mỗi bước, hãy tính toán chi phí bổ sung cần thiết để đáp ứng khoảng cách đó.

---

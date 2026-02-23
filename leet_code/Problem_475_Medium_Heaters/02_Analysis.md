# Analysis for Heaters
# *Phân tích cho bài toán Máy sưởi*

## 1. Problem Essence & Nearest Neighbor
## *1. Bản chất vấn đề & Hàng xóm Gần nhất*

### The Challenge
### *Thách thức*
Finding the minimum radius required such that every house is covered by at least one heater. This involves calculating the distance from each house to its **closest** heater, and then taking the **maximum** of those minimum distances.
- $Radius = \max_{h \in houses} (\min_{H \in heaters} |h - H|)$

### Strategy: Sorting + Binary Search
### *Chiến lược: Sắp xếp + Tìm kiếm Nhị phân*

1.  **Sorting:** Sort the `heaters` array. This allows us to quickly find the nearest heater for any house using binary search.
2.  **Iterate Houses:** For each `house`:
    - Find the position of the house in the sorted `heaters` array (using `Arrays.binarySearch` or a custom implementation).
    - If the house is found at a heater's location, distances is 0.
    - If not found, `binarySearch` returns an insertion point. The closest heaters are the ones immediately to the **left** and **right** of this insertion point.
    - Calculate `dist1` (to left heater) and `dist2` (to right heater).
    - `minDist` for this house is `min(dist1, dist2)`.
    - Update global `maxRadius = max(maxRadius, minDist)`.

---

## 2. Approach: Closest Pair Logic
## *2. Hướng tiếp cận: Logic Cặp gần nhất*

### Logic
### *Logic*
(See above). The complexity is dominated by sorting the heaters. Then for each house, we do a $O(\log M)$ search.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimality:** $O(N \log M)$ is much better than brute force $O(N \cdot M)$.
    *Tính tối ưu: $O(N \log M)$ tốt hơn nhiều so với vét cạn $O(N \cdot M)$.*
*   **Simplicity:** Uses standard library functions.
    *Sự đơn giản: Sử dụng các hàm thư viện chuẩn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \log M + N \log M)$ where $N$ is houses length and $M$ is heaters length.
    *Độ phức tạp thời gian: $O(M \log M + N \log M)$.*
*   **Space Complexity:** $O(1)$ or $O(\log M)$ for sorting stack.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `houses=[1,2,3,4], heaters=[1,4]`
1. Sorted heaters: `[1, 4]`.
2. House `1`: Found at index 0. Dist = 0.
3. House `2`: Insert point between 1 and 4.
   - Left heater: 1. Dist = `2-1 = 1`.
   - Right heater: 4. Dist = `4-2 = 2`.
   - Min = 1.
4. House `3`: Insert point between 1 and 4.
   - Left heater: 1. Dist = `3-1 = 2`.
   - Right heater: 4. Dist = `4-3 = 1`.
   - Min = 1.
5. House `4`: Found at index 1. Dist = 0.
Result: `max(0, 1, 1, 0) = 1`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sort heaters and find nearest heater for each house using binary search.
*Sắp xếp các máy sưởi và tìm máy sưởi gần nhất cho mỗi ngôi nhà bằng tìm kiếm nhị phân.*
---
*Hơi ấm không cần phải bao phủ tất cả mọi nơi cùng lúc, nó chỉ cần đủ gần với những ai đang cần đến nó. Bằng cách sắp xếp trật tự các nguồn nhiệt (sorted heaters) và tìm kiếm điểm tựa gần nhất (nearest neighbor) cho mỗi cá thể (house), ta tìm ra bán kính tối thiểu để sự ấm áp lan tỏa vẹn toàn. Giải pháp tốt nhất không phải là lớn nhất, mà là sự vừa vặn nhất.*
Warmth does not need to cover everywhere at the same time, it just needs to be close enough to those who need it. By arranging the order of heat sources (sorted heaters) and finding the nearest fulcrum (Nearest Neighbor) for each individual (house), we find the minimum radius so that the warmth spreads completely. The best solution is not the biggest, but the most fit.

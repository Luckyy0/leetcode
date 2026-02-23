# Analysis for Random Pick with Weight
# *Phân tích cho bài toán Chọn Ngẫu nhiên theo Trọng số*

## 1. Problem Essence & Distribution Mapping
## *1. Bản chất vấn đề & Ánh xạ Phân phối*

### The Challenge
### *Thách thức*
Simulating a non-uniform discrete distribution.
- Weights represent intervals on a number line.
- Bigger weight -> Bigger interval -> Higher chance.

### Strategy: Prefix Sum + Binary Search
### *Chiến lược: Tổng Tiền tố + Tìm kiếm Nhị phân*

1.  **Prefix Sum:** Construct array `prefix` where `prefix[i] = w[0] + ... + w[i]`.
    - Intervals are `(0, prefix[0]]`, `(prefix[0], prefix[1]]`, etc.
    - Total range is `[1, prefix[n-1]]`.
2.  **Random Pick:** Generate `target` in `[1, total]`.
3.  **Search:** Find the first index `i` such that `prefix[i] >= target`.
    - Since `prefix` is sorted, use Binary Search.

---

## 2. Approach: Prefix Array and Binary Search
## *2. Hướng tiếp cận: Mảng Tiền tố và Tìm kiếm Nhị phân*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Setup, O(log N) Query:** Fast retrieval.
    *Thiết lập O(N), Truy vấn O(log N): Truy xuất nhanh.*
*   **Space O(N):** Linear storage.
    *Không gian O(N): Lưu trữ tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Constructor $O(N)$, `pickIndex` $O(\log N)$.
    *Độ phức tạp thời gian: Thêm $O(N)$, Chọn $O(\log N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 3]` -> Prefix `[1, 4]`.
Query: Rand(4) + 1 -> Value in `[1, 4]`.
- If 1: `prefix[0] >= 1`. Ret 0.
- If 2: `prefix[0] < 2`. `prefix[1] >= 2`. Ret 1.
- If 3, 4: Ret 1.
Prob(0) = 1/4. Prob(1) = 3/4. Matches.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Accumulate weights into prefix array, binary search random target.
*Tích lũy trọng số vào mảng tiền tố, tìm kiếm nhị phân mục tiêu ngẫu nhiên.*
---
*Cơ hội (probability) không chia đều cho tất cả. Bằng cách tích lũy (prefix sum), ta xây dựng nên những vùng lãnh thổ (intervals) tương ứng với tầm vóc của mỗi lựa chọn. Trong sự vô định của ngẫu nhiên (random), kẻ có nền tảng lớn hơn sẽ chiếm lĩnh không gian lớn hơn.*
Opportunity (Probability) is not divided equally for all. By accumulating (Prefix Sum), we build territories (Intervals) corresponding to the stature of each choice. In the uncertainty of randomness (Random), the one with the larger foundation will occupy a larger space.

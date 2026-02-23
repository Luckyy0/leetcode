# Analysis for The Skyline Problem
# *Phân tích cho bài toán Đường chân trời*

## 1. Problem Essence & Sweep Line
## *1. Bản chất vấn đề & Thuật toán Quét đường*

### The Contour
### *Đường viền*
The skyline only changes at the **start** or **end** of a building.
- At `start`: Height might increase.
- At `end`: Height might decrease.
*Đường chân trời chỉ thay đổi tại điểm **bắt đầu** hoặc **kết thúc** của một tòa nhà.*

We need to process these "Critical Points" in order of their X-coordinates.
*Chúng ta cần xử lý các "Điểm tới hạn" này theo thứ tự tọa độ X.*

### The Max Height Property
### *Tính chất chiều cao tối đa*
At any point `x`, the height of the skyline is the **maximum** height of all valid buildings that cover `x` (i.e., `left <= x < right`).
*Tại bất kỳ điểm `x` nào, chiều cao của đường chân trời là chiều cao **tối đa** của tất cả các tòa nhà hợp lệ bao phủ `x`.*

---

## 2. Approach: Sweep Line with Max Heap
## *2. Hướng tiếp cận: Quét đường với Max Heap*

### Data Structures
### *Cấu trúc dữ liệu*
1.  **Events List:** Separate each building `[L, R, H]` into two events:
    - `(L, -H)`: Start of building. Encode height as negative to act as a tie-breaker (process start before end if x is same, and higher start before lower start).
    - `(R, H)`: End of building. Positive height.
    *Danh sách sự kiện: Tách mỗi tòa nhà thành `(L, -H)` và `(R, H)`.*
2.  **Max Heap (Priority Queue):** Stores the heights of all "live" buildings currently intersected by the sweep line.
    *Max Heap: Lưu trữ chiều cao của các tòa nhà đang "sống".*

### Algorithm
### *Thuật toán*
1.  Add all events to a list and sort them:
    - Primary key: `x` (coordinate).
    - Secondary key: `height`.
    *Why special sorting?*
    - Start `(L, -H)` comes before End `(R, H)` if `x` is same (overlap).
    - Higher start comes before lower start (to register peak immediately).
    - Lower end comes before higher end (technically less critical but good for consistency).
2.  Initialize Heap with `0` (ground level). Initialize `prevMax = 0`.
3.  Iterate through sorted events:
    - If Start event `(h < 0)`: Add `-h` to Heap.
    - If End event `(h > 0)`: Remove `h` from Heap.
    - Check `currentMax = heap.peek()`.
    - If `currentMax != prevMax`:
        - We found a "Key Point"! Add `[x, currentMax]` to result.
        - `prevMax = currentMax`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Discrete Processing:** We transform a continuous geometric problem into discrete event processing.
    *Xử lý rời rạc: Biến bài toán hình học liên tục thành xử lý sự kiện rời rạc.*
*   **Priority Queue:** Efficiently gives us the "Current Max Height" in $O(1)$ or $O(\log N)$.
    *Hàng đợi ưu tiên: Cung cấp Chiều cao tối đa hiện tại một cách hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting events. Heap operations take $O(N \log N)$ (or $O(N^2)$ in Java's `remove(Object)` worst case, but typically fast enough). To strictly get $O(N \log N)$, one needs a "Lazy Removal" heap strategy (TreeMap or delaying removal).
    *Độ phức tạp thời gian: $O(N \log N)$. Lời cảnh báo: `remove` trong PQ Java là $O(N)$. Sử dụng TreeMap hoặc Lazy Removal để đạt chuẩn $O(N \log N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

### Logic for Tie-Breaking (Sorting)
- `(x, -H)` vs `(x, -H2)`: Sort by `-H` ascending (Height descending). Start higher building first.
- `(x, H)` vs `(x, H2)`: Sort by `H` ascending. Remove lower building first? (Actually end events order matters less relative to each other, but must come after starts).
- `(x, -H)` vs `(x, H2)`: Start must process before End. Since `-H < 0` and `H2 > 0`, Start comes first naturally.
*Logic phá vỡ thế cân bằng: Start (-H) luôn nhỏ hơn End (H), nên Start được xử lý trước.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Buildings:** `[[0, 2, 3], [2, 5, 3]]`
Events:
`[0, -3]` (Start B1)
`[2, 3]` (End B1)
`[2, -3]` (Start B2)
`[5, 3]` (End B2)

**Sort:**
1. `(0, -3)`
2. `(2, -3)` (Start B2 comes before End B1 because -3 < 3)
3. `(2, 3)`
4. `(5, 3)`

**Sweep:**
1. `(0, -3)`: Heap `[0, 3]`. Max 3 != 0. Add `[0, 3]`. Prev=3.
2. `(2, -3)`: Heap `[0, 3, 3]`. Max 3 == 3. No change.
3. `(2, 3)`: Remove 3. Heap `[0, 3]`. Max 3 == 3. No change.
4. `(5, 3)`: Remove 3. Heap `[0]`. Max 0 != 3. Add `[5, 0]`. Prev=0.

**Result:** `[[0, 3], [5, 0]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The Skyline Problem is a famous "Hard" problem because handling edge cases (connected buildings, buildings inside buildings) is brutal without a clean "Event Sorting" strategy. Using negative heights for start events is the pro-tip that simplifies sorting logic immensely.
*Bài toán Đường chân trời nổi tiếng là "Khó" vì các trường hợp biên rất phức tạp. Sử dụng chiều cao âm cho sự kiện bắt đầu là mẹo chuyên nghiệp giúp đơn giản hóa logic sắp xếp.*
---
*Đường chân trời không được vẽ bởi từng viên gạch, mà bởi những đỉnh cao nhất và những khoảng lặng (kết thúc) của chúng.*
The skyline is not drawn by every single brick, but by their highest peaks and their silences (ends).

# Analysis for Rectangle Area II
# *Phân tích cho bài toán Diện tích Hình chữ nhật II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Calculate the total area covered by multiple overlapping rectangles. The coordinates are huge ($10^9$), but the number of rectangles is small ($200$). This suggests an algorithm whose complexity depends on the number of rectangles, not the coordinate space.
*Tính tổng diện tích được bao phủ bởi nhiều hình chữ nhật chồng lấn. Tọa độ rất lớn ($10^9$), nhưng số lượng hình chữ nhật nhỏ ($200$). Điều này gợi ý một thuật toán có độ phức tạp phụ thuộc vào số lượng hình chữ nhật.*

---

## 2. Strategy: Sweep Line + Coordinate Compression
## *2. Chiến lược: Đường quét (Sweep Line) + Nén tọa độ*

### Key Concept
### *Khái niệm chính*
Imagine a vertical line "sweeping" across the plane from left to right.
1. The vertical lines (x-coordinates) divide the plane into vertical strips.
2. Inside each strip, the set of active rectangles (those covering this x-range) is constant.
3. We only need to calculate the height of the union of y-intervals for these active rectangles.
*Tưởng tượng một đường thẳng đứng "quét" qua mặt phẳng từ trái sang phải. Các đường thẳng đứng (tọa độ x) chia mặt phẳng thành các dải dọc. Trong mỗi dải, tập hợp các hình chữ nhật đang hoạt động là không đổi. Chúng ta chỉ cần tính chiều cao hợp của các đoạn y của các hình chữ nhật này.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Extract Events:** For each rectangle `[x1, y1, x2, y2]`, create two events:
    - Entering event at `x1`: `(y1, y2, type = 1)`
    - Leaving event at `x2`: `(y1, y2, type = -1)`
    Store these in a list and sort by `x`.
    *   **Trích xuất sự kiện:** Với mỗi hình chữ nhật, tạo hai sự kiện: vào tại `x1` và ra tại `x2`. Lưu vào một danh sách và sắp xếp theo `x`.*

2.  **Coordinate Compression (Y-axis):** Extract all unique `y` coordinates and sort them. This defines the possible "height" blocks.
    *   **Nén tọa độ (Trục Y):** Trích xuất tất cả các tọa độ `y` duy nhất và sắp xếp chúng.*

3.  **Sweep:**
    - For each pair of consecutive x-events:
        - Calculate the current "active height" of the union of all y-intervals.
        - `Area = Area + activeHeight * (x_next - x_curr)`.
        - Update the active y-intervals based on the current event.
    *   **Quét:** Với mỗi cặp sự kiện x liên tiếp: Tính chiều cao hoạt động hiện tại của hợp tất cả các đoạn y. Diện tích = Diện tích + chiều cao * (x\_sau - x\_trước). Cập nhật các đoạn y dựa trên phần tử hiện tại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int rectangleArea(int[][] rectangles) {
    int OPEN = 0, CLOSE = 1;
    int[][] events = new int[rectangles.length * 2][4];
    int t = 0;
    for (int[] r: rectangles) {
        events[t++] = new int[]{r[0], OPEN, r[1], r[3]};
        events[t++] = new int[]{r[2], CLOSE, r[1], r[3]};
    }
    Arrays.sort(events, (a, b) -> a[0] - b[0]);

    List<int[]> active = new ArrayList<>();
    long ans = 0, cur_x = events[0][0];
    
    for (int[] event: events) {
        long curHeight = 0, query_y = -1;
        Collections.sort(active, (a, b) -> a[0] - b[0]);
        for (int[] interval: active) {
            query_y = Math.max(query_y, interval[0]);
            curHeight += Math.max(0, interval[1] - query_y);
            query_y = Math.max(query_y, interval[1]);
        }
        ans += curHeight * (event[0] - cur_x);
        if (event[1] == OPEN) active.add(new int[]{event[2], event[3]});
        else {
            for (int i = 0; i < active.size(); i++) {
                if (active.get(i)[0] == event[2] && active.get(i)[1] == event[3]) {
                    active.remove(i); break;
                }
            }
        }
        cur_x = event[0];
    }
    return (int) (ans % 1000000007);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \log N)$, where $N$ is the number of rectangles. There are $2N$ x-events. At each event, we sort active y-intervals (up to $N$) and merge them ($O(N \log N)$).
    *   **Độ phức tạp thời gian:** $O(N^2 \log N)$, vì có $2N$ sự kiện x, tại mỗi sự kiện ta sắp xếp và hợp nhất tối đa $N$ đoạn y.*
*   **Space Complexity:** $O(N)$ to store events and active intervals.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The Sweep Line algorithm is the standard technique for computational geometry problems involving unions of shapes. Coordinate compression allows us to disregard the massive coordinate values and only focus on the relative positions of edges.
*Thuật toán Đường quét là kỹ thuật tiêu chuẩn cho các bài toán hình học tính toán liên quan đến hợp của các hình. Nén tọa độ giúp bỏ qua các giá trị tọa độ lớn và chỉ tập trung vào vị trí tương đối của các cạnh.*

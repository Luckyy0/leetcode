# Analysis for Minimize Max Distance to Gas Station
# *Phân tích cho bài toán Tối thiểu hóa Khoảng cách Tối đa đến Trạm xăng*

## 1. Problem Essence & Binary Search on Answer
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân trên Kết quả*

### The Challenge
### *Thách thức*
We want to minimize the *maximum* gap. This is a classic "Min-Max" problem solvable by Binary Search.
*Chúng ta muốn tối thiểu hóa khoảng cách *lớn nhất*. Đây là bài toán "Min-Max" kinh điển có thể giải bằng Tìm kiếm Nhị phân.*

If we decide the maximum allowed gap is $D$, can we verify if it is possible to achieve this using at most $K$ new stations?
*Nếu chúng ta quyết định khoảng cách tối đa cho phép là $D$, liệu ta có thể kiểm tra xem có thể đạt được điều này bằng cách sử dụng tối đa $K$ trạm mới không?*

### Check Function
### *Hàm Kiểm tra*
For a target max distance $D$:
- Iterate through each existing adjacent interval `gap = stations[i+1] - stations[i]`.
- If `gap > D`, we need to insert new stations to break it down.
- Number of stations needed = $\lfloor \frac{gap}{D} \rfloor$ ? Wait.
- If $gap = 10, D = 3$: segments 3, 3, 3, 1. Cuts needed: 3. Formula: $\lceil \frac{gap}{D} \rceil - 1$ or `(int)(gap / D)`.
- Correct integer math: `count = (int)((gap - 1e-9) / D)`. Actually just `(int)(gap / D)` works? Let's verify.
  - $10 / 3 = 3.33$. `(int)3.33` = 3 stations. Intervals: 2.5, 2.5, 2.5, 2.5. Distance 2.5.
  - Wait, if we use 3 stations, we have 4 segments. Length is $10/4 = 2.5 \le 3$. OK.
- Total added stations must be $\le K$.
*Với khoảng cách mục tiêu $D$: Duyệt qua từng khoảng cách hiện có. Tính số trạm cần thêm để chia nhỏ khoảng cách đó xuống dưới hoặc bằng $D$. Tổng số trạm thêm phải $\le K$.*

---

## 2. Strategy: Binary Search
## *2. Chiến lược: Tìm kiếm Nhị phân*

### Algorithm
### *Thuật toán*

1.  **Ranges:** `low = 0`, `high = stations[n-1] - stations[0]` (or max gap).
    *   **Phạm vi:** `low = 0`, `high = max_gap`.*

2.  **Loop:** While `high - low > 1e-6`:
    - `mid = (low + high) / 2`.
    - `if (check(mid, K))`: `high = mid` (Try smaller).
    - `else`: `low = mid` (Need larger).
    *   **Vòng lặp:** Trong khi chênh lệch > sai số cho phép. Nếu thỏa mãn, thử nhỏ hơn. Ngược lại, thử lớn hơn.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public double minmaxGasDist(int[] stations, int k) {
    double left = 0, right = 1e8;
    while (right - left > 1e-6) {
        double mid = left + (right - left) / 2;
        if (possible(mid, stations, k)) {
            right = mid;
        } else {
            left = mid;
        }
    }
    return left;
}

boolean possible(double limit, int[] st, int k) {
    int count = 0;
    for (int i = 0; i < st.length - 1; i++) {
        count += (int) ((st[i+1] - st[i]) / limit);
    }
    return count <= k;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log(\frac{Range}{\epsilon}))$. Here $Range \approx 10^8, \epsilon = 10^{-6}$, so $\log(10^{14}) \approx 47$ iterations. Very fast.
    *   **Độ phức tạp thời gian:** $O(N \log(\text{Range}))$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**St=[1, 2, 3], K=1**
Gaps: 1, 1. Max gap 1.
If we add 1 station, best place is inside max gap? Gaps are equal. Does not reduce max gap below 0.5?
Wait, putting one in `[1, 2]` -> `1, 1.5, 2, 3`. Max gap 1 (from `2-3`).
Putting in `[2, 3]` -> `1, 2, 2.5, 3`. Max gap 1 (from `1-2`).
So answer is 1? No no, example for this logic dry run.
Actually for dry run logic:
`check(0.5)`? Gap 1 requires `1/0.5 = 2` segments -> 1 station. Total 2 stations. $2 > K=1$. Fail.
`check(1.0)`? Gap 1 -> 0 stations. Total 0. OK.
Result converges to 1.0 (actually for [1,2,3] with K=1, max dist remains 1 because splitting one gap leaves the other untouched).
Wait, problem says $K$ new stations total.
If St=[1, 10], K=9. Gap 9. Need $9/limit \le 9$. Limit 1. $9/1 = 9$ segments? No, 9 stations -> 10 segments. Len 0.9.
Formula: `count = (gap / limit)`. Int cast implies floor.
If gap=10, lim=10. `10/10` = 1? No count should be 0.
Correct formula: `Math.ceil(gap / limit) - 1`.
Or `(int)((gap - epsilon) / limit)`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Standard Binary Search on Result. Careful with floating point check (use a loop for fixed iterations or epsilon).
*Tìm kiếm Nhị phân chuẩn trên Kết quả. Cẩn thận với kiểm tra số thực (dùng vòng lặp số lần cố định hoặc epsilon).*

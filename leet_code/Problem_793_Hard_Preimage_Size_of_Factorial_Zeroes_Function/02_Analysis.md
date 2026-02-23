# Analysis for Preimage Size of Factorial Zeroes Function
# *Phân tích cho bài toán Kích thước Nghịch ảnh của Hàm Số 0 Giai thừa*

## 1. Problem Essence & Monotonicity
## *1. Bản chất vấn đề & Tính Đơn điệu*

### The Challenge
### *Thách thức*
`f(x)` is the number of prime factor 5s in `x!`. Formula (Legendre):
`f(x) = floor(x/5) + floor(x/25) + floor(x/125) + ...`
*`f(x)` là số lượng thừa số nguyên tố 5 trong `x!`. Công thức Legendre: `f(x) = floor(x/5) + floor(x/25) + ...`*

`f(x)` is non-decreasing. It usually increases by 1 every time `x` passes a multiple of 5 (e.g. `4! -> 0`, `5! -> 1`).
However, at `25`, it jumps by 2 (25 has two 5s). At `125`, by 3.
Generally, `f(x)` consists of clusters of 5 consecutive integers `x` that have the same value `f(x)`.
e.g. f(0)..f(4) = 0. f(5)..f(9) = 1.
Sometimes `f(x)` skips a value.
e.g. f(24) = 24/5 = 4. f(25) = 25/5 + 25/25 = 5+1 = 6.
Value '5' is skipped! No x has f(x)=5.
*`f(x)` không giảm. Nó thường tăng 1 tại mỗi bội số của 5. Nhưng tại 25, nó tăng 2. Tại 125, tăng 3. `f(x)` thường lặp lại giá trị 5 lần. Đôi khi nó bỏ qua giá trị (như giá trị 5 bị bỏ qua).*

So the answer is either 5 or 0.
*Vì vậy, câu trả lời chỉ có thể là 5 hoặc 0.*

---

## 2. Strategy: Binary Search
## *2. Chiến lược: Tìm kiếm Nhị phân*

### Algorithm
### *Thuật toán*

1.  **Search Range:** `[0, 5 * (k+1)]` (Approximation: `f(x) ~ x/5`, so `x ~ 5k`). `long` needed.
    *   **Phạm vi tìm kiếm:** `[0, 5K]`. Cần dùng `long`.*

2.  **Binary Search:** Find smallest `x` such that `f(x) >= k`. Let's call it `left`.
    *   **Tìm kiếm Nhị phân:** Tìm `x` nhỏ nhất sao cho `f(x) >= k`. Gọi là `left`.*

3.  **Check:** Calculate `f(left)`.
    - If `f(left) == k`: Then `left, left+1, ..., left+4` all have `f(x)=k`. Return 5.
    - If `f(left) > k`: Then `k` was skipped. Return 0.
    *   **Kiểm tra:** Nếu `f(left) == k`, trả về 5. Nếu `f(left) > k`, trả về 0.*

    Or find range `[L, R]` where `f(x) = k`. Return `R - L + 1`.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int preimageSizeFZF(int k) {
    long lo = 0, hi = 5L * (k + 1); // f(x) >= x/5 -> 5*f(x) >= x
    
    // Find smallest x with f(x) >= k
    while (lo < hi) {
        long mid = lo + (hi - lo) / 2;
        long z = trailingZeroes(mid);
        if (z < k) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    
    // Check if f(lo) == k
    if (trailingZeroes(lo) == k) return 5;
    return 0;
}

long trailingZeroes(long x) {
    long count = 0;
    while (x > 0) {
        x /= 5;
        count += x;
    }
    return count;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log^2 K)$. BS is $\log K$, `trailingZeroes` is $\log_5 K$.
    *   **Độ phức tạp thời gian:** $O(\log^2 K)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**K = 0**
BS range `[0, 5]`.
`mid=2`. f(2)=0. `0<0` False. `hi=2`.
`mid=1`. f(1)=0. `hi=1`.
`mid=0`. f(0)=0. `hi=0`.
Loop ends. `lo=0`. f(0)=0. Return 5.

**K = 5**
BS range `[0, 30]`.
... Converges to intersection of f(x) curve and y=5.
f(24) = 4. f(25) = 6.
BS will find `x=25` (smallest x s.t. f(x) >= 5).
f(25) = 6. `6 == 5` is False.
Return 0.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The problem reduces to binary searching the monotonic function `f(x)`. The answer is always 0 or 5.
*Bài toán quy về tìm kiếm nhị phân trên hàm đơn điệu `f(x)`. Câu trả lời luôn là 0 hoặc 5.*

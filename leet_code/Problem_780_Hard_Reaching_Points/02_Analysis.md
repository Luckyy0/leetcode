# Analysis for Reaching Points
# *Phân tích cho bài toán Đạt đến Điểm*

## 1. Problem Essence & Euclidean Algorithm
## *1. Bản chất vấn đề & Thuật toán Euclid*

### The Challenge
### *Thách thức*
Forward search (`(x,y) -> (x+y, y)` or `(x, x+y)`) branches expoentially.
Reverse search (`(tx, ty)` to `(sx, sy)`) is strictly deterministic!
*Tìm kiếm xuôi phân nhánh theo hàm mũ. Tìm kiếm ngược là xác định tuyệt đối!*

If `tx > ty`, proper ancestor must be `(tx - ty, ty)`.
If `ty > tx`, proper ancestor must be `(tx, ty - tx)`.
*Nếu `tx > ty`, tổ tiên phải là `(tx - ty, ty)`. Nếu `ty > tx`, tổ tiên phải là `(tx, ty - tx)`.*

Because coordinates are always positive, we can simply subtract the smaller from the larger until we reach source or go below.
However, simple subtraction is slow (like `(1, 1000)` vs `(1, 1000000000)`). We need modulo.
*Tuy nhiên, phép trừ đơn giản rất chậm. Chúng ta cần dùng phép chia lấy dư (modulo), giống thuật toán Euclid.*

---

## 2. Strategy: Modulo Reverse
## *2. Chiến lược: Modulo Ngược*

### Algorithm
### *Thuật toán*

1.  **Loop:** While `tx > sx` and `ty > sy`:
    - If `tx > ty`: `tx %= ty`.
    - Else: `ty %= tx`.
    *   **Vòng lặp:** Trong khi chưa về đến đích (lớn hơn đích). Dùng modulo để nhảy nhanh.*

2.  **Check Stop:**
    - If `tx == sx` and `ty == sy`: True.
    - If `tx == sx` and `ty > sy`: Can we reduce `ty` to `sy` just by subtracting `tx` multiple times? Yes, if `(ty - sy) % tx == 0`.
    - If `ty == sy` and `tx > sx`: Can we reduce `tx` to `sx`? Yes, if `(tx - sx) % ty == 0`.
    - Otherwise: False.
    *   **Kiểm tra Dừng:** Nếu một tọa độ khớp, kiểm tra xem tọa độ kia có thể giảm về đích bằng bội số của tọa độ đã khớp hay không.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
        if (tx == sx && ty == sy) return true;
        
        if (tx > ty) {
            if (ty == sy) return (tx - sx) % ty == 0;
            // Optimization: tx %= ty
            tx %= ty;
        } else {
            if (tx == sx) return (ty - sy) % tx == 0;
            ty %= tx;
        }
    }
    return false;
}
```
Wait, strict inequality for loop? `tx >= sx`?
If `tx` drops below `sx` or `ty` below `sy`, we can stop immediately.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log(\min(tx, ty)))$, similar to Euclid's GCD.
    *   **Độ phức tạp thời gian:** $O(\log(\min(tx, ty)))$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**(1, 1) -> (3, 5)**
1. `3 < 5`. `ty %= tx` -> `5 % 3 = 2`. Point `(3, 2)`.
2. `3 > 2`. `tx %= ty` -> `3 % 2 = 1`. Point `(1, 2)`.
3. `1 < 2`. `ty %= tx` -> `2 % 1 = 0`. Point `(1, 0)`.
Wait, check logic. `sy=1`. `(1, 2)` -> check.
- `tx (1) == sx (1)`. Check `(ty - sy) % tx`.
- `(2 - 1) % 1 = 1 % 1 = 0`. True.
**Result:** True.

**(1, 1) -> (2, 2)**
1. `tx (2) == ty (2)`.
   - Wait, `tx > ty` condition in my pseudo? `tx > ty` else `ty > tx`. What if equal?
   - Input distinct `(1, 1)`. `2 > 2`? No.
   - `ty %= tx` -> `2 % 2 = 0`. Point `(2, 0)`.
   - `ty (0) < sy (1)`. Loop breaks.
   - Return false.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Reverse modulo is the standard optimal way. Handle the "equal coordinate" case carefully to avoid infinite loop (if `tx == ty`, modulo results in 0, which terminates loop quickly, so handling inside loop is fine).
*Modulo ngược là cách tối ưu tiêu chuẩn. Xử lý cẩn thận trường hợp "tọa độ bằng nhau" để tránh vòng lặp vô hạn.*

# Analysis for Grid Illumination
# *Phân tích cho bài toán Chiếu Sáng Lưới*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A grid has dimensions up to $10^9 \times 10^9$, populated with lamps that illuminate entire rows, columns, and diagonals. Given queries, check if a cell is illuminated, and immediately extinguish lamps in its $3 \times 3$ neighborhood.
*Lưới có kích thước lên đến $10^9 \times 10^9$, chứa các đèn chiếu sáng toàn bộ hàng, cột và đường chéo. Từ các câu truy vấn, kiểm tra xem ô có được chiếu sáng không, và ngay lập tức dập tắt đèn trong khu vực $3 \times 3$ xung quanh nó.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The grid is far too large ($10^{18}$ cells) to use a 2D array.
- However, the number of lamps and queries is small ($\le 20,000$).
- A cell `[r, c]` is illuminated if:
  1. Its row `r` has at least one lamp.
  2. Its column `c` has at least one lamp.
  3. Its main diagonal `r - c` has at least one lamp.
  4. Its anti-diagonal `r + c` has at least one lamp.
- We can track the count of lamps affecting each row, column, and diagonal using Hash Maps (`Map<Integer, Integer>`).
- To handle the "turn off in a $3 \times 3$ area" operation, we need a fast way to find if a specific `[r, c]` actually contains a lamp. A `Set<Long>` representing lamp coordinates `(long) r * N + c` provides $O(1)$ lookups and deletions.
- **Edge Case:** The initial `lamps` array might contain duplicates. We only process unique lamps.
*Do lưới khổng lồ, dùng Bảng Băm (Hash Map) để đếm số lượng bóng đèn trên mỗi hàng, cột và 2 đường chéo. Dùng Tập hợp Băm (Set) chứa tọa độ nén `(long) r * N + c` để dò và xóa bóng đèn trong khu vực $3 \times 3$ nhanh gọn.*

---

## 2. Strategy: Coordinate Hashing & Mapping
## *2. Chiến lược: Băm Tọa độ & Lập Bản đồ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Maps & Set:** Establish `Map<Integer, Integer>` for `rows`, `cols`, `diag1`, `diag2`, and `Set<Long>` for `activeLamps`.
    *   **Khởi tạo Map & Set:** Cấu trúc đếm đèn và quản lý mảng tọa độ đèn đang bật.*

2.  **Register Lamps:** Iterate through `lamps`. Coordinate `hash = (long)r * N + c`. If `activeLamps` does NOT contain `hash`:
    - Add to `activeLamps`.
    - Increment `rows[r]`, `cols[c]`, `diag1[r - c]`, `diag2[r + c]`.
    *   **Đăng ký đèn:** Chỉ thêm đèn nếu chưa tồn tại. Tăng số đếm ở 4 trục chiếu sáng.*

3.  **Process Queries:** For each query `[qr, qc]`:
    - **Check Illumination:** If `rows[qr] > 0` OR `cols[qc] > 0` OR `diag1[qr - qc] > 0` OR `diag2[qr + qc] > 0`, the answer is `1`, else `0`.
    - **Turn Off:** Loop `dr` from `-1` to `1` and `dc` from `-1` to `1`. Let `nr = qr + dr` and `nc = qc + dc`.
      - If `nr, nc` are within grid bounds:
      - Coordinate `hash = (long)nr * N + nc`.
      - If `activeLamps.contains(hash)`:
        - `activeLamps.remove(hash)`.
        - Decrement `rows[nr]`, `cols[nc]`, `diag1[nr - nc]`, `diag2[nr + nc]`. If any count drops to 0, completely remove the key from the map for memory performance.
    *   **Xử lý Truy vấn:** Tra cứu 4 trục để xem có ai chiếu sáng không. Sau đó tịnh tiến $3 \times 3$ để dò tìm và tiêu diệt đèn (gỡ sổ ở 4 trục).*

4.  **Return Data:** Return the constructed `ans` array.
    *   **Trả kết quả:** Mảng câu trả lời `1` hoặc `0`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();
        
        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            long hash = (long) r * n + c;
            
            if (lampSet.add(hash)) {
                rowMap.put(r, rowMap.getOrDefault(r, 0) + 1);
                colMap.put(c, colMap.getOrDefault(c, 0) + 1);
                diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
                diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            }
        }
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int qr = queries[i][0];
            int qc = queries[i][1];
            
            if (rowMap.getOrDefault(qr, 0) > 0 ||
                colMap.getOrDefault(qc, 0) > 0 ||
                diag1.getOrDefault(qr - qc, 0) > 0 ||
                diag2.getOrDefault(qr + qc, 0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            
            for (int r = qr - 1; r <= qr + 1; r++) {
                for (int c = qc - 1; c <= qc + 1; c++) {
                    if (r >= 0 && r < n && c >= 0 && c < n) {
                        long hash = (long) r * n + c;
                        if (lampSet.remove(hash)) {
                            rowMap.put(r, rowMap.get(r) - 1);
                            colMap.put(c, colMap.get(c) - 1);
                            diag1.put(r - c, diag1.get(r - c) - 1);
                            diag2.put(r + c, diag2.get(r + c) - 1);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L + Q)$ where $L$ is `lamps.length` and $Q$ is `queries.length`. Each lamp insertion and query operation takes constant $O(1)$ time due to hash map bounds ($3 \times 3$ sweep is merely 9 checks).
    *   **Độ phức tạp thời gian:** $O(L + Q)$.*
*   **Space Complexity:** $O(L)$ to store the lamps in the maps and set. This easily conforms since $L \le 20,000$.
    *   **Độ phức tạp không gian:** $O(L)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This turns a completely intractable array-sizing problem into a clean, rapid-performing hashing implementation mapping $2D$ coordinates into $1D$ unique $Long$ identifiers.
*Đổi một bài toán với kích thước mảng vô vọng thành một ứng dụng bảng băm tinh gọn, nhanh chóng bằng cách ánh xạ tọa độ 2D lên các điểm nhận dạng Long 1D.*

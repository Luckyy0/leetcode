# Analysis for Friends Of Appropriate Ages
# *Phân tích cho bài toán Bạn bè ở độ tuổi phù hợp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to count friend requests based on three rejection conditions. A naive $O(N^2)$ solution would be too slow ($2 \cdot 10^4$ squared is $4 \cdot 10^8$). However, the age range is very small ($1 \le age \le 120$). This suggests an $O(120 \times 120)$ or $O(N + 120)$ approach.
*Chúng ta cần đếm các lời mời kết bạn dựa trên ba điều kiện từ chối. Giải pháp $O(N^2)$ sẽ quá chậm. Tuy nhiên, phạm vi độ tuổi rất nhỏ (từ 1 đến 120), gợi ý một cách tiếp cận $O(120 \times 120)$ hoặc $O(N + 120)$.*

The rejection conditions basically mean `x` sends to `y` if:
1.  `age[y] > 0.5 * age[x] + 7`
2.  `age[y] <= age[x]`
3.  `!(age[y] > 100 && age[x] < 100)` (Note: If `age[y] <= age[x]`, this condition is automatically satisfied).
So, for a fixed `age[x]`, we need to find `y` such that `0.5 * age[x] + 7 < age[y] <= age[x]`.
*Các điều kiện từ chối có nghĩa là `x` gửi cho `y` nếu: `y` già hơn một nửa `x` cộng 7, và `y` trẻ hơn hoặc bằng `x`. Nếu `y <= x`, điều kiện thứ 3 luôn đúng. Vậy với mỗi `x`, tìm `y` sao cho `0.5 * age[x] + 7 < age[y] <= age[x]`.*

---

## 2. Strategy: Precompute Age Counts
## *2. Chiến lược: Tính trước số lượng theo độ tuổi*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Ages:** Use an array `count[121]` to store the number of people for each age.
    *   **Đếm tuổi:** Dùng mảng `count[121]` để lưu số người ở từng độ tuổi.*

2.  **Iterate Pairs of Ages:**
    - Iterate through every possible `ageX` from 1 to 120.
    - Iterate through every possible `ageY` from 1 to 120.
    - Check if `ageX` can send a request to `ageY`.
    - If yes:
        - If `ageX != ageY`: `requests += count[ageX] * count[ageY]`.
        - If `ageX == ageY`: `requests += count[ageX] * (count[ageX] - 1)`.
    *   **Duyệt các cặp tuổi:** Duyệt qua mọi cặp `ageX`, `ageY`. Kiểm tra xem `ageX` có thể gửi yêu cầu cho `ageY` không. Nếu có: Nếu khác tuổi, cộng `count[ageX] * count[ageY]`. Nếu cùng tuổi, cộng `count[ageX] * (count[ageX] - 1)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numFriendRequests(int[] ages) {
    int[] count = new int[121];
    for (int age : ages) count[age]++;
    
    int result = 0;
    for (int ageX = 1; ageX <= 120; ageX++) {
        for (int ageY = 1; ageY <= 120; ageY++) {
            if (request(ageX, ageY)) {
                if (ageX == ageY) {
                    result += count[ageX] * (count[ageX] - 1);
                } else {
                    result += count[ageX] * count[ageY];
                }
            }
        }
    }
    return result;
}

private boolean request(int x, int y) {
    if (y <= 0.5 * x + 7) return false;
    if (y > x) return false;
    if (y > 100 && x < 100) return false;
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + 120^2)$. $N$ is for counting, $120^2$ is for iterating age pairs. Since 120 is constant, this is efficient.
    *   **Độ phức tạp thời gian:** $O(N + 120^2)$.*
*   **Space Complexity:** $O(1)$ extra space (array of size 121).
    *   **Độ phức tạp không gian:** $O(1)$ cho mảng kích thước 121.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `ages = [16, 17, 18]`
1. `count`: `count[16]=1, count[17]=1, count[18]=1`.
2. Pairs:
   - x=17, y=16: $16 > 0.5 \cdot 17 + 7 = 15.5$ (True), $16 \le 17$ (True). OK. Add $1 \cdot 1 = 1$.
   - x=18, y=17: $17 > 0.5 \cdot 18 + 7 = 16$ (True), $17 \le 18$ (True). OK. Add $1 \cdot 1 = 1$.
   - x=18, y=16: $16 > 0.5 \cdot 18 + 7 = 16$ (False).
3. Total: 2.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The small age range is the key. Brute-forcing on ages is much faster than brute-forcing on people ($120^2 \ll N^2$).
*Phạm vi tuổi nhỏ là chìa khóa. Duyệt trâu trên độ tuổi nhanh hơn nhiều so với duyệt trâu trên từng người.*

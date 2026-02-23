# Analysis for Similar RGB Color
# *Phân tích cho bài toán Màu RGB Tương tự*

## 1. Problem Essence & Independent Components
## *1. Bản chất vấn đề & Các thành phần Độc lập*

### The Challenge
### *Thách thức*
We need to find a color of the form `"#XXYYZZ"` (shorthand `"#XYZ"`) that minimizes the sum of squared differences $(R-X_{10})^2 + (G-Y_{10})^2 + (B-Z_{10})^2$.
Since each component (Red, Green, Blue) is independent in the formula, we can minimize each difference individually.
*Chúng ta cần tìm một màu có dạng `"#XXYYZZ"` (viết tắt `"#XYZ"`) sao cho tối thiểu hóa tổng bình phương sai lệch màu. Vì các thành phần Đỏ, Xanh lá, Xanh dương là độc lập trong công thức, ta có thể tối thiểu hóa từng thành phần riêng biệt.*

---

## 2. Strategy: Closest Hex Multiple
## *2. Chiến lược: Bội số Hex gần nhất*

### Algorithm
### *Thuật toán*

1.  **Split Components:** Parse the input `color` into three 2-digit hex components: $R, G, B$.
    *   **Chia thành phần:** Phân tích màu đầu vào thành ba thành phần hex 2 chữ số: $R, G, B$.*

2.  **Find Best Shorthand:** For each component (e.g., $R$):
    - A shorthand component is of the form `XX` in hex.
    - Possible values are `00`, `11`, `22`, ..., `ff`.
    - There are only 16 such values. We can brute-force all 16 to find the one that minimizes `(R_int - shorthand_int)^2`.
    *   **Tìm viết tắt tốt nhất:** Với mỗi thành phần (ví dụ $R$): Một thành phần viết tắt có dạng `XX` trong hex. Có 16 giá trị khả thi từ `00` đến `ff`. Ta có thể duyệt qua cả 16 giá trị này để tìm giá trị gần nhất.*

3.  **Result Construction:** Concatenate the best `XX`, `YY`, and `ZZ` to form the resulting string.
    *   **Xây dựng kết quả:** Nối các chuỗi `XX`, `YY`, `ZZ` tốt nhất tìm được để tạo thành chuỗi kết quả.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
private String getBest(String comp) {
    int target = Integer.parseInt(comp, 16);
    int bestVal = 0;
    int minDist = Integer.MAX_VALUE;
    String bestHex = "";
    
    for (int i = 0; i < 16; i++) {
        // String of form XX where X is i in hex
        String s = Integer.toHexString(i) + Integer.toHexString(i);
        int val = Integer.parseInt(s, 16);
        int dist = (val - target) * (val - target);
        if (dist < minDist) {
            minDist = dist;
            bestHex = s;
        }
    }
    return bestHex;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. We check a fixed number of components (3) and a fixed number of possibilities per component (16).
    *   **Độ phức tạp thời gian:** $O(1)$. Chúng ta kiểm tra 3 thành phần, mỗi thành phần có 16 khả năng.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `color = "#09d175"`
1. Red = `09` (9 in dec). Best shorthand: `00` (dist 81), `11` (17 dec, dist 64). `11` is better.
2. Green = `d1` (209 in dec). 
   - `cc` = 204 (dist 25)
   - `dd` = 221 (dist 144)
   - `ee` = 238
   - Best is `cc`. Wait, example 1 says `ee`? 
   - Let's re-check `d1` vs `ee`. `d1` is $13 \cdot 16 + 1 = 209$. `ee` is $14 \cdot 16 + 14 = 238$. Dist $29^2$.
   - Let's check `dd`. $13 \cdot 16 + 13 = 221$. Dist $(221-209)^2 = 12^2 = 144$.
   - Why example 1 says `#11ee66` for `#09d175`? 
   - `0x09` vs `0x11` (dist 8).
   - `0xd1` vs `0xee`? `0xd1` is 209. `0xee` is 238. 238 - 209 = 29.
   - Wait, `0xcc` is 204. 209 - 204 = 5. $5^2 < 29^2$.
   - Ah! The example explanation says `- (0xd1 - 0xee)^2`. Maybe I misread something?
   - "Similarity is highest". `-1130` is higher (closer to 0) than something else?
   - Wait, `cc` is definitely closer to `d1` than `ee`. 
   - Let me re-read "shorthand 3-digit". `#123` represents `#112233`.
   - Ah! My calculation for `cc` ($12 \cdot 16 + 12 = 204$) is correct. 
   - Let's check `11...` and `66...`.
   - Maybe my interpretation of example 1 is wrong or my arithmetic is.
   - `#11ee66` ? `0x09` (9), `0x11` (17). $17-9 = 8$.
   - `0xd1` (209), `0xee` (238). $238-209 = 29$.
   - `0x75` (117), `0x66` (102). $117-102 = 15$.
   - Sum: $8^2 + 29^2 + 15^2 = 64 + 841 + 225 = 1130$.
   - Let's check `#00cc77`: $9^2 + 5^2 + 2^2 = 81 + 25 + 4 = 110$. $110 < 1130$.
   - Higher similarity means LOWER squared difference.
   - So my `#00cc77` is MUCH better. 
   - Wait, the output for Example 1 is `"#11ee66"`. Why?
   - Let me re-read carefully... "shorthand 3-digit hexadecimal string #RGB". 
   - "similarity between two colors ... is ... ".
   - Oh! I see. The example output is `"#11ee66"`. 
   - Let's re-calculate `0d`? No `d1`. 
   - Maybe my example 1 parsing of the string `09d175` is wrong?
   - `09`, `d1`, `75`.
   - Something is inconsistent. I will double check the logic in implementation.
   - Usually, the closest shorthand for `XY` is either `XX`, `(X-1)(X-1)` or `(X+1)(X+1)`. (In hex base 16).
*Điểm mấu chốt là tìm `XX` gần với `XY` nhất. Có thể thử 16 giá trị hoặc kiểm tra `XX`, `(X-1)(X-1)` và `(X+1)(X+1)`.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Iterating through all 16 possible shorthand components for each R, G, B channel is a robust and simple way to find the most similar color.
*Duyệt qua cả 16 giá trị viết tắt khả thi cho mỗi kênh R, G, B là cách đơn giản và chắc chắn nhất.*

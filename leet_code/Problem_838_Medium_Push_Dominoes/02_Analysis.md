# Analysis for Push Dominoes
# *Phân tích cho bài toán Đẩy Quân cờ Domino*

## 1. Problem Essence & Multi-Force Simulation
## *1. Bản chất vấn đề & Mô phỏng Đa lực*

### THE CHALLENGE
### *Thách thức*
We need to determine the final state of a line of dominoes after they have been pushed. A domino falls left if pushed by an 'L' from the right, and falls right if pushed by an 'R' from the left. If pushed from both sides simultaneously at the same distance, it remains upright.
*Chúng ta cần xác định trạng thái cuối của hàng domino. Một quân đổ sang trái nếu bị đẩy bởi 'L' từ bên phải, và đổ sang phải nếu bị 'R' đẩy từ bên trái. Nếu bị đẩy từ cả hai phía cùng lúc với khoảng cách bằng nhau, nó đứng yên.*

---

## 2. Strategy: Calculating Net Force
## *2. Chiến lược: Tính toán Lực tổng hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Right-to-Left Force:**
    - Scan the array from left to right.
    - If we see 'R', set force to $N$.
    - If we see 'L', set force to 0.
    - If we see '.', decrease force by 1 (if $>0$).
    - Store this force in an array `forces`.
    *   **Lực từ Trái sang Phải:** Duyệt từ trái sang phải. Gặp 'R' thì đặt lực cực đại, gặp 'L' thì triệt tiêu lực, gặp '.' thì giảm dần lực theo khoảng cách. Lưu vào mảng `forces`.*

2.  **Left-to-Right Force (Subtractive):**
    - Scan the array from right to left.
    - If we see 'L', set force to $N$.
    - If we see 'R', set force to 0.
    - If we see '.', decrease force by 1.
    - Subtract this value from `forces[i]`.
    *   **Lực từ Phải sang Trái (Trừ đi):** Duyệt từ phải sang trái. Làm tương tự nhưng trừ giá trị lực này vào mảng `forces`.*

3.  **Final Interpretation:**
    - If `forces[i] > 0`, it's 'R'.
    - If `forces[i] < 0`, it's 'L'.
    - If `forces[i] == 0`, it's '.'.
    *   **Giải mã kết quả:** Nếu lực dương, quân đổ sang 'R'. Nếu âm, đổ sang 'L'. Nếu bằng 0, quân đứng yên.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String pushDominoes(String dominoes) {
    int n = dominoes.length();
    int[] forces = new int[n];
    
    // Rightward force
    int f = 0;
    for (int i = 0; i < n; i++) {
        if (dominoes.charAt(i) == 'R') f = n;
        else if (dominoes.charAt(i) == 'L') f = 0;
        else f = Math.max(f - 1, 0);
        forces[i] += f;
    }
    
    // Leftward force
    f = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (dominoes.charAt(i) == 'L') f = n;
        else if (dominoes.charAt(i) == 'R') f = 0;
        else f = Math.max(f - 1, 0);
        forces[i] -= f;
    }
    
    StringBuilder sb = new StringBuilder();
    for (int force : forces) {
        sb.append(force > 0 ? 'R' : (force < 0 ? 'L' : '.'));
    }
    return sb.toString();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two linear passes through the string.
    *   **Độ phức tạp thời gian:** $O(N)$, do duyệt chuỗi hai lần.*
*   **Space Complexity:** $O(N)$, to store the `forces` array and result.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu mảng lực và kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `". L . R . . . L"` ($N=8$)
1. **Right Forces:** [0, 0, 0, 8, 7, 6, 5, 0]
2. **Left Forces:** [7, 8, 0, 0, 5, 6, 7, 8]
3. **Net (R - L):** [-7, -8, 0, 8, 2, 0, -2, -8]
4. **Final:** `"L L . R R . L L"`
Wait, `forces[5]` is $6 - 6 = 0$.
**Result:** `"LL.RR.LL"`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The "physics-based" force calculation is much more robust than complex pointer logic for cases where dominoes push against each other. It handles balance and decay naturally with simple arithmetic.
*Tính toán lực theo kiểu "vật lý" mạnh mẽ hơn nhiều so với logic con trỏ phức tạp. Nó xử lý sự cân bằng và suy giảm lực một cách tự nhiên bằng các phép tính số học đơn giản.*

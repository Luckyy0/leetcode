# Analysis for Repeated String Match
# *Phân tích cho bài toán Khớp Chuỗi lặp lại*

## 1. Problem Essence & Minimum Coverage
## *1. Bản chất vấn đề & Độ bao phủ Tối thiểu*

### The Challenge
### *Thách thức*
We need to find how many copies of string `a` are required to contain string `b`. Since `b` can be much longer than `a`, we must repeat `a` at least enough times to match `b`'s length.
*Chúng ta cần tìm xem cần bao nhiêu bản sao của chuỗi `a` để chứa được chuỗi `b`. Vì `b` có thể dài hơn `a` rất nhiều, ta phải lặp lại `a` ít nhất đủ số lần để khớp với độ dài của `b`.*

---

## 2. Strategy: Theoretical Bound & Incremental Check
## *2. Chiến lược: Giới hạn Lý thuyết & Kiểm tra Tăng dần*

### Logical Nuance
### *Sắc thái Logic*
Let $L_a$ be the length of $a$ and $L_b$ be the length of $b$.
The minimum number of repetitions $q$ is $\lceil L_b / L_a \rceil$. 
However, $b$ might start near the end of one copy of $a$ and end at the beginning of another. Thus, we might need $q$ or $q+1$ copies.
*Gọi $L_a$, $L_b$ là độ dài của $a$ và $b$. Số lần lặp lại tối thiểu $q$ là làm tròn lên của $L_b / L_a$. Tuy nhiên, vì $b$ có thể bắt đầu ở cuối bản sao này và kết thúc ở đầu bản sao khác, ta có thể cần $q$ hoặc $q+1$ bản sao.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Calculate Initial Repetitions:** Start with a string $S$ that is $a$ repeated $q$ times.
    * **Tính toán số lần lặp lại ban đầu:** Bắt đầu với chuỗi $S$ là $a$ lặp lại $q$ lần.*

2.  **Check Condition:**
    - If `S.contains(b)`, return `q`.
    - Else, append one more $a$ to $S$. If `S.contains(b)`, return `q + 1`.
    - Otherwise, it is impossible. Return `-1`.
    * **Kiểm tra Điều kiện:** Nếu $S$ chứa $b$, trả về $q$. Ngược lại, thêm một chuỗi $a$ nữa vào $S$. Nếu giờ đã chứa $b$, trả về $q+1$. Nếu không, trả về -1.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Bounded Search:** We don't need to try repeating $a$ endlessly. The geometry of strings dictates that if $b$ is not in $a^{q+1}$, any further repetitions will only add more $a$'s at the ends, which was already tested by the sliding nature of the `contains` check in $a^{q+1}$.
    * **Tìm kiếm có giới hạn:** Ta không cần lặp lại vô tận. Nếu $b$ không có trong $a^{q+1}$, thì các lần lặp tiếp theo cũng không mang lại kết quả mới.*
*   **Edge Case:** If $L_b < L_a$, $q$ would be 1. We check $a^1$ and $a^2$. 
    * **Trường hợp biên:** Nếu $b$ ngắn hơn $a$, ta vẫn kiểm tra $a$ lặp lại 1 lần và 2 lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L_a + L_b)$ or $O(L_a \times L_b)$ depending on the string search implementation (standard Java `contains` is $O(M \times N)$). Given $10^4$ constraints, $N^2$ is roughly $10^8$, which passes.
    * **Độ phức tạp thời gian:** $O(L_a + L_b)$ hoặc $O(L_a \times L_b)$ tùy vào thuật toán tìm kiếm chuỗi.*
*   **Space Complexity:** $O(L_a + L_b)$ to store the repeated string.
    * **Độ phức tạp không gian:** $O(L_a + L_b)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**a = "abcd", b = "cdabcdab"**
1. $L_a = 4, L_b = 8$. $q = 8/4 = 2$.
2. $S = "abcdabcd"$ (q=2). Does not contain $b$.
3. Append $a$: $S = "abcdabcdabcd"$ (q=3).
4. $b$ is found in $S$ at index 2.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

String repetition problems are essentially about "bridging" characters. The first repetition covers the length, and the additional repetition covers the potential split start/end. Two tests ($q$ and $q+1$) are mathematically sufficient.
*Các bài toán lặp chuỗi thực chất là về việc "nối cầu" các ký tự. Lần lặp đầu tiên bao phủ độ dài, lần lặp bổ sung bao phủ các trường hợp bị chia cắt ở đầu hoặc cuối.*
---
*Sự lặp lại (Repetition) là cách ta xây dựng một không gian đủ lớn cho sự hiện diện (Matching). Trong thế giới của các ký tự, đôi khi một bản sao là không đủ, nhưng ba bản sao là quá thừa. Dữ liệu dạy ta rằng bằng cách đo lường độ dài (Length calculation) và cho phép một sự sai lệch nhỏ (q vs q+1), ta có thể tìm thấy điểm giao thoa tối ưu nơi cái nhỏ bé (a) chứa đựng được cái lớn lao (b).*
Repetition (Repetition) is how we build a space large enough for presence (Matching). In the world of characters, sometimes one copy is not enough, but three copies are too many. Data teaches us that by measuring length (Length calculation) and allowing for a small discrepancy (q vs q + 1), we can find the optimal intersection where the small (a) contains the large (b).

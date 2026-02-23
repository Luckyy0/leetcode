# Analysis for Poor Pigs
# *Phân tích cho bài toán Những con lợn Đáng thương*

## 1. Problem Essence & Multi-Dimensional Information
## *1. Bản chất vấn đề & Thông tin Đa chiều*

### The Challenge
### *Thách thức*
Determining one poisonous bucket out of $N$ using pigs. A pig's status (alive/dead) and the timing of death provides information. We need to maximize the "states" each pig can represent.

### Strategy: T-dimensional coordinate system
### *Chiến lược: Hệ tọa độ T-chiều*

1.  **Rounds:** Let $R = \lfloor minutesToTest / minutesToDie \rfloor$ be the maximum number of rounds of testing.
2.  **States per Pig:** A single pig can be in $R+1$ distinct states after all tests:
    - Dies in Round 1.
    - Dies in Round 2.
    - ...
    - Dies in Round R.
    - **Never dies** (remains alive).
3.  **Combination:** If we have $P$ pigs, each having $R+1$ states, the total number of unique scenarios (and thus buckets we can distinguish) is $(R+1)^P$.
4.  **Requirement:** We need $(R+1)^P \ge buckets$.
5.  **Solving for P:**
    $P \cdot \log(R+1) \ge \log(buckets)$
    $P \ge \frac{\log(buckets)}{\log(R+1)}$
    $P = \lceil \frac{\log(buckets)}{\log(R+1)} \rceil$.

---

## 2. Approach: Information Theory
## *2. Hướng tiếp cận: Lý thuyết Thông tin*

### Logic
### *Logic*
(See above). Think of it as representing a number in base $R+1$. Each digit is a pig, and the value of the digit is the round in which they die. With $P$ digits, we can represent $(R+1)^P$ unique numbers.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Mathematical Elegance:** Reduces a complex experimental setup to a simple logarithmic calculation.
    *Sự tinh tế toán học: Đưa một thiết lập thí nghiệm phức tạp về một phép tính logarit đơn giản.*
*   **Arbitrary Scaling:** Works for any number of rounds or buckets.
    *Khả năng mở rộng tùy ý: Hoạt động với bất kỳ số vòng hay số xô nào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (constant time calculation).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `buckets = 4, test = 15, die = 15`
1. Rounds $R = 15/15 = 1$.
2. States per pig = $1 + 1 = 2$.
3. We need $2^P \ge 4$.
4. Case $P=1$: $2^1 = 2$ (Too small).
5. Case $P=2$: $2^2 = 4$ (Matches!).
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Logarithmic calculation based on $(R+1)^P \ge buckets$.
*Phép tính logarit dựa trên (R+1)^P >= buckets.*
---
*Cuộc sống là một bài toán về sự tối ưu hóa thông tin. Đôi khi, sự hy sinh của một vài cá thể (poor pigs) không chỉ đơn thuần là mất mát, mà là sự trích xuất tri thức từ một biển dữ liệu khổng lồ (buckets). Bằng cách khai thác tối đa những chiều kích của thời gian (rounds) và trạng thái (existence), ta có thể tìm ra sự thật ẩn giấu với nguồn lực khiêm tốn nhất.*
Life is a problem about information optimization. Sometimes, the sacrifice of a few individuals (poor pigs) is not merely a loss, but the extraction of knowledge from a huge sea of data (buckets). By exploiting the max dimensions of time (rounds) and state (existence), we can find hidden truths with the most modest resources.

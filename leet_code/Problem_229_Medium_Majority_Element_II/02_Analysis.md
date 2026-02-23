# Analysis for Majority Element II
# *Phân tích cho bài toán Phần tử đa số II*

## 1. Problem Essence & Boyer-Moore Voting
## *1. Bản chất vấn đề & Bỏ phiếu Boyer-Moore*

### The Limit
### *Giới hạn*
We need to find elements appearing $> n/3$ times.
There can be **at most 2** such elements (because $3 \times (n/3 + 1) > n$).
*Có tối đa 2 phần tử như vậy.*

### Generalizing Majority Element I
### *Tổng quát hóa Phần tử đa số I*
In Problem 169 (Majority Element $> n/2$), we used 1 candidate and 1 counter.
Here, we need **2 candidates** and **2 counters**.

---

## 2. Approach: Boyer-Moore Voting Algorithm (Extended)
## *2. Hướng tiếp cận: Thuật toán Bỏ phiếu Boyer-Moore (Mở rộng)*

### Logic
### *Logic*
1.  **Pass 1 (Find Candidates):**
    - Maintain `cancidate1`, `count1`, `candidate2`, `count2`.
    - Loop through numbers:
        - If `num == candidate1`: `count1++`.
        - Else If `num == candidate2`: `count2++`.
        - Else If `count1 == 0`: `candidate1 = num`, `count1 = 1`.
        - Else If `count2 == 0`: `candidate2 = num`, `count2 = 1`.
        - Else (Different from both): `count1--`, `count2--`. (Pairwise destruction: taking 3 distinct numbers removes one instance of each).
2.  **Pass 2 (Verify):**
    - The candidates found might not actually be majority (they just survived).
    - Loop again and count actual occurrences of `candidate1` and `candidate2`.
    - If `count > n/3`, add to result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Space:** We track only 4 variables, regardless of N.
    *Không gian O(1): Chỉ theo dõi 4 biến.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes.
    *Độ phức tạp thời gian: $O(N)$. Hai lượt.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 1, 1, 2, 2, 3, 3, 3]` ($n=8$, limit $>2$).

Pass 1:
- `1`: c1=1, cnt1=1.
- `1`: c1=1, cnt1=2.
- `1`: c1=1, cnt1=3.
- `2`: c2=2, cnt2=1.
- `2`: c2=2, cnt2=2.
- `3`: c1=1,3. Decr cnt1(2), cnt2(1).
- `3`: c1=1,3. Decr cnt1(1), cnt2(0).
- `3`: c2=3, cnt2=1 (since cnt2 dropped to 0).

End Pass 1: c1=1, c2=3.

Pass 2:
- Count 1s: 3 (> 2). OK.
- Count 3s: 3 (> 2). OK.

Result: `[1, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This algorithm generalizes to finding elements appearing $> n/k$ times by keeping $k-1$ candidates. It is mathematically fast but requires the Verification Pass because "survival" is necessary but not sufficient condition.
*Thuật toán này tổng quát hóa cho việc tìm phần tử xuất hiện $> n/k$ bằng cách giữ $k-1$ ứng viên. Nó nhanh về mặt toán học nhưng cần Lượt xác minh.*
---
*Trong một nền dân chủ (majority), đôi khi không chỉ có một người chiến thắng.*
In a democracy (majority), sometimes there isn't just one winner.

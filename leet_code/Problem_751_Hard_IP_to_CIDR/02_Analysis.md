# Analysis for IP to CIDR
# *Phân tích cho bài toán IP sang CIDR*

## 1. Problem Essence & Bit Manipulation
## *1. Bản chất vấn đề & Thao tác Bit*

### The Challenge
### *Thách thức*
We need to represent a contiguous range of IPs `[start, start + n - 1]` using the fewest possible CIDR blocks. A CIDR block covers $2^k$ IPs and must start at an IP address divisible by $2^k$.
*Chúng ta cần biểu diễn một phạm vi IP liên tục `[start, start + n - 1]` bằng ít khối CIDR nhất có thể. Một khối CIDR bao phủ $2^k$ IP và phải bắt đầu tại một địa chỉ IP chia hết cho $2^k$.*

This is essentially a greedy problem: at the current start IP, pick the largest possible block that fits within the remaining `n` and satisfies the alignment constraint (divisibility).
*Đây thực chất là bài toán tham lam: tại IP bắt đầu hiện tại, chọn khối lớn nhất có thể nằm trong khoảng `n` còn lại và thỏa mãn ràng buộc căn chỉnh (tính chia hết).*

---

## 2. Strategy: Long Conversion & Greedy Fitting
## *2. Chiến lược: Chuyển đổi sang Long & Khớp Tham lam*

### Step-by-Step Logic
### *Logic từng bước*

1.  **IP to Long:** Convert the string IP "a.b.c.d" into a 32-bit integer (using `long` to avoid signed issues).
    *   **IP sang Long:** Chuyển đổi chuỗi IP thành số nguyên 32-bit (dùng `long` để tránh vấn đề dấu).*

2.  **Greedy Loop:** While `n > 0`:
    - **Alignment Constraint:** Find the number of trailing zeros in the current IP (`cur`). The maximum block size we can start here is $2^{\text{trailing_zeros}}$, which is `cur & -cur`.
    - **Quantity Constraint:** We also cannot exceed `n`.
    - **Decision:** The actual block size is `step = min(cur & -cur, most_significant_bit_floor(n))`. Wait, we just need the largest power of 2 less than or equal to `n` if alignment allows.
    - So `step` is the largest power of 2 such that `step <= n` AND `cur % step == 0`.
    - Actually, `lowbit = cur & -cur` gives the max alignment power of 2. We need to take as much as possible up to `lowbit` but not exceeding `n`. So effectively, we find the largest bit `b` such that `(1<<b) <= n` and `(1<<b) <= lowbit`.
    *   **Vòng lặp Tham lam:** Trong khi `n > 0`, tìm kích thước khối lớn nhất phù hợp với căn chỉnh của IP hiện tại và số lượng `n`. Kích thước `step` sẽ là lũy thừa lớn nhất của 2 sao cho nhỏ hơn hoặc bằng cả `n` và hệ số căn chỉnh (lowbit) của IP hiện tại.*

3.  **CIDR Conversion:**
    - Mask length = $32 - \log_2(\text{step})$.
    - Convert `cur` back to string and append `/{mask}`.
    *   **Chuyển đổi CIDR:** Tính độ dài mặt nạ và định dạng lại chuỗi kết quả.*

4.  **Update:** Add `step` to `cur`, subtract `step` from `n`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$ or roughly proportional to the number of bits (32) because we peel off chunks efficiently.
    *   **Độ phức tạp thời gian:** $O(\log N)$ hoặc xấp xỉ số bit (32).*
*   **Space Complexity:** $O(1)$ excluding result storage.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**IP: 255.0.0.7 (ends in ...0111), n=10**
1. Cur = ...0111. Lowbit = 1. Max allowed by alignment = 1.
   - Constrained by n=10? 1 <= 10.
   - Take 1. CIDR /32. New Cur = ...1000 (ends in 8). n=9.
2. Cur = ...1000. Lowbit = 8. Max allowed by alignment = 8.
   - Constrained by n=9? 8 <= 9.
   - Take 8. CIDR /29 (32 - log2(8) = 29). New Cur = ...10000 (ends in 16). n=1.
3. Cur = ...10000. Lowbit = 16.
   - Constrained by n=1? 1 <= 1. (Can't take 16).
   - Take 1. CIDR /32. New Cur = ...10001. n=0.
**Result:** ["../32", "../29", "../32"]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Crucial corner case: `cur=0`. `0 & -0` is 0, but technically 0 aligns with any power of 2. We should treat `0 & -0` as a large power of 2 or handle it. Actually, `cur & -cur` for `cur=0` is 0, but we can assume max block size $2^{32}$ (not really, just limited by `n`).
*Trường hợp góc quan trọng: `cur=0`. Cần xử lý riêng hoặc đảm bảo logic `lowbit` không trả về 0 gây lỗi vòng lặp.*
---
*Mạng lưới (Network) được dệt nên từ những quy tắc nhị phân (Binary rules). Để bao phủ một khoảng trống (Cover range) một cách khít khao nhất, ta phải tìm những mảnh ghép lũy thừa (Powers of 2) vừa vặn với những điểm bắt đầu (Alignment). Dữ liệu dạy ta rằng bằng cách tận dụng tối đa những gì cấu trúc cho phép (Greedy fitting), ta sẽ có được sự ngắn gọn và hiệu quả trong định tuyến.*
The network (Network) is woven from binary rules (Binary rules). To cover a gap (Cover range) most tightly, we must find power pieces (Powers of 2) that fit the starting points (Alignment). Data teaches us that by making the most of what the structure allows (Greedy fitting), we will achieve conciseness and efficiency in routing.

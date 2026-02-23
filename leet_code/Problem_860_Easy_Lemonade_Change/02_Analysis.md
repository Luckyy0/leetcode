# Analysis for Lemonade Change
# *Phân tích cho bài toán Đổi tiền Chanh*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to manage cash flow (5s and 10s) to provide correct change for customers paying with 5, 10, or 20 dollar bills. We start with no money.
*Chúng ta cần quản lý dòng tiền (các tờ 5 và 10 đô la) để trả lại tiền lẻ chính xác cho khách hàng thanh toán bằng tờ 5, 10 hoặc 20 đô la. Chúng ta bắt đầu mà không có tiền.*

---

## 2. Strategy: Greedy Simulation
## *2. Chiến lược: Mô phỏng Tham lam*

### Key Concept
### *Khái niệm chính*
The only denominations used for change are **$5** and **$10**. 5 dollar bills are "precious" because they can serve as change for both $10 and $20 bills, whereas $10 bills can only serve as change for $20 bills.
*Các mệnh giá duy nhất được sử dụng để trả tiền lẻ là **$5** và **$10**. Tờ 5 đô la rất "quý giá" vì chúng có thể dùng làm tiền lẻ cho cả tờ $10 và $20, trong khi tờ $10 chỉ có thể làm tiền lẻ cho tờ $20.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize counters:** `five = 0`, `ten = 0`.
    *   **Khởi tạo bộ đếm:** `five = 0`, `ten = 0`.*

2.  **Iterate through `bills`:**
    - If bill is **$5**: increment `five`.
    - If bill is **$10**: increment `ten` and decrement `five`. If `five < 0`, return `false`.
    - If bill is **$20**:
        - Option A (Greedy): Give one **$10** and one **$5**. (Preferred because it saves $5s).
        - Option B: Give three **$5**s.
        - If neither is possible, return `false`.
    *   **Duyệt qua `bills`:** Nếu là tờ **$5**: tăng `five`. Nếu là tờ **$10**: tăng `ten` và giảm `five`. Nếu `five < 0`, trả về `false`. Nếu là tờ **$20**: Lựa chọn A (Tham lam): Đưa một tờ **$10** và một tờ **$5** (Ưu tiên vì tiết kiệm các tờ $5). Lựa chọn B: Đưa ba tờ **$5**. Nếu cả hai đều không khả thi, trả về `false`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
        if (bill == 5) {
            five++;
        } else if (bill == 10) {
            if (five == 0) return false;
            five--;
            ten++;
        } else { // bill == 20
            if (ten > 0 && five > 0) {
                ten--;
                five--;
            } else if (five >= 3) {
                five -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, for a single pass through the bills array.
    *   **Độ phức tạp thời gian:** $O(N)$, cho một lần duyệt qua mảng hóa đơn.*
*   **Space Complexity:** $O(1)$, only two variables used.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always prioritize giving out $10 bills when making change for a $20 bill. This is a greedy approach that preserves the more flexible $5 bills.
*Luôn ưu tiên đưa tờ $10 khi thối tiền cho tờ $20. Đây là cách tiếp cận tham lam giúp bảo tồn các tờ $5 linh hoạt hơn.*

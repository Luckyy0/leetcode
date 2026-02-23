# Analysis for Strong Password Checker
# *Phân tích cho bài toán Kiểm tra Mật khẩu Mạnh*

## 1. Problem Essence & Multi-stage Optimization
## *1. Bản chất vấn đề & Tối ưu hóa đa giai đoạn*

### The Challenge
### *Thách thức*
Satisfying three constraints simultaneously (length, types, repetition) with minimal operations. The core difficulty lies in the interaction between deletion and triplet reduction for passwords longer than 20 characters.

### Key Metrics
### *Các chỉ số chính*
1.  **Missing Types (MT):** 3 minus (hasLower + hasUpper + hasDigit).
2.  **Repetitions (R):** For any block of length $L \ge 3$, we need $\lfloor L/3 \rfloor$ replacements to break it.

---

## 2. Approach: Case-by-Case Strategy
## *2. Hướng tiếp cận: Chiến lược theo từng trường hợp*

### Case 1: Length < 6
### *Trường hợp 1: Độ dài < 6*
- Need to insert $6 - N$ characters.
- In-place replacements or insertions can also fix `MT` and `R`.
- Result: $\max(6 - N, MT)$.

### Case 2: 6 <= Length <= 20
### *Trường hợp 2: 6 <= Độ dài <= 20*
- No need for deletions/insertions for length.
- Fix `MT` and `R` using replacements.
- One replacement can both break a triplet and fulfill a missing type.
- Result: $\max(R_{total}, MT)$.

### Case 3: Length > 20
### *Trường hợp 3: Độ dài > 20*
- We MUST delete $D = N - 20$ characters.
- We want to use these $D$ deletions to reduce the required $R$ as much as possible.
- Each $R$ saved is one less replacement needed later.
- **Priority for deletions:**
    - Priority 1: $L \pmod 3 == 0$. Deleting 1 character reduces the replacement count by 1.
    - Priority 2: $L \pmod 3 == 1$. Deleting 2 characters (if available) reduces the replacement count by 1.
    - Priority 3: Remaining deletions reduce replacement count by 1 every 3 deletions.
- Result: $D + \max(R_{remaining}, MT)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy Optimization:** Prioritizing deletions that provide the "best bang for buck" in terms of triplet reduction.
    *Tối ưu hóa tham lam: Ưu tiên xóa các ký tự mang lại hiệu quả cao nhất trong việc giảm lặp.*
*   **Comprehensive Coverage:** Handles all constraints in a unified mathematical framework.
    *Bao phủ toàn diện: Xử lý mọi ràng buộc trong một khung toán học thống nhất.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the password.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ to store triplet lengths or $O(1)$ with clever tracking.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"aaaaaaAAAAAA111111" (Len 18)`
1. `MT = 0` (has L, U, D).
2. Triplets: `aaaaaa` (len 6, needs 2), `AAAAAA` (len 6, needs 2), `111111` (len 6, needs 2).
3. Total $R = 2+2+2 = 6$.
4. Len is in range $[6, 20]$.
Result: 6 replacements needed.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Calculate missing types and triplet lengths, then apply greedy deletions for length > 20.
*Tính số loại thiếu và độ dài lặp, sau đó áp dụng xóa tham lam cho độ dài > 20.*
---
*Xây dựng một mật khẩu mạnh (strong password) cũng giống như việc thiết kế một pháo đài. Nó cần có quy mô vừa đủ (length), sự đa dạng trong cấu trúc (missing types) và tránh sự đơn điệu lặp lại (repetition). Khi pháo đài quá lớn (length > 20), việc cắt tỉa (deletion) một cách khôn ngoan sẽ giúp bảo trì sự kiên cố mà không tiêu tốn quá nhiều tài nguyên (replacements).*
Building a strong password (strong password) is like designing a fortress. It needs a sufficient scale (length), diversity in structure (missing types), and to avoid monotonous repetition (repetition). When the fortress is too large (length > 20), wise pruning (deletion) will help maintain its solidity without consuming too many resources (replacements).

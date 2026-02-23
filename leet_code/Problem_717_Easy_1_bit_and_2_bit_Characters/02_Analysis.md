# Analysis for 1-bit and 2-bit Characters
# *Phân tích cho bài toán Ký tự 1-bit và 2-bit*

## 1. Problem Essence & Greedy Decoding
## *1. Bản chất vấn đề & Giải mã Tham lam*

### The Challenge
### *Thách thức*
The encoding rules are prefix-free for the leading bit:
- If a character starts with `0`, it **must** be the 1-bit character `0`.
- If a character starts with `1`, it **must** be a 2-bit character (`10` or `11`).
We need to determine if the very last `0` in the array is a standalone character or part of a `10` character.
*Các quy tắc mã hóa rất rõ ràng: Nếu ký tự bắt đầu bằng `0`, nó là ký tự 1-bit. Nếu bắt đầu bằng `1`, nó là ký tự 2-bit. Ta cần biết số `0` cuối cùng là một ký tự đứng riêng hay là phần đuôi của cặp `10`.*

---

## 2. Strategy: Linear Scan Simulation
## *2. Chiến lược: Mô phỏng Duyệt Tuyến tính*

Since the decoding is deterministic from left to right, we can simply simulate the process.
*Vì việc giải mã là xác định từ trái sang phải, ta có thể mô phỏng quá trình này một cách đơn giản.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate:** Start at `i = 0`.
2.  **Jump Logic:**
    - If `bits[i] == 1`: This is the start of a 2-bit character. Increment `i` by `2`.
    - If `bits[i] == 0`: This is a 1-bit character. Increment `i` by `1`.
3.  **Check Terminal State:**
    - Continue until `i` reaches at least `bits.length - 1`.
    - If the loop ends exactly at `i = bits.length - 1`, it means the last character we decoded started at the last available bit, thus it **must** be a 1-bit character.
    - If the loop ends at `i = bits.length`, it means the last character was a 2-bit character that finished exactly at the end.
    * **Kiểm tra trạng thái cuối:** Nếu quá trình duyệt kết thúc đúng tại chỉ số cuối cùng (`length - 1`), nghĩa là ký tự cuối là loại 1-bit. Nếu vượt qua, nghĩa là ký tự cuối là loại 2-bit.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of bits. We scan the array once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**bits = [1, 1, 1, 0]**
1. i = 0: `bits[0] == 1`. Jump to i = 2.
2. i = 2: `bits[2] == 1`. Jump to i = 4.
3. End loop because i >= length - 1.
4. i = 4. Since 4 != (4-1), result is `false`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

For deterministic coding problems, simpler simulation is always better than complex recursive backtracking. The leading bit is the decision-maker here.
*Đối với các bài toán mã hóa xác định, mô phỏng đơn giản luôn tốt hơn đệ quy phức tạp. Bit dẫn đầu là thực thể định đoạt ở đây.*
---
*Sự phân loại (Decoding) là một quá trình của sự lựa chọn không thể đảo ngược. Trong dãy các tín hiệu (Bits), mỗi bước đi (Jump) xác định số phận của những phần tử theo sau. Dữ liệu dạy ta rằng bằng cách tuân thủ luật lệ của sự khởi đầu (Decisive leading bit), ta có thể thấu thị được cấu trúc cuối cùng của một chuỗi thông tin từ những bước chân đầu tiên.*
Classification (Decoding) is a process of irreversible choices. In a series of signals (Bits), each step (Jump) determines the fate of subsequent elements. Data teaches us that by following the rules of the beginning (Decisive leading bit), we can see the final structure of an information chain from the very first steps.

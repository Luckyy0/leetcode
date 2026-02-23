# Analysis for Find the Closest Palindrome
# *Phân tích cho bài toán Tìm Số Đối xứng Gần nhất*

## 1. Problem Essence & The Boundary of Symmetry
## *1. Bản chất vấn đề & Ranh giới của sự Đối xứng*

### The Challenge
### *Thách thức*
Given an integer string $n$, we need to find the closest palindrome number (excluding $n$). If there's a tie, choose the smaller one.
*Cho một chuỗi số nguyên $n$, chúng ta cần tìm số đối xứng gần nhất (không bao gồm $n$). Nếu có sự cân bằng, hãy chọn số nhỏ hơn.*

With numbers up to $10^{18}$, searching via increment/decrement is impossible. We must generate potential palindromes directly from the prefix of $n$.
*Với các con số lên đến $10^{18}$, việc tìm kiếm thông qua tăng/giảm đơn thuần là không thể. Chúng ta phải tạo ra các số đối xứng tiềm năng trực tiếp từ tiền tố của $n$.*

---

## 2. Strategy: Candidate Generation via Prefix Variation
## *2. Chiến lược: Tạo Ứng cử viên qua Biến đổi Tiền tố*

The closest palindrome is likely formed by mirroring the first half of the digits of $n$. However, we must consider small changes to the middle digit to cover all possibilities.
*Số đối xứng gần nhất nhiều khả năng được hình thành bằng cách lấy đối xứng nửa đầu các chữ số của $n$. Tuy nhiên, chúng ta phải cân nhắc những thay đổi nhỏ đối với chữ số ở giữa để bao quát mọi khả năng.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Extract the Prefix:** Take the first `(length + 1) / 2` digits of $n$. Let this be `P`.
    * **Trích xuất Tiền tố:** Lấy `(độ dài + 1) / 2` chữ số đầu tiên của $n$. Gọi giá trị này là `P`.*

2.  **Generate 5 Candidates:**
    * **Tạo 5 Ứng cử viên:**
    - **C1: Mirror `P`.** (e.g., 123 -> 12 -> 121).
    - * **C1: Lấy đối xứng `P`.** (ví dụ: 123 -> 12 -> 121).*
    - **C2: Mirror `P + 1`.** (e.g., 123 -> 13 -> 131).
    - * **C2: Lấy đối xứng `P + 1`.** (ví dụ: 123 -> 13 -> 131).*
    - **C3: Mirror `P - 1`.** (e.g., 123 -> 11 -> 111).
    - * **C3: Lấy đối xứng `P - 1`.** (ví dụ: 123 -> 11 -> 111).*
    - **C4: Smallest number of `len - 1` digits.** (e.g., 100 -> 99). This is $10^{L-1} - 1$.
    - * **C4: Số nhỏ nhất gồm `len - 1` chữ số.** (ví dụ: 100 -> 99). Đây là $10^{L-1} - 1$.*
    - **C5: Smallest number of `len + 1` digits.** (e.g., 99 -> 101). This is $10^L + 1$.
    - * **C5: Số nhỏ nhất gồm `len + 1` chữ số.** (ví dụ: 99 -> 101). Đây là $10^L + 1$.*

3.  **Filtration:** Exclude `n` itself from the candidates.
    * **Lọc bỏ:** Loại bỏ chính `n` khỏi danh sách các ứng cử viên.*

4.  **Comparison:** For each candidate, calculate the absolute distance to $n$. Keep the one with the smallest distance. If distances are equal, pick the smaller candidate.
    * **So sánh:** Đối với mỗi ứng cử viên, hãy tính khoảng cách tuyệt đối đến $n$. Giữ lại số có khoảng cách nhỏ nhất. Nếu khoảng cách bằng nhau, hãy chọn ứng cử viên nhỏ hơn.*

---

## 3. Structural Advantages & Edge Case Logic
## *3. Ưu điểm Cấu trúc & Logic Trường hợp biên*

*   **Prefix Dominance:** The most significant digits control the distance. By mirroring the prefix, we ensure we are in the closest "power of ten" neighborhood possible.
    * **Sự thống trị của tiền tố:** Các chữ số quan trọng nhất kiểm soát khoảng cách. Bằng cách lấy đối xứng tiền tố, chúng ta đảm bảo mình đang ở trong vùng lân cận "lũy thừa của mười" gần nhất có thể.*
*   **Length Transitions:** Edge cases like 1000 or 999 are handled by the $10^{L-1}-1$ and $10^L+1$ candidates, which cover changes in digit count.
    * **Chuyển đổi độ dài:** Các trường hợp biên như 1000 hoặc 999 được xử lý bởi các ứng cử viên $10^{L-1}-1$ và $10^L+1$, giúp bao quát những thay đổi về số lượng chữ số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$, where $L$ is the number of digits in $n$. We perform a constant number of string operations and long conversions.
    * **Độ phức tạp thời gian:** $O(L)$, trong đó $L$ là số chữ số trong $n$. Chúng ta thực hiện một số lượng cố định các thao tác chuỗi và chuyển đổi số.*
*   **Space Complexity:** $O(L)$ to store the generated candidates.
    * **Độ phức tạp không gian:** $O(L)$ để lưu trữ các ứng cử viên được tạo ra.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `n = "128"`
- `len = 3`. `prefix = 12`.
- Candidates:
  1. Mirror `12` -> `121`. Diff = |128 - 121| = 7.
  2. Mirror `12 + 1 = 13` -> `131`. Diff = |128 - 131| = 3.
  3. Mirror `12 - 1 = 11` -> `111`. Diff = |128 - 111| = 17.
  4. Lower bound `10^2 - 1 = 99`. Diff = 29.
  5. Upper bound `10^3 + 1 = 1001`. Diff = 873.
- Result: **131** has the minimum difference.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always generate potential solutions from the "most significant" part of the input when dealing with extremely large search spaces.
*Luôn tạo ra các giải pháp tiềm năng từ phần "quan trọng nhất" của đầu vào khi đối mặt với không gian tìm kiếm cực kỳ lớn.*
---
*Số đối xứng (Palindrome) là vẻ đẹp của sự cân bằng. Đôi khi, để tìm thấy sự cân bằng gần nhất với hiện tại (Closest), ta phải thử thay đổi một chút ở tâm (Middle) hoặc thậm chí là chấp nhận một sự thay đổi hoàn toàn về quy mô (Edge cases).*
Palindromes (Palindrome) are the beauty of balance. Sometimes, to find the balance closest to the present (Closest), we have to try changing a bit in the heart (Middle) or even accept a complete change in scale (Edge cases).

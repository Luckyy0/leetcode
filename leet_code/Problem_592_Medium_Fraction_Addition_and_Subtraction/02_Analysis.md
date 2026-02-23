# Analysis for Fraction Addition and Subtraction
# *Phân tích cho bài toán Cộng và Trừ Phân số*

## 1. Problem Essence & Numeric Reduction
## *1. Bản chất vấn đề & Sự Rút gọn Số học*

### The Challenge
### *Thách thức*
We need to parse a string containing multiple fractions (with positive or negative signs) and calculate their sum, returning the result as an irreducible fraction.
*Chúng ta cần phân tích một chuỗi chứa nhiều phân số (với dấu cộng hoặc trừ) và tính tổng của chúng, trả về kết quả dưới dạng một phân số tối giản.*

Two core sub-problems:
*Hai bài toán con cốt lõi:*
1.  **String Parsing:** Correcting tokenizing fractions when signs act as separators.
    * **Phân tích Chuỗi:** Tách đúng các phân số khi các dấu đóng vai trò là ký tự phân cách.*
2.  **Fraction Arithmetic:** Common denominator operations and simplification using GCD.
    * **Số học Phân số:** Các phép toán mẫu số chung và rút gọn bằng cách sử dụng GCD.*

---

## 2. Strategy: Scanning and Iterative Summation
## *2. Chiến lược: Quét và Tính tổng Lặp*

Instead of finding the LCM for all fractions at once, we can sum them one by one.
*Thay vì tìm BCNN cho tất cả các phân số cùng một lúc, chúng ta có thể cộng từng phân số một.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Scanner Setup:** Use a tool (like `Scanner` in Java or a regex tokenizer) that can handle signs while reading integers.
    * **Thiết lập Bộ quét:** Sử dụng một công cụ (như `Scanner` trong Java hoặc trình phân tách regex) có thể xử lý các dấu khi đọc các số nguyên.*

2.  **Initialize Result:** Start with a fraction $\frac{0}{1}$ (numerator = 0, denominator = 1).
    * **Khởi tạo Kết quả:** Bắt đầu với phân số $\frac{0}{1}$ (tử số = 0, mẫu số = 1).*

3.  **The Loop:** For each fraction $\frac{n}{d}$ found in the string:
    * **Vòng lặp:** Đối với mỗi phân số $\frac{n}{d}$ tìm thấy trong chuỗi:*
    - Calculate the new numerator: $NewNum = CurrentNum \times d + n \times CurrentDen$.
    - *Tính tử số mới: $NewNum = CurrentNum \times d + n \times CurrentDen$.*
    - Calculate the new denominator: $NewDen = CurrentDen \times d$.
    - *Tính mẫu số mới: $NewDen = CurrentDen \times d$.*
    - **Simplify:** Find the Great Common Divisor ($GCD$) of the absolute values of $NewNum$ and $NewDen$. Divide both by $GCD$.
    - * **Rút gọn:** Tìm Ước chung lớn nhất ($GCD$) của các giá trị tuyệt đối của $NewNum$ và $NewDen$. Chia cả hai cho $GCD$.*

4.  **Formatting:** Return the result in the format `"numerator/denominator"`.
    * **Định dạng:** Trả về kết quả theo định dạng `"tử số/mẫu số"`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **GCD Utility:** Euclid's algorithm for GCD is indispensable for fraction simplification.
    * **Tiện ích GCD:** Thuật toán Euclid cho GCD là không thể thiếu để rút gọn phân số.*
*   **Sign Handling:** By treating signs as part of the numerator (e.g., `-1/2` is parsed as numerator `-1` and denominator `2`), the math remains purely additive.
    * **Xử lý Dấu:** Bằng cách coi dấu là một phần của tử số (ví dụ: `-1/2` được phân tích thành tử số `-1` và mẫu số `2`), toán học vẫn thuần túy là phép cộng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log M)$, where $N$ is the length of the string and $M$ is the magnitude of the largest denominator. Each GCD operation takes logarithmic time.
    * **Độ phức tạp thời gian:** $O(N \log M)$, trong đó $N$ là độ dài của chuỗi và $M$ là độ lớn của mẫu số lớn nhất. Mỗi phép tính GCD tốn thời gian logarit.*
*   **Space Complexity:** $O(1)$ additional space beyond the result string.
    * **Độ phức tạp không gian:** $O(1)$ không gian bổ sung bên ngoài chuỗi kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Expression:** `"1/3-1/2"`
1. Start: `0/1`.
2. Add `1/3`: $(0*3 + 1*1) / (1*3) = 1/3$.
3. Add `-1/2`: $(1*2 + -1*3) / (3*2) = (2-3)/6 = -1/6$.
4. Simplify: GCD(1, 6) = 1. No change.
5. Final: `-1/6`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For math problems involving string parsing, focus on robust tokenization (e.g., using a scanner with custom delimiters) to simplify the extraction of numerical components.
*Đối với các bài toán toán học liên quan đến phân tích chuỗi, hãy tập trung vào việc tách từ mạnh mẽ (ví dụ: sử dụng bộ quét với các ký tự phân tách tùy chỉnh) để đơn giản hóa việc trích xuất các thành phần số.*
---
*Toán học (Mathematics) là ngôn ngữ của sự chính xác. Khi các bộ phận (Fractions) riêng biệt hòa quyện thành một tổng thể (Sum), sự đơn giản hóa (Simplification) là bước cuối cùng để tìm thấy bản chất (GCD) cốt lõi của giá trị.*
Mathematics (Mathematics) is the language of precision. When individual parts (Fractions) merge into a whole (Sum), simplification (Simplification) is the final step to find the core essence (GCD) of value.

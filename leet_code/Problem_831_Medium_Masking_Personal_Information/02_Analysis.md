# Analysis for Masking Personal Information
# *Phân tích cho bài toán Che giấu Thông tin Cá nhân*

## 1. Problem Essence & Categorization
## *1. Bản chất vấn đề & Phân loại*

### THE CHALLENGE
### *Thách thức*
The goal is to mask sensitive personal information from a string that can be either an email or a phone number. We first need to distinguish between the two types and then apply the specific formatting rules for each.
*Mục tiêu là che giấu thông tin cá nhân nhạy cảm từ một chuỗi có thể là email hoặc số điện thoại. Đầu tiên, chúng ta cần phân biệt hai loại này và sau đó áp dụng các quy tắc định dạng cụ thể cho từng loại.*

---

## 2. Strategy: String Processing
## *2. Chiến lược: Xử lý chuỗi*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Distinguish Type:** If the string contains an '@' character, it's an email. Otherwise, it's a phone number.
    *   **Phân loại:** Nếu chuỗi chứa ký tự '@', đó là email. Ngược lại, đó là số điện thoại.*

2.  **Email Masking:**
    - Convert the whole string to lowercase.
    - Split at '@' to get `name` and `domain`.
    - Format as `name[0] + "*****" + name[last] + "@" + domain`.
    *   **Che giấu Email:** Chuyển tất cả thành chữ thường. Chia tại '@' để lấy `tên` và `tên_miền`. Định dạng thành `ký_tự_đầu + "*****" + ký_tự_cuối + "@" + tên_miền`.*

3.  **Phone Masking:**
    - Extract all digits from the string.
    - Determine if there's a country code based on the total digit count $N$:
        - $N = 10$: No country code. Format: `"***-***-XXXX"`.
        - $N > 10$: Format: `"+" + "*".repeat(N-10) + "-***-***-XXXX"`.
    - Here `XXXX` represents the last 4 digits.
    *   **Che giấu Số điện thoại:** Trích xuất tất cả chữ số. Xác định mã quốc gia dựa trên tổng số chữ số $N$. Nếu $N=10$, định dạng là `"***-***-XXXX"`. Nếu $N > 10$, thêm tiền tố mã quốc gia đằng trước.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String maskPII(String s) {
    if (s.contains("@")) {
        // Email
        s = s.toLowerCase();
        int atIndex = s.indexOf('@');
        return s.charAt(0) + "*****" + s.charAt(atIndex - 1) + s.substring(atIndex);
    } else {
        // Phone
        // Keep only digits
        String digits = s.replaceAll("[^0-9]", "");
        int n = digits.length();
        String lastFour = digits.substring(n - 4);
        String local = "***-***-" + lastFour;
        if (n == 10) return local;
        String country = "+";
        for (int i = 0; i < n - 10; i++) country += "*";
        return country + "-" + local;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$, where $L$ is the length of the string `s`. We traverse the string a constant number of times for conversion or digit extraction.
    *   **Độ phức tạp thời gian:** $O(L)$, với $L$ là độ dài chuỗi, do ta duyệt chuỗi một số lần cố định.*
*   **Space Complexity:** $O(L)$ or $O(1)$ extra space depending on how string builders are used, but primarily needs to store the resulting string.
    *   **Độ phức tạp không gian:** $O(L)$ để lưu trữ chuỗi kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `"1(234)567-89012"`
1. Digits: "123456789012" ($N=12$).
2. Last 4: "9012".
3. Local mask: "***-***-9012".
4. Country code: $12 - 10 = 2$ digits. Prefix: "+**-".
**Result:** "+**-***-***-9012"

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using `String.replaceAll("[^0-9]", "")` is a clean way to handle phone number formatting. For strings, always be mindful of case-sensitivity in the email part.
*Sử dụng `replaceAll` với biểu thức chính quy là cách sạch sẽ nhất để xử lý số điện thoại. Luôn chú ý đến phân biệt chữ hoa chữ thường trong phần email.*

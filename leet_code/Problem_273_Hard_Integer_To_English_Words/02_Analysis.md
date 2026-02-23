# Analysis for Integer to English Words
# *Phân tích cho bài toán Đổi Số nguyên sang Tiếng Anh*

## 1. Problem Essence & Grouping
## *1. Bản chất vấn đề & Nhóm*

### The Pattern
### *Mẫu*
English numbers are grouped by thousands:
- Billions
- Millions
- Thousands
- Hundreds

Within each group (0 to 999), the pattern is the same:
- `X Hundred` + `YY`
- `YY` is handled as:
    - `0-19`: Direct mapping (One, ..., Nineteen).
    - `20-99`: Tens (Twenty, ..., Ninety) + Units (One, ..., Nine).

### Strategy
### *Chiến lược*
1.  Handle 0 explicitly ("Zero").
2.  Split number into blocks of 1000.
3.  Iterate blocks from largest (Billion) to smallest.
4.  Function `helper(int num)` converts 0-999 to string.
5.  Append suffix ("Billion", "Million", "Thousand") if block > 0.

---

## 2. Approach: Recursive/Iterative Grouping
## *2. Hướng tiếp cận: Nhóm đệ quy/lặp*

### Logic
### *Logic*
Arrays:
- `LESS_THAN_20`: ["", "One", ... "Nineteen"]
- `TENS`: ["", "Ten", "Twenty", ... "Ninety"]
- `THOUSANDS`: ["", "Thousand", "Million", "Billion"]

Main: `numberToWords(num)`
- Loop `i` from 0 upwards (chunks).
- `chunk = num % 1000`.
- If `chunk > 0`: `res = helper(chunk) + THOUSANDS[i] + " " + res`.
- `num /= 1000`.

Helper: `helper(num)`
- `num == 0`: ""
- `num < 20`: `LESS_THAN_20[num]`
- `num < 100`: `TENS[num/10] + helper(num%10)`
- `num >= 100`: `LESS_THAN_20[num/100] + " Hundred " + helper(num%100)`

Trimming spaces is crucial.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Modular:** The logic for "123" is exactly the same whether it's 123 Billion or just 123.
    *Mô-đun: Logic cho "123" là hoàn toàn giống nhau dù là 123 Tỷ hay chỉ là 123.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where N is number of digits. Since max int is fixed, effectively $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 12345
1.  Chunk 1: `345`. `helper(345)` -> "Three Hundred Forty Five". Append "". Result: "Three Hundred Forty Five".
2.  Chunk 2: `12`. `helper(12)` -> "Twelve". Append "Thousand".
3.  Combine: "Twelve Thousand Three Hundred Forty Five".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Be super careful with spaces. " " should only be added between words.
*Cẩn thận với khoảng trắng.*
---
*Những con số khô khan khi được diễn giải thành lời (words) bỗng trở nên có hồn. Giao tiếp là nghệ thuật biến dữ liệu thành câu chuyện.*
Dry numbers, when translated into words, suddenly come alive. Communication is the art of turning data into stories.

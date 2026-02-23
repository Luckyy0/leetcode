# Analysis for Reverse Words in a String III
# *Phân tích cho bài toán Đảo ngược Từ trong Chuỗi III*

## 1. Problem Essence & Local Transformation
## *1. Bản chất vấn đề & Biến đổi Cục bộ*

### The Challenge
### *Thách thức*
We are tasked with reversing the characters of each individual word in a sentence, while keeping the spaces and the overall word order fixed.
*Chúng ta được giao nhiệm vụ đảo ngược các ký tự của từng từ riêng lẻ trong một câu, trong khi vẫn giữ cố định các khoảng trắng và thứ tự từ tổng thể.*

A word is defined as a sequence of non-space characters.
*Một từ được định nghĩa là một chuỗi các ký tự không phải khoảng trắng.*

---

## 2. Strategy: Two-Pointer Word-by-Word In-Place Reversal
## *2. Chiến lược: Đảo ngược Tại chỗ từng từ bằng Hai con trỏ*

The most efficient way to handle character manipulation in Java strings is to convert the string to a `char[]` first.
*Cách hiệu quả nhất để xử lý thao tác ký tự trong chuỗi Java là chuyển chuỗi đó thành một mảng `char[]` trước.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Conversion:** Convert the input string `s` to a character array `a`.
    * **Chuyển đổi:** Chuyển đổi chuỗi đầu vào `s` thành một mảng ký tự `a`.*

2.  **Boundary Identification:** Use a pointer `i` to scan the string.
    * **Xác định ranh giới:** Sử dụng một con trỏ `i` để quét qua chuỗi.*
    - Start a word at index `start = i`.
    - *Bắt đầu một từ tại chỉ số `start = i`.*
    - Move `i` forward until it hits a space or the end of the string. The end of the word is `end = i - 1`.
    - *Di chuyển `i` về phía trước cho đến khi gặp khoảng trắng hoặc kết thúc chuỗi. Điểm cuối của từ là `end = i - 1`.*

3.  **Local Reversal:** Once a word's boundaries `[start, end]` are found, use two pointers (`l = start`, `r = end`) to swap characters until they meet in the middle.
    * **Đảo ngược cục bộ:** Khi tìm thấy ranh giới của một từ `[start, end]`, hãy sử dụng hai con trỏ (`l = start`, `r = end`) để hoán đổi các ký tự cho đến khi chúng gặp nhau ở giữa.*

4.  **Skip Spaces:** Increment `i` to move past the space and repeat for the next word.
    * **Bỏ qua khoảng trắng:** Tăng `i` để đi qua khoảng trắng và lặp lại cho từ tiếp theo.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **In-Place Efficiency:** By working on a character array, we avoid creating numerous temporary string objects, which would put pressure on the Java Garbage Collector.
    * **Hiệu quả tại chỗ:** Bằng cách làm việc trên mảng ký tự, chúng ta tránh tạo ra vô số các đối tượng chuỗi tạm thời, điều này sẽ gây áp lực lên Bộ thu gom rác (Garbage Collector) của Java.*
*   **Simple Logic:** The separation of concerns between "finding boundaries" and "reversing" makes the code clean and easy to maintain.
    * **Logic đơn giản:** Việc tách biệt giữa các mối quan tâm "tìm ranh giới" và "đảo ngược" giúp mã nguồn sạch sẽ và dễ bảo trì.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We look at each character exactly twice (once to find the word boundary and once to perform the swap).
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta xem xét mỗi ký tự chính xác hai lần (một lần để tìm ranh giới từ và một lần để thực hiện hoán đổi).*
*   **Space Complexity:** $O(N)$. We need the space for the output character array (or StringBuilder).
    * **Độ phức tạp không gian:** $O(N)$. Chúng ta cần không gian cho mảng ký tự đầu ra (hoặc StringBuilder).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `"Let's go"`
1. Start=0. Find end of "Let's": `i` stops at index 5 (space). `end = 4`.
2. Reverse `a[0...4]`: "Let's" -> "s'teL".
3. Move `i` to 6. Find end of "go": `i` stops at end of string. `end = 7`.
4. Reverse `a[6...7]`: "go" -> "og".
5. Result: `"s'teL og"`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using the two-pointer approach on a mutable structure like `char[]` is the standard optimal performance pattern for string reversal problems.
*Sử dụng phương pháp hai con trỏ trên một cấu trúc có thể thay đổi như `char[]` là mô hình hiệu suất tối ưu tiêu chuẩn cho các bài toán đảo ngược chuỗi.*
---
*Mỗi từ ngữ (Word) mang trong mình một ý nghĩa, và dù thứ tự các ký tự có bị đảo lộn (Reverse), vị trí của chúng trong câu (Sentence) vẫn không đổi. Đây là lời nhắc nhở rằng chúng ta có thể thay đổi cách nhìn nhận bên trong mỗi vấn đề, nhưng cấu trúc tổng thể và sự liên kết giữa chúng vẫn cần được tôn trọng.*
Each word (Word) carries a meaning, and even if the order of characters is reversed (Reverse), its position in the sentence (Sentence) remains unchanged. This is a reminder that we can change the way we perceive inside each problem, but the overall structure and the connection between them still need to be respected.

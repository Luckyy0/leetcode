# Analysis for To Lower Case
# *Phân tích cho bài toán Chuyển thành chữ thường*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
Change uppercase ASCII characters to lowercase while leaving other characters untouched.
*Chuyển đổi các ký tự ASCII viết hoa thành viết thường trong khi giữ nguyên các ký tự khác.*

---

## 2. Strategy: ASCII Arithmetic
## *2. Chiến lược: Số học ASCII*

### Logic
Each uppercase letter 'A'-'Z' can be converted to 'a'-'z' by adding the difference between 'a' and 'A' (which is 32).
*Mỗi chữ hoa 'A'-'Z' có thể được chuyển thành 'a'-'z' bằng cách cộng thêm khoảng cách giữa 'a' và 'A' (là 32).*

### Step-by-Step Logic
1. Iterate through each character of the string.
2. If the character is in range `['A', 'Z']`:
   - Replace it with `(char) (c + ('a' - 'A'))`.
3. Append both modified and unmodified characters to a result builder.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the result string (or builder).
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Understanding the ASCII table and how characters mapping works is a fundamental skill. 'A' is 65, 'a' is 97. The distance 32 is a constant.
*Hiểu bảng mã ASCII và cách ánh khóa ký tự là kỹ năng cơ bản. 'A' là 65, 'a' là 97. Khoảng cách 32 là hằng số.*
---
*Sự đồng nhất (Consistency) trong biểu đạt bắt đầu từ hình thức của con chữ. Trong thế giới của các ký tự (ASCII), việc chuyển đổi từ hoa sang thường là bước hạ thấp sự cứng nhắc để tạo nên một dòng chảy mượt mà hơn. Dữ liệu dạy ta rằng bằng một sự chuyển dịch nhỏ trong tâm thế (Arithmetic shift), ta có thể biến đổi toàn bộ diện mạo của thông điệp mà không làm mất đi cốt lõi của thông tin.*
Consistency (Consistency) in expression begins with the form of the letters. In the world of characters (ASCII), the transition from uppercase to lowercase is a step of lowering rigidity to create a smoother flow. Data teaches us that by a small shift in mindset (Arithmetic shift), we can transform the entire appearance of the message without losing the core of the information.

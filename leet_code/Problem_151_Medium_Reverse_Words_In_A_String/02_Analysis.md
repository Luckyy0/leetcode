# Analysis for Reverse Words in a String
# *Phân tích cho bài toán Đảo ngược từ trong chuỗi*

## 1. Problem Essence & String Manipulation Constraints
## *1. Bản chất vấn đề & Ràng buộc xử lý chuỗi*

### The "Clean-up" Requirement
### *Yêu cầu "Làm sạch"*
The main challenge isn't just reversing the order of words, but handling the messy input. We must:
1. Ignore leading spaces.
2. Ignore trailing spaces.
3. Compress multiple spaces between words into a single space.
*Thử thách chính không chỉ là đảo ngược thứ tự các từ, mà là xử lý đầu vào lộn xộn. Chúng ta phải: 1. Bỏ qua khoảng trắng ở đầu. 2. Bỏ qua khoảng trắng ở cuối. 3. Nén nhiều khoảng trắng giữa các từ thành một khoảng trắng duy nhất.*

### Language Specifics (Java)
### *Đặc thù ngôn ngữ (Java)*
In Java, strings are **immutable**. This means any modification results in a new string object. For efficient manipulation, we should use built-in library functions or a `StringBuilder`.
*Trong Java, chuỗi là **bất biến**. Điều này có nghĩa là bất kỳ sửa đổi nào cũng tạo ra một đối tượng chuỗi mới. Để xử lý hiệu quả, chúng ta nên sử dụng các hàm thư viện có sẵn hoặc `StringBuilder`.*

---

## 2. Approach: Standard Library usage (The Efficient Way)
## *2. Hướng tiếp cận: Sử dụng thư viện tiêu chuẩn (Cách hiệu quả)*

### Algorithm Logic
### *Logic thuật toán*
1.  **Trim:** Use `s.trim()` to remove leading and trailing spaces immediately.
2.  **Split:** Use `s.split("\\s+")`. The regex `\\s+` matches one or more whitespace characters. This effectively handles multiple spaces between words and returns an array of clean words.
3.  **Reverse and Join:** Iterate through the word array from the last element to the first, appending each to a `StringBuilder` with a space in between (except for the last word).

---

## 3. Alternative Approach: In-place-like manipulation
## *3. Hướng tiếp cận thay thế: Mô phỏng thao tác tại chỗ*

If we were working with a language with mutable strings (like C++ `char*`), we could:
1. Reverse the entire string.
2. Iterate through the string and reverse each individual word.
3. Clean up the spaces.
*Nếu chúng ta làm việc với một ngôn ngữ có chuỗi khả biến, chúng ta có thể: 1. Đảo ngược toàn bộ chuỗi. 2. Lặp qua chuỗi và đảo ngược từng từ riêng lẻ. 3. Làm sạch các khoảng trắng.*
In Java, this is less efficient because of the immutability, but it's a good mental model for memory-constrained problems.
*Trong Java, cách này ít hiệu quả hơn do tính bất biến, nhưng nó là một mô hình tư duy tốt cho các bài toán bị hạn chế bộ nhớ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    - `trim()` takes $O(N)$.
    - `split()` takes $O(N)$.
    - Building the result string takes $O(N)$.
    *Độ phức tạp thời gian: $O(N)$, trong đó $N$ là độ dài của chuỗi. Các thao tác trim, split và xây dựng kết quả đều tốn thời gian tuyến tính.*
*   **Space Complexity:** $O(N)$. We need space to store the split words and the final reconstructed string.
    *Độ phức tạp không gian: $O(N)$. Chúng ta cần không gian để lưu trữ các từ được tách ra và chuỗi được tái cấu trúc cuối cùng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "  hello   world  "`

1. `s.trim()` -> `"hello   world"`
2. `s.split("\\s+")` -> Array: `["hello", "world"]`
3. Reverse iterate:
   - Append "world". `SB: "world"`
   - Append " ". `SB: "world "`
   - Append "hello". `SB: "world hello"`
4. **Final Result:** `"world hello"`

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Using `split("\\s+")` is the most readable and professional way to handle this problem in Java. It leverages the power of regular expressions to handle the tricky multiple-space edge cases cleanly. Always remember to use `StringBuilder` for the final assembly to avoid creating many temporary string objects in memory.
*Sử dụng `split("\\s+")` là cách chuyên nghiệp và dễ đọc nhất để xử lý bài toán này trong Java. Nó tận dụng sức mạnh của biểu thức chính quy để xử lý các trường hợp biên nhiều khoảng trắng một cách sạch sẽ. Luôn nhớ sử dụng `StringBuilder` để lắp ghép kết quả cuối cùng nhằm tránh tạo ra nhiều đối tượng chuỗi tạm thời trong bộ nhớ.*
---
*Đôi khi việc nhìn thế giới từ dưới lên trên, từ sau ra trước, sẽ giúp chúng ta nhận ra những giá trị cốt lõi bị vùi lấp bởi những khoảng trống vô nghĩa.*
Sometimes looking at the world from bottom to top, from back to front, will help us realize the core values buried by meaningless gaps.

# Analysis for Ambiguous Coordinates
# *Phân tích cho bài toán Tọa độ không rõ ràng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a string of digits inside parentheses, we need to split the string into two parts (X and Y coordinates) and then insert decimal points in each part such that they form valid numbers. 
A number is **valid** if:
- It doesn't have unnecessary leading zeros (e.g., "01" is invalid, but "0" or "0.1" is okay).
- It doesn't have unnecessary trailing zeros in the decimal part (e.g., "0.10" is invalid).
*Cho một chuỗi chữ số trong dấu ngoặc đơn, chúng ta cần chia chuỗi thành hai phần (tọa độ X và Y), sau đó chèn dấu thập phân vào mỗi phần sao cho chúng tạo thành các số hợp lệ. Một số là hợp lệ nếu: Không có số 0 thừa ở đầu (ví dụ "01" sai, nhưng "0" hoặc "0.1" đúng), và không có số 0 thừa ở cuối phần thập phân (ví dụ "0.10" sai).*

---

## 2. Strategy: Brute Force with Validation
## *2. Chiến lược: Duyệt trâu kèm Kiểm chuẩn*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Strip Parentheses:** Get the inner digits of the string `s`.
    *   **Bỏ ngoặc:** Lấy phần chữ số bên trong chuỗi `s`.*

2.  **Split into X and Y:** Iterate through all possible split points `i` to divide the string into two halves.
    *   **Chia X và Y:** Duyệt qua mọi điểm chia `i` để tách chuỗi thành hai nửa.*

3.  **Generate Valid Numbers for Each Half:** For each half (X or Y), find all possible valid ways to format it as a number (with or without a decimal point).
    *   **Tạo số hợp lệ cho mỗi nửa:** Với mỗi phần (X hoặc Y), tìm tất cả các cách định dạng hợp lệ (có hoặc không có dấu thập phân).*

4.  **Combining:** Combine every valid representation of the X part with every valid representation of the Y part to form the final coordinate string `"(X, Y)"`.
    *   **Kết hợp:** Kết hợp mọi cách biểu diễn X hợp lệ với mọi cách biểu diễn Y hợp lệ.*

### Validation Logic for a single part `str`:
-   No decimal point: `str` is valid if `str.length == 1` OR `str[0] != '0'`.
-   With decimal point at `dotIndex`:
    -   Integral part `str[0...dotIndex-1]` is valid.
    -   Fractional part `str[dotIndex...end]` is valid if `str[end] != '0'`.

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<String> ambiguousCoordinates(String s) {
    List<String> result = new ArrayList<>();
    String digits = s.substring(1, s.length() - 1);
    
    // Split into X and Y
    for (int i = 1; i < digits.length(); i++) {
        List<String> xList = getValidNumbers(digits.substring(0, i));
        List<String> yList = getValidNumbers(digits.substring(i));
        
        for (String x : xList) {
            for (String y : yList) {
                result.add("(" + x + ", " + y + ")");
            }
        }
    }
    return result;
}

private List<String> getValidNumbers(String s) {
    List<String> list = new ArrayList<>();
    int n = s.length();
    
    // Case 1: No decimal point
    if (n == 1 || s.charAt(0) != '0') {
        list.add(s);
    }
    
    // Case 2: Insert decimal point
    for (int i = 1; i < n; i++) {
        String left = s.substring(0, i);
        String right = s.substring(i);
        
        // Validation:
        // Left: No leading zeros (unless "0")
        // Right: No trailing zeros
        if ((left.length() == 1 || left.charAt(0) != '0') && right.charAt(right.length() - 1) != '0') {
            list.add(left + "." + right);
        }
    }
    return list;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. $N$ is the length of digits. We split the string in $O(N)$ ways, and for each part, we check $O(N)$ dot positions. String concatenations add another $O(N)$. Since $N \le 10$, this is very small.
    *   **Độ phức tạp thời gian:** $O(N^3)$, với $N$ là độ dài chuỗi chữ số. Do $N \le 10$, thuật ngữ này rất nhỏ.*
*   **Space Complexity:** $O(N^3)$, to store the resulting strings.
    *   **Độ phức tạp không gian:** $O(N^3)$, để lưu các chuỗi kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `"(123)"`
1. Split: "1" and "23".
   - "1" -> ["1"]
   - "23" -> ["23", "2.3"]
   - Combinations: "(1, 23)", "(1, 2.3)"
2. Split: "12" and "3".
   - "12" -> ["12", "1.2"]
   - "3" -> ["3"]
   - Combinations: "(12, 3)", "(1.2, 3)"
**Total:** ["(1, 23)", "(1, 2.3)", "(12, 3)", "(1.2, 3)"]

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Splitting into two problems (splitting the string and validating numbers) makes the solution much cleaner. The strict zero rules handle most of the filtering logic.
*Chia bài toán thành hai phần (chia chuỗi và kiểm tra tính hợp lệ của số) giúp giải pháp sạch sẽ hơn nhiều. Các quy tắc nghiêm ngặt về số 0 xử lý hầu hết logic lọc.*

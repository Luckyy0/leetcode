# Analysis for Backspace String Compare
# *Phân tích cho bài toán So sánh Chuỗi có Dấu xóa ngược*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to compare two strings after applying backspace operations. The '#' character deletes the immediately preceding character if one exists.
*Chúng ta cần so sánh hai chuỗi sau khi thực hiện thao tác xóa ngược. Ký tự '#' sẽ xóa ký tự đứng ngay trước nó nếu có.*

---

## 2. Strategy: Two Pointers (Backward Iteration)
## *2. Chiến lược: Hai con trỏ (Duyệt ngược)*

### Why Backward?
### *Tại sao duyệt ngược?*
If we process the string from start to finish, the '#' affects what we've already seen (requires a stack). If we process it from finish to start, a '#' tells us how many future characters we must skip. This allows comparing the strings in $O(1)$ space.
*Nếu xử lý từ đầu đến cuối, phím '#' sẽ ảnh hưởng đến những gì đã xem (cần dùng stack). Nếu xử lý từ cuối về đầu, một phím '#' cho biết chúng ta cần bỏ qua bao nhiêu ký tự tiếp theo. Điều này cho phép so sánh các chuỗi trong không gian $O(1)$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Pointers:** Start `i` at the end of `s` and `j` at the end of `t`.
    *   **Khởi tạo con trỏ:** Bắt đầu `i` ở cuối chuỗi `s` và `j` ở cuối chuỗi `t`.*

2.  **Handle Backspaces:** While iterating backwards:
    - If current char is '#', increment a `skip` counter and move back.
    - If current char is a letter and `skip > 0`, ignore the char, decrement `skip`, and move back.
    - Stop when we find a "valid" character (one that will survive the backspaces).
    *   **Xử lý xóa ngược:** Trong khi duyệt ngược: Nếu gặp '#', tăng biến đếm `skip`. Nếu gặp chữ cái và `skip > 0`, bỏ qua chữ đó và giảm `skip`. Dừng lại khi tìm được ký tự "hợp lệ" (không bị xóa).*

3.  **Compare:** Compare the valid characters from `s` and `t`. If they differ, return `false`.
    *   **So sánh:** So sánh các ký tự hợp lệ từ cả hai chuỗi. Nếu khác nhau, trả về `false`.*

4.  **Repeat:** Repeat until both strings are exhausted.
    *   **Lặp lại:** Thực hiện cho đến khi duyệt hết cả hai chuỗi.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean backspaceCompare(String s, String t) {
    int i = s.length() - 1, j = t.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) {
        // Find next valid char in s
        while (i >= 0) {
            if (s.charAt(i) == '#') { skipS++; i--; }
            else if (skipS > 0) { skipS--; i--; }
            else break;
        }
        // Find next valid char in t
        while (j >= 0) {
            if (t.charAt(j) == '#') { skipT++; j--; }
            else if (skipT > 0) { skipT--; j--; }
            else break;
        }
        
        // Compare current valid chars
        if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
        if ((i >= 0) != (j >= 0)) return false; // One string empty, other not
        
        i--; j--;
    }
    return true;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the strings. Each character is visited once.
    *   **Độ phức tạp thời gian:** $O(N + M)$, duyệt qua mỗi ký tự một lần.*
*   **Space Complexity:** $O(1)$ since we only use a few integer variables.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Working backward is a powerful technique whenever operations affect previous elements. It often transforms an $O(N)$ space problem into an $O(1)$ space problem.
*Làm việc ngược từ cuối lên là một kỹ thuật mạnh mẽ bất cứ khi nào các thao tác ảnh hưởng đến các phần tử trước đó. Nó thường chuyển đổi một bài toán tốn bộ nhớ $O(N)$ thành $O(1)$.*

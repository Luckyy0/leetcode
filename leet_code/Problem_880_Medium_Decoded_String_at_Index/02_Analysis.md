# Analysis for Decoded String at Index
# *Phân tích cho bài toán Chuỗi Giải mã tại Chỉ số*

## 1. Problem Essence & Constraints
## *2. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the $K$-th character of a string that has been repeatedly expanded by digits. The expanded string can be massive (up to $2^{63}-1$), so we **cannot** actually build it in memory.
*Tìm ký tự thứ $K$ của một chuỗi đã được mở rộng bằng các chữ số. Chuỗi mở rộng có thể cực kỳ lớn, vì vậy chúng ta **không thể** thực sự xây dựng nó trong bộ nhớ.*

---

## 2. Strategy: Reverse Traversal with Modulo
## *2. Chiến lược: Duyệt ngược với phép chia lấy dư*

### Key Logic
### *Logic chính*
When a string of length $L$ is repeated $D$ times, the character at $K$ in the new string is the same as the character at $K \pmod L$ in the original string of length $L$.
*Khi một chuỗi độ dài $L$ được lặp lại $D$ lần, ký tự tại vị trí $K$ trong chuỗi mới giống với ký tự tại vị trí $K \pmod L$ trong chuỗi gốc độ dài $L$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Calculate Total Length:** Traverse the string once to find the final decoded length.
    - If char is letter: `size++`.
    - If char is digit `d`: `size *= d`.
    *   **Tính tổng độ dài:** Duyệt qua chuỗi một lần để tìm độ dài giải mã cuối cùng. Nếu là chữ cái, tăng `size`. Nếu là chữ số `d`, nhân `size` với `d`.*

2.  **Traverse backwards:**
    - Iterate the encoded string from end to start.
    - Update $K = K \pmod{size}$.
    - If $K == 0$ and current character is a letter: We found it! Return the character.
    - If current character is a digit `d`: Shrink `size = size / d`.
    - Else (if char is letter): `size--`.
    *   **Duyệt ngược:** Duyệt chuỗi đã mã hóa từ cuối lên đầu. Cập nhật $K = K \pmod{size}$. Nếu $K=0$ và ký tự hiện tại là chữ cái: Trả về ký tự đó. Nếu là chữ số, thu nhỏ `size`. Nếu là chữ cái, giảm `size` đi 1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String decodeAtIndex(String s, int k) {
    long size = 0;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) size *= (c - '0');
        else size++;
    }
    
    long K = k;
    for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        K %= size;
        if (K == 0 && Character.isLetter(c)) return String.valueOf(c);
        
        if (Character.isDigit(c)) size /= (c - '0');
        else size--;
    }
    return "";
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the encoded string. We traverse the string twice.
    *   **Độ phức tạp thời gian:** $O(N)$, vì chúng ta duyệt qua chuỗi hai lần.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Whenever a problem involves massive repetition or extremely long strings with a predictable pattern, use modulo arithmetic to "wrap" the index back into a manageable range.
*Bất cứ khi nào bài toán liên quan đến sự lặp lại quy mô lớn hoặc các chuỗi cực dài với quy luật có thể dự đoán được, hãy sử dụng phép toán modulo để "quấn" chỉ số trở lại phạm vi có thể quản lý được.*

# Analysis for Check If Word Is Valid After Substitutions
# *Phân tích cho bài toán Kiểm tra xem Từ có Hợp lệ sau khi thay thế không*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A valid string is built exclusively by repeatedly inserting `"abc"`. Given a string, determine if it could have been built this way.
*Một chuỗi hợp lệ chỉ được xây dựng bằng cách chèn liên tục `"abc"`. Cho một chuỗi, hãy xác định xem nó có thể được xây dựng theo cách này hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a classic parsing problem evaluating nested structures, very similar to matching parentheses like `()` or `[]`.
- Instead of matching pairs, we are matching the triplet sequence `"abc"`.
- If a string is valid, we should be able to un-build it by continuously removing `"abc"` substrings until the string is completely empty.
- When we scan the string from left to right, whenever we encounter the character `'c'`, the two characters immediately preceding it MUST be `'b'` and `'a'` respectively. If they are, it forms `"abc"`, and we can safely "remove" them and continue.
*Bài toán rất giống với bài toán kiểm tra dấu ngoặc hợp lệ. Thay vì tìm các cặp `()`, ta tìm các cụm 3 ký tự `"abc"`. Khi tìm thấy chữ `'c'`, nếu 2 chữ trước nó là `'a'` và `'b'`, ta thu hồi (rút) chúng lại. Thích hợp nhất để dùng Ngăn xếp (Stack).*

---

## 2. Strategy: Stack Simulation
## *2. Chiến lược: Mô phỏng Ngăn xếp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Array Stack:** To optimize speed, instead of using Java's `Stack` class, use a primitive `char[]` array as a stack along with a `top` pointer initialized to `0`.
    *   **Khởi tạo Ngăn xếp mảng:** Sử dụng mảng `char[]` và con trỏ `top` làm mảng xếp.*

2.  **Iterate Over String:** Process each character `ch` in `s`.
    - If `ch == 'c'`: Check if the stack has at least 2 characters (`top >= 2`), AND the top character is `'b'` (`stack[top - 1] == 'b'`), AND the character below it is `'a'` (`stack[top - 2] == 'a'`).
      - If true: "Pop" `"ab"` off the stack by decrementing `top` by 2 (`top -= 2`). We don't push the `'c'`.
      - If false: We found a `'c'` without a matching `"ab"`. The string is invalid, but we can just push it anyway. Wait, structurally, pushing it is fine because it will never form `"abc"` later, and at the end `top` won't be 0. So `stack[top++] = ch`.
    - If `ch != 'c'`: Simply push it onto the stack: `stack[top++] = ch`.
    *   **Lặp qua chuỗi:**  Gặp `'c'`, kiểm tra 2 vị trí trước có phải `'a'` và `'b'` không. Nếu đúng, pop ra. Nếu không (hoặc là ký tự khác), cứ đưa vào ngăn xếp.*

3.  **Evaluate:** After finishing the loop, if the string was perfectly built by `"abc"` insertions, the stack should be entirely empty (`top == 0`). Return `true`. Otherwise, return `false`.
    *   **Đánh giá:** Ngăn xếp phải hoàn toàn rỗng ở cuối thì mới hợp lệ.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'c') {
                if (top >= 2 && stack[top - 1] == 'b' && stack[top - 2] == 'a') {
                    // Valid 'abc' found, pop 'a' and 'b'
                    top -= 2;
                } else {
                    // Invalid, but push it to fail the top == 0 condition at the end
                    stack[top++] = ch;
                }
            } else {
                stack[top++] = ch;
            }
        }
        
        return top == 0;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the length of `s`. We scan the string strictly once from left to right, doing $O(1)$ operations per character.
    *   **Độ phức tạp thời gian:** $O(N)$. Quét tuyến tính.*
*   **Space Complexity:** $O(N)$ for the `char[]` stack holding at most $N$ characters.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simulating a stack with an initialized primitive array provides blazingly fast parsing execution, ideal for syntax validation problems.
*Mô phỏng ngăn xếp bằng một mảng nguyên thủy cung cấp tốc độ phân tích cú pháp chớp nhoáng, lý tưởng cho các bài toán kiểm tra tính hợp lệ về mặt ngữ pháp.*

# Analysis for Score of Parentheses
# *Phân tích cho bài toán Điểm của Dấu ngoặc*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to compute a recursive score for balanced parentheses. The base case `()` is 1 point. Wrapping doubles the inside score, and juxtaposition adds scores together.
*Chúng ta cần tính điểm theo đệ quy cho các dấu ngoặc cân bằng. Trường hợp cơ bản `()` là 1 điểm. Bao quanh sẽ nhân đôi điểm bên trong và đặt cạnh nhau sẽ cộng các điểm lại với nhau.*

---

## 2. Strategy: Stack or Tree Depth
## *2. Chiến lược: Ngăn xếp hoặc Độ sâu cây*

### Key Insight
### *Nhận thức chính*
The nested structure suggests using a stack or observing the "depth" of the innermost pairs.
*Cấu trúc lồng nhau gợi ý việc sử dụng ngăn xếp hoặc quan sát "độ sâu" của các cặp trong cùng.*

### Approach 1: Stack
### *Cách tiếp cận 1: Ngăn xếp*
- Maintain a stack of current scores.
- Push `0` when we see `(`.
- When we see `)`, pop the inner score. If it was `0`, the inner pair was `()`, so its score is 1. Otherwise, it's `2 * pop`.
- Add this score to the new top of the stack.
*Duy trì một ngăn xếp các điểm hiện tại. Đẩy `0` khi gặp `(`. Khi gặp `)`, lấy điểm bên trong ra. Nếu là `0`, cặp bên trong là `()`, vì vậy điểm là 1. Ngược lại, điểm là `2 * pop`. Cộng điểm này vào đỉnh mới của ngăn xếp.*

### Approach 2: Constant Space (Bitwise)
### *Cách tiếp cận 2: Không gian không đổi (Bitwise)*
- Only the innermost `()` pairs contribute to the total score.
- A `()` pair at depth `d` contributes $2^d$ points.
- We can traverse the string and maintain current depth. When we see a literal `()`, add $2^d$ to the result.
*Chỉ những cặp `()` trong cùng mới đóng góp vào tổng điểm. Một cặp `()` ở độ sâu `d` đóng góp $2^d$ điểm. Chúng ta có thể duyệt chuỗi và duy trì độ sâu hiện tại. Khi gặp một cặp `()`, cộng $2^d$ vào kết quả.*

---

## 3. Implementation Logic (Approach 2)
## *3. Logic triển khai (Cách tiếp cận 2)*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int scoreOfParentheses(String s) {
    int score = 0, depth = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            depth++;
        } else {
            depth--;
            if (s.charAt(i - 1) == '(') {
                score += 1 << depth;
            }
        }
    }
    return score;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ for a single pass through the string.
    *   **Độ phức tạp thời gian:** $O(N)$ cho một lần duyệt qua chuỗi.*
*   **Space Complexity:** $O(1)$ for the binary/depth approach.
    *   **Độ phức tạp không gian:** $O(1)$ cho cách tiếp cận nhị phân/độ sâu.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Observing that score depends on binary powers of depth is a clever way to solve this in $O(1)$ space.
*Nhận thấy rằng điểm số phụ thuộc vào lũy thừa bậc 2 của độ sâu là một cách thông minh để giải bài này trong không gian $O(1)$.*

# Analysis for Clumsy Factorial
# *Phân tích cho bài toán Giai thừa Vụng về*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Evaluate a mathematical expression involving `*`, `/`, `+`, `-` with standard arithmetic operator precedence, but the operators repeat in a strict sequence.
*Tính giá trị một biểu thức toán học bao gồm `*`, `/`, `+`, `-` có xét sự ưu tiên toán tử thông thường, nhưng các phép toán được lặp lại theo một trình tự nghiêm ngặt.*

---

## 2. Strategy 1: Naive (Stack Simulation)
## *2. Chiến lược 1: Ngây thơ (Mô phỏng bằng Ngăn xếp)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy simulates the calculation using a Stack. When encountering multiplication or division, we can instantly pop the last number, perform the operation, and push the result back. Addition and subtraction numbers can simply be pushed (with the appropriate sign), and later we sum everything up.
*Chiến lược ngây thơ dùng Ngăn xếp (Stack) để mô phỏng tính toán. Khi gặp phép nhân chia, ta rút số cuối ra tính luôn rồi ném lại. Khi gặp cộng trừ thì đẩy số đó (kèm dấu dương hoặc âm) vào ngăn xếp. Cuối cùng tính tổng mảng xếp lại.*

```java
import java.util.Stack;

public class Solution {
    public int clumsyNaive(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;
        int op = 0; // 0: *, 1: /, 2: +, 3: -
        
        while (n > 0) {
            if (op == 0) {
                stack.push(stack.pop() * n);
            } else if (op == 1) {
                stack.push(stack.pop() / n);
            } else if (op == 2) {
                stack.push(n);
            } else if (op == 3) {
                stack.push(-n);
            }
            n--;
            op = (op + 1) % 4;
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
```

- **Weakness (Điểm yếu):** While $O(N)$ time complexity is perfectly fine for $N \le 10^4$, this approach requires an entire `java.util.Stack` data structure which uses $O(N)$ space and boxing/unboxing overhead for `Integer` objects.
  *Mặc dù thời gian $O(N)$ hoàn toàn phù hợp với $N \le 10^4$, phương pháp này đòi hỏi cả một cấu trúc dữ liệu `java.util.Stack` ngốn $O(N)$ bộ nhớ, đồng thời mất hiệu suất do có thao tác bọc/mở hộp (boxing/unboxing) đối tượng `Integer`.*

---

## 3. Strategy 2: Optimal (Mathematical Grouping / O(1) Space)
## *3. Chiến lược 2: Tối ưu (Nhóm Toán học / Không gian O(1))*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Because the series strictly groups by 4 operations: `x * (x-1) / (x-2) + (x-3) - ...`, we observe that `x * (x-1) / (x-2)` roughly equals `x+1`. For numbers larger than 4, there's a strong mathematical pattern regarding the modulus. But even without mathematical tricks, we can simulate the grouping iteratively with mere $O(1)$ constant variables without a physical Stack. We just handle chunks of 4 sequentially. By doing so, we bypass the $O(N)$ memory overhead footprint altogether.
*Bởi vì dãy số chia thành các nhóm 4 phép toán `x * (x-1) / (x-2) + (x-3) - ...`, ta nhận ra cụm `x * (x-1) / (x-2)` gần như bằng `x+1`. Có những quy luật toán học rõ ràng khi $N > 4$. Nhưng ngay cả không dùng quy luật, ta có thể tự duyệt theo từng đoạn chunk độ dài 4 bằng biến rời rạc, không cần dùng Stack thực thụ ($O(1)$ space).*

If we want the pure Math $O(1)$ trick:
*Nếu dùng Mẹo Toán học $O(1)$ thuần túy:*
- `N = 1 -> 1`
- `N = 2 -> 2`
- `N = 3 -> 6`
- `N = 4 -> 7`
- `N % 4 == 0 -> N + 1`
- `N % 4 == 1 -> N + 2`
- `N % 4 == 2 -> N + 2`
- `N % 4 == 3 -> N - 1`

### Algorithm Steps (Math Trick)
### *Các bước thuật toán (Mẹo Toán học)*

This runs in literal $O(1)$ complexity, completely bypassing parsing or simulations!
*Cách này chạy mất độ phức tạp siêu hạn $O(1)$, lách qua luôn quá trình tạo mảng và giải phương trình! Trả kết quả theo modulo 4 một cách chớp nhoáng.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int clumsy(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        if (n == 4) return 7;
        
        if (n % 4 == 0) return n + 1;
        else if (n % 4 == 1) return n + 2;
        else if (n % 4 == 2) return n + 2;
        else return n - 1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. It solves the problem immediately purely based on the mathematical residue class modulo 4.
    *   **Độ phức tạp thời gian:** $O(1)$. Bài toán được giải quyết lập tức qua các trường hợp dư lấy theo modulo 4.*
*   **Space Complexity:** $O(1)$. No extra space requires.
    *   **Độ phức tạp không gian:** $O(1)$. Không cần tốn thêm bộ nhớ.*

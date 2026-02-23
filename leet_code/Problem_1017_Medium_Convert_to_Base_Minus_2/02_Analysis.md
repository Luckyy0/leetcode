# Analysis for Convert to Base -2
# *Phân tích cho bài toán Chuyển Cơ số -2*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Convert a base-10 integer into base -2 (negabinary). In standard binary, digits represent powers of $2$ ($2^0, 2^1, 2^2...$). In negabinary, digits tightly represent powers of $-2$ ($(-2)^0=1, (-2)^1=-2, (-2)^2=4, (-2)^3=-8...$). The digits must still be exclusively `0` or `1`.
*Chuyển một số nguyên hệ 10 sang hệ Cơ số -2 (Nhị phân âm). Trong nhị phân thường, các ký tự đứng cho số mũ của $2$ (như $1, 2, 4, 8$). Trong hệ -2, chúng gài hàng ở số mũ của $-2$ (như $1, -2, 4, -8, 16$). Ký tự vẫn chỉ được phép dùng biến thể nhị phân `0` hoặc `1`.*

---

## 2. Strategy 1: Naive (Power Matching)
## *2. Chiến lược 1: Ngây thơ (Dò khớp số mũ)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to try and deduct the largest possible powers of $-2$ that fit into `N` and check variations recursively. But unlike positive bases where values strictly increase, base $-2$ oscillates wildly between positive and negative realms ($4$, $-8$, $16$, $-32$). Matching values destructively triggers a nightmare of branching.
*Tâm trí ngây thơ sẽ nặn thử một danh sách các luỹ thừa của -2, ráng đem tổng hợp và dìm N nhích dần về 0. Nhưng cay đắng thay, thay vì tăng đều, hàm lượng $-2$ giật chớp tắt qua lại Âm/Dương ($4$, $-8$, $16$, $-32, \dots$). Ráp kiểu phỏng đoán sẽ trượt vào mớ bòng bong chia nhánh thuật toán hỗn loạn!*

*(Chỉ giải pháp Tối ưu mới có thể hạ bệ được tính chất cơ số -2 này).*

---

## 3. Strategy 2: Optimal (Negative Division Rules)
## *3. Chiến lược 2: Tối ưu (Luật chia số âm)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of building powers downward, we construct digits fundamentally upwards sequentially from right to left (like standard division base 2 tracking remainders).
To convert an integer $N$ to base $B$:
- Repeatedly divide $N$ by $B$.
- Log the remainder as the digit.
- Update $N = N / B$ quotient.

*Thay vì gồng xây luỹ thừa trừ dần từ ngọn, ta tiến hóa đập đá nền móng xây dần từ phải qua trái y như Toán học Tiểu học chia đôi (lấy số dư ráp vào đuôi).*
*Để hoán đổi đổi nguyên x sang cơ số B:*
*- Chia lặp $N$ cho $B$.*
*- Nép cái phần Dư kia làm chữ đứng đuôi.*
*- Thu gọn $N$ nhường chỗ cho phần Nguyên $N / B$ mới.*

**THE KICKER (CÚ BẺ LÁI):** 
In standard programming languages like Java, `-3 / -2 = 1` with a remainder of `-1`. 
*Mấu chốt phá đảo: Trong ngôn ngữ lập trình, phép chia cho số âm làm số dư rớt về âm (VD `-3 / -2 = 1` dư `-1`).*
But in any base representation, **DIGITS CANNOT BE NEGATIVE!** They must strictly be `0` or `1`!
*Nhưng hệ Cơ số không mang phép biến đổi KÝ TỰ ÂM! Chữ số MÃI MÃI CHỈ LÀ `0` HOẶC `1`!*

If computing $N / (-2)$ leaves a negative remainder `R = -1`:
We mentally shift the division! If we subtract $1$ from the quotient, we inherently add $|B|$ (which is $2$) to the remainder.
- Math: $N = (-2) \cdot Q - 1$
- Adjusted Math: $N = (-2) \cdot (Q + 1) - 1 - (-2) = (-2) \cdot (Q + 1) + 1$
Thus, the new positive remainder successfully becomes `1`, and the new quotient cleanly becomes `Q + 1`!

*Vậy, gặp số dư âm $R = -1$ thì tính sao?*
*Ta ép cung phép toán! "Xén" 1 đơn vị từ Phần Nguyên để đắp bù "Dương khí" đùn sang phần Dư. Cụ thể: Bơm $2$ vào số dư (tức là $R = -1 + 2 = 1$), sau đó đền bù $1$ vào phần Nguyên (để đảm bảo phương trình hai vế không xê dịch).*
*Do đó: Nếu chia $N / -2$ mà số dư chọi ra số âm, ta CỘNG 1 VÀO THƯƠNG SỐ làm món nợ, lập tức SỐ DƯ trỗi dậy Dương `1` đĩnh đạc!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        
        StringBuilder b = new StringBuilder();
        while (n != 0) {
            int remainder = n % -2;
            n = n / -2;
            
            // Xử lý thần kỳ số dư âm
            if (remainder < 0) {
                remainder += 2; // Đẩy dư thành 1 (vì n%2 chỉ có thể dư 0 hoặc -1)
                n += 1; // Bù đắp lỗi thương số đẩy qua trái
            }
            
            b.append(remainder);
        }
        
        // Vì đắp từ phải sang trái, cuối cùng phải lộn ngược chuỗi lại
        return b.reverse().toString();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$. We just repeatedly divide `N` by `2`. For an integer stretching up to $10^9$, it halts confidently under physically ~32 mathematical steps. Staggeringly quick.
    *   **Độ phức tạp thời gian:** $O(\log N)$. Chúng ta liên tục xé nửa $N$. Cỡ số tỷ thì cũng lặp loanh quanh khoảng 32 vòng là cháy sạch bách thành cát bụi. Không thể bắt trúng khoảnh khắc dừng của nó.*
*   **Space Complexity:** $O(\log N)$. `StringBuilder` merely needs roughly 30 spots of text structure, equating functionally to strictly constants memory strings allocation.
    *   **Độ phức tạp không gian:** $O(\log N)$. Chuỗi `StringBuilder` ngậm 30 kí tự `0/1`, lượng lưu nhỏng bé li ti chừng 60 bytes.*

# Analysis for Numbers With Repeated Digits
# *Phân tích cho bài toán Các số có chữ số lặp lại*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given `n`, count how many positive integers up to `n` have at least one repeated digit.
*Cho `n`, đếm xem có bao nhiêu số nguyên dương nhỏ hơn hoặc bằng `n` có ít nhất một chữ số lặp lại.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Counting numbers with *repeated* digits is hard. However, it's significantly easier to count the numbers with strictly *unique* digits!
- If we can find the count of numbers with strictly unique digits `U`, then the answer is exactly `n - U`.
- *Đếm số lượng các số CÓ chữ số lặp lại là rất khó. Tuy nhiên, đếm số lượng các số KHÔNG CÓ chữ cái nào lặp lại (còn gọi là số độc nhất) thì dễ hơn rất nhiều!*
- *Nếu tính được tổng những con số có các chữ số khác nhau hoàn toàn là `U`, thì đáp án bài toán chính xác là `n - U`.*

---

## 2. Strategy 1: Naive (Iterative Check)
## *2. Chiến lược 1: Ngây thơ (Kiểm tra từng số)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to literally iterate from `1` up to `n`. For each number, we convert it to a string or parse digits to a HashSet `boolean[] seen` to check if a digit shows up more than once.
*Ý tưởng ngây thơ là lặp một vòng từ số `1` đến `n`. Với mỗi con số, ta tách từng chữ số bỏ vào một cái mảng đánh dấu `boolean[] seen`. Nếu bị trùng chữ số thì tăng biến đếm lên.*

```java
public class Solution {
    public int numDupDigitsAtMostNNaive(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (hasRepeatedDigits(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean hasRepeatedDigits(int num) {
        boolean[] seen = new boolean[10];
        while (num > 0) {
            int digit = num % 10;
            if (seen[digit]) return true;
            seen[digit] = true;
            num /= 10;
        }
        return false;
    }
}
```

- **Weakness (Điểm yếu):** We must execute the loop up to `$10^9$` times. Inside the loop, separating digits entails divisions `num / 10`. This algorithm easily touches $10^{10}$ processing cycles, blowing far past the Time Limit (TLE).
  *Vòng lặp chạy chục triệu thì được, chứ chạy lên số siêu lớn tới tỷ ($10^9$) thì chịu không nổi. Bên trong lại còn phép toán chia nguyên khá nặng `num / 10`. Tổng chu trình chục tỷ lượt tính làm treo máy tức thì (Lỗi TLE).*

---

## 3. Strategy 2: Optimal (Combinatorics / Digit DP)
## *3. Chiến lược 2: Tối ưu (Tổ hợp / Phép đếm số học cơ số)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of counting numbers one by one, we jump straight to building them using Combinations.
Suppose `n = 8765` (4 digits long).
To find unique-digit numbers <= 8765, we break the problem into two distinct groups:
1. **Numbers with strict length < 4 digits:** (e.g., length 1, 2, 3).
   Any number smaller in length is essentially smaller in value.
   - 1 digit: $9$ choices (1-9)
   - 2 digits: $9 \times 9$ choices (first digit 1-9, second digit 0-9 except first)
   - 3 digits: $9 \times 9 \times 8$ choices.
2. **Numbers with exactly 4 digits <= 8765:**
   We try to match the given `n` prefix by prefix.
   - Numbers smaller acting on the 1st digit: `1xxx` to `7xxx` (7 choices). 
     For the remaining 3 places, we pick from the 9 unused digits: $P(9, 3)$.
   - Now we "lock in" `8` as the first digit, and move to the 2nd digit (`7`).
     - Numbers like `80xx` to `86xx`, but skipping `8` since it's already used!
   - Continue locking digits left to right. If we encounter a repeated locked digit, we immediately break, as we cannot form any unique branch off an already illegal prefix!

*Thay vì ngồi đếm thủ công từng số một, ta dùng Toán Tổ Hợp để gom cụm hàng loạt chữ số. Lấy ví dụ $N = 8765$. Gồm 2 pha gom nhóm: Khẳng định những số có chiều dài nhỏ hơn 4 (1, 2, 3 chữ số) ĐỀU nhỏ hơn `n` và an toàn để áp dụng toán cấp số nhân $9 \times 9 \times 8$. Còn chuỗi 4 số thì ta dò từng cái tiền tố của $8765$, đếm gộp các cụm kiểu `1xxx`, `2xxx`, cho đến khi khóa hẳn số `8`, rồi lại quét tiền tố cụm con `81xx`, `82xx`.*

### Helper Formula: Permutations
The number of ways to pick `k` distinct digits from an available pool size `m` is the Permutation $P(m, k) = m \times (m - 1) \dots \times (m - k + 1)$.
*Toán tổ hợp: Lấy k chữ số khác nhau từ rổ cón m mống. Ký hiệu là $A_{m}^{k}$ (Permutation $P(m, k)$). Sắp xếp nhân giảm dần.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.ArrayList;

public class Solution {
    public int numDupDigitsAtMostN(int n) {
        // Chuyển n+1 thành mảng chữ số d để dễ dò chặn trên ("<" thay vì "<=")
        ArrayList<Integer> digits = new ArrayList<>();
        for (int x = n + 1; x > 0; x /= 10) {
            digits.add(0, x % 10);
        }
        
        int uniqueCount = 0;
        int len = digits.size();
        
        // Bước 1: Mảng tổ hợp các số ĐỘC NHẤT có chiều dài bé hơn (chiều dài 1 đến len-1)
        for (int i = 1; i < len; i++) {
            uniqueCount += 9 * perm(9, i - 1);
        }
        
        // Bước 2: Tổ hợp các số ĐỘC NHẤT có chiều dài đúng bằng len
        boolean[] seen = new boolean[10];
        for (int i = 0; i < len; i++) {
            int digit = digits.get(i);
            // Chọn một chữ số làm đầu từ 1(nếu i=0) hoặc 0 tới nhỏ hơn digit
            for (int j = (i == 0 ? 1 : 0); j < digit; j++) {
                if (!seen[j]) {
                    uniqueCount += perm(9 - i, len - i - 1);
                }
            }
            // Nếu phát hiện chặn trên dính số trùng -> Cắt đứt không truy vết nhánh chính
            if (seen[digit]) break;
            seen[digit] = true;
        }
        
        // Kết quả = (Tất cả N) - (Số KHÔNG trùng nào)
        return n - uniqueCount;
    }
    
    // Tính P(m, k) = m * (m-1) * ...
    private int perm(int m, int k) {
        if (k == 0) return 1;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= (m - i);
        }
        return res;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_{10} N)$. The number of digits in `n` is roughly $\sim 10$ at maximum. The outer loop runs 10 times, the inner loop runs 10 times. Total computations are on the scale of $100$ instructions, running instantaneously at literally $O(1)$ constant time scale! 
    *   **Độ phức tạp thời gian:** $O(\log_{10} N)$. Số lượng chữ số của N tỷ tối đa là dài 10 mống. Vòng lặp trùm và con gộp lại quét chừng 10x10 lần. Chớp một cái là nó xuất ngay ra đáp án, nhẹ nhàng như lông vũ! Gần như bằng thao tác độ phức tạp O(1) tĩnh.*
*   **Space Complexity:** $O(\log_{10} N)$. To store the array of digits of length $\le 10$.
    *   **Độ phức tạp không gian:** $O(\log_{10} N)$. Lưu mảng độ dài 10 chữ số cỏn con.*

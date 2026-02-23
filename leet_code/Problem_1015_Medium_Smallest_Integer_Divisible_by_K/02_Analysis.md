# Analysis for Smallest Integer Divisible by K
# *Phân tích cho bài toán Số nguyên nhỏ nhất chia hết cho K*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the length of the smallest number made entirely of `1`s (like `11`, `111`, etc.) that is perfectly divisible by $K$. If it doesn't exist, return `-1`. The generated number could easily exceed 64-bit integer limits.
*Tìm độ dài của số nhỏ nhất chỉ tạo thành từ các số `1` (giống như `11`, `111`...) chia hết cho $K$. Nếu không tồn có số nào, trả về `-1`. Con số được tạo ra có thể dễ dàng vượt quá sức chứa của bộ nhớ số nguyên 64-bit.*

---

## 2. Strategy 1: Naive (BigInteger Simulation)
## *2. Chiến lược 1: Ngây thơ (Mô phỏng bằng Số Lớn)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The most direct way is to build the actual numbers (`1`, `11`, `111`...) step by step as strings or `BigInteger` objects in Java, then check if it's divisible by $K$.
*Cách trực tiếp nhất là tự tay xây dựng đống số khủng lồ (`1`, `11`, `111`...) trên chuỗi String hoặc dùng lớp `BigInteger` của Java, rồi đem mod cho $K$ để kiểm tra chia hết.*

```java
import java.math.BigInteger;

public class Solution {
    public int smallestRepunitDivByKNaive(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        
        BigInteger num = BigInteger.ONE;
        BigInteger bigK = BigInteger.valueOf(k);
        int length = 1;
        
        while (!num.remainder(bigK).equals(BigInteger.ZERO)) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.ONE); // Thêm số 1 vào đuôi
            length++;
        }
        return length;
    }
}
```

- **Weakness (Điểm yếu):** String creation or `BigInteger` arithmetic is excruciatingly slow when numbers get intensely large. For $K = 99999$, the result is $99999$ digits long! Performing division on numbers with 100,000 digits thousands of times per second leads directly to a Memory Limit Exceeded (MLE) or Time Limit Exceeded (TLE) crash.
  *Việc dùng chuỗi hay `BigInteger` xử lý toán học là nỗi ác mộng khi chữ số lềnh bềnh to lên. Ví dụ nếu $K = 99999$, đáp án dài tới 99,999 chữ số! Việc đem con số hàng trăm ngàn ký tự đi chia lặp lại nhiều vòng sẽ làm cháy bộ nhớ đệm lập tức (MLE) hoặc rớt đài Thời gian (TLE).*

---

## 3. Strategy 2: Optimal (Modulo Arithmetic & Pigeonhole Principle)
## *3. Chiến lược 2: Tối ưu (Toán học Modulo & Nguyên lý Chuồng Bồ Câu)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

We don't need to actually store the gigantic number `N`. We strictly only care about its remainder when divided by `K`.
A mathematical rule of Modulo states: `(A * 10 + 1) % K == ((A % K) * 10 + 1) % K`.
This means we can recursively carry over the "remainder" from the previous length to compute the remainder of the current length! If the remainder hits `0`, we successfully found a length. 
- **Impossible Cases:** Any number ending in `1` can **never** be divisible by an even number (`2, 4, 6...`) or numbers ending in `5` or `0`. So if `K % 2 == 0` or `K % 5 == 0`, it's an immediate `return -1`.
- **Termination/Infinite Loop:** According to the **Pigeonhole Principle**, there are exclusively at most `K` possible remainders (`0` to `K-1`). If we generate numbers more than `K` times and still haven't found a `0` remainder, we will definitely just repeat old remainders, spinning in an endless loop forever. Thus, we only ever need to search up to `length = K`.

*Thực chất, ta không cần phải lưu cả con trâu Khổng Lồ $N$. Chúng ta chỉ quan tâm nó lúc CHIA DƯ cho $K$ được bao nhiêu.*
*Quy tắc chuẩn Modulo: `(A * 10 + 1) % K == ((A % K) * 10 + 1) % K`.*
*Điều này có nghĩa là ta lấy khúc Dư của vòng trước, nhân 10 rồi cộng 1 ở vòng này là dư sức biết đáp án của độ dài kế tiếp. Nếu mảy may Số Dư rơi về 0, báo tin thắng cuộc.*
*- **Trường hợp loại trừ:** Bất cứ số nào kết thúc đuôi `1` đều KHÔNG BAO GIỜ chia hết cho số chẵn (2,4,6...) hay số chia hết cho 5. Mới vào check `K % 2 == 0` hay `K % 5 == 0` là đá văng về -1 luôn.*
*- **Vòng lặp Vô Tận:** Dựa vào **Định lý Chuồng bồ câu (Pigeonhole)**, một phép chia dư cho $K$ chỉ có tối đa `K` đáp án có thể xảy ra (từ `0` đến `K-1`). Nghĩa là nếu ta nhân mảng dài ra hơn `K` lần mà chưa trúng số `0`, thì những con số dư gắp phía sau chắc chắn sẽ Tái Diễn (Bị Trùng), dẫn tới vòng tròn vĩnh cửu. Vậy nên ta chỉ dò an toàn `length` nhiều nhất đến `K`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int smallestRepunitDivByK(int k) {
        // Lọc triệt để con số có tận cùng không hợp logic với 1
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        
        int remainder = 0;
        
        // Chỉ chạy tối đa K bước vì Định luật bồ câu (Có K lỗ, bay K+1 con kiểu gì cũng trùng lỗ cũ)
        for (int length = 1; length <= k; length++) {
            // Cập nhật số dư: Số mới = Dư cũ * 10 + 1 
            remainder = (remainder * 10 + 1) % k;
            
            // Nếu phát hiện chia đều chẵn, quăng đáp án chiều dài
            if (remainder == 0) {
                return length;
            }
        }
        
        return -1; 
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K)$. We iterate a loop precisely at most $K$ times due to modulo remainder boundaries. With $K \le 10^5$, it's super instantaneous.
    *   **Độ phức tạp thời gian:** $O(K)$. Chạy lặp cày xới đúng $K$ lần là kịch kim do giới hạn phần dư (chỉ tầm $10^5$ phép tính), quá tốc độ.*
*   **Space Complexity:** $O(1)$. Just storing a single tiny numeric variable `remainder`. Overwhelmingly efficient memory wise.
    *   **Độ phức tạp không gian:** $O(1)$. Nhốt lại mỗi một số `remainder` tĩnh. Bóp vụn nỗi lo tràn RAM của BigInteger.*

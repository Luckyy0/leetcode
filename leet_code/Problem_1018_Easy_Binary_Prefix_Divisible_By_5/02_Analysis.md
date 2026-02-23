# Analysis for Binary Prefix Divisible By 5
# *Phân tích cho bài toán Tiền tố nhị phân chia hết cho 5*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a stream of bits (0s and 1s), we construct a binary number bit by bit. For every new bit added to the right, we must immediately check if the decimal value of the full binary sequence built so far is mathematically divisible by 5. The total length of the bit stream can reach $10^5$.
*Cho một dòng các bit (0 và 1), ta liên tiếp ráp thành số nhị phân từ trái sang phải. Cứ mỗi khi xỏ thêm 1 bit vào đuôi, ta phải kiểm tra ngay xem giá trị số thập phân của toàn bộ dãy vừa ráp có chia hết cho 5 hay không. Độ dài của mảng bit bự lên tới mức $10^5$ phần tử.*

---

## 2. Strategy 1: Naive (Accumulate the Full Number)
## *2. Chiến lược 1: Ngây thơ (Lưu trữ nhồi giá trị Toàn phần)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy physically decodes the binary array by doubling the previous value and adding the new bit (`value = value * 2 + bit`). Then we check if `value % 5 == 0`.
*Chiến lược ngây thơ đem giải mã theo công thức toán truyền thống: Lấy con số của bước trước x2 lên, rồi rớt luôn cái bit sinh sau đẻ muộn vào (`giá_trị = giá_trị * 2 + bit`). Cuối cùng xét chuẩn xem `giá_trị % 5 == 0` có đúng không.*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5Naive(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        long value = 0;
        for (int bit : nums) {
            value = (value * 2) + bit;
            if (value % 5 == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        return answer;
    }
}
```

- **Weakness (Điểm yếu):** Integer Overflow! A 64-bit `long` primitive can only hold roughly 63 bits of data. The given array `nums` can pack up to exactly $10^5$ bits! Around the 64th loop cycle, the `value` will monumentally overflow its hardware capacity and warp into catastrophic negative numbers. Using immense slow objects like `BigInteger` for $10^5$ math rounds causes severe execution delays (TLE) and devours memory.
  *Lật xe vì Tràn Số (Overflow)! Một biến `long` 64-bit to nhất của Java chỉ cưu mang được tầm 63 bit nhị phân. Mảng đề tài `nums` lại dài rùng rợn tận $10^5$ bits! Vừa bò đến vòng lặp thứ 64 là biến số kia đã vỡ tung sức chứa, lộn ngược chu kỳ thành số âm điên cuồng phá nát toán học. Nếu cố đấm ăn xôi dùng Siêu Lớp `BigInteger` để thồ hệ số $10^5$ vòng lặp thì tốc độ sẽ rùa bò hụt hơi gây TLE (Quá thời gian).*

---

## 3. Strategy 2: Optimal (Modulo Tracking)
## *3. Chiến lược 2: Tối ưu (Dấu ép Số Dư - Modulo)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

We unequivocally DO NOT CARE about the gargantuan massive binary value. We strictly only care if it divides evenly by 5!
Thanks to the robust properties of Modular Arithmetic:
`(A * 2 + B) % 5 == ((A % 5) * 2 + B) % 5`
This equation mathematically dictates that we only need to keep track of the *current remainder mod 5* instead of the real astronomical number! Since the remainder modulo $5$ can only strictly take values from `0` to `4`, we confine the accumulator memory to absolute hardware bounds safely.
*Sự thật bẻ bàng: Chúng ta HOÀN TOÀN KHÔNG CẦN QUAN TÂM cái con số nhị phân nếm đuôi 100 ngàn lần kia to tổ chảng khủng khiếp cỡ nào. Mã di truyền của ta chỉ cần 1 điều: Nó Có Đứt Đuôi Cho 5 Hay Không!*
*Dựa dẫm vào luật lệ bất biến của hệ thống Phép Modulo (Phép Dư):*
`(A * 2 + B) % 5 == ((A % 5) * 2 + B) % 5`
*Định lý trên đóng đinh một sự thật toán học: Chúng ta CHỈ CẦN THEO DÕI SỐ DƯ của vòng trước, lấy nó nhân 2 rồi cộng bit cuối là thừa tư cách biết số dư của vòng này, Không cần mang vác cái thân xác khổng lồ kia! Vì số dư của hệ 5 chỉ vỏn vẹn loanh quanh từ `0` đến `4`, biến lưu trữ của chúng ta an toàn 100%, vĩnh viễn không biết mùi Tràn Số (Overflow) là gì!*

### Algorithm Steps
### *Các bước thuật toán*

1.  Initialize `remainder = 0`. Create an `answer` boolean list.
    *   *Khởi tạo cục cưng `remainder = 0` (số dư). Một danh sách chứa phiếu bóc `answer`.*
2.  Iterate over each bit `b` in `nums`.
    *   *Sải chân lướt dọc từng bit `b`. *
3.  Update the state mathematically: `remainder = (remainder * 2 + b) % 5`.
    *   *Hô biến phép toán Modulo chắp vá: `remainder = (remainder * 2 + b) % 5`.*
4.  If the freshly updated `remainder == 0`, append `true` to the `answer` list. Otherwise, append `false`.
    *   *Báo cáo: Tái sinh số dư xong, nếu nó rụng về đúng chuẩn số `0`, thảy `true` vô thẻ thu hoạch. Lệch khỏi 0 thì thả `false`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>(nums.length);
        int remainder = 0;
        
        for (int bit : nums) {
            // Cập nhật số dư: chỉ mượn phần dư cũ để tính
            remainder = ((remainder << 1) + bit) % 5; // `<< 1` chạy siêu nhanh thay cho `* 2`
            
            // Chia hết khi phần dư rớt cạn về 0
            if (remainder == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        
        return answer;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We perfectly evaluate exactly one iteration per array bit item exactly once. The mathematical operation executes in $O(1)$ constant overhead limits utilizing bit-shifts (`<< 1`).
    *   **Độ phức tạp thời gian:** $O(N)$. Ăn trọn mảng một mạch dài không quay gót một bước nào. Những phép tinh chỉnh modulo và dịch bit (`<< 1`) chớp giật siêu thanh trong luồng hệ thống $O(1)$.*
*   **Space Complexity:** $O(N)$. Since we fundamentally MUST return a `List<Boolean>` size identical to $N$, retaining the structural answer footprint logs scaling linear memory. Pure algorithmic auxiliary space is $O(1)$.
    *   **Độ phức tạp không gian:** $O(N)$. Quy tắc bài thi ép buộc phải nhả ra một Mảng Tích Booleans dài cỡ bằng mảng chúa N, nên tốn mất chi phí rải RAM $O(N)$. Song, bộ nhớ phụ trợ làm thuật toán thì tĩnh y thinh $O(1)$.*

# Analysis for Single Number II
# *Phân tích cho bài toán Số Duy Nhất II*

## 1. Problem Essence & Evolution
## *1. Bản Chất Vấn Đề & Sự Phát Triển*

### Transition from Single Number I
### *Sự chuyển tiếp từ Số Duy Nhất I*
*   In the first version, elements appeared twice. We used XOR because $X \oplus X = 0$.
    *Trong phiên bản đầu tiên, các phần tử xuất hiện hai lần. Chúng ta đã sử dụng XOR vì $X \oplus X = 0$.*
*   Now, elements appear **three times**. XOR doesn't help because $X \oplus X \oplus X = X$. It doesn't cancel out.
    *Bây giờ, các phần tử xuất hiện **ba lần**. XOR không giúp ích được gì vì $X \oplus X \oplus X = X$. Nó không triệt tiêu lẫn nhau.*
*   The constraint remains strict: $O(N)$ time and $O(1)$ space.
    *Ràng buộc vẫn nghiêm ngặt: thời gian $O(N)$ và không gian $O(1)$.*

---

## 2. Approach 1: Bit Manipulation (Summing Bits)
## *2. Hướng Tiếp Cận 1: Thao Tác Bit (Tổng hợp Bit)*

This is the most intuitive $O(1)$ space solution.
*Đây là giải pháp không gian $O(1)$ trực quan nhất.*

### Logic
### *Logic*
1.  An integer in Java (and most systems) has 32 bits.
    *Một số nguyên trong Java (và hầu hết các hệ thống) có 32 bit.*
2.  For each bit position $i$ (from 0 to 31):
    -   Count how many numbers in the array have their $i$-th bit set to 1.
        *Đếm xem có bao nhiêu số trong mảng có bit thứ $i$ được đặt thành 1.*
3.  Because every number (except the single one) appears 3 times, those numbers will contribute a multiple of 3 to the total count of that bit.
    *Bởi vì mỗi số (ngoại trừ số duy nhất) đều xuất hiện 3 lần, các số đó sẽ đóng góp một bội số của 3 vào tổng số lượng bit đó.*
4.  If the total count of the $i$-th bit is not divisible by 3 (specifically, if `count % 3 == 1`), it must be because the **Single Number** has its $i$-th bit set.
    *Nếu tổng số lượng của bit thứ $i$ không chia hết cho 3 (cụ thể là nếu `count % 3 == 1`), thì chắc chắn là do **Số Duy Nhất** có bit thứ $i$ được đặt.*
5.  Construct the single number by setting its bits based on this observation.
    *Xây dựng số duy nhất bằng cách đặt các bit của nó dựa trên quan sát này.*

---

## 3. Approach 2: State Tracking (Logic Gates)
## *3. Hướng Tiếp Cận 2: Theo Dõi Trạng Thái (Cổng Logic)*

This is a more advanced technique using two variables (`ones` and `twos`) to keep track of bits that have appeared once or twice.
*Đây là một kỹ thuật nâng cao hơn sử dụng hai biến (`ones` và `twos`) để theo dõi các bit đã xuất hiện một hoặc hai lần.*

-   `ones`: Stores bits that appeared $3n + 1$ times.
-   `twos`: Stores bits that appeared $3n + 2$ times.
-   When a bit appears for the third time, it should be cleared from both.

While harder to grasp, it is faster as it only requires one pass without nested loops (though Approach 1 is also one pass with a fixed inner loop of 32).
*Dù khó nắm bắt hơn, nó nhanh hơn vì chỉ yêu cầu một lượt duyệt mà không có vòng lặp lồng nhau (mặc dù Hướng tiếp cận 1 cũng là một lượt với vòng lặp bên trong cố định là 32).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(32 \cdot N) = O(N)$. We iterate over the 32 bits, and for each bit, we traverse the array.
    *Độ phức tạp thời gian: $O(32 \cdot N) = O(N)$. Chúng ta lặp qua 32 bit và với mỗi bit, chúng ta duyệt qua mảng.*
*   **Space Complexity:** $O(1)$. We only use a few integer variables (`result`, `count`, etc.) regardless of the input size.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một vài biến số nguyên bất kể kích thước đầu vào.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [2, 2, 3, 2]`
(Binary: 2 is `10`, 3 is `11`)

-   **Bit 0:** 2 has `0`, 2 has `0`, 3 has `1`, 2 has `0`.
    -   `Count = 1`. `1 % 3 = 1`. Result Bit 0 = 1.
-   **Bit 1:** 2 has `1`, 2 has `1`, 3 has `1`, 2 has `1`.
    -   `Count = 4`. `4 % 3 = 1`. Result Bit 1 = 1.
-   **Other Bits (2 to 31):** All counts are 0. `0 % 3 = 0`. Result Bits = 0.

**Final Result Binary:** `...00011` = 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The "Summing Bits" approach is highly recommended for its clarity and generalizability. It can be easily adapted if the problem changes to "elements appear 5 times" (just use `% 5`). The "State Tracking" approach, while clever, is harder to explain in a high-pressure interview context.
*Cách tiếp cận "Tổng hợp Bit" được khuyến nghị mạnh mẽ vì sự rõ ràng và tính khái quát của nó. Nó có thể dễ dàng được điều chỉnh nếu bài toán thay đổi thành "các phần tử xuất hiện 5 lần" (chỉ cần sử dụng `% 5`). Cách tiếp cận "Theo Dõi Trạng Thái", dù thông minh, lại khó giải thích hơn trong bối cảnh phỏng vấn áp lực cao.*
---
*Khi sự trùng lặp diễn ra theo quy luật của số ba, chìa khóa nằm ở việc tìm ra phần dư lẻ loi trong từng phân tử nhỏ nhất.*
When duplication follows the rule of three, the key lies in finding the lonely remainder in every smallest element.

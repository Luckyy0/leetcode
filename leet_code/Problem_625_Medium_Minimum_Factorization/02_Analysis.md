# Analysis for Minimum Factorization
# *Phân tích cho bài toán Phân tích nhân tử Tối thiểu*

## 1. Problem Essence & Greedy Digit Selection
## *1. Bản chất vấn đề & Lựa chọn Chữ số Tham lam*

### The Challenge
### *Thách thức*
We need to find a number whose digits multiply to $a$. To make this number as small as possible, we have two goals:
*Chúng ta cần tìm một số mà tích các chữ số của nó bằng $a$. Để làm cho số này nhỏ nhất có thể, chúng ta có hai mục tiêu:*
1.  **Minimize the number of digits:** This means choosing the largest possible single-digit factors first.
    * **Tối thiểu hóa số lượng chữ số:** Điều này có nghĩa là chọn các nhân tử có một chữ số lớn nhất có thể trước.*
2.  **Order the digits:** Smaller digits should be at the higher place values (the front).
    * **Sắp xếp các chữ số:** Các chữ số nhỏ hơn nên ở các hàng giá trị cao hơn (phía trước).*

---

## 2. Strategy: Prime Factorization (9 down to 2)
## *2. Chiến lược: Phân tích nhân tử (từ 9 xuống 2)*

The only digits we can use are from 2 to 9. We use a greedy strategy by trying to divide $a$ by the largest possible digit first (9, then 8, ..., then 2).
*Các chữ số duy nhất chúng ta có thể sử dụng là từ 2 đến 9. Chúng ta sử dụng chiến lược tham lam bằng cách cố gắng chia $a$ cho chữ số lớn nhất có thể trước (9, sau đó là 8, ..., rồi đến 2).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Special Case:** If `a < 10`, then `a` itself is the answer (unless it's 1, then the logic still holds).
    * **Trường hợp Đặc biệt:** Nếu `a < 10`, thì chính `a` là câu trả lời.*

2.  **Reverse Division:** Iterate from $i = 9$ down to $2$.
    * **Chia Ngược:** Duyệt từ $i = 9$ xuống đến $2$.*
    - While `a % i == 0`:
        - Save the digit `i`.
        - `a = a / i`.

3.  **Check Remainder:** After the loop, if `a > 1`, it means `a` has a prime factor greater than 7 (like 11, 13, etc.), which cannot be represented by a single digit. Return 0.
    * **Kiểm tra Số dư:** Sau vòng lặp, nếu `a > 1`, điều đó có nghĩa là `a` có nhân tử nguyên tố lớn hơn 7, không thể biểu diễn bằng một chữ số duy nhất. Trả về 0.*

4.  **Construct Result:** Sort the collected digits in ascending order to form the smallest number.
    * **Xây dựng Kết quả:** Sắp xếp các chữ số đã thu thập theo thứ tự tăng dần để tạo thành số nhỏ nhất.*

5.  **Overflow Check:** Ensure the result fits in a 32-bit signed integer (`2^31 - 1`).
    * **Kiểm tra Tràn số:** Đảm bảo kết quả vừa với số nguyên có dấu 32-bit.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Greedy Correctness:** Dividing by 9 instead of 3 twice reduces the total digit count (one '9' vs two '3's). Lower digit count is the most powerful way to make a number smaller.
    * **Tính Tham lam Chính xác:** Chia cho 9 thay vì chia cho 3 hai lần làm giảm tổng số lượng chữ số (một số '9' so với hai số '3'). Số lượng chữ số ít hơn là cách mạnh mẽ nhất để làm cho một số nhỏ hơn.*
*   **Logical Chain:** By collecting digits from 9 down to 2 and then appending them to a result (starting from units), we naturally get the largest digits at the end and smallest at the beginning.
    * **Chuỗi Logic:** Bằng cách thu thập các chữ số từ 9 xuống 2 rồi thêm chúng vào kết quả (bắt đầu từ hàng đơn vị), chúng ta tự nhiên có được các chữ số lớn nhất ở cuối và nhỏ nhất ở đầu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_2 a)$. In each step, we divide $a$ by at least 2. The number of digits in the result is also proportional to this.
    * **Độ phức tạp thời gian:** $O(\log_2 a)$. Trong mỗi bước, chúng ta chia $a$ cho ít nhất 2. Số lượng chữ số trong kết quả cũng tỷ lệ thuận với điều này.*
*   **Space Complexity:** $O(1)$ if we use a `long` to build the number or $O(L)$ to store the digits before sorting.
    * **Độ phức tạp không gian:** $O(1)$ nếu sử dụng kiểu `long` để tạo số hoặc $O(L)$ để lưu trữ các chữ số trước khi sắp xếp.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** a = 48
1. 48 % 9 != 0.
2. 48 % 8 == 0. Digit: [8]. a = 6.
3. 6 % 8, 7 != 0.
4. 6 % 6 == 0. Digit: [8, 6]. a = 1.
5. Exit loop. a=1, Success.
6. Digits: [6, 8] (assembled as 68).
**Result:** 68.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "smallest number with property X" problems, always prioritize reducing the digit count first (by using larger factors), then arrange those factors in increasing order to put smaller digits in higher positional values.
*Đối với các bài toán "số nhỏ nhất có tính chất X", hãy luôn ưu tiên giảm số lượng chữ số trước (bằng cách sử dụng các nhân tử lớn hơn), sau đó sắp xếp các nhân tử đó theo thứ tự tăng dần để đưa các chữ số nhỏ hơn vào các hàng giá trị cao hơn.*
---
*Sự tinh gọn (Minimization) bắt đầu từ việc tối giản các thành phần. Để tạo ra một con số nhỏ nhất từ một tích lớn (Multiplication), ta cần tận dụng những nhân tử mạnh mẽ nhất (Digits 9-2) để rút ngắn độ dài. Dữ liệu dạy ta rằng sự trật tự (Sorting) là yếu tố quyết định giá trị, biến những mảnh vỡ thành một cấu trúc hoàn chỉnh và hiệu quả.*
Minimalization (Minimization) starts with the reduction of components. To create the smallest number from a large product (Multiplication), we need to use the most powerful factors (Digits 9-2) to shorten the length. Data teaches us that order (Sorting) is the key to value, turning fragments into a complete and efficient structure.

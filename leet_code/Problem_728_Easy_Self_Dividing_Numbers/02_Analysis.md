# Analysis for Self Dividing Numbers
# *Phân tích cho bài toán Số tự Chia hết*

## 1. Problem Essence & Digit Verification
## *1. Bản chất vấn đề & Xác thực Chữ số*

### The Challenge
### *Thách thức*
We need to check every number in a given range to see if it satisfies two conditions:
1. It does not contain the digit `0`.
2. It is divisible by every digit it contains.
*Chúng ta cần kiểm tra mọi số trong một khoảng cho trước để xem nó có thỏa mãn hai điều kiện: (1) Không chứa chữ số 0, và (2) Chia hết cho mọi chữ số của chính nó.*

---

## 2. Strategy: Iteration and Modular Arithmetic
## *2. Chiến lược: Vòng lặp và Số học Mô-đun*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate through Range:** Loop from `left` up to `right`.
    * **Duyệt qua Khoảng:** Chạy vòng lặp từ `left` đến `right`.*

2.  **Verify Self-Divisible:** For each number $N$:
    - Keep a copy of $N$.
    - Use a loop with `% 10` to extract the last digit `d` and `/ 10` to reduce the number.
    - **Check Digit `d`:**
        - If `d == 0`, immediately fail (Self-dividing numbers can't have 0).
        - If `N % d != 0`, fail.
    - If you finish checking all digits without failing, the number is self-dividing.
    * **Xác thực Tự chia hết:** Với mỗi số $N$: Trích xuất từng chữ số bằng phép chia lấy dư cho 10. Nếu gặp số 0 hoặc $N$ không chia hết cho chữ số đó, ta loại bỏ số này. Nếu vượt qua mọi chữ số, số đó là hợp lệ.*

3.  **Collect Results:** Add all valid numbers to a result list.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot D)$, where $N$ is the number of elements in the range (`right - left + 1`) and $D$ is the maximum number of digits (here, $D \le 5$ as $right \le 10^4$).
    * **Độ phức tạp thời gian:** $O(N \cdot D)$.*
*   **Space Complexity:** $O(N)$ for the result list, but $O(1)$ auxiliary space.
    * **Độ phức tạp không gian:** $O(1)$ không gian bổ trợ.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

This problem is a classic example of digit manipulation. Using modular arithmetic (`% 10` and `/ 10`) is generally faster and more memory-efficient than converting the number to a string and parsing characters.
*Bài toán này là ví dụ điển hình về xử lý chữ số. Sử dụng toán học mô-đun (`% 10` và `/ 10`) thường nhanh hơn và tiết kiệm bộ nhớ hơn so với việc chuyển số thành chuỗi rồi phân tích ký tự.*
---
*Sự hòa hợp (Divisibility) trong bản thân một con số là khi mỗi thành phần tạo nên nó (Digits) đều là ước số của cái toàn thể. Trong thế giới của các số học, sự tự chia hết (Self-dividing) thể hiện một cấu trúc hoàn chỉnh và thống nhất. Dữ liệu dạy ta rằng bằng cách phân rã một thực thể thành những phần nhỏ nhất (Digit extraction) và kiểm tra sự tương thích của chúng (Modulo check), ta có thể nhận diện được những sự kết hợp hài hòa nhất trong vũ trụ số.*
Harmony (Divisibility) within a number is when each component that makes it up (Digits) is a divisor of the whole. In the world of arithmetic, self-divisibility (Self-dividing) represents a complete and unified structure. Data teaches us that by decomposing an entity into its smallest parts (Digit extraction) and testing their compatibility (Modulo check), we can identify the most harmonious combinations in the digital universe.

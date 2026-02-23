# Analysis for Maximum Swap
# *Phân tích cho bài toán Hoán đổi Tối đa*

## 1. Problem Essence & Greedy Digit Placement
## *1. Bản chất vấn đề & Đặt chữ số Tham lam*

### The Challenge
### *Thách thức*
To maximize a number by swapping two digits, we want the largest possible digit to appear as far to the left as possible. Conversely, the smaller digit that gets replaced should also be as far to the left as possible (to maximize the net gain).
*Để tối đa hóa một con số bằng cách hoán đổi hai chữ số, chúng ta muốn chữ số lớn nhất có thể xuất hiện càng xa về bên trái càng tốt. Ngược lại, chữ số nhỏ hơn bị thay thế cũng nên nằm càng xa về bên trái càng tốt.*

---

## 2. Strategy: Last Position Mapping + Greedy Scan
## *2. Chiến lược: Ánh xạ Vị trí Cuối + Quét Tham lam*

We can achieve this in linear time by recording the latest positions of all digits.
*Chúng ta có thể đạt được điều này trong thời gian tuyến tính bằng cách ghi lại vị trí xuất hiện cuối cùng của tất cả các chữ số.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Preprocessing:** Convert `num` to a character array. Create an array `last[10]` where `last[d]` stores the highest index where digit `d` appeared.
    * **Tiền xử lý:** Chuyển `num` thành mảng ký tự. Tạo mảng `last[10]` lưu vị trí cuối cùng của mỗi chữ số từ 0-9.*

2.  **Greedy Scan (Left to Right):** Iterate through the digits from the beginning (most significant digit).
    * **Quét Tham lam:** Duyệt qua các chữ số từ trái sang phải.*
    - For the current digit at index `i` (let's say it's `d`):
        - Check if there exists any larger digit $x \in [9, d+1]$ that appears *after* index `i`.
        - We check from 9 down to $d+1$ to ensure we find the *absolute largest* digit to swap with.
        - If such a digit $x$ exists (where `last[x] > i`):
            - Swap `char[i]` and `char[last[x]]`.
            - Return the resulting number immediately (since we can only swap at most once).

3.  **Default:** If no such swap is found, return the original number.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Choice of Swap Partner:** Why pick the *last* occurrence of the larger digit? Because moving a large digit to the front is good, but moving the small digit that was originally at the front as far back as possible is even better (though in this case, the front-most index $i$ is fixed, picking the furthest $last[x]$ doesn't change $i$'s value, but it ensures we don't prematurely swap a potential candidate for a better future swap). Actually, picking the *last* occurrence is crucial if there are multiple same-digit candidates to maximize the value.
    * **Lựa chọn đối tác hoán đổi:** Việc chọn vị trí cuối cùng (`last[x]`) đảm bảo ta tận dụng tối đa giá trị của con số.*
*   **Linear Efficiency:** Instead of $O(N^2)$ for all possible pairs, we use $O(10 \times N) = O(N)$.
    * **Hiệu suất tuyến tính:** $O(N)$ thay vì $O(N^2)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of digits. We scan the digits a few times.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the character array of the number.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** 2736
1. `digits = [2, 7, 3, 6]`.
2. `last = {2:0, 7:1, 3:2, 6:3}` (others -1).
3. `i = 0` (digit 2):
   - Check digits 9, 8: not present.
   - Check digit 7: `last[7] = 1`. 1 > 0.
   - Swap `digits[0]` and `digits[1]`.
4. `digits` becomes `[7, 2, 3, 6]`.
**Result:** 7236.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In digit manipulation problems, "pre-calculating" the positions of digits 0-9 is a standard optimization. It allows you to transform a global "find the best" search into a sequence of local queries against a constant-sized frequency/position map.
*Trong các bài toán xử lý chữ số, việc tính toán trước vị trí của các chữ số 0-9 là một sự tối ưu hóa tiêu chuẩn.*
---
*Cơ hội quý giá (Swap) chỉ đến một lần. Trong dòng chảy của các con số, để đạt được đỉnh cao (Maximum), ta phải biết hy sinh sự ổn định ở hàng cao nhất (Leftmost) để đổi lấy một giá trị tiềm năng to lớn hơn từ phía sau (Largest digit). Dữ liệu dạy ta rằng bằng cách quan sát toàn cảnh (Last positions) và nắm bắt thời cơ sớm nhất (First swap point), ta có thể xoay chuyển trật tự để đạt được sức mạnh tối đa.*
Valuable opportunities (Swap) only come once. In the flow of numbers, to reach the peak (Maximum), we must know how to sacrifice stability at the highest level (Leftmost) in exchange for a larger potential value from behind (Largest digit). Data teaches us that by observing the whole picture (Last positions) and seizing the earliest opportunity (First swap point), we can change the order to achieve maximum power.

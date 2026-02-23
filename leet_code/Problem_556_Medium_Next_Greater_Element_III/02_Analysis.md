# Analysis for Next Greater Element III
# *Phân tích cho bài toán Phần tử Lớn hơn Tiếp theo III*

## 1. Problem Essence & Lexicographical Permutation
## *1. Bản chất vấn đề & Hoán vị Thứ tự từ điển*

### The Challenge
### *Thách thức*
Given a number $n$, we want to rearrange its digits to form the smallest possible number that is strictly greater than $n$.
*Cho một số $n$, chúng ta muốn sắp xếp lại các chữ số của nó để tạo thành số nhỏ nhất có thể mà lớn hơn $n$ một cách nghiêm ngặt.*

This is equivalent to finding the "Next Permutation" of the sequence of digits in lexicographical order.
*Điều này tương đương với việc tìm "Hoán vị tiếp theo" của chuỗi các chữ số theo thứ tự từ điển.*

We also need to ensure the result fits within a 32-bit signed integer, returning -1 if it overflows.
*Chúng ta cũng cần đảm bảo kết quả nằm trong giới hạn số nguyên có dấu 32 bit, trả về -1 nếu bị tràn số.*

---

## 2. Strategy: The 4-Step Next Permutation Algorithm
## *2. Chiến lược: Thuật toán Hoán vị Tiếp theo 4 bước*

The algorithm works by identifying the rightmost point where the ascending order (from right to left) is broken.
*Thuật toán hoạt động bằng cách xác định điểm xa nhất bên phải nơi trật tự tăng dần (từ phải sang trái) bị phá vỡ.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Identify the Pivot ($i$):** Scan from right to left to find the first digit that is smaller than its right neighbor. Let this index be $i$.
    * **Xác định điểm xoay ($i$):** Quét từ phải sang trái để tìm chữ số đầu tiên nhỏ hơn chữ số láng giềng bên phải của nó. Gọi chỉ số này là $i$.*
    - If no such $i$ exists (e.g., 54321), then the number is already the largest possible. Return -1.
    - *Nếu không tồn tại $i$ như vậy (ví dụ: 54321), thì số đó vốn đã là số lớn nhất có thể. Trả về -1.*

2.  **Find the Successor ($j$):** Scan from right to left to find the smallest digit that is larger than `digits[i]`. Let this index be $j$.
    * **Tìm phần tử kế nghiệp ($j$):** Quét từ phải sang trái để tìm chữ số nhỏ nhất mà lớn hơn `digits[i]`. Gọi chỉ số này là $j$.*
    - Since everything to the right of $i$ is in descending order, the first digit we find from the right that is $> digits[i]$ will be the one.
    - *Vì mọi thứ bên phải $i$ đều theo thứ tự giảm dần, chữ số đầu tiên chúng ta tìm thấy từ bên phải mà $> digits[i]$ sẽ là chữ số đó.*

3.  **Swap:** Swap `digits[i]` and `digits[j]`. This increases the number locally at the highest possible position for a minimal change.
    * **Hoán đổi:** Hoán đổi `digits[i]` và `digits[j]`. Việc này làm tăng số lượng tại vị trí cao nhất có thể cho một sự thay đổi tối thiểu.*

4.  **Reverse the Suffix:** Reverse all digits to the right of index $i$ (from $i+1$ to the end).
    * **Đảo ngược phần hậu tố:** Đảo ngược tất cả các chữ số bên phải chỉ số $i$ (từ $i+1$ đến hết).*
    - This suffix was in descending order; reversing it makes it ascending (the smallest possible order).
    - *Phần hậu tố này vốn theo thứ tự giảm dần; việc đảo ngược nó làm cho nó trở thành tăng dần (thứ tự nhỏ nhất có thể).*

---

## 3. Structural Advantages & Overflow Handling
## *3. Ưu điểm Cấu trúc & Xử lý Tràn số*

*   **Optimal Search:** The algorithm only scans the digits a few times, making it extremely fast.
    * **Tìm kiếm tối ưu:** Thuật toán chỉ quét các chữ số một vài lần, giúp nó hoạt động cực kỳ nhanh.*
*   **Safety Check:** We use `Long.parseLong()` to convert the resulting digit array back into a number. We then compare this with `Integer.MAX_VALUE`.
    * **Kiểm tra an toàn:** Chúng ta sử dụng `Long.parseLong()` để chuyển mảng chữ số kết quả trở lại thành một con số. Sau đó, chúng ta so sánh nó với `Integer.MAX_VALUE`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(D)$, where $D$ is the number of digits. Since $D \le 10$ for a 32-bit integer, this is effectively $O(1)$.
    * **Độ phức tạp thời gian:** $O(D)$, trong đó $D$ là số chữ số. Vì $D \le 10$ đối với số nguyên 32 bit, điều này thực chất là $O(1)$.*
*   **Space Complexity:** $O(D)$ to store the digits in an array.
    * **Độ phức tạp không gian:** $O(D)$ để lưu trữ các chữ số trong một mảng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `2302431`
1. **Find Pivot:** Scan right to left: 1 < 3, 3 < 4, 4 > 2. Break at index 3 (`digits[3]=2`). So **$i=3$**.
2. **Find Successor:** Scan right to left for something > 2: 1 < 2, 3 > 2. Found it at index 5 (`digits[5]=3`). So **$j=5$**.
3. **Swap:** `2303421`.
4. **Reverse Suffix** (from index 4 to end): Reverse `421` -> `124`.
5. **Final Result:** `2303124`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Next Permutation is the definitive algorithm for any problem involving finding the "next" state in a lexicographical sequence.
*Hoán vị Tiếp theo là thuật toán dứt khoát cho bất kỳ bài toán nào liên quan đến việc tìm trạng thái "tiếp theo" trong một chuỗi thứ tự từ điển.*
---
*Thứ tự (Order) là gốc rễ của giá trị. Chỉ cần thay đổi vị trí của những thành phần vốn có (Digits), ta có thể tạo ra một thực thể mới lớn mạnh hơn. Hãy tìm ra điểm gãy (Pivot) nơi trật tự bị đảo lộn, và tái cấu trúc nó để đạt được bước tiến nhỏ nhất (Smallest greater) nhưng ý nghĩa nhất.*
Order (Order) is the root of value. Just by changing the position of the existing components (Digits), we can create a new entity that is stronger. Find the breaking point (Pivot) where order is reversed, and restructure it to achieve the smallest but most meaningful step forward (Smallest greater).

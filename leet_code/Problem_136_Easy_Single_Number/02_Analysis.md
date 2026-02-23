# Analysis for Single Number
# *Phân tích cho bài toán Số Duy Nhất*

## 1. Problem Essence & Constraints
## *1. Bản Chất Vấn Đề & Ràng Buộc*

### The Core Challenge
### *Thử Thách Cốt Lõi*
*   We are given an array where every number appears twice, except for one number that appears only once.
    *Chúng ta được cung cấp một mảng trong đó mọi số đều xuất hiện hai lần, ngoại trừ một số chỉ xuất hiện một lần.*
*   The primary constraint is **O(N) time** and **O(1) space**.
    *Ràng buộc chính là **thời gian O(N)** và **không gian O(1)**.*

### Common (But Suboptimal) Approaches
### *Các Cách Tiếp Cận Phổ Biến (Nhưng Không Tối Ưu)*
1.  **Sorting:** Sorting the array takes $O(N \log N)$ time. After sorting, we can check neighbors to find the unique element. This violates the linear time requirement.
    *Sắp xếp: Sắp xếp mảng mất thời gian $O(N \log N)$. Sau đó có thể kiểm tra các phần tử liền kề. Điều này vi phạm yêu cầu thời gian tuyến tính.*
2.  **HashSet/Frequency Map:** Storing frequencies in a `HashMap` or `HashSet` takes $O(N)$ time but requires $O(N)$ space. This violates the constant space requirement.
    *HashSet/Bản đồ Tần suất: Lưu trữ tần suất trong `HashMap` hoặc `HashSet` mất thời gian $O(N)$ nhưng yêu cầu không gian $O(N)$. Điều này vi phạm yêu cầu không gian hằng số.*

---

## 2. Approach: Bit Manipulation (XOR)
## *2. Hướng Tiếp Cận: Thao Tác Bit (XOR)*

To solve this within the strict constraints, we leverage the elegant properties of the **Bitwise XOR** operator (`^`).
*Để giải quyết bài toán này trong các ràng buộc nghiêm ngặt, chúng ta tận dụng các đặc tính thanh lịch của toán tử **Bitwise XOR** (`^`).*

### Mathematical Properties of XOR
### *Đặc Tính Toán Học của XOR*
1.  **Commutativity:** $a \oplus b = b \oplus a$.
    *Tính giao hoán: $a \oplus b = b \oplus a$.*
2.  **Associativity:** $a \oplus (b \oplus c) = (a \oplus b) \oplus c$.
    *Tính kết hợp: $a \oplus (b \oplus c) = (a \oplus b) \oplus c$.*
3.  **Identity Element:** $a \oplus 0 = a$.
    *Phần tử đơn vị: $a \oplus 0 = a$.*
4.  **Self-Inverse:** $a \oplus a = 0$.
    *Tự nghịch đảo: $a \oplus a = 0$.*

### Logic
### *Logic*
If we XOR all elements in the array together:
-   Because of commutativity and associativity, we can rearrange the order to group identical numbers together.
-   Any pair of identical numbers will result in 0 ($X \oplus X = 0$).
-   Eventually, we will have $0 \oplus 0 \oplus ... \oplus \text{Single Number}$.
-   Since $0 \oplus \text{Anything} = \text{Anything}$, the final result will be the single number.
*Nếu chúng ta XOR tất cả các phần tử trong mảng lại với nhau: Nhờ tính giao hoán và kết hợp, chúng ta có thể sắp xếp lại thứ tự để nhóm các số giống nhau lại. Bất kỳ cặp số giống nhau nào cũng sẽ cho kết quả là 0 ($X \oplus X = 0$). Cuối cùng, chúng ta sẽ có $0 \oplus 0 \oplus ... \oplus \text{Số Duy Nhất}$. Vì $0 \oplus \text{Bất_kỳ_số_nào} = \text{Bất_kỳ_số_nào}$, kết quả cuối cùng sẽ là số duy nhất cần tìm.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We traverse the array exactly once to XOR all elements.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt qua mảng đúng một lần để XOR tất cả các phần tử.*
*   **Space Complexity:** $O(1)$. We only use a single integer variable to store the running XOR result.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một biến số nguyên duy nhất để lưu trữ kết quả XOR đang chạy.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Input:** `nums = [4, 1, 2, 1, 2]`

1.  `Result = 0`
2.  `Result ^= 4` -> `4`
3.  `Result ^= 1` -> `4 ^ 1` (Binary: `100 ^ 001 = 101` = 5)
4.  `Result ^= 2` -> `4 ^ 1 ^ 2` (Binary: `101 ^ 010 = 111` = 7)
5.  `Result ^= 1` -> `4 ^ 2 ^ (1 ^ 1)` -> `4 ^ 2 ^ 0` -> `4 ^ 2` (Binary: `100 ^ 010 = 110` = 6)
    *Wait, the order doesn't matter:*
    `(1 ^ 1) ^ (2 ^ 2) ^ 4` = `0 ^ 0 ^ 4` = `4`.

**Final Result:** 4.

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

Bit manipulation is the most professional and efficient way to handle "Single Number" problems. It demonstrates a deep understanding of low-level computer arithmetic. This pattern is often the "Gold Standard" in technical interviews for tasks requiring minimal memory footprint.
*Thao tác bit là cách chuyên nghiệp và hiệu quả nhất để xử lý các bài toán "Số Duy Nhất". Nó thể hiện sự hiểu biết sâu sắc về số học máy tính cấp thấp. Mô hình này thường là "Tiêu chuẩn Vàng" trong các cuộc phỏng vấn kỹ thuật cho các nhiệm vụ yêu cầu tối thiểu dấu vết bộ nhớ.*
---
*Đôi khi cách để tìm ra kẻ lạc lõng nhất chính là để những kẻ giống nhau tự triệt tiêu lẫn nhau.*
Sometimes the way to find the odd one out is to let identical ones cancel each other out.

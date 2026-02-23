# Analysis for Can Place Flowers
# *Phân tích cho bài toán Có thể Trồng Hoa không*

## 1. Problem Essence & Local Constraints
## *1. Bản chất vấn đề & Các Ràng buộc Cục bộ*

### The Challenge
### *Thách thức*
We need to determine if $n$ flowers can be placed in a grid where no two flowers can be adjacent (`101` is okay, `11` is not).
*Chúng ta cần xác định liệu có thể đặt $n$ bông hoa vào một mặt lưới mà không có hai bông hoa nào được liền kề nhau (`101` là ổn, `11` là không).*

The rule is local: a cell `i` can accept a flower if `flowerbed[i] == 0` and both `flowerbed[i-1]` and `flowerbed[i+1]` are also `0` (or are outside the bounds of the array).
*Quy tắc này mang tính cục bộ: một ô `i` có thể nhận một bông hoa nếu `flowerbed[i] == 0` và cả `flowerbed[i-1]` lẫn `flowerbed[i+1]` đều bằng `0` (hoặc nằm ngoài phạm vi của mảng).*

---

## 2. Strategy: Greedy Linear Scan
## *2. Chiến lược: Quét Tuyến tính Tham lam*

Taking a greedy approach—planting a flower as soon as a valid spot is found—is optimal.
*Việc thực hiện phương pháp tham lam—trồng một bông hoa ngay khi tìm thấy một vị trí hợp lệ—là tối ưu.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate:** Loop through the `flowerbed` array from left to right.
    * **Duyệt:** Quét qua mảng `flowerbed` từ trái sang phải.*

2.  **Check Condition:** For each index `i`:
    * **Kiểm tra Điều kiện:** Đối với mỗi chỉ số `i`:*
    - Is `flowerbed[i]` empty (`0`)?
    - Is the left neighbor empty or non-existent? (`i == 0 || flowerbed[i-1] == 0`)
    - Is the right neighbor empty or non-existent? (`i == length - 1 || flowerbed[i+1] == 0`)
    - *Ô `i` có trống không? Người hàng xóm bên trái có trống hoặc không tồn tại không? Người hàng xóm bên phải có trống hoặc không tồn tại không?*

3.  **Plant:** If all conditions are met:
    * **Trồng:** Nếu tất cả các điều kiện được đáp ứng:*
    - "Plant" the flower: `flowerbed[i] = 1`.
    - Decrement `n`.
    - * "Trồng" hoa: `flowerbed[i] = 1`. Giảm `n`.*

4.  **Early Exit:** If `n` reaches `0` at any point, return `true`.
    * **Thoát sớm:** Nếu `n` đạt tới `0` tại bất kỳ thời điểm nào, trả về `true`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Boundary Handling:** By using logical OR short-circuiting (e.g., `i == 0 || flowerbed[i-1] == 0`), we handle the edges of the flowerbed gracefully without index-out-of-bounds errors.
    * **Xử lý Biên:** Bằng cách sử dụng các toán tử logic (ví dụ: `i == 0 || flowerbed[i-1] == 0`), chúng ta xử lý các cạnh của luống hoa một cách mượt mà mà không gặp lỗi vượt quá chỉ số mảng.*
*   **Optimal Substructure:** A greedy choice doesn't prevent a better global solution because each plant only affects its immediate neighbors. Planting as early as possible is always safe.
    * **Cấu trúc con tối ưu:** Một lựa chọn tham lam không ngăn cản một giải pháp toàn cục tốt hơn vì mỗi lần trồng cây chỉ ảnh hưởng đến hàng xóm trực tiếp của nó. Trồng càng sớm càng tốt luôn là cách an toàn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the flowerbed. we visit each plot once.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là độ dài của luống hoa. Chúng ta ghé thăm mỗi ô một lần.*
*   **Space Complexity:** $O(1)$. We only use a few integer variables. (Strictly speaking, $O(1)$ if we modify the input array, or $O(N)$ if we want to preserve the input).
    * **Độ phức tạp không gian:** $O(1)$. Chúng ta chỉ sử dụng một vài biến số nguyên.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `[1,0,0,0,1]`, $n=1$
- Index 0: `1`. Skip.
- Index 1: `0`. Left is `1`. Skip.
- Index 2: `0`. Left is `0`, Right is `0`. **Plant!** Array: `[1,0,1,0,1]`. $n=0$.
- Return `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For 1D configuration problems with local constraints, a greedy linear sweep is usually the most efficient approach. Always remember to check boundary conditions (start and end of the array) carefully.
*Đối với các bài toán cấu hình 1D với các ràng buộc cục bộ, một phép quét tuyến tính tham lam thường là cách tiếp cận hiệu quả nhất. Luôn nhớ kiểm tra kỹ các điều kiện biên (đầu và cuối mảng).*
---
*Sự phát triển (Growth) cần không gian để hít thở. Khi ta trồng một hạt mầm (Flower), ta phải tôn trọng khoảng cách (Interval) để mọi sự sống đều có cơ hội tỏa sáng. Sự tham lam một cách khôn ngoan (Greedy logic) là việc tận dụng từng cơ hội nhỏ nhất ngay khi nó xuất hiện để đạt được mục tiêu chung.*
Growth (Growth) needs space to breathe. When we plant a seed (Flower), we must respect the interval (Interval) so that every life has a chance to shine. Wise greed (Greedy logic) is seizing every smallest opportunity as soon as it appears to achieve a common goal.

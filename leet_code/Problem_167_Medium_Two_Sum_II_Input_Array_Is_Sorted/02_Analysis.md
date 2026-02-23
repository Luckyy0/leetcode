# Analysis for Two Sum II - Input Array Is Sorted
# *Phân tích cho bài toán Hai số tổng (Mảng đã sắp xếp)*

## 1. Problem Essence & Sorting Advantage
## *1. Bản chất vấn đề & Lợi thế của việc sắp xếp*

### The Evolution from Two Sum
### *Sự tiến hóa từ bài toán Two Sum*
In the original Two Sum problem, the input was unsorted, requiring us to use a `HashMap` ($O(N)$ space) to remember seen numbers.
*Trong bài toán Two Sum gốc, đầu vào chưa được sắp xếp, yêu cầu chúng ta sử dụng `HashMap` (không gian $O(N)$) để ghi nhớ các số đã gặp.*

In this version, the input is **already sorted**. This is a massive hint. Sorting introduces a monotonic property that we can exploit to navigate the search space using **two pointers**, reducing space complexity to $O(1)$.
*Trong phiên bản này, đầu vào **đã được sắp xếp**. Đây là một gợi ý lớn. Việc sắp xếp tạo ra thuộc tính đơn điệu mà chúng ta có thể khai thác để điều hướng không gian tìm kiếm bằng **hai con trỏ**, giảm độ phức tạp không gian xuống $O(1)$.*

---

## 2. Approach: The Two-Pointer Convergence
## *2. Hướng tiếp cận: Sự hội tụ của hai con trỏ*

### Strategic Logic
### *Logic chiến lược*
1.  Initialize two pointers: `left` at the start (index 0) and `right` at the end (index $N-1$).
2.  Calculate the `sum = numbers[left] + numbers[right]`.
3.  **If `sum == target`**: We found the answer. Return `[left + 1, right + 1]` (since it's 1-indexed).
4.  **If `sum < target`**: The current sum is too small. Since the array is sorted, the only way to increase the sum is to move the `left` pointer to a larger value.
    *Nếu `sum < target`: Tổng hiện tại quá nhỏ. Vì mảng đã sắp xếp, cách duy nhất để tăng tổng là di chuyển con trỏ `left` sang một giá trị lớn hơn.*
5.  **If `sum > target`**: The current sum is too large. The only way to decrease it is to move the `right` pointer to a smaller value.
    *Nếu `sum > target`: Tổng hiện tại quá lớn. Cách duy nhất để giảm nó là di chuyển con trỏ `right` sang một giá trị nhỏ hơn.*
6.  Repeat until the solution is found.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Space Efficiency:** Unlike the hash map approach, we don't store any numbers. We only use two integer variables for indices.
    *Hiệu quả không gian tối ưu: Không giống như cách dùng hash map, chúng ta không lưu trữ bất kỳ con số nào. Chúng ta chỉ sử dụng hai biến nguyên cho chỉ số.*
*   **Guaranteed Termination:** The problem guarantees exactly one solution, meaning the pointers will always converge on the correct pair without falling out of bounds or missing the answer.
    *Đảm bảo kết thúc: Đề bài đảm bảo có đúng một giải pháp, nghĩa là các con trỏ sẽ luôn hội tụ về cặp số đúng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. In the worst case, we move the pointers a combined total of $N$ times until they meet in the middle or find the solution.
    *Độ phức tạp thời gian: $O(N)$. Trong trường hợp xấu nhất, chúng ta di chuyển các con trỏ tổng cộng $N$ lần.*
*   **Space Complexity:** $O(1)$. No auxiliary data structures are used.
    *Độ phức tạp không gian: $O(1)$. Không sử dụng các cấu trúc dữ liệu bổ trợ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `numbers = [2, 7, 11, 15], target = 9`

1.  `left = 0 (2), right = 3 (15)`. `Sum = 17`.
2.  `17 > 9`. Too big! Move `right` down.
3.  `left = 0 (2), right = 2 (11)`. `Sum = 13`.
4.  `13 > 9`. Too big! Move `right` down.
5.  `left = 0 (2), right = 1 (7)`. `Sum = 9`.
6.  `Sum == target`.
7.  Return `[0+1, 1+1] = [1, 2]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two Sum II is the quintessential example of the "Two Pointers on a Sorted Array" pattern. It demonstrates that pre-sorting data (or having sorted data) allows us to replace memory-heavy lookup tables with efficient boundary navigation. Always double-check if the problem asks for 0-indexed or 1-indexed results to avoid "Off-by-one" errors.
*Two Sum II là ví dụ điển hình của mẫu hình "Hai con trỏ trên mảng đã sắp xếp". Nó chứng minh rằng việc có dữ liệu đã sắp xếp cho phép chúng ta thay thế các bảng tra cứu tốn bộ nhớ bằng việc điều hướng ranh giới hiệu quả. Luôn kiểm tra kỹ xem đề bài yêu cầu kết quả đánh số từ 0 hay từ 1 để tránh lỗi lệch 1 đơn vị.*
---
*Khi vạn vật đã được sắp đặt theo trật tự, hai ánh nhìn từ hai đầu đối cực sẽ sớm tìm thấy sự hòa hợp ở giữa.*
When everything is arranged in order, two gazes from opposite ends will soon find harmony in the middle.

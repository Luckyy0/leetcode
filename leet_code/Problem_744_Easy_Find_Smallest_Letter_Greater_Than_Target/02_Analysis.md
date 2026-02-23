# Analysis for Find Smallest Letter Greater Than Target
# *Phân tích cho bài toán Tìm Ký tự Nhỏ nhất Lớn hơn Mục tiêu*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân*

### The Challenge
### *Thách thức*
We are looking for the "Upper Bound" of a target character in a sorted array. If the target is greater than or equal to the largest element (or no element is strictly greater), we wrap around to the first element.
*Chúng ta đang tìm "Cận trên" (Upper Bound) của một ký tự mục tiêu trong mảng đã sắp xếp. Nếu mục tiêu lớn hơn hoặc bằng phần tử lớn nhất (hoặc không có phần tử nào lớn hơn thực sự), ta quay vòng về phần tử đầu tiên.*

---

## 2. Strategy: Binary Search (Upper Bound)
## *2. Chiến lược: Tìm kiếm Nhị phân (Cận trên)*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Check Wrap-around:** If `target >= letters[last]`, then no character is strictly greater. Return `letters[0]`.
    *   **Kiểm tra Quay vòng:** Nếu `target` lớn hơn hoặc bằng phần tử cuối cùng, không có ký tự nào lớn hơn. Trả về `letters[0]`.*

2.  **Binary Search:**
    - Range: `[0, n-1]`.
    - If `letters[mid] > target`:
        - Try to find a smaller candidate to the left. `right = mid`.
    - If `letters[mid] <= target`:
        - Must look to the right. `left = mid + 1`.
    - Termination: When `left == right`, `letters[left]` is the smallest character greater than `target`.
    *   **Tìm kiếm Nhị phân:** Nếu `mid` lớn hơn, thu hẹp về bên trái. Nếu nhỏ hơn hoặc bằng, buộc phải tìm bên phải. Khi `left == right`, đó là kết quả.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *   **Độ phức tạp thời gian:** $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**letters = ["c", "f", "j"], target = "c"**
1. L=0, R=2. Mid=1 ('f').
2. 'f' > 'c'. Possible. R=1.
3. L=0, R=1. Mid=0 ('c').
4. 'c' <= 'c'. Need larger. L=1.
5. L=1, R=1. Loop ends.
**Result:** letters[1] = "f".

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using standard Binary Search templates helps avoid off-by-one errors. The wrap-around logic is best handled as a separate check or by modulo arithmetic on the result index.
*Sử dụng mẫu Tìm kiếm Nhị phân chuẩn giúp tránh lỗi sai lệch một đơn vị. Logic quay vòng tốt nhất nên được xử lý như một kiểm tra riêng biệt hoặc dùng phép chia lấy dư trên chỉ số kết quả.*
---
*Trong danh sách đã sắp đặt (Sorted array), việc tìm kiếm kẻ kế thừa (Successor) là một hành trình nhị phân. Khi vượt qua giới hạn cuối cùng (Wrap around), sự khởi đầu mới lại bắt đầu từ con số không. Dữ liệu dạy ta rằng bằng cách chia đôi không gian (Halving space), ta có thể tìm thấy bước tiếp theo ngắn nhất cho bất kỳ điểm dừng nào.*
In a sorted array, searching for a successor (Successor) is a binary journey. When crossing the final limit (Wrap around), a new beginning starts from zero. Data teaches us that by halving the space (Halving space), we can find the shortest next step for any stopping point.

# Analysis for Maximum Distance in Arrays
# *Phân tích cho bài toán Khoảng cách Lớn nhất trong các Mảng*

## 1. Problem Essence & Global Extremes
## *1. Bản chất vấn đề & Các giá trị Cực đoan Toàn cục*

### The Challenge
### *Thách thức*
We need to find the maximum possible $|a - b|$ where $a$ and $b$ come from different arrays. Since each array is sorted, the minimum of an array is its first element and the maximum is its last element.
*Chúng ta cần tìm $|a - b|$ lớn nhất có thể trong đó $a$ và $b$ đến từ các mảng khác nhau. Vì mỗi mảng đã được sắp xếp, giá trị nhỏ nhất của một mảng là phần tử đầu tiên và giá trị lớn nhất là phần tử cuối cùng của nó.*

Crucially, $a$ and $b$ **cannot** be from the same array.
*Quan trọng là, $a$ và $b$ **không thể** đến từ cùng một mảng.*

---

## 2. Strategy: Single Pass Extremes Tracking
## *2. Chiến lược: Theo dõi các Cực trị trong một lần duyệt*

Instead of comparing all pairs of arrays ($O(M^2)$), we can iterate once and maintain the "current best" global minimum and maximum encountered so far.
*Thay vì so sánh tất cả các cặp mảng ($O(M^2)$), chúng ta có thể duyệt một lần và duy trì giá trị nhỏ nhất và lớn nhất toàn cục "tốt nhất hiện tại" đã gặp cho đến nay.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialization:** Take the first array's first and last elements as our initial `minVal` and `maxVal`.
    * **Khởi tạo:** Lấy phần tử đầu tiên và cuối cùng của mảng đầu tiên làm `minVal` và `maxVal` ban đầu.*

2.  **Iterate from Second Array:** For each array `i` from $1$ to $m-1$:
    * **Duyệt từ Mảng thứ Hai:** Đối với mỗi mảng `i` từ $1$ đến $m-1$:*
    - **Current Array Extremes:** `currMin = arrays[i][0]`, `currMax = arrays[i][end]`.
    - **Calculate Potential Distances:**
        - `dist1 = abs(currMax - minVal)` (Current max vs Global min)
        - `dist2 = abs(maxVal - currMin)` (Global max vs Current min)
    - **Update Global Answer:** `res = max(res, dist1, dist2)`.
    - **Update Global Extremes:** 
        - `minVal = min(minVal, currMin)`
        - `maxVal = max(maxVal, currMax)`

3.  **Return `res`.**

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Greedy Integrity:** By updating the result *before* updating the global extremes, we strictly enforce that the two numbers come from different arrays.
    * **Tính Tham lam Chính xác:** Bằng cách cập nhật kết quả *trước khi* cập nhật các cực trị toàn cục, chúng ta thực hiện nghiêm ngặt quy tắc là hai số phải đến từ các mảng khác nhau.*
*   **Efficiency:** This reduces a potential quadratic complexity problem into a linear one.
    * **Hiệu suất:** Điều này giảm một bài toán có độ phức tạp bậc hai tiềm năng xuống còn độ phức tạp tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M)$ where $M$ is the number of arrays. We only look at the first and last elements of each array once.
    * **Độ phức tạp thời gian:** $O(M)$ trong đó $M$ là số lượng mảng. Chúng ta chỉ nhìn vào phần tử đầu tiên và cuối cùng của mỗi mảng một lần.*
*   **Space Complexity:** $O(1)$ beyond the input storage.
    * **Độ phức tạp không gian:** $O(1)$ ngoài việc lưu trữ đầu vào.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [[1,2,3], [4,5], [1,2,3]]
1. i=0: minVal=1, maxVal=3, res=0.
2. i=1 ([4,5]):
   - dist1 = |5 - 1| = 4.
   - dist2 = |3 - 4| = 1.
   - res = max(0, 4, 1) = 4.
   - minVal = min(1, 4) = 1.
   - maxVal = max(3, 5) = 5.
3. i=2 ([1,2,3]):
   - dist1 = |3 - 1| = 2.
   - dist2 = |5 - 1| = 4.
   - res = max(4, 2, 4) = 4.
**Result:** 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When searching for a maximum difference across groups, use a single-pass approach to track the extremes. The order of operations (calculate distance then update trackers) is the key to ensuring distinct source criteria.
*Khi tìm kiếm hiệu số lớn nhất giữa các nhóm, hãy sử dụng phương pháp duyệt một lần để theo dõi các cực trị. Thứ tự thao tác (tính khoảng cách rồi mới cập nhật các biến theo dõi) là chìa khóa để đảm bảo tiêu chí nguồn gốc khác biệt.*
---
*Tầm nhìn (Vision) nằm ở việc nhận diện những thái cực. Trong một tập hợp các mảng (Arrays), khoảng cách lớn nhất (Maximum distance) không được tìm thấy bằng cách nhìn vào bên trong một nhóm, mà bằng cách so sánh ranh giới (Extremes) của các nhóm khác nhau. Dữ liệu dạy ta rằng sự khác biệt vĩ đại nhất nảy sinh từ sự va chạm giữa những thế giới riêng biệt.*
Vision (Vision) lies in identifying extremes. In a set of arrays (Arrays), the maximum distance (Maximum distance) is not found by looking within a group, but by comparing the boundaries (Extremes) of different groups. Data teaches us that the greatest difference arises from the collision between separate worlds.

# Analysis for Binary Search
# *Phân tích cho bài toán Tìm kiếm Nhị phân*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
Searching for a value in a sorted array efficiently. Since the array is sorted, we can use the "divide and conquer" philosophy to eliminate half of the elements in each step.
*Tìm kiếm một giá trị trong mảng đã sắp xếp một cách hiệu quả. Vì mảng đã được sắp xếp, ta có thể sử dụng triết lý "chia để trị" để loại bỏ một nửa số phần tử trong mỗi bước.*

---

## 2. Strategy: Middle-Point Comparison
## *2. Chiến lược: So sánh Điểm giữa*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** `left = 0`, `right = nums.length - 1`.
2.  **Iterate:** While `left <= right`:
    - Calculate `mid = left + (right - left) / 2`.
    - If `nums[mid] == target`, return `mid`.
    - If `nums[mid] < target`, the target is in the right half: `left = mid + 1`.
    - If `nums[mid] > target`, the target is in the left half: `right = mid - 1`.
3.  **Failure:** If the loop ends, return `-1`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$, where $N$ is the length of the array.
    * **Độ phức tạp thời gian:** $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Binary Search is the fundamental search algorithm for sorted data. Always use `left + (right - left) / 2` to calculate the middle point to prevent potential integer overflow issues.
*Tìm kiếm nhị phân là thuật toán tìm kiếm cơ bản cho dữ liệu đã sắp xếp. Luôn sử dụng công thức tính điểm giữa an toàn để tránh tràn số nguyên.*
---
*Sự phân đôi (Bisection) là chìa khóa để chế ngự sự khổng lồ (Large data). Trong một thế giới của các giá trị đã được sắp đặt (Sorted), ta không đi tìm từng mảnh, mà ta thu hẹp không gian của sự nghi ngờ (Divide and conquer). Dữ liệu dạy ta rằng bằng cách chọn đúng trung tâm (Midpoint) và quyết đoán loại bỏ những gì không phù hợp, ta có thể tìm thấy chân lý chỉ trong vài nhịp đập của thời gian.*
Bisection (Bisection) is the key to subduing the gigantic (Large data). In a world of ordered values (Sorted), we don't look for every piece, but we narrow the space of doubt (Divide and conquer). Data teaches us that by choosing the right center (Midpoint) and decisively eliminating what is inappropriate, we can find the truth in only a few beats of time.

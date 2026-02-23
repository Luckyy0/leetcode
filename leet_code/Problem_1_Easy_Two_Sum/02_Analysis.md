# Analysis for Two Sum
# *Phân tích cho bài toán Hai Số Tổng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** An integer array `nums` and an integer `target`. *Một mảng số nguyên `nums` và một số nguyên `target`.*
*   **Output:** An array of two integers representing indices. *Một mảng gồm hai số nguyên đại diện cho các chỉ số.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `nums.length` is up to $10^4$. *Độ dài `nums` lên tới $10^4$.*
*   If we use a **Brute Force** approach ($O(N^2)$), the number of operations is roughly $(10^4)^2 = 10^8$. *Nếu chúng ta sử dụng phương pháp **Vét cạn** ($O(N^2)$), số lượng phép tính xấp xỉ $(10^4)^2 = 10^8$.*
*   This might be accepted but is on the edge of Time Limit Exceeded (TLE) or very slow. *Điều này có thể được chấp nhận nhưng đang ở ranh giới của Lỗi Quá Thời Gian (TLE) hoặc rất chậm.*
*   An **Optimized** approach ($O(N)$) is preferred. *Một phương pháp **Tối ưu** ($O(N)$) được ưu tiên hơn.*

### Edge Cases
### *Các trường hợp biên*
*   Minimum array size (2 elements). *Kích thước mảng tối thiểu (2 phần tử).*
*   Negative numbers in input or target. *Số âm trong đầu vào hoặc target.*
*   Duplicate numbers (e.g., `[3, 3]` with target `6`). *Các số trùng lặp (ví dụ, `[3, 3]` với target `6`).*

## 2. Data Structure Strategy
## *2. Chiến lược Cấu trúc Dữ liệu*

Since we cannot use `java.util.HashMap`, we will build a custom Hash Map.
*Vì chúng ta không thể sử dụng `java.util.HashMap`, chúng ta sẽ xây dựng một Bảng Băm tùy chỉnh.*

*   **Structure:** An array of `Node` objects (Buckets). *Cấu trúc: Một mảng các đối tượng `Node` (Buckets).*
*   **Node:** Stores `key` (number), `value` (index), and `next` reference. *`Node`: Lưu trữ `key` (số), `value` (chỉ số), và tham chiếu `next`.*
*   **Hashing:** `index = Math.abs(key) % SIZE`. *Băm: `index = Math.abs(key) % SIZE`.*
*   **Collision Handling:** Chaining (Linked List). *Xử lý va chạm: Phương pháp chuỗi (Danh sách liên kết).*

## 3. Approach & Algorithm
## *3. Giải thuật & Hướng tiếp cận*

### Approach 1: Brute Force (Naive)
### *Hướng tiếp cận 1: Vét cạn (Ngây thơ)*

*   **Intuition:** Check every pair of numbers. *Ý tưởng: Kiểm tra mọi cặp số.*
*   **Steps:**
    1.  Loop `i` from `0` to `n-1`. *Vòng lặp `i` từ `0` đến `n-1`.*
    2.  Loop `j` from `i+1` to `n-1`. *Vòng lặp `j` từ `i+1` đến `n-1`.*
    3.  If `nums[i] + nums[j] == target`, return `[i, j]`. *Nếu `nums[i] + nums[j] == target`, trả về `[i, j]`.*
*   **Complexity:**
    *   Time: $O(N^2)$. *Thời gian: $O(N^2)$.*
    *   Space: $O(1)$. *Không gian: $O(1)$.*

### Approach 2: One-pass Hash Table (Optimal)
### *Hướng tiếp cận 2: Bảng Băm một lượt (Tối ưu)*

*   **Intuition:** While iterating, check if the complement (`target - current_value`) exists in the map. *Ý tưởng: Trong khi duyệt, kiểm tra xem phần bù (`target - current_value`) có tồn tại trong bảng không.*
*   **Algorithm Steps:**
    1.  Initialize our custom `HashMap`. *Khởi tạo `HashMap` tùy chỉnh của chúng ta.*
    2.  Iterate through the array with index `i`. *Duyệt qua mảng với chỉ số `i`.*
    3.  Calculate `complement = target - nums[i]`. *Tính `complement = target - nums[i]`.*
    4.  Check if `complement` is in the map. *Kiểm tra xem `complement` có trong bảng không.*
        *   If yes, return `[map.get(complement), i]`. *Nếu có, trả về `[map.get(complement), i]`.*
        *   If no, add `nums[i]` and `i` to the map. *Nếu không, thêm `nums[i]` và `i` vào bảng.*
*   **Complexity:**
    *   Time: $O(N)$. We look up each element once. *Thời gian: $O(N)$. Chúng ta tra cứu mỗi phần tử một lần.*
    *   Space: $O(N)$. Storing items in the map. *Không gian: $O(N)$. Lưu trữ các phần tử trong bảng.*

### Dry Run
### *Chạy thử*
Input: `nums = [2, 7, 11, 15]`, `target = 9`.
Map is empty. *Bảng rỗng.*

1.  `i = 0`, `val = 2`. `Complement = 9 - 2 = 7`.
    *   Is `7` in Map? No. *`7` có trong Bảng không? Không.*
    *   Put `(2, 0)` into Map. *Thêm `(2, 0)` vào Bảng.*
2.  `i = 1`, `val = 7`. `Complement = 9 - 7 = 2`.
    *   Is `2` in Map? Yes (index 0). *`2` có trong Bảng không? Có (chỉ số 0).*
    *   Return `[0, 1]`. *Trả về `[0, 1]`.*

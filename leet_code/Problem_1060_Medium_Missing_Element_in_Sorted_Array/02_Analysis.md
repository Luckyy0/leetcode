# Analysis for Missing Element in Sorted Array
# *Phân tích bài toán Phần Tử Bị Thiếu Trong Mảng Đã Sắp Xếp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a strictly increasing array of sequential numbers `nums` and an integer `k`, you need to find the `kth` missing number in the sequence that starts from `nums[0]`.
*Được cấp một mảng số nguyên dương `nums` đang được xếp tăng dần đều và không trùng lặp, kèm thông số `k`. Nhiệm vụ của bạn là hãy truy tìm ra số bị mất tích xếp ở Vị trí thứ `k` tính từ mốc bắt đầu là con số Trái Cùng của mảng `nums[0]`.*

Constraints: Array length is up to 50,000, and $k$ can be up to $10^8$.
*Chiều dài mảng dao động tới 50,000, và chỉ số $k$ có thể bung lên 100 triệu.*

---

## 2. Strategy: Brute Force (Linear Scan)
## *2. Chiến lược: Trâu Cày (Quét Tuyến Tính)*

### Naive Logic
### *Lý luận thô sơ*
The simplest non-optimal approach is to linearly scan the array from the first element `nums[0]`. For every adjacent pair `(nums[i-1], nums[i])`, we calculate the gap between them.
*Cách giải quyết đơn giản nhất ai cũng nghĩ ra là soi mảng từ trái sang phải, bắt đầu từ phần tử đầu tiên `nums[0]`. Với mỗi cặp số đứng cạnh nhau `(nums[i-1], nums[i])`, ta tính ra khe hở rỗng của chúng (bao nhiêu số bị mất ở giữa).*

-   If the gap provides enough missing numbers to satisfy our counter `k`, the missing number natively belongs inside this specific gap! The answer is simply `nums[i-1] + k`.
    * *Nếu cái khe trống đó chứa lớn hơn hoặc bằng Số lượng `k` ta đang khao khát, thì Số Lạc cần bới ra Nằm Chắc Trúng Vào Khe đó. Số cần tìm là `nums[i-1] + k`.*
-   If the gap doesn't satisfy `k`, we subtract the gap size from `k` and continue to the next pairs.
    * *Nếu khe trống quá nhỏ không chứa đủ lượng `k`, ta trừ đi số lượng của Khe đó Khỏi Lượng `k` Đang Tìm, rồi vác đôi chân đi qua soi Cặp tiếp theo.*
-   If we exhaust the entire array and STILL haven't found the `kth` missing number, it mathematically implies the target is infinitely residing beyond the final element. We just add the remaining `k` to the last element `nums[n-1] + k`.
    * *Nếu đã quét sạch cả cái mảng mà vẫn Chưa Đủ Lượng `k`, Nghĩa là cái số ta Cần Phải tìm mẳm tít Tắp Bên Phải Mảnh Rìa Đuôi Của Mảng. Thế ta Cứ Cuốn Lấy Cục `k` dư Cộng Đại Lên Đuôi `nums[n-1] + k`.*

**Drawbacks (Điểm yếu):**
Array length goes up to 50,000. An $O(N)$ linear scan will technically pass but it is completely sub-optimal. The array is ALREADY STRICTLY SORTED. Any problem involving searching in a strictly sorted array points directly to an $O(\log N)$ Binary Search trick.
*Tuy Quét Cạn Tuyến Tính $O(N)$ vẫn lọt lưới, nhưng nó lại Lãng Phí Thời Gian! Bản thân cái Mảng Đã XẾP CỨNG TRẬT TỰ TĂNG DẦN hoàn mỹ, việc cày tuyến tính là một tội ác, làm lu mờ đi Nhãn Quan Mở Lối Đi Tìm Kiếm Nhị Phân (Binary Search) Tối Thiểu Hóa Thời Gian $O(\log N)$ đỉnh nóc.*

---

## 3. Strategy: Optimal (Binary Search)
## *3. Chiến lược: Tối ưu (Tìm kiếm Nhị Phân)*

### Logic and Rules
### *Lý luận và Quy tắc*

The crucial realization is formulating a mathematical function to find out exactly how many elements are missing BEFORE a specific index `i`.
*Chìa Khóa Mở Đường để chuyển từ Quét O(N) sang Nhị Phân $O(\log N)$ là tự xây dựng: "Một Hàm Giám Định tại Điểm Cố Định `i`, Tính toán cụ thể có bao nhiêu Số Đã Mất tích từ Đầu Nguồn `[0]` tới điểm `[i]` này?"*

The number of missing elements up to index `i` is explicitly formulated:
*Công Thức Của Sự Hụt Số Tính Tại vị trí `i` Tức Thì:*
`missing(i) = nums[i] - nums[0] - i`
*Giải Nghĩa: Khoảng nhảy vọt mỏ neo Lớn Nhất là `nums[i] - nums[0]`. Khi Ta lấy hiệu này Trừ đi số phần tử Quân Số Thực Sự Đang Hiện Hữu Trong Bụng mảng ở `i`, ta tự lột Móng Hạt Số lượng bị bay màu.*

1. **Check the Extreme Edge First:** If the target $k$ is greater than the total number of missing elements at the very last index `n-1`, it means the `kth` missing element is physically outside, to the right of the entire array.
   * *1. Cột Mốc Đo Ảo Ngay Ranh Giới Chót Mảng: Đo Hàm Thừa Thiếu Tại Đuôi Điểm `n - 1`. NẾU Sự Thất Lạc Tính Tới Chót Đuôi Mảng Gộp Vẫn Cực Bé Hơn Lệnh K `k`, Thì Số Chắc Chắn Bị Lọt Tít Cửa Ngoài Cuối Mảng. Khởi Lệnh Trả Về Phép Tính Tổng Đuôi Biên Trực Tiếp `nums[n - 1] + (k - missing(n - 1))`.*
2. **Binary Search Core Engine:** If the answer naturally hides within the array boundaries, properly maintain valid search pointers `left = 0` and `right = n - 1`. Calculate `mid`. If `missing(mid) < k`, shift `left = mid + 1`. Otherwise `right = mid`.
   * *2. Lõi Cưa Cắt Nhị Phân: Hành động Chặt Đôi Khúc Phân Cách Tìm Lối Đếm Dư: Đặt `left = 0` và `right = n - 1`. Chặt Ngang Lấy `mid`. Nếu đếm thiếu tại bụng Giữa `missing(mid)` mà vẫn Còn Nhỏ Hơn `k`... Nhảy Xốc Mép Vách `left = mid + 1`. Ngược lại Trả Cầu Trượt Thòng Góc Gọng Kìm Ép Biên Lọc Buột Dây Sườn Cận Viền `right = mid`.*
3. **The Final Absolute Yield:** The while loop actively breaks exactly when `left == right`. The target value seamlessly equals logical math.
   * *3. Cú Hạ Màn Kẹp Rốn: Trái Tim Nhị Phân Cắt Nhịp khi Vòng Đếm Chốt Chặn `left == right`. Con Toán Logic Bị Giải Thụ Khít Ngắn Đúng Ở Trạm Áp Điểm Tại Hộ Vệ Sát Tựa Nách Nút Trước Nó `left - 1`. Phép Lấp Xả Con Thiếu Thành Đáp Án Lõng Tích: `nums[left - 1] + (k - missing(left - 1))`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java Tối Ưu*

```java
public class Solution {
    private int missingAmount(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        
        // Rơi lọt ra ngoài rìa phải
        if (k > missingAmount(n - 1, nums)) {
            return nums[n - 1] + k - missingAmount(n - 1, nums);
        }
        
        int left = 0; 
        int right = n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (missingAmount(mid, nums) < k) {
                left = mid + 1;
            } else {
                right = mid; 
            }
        }
        
        return nums[left - 1] + k - missingAmount(left - 1, nums);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *   **Độ phức tạp thời gian:** $O(\log N)$. Áp Dụng Chặt Lõi Kép Binary Search Khoan Nửa Tốc Độ Sập Thúc Chu Kỳ Kiểm Tán Mỗi Vòng Quét Ngắn Gập Thời Gian Chỉ Xấp Xỉ Một Cú Nhảy Mắt Khít Dấu Dòng $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$. Nhóm Trục Cột Chỉ Mục Index Trỏ Đi Dựa Tuyển Bộ Rỗng Tuyết Rời Trọng Lượng RAM Ôm Gác $O(1)$.*

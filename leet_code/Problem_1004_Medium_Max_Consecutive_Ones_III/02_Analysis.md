# Analysis for Max Consecutive Ones III
# *Phân tích cho bài toán Số lượng số 1 liên tiếp tối đa III*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the length of the longest contiguous subarray containing only `1`s, given that we can change up to `k` `0`s into `1`s.
*Tìm chiều dài của dãy con liên tiếp dài nhất chỉ chứa các số `1`, với điều kiện chúng ta có thể thay đổi tối đa `k` số `0` thành `1`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The goal is to find the longest subarray that contains at most `k` zeros.
- This is a classic "sliding window" (or two pointers) problem. We can expand the window by moving the `right` pointer and keeping track of the number of zeros inside the window.
- If the number of zeros exceeds `k`, we simply shrink the window from the left by moving the `left` pointer until the number of zeros is equal to `k` or less.
*Mục tiêu là tìm dãy con dài nhất chứa tối đa `k` số 0. Đây là bài toán kinh điển về "cửa sổ trượt" (sliding window) hay hai con trỏ. Chúng ta mở rộng cửa sổ bằng cách di chuyển con trỏ `right` và theo dõi số lượng số 0 bên trong. Nếu số lượng số 0 vượt quá `k`, ta thu hẹp cửa sổ từ bên trái bằng con trỏ `left` cho đến khi số lượng số 0 không vượt quá `k`.*

## 2. Strategy 1: Naive (Brute Force)
## *2. Chiến lược 1: Ngây thơ (Vét cạn)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive approach is to generate all possible subarrays, and for each subarray, count the number of zeros. If it has at most `k` zeros, we compare its length to our maximum length so far.
*Cách tiếp cận ngây thơ là tạo ra tất cả các dãy con có thể có, và với mỗi dãy con, đếm số lượng số 0. Nếu nó có tối đa `k` số 0, chúng ta so sánh chiều dài của nó với chiều dài lớn nhất tính đến hiện tại.*

```java
public class Solution {
    public int longestOnesNaive(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                // Thỏa mãn điều kiện thì cập nhật maxLength
                if (zeros <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    // Quá số k số 0 thì không cần xét thêm vòng lặp j cho i này nữa
                    break;
                }
            }
        }
        return maxLength;
    }
}
```

- **Weakness (Điểm yếu):** To check every possible subarray, we use two nested loops, resulting in an $O(N^2)$ time complexity. With the constraint $N \le 10^5$, an $O(N^2)$ algorithm would perform up to $10^{10}$ operations in the worst case, inevitably causing a Time Limit Exceeded (TLE) error.
  *Để kiểm tra mọi dãy con có thể có, chúng ta sử dụng hai vòng lặp lồng nhau, dẫn đến độ phức tạp thời gian là $O(N^2)$. Với ràng buộc $N \le 10^5$, một thuật toán $O(N^2)$ sẽ phải thực hiện lên tới $10^{10}$ phép toán trong trường hợp xấu nhất, chắc chắn gây ra lỗi Quá giới hạn thời gian (TLE).*

---

## 3. Strategy 2: Optimal Sliding Window
## *3. Chiến lược 2: Cửa sổ trượt tối ưu*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

The Sliding Window algorithm solves the $O(N^2)$ bottleneck by processing each element exactly twice at most (once when the `right` pointer adds it to the window, and once when the `left` pointer removes it). Instead of resetting the start of the subarray and recounting from scratch like the naive approach, this optimal approach dynamically shrinks and expands a contiguous region. Both `left` and `right` pointers only move forward (never backwards), bringing the time complexity down to a lightning-fast $O(N)$.
*Thuật toán Cửa sổ trượt giải quyết nút thắt $O(N^2)$ bằng cách xử lý mỗi phần tử trễ nhất là đúng hai lần (một lần khi con trỏ `right` thêm nó vào cửa sổ, và một lần khi con trỏ `left` loại bỏ nó). Thay vì đặt lại điểm bắt đầu của dãy con và đếm lại từ đầu như cách tiếp cận ngây thơ, cách tiếp cận tối ưu này thu hẹp và mở rộng linh hoạt một vùng liên tiếp. Cả hai con trỏ `left` và `right` chỉ di chuyển về phía trước (không bao giờ quay lại), giảm thiểu độ phức tạp thời gian xuống con số chớp nhoáng $O(N)$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Pointers and Counters:** Set `left = 0`, `zeros = 0`, and `maxLength = 0`.
    *   **Khởi tạo con trỏ và biến đếm:** Đặt `left = 0`, `zeros = 0`, và `maxLength = 0`.*

2.  **Expand Window:** Iterate `right` pointer from `0` to the length of the array.
    *   **Mở rộng cửa sổ:** Lặp con trỏ `right` từ `0` đến hết mảng.*
    -   If `nums[right] == 0`, increment `zeros`.
        *Nếu `nums[right] == 0`, tăng biến đếm `zeros`.*

3.  **Shrink Window if Invalid:** While `zeros > k`, it means the current window `[left, right]` is invalid. We must shrink it by moving `left` to the right.
    *   **Thu hẹp cửa sổ nếu không hợp lệ:** Trong khi `zeros > k`, nghĩa là cửa sổ hiện tại `[left, right]` không hợp lệ. Chúng ta phải thu hẹp bằng cách di chuyển `left` sang phải.*
    -   If `nums[left] == 0`, decrement `zeros`.
        *Nếu `nums[left] == 0`, giảm `zeros`.*
    -   Increment `left` (`left++`).
        *Tăng `left` (`left++`).*

4.  **Update Output:** After making sure the window is valid (`zeros <= k`), the length of the current window is `right - left + 1`. We update `maxLength` accordingly.
    *   **Cập nhật kết quả:** Sau khi đảm bảo cửa sổ hợp lệ (`zeros <= k`), chiều dài của cửa sổ hiện tại là `right - left + 1`. Tính `maxLength` lớn nhất.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the length of `nums`. Both `left` and `right` pointers traverse the array at most once from left to right.
    *   **Độ phức tạp thời gian:** $O(N)$ với $N$ là chiều dài của `nums`. Cả hai con trỏ `left` và `right` chỉ duyệt qua mảng nhiều nhất một lần từ trái qua phải.*
*   **Space Complexity:** $O(1)$. We only use a few integer variables (`left`, `right`, `zeros`, `maxLength`).
    *   **Độ phức tạp không gian:** $O(1)$. Chỉ sử dụng một vài biến số nguyên tĩnh.*

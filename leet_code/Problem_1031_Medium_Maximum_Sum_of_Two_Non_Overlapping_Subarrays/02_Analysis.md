# Analysis for Maximum Sum of Two Non-Overlapping Subarrays
# *Phân tích bài toán Tổng Lớn Nhất của Hai Mảng Con Không Giao Nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an integer array `nums` and two integers `firstLen` and `secondLen`, return the maximum sum of elements in two non-overlapping subarrays with lengths `firstLen` and `secondLen`.
*Cho một mảng số nguyên `nums` cùng với hai độ dài cụ thể `firstLen` và `secondLen`, nhiệm vụ của chúng ta là lùng sục tổng lớn nhất đạt được từ hai mảng con (Subarrays) không được đè chéo (Non-overlapping) dính dáng lên nhau.*

---

## 2. Strategy 1: Naive (Prefix Sum and Nested Iterations)
## *2. Chiến lược 1: Ngây Thơ (Tạo Tổng Cộng Dồn và Hai Vòng Lặp Lồng)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea builds a prefix array to sum up interval selections in $O(1)$. We then select a valid chunk of length `firstLen` and subsequently iterate a separate sub-window scanning the remaining valid portions of the array strictly outside the bounds to accumulate `secondLen`. We evaluate maximum values comprehensively.
*Suy nghĩ nguyên thủy nhất là tính sẵn Mảng Tổng Cộng Dồn (Prefix Sum Array) để mỗi lần cắt dây Subarray có thể lấy ra ngay Tổng với tốc độ $O(1)$. Sau đó cắm chốt hai cửa sổ: Chọn một khoảng con `firstLen` bất kì, rồi thả cửa sổ `secondLen` rảo bộ qua lại dòm ngó trên tất cả những diện tích đất trống còn lại của mảng. Cộng 2 khúc đó lại và truy lùng xem cái nào max.*

```java
public class Solution {
    public int maxSumTwoNoOverlapNaive(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];

        int maxTotal = 0;
        
        // Cố định cánh L
        for (int i = 0; i <= n - firstLen; i++) {
            int sumL = prefix[i + firstLen] - prefix[i];
            
            // Tìm M bên trái L
            for (int j = 0; j <= i - secondLen; j++) {
                int sumM = prefix[j + secondLen] - prefix[j];
                maxTotal = Math.max(maxTotal, sumL + sumM);
            }
            // Tìm M bên phải L
            for (int j = i + firstLen; j <= n - secondLen; j++) {
                int sumM = prefix[j + secondLen] - prefix[j];
                maxTotal = Math.max(maxTotal, sumL + sumM);
            }
        }
        return maxTotal;
    }
}
```

- **Weakness:** The sliding bounds re-iterate repeatedly on previously evaluated data resulting in $O(N^2)$ algorithm bottleneck logic limits inherently dragging performance drastically.
- ***Điểm yếu:** Vòng lặp thứ hai cày qua cày lại những khúc đất đã rà soát trước đó của mảng, đẩy hệ số chịu tải lên cọc $O(N^2)$, một hiệu suất khá tẻ nhạt và dư thừa logic trầm trọng.*

---

## 3. Strategy 2: Optimal (Linear Sliding Window with DP State)
## *3. Chiến lược 2: Tối ưu (Trượt Cửa Sổ Tuyến Tính Kết Hợp Đỉnh Điểm DP)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why brute-force the second window completely when we can natively maintain the **maximum historic sum** of the preceding window dynamically as we physically slide bounds toward the right?
*Tại sao phải đánh rã trâu cái vòng lặp dò tìm cửa sổ thứ 2, trong khi hoàn toàn có thể ghi nhớ "Nóc Tổng Cũ Lịch Sử Cao Nhất" của Cửa Sổ kia trong lúc lướt tới phía phải của trục số?*
We solve this with a fluid continuous scan:
1. Scan specifically strictly assuming `firstLen` inherently historically appears prior to `secondLen`. While effectively sliding `secondLen`, we dynamically strictly keep tracking the maximum valid `firstLen` sum located directly behind the current elements.
2. Invert the logic exactly assuming `secondLen` natively implicitly appears before `firstLen`.
*Quy chuẩn trượt thông minh như sau:*
*1. Thử duyệt trường hợp `firstLen` nằm rớt Đằng Trước `secondLen`. Khi kéo đuôi cửa sổ `secondLen` trượt từng ô sang phải, ta Cập Nhật luôn cái đỉnh Max của thằng Cửa Sổ Đầu `firstLen` nằm núp gió ngay mép trái nó. Đánh một vòng là vét xong mẻ.*
*2. Đảo ngược vai trò: Thử trường hợp `secondLen` đứng Đằng Trước `firstLen`! Mọi thứ giữ y nguyên thuật toán. Đại cục nào lớn hơn thì Múc Ngay!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        return Math.max(findMaxSlidingWindowOffset(nums, L, M), 
                        findMaxSlidingWindowOffset(nums, M, L));
    }

    private int findMaxSlidingWindowOffset(int[] nums, int L, int M) {
        int sumL = 0;
        for (int i = 0; i < L; i++) sumL += nums[i];

        int maxL = sumL;
        int sumM = 0;
        for (int i = L; i < L + M; i++) sumM += nums[i];

        int globalMax = maxL + sumM;

        for (int i = L + M; i < nums.length; i++) {
            sumL += nums[i - M] - nums[i - M - L];
            maxL = Math.max(maxL, sumL);

            sumM += nums[i] - nums[i - M];
            globalMax = Math.max(globalMax, maxL + sumM);
        }
        return globalMax;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ defines the array bound lengths explicitly natively functionally logically efficiently processed within dynamic sweeps completely linearly intelligently natively!
*   *   **Độ phức tạp thời gian:** $O(N)$. Hai tia quét trượt cửa sổ song song không làm nhịp tim hệ thống lỡ chấn. Nó ăn tột đỉnh Tuyến tính một bước (quét sang trái quét sang phải).*
*   **Space Complexity:** $O(1)$ efficiently explicitly logically perfectly organically intelligently handled natively smoothly securely optimally predictably!
*   *   **Độ phức tạp không gian:** $O(1)$. Giữ vài biến con con đong đếm lạch tạch thay vì chưng cất bộ Mảng DP hay Prefix Array cồng kềnh. Gọn rụng rời!*

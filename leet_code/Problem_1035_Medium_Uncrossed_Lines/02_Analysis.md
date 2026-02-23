# Analysis for Uncrossed Lines
# *Phân tích bài toán Đoạn Thẳng Không Cắt Nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are given two integer arrays `nums1` and `nums2`. We write the integers of `nums1` and `nums2` on two separate horizontal lines. We may draw connecting lines: a straight line connecting two numbers `nums1[i]` and `nums2[j]` if `nums1[i] == nums2[j]`. Lines cannot intersect each other. Return the maximum number of connecting lines we can draw.
*Bạn được cấp hai mảng số nguyên `nums1` và `nums2` nằm vắt ngang thành hai đường thẳng song song trên giấy. Bạn được quyền nối các điểm có giá trị bằng nhau (`nums1[i] == nums2[j]`) từ trên xuống dưới. Hai vệt nối Không Được Cắt Nhau! Nhiệm vụ là vẽ lót được Tối Đa bao nhiêu sợi chỉ song song.*

---

## 2. Strategy: Optimal (Dynamic Programming - Longest Common Subsequence)
## *2. Chiến lược: Tối ưu (Quy Hoạch Động - Bài toán Con Chung Dài Nhất)*

### Logic and Rules
### *Lý luận và Quy tắc*

The rule that lines cannot cross is mathematically equivalent to preserving the relative order of elements. This directly translates the problem into finding the Longest Common Subsequence (LCS) between the two arrays.
*Yêu cầu "các đường nối không cắt nhau" ĐỒNG NGHĨA tuyệt đối với việc Bạn phải bốc ra Một Dãy Chữ Số Liên Tiếp Ẩn Giấu Bề Mặt trong cả hai mảng với Trật Tự Không Đổi (Từ trái sang phải). Nếu bạn phá bỏ trật tự, hai sợi dây sẽ đâm chéo. Đây CHÍNH LÀ CHUỖI CON CHUNG DÀI NHẤT (Longest Common Subsequence - LCS).*

We construct a 2D DP table `dp[i][j]` representing the maximum number of connecting lines between the first `i` elements of `nums1` and the first `j` elements of `nums2`.
- If `nums1[i-1] == nums2[j-1]`: A match is found. Add a line. `dp[i][j] = dp[i-1][j-1] + 1`
- If `nums1[i-1] != nums2[j-1]`: Inherit the max from dropping either character. `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`
*Xây dựng bảng Quy Hoạch Động Ma Trận `dp[i][j]` lưu Kỷ lục số đai nối nhiều nhất nếu dừng mảng 1 đứt đoạn tới chữ thứ $i$, và dừng Mảng 2 đứt đoạn ở chữ thứ $j$.*
*- TRƯỜNG HỢP 1: NẾU `nums1[i-1] == nums2[j-1]`. Nối ngay một sợi. `dp[i][j] = dp[i-1][j-1] + 1`*
*- TRƯỜNG HỢP 2: NẾU `nums1[i-1] != nums2[j-1]`. Kế thừa kỷ lục cũ lớn hơn khi bỏ 1 ký tự mảng A hoặc mảng B. `dp[i][j] = max( dp[i-1][j], dp[i][j-1] )`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(m \times n)$. We use two simple nested loops to populate the dynamic programming matrix step by step.
    *   **Độ phức tạp thời gian:** $O(m \times n)$. Đổ 2 Vòng Lặp qua Ma trận $N$ dòng và $M$ cột để điền bảng DP.*
*   **Space Complexity:** $O(m \times n)$ to store the DP table. It can be optimized to $O(\min(m,n))$ by using a one-dimensional rolling array.
    *   **Độ phức tạp không gian:** $O(m \times n)$. Chiếm dụng tài nguyên khởi tạo Bảng Ma Trận tĩnh $m \times n$. (Có thể thu nhỏ còn 1 mảng 1 chiều quay vòng).*

# Analysis for Longest Arithmetic Subsequence
# *Phân tích bài toán Dãy Con Cấp Số Cộng Dài Nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the length of the longest arithmetic subsequence in an array. An arithmetic subsequence maintains a constant fixed difference (`d = nums[i] - nums[j]`) between consecutive elements. Elements can be skipped, but the relative order must be the same as the original array.
*Tìm chiều dài của dãy con cấp số cộng dài nhất trong một mảng. Dãy con cấp số cộng duy trì một bước nhảy cố định (công sai `d = nums[i] - nums[j]`) giữa các phần tử liên tiếp. Có thể bỏ qua các phần tử ở giữa, nhưng thứ tự tương đối phải được giữ nguyên y như mảng gốc.*

---

## 2. Strategy 1: Naive (Three-Nested Loops Simulation)
## *2. Chiến lược 1: Ngây thơ (Thi đấu Ba Vòng Lặp Lồng Máy)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea iterates through every pair of elements to define the initial difference (`nums[j] - nums[i]`). Then, it linearly scans the rest of the array to find the next elements that maintain this difference.
*Tư duy ngây ngô đòi đúc ngẫu nhiên hàng ngàn cái Khoảng Cách `d` (Công sai) bằng cách cố nhồi nhét hai vòng lặp lồng gắp Từng Cặp phần tử bất kỳ. Từ cặp này, chạy thêm vòng lặp thứ ba dọc theo mảng để mò mẫm phần tử tiếp theo.*

```java
public class Solution {
    public int longestArithSeqLengthNaive(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        
        int maxLength = 2;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int expectedStep = nums[j] - nums[i]; 
                int currentLength = 2; 
                int nextExpectedValue = nums[j] + expectedStep;
                
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == nextExpectedValue) {
                        currentLength++;
                        nextExpectedValue += expectedStep;
                    }
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
```

- **Weakness:** We relentlessly re-evaluate the later numbers inside the $k$-loop multiple overlapping times for branching prefix combinations. The pure depth reaches $O(N^3)$, which results in Time Limit Exceeded (TLE) timeouts for arrays up to length 1000.
- ***Điểm yếu:** Vòng lặp thứ ba lại lôi thêm các phần tử đằng sau ra nhai đi nhai lại nhiều lần, đẩy độ phức tạp lún móp xuống $O(N^3)$. Với nọc Độc Kích cỡ mảng $N = 1000$, chắc chắn dẫn tới cái kết sập nguồn treo máy Time Limit Exceeded (Quá hạn thời gian)!*

---

## 3. Strategy 2: Optimal (Dynamic Programming with Memory Array Offset)
## *3. Chiến lược 2: Tối ưu (Quy Hoạch Động trên Bảng Offset Bù Trừ)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

We deploy optimized Dynamic Programming (DP). Let `dp[i][diff]` denote the length of the longest arithmetic subsequence ending at array index `i` with the explicit constant gap `diff`. As we evaluate every pair `(i, j)` where $j < i$:
*Chúng ta sẽ dàn trận Quy Hoạch Động (DP) đỉnh cao! Đúc bảng `dp[i][diff]` quy trình ngầm ám chỉ "Chiều dài khủng nhất của Chuỗi số học ĐÁP CÁNH tại ô `i`, có Nhịp nhảy là `diff`". Chạy lặp rà Từng Cặp `(i, j)` trong đó $j < i$:*
1. Calculate the raw gap: `diff = nums[i] - nums[j]`.
*1. Tính cú giật điện Step: `diff = nums[i] - nums[j]`.*
2. Check backwards: if a sequence ended at `j` bearing the very same physical `diff`, we extend it by appending our brand new value `nums[i]`.
*2. Nhìn ngược về quá khứ: Nếu chuỗi của Tổ Tiên đã kết thúc ở Điểm `j` mang trên lưng cùng nhịp tim giật đập `diff` đó, mình kéo dài liên mạch nó ra bằng cách gắn thêm giá trị mới `nums[i]`!*
3. Formula: `dp[i][diff] = dp[j][diff] + 1;`
*3. Phép Màu Xích Liên Giao: `dp[i][diff] = dp[j][diff] + 1`.*
The gap `diff` can be negative. Since the limits of elements are strictly `0 <= node.val <= 500`, differences fall within `[-500, 500]`. We offset the gap by adding `500`, adjusting the storage index to essentially cover the positive range `[0, 1000]`.
*Lệnh cấm kị: Nhịp Bước `diff` có thể mang dấu âm (VD 20 về 15 là -5). Giá trị mảng gốc chỉ từ 0 đến 500, nên bước nảy khùng điên nhất là -500. Cộng chêm Offset bù trừ `+500` vào Độ Lệch Công Sai. Bảng Màng DP giờ sảng khoái tiêu hóa êm ái cột Số $0$ đến Cột $1000$ rải khắp địa phận!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001]; 
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int offsetDiff = diff + 500; 
                
                dp[i][offsetDiff] = dp[j][offsetDiff] > 0 ? dp[j][offsetDiff] + 1 : 2;
                maxLength = Math.max(maxLength, dp[i][offsetDiff]);
            }
        }
        
        return maxLength;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the length of the array. The nested two loops iterate over all pairs sequentially. For maximum constraint $N=1000$, loops generate $\approx 5 \times 10^5$ operations, vastly outperforming cube constraints.
*   *   **Độ phức tạp thời gian:** $O(N^2)$, với $N$ là số lượng phần tử của mảng. Hai vòng lặp lồng nhau quét tất cả các cặp có thể! Nếu rải mảng đụng trần đại dương 1000, hệ thống chỉ quay ro ro $\sim 500.000$ nhịp. Đạp nát vũng bùn $O(N^3)$ lề mề.*
*   **Space Complexity:** $O(N \times D)$, where $N$ is the array length and $D$ is the size of the offset domain (1001 column boundaries). It utilizes $1000 \times 1001 \approx 10^6$ elements, taking less than 4 megabytes.
*   *   **Độ phức tạp không gian:** $O(N \times D)$, với $N$ là số phần tử và $D$ là số nhịp bước (bảng 1001 cột bù trừ). Xài chung một mảng 2 chiều tốn cỡ 4 Megabyte RAM, dư sức bẻ lái khỏi giới hạn rác máy!*

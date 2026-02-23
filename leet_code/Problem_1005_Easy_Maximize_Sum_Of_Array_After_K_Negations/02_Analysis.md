# Analysis for Maximize Sum Of Array After K Negations
# *Phân tích cho bài toán Tối đa hóa tổng mảng sau K lần đảo dấu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to perform exactly `k` negations to maximize the total sum of the array. The optimal way is to always negate the smallest (most negative) numbers first. If there are no negative numbers left and `k` is still not exhausted, we should repeatedly negate the smallest non-negative number to minimize the loss.
*Chúng ta cần thực hiện chính xác `k` lần đảo dấu để tổng các phần tử trong mảng là lớn nhất. Cách tối ưu là luôn đảo dấu các số nhỏ nhất (âm nhiều nhất) trước. Nếu không còn số âm nào và `k` vẫn chưa hết, ta nên lặp đi lặp lại việc đảo dấu số không âm nhỏ nhất để giảm thiểu tổn thất.*

---

## 2. Strategy 1: Naive (Brute Force)
## *2. Chiến lược 1: Ngây thơ (Vét cạn)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy is to simulate the process exactly as described: for each of the `k` steps, find the minimum element in the entire array and negate it.
*Chiến lược ngây thơ là mô phỏng quá trình đúng như mô tả: với mỗi bước trong số `k` bước, tìm phần tử nhỏ nhất trong toàn bộ mảng và đảo dấu nó.*

```java
public class Solution {
    public int largestSumAfterKNegationsNaive(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            // Tìm phần tử nhỏ nhất
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Đảo dấu phần tử nhỏ nhất
            nums[minIndex] = -nums[minIndex];
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
```

- **Weakness (Điểm yếu):** Finding the minimum element takes $O(N)$ time, and doing this `k` times results in an $O(N \times K)$ time complexity. With $N, K \le 10^4$, this could take up to $10^8$ operations, which is slow and close to the TLE threshold.
  *Việc tìm phần tử nhỏ nhất mất thời gian $O(N)$, và thực hiện việc này `k` lần dẫn đến độ phức tạp thời gian là $O(N \times K)$. Với $N, K \le 10^4$, có thể mất đến $10^8$ phép toán, rất chậm và sát giới hạn quá giới hạn thời gian (TLE).*

---

## 3. Strategy 2: Optimal (Greedy & Sorting/PriorityQueue)
## *3. Chiến lược 2: Tối ưu (Tham lam & Sắp xếp / Hàng đợi ưu tiên)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of finding the minimum element repeatedly, we can sort the array once in $O(N \log N)$ time. After sorting, the negative numbers are grouped at the beginning from smallest to largest. We sequentially negate them until either `k` runs out or we run out of negative numbers. If `k` is still greater than 0 and odd, we must sacrifice the smallest absolute value in the array by negating it. This completely eliminates the bottleneck of repeatedly scanning the array, bringing the time complexity to an extremely fast $O(N \log N)$.
*Thay vì liên tục tìm phần tử nhỏ nhất, chúng ta có thể sắp xếp mảng một lần trong thời gian $O(N \log N)$. Sau khi sắp xếp, các số âm nằm ở đầu mảng theo thứ tự từ nhỏ đến lớn. Ta lần lượt đảo dấu chúng cho đến khi hết `k` hoặc hết số âm. Nếu `k` vẫn còn lớn hơn 0 và là số lẻ, ta "hi sinh" phần tử có giá trị tuyệt đối nhỏ nhất trong mảng bằng cách đảo dấu nó. Cách này loại bỏ hoàn toàn nút thắt của việc quét mảng lặp đi lặp lại, giúp độ phức tạp thời gian giảm xuống mức cực nhanh $O(N \log N)$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort array:** Sort the array `nums` in ascending order.
    *   **Sắp xếp mảng:** Sắp xếp mảng `nums` theo thứ tự tăng dần.*
2.  **Negate Negatives:** Iterate through the array. If the number is negative and `k > 0`, negate it and decrease `k`.
    *   **Đảo số âm:** Lặp qua mảng. Nếu số âm và `k > 0`, đảo dấu nó và giảm `k`.*
3.  **Handle remaining `k`:** If `k` is odd after negating all negative numbers, sort the array again (or keep track of the minimum absolute value) and negate the smallest element. If `k` is even, we don't need to do anything because negating a number an even number of times keeps it the same.
    *   **Xử lý phần `k` còn lại:** Nếu `k` là số lẻ sau khi đã đảo tất cả số âm, hãy sắp xếp lại mảng (hoặc theo dõi giá trị tuyệt đối nhỏ nhất) và đảo dấu con số nhỏ nhất. Nếu `k` chẵn, ta không cần làm gì vì đảo dấu một số chẵn lần thì vẫn giữ nguyên giá trị.*
4.  **Sum array:** Calculate and return the sum.
    *   **Tính tổng:** Tính và trả về tổng các phần tử.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.Arrays;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        
        // Lật dấu các số âm
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        
        // Tính tổng và tìm giá trị nhỏ nhất hiện tại
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        
        // Nếu k lẻ, trừ đi 2 lần giá trị nhỏ nhất (vì nó đã được cộng vào tổng ở trên)
        if (k % 2 != 0) {
            sum -= 2 * min;
        }
        
        return sum;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the length of `nums`. The built-in sorting method runs in $O(N \log N)$ time, and the subsequent iterations take $O(N)$ time.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ với $N$ là chiều dài của mảng `nums`. Hàm sắp xếp có sẵn chạy trong $O(N \log N)$, và các bước lặp sau đó tốn $O(N)$ thời gian.*
*   **Space Complexity:** $O(\log N)$ or $O(N)$ built-in memory stack used for sorting depends on language/algorithm details.
    *   **Độ phức tạp không gian:** $O(\log N)$ hoặc $O(N)$ do bộ nhớ tích hợp trong các thuật toán sắp xếp của hệ thống.*

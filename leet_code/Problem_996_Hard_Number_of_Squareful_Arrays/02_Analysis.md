# Analysis for Number of Squareful Arrays
# *Phân tích cho bài toán Số lượng mảng Squareful*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count unique permutations of an array where every adjacent pair sums to a perfect square.
*Đếm các hoán vị duy nhất của một mảng mà mọi cặp phần tử liền kề có tổng là một số chính phương.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The array length is very small ($N \le 12$). This implies $O(N!)$ backtracking is the intended solution.
- The challenge is generating **unique** permutations efficiently to avoid recounting identical sequences when `nums` contains duplicates.
- Solution for duplicates: Sort the array first. When iterating through choices, if the current number is the same as the previous one, and the previous one was **not used** in the current branch, skip it (`if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;`).
- Optimization: Backtracking with pruning. At each step, only choose a number if it forms a perfect square with the previously chosen number.
*Độ dài mảng rất nhỏ ($N \le 12$), phù hợp với thuật toán quay lui (backtracking). Cần sắp xếp mảng và sử dụng kỹ thuật bỏ qua phần tử trùng lặp (nếu phần tử giống phần tử trước mà phần tử trước chưa được dùng trong nhánh này thì bỏ qua) để chỉ sinh ra các hoán vị duy nhất.*

---

## 2. Strategy: Backtracking with Pruning
## *2. Chiến lược: Quay lui cắt tỉa*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Preparation:** Sort `nums`. Create boolean `used` array of size $N$. `ans = 0`.
    *   **Chuẩn bị:** Sắp xếp mảng, tạo mảng boolean đánh dấu đã dùng, biến đếm kết quả.*

2.  **Backtracking Function:** `backtrack(int count, int lastNum)`
    - Base case: If `count == nums.length`, a valid permutation is formed. `ans++`, return.
    - Loop `i` from `0` to `N-1`:
        - If `used[i]` is true, `continue`.
        - If `i > 0 && nums[i] == nums[i-1] && !used[i-1]`, `continue` (Skip duplicate permutations).
        - If `count > 0` and `!isSquare(lastNum + nums[i])`, `continue` (Prune invalid paths immediately).
        - **Choose:** Mark `used[i] = true`.
        - **Explore:** `backtrack(count + 1, nums[i])`.
        - **Un-choose:** Mark `used[i] = false`.
    *   **Hàm Quay lui:** Gọi đệ quy thêm biến vào hoán vị, cắt tỉa nếu không tạo thành số chính phương.*

3.  **Square Check:** A fast function `isSquare(int v)`: `int r = (int)Math.sqrt(v); return r * r == v;`.
    *   **Kiểm tra số chính phương:** Tính bình phương căn bậc 2.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    int count = 0;
    
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, 0, -1);
        return count;
    }
    
    private void backtrack(int[] nums, boolean[] used, int pCount, int lastNum) {
        if (pCount == nums.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // Skip duplicates to ensure unique permutations
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            
            // Check perfect square condition
            if (pCount > 0 && !isSquare(lastNum + nums[i])) continue;
            
            used[i] = true;
            backtrack(nums, used, pCount + 1, nums[i]);
            used[i] = false;
        }
    }
    
    private boolean isSquare(int val) {
        int root = (int) Math.sqrt(val);
        return root * root == val;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot N!)$. In the worst case (all identical numbers), the duplicate check makes it $O(N)$. Without duplicates and all pairs being perfect squares, it's $O(N!)$. Pruning drastically reduces typical running time.
    *   **Độ phức tạp thời gian:** $O(N!)$ trong trường hợp xấu nhất không có trùng lặp và mọi tổng đều là số chính phương.*
*   **Space Complexity:** $O(N)$ for the recursion stack and the `used` array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting + Duplicate skipping ensures we only explore unique permutations, and the sum check at each step trims the search tree effectively.
*Sắp xếp mảng và bỏ qua phần tử trùng lặp đảm bảo chỉ thám hiểm các hoán vị duy nhất, việc kiểm tra tổng ở mỗi bước cắt tỉa cây tìm kiếm vô cùng hiệu quả.*

# Analysis for Beautiful Array
# *Phân tích cho bài toán Mảng Đẹp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Arrange numbers `1..N` such that for any `i < k < j`, `2 * nums[k] != nums[i] + nums[j]`.
*Sắp xếp các số `1..N` sao cho với mọi `i < k < j`, `2 * nums[k] != nums[i] + nums[j]`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The condition `2 * nums[k] == nums[i] + nums[j]` means `nums[k]` is the arithmetic mean of `nums[i]` and `nums[j]`. This implies `nums[i] + nums[j]` is even.
- If `nums[i]` is ODD and `nums[j]` is EVEN, then `nums[i] + nums[j]` is ODD.
- `2 * nums[k]` is always EVEN.
- So, `2 * nums[k]` can never equal `ODD + EVEN`.
- Strategy: Put all ODD numbers on the left, and all EVEN numbers on the right.
- Then any `i < j` crossing the middle will have `nums[i]` (odd) + `nums[j]` (even) = odd, so no `k` exists.
- Now we need to solve the problem for the ODD part and the EVEN part recursively.
- This is a divide and conquer strategy.
- Base case: `N=1`, array `[1]` is beautiful.
- Recursive step:
  - Odds: `2*x - 1`. If `x` array is beautiful, `2*x - 1` is beautiful (linear transformation preserves arithmetic progression property).
  - Evens: `2*x`. If `x` array is beautiful, `2*x` is beautiful.
- Combine: `[...Odds, ...Evens]`.
*Điều kiện có nghĩa là `nums[k]` là trung bình cộng. Nếu ta đặt tất cả số lẻ bên trái, tất cả số chẵn bên phải, thì tổng một số lẻ và một số chẵn luôn là lẻ, không thể bằng `2*k`. Vậy ta chỉ cần giải đệ quy cho nửa lẻ và nửa chẵn.*

---

## 2. Strategy: Divide and Conquer
## *2. Chiến lược: Chia để Trị*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterative Approach:** Build the array level by level.
    *   **Cách tiếp cận lặp:** Xây dựng mảng từng tầng.*

2.  **Logic:**
    - Start with `res = [1]`.
    - While `res.length < n`:
        - Create `temp`.
        - Add `odd` transformation: For each `x` in `res`, if `2*x - 1 <= n`, add `2*x - 1`.
        - Add `even` transformation: For each `x` in `res`, if `2*x <= n`, add `2*x`.
        - `res = temp`.
    *   **Logic:** Bắt đầu với `[1]`. Ở mỗi bước, tạo danh sách mới bằng cách biến đổi danh sách cũ thành các số lẻ (`2x-1`) và các số chẵn (`2x`) tương ứng.*

3.  **Return:** `res`.
    *   **Trả về:** `res`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.ArrayList;

public class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        
        while (res.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            // Add odd numbers
            for (int x : res) {
                if (x * 2 - 1 <= n) {
                    temp.add(x * 2 - 1);
                }
            }
            // Add even numbers
            for (int x : res) {
                if (x * 2 <= n) {
                    temp.add(x * 2);
                }
            }
            res = temp;
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ or effectively $O(N)$. At each step size doubles. Wait, actually linear because total elements added is N? No, `res` grows.
    - Step 1: size 1 -> process 1.
    - Step 2: size 2 -> process 2.
    - ... Log N steps. Total work is sum of sizes. $1 + 2 + 4 + ... + N = 2N$. So $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for result list.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple iterative construction based on the property that Odd + Even != 2 * Integer.
*Xây dựng lặp đơn giản dựa trên tính chất Lẻ + Chẵn != 2 * Số nguyên.*

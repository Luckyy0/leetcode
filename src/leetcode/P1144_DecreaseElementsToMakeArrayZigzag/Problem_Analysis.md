# 1144. Decrease Elements To Make Array Zigzag / Giảm các Phần tử để Tạo Mảng Zigzag

## Problem Description / Mô tả bài toán
Given an array `nums` of integers, a move consists of choosing any element and decreasing it by 1.
An array is zigzag if either:
- Every even indexed element is greater than adjacent elements (Peaks at even).
- Every odd indexed element is greater than adjacent elements (Peaks at odd).
Return the minimum moves to transform `nums` into a zigzag array.
Cho một mảng `nums` các số nguyên, một nước đi bao gồm việc chọn bất kỳ phần tử nào và giảm nó đi 1.
Một mảng là zigzag nếu:
- Mỗi phần tử có chỉ số chẵn lớn hơn các phần tử liền kề (Đỉnh ở chẵn).
- Mỗi phần tử có chỉ số lẻ lớn hơn các phần tử liền kề (Đỉnh ở lẻ).
Trả về số bước di chuyển tối thiểu để biến đổi `nums` thành một mảng zigzag.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Calculation / Tính toán Tham lam
Since we can only decrease, if we want an element to be smaller than neighbors, we decrease it.
We verify two scenarios:
1. Even indices are peaks (so odd indices are valleys).
   - For each odd index `i`: `nums[i]` must be `< min(nums[i-1], nums[i+1])`.
   - Moves needed = `current_val - (min_neighbor - 1)`. If already smaller, 0.
2. Odd indices are peaks (so even indices are valleys).
   - For each even index `i`: `nums[i]` must be `< min(nums[i-1], nums[i+1])`.

Calculate moves for both, take minimum.
Wait, can decreasing one neighbor affect the next condition?
The condition is local for the "valley".
If we make `i` a valley, we need `nums[i] < nums[i-1]` and `nums[i] < nums[i+1]`.
Decreasing `i` helps, decreasing `i-1` makes it harder for `i` to be valley?
BUT we only decrease elements at indices that are supposed to be valleys.
In Scenario 1 (Odd valleys), we only decrease odd indices. Even indices (peaks) are kept as is?
Yes, decreasing peaks never helps the zigzag condition for THAT peak.
Wait.
If we decrease a peak: it risks violating the condition `peak > valley`.
But we can only decrease.
To satisfy `peak > valley`, we can either increase peak (impossible) or decrease valley (possible).
So the only strategy is to decrease the valleys.
Thus, the two scenarios are independent calculations.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two-Pass Valley Optimization
Consider two cases: indices $0, 2, 4...$ are peaks (and $1, 3, 5...$ are valleys), or vice-versa. Since we can only decrease numbers, to satisfy a peak condition $A[i-1] < A[i] > A[i+1]$, we must decrease the "valley" elements $A[i-1]$ and $A[i+1]$. Specifically, if we decide even indices are valleys, we iterate through all even $i$ and reduce $A[i]$ until it is strictly less than both neighbors (i.e., $\le \min(Neighbors) - 1$). The cost is the sum of reductions. Compare the cost for making even-indices valleys vs. odd-indices valleys and return the minimum.
Xem xét hai trường hợp: các chỉ số $0, 2, 4...$ là các đỉnh (và $1, 3, 5...$ là các thung lũng), hoặc ngược lại. Vì chúng ta chỉ có thể giảm các số, để thỏa mãn điều kiện đỉnh $A[i-1] < A[i] > A[i+1]$, chúng ta phải giảm các phần tử "thung lũng" $A[i-1]$ và $A[i+1]$. Cụ thể, nếu chúng ta quyết định các chỉ số chẵn là các thung lũng, chúng ta lặp qua tất cả $i$ chẵn và giảm $A[i]$ cho đến khi nó nhỏ hơn hoàn toàn cả hai hàng xóm (tức là, $\le \min(Neighbors) - 1$). Chi phí là tổng các mức giảm. So sánh chi phí để tạo các thung lũng chỉ số chẵn so với các thung lũng chỉ số lẻ và trả về mức tối thiểu.

---

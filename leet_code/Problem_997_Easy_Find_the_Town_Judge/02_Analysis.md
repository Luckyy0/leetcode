# Analysis for Find the Town Judge
# *Phân tích cho bài toán Tìm Thẩm phán của Thị trấn*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Identify the node in a directed graph with an in-degree of `n-1` and an out-degree of `0`.
*Xác định đỉnh trong đồ thị có hướng có bậc vào là `n-1` và bậc ra là `0`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Each trust relationship `[a, b]` means `a` trusts `b` (directed edge from `a` to `b`).
- Person `a` gives out trust (out-degree increases).
- Person `b` receives trust (in-degree increases).
- The town judge trusts nobody: Out-degree = 0.
- Everyone (except the judge) trusts the judge: In-degree = `N - 1`.
- We can track the net trust score: `(In-degree) - (Out-degree)`.
- If a person is the judge, their net trust score must be EXACTLY `N - 1`.
- Anyone else will either trust someone (out-degree > 0) or won't be trusted by everyone (in-degree < N-1), so their net score will be $< N - 1$.
*Theo dõi điểm tin cậy ròng. Thẩm phán nhận N-1 niềm tin và không cho đi niềm tin nào, do đó điểm ròng là N-1. Bất kỳ ai khác đều có điểm < N-1.*

---

## 2. Strategy: Trust Score Array
## *2. Chiến lược: Mảng Điểm Tin cậy*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Array:** Create an array `trustScores` of size `N + 1`. (Base 1 index).
    *   **Khởi tạo mảng:** Mảng `trustScores` đếm điểm.*

2.  **Process Edges:** Loop through the `trust` array.
    - For `[a, b]`:
      - `trustScores[a]--` (Person `a` trusts someone, lose 1 point)
      - `trustScores[b]++` (Person `b` is trusted, gain 1 point)
    *   **Xử lý cạnh:** Trừ điểm người giao phiếu bầu, cộng điểm người nhận.*

3.  **Find Judge:** Loop from `1` to `N`:
    - If `trustScores[i] == N - 1`, return `i`.
    *   **Tìm Thẩm phán:** Người có điểm N-1 chính là Thẩm phán.*

4.  **Fallback:** If loop finishes without returning, return `-1`.
    *   **Trường hợp không có:** Trả về `-1`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int findJudge(int n, int[][] trust) {
        // If there's only 1 person and no one to trust, they are the judge.
        if (n == 1 && trust.length == 0) return 1;
        
        // Array to keep track of net trust score
        int[] trustScores = new int[n + 1];
        
        for (int[] t : trust) {
            trustScores[t[0]]--; // loses trust score because they trust someone
            trustScores[t[1]]++; // gains trust score because they are trusted
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(T + N)$, where $T$ is the length of `trust` array and $N$ is the number of people. We loop through `trust` once and then from `1` to `N`.
    *   **Độ phức tạp thời gian:** $O(T + N)$.*
*   **Space Complexity:** $O(N)$ for the `trustScores` array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a single array to track net degrees is the most optimal and concise way to solve this directed graph problem.
*Sử dụng một mảng duy nhất để theo dõi bậc ròng là cách tối ưu và súc tích nhất để giải quyết bài toán đồ thị có hướng này.*

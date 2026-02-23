# Analysis for Jump Game
# *Phân tích cho bài toán Trò Chơi Nhảy*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`. *Mảng `nums`.*
*   **Output:** Boolean. *Giá trị Boolean.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $10^4$. $O(n)$ time complexity is expected.
*   *Độ dài lên tới $10^4$. Độ phức tạp thời gian $O(n)$ được mong đợi.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Greedy (Maintain Max Reach)
### *Hướng tiếp cận: Tham Lam (Duy Trì Tầm Xa Tối Đa)*

*   **Intuition:** At each step, update the farthest index we can reach. If our current position exceeds the farthest reachable index, we cannot progress further.
*   *Ý tưởng: Tại mỗi bước, hãy cập nhật chỉ số xa nhất mà chúng ta có thể đạt tới. Nếu vị trí hiện tại của chúng ta vượt quá chỉ số xa nhất có thể đạt tới, chúng ta không thể tiến xa hơn.*

*   **Algorithm Steps:**
    1.  Initialize `reachable = 0`.
    2.  Iterate through `nums` with index `i`:
        *   If `i > reachable`, return `false`.
        *   Update `reachable = max(reachable, i + nums[i])`.
        *   If `reachable >= nums.length - 1`, return `true`.
    3.  Return `true`.

*   **Complexity:**
    *   Time: $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums = [2, 3, 1, 1, 4]`
- `i=0`: reachable=max(0, 0+2)=2.
- `i=1`: reachable=max(2, 1+3)=4.
- `reachable >= 4` -> True.

`nums = [3, 2, 1, 0, 4]`
- `i=0`: reachable=3.
- `i=1`: reachable=max(3, 1+2)=3.
- `i=2`: reachable=max(3, 2+1)=3.
- `i=3`: reachable=max(3, 3+0)=3.
- `i=4`: `i > reachable` (4 > 3). False.
---
This greedy approach is efficient and covers all cases.
*Cách tiếp cận tham lam này hiệu quả và bao quát tất cả các trường hợp.*

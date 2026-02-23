# Analysis for Permutations
# *Phân tích cho bài toán Hoán Vị*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of unique integers `nums`. *Mảng các số nguyên duy nhất `nums`.*
*   **Output:** List of all possible permutations. *Danh sách tất cả các hoán vị có thể.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `nums.length` is very small (up to 6).
*   Number of permutations is $n!$. For $n=6$, it is 720.
*   *Độ dài của `nums` rất nhỏ (lên tới 6).*
*   *Số lượng hoán vị là $n!$. Với $n=6$, nó là 720.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** We can build permutations step by step. At each step, we choose an unused number from the input array and move to the next step.
*   *Ý tưởng: Chúng ta có thể xây dựng các hoán vị từng bước. Tại mỗi bước, chúng ta chọn một số chưa được sử dụng từ mảng đầu vào và chuyển sang bước tiếp theo.*

*   **Algorithm Steps:**
    1.  Maintain a `used` boolean array or a set to keep track of numbers already in the current permutation.
    2.  `backtrack(currentPermutation)`:
        *   If `currentPermutation.size == nums.size`: add a copy to results.
        *   For each `num` in `nums`:
            *   If `num` is not used:
                *   Mark `num` as used.
                *   Add `num` to `currentPermutation`.
                *   `backtrack(...)`.
                *   Backtrack: remove `num` and mark as unused.

*   **Complexity:**
    *   Time: $O(n \cdot n!)$ where $n!$ is the number of permutations and $n$ is the work to copy each permutation.
    *   Space: $O(n)$ for the recursion stack and `used` array.

### Dry Run
### *Chạy thử*
`nums = [1, 2]`
1.  Empty `[]`.
2.  Choose 1: `[1]`.
    *   Choose 2: `[1, 2]`. Result: `[[1, 2]]`.
3.  Backtrack to `[]`.
4.  Choose 2: `[2]`.
    *   Choose 1: `[2, 1]`. Result: `[[1, 2], [2, 1]]`.
Done.

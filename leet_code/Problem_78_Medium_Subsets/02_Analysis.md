# Analysis for Subsets
# *Phân tích cho bài toán Tập Con*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of unique integers. *Mảng các số nguyên duy nhất.*
*   **Output:** List of all possible subsets (power set). *Danh sách tất cả các tập con có thể (tập lũy thừa).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 10. Total subsets: $2^{10} = 1024$.
*   All elements are unique.
*   *Độ dài lên tới 10. Tổng số tập con: $2^{10} = 1024$.*
*   *Tất cả các phần tử là duy nhất.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (Cascading)
### *Hướng tiếp cận: Quay lui (Xếp tầng)*

*   **Intuition:** For each element, we have two choices: include it in the subset or not. This creates a decision tree.
*   *Ý tưởng: Đối với mỗi phần tử, chúng ta có hai lựa chọn: đưa nó vào tập con hoặc không. Điều này tạo ra một cây quyết định.*

*   **Algorithm Steps:**
    1.  Initialize a result list starting with an empty subset `[[]]`.
    2.  Iterate through each number in `nums`:
        *   Take all existing subsets in the result list.
        *   Create new subsets by Adding the current number to each existing one.
        *   Add These new subsets back to the result list.

*   **Complexity:**
    *   Time: $O(N \cdot 2^N)$.
    *   Space: $O(N \cdot 2^N)$ for the result.

### Dry Run
### *Chạy thử*
`nums = [1, 2, 3]`
1. Start: `[[]]`
2. Add 1: `[[], [1]]`
3. Add 2: `[[], [1], [2], [1, 2]]`
4. Add 3: `[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]`
Done.
---
*Số lượng tập con của một tập hợp có n phần tử luôn là $2^n$.*
The number of subsets of a set with n elements is always $2^n$.

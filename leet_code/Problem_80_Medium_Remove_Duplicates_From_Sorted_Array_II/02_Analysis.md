# Analysis for Remove Duplicates from Sorted Array II
# *Phân tích cho bài toán Loại Bỏ Phần Tử Trùng Lặp II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted array with duplicates. *Mảng đã sắp xếp có các phần tử trùng lặp.*
*   **Output:** Length of the array up to which each element appears at most twice. *Độ dài của mảng mà tại đó mỗi phần tử xuất hiện tối đa hai lần.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $3 \cdot 10^4$. $O(N)$ time complexity.
*   In-place modification, $O(1)$ extra space.
*   *Độ dài lên tới $3 \cdot 10^4$. Độ phức tạp thời gian $O(N)$.*
*   *Sửa đổi tại chỗ, không gian bổ sung $O(1)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers
### *Hướng tiếp cận: Hai con trỏ*

*   **Intuition:** Since the array is sorted, duplicates are adjacent. We can maintain a pointer `k` which represents the position to place the next valid element. For each element `num` in the array, if it's one of the first two elements or if it's different from the element at `k-2`, it's valid to be included.
*   *Ý tưởng: Vì mảng đã được sắp xếp, các phần tử trùng lặp sẽ nằm cạnh nhau. Chúng ta có thể duy trì một con trỏ `k` đại diện cho vị trí để đặt phần tử hợp lệ tiếp theo. Đối với mỗi phần tử `num` trong mảng, nếu nó là một trong hai phần tử đầu tiên hoặc nếu nó khác với phần tử tại `k-2`, nó là hợp lệ để được đưa vào.*

*   **Algorithm Steps:**
    1.  If `nums.length <= 2`, return its length.
    2.  `k = 2`.
    3.  Iterate `i` from 2 to `nums.length - 1`:
        *   If `nums[i] != nums[k-2]`:
            *   `nums[k] = nums[i]`.
            *   `k++`.
    4.  Return `k`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums = [1,1,1,2,2,3]`
1. `k = 2`. `i` starts from 2.
2. `i = 2`: `nums[2] = 1`. `nums[k-2] = nums[0] = 1`. Equal. Skip.
3. `i = 3`: `nums[3] = 2`. `nums[k-2] = nums[0] = 1`. Not equal.
   - `nums[k] = nums[2] = 2`. `k = 3`. Array: `[1, 1, 2, 2, 2, 3]`.
4. `i = 4`: `nums[4] = 2`. `nums[k-2] = nums[1] = 1`. Not equal.
   - `nums[k] = nums[3] = 2`. `k = 4`. Array: `[1, 1, 2, 2, 2, 3]`.
5. `i = 5`: `nums[5] = 3`. `nums[k-2] = nums[2] = 2`. Not equal.
   - `nums[k] = nums[4] = 3`. `k = 5`.
Result: 5.
---
*Việc so sánh với phần tử tại vị trí k-2 là điểm mấu chốt để giới hạn số lần xuất hiện là 2.*
Comparing with the element at index k-2 is the key point to limit the frequency to 2.

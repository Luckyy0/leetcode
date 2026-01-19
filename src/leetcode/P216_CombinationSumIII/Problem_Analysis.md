# 216. Combination Sum III / Tổng Tổ Hợp III

## Problem Description / Mô tả bài toán
Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:
Tìm tất cả các tổ hợp hợp lệ của `k` số có tổng bằng `n` sao cho các điều kiện sau đây là đúng:

- Only numbers `1` through `9` are used.
- Chỉ các số từ `1` đến `9` được sử dụng.
- Each number is used **at most once**.
- Mỗi số được sử dụng **tối đa một lần**.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
Trả về danh sách tất cả các tổ hợp hợp lệ có thể. Danh sách không được chứa cùng một tổ hợp hai lần, và các tổ hợp có thể được trả về theo bất kỳ thứ tự nào.

### Example 1:
```text
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation: 1 + 2 + 4 = 7. There are no other valid combinations.
```

### Example 2:
```text
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation: 
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
```

### Example 3:
```text
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations. 
Using 4 different numbers in the range [1,9], the smallest sum is 1+2+3+4 = 10.
```

## Constraints / Ràng buộc
- `2 <= k <= 9`
- `1 <= n <= 60`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking / Quay lui
This is a standard combination problem where we select `k` distinct numbers from the set `{1, 2, ..., 9}`.
Đây là một bài toán tổ hợp tiêu chuẩn nơi chúng ta chọn `k` số khác nhau từ tập hợp `{1, 2, ..., 9}`.

**State**: `backtrack(start, count, currentSum, path)`
- `start`: The smallest number we can pick next (to avoid duplicates and ensure distinctness).
- `count`: How many numbers we have picked so far.
- `currentSum`: The sum of numbers picked so far.
- `path`: The current list of numbers.

**Base Cases**:
- If `count == k`:
    - If `currentSum == n`: Add `path` to results.
    - Return.
- If `currentSum > n` or `count > k`: Prune (return).

**Recursive Step**:
- Loop `i` from `start` to `9`.
- Add `i` to path.
- Recurse: `backtrack(i + 1, count + 1, currentSum + i, path)`.
- Backtrack: Remove `i` from path.

---

## Analysis / Phân tích

### Approach: Backtracking

**Complexity / Độ phức tạp**:
- **Time**: C(9, k). Since k is small (<= 9), this is very fast. The max combinations is C(9, 4) or C(9, 5) which is 126.
- **Space**: O(k) for recursion stack and path storage.

---

## Edge Cases / Các trường hợp biên
1.  **Impossible Sum**: `k=3, n=1`. Min sum is `1+2+3=6`. returns empty.
2.  **Sum too large**: `k=3, n=30`. Max sum is `9+8+7=24`. returns empty.
3.  **k=9**: Only one combination `1..9` summing to 45.

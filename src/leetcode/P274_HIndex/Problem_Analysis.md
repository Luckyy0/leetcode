# 274. H-Index / Chỉ Số H

## Problem Description / Mô tả bài toán
Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their `i-th` paper, return the researcher's h-index.
Cho một mảng các số nguyên `citations` trong đó `citations[i]` là số lượng trích dẫn mà một nhà nghiên cứu nhận được cho bài báo thứ `i` của họ, hãy trả về chỉ số h (h-index) của nhà nghiên cứu đó.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.
Theo định nghĩa về chỉ số h trên Wikipedia: Chỉ số h được định nghĩa là giá trị tối đa của `h` sao cho nhà nghiên cứu đã xuất bản ít nhất `h` bài báo mà mỗi bài được trích dẫn ít nhất `h` lần.

### Example 1:
```text
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
```

### Example 2:
```text
Input: citations = [1,3,1]
Output: 1
```

## Constraints / Ràng buộc
- `n == citations.length`
- `1 <= n <= 5000`
- `0 <= citations[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sorting Approach / Tiếp Cận Sắp Xếp
1.  Sort citations in **ascending** order.
2.  Iterate from index `i` (0 to `n-1`).
    - The number of papers with at least `citations[i]` citations is `n - i`.
    - `h` is the max value where `count >= value`.
    - If `citations[i] >= n - i`, then `n - i` is a valid H. We want the max such H.
    - Specifically, if we check from left to right, the first time `citations[i] >= n - i`, it means `n - i` works.
    - Example `[0, 1, 3, 5, 6]`. N=5.
    - `i=0, val=0`. Pap>=0: 5. 0 < 5.
    - `i=1, val=1`. Pap>=1: 4. 1 < 4.
    - `i=2, val=3`. Pap>=3: 3. 3 >= 3. -> H=3.
    - `i=3, val=5`. Pap>=5: 2. 5 > 2. (Valid pap count is 2, but val is 5. Limited by pap count. Max is 2).
    - We take `min(val, count)`? No.
    - The condition is `h` papers have `>= h` citations.
    - At `i=2`, we have 3 papers `>= 3`. So 3 is valid.
    - At `i=1` (value 1), we have 4 papers `>= 1`. So 1 is valid. But 3 > 1.
    - So we maximize. Logic: `Math.max(currentH, min(citations[i], n-i))`.
    - Actually simpler: Iterate `i` from `0` to `n-1`. The value `h = n - i` represents "h papers". If `citations[i] >= h`, then we found the largest set of `h` papers satisfying condition (because left of `i`, count is larger but value is smaller).

### Counting Sort Approach (Bucket) / Tiếp Cận Đếm (Bucket)
Since `h` is at most `N`, any citation count > `N` can be treated as `N`.
1.  Create `buckets` array size `N + 1`.
2.  For each `c` in `citations`:
    - `buckets[min(c, N)]++`.
3.  Iterate `k` from `N` down to `0`. Accumulate `count += buckets[k]`.
    - `count` is the number of papers with `>= k` citations.
    - If `count >= k`: return `k`.
4.  This is O(N).

---

## Analysis / Phân tích

### Approach: Bucket Sort (O(N))

**Algorithm**:
1.  `n = citations.length`.
2.  `buckets` size `n + 1`.
3.  Fill buckets.
4.  Scan backwards.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **[0]**: N=1. buckets[0]=1. Scan `k=1`, count=0 < 1. `k=0`, count=1 >= 0. Return 0.
2.  **[100]**: N=1. buckets[1]=1. Scan `k=1`, count=1 >= 1. Return 1.

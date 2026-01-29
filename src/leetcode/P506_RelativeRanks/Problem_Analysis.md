# 506. Relative Ranks / Xếp Hạng Tương Đối

## Problem Description / Mô tả bài toán
You are given an integer array `score` of size `n`, where `score[i]` is the score of the `i-th` athlete in a competition. All the scores are guaranteed to be **unique**.
Bạn được cho một mảng số nguyên `score` kích thước `n`, trong đó `score[i]` là điểm số của vận động viên thứ `i` trong một cuộc thi. Tất cả các điểm số được đảm bảo là **không trùng lặp**.

The athletes are placed based on their scores, where the `1st` place athlete has the highest score, the `2nd` place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
Các vận động viên được xếp hạng dựa trên điểm số của họ, trong đó vận động viên đứng thứ `1` có điểm cao nhất, vận động viên đứng thứ `2` có điểm cao thứ nhì, và cứ tiếp tục như vậy. Thứ hạng của mỗi vận động viên xác định giải thưởng của họ:

- The `1st` place athlete's rank is `"Gold Medal"`.
- The `2nd` place athlete's rank is `"Silver Medal"`.
- The `3rd` place athlete's rank is `"Bronze Medal"`.
- For the `4th` to `n-th` place athletes, their rank is their placement number (i.e., `"4"`, `"5"`, ..., `"n"`).

Return an array `answer` of size `n` where `answer[i]` is the rank of the `i-th` athlete.
Hãy trả về một mảng `answer` kích thước `n`, trong đó `answer[i]` là thứ hạng của vận động viên thứ `i`.

### Example 1:
```text
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
```

### Example 2:
```text
Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
```

## Constraints / Ràng buộc
- `n == score.length`
- `1 <= n <= 10^4`
- `0 <= score[i] <= 10^6`
- All the scores are **unique**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting Indices / Sắp xếp chỉ số
We need to sort the scores while keeping track of the original indices to map the ranks back.

Algorithm:
1. Create a list of indices `[0, 1, ..., n-1]`.
2. Sort these indices based on the values in `score` in **descending** order.
3. Iterate through the sorted indices:
   - The first index gets `"Gold Medal"`.
   - The second index gets `"Silver Medal"`.
   - The third index gets `"Bronze Medal"`.
   - The rest get their rank as a string.
4. Return the result array.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(N) to store indices and the result.

---

## Analysis / Phân tích

### Approach: Value-to-Rank Mapping

**Algorithm**:
1.  Store (score, index) pairs.
2.  Sort pairs by score descending.
3.  Assign rank strings based on sorted position.
4.  Re-align to original order.

---

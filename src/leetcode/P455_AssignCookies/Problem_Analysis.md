# 455. Assign Cookies / Phân Chia Bánh Quy

## Problem Description / Mô tả bài toán
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
Giả sử bạn là một bậc cha mẹ tuyệt vời và muốn chia bánh quy cho các con. Tuy nhiên, mỗi đứa trẻ chỉ được nhận tối đa một bản bánh quy.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with; and each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign the cookie `j` to the child `i`, and the child `i` will be content. Your goal is to maximize the number of your content children and output the maximum number.
Mỗi đứa trẻ `i` có một mức độ "tham ăn" `g[i]`, đó là kích thước tối thiểu của một chiếc bánh quy mà đứa trẻ đó sẽ hài lòng; và mỗi chiếc bánh quy `j` có một kích thước `s[j]`. Nếu `s[j] >= g[i]`, chúng ta có thể chia chiếc bánh quy `j` cho đứa trẻ `i`, và đứa trẻ đó sẽ hài lòng. Mục tiêu của bạn là tối đa hóa số lượng trẻ em hài lòng.

### Example 1:
```text
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You should output 1.
```

### Example 2:
```text
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You should output 2.
```

## Constraints / Ràng buộc
- `1 <= g.length <= 3 * 10^4`
- `0 <= s.length <= 3 * 10^4`
- `1 <= g[i], s[j] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Strategy / Chiến lược Tham lam
To maximize the number of content children, we should always satisfy the child with the **least greed factor** using the **smallest suitable cookie**.

Algorithm:
1. Sort both the greed factors `g` and the cookie sizes `s` in non-decreasing order.
2. Maintain two pointers: `child = 0` and `cookie = 0`.
3. While `child < g.length` and `cookie < s.length`:
   - If `s[cookie] >= g[child]`:
     - This child is content. Increment `child`.
   - Always increment `cookie` whether the current child was satisfied or not (because if a cookie is too small for the current child, it will surely be too small for the next child with even higher greed).
4. Return `child`.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M log M) due to sorting both arrays.
- **Space**: O(log N) or O(log M) for sorting.

---

## Analysis / Phân tích

### Approach: Two-Pointer Greedy Matching

**Algorithm**:
1.  Sort parameters.
2.  Iterate to match.
3.  Count matches.

---

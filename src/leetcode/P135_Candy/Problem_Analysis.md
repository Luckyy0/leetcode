# 135. Candy / Kẹo

## Problem Description / Mô tả bài toán
There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.
Có `n` đứa trẻ đang đứng thành một hàng. Mỗi đứa trẻ được chỉ định một giá trị đánh giá được đưa ra trong mảng số nguyên `ratings`.

You are giving candies to these children subjected to the following requirements:
Bạn đang phát kẹo cho những đứa trẻ này theo các yêu cầu sau:

- Each child must have at least one candy.
- Mỗi đứa trẻ phải có ít nhất một viên kẹo.
- Children with a higher rating get more candies than their neighbors.
- Những đứa trẻ có đánh giá cao hơn sẽ nhận được nhiều kẹo hơn so với những đứa trẻ hàng xóm của chúng.

Return the minimum number of candies you need to have to distribute the candies to the children.
Trả về số lượng kẹo tối thiểu bạn cần có để phân phát cho các đứa trẻ.

### Example 1:
```text
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
```

### Example 2:
```text
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
```

## Constraints / Ràng buộc
- `n == ratings.length`
- `1 <= n <= 2 * 10^4`
- `0 <= ratings[i] <= 2 * 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Two-Pass Strategy / Chiến lược Tham lam Hai Lượt
The core idea is to handle the dependencies of children with their left neighbors and right neighbors separately.
Ý tưởng chính là xử lý sự phụ thuộc của trẻ em với hàng xóm bên trái và hàng xóm bên phải một cách riêng biệt.

1.  **Left-to-Right Pass**: Ensure that a child with a higher rating than their left neighbor gets more candies.
    `if ratings[i] > ratings[i-1], count[i] = count[i-1] + 1`
2.  **Right-to-Left Pass**: Ensure that a child with a higher rating than their right neighbor gets more candies.
    `if ratings[i] > ratings[i+1], count[i] = max(count[i], count[i+1] + 1)`

By taking the maximum of the two constraints, we satisfy both conditions with the minimum possible number of candies.

---

## Analysis / Phân tích

### Approach: Two-Pass Greedy / Tham lam Hai Lượt

**Algorithm**:
1.  Initialize an array `candies` of size `n` with all `1`s.
2.  Traverse from `1` to `n-1`:
    - If `ratings[i] > ratings[i-1]`, `candies[i] = candies[i-1] + 1`.
3.  Traverse from `n-2` to `0`:
    - If `ratings[i] > ratings[i+1]`, `candies[i] = max(candies[i], candies[i+1] + 1)`.
4.  Return the sum of the `candies` array.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - two linear traversals.
- **Space**: O(N) - to store the candies array. (Can be O(1) if we use a more complex logic, but O(N) is standard and clear).

---

## Edge Cases / Các trường hợp biên
1.  **Ratings are equal**: Neighbors with equal ratings don't need to have more kẹo.
2.  **Ratings strictly increasing/decreasing**: Handled by the two passes.
3.  **Zig-zag ratings**: Handled by the `max` logic in the second pass.

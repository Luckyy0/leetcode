# 638. Shopping Offers / Ưu Đãi Mua Sắm

## Problem Description / Mô tả bài toán
In LeetCode Store, there are `n` items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
Tại Cửa hàng LeetCode, có `n` mặt hàng để bán. Mỗi mặt hàng có một mức giá. Tuy nhiên, có một số ưu đãi đặc biệt và ưu đãi đặc biệt bao gồm một hoặc nhiều loại mặt hàng khác nhau với giá ưu đãi.

You are given an integer array `price` where `price[i]` is the price of the `i-th` item, and an integer array `needs` where `needs[i]` is the number of pieces of the `i-th` item you want to buy.
Bạn được cho một mảng số nguyên `price` trong đó `price[i]` là giá của mặt hàng thứ `i`, và một mảng số nguyên `needs` trong đó `needs[i]` là số lượng mặt hàng thứ `i` bạn muốn mua.

You are also given an array `special` where `special[i]` is of size `n + 1` representing the `i-th` special offer: `special[i][j]` is the number of pieces of the `j-th` item in the offer and `special[i][n]` is the price of the offer.
Bạn cũng được cho một mảng `special` trong đó `special[i]` có kích thước `n + 1` đại diện cho ưu đãi đặc biệt thứ `i`: `special[i][j]` là số lượng mặt hàng thứ `j` trong ưu đãi và `special[i][n]` là giá của ưu đãi.

Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You can use any offer multiple times.
Trả về mức giá thấp nhất bạn phải trả cho chính xác các mặt hàng nhất định như đã cho, nơi bạn có thể sử dụng tối ưu các ưu đãi đặc biệt. Bạn không được phép mua nhiều mặt hàng hơn bạn muốn, ngay cả khi điều đó sẽ làm giảm giá chung. Bạn có thể sử dụng bất kỳ ưu đãi nào nhiều lần.

### Example 1:
```text
Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Memoization / Backtracking / DFS với Ghi Nhớ / Quay Lui
State: `needs` array.
Base case: `needs` all zero -> cost 0.
Transitions:
1. Buy items individually (Direct dot product `price * needs`). This is a baseline upper bound.
2. Try applying each special offer.
   Condition: Offer must not cause `needs` to go negative.
   If valid, `newNeeds = needs - offerItems`, `cost = offerPrice + dfs(newNeeds)`.
   Minimize cost.

Memoization: `Map<List<Integer>, Integer> map` stores min cost for a given needs state.

### Complexity / Độ phức tạp
- **Time**: depends on state space. Usually small N (max 6 items) allows DFS.
- **Space**: O(States) for recursion and memo.

---

## Analysis / Phân tích

### Approach: Recursive DFS with Memo

**Algorithm**:
1.  Define a recursive function `solve(needs)`.
2.  Calculate baseline cost without offers.
3.  Iterate through offers.
4.  If offer valid, recurse and update min cost.
5.  Use HashMap to memoize results keyed by `needs`.

---

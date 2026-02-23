# Result for Random Pick with Weight
# *Kết quả cho bài toán Chọn Ngẫu nhiên theo Trọng số*

## Description
## *Mô tả*

You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `i^th` index.
*Bạn được cho một mảng số nguyên dương **có chỉ số bắt đầu từ 0** `w`, trong đó `w[i]` mô tả **trọng số** của chỉ số thứ `i`.*

You need to implement the function `pickIndex()`, which randomly picks an index in the range `[0, w.length - 1]` (inclusive) and returns it. The probability of picking an index `i` is `w[i] / sum(w)`.
*Bạn cần triển khai hàm `pickIndex()`, hàm này chọn ngẫu nhiên một chỉ số trong khoảng `[0, w.length - 1]` (bao gồm cả hai đầu mút) và trả về nó. Xác suất chọn chỉ số `i` là `w[i] / sum(w)`.*

For example, if `w = [1, 3]`, the probability of picking index `0` is `1 / (1 + 3) = 0.25` (i.e., 25%), and the probability of picking index `1` is `3 / (1 + 3) = 0.75` (i.e., 75%).
*Ví dụ, nếu `w = [1, 3]`, xác suất chọn chỉ số `0` là `1 / (1 + 3) = 0.25` (tức là 25%), và xác suất chọn chỉ số `1` là `3 / (1 + 3) = 0.75` (tức là 75%).*

## Example 1:
## *Ví dụ 1:*

**Input**
`["Solution","pickIndex"]`
`[[[1]],[]]`
**Output**
`[null,0]`
**Explanation**
`Solution solution = new Solution([1]);`
`solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element.`

## Example 2:
## *Ví dụ 2:*

**Input**
`["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]`
`[[[1,3]],[],[],[],[],[]]`
**Output**
`[null,1,1,1,1,0]`
**Explanation**
`Solution solution = new Solution([1, 3]);`
`solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.`
`solution.pickIndex(); // return 1`
`solution.pickIndex(); // return 1`
`solution.pickIndex(); // return 1`
`solution.pickIndex(); // return 0. It's returning the first element (index = 0) that has probability of 1/4.`

Since this is a randomization problem, multiple answers are allowed.

## Constraints:
## *Ràng buộc:*

*   `1 <= w.length <= 10^4`
*   `1 <= w[i] <= 10^5`
*   `pickIndex` will be called at most `10^4` times.

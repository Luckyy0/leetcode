# Result for Soup Servings
# *Kết quả cho bài toán Phục vụ Súp*

## Description
## *Mô tả*

There are two types of soup: **type A** and **type B**. Initially, we have `n` ml of each type of soup. There are four kinds of operations:
1.  Serve `100` ml of **soup A** and `0` ml of **soup B**.
2.  Serve `75` ml of **soup A** and `25` ml of **soup B**.
3.  Serve `50` ml of **soup A** and `50` ml of **soup B**.
4.  Serve `25` ml of **soup A** and `75` ml of **soup B**.

*Có hai loại súp: loại A và loại B. Ban đầu có `n` ml mỗi loại. Có 4 loại phép phục vụ với liều lượng sụp A-B lần lượt là: (100-0), (75-25), (50-50), (25-75).*

When we serve some amount of soup, and the amount of soup remaining is less than the amount required, we use all the remaining amount of that type of soup. Each operation has an equal probability of `0.25`.
*Khi phục vụ, nếu lượng súp còn lại ít hơn yêu cầu, ta dùng hết phần còn lại đó. Mỗi phép toán có xác suất bằng nhau là 0.25.*

Return *the probability that **soup A** will be empty first, plus half the probability that **soup A** and **soup B** become empty at the same time*. Answers within `10^-5` of the actual answer will be accepted.
*Trả về *xác suất súp A hết trước, cộng với nửa xác suất súp A và B hết cùng lúc*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 50
**Output:** 0.62500
**Explanation:** If we choose each of the four operations with probability 0.25, our possible outcomes are:
- Serve (100, 0): Soup A becomes empty first.
- Serve (75, 25): Soup A becomes empty first.
- Serve (50, 50): Soup A and B become empty at the same time.
- Serve (25, 75): Soup B becomes empty first.
So the probability is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= n <= 10^9`

# Result for Fruit Into Baskets
# *Kết quả cho bài toán Trái cây và Giỏ*

## Description
## *Mô tả*

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the **type** of fruit the `i`-th tree produces.
*Bạn đang đến thăm một trang trại có một hàng cây ăn quả duy nhất được sắp xếp từ trái sang phải. Các cây được đại diện bởi một mảng số nguyên `fruits` trong đó `fruits[i]` là **loại** trái cây mà cây thứ `i` sản xuất.*

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
*Bạn muốn thu thập càng nhiều trái cây càng tốt. Tuy nhiên, chủ trang trại có một số quy tắc nghiêm ngặt mà bạn phải tuân theo:*

*   You only have **two** baskets, and each basket can only hold a **single type** of fruit. There is no limit on the amount of fruit each basket can hold.
    *   *Bạn chỉ có **hai** giỏ, và mỗi giỏ chỉ có thể chứa một **loại** trái cây duy nhất. Không có giới hạn về lượng trái cây mỗi giỏ có thể chứa.*
*   Starting from any tree of your choice, you must pick **exactly one fruit** from **every** tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
    *   *Bắt đầu từ bất kỳ cây nào bạn chọn, bạn phải hái **chính xác một quả** từ **mọi** cây (bao gồm cả cây bắt đầu) trong khi di chuyển sang phải. Trái cây đã hái phải vừa với một trong các giỏ của bạn.*
*   Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
    *   *Khi bạn đến một cây có trái cây không thể chứa trong giỏ của bạn, bạn phải dừng lại.*

Given the integer array `fruits`, return *the maximum number of fruits you can pick*.
*Cho mảng số nguyên `fruits`, hãy trả về *số lượng trái cây tối đa bạn có thể hái*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** fruits = [1,2,1]
**Output:** 3
**Explanation:** We can pick from all 3 trees.

## Example 2:
## *Ví dụ 2:*

**Input:** fruits = [0,1,2,2]
**Output:** 3
**Explanation:** We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick [0,1].

## Example 3:
## *Ví dụ 3:*

**Input:** fruits = [1,2,3,2,2]
**Output:** 4
**Explanation:** We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick [1,2].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= fruits.length <= 10^5`
*   `0 <= fruits[i] < fruits.length`

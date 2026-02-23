# Result for Shopping Offers
# *Kết quả cho bài toán Ưu đãi Mua sắm*

## Description
## *Mô tả*

In LeetCode Store, there are `n` items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
*Trong Cửa hàng LeetCode, có `n` mặt hàng để bán. Mỗi mặt hàng có một mức giá. Tuy nhiên, có một số ưu đãi đặc biệt (special offers), và một ưu đãi đặc biệt bao gồm một hoặc nhiều loại mặt hàng khác nhau với giá khuyến mãi.*

You are given an integer array `price` where `price[i]` is the price of the `i`-th item, and an integer array `needs` where `needs[i]` is the number of `i`-th items you need to buy.
*Bạn được cho một mảng số nguyên `price` trong đó `price[i]` là giá của mặt hàng thứ `i`, và một mảng số nguyên `needs` trong đó `needs[i]` là số lượng mặt hàng thứ `i` bạn cần mua.*

You are also given a 2D integer array `special` where `special[i]` is of the form `[n1, n2, ..., nn, price]` which means the `i`-th special offer can sell `n1` items of the 1st kind, `n2` items of the 2nd kind, ..., and `nn` items of the `n`-th kind at the price of `price`.
*Bạn cũng được cho một mảng số nguyên 2 chiều `special` trong đó `special[i]` có dạng `[n1, n2, ..., nn, price]`, có nghĩa là ưu đãi đặc biệt thứ `i` có thể bán `n1` mặt hàng loại 1, `n2` mặt hàng loại 2, ..., và `nn` mặt hàng loại `n` với mức giá `price`.*

You are **not allowed** to buy more items than you need even if the special offer has a lower price. Return the lowest price you have to pay for **exactly** such a list of needs.
*Bạn **không được phép** mua nhiều mặt hàng hơn mức bạn cần ngay cả khi ưu đãi đặc biệt có giá thấp hơn. Hãy trả về mức giá thấp nhất bạn phải trả cho **chính xác** danh sách nhu cầu đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
**Output:** 14
**Explanation:** 
There are two kinds of items, A and B. Their prices are 2 and 5 respectively. 
In special offer 1, you can buy 3 of A and 0 of B at the price 5. 
In special offer 2, you can buy 1 of A and 2 of B at the price 10. 
You need to buy 3 of A and 2 of B. 
One way of buying is to use special offer 1 and then buy 0 of A and 2 of B separately. 
So cost = 5 + 2*5 = 15.
Another way of buying is to buy 3 of A and 2 of B yesterday, cost = 3*2 + 2*5 = 16.
Wait, let's look for a better one...
Buy 1 of A and 2 of B using special offer 2, and then buy 2 of A separately.
Cost = 10 + 2*2 = 14.
Total lowest cost = 14.

## Example 2:
## *Ví dụ 2:*

**Input:** price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
**Output:** 11
**Explanation:** The lowest price is to buy 1 item A, 1 item B and 1 item C for the price of 2+2*3+4 = 12.
Wait, if we use offer [1,1,0,4], we get 1A, 1B for 4. Then we need 1B, 1C extra for 3+4=7. Total = 11.

---

## Constraints:
## *Ràng buộc:*

*   `n == price.length == needs.length`
*   `1 <= n <= 6`
*   `0 <= price[i], needs[i] <= 10`
*   `1 <= special.length <= 100`
*   `special[i].length == n + 1`
*   `0 <= special[i][j] <= 50`

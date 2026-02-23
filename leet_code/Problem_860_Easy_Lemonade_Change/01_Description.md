# Result for Lemonade Change
# *Kết quả cho bài toán Đổi tiền Chanh*

## Description
## *Mô tả*

At a lemonade stand, each lemonade costs `$5`. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or `$20` bill. You must provide the correct change to each customer so that the net transaction is that the customer pays `$5`.
*Tại một quầy bán nước chanh, mỗi cốc nước chanh có giá `$5`. Khách hàng đang đứng thành một hàng đợi để mua nước và gọi từng người một (theo thứ tự được chỉ định bởi bills). Mỗi khách hàng sẽ chỉ mua một cốc nước chanh và thanh toán bằng tờ `$5`, `$10` hoặc `$20`. Bạn phải cung cấp tiền lẻ chính xác cho mỗi khách hàng sao cho giao dịch ròng là khách hàng trả `$5`.*

Note that you do not have any change in hand at first.
*Lưu ý rằng ban đầu bạn không có bất kỳ đồng tiền lẻ nào trong tay.*

Given an integer array `bills` where `bills[i]` is the bill the `i`-th customer pays, return `true` *if you can provide every customer with the correct change, or `false` otherwise*.
*Cho một mảng số nguyên `bills`, trong đó `bills[i]` là tờ tiền mà khách hàng thứ `i` trả, hãy trả về `true` *nếu bạn có thể cung cấp cho mọi khách hàng số tiền lẻ chính xác, ngược lại trả về `false`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** bills = [5,5,5,10,20]
**Output:** true
**Explanation:** 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5 bill.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

## Example 2:
## *Ví dụ 2:*

**Input:** bills = [5,5,10,10,20]
**Output:** false
**Explanation:** 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= bills.length <= 10^5`
*   `bills[i]` is either `5`, `10`, or `20`.

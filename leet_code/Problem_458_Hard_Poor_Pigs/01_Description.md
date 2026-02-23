# Result for Poor Pigs
# *Kết quả cho bài toán Những con lợn Đáng thương*

## Description
## *Mô tả*

There are `buckets` buckets of liquid, where **exactly one** of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have `minutesToTest` minutes to determine which bucket is poisonous, and you have to wait `minutesToDie` minutes to see if a pig dies after drinking any specific bucket's liquid.
*Có `buckets` xô chứa chất lỏng, trong đó **đúng một** xô là có độc. Để tìm ra xô nào có độc, bạn cho một số lượng lợn nhất định uống chất lỏng để xem chúng có chết hay không. Thật không may, bạn chỉ có `minutesToTest` phút để xác định xô nào có độc, và bạn phải đợi `minutesToDie` phút để xem lợn có chết sau khi uống chất lỏng từ một xô cụ thể hay không.*

Follow these steps:
1. Choose some live pigs to feed.
2. For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time. Each bucket can be fed to any number of pigs, and each pig can be fed from any number of buckets.
3. Wait for `minutesToDie` minutes. You may not feed any other pigs during this time.
4. After `minutesToDie` minutes have passed, any pigs that drank the poison will die, and all others will survive.
5. Repeat this process until you run out of time.

Given `buckets`, `minutesToDie`, and `minutesToTest`, return *the **minimum** number of pigs needed to figure out which bucket is poisonous within the allotted time*.
*Cho `buckets`, `minutesToDie`, và `minutesToTest`, hãy trả về *số lượng lợn **tối thiểu** cần thiết để tìm ra xô nào có độc trong thời gian cho phép*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `buckets = 4, minutesToDie = 15, minutesToTest = 15`
**Output:** `2`
**Explanation:** 
- Test 1: Feed pig 1 buckets 1 and 2. Feed pig 2 buckets 1 and 3.
- If both die, bucket 1 is poison.
- If only pig 1 dies, bucket 2 is poison.
- If only pig 2 dies, bucket 3 is poison.
- If neither dies, bucket 4 is poison.

## Example 2:
## *Ví dụ 2:*

**Input:** `buckets = 4, minutesToDie = 15, minutesToTest = 30`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   `1 <= buckets <= 1000`
*   `1 <= minutesToDie <= minutesToTest <= 1000`

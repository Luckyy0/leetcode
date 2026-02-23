# Result for Knight Dialer
# *Kết quả cho bài toán Quay số Mã tuần*

## Description
## *Mô tả*

The chess knight has a **unique movement**, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an **L**). The possible movements of chess knight are shown in this diagram:
*Mã trong cờ vua có **nước đi độc đáo**, nó có thể di chuyển hai ô theo chiều dọc và một ô theo chiều ngang, hoặc hai ô theo chiều ngang và một ô theo chiều dọc (cả hai đều tạo thành hình chữ **L**). Các bước di chuyển có thể của mã được hiển thị trong sơ đồ này:*

A chess knight can move as indicated in the chess diagram below:
*Một con mã cờ vua có thể di chuyển như chỉ dẫn trong sơ đồ cờ vua dưới đây:*

```
1 2 3
4 5 6
7 8 9
  0
```

We have a chess knight and a phone pad as shown above, the knight can only stand on a numeric cell (i.e. blue cell).
*Chúng ta có một con mã cờ vua và một bàn phím điện thoại như hình trên, con mã chỉ có thể đứng trên một ô số (tức là ô màu xanh).*

Given an integer `n`, return how many distinct phone numbers of length `n` we can dial.
*Cho một số nguyên `n`, hãy trả về có bao nhiêu số điện thoại riêng biệt có độ dài `n` mà chúng ta có thể quay.*

You are allowed to place the knight on any numeric cell initially and then you should perform `n - 1` jumps to dial a number of length `n`. All jumps should be valid knight jumps.
*Bạn được phép đặt con mã lên bất kỳ ô số nào ban đầu và sau đó bạn nên thực hiện `n - 1` lần nhảy để quay một số có độ dài `n`. Tất cả các bước nhảy phải là bước nhảy hợp lệ của mã.*

As the answer may be very large, return the answer **modulo** `10^9 + 7`.
*Vì câu trả lời có thể rất lớn, hãy trả về câu trả lời **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 1
**Output:** 10
**Explanation:** We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2
**Output:** 20
**Explanation:** All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]

## Example 3:
## *Ví dụ 3:*

**Input:** n = 3131
**Output:** 136006598
**Explanation:** Please take care of the mod.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 5000`

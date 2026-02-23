# Result for Number of 1 Bits
# *Kết quả cho bài toán Số lượng Bit 1*

## Description
## *Mô tả*

Write a function that takes the binary representation of a positive integer and returns the number of set bits it has (also known as the [Hamming weight](http://en.wikipedia.org/wiki/Hamming_weight)).
*Viết một hàm nhận vào biểu diễn nhị phân của một số nguyên dương và trả về số lượng bit đã đặt (bit 1) của nó (còn được gọi là [Trọng số Hamming](http://en.wikipedia.org/wiki/Hamming_weight)).*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 11`
**Output:** `3`
**Explanation:** The input binary string `00000000000000000000000000001011` has a total of three set bits.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 128`
**Output:** `1`
**Explanation:** The input binary string `00000000000000000000000010000000` has a total of one set bit.

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 2147483645`
**Output:** `30`
**Explanation:** The input binary string `11111111111111111111111111111101` has a total of thirty set bits.

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2^31 - 1`

**Follow up:** If this function is called many times, how would you optimize it?
**Câu hỏi mở rộng:** Nếu hàm này được gọi nhiều lần, bạn sẽ tối ưu hóa nó như thế nào?

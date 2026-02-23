# Result for Reverse Bits
# *Kết quả cho bài toán Đảo ngược Bit*

## Description
## *Mô tả*

Reverse the bits of a given 32-bit unsigned integer.
*Đảo ngược các bit của một số nguyên không dấu 32-bit đã cho.*

**Note:**
*   Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
    *Lưu ý rằng trong một số ngôn ngữ, chẳng hạn như Java, không có kiểu số nguyên không dấu. Trong trường hợp này, cả đầu vào và đầu ra sẽ được đưa ra dưới dạng kiểu số nguyên có dấu. Chúng không ảnh hưởng đến việc triển khai của bạn, vì biểu diễn nhị phân bên trong của số nguyên là giống nhau, cho dù nó có dấu hay không dấu.*
*   In Java, the compiler represents the signed integers using **2's complement** notation. Therefore, in Example 1, the input represents the signed integer `-3` and the output represents the signed integer `-1073741825`.
    *Trong Java, trình biên dịch biểu diễn các số nguyên có dấu bằng ký hiệu **bù 2**. Do đó, trong Ví dụ 1, đầu vào đại diện cho số nguyên có dấu `-3` và đầu ra đại diện cho số nguyên có dấu `-1073741825`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 00000010100101000001111010011100`
**Output:** `964176192 (00111001011110000010100101000000)`
**Explanation:** The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 11111111111111111111111111111101`
**Output:** `3221225471 (10111111111111111111111111111111)`
**Explanation:** The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

## Constraints:
## *Ràng buộc:*

*   The input must be a **binary string** of length `32`.

**Follow up:** If this function is called many times, how would you optimize it?
**Câu hỏi mở rộng:** Nếu hàm này được gọi nhiều lần, bạn sẽ tối ưu hóa nó như thế nào?

# Result for Distribute Candies
# *Kết quả cho bài toán Phân chia Kẹo*

## Description
## *Mô tả*

Alice has `n` candies, where the `i`-th candy is of type `candyType[i]`. Alice noticed that she started to gain weight, so she visited a doctor.
*Alice có `n` viên kẹo, trong đó viên kẹo thứ `i` thuộc loại `candyType[i]`. Alice nhận thấy mình bắt đầu tăng cân, vì vậy cô đã đi khám bác sĩ.*

The doctor advised Alice to only eat `n / 2` of the candies she has (`n` is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
*Bác sĩ khuyên Alice chỉ nên ăn `n / 2` số kẹo cô có (`n` luôn là số chẵn). Alice rất thích kẹo của mình và cô muốn ăn số lượng loại kẹo khác nhau tối đa trong khi vẫn tuân theo lời khuyên của bác sĩ.*

Given the integer array `candyType` of length `n`, return the **maximum number** of different types of candies she can eat if she only eats `n / 2` of them.
*Cho mảng số nguyên `candyType` có độ dài `n`, hãy trả về **số lượng tối đa** các loại kẹo khác nhau mà cô ấy có thể ăn nếu cô ấy chỉ ăn `n / 2` trong số chúng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** candyType = [1,1,2,2,3,3]
**Output:** 3
**Explanation:** Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
*Giải thích: Alice chỉ có thể ăn 6 / 2 = 3 viên kẹo. Vì chỉ có 3 loại, cô ấy có thể ăn mỗi loại một viên.*

---

## Constraints:
## *Ràng buộc:*

*   `n == candyType.length`
*   `2 <= n <= 104`
*   `n` is even.
*   `-105 <= candyType[i] <= 105`

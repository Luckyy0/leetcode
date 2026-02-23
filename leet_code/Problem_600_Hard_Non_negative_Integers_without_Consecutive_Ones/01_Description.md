# Result for Non-negative Integers without Consecutive Ones
# *Kết quả cho bài toán Số nguyên Không âm không có Hai chữ số 1 Liên tiếp*

## Description
## *Mô tả*

Given a positive integer `n`, return the number of the non-negative integers less than or equal to `n`, whose binary representations do not contain consecutive ones.
*Cho một số nguyên dương `n`, hãy trả về số lượng các số nguyên không âm nhỏ hơn hoặc bằng `n` mà biểu diễn nhị phân của chúng không chứa hai chữ số một liên tiếp.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 5
**Output:** 5
**Explanation:** 
Here are the non-negative integers <= 5:
0 : 0
1 : 1
2 : 10
3 : 11 (contains consecutive ones)
4 : 100
5 : 101
So, the non-negative integers <= 5 without consecutive ones are 0, 1, 2, 4, 5. The answer is 5.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** n = 2
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 109`

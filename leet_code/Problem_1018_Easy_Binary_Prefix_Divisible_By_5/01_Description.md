# Result for Binary Prefix Divisible By 5
# *Kết quả cho bài toán Tiền tố nhị phân chia hết cho 5*

## Description
## *Mô tả*

You are given a binary array `nums` (an array containing only `0`s and `1`s).
*Bạn được cung cấp một mảng nhị phân `nums` (một mảng chỉ chứa các số `0` và `1`).*

We define `xi` as the number whose binary representation is the subarray `nums[0..i]` (from most-significant-bit to least-significant-bit).
*Chúng ta định nghĩa `xi` là số mà biểu diễn nhị phân của nó chính là mảng con `nums[0..i]` (tính từ bit có nghĩa cao nhất đến bit có nghĩa thấp nhất).*

*   For example, if `nums = [1,0,1]`, then `x0 = 1`, `x1 = 2`, and `x2 = 5`.
    *   *Ví dụ, nếu `nums = [1,0,1]`, thì `x0 = 1`, `x1 = 2`, và `x2 = 5`.*

Return *an array of booleans* `answer` *where* `answer[i]` *is* `true` *if* `xi` *is divisible by* `5`.
*Trả về một mảng booleans `answer` trong đó `answer[i]` là `true` nếu `xi` chia hết cho `5`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [0,1,1]
**Output:** [true,false,false]
**Explanation:** 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.
*Giải thích: Các số được tạo ra ở dạng nhị phân là 0, 01, 011; đổi ra cơ số 10 là 0, 1 và 3. Chỉ có số đầu tiên (0) chia hết cho 5, vì thế answer[0] là true.*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,1,1]
**Output:** [false,false,false]
**Explanation:** 
The input numbers in binary are 1, 11, 111; which are 1, 3, and 7 in base-10.
None of them are divisible by 5.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `nums[i]` is either `0` or `1`.

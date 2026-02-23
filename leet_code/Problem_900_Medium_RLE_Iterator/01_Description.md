# Result for RLE Iterator
# *Kết quả cho bài toán Trình lặp Mã hóa Độ dài Chạy*

## Description
## *Mô tả*

We can use run-length encoding (RLE) to encode a sequence of integers. In a run-length encoded array of even length `encoding`, for all even `i`, `encoding[i]` tells us the number of times that the non-negative integer value `encoding[i + 1]` is repeated in the sequence.
*Chúng ta có thể sử dụng mã hóa độ dài chạy (RLE) để mã hóa một chuỗi các số nguyên. Trong một mảng mã hóa độ dài chạy có độ dài chẵn `encoding`, đối với tất cả các `i` chẵn, `encoding[i]` cho chúng ta biết số lần mà giá trị số nguyên không âm `encoding[i + 1]` được lặp lại trong chuỗi.*

-   For example, the sequence `[8,8,8,5,5]` can be encoded as `encoding = [3,8,2,5]`. `encoding = [3,8,0,9,2,5]` and `encoding = [2,8,1,8,2,5]` are also valid RLE of that sequence.
    *Ví dụ, chuỗi `[8,8,8,5,5]` có thể được mã hóa thành `encoding = [3,8,2,5]`. `encoding = [3,8,0,9,2,5]` và `encoding = [2,8,1,8,2,5]` cũng là các RLE hợp lệ của chuỗi đó.*

Given a run-length encoded array, design an iterator that iterates through it.
*Cho một mảng mã hóa độ dài chạy, hãy thiết kế một trình lặp (iterator) duyệt qua nó.*

Implement the `RLEIterator` class:
*Triển khai lớp `RLEIterator`:*

-   `RLEIterator(int[] encoding)` Initializes the object with the encoded array `encoding`.
    *`RLEIterator(int[] encoding)` Khởi tạo đối tượng với mảng mã hóa `encoding`.*
-   `int next(int n)` Exhausts the next `n` elements and returns the last element exhausted in this way. If there is no element left to exhaust, return `-1`.
    *`int next(int n)` Tiêu thụ `n` phần tử tiếp theo và trả về phần tử cuối cùng được tiêu thụ theo cách này. Nếu không còn phần tử nào để tiêu thụ, trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["RLEIterator", "next", "next", "next", "next"]
[[[3, 8, 0, 9, 2, 5]], [2], [1], [1], [2]]
**Output:** [null, 8, 8, 5, -1]
**Explanation:** 
RLEIterator rLEIterator = new RLEIterator([3, 8, 0, 9, 2, 5]); // This maps to the sequence [8,8,8,5,5].
rLEIterator.next(2); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is [8,5,5].
rLEIterator.next(1); // exhausts 1 term of the sequence, returning 8. The remaining sequence is [5,5].
rLEIterator.next(1); // exhausts 1 term of the sequence, returning 5. The remaining sequence is [5].
rLEIterator.next(2); // exhausts 2 terms, but only 1 term is available. Returns -1.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= encoding.length <= 1000`
*   `encoding.length` is even.
*   `0 <= encoding[i] <= 10^9`
*   `1 <= n <= 10^9`
*   At most `1000` calls will be made to `next`.

# Result for Pancake Sorting
# *Kết quả cho bài toán Sắp xếp Bánh kếp*

## Description
## *Mô tả*

Given an array of integers `arr`, sort the array performing a series of **pancake flips**.
*Cho một mảng các số nguyên `arr`, hãy sắp xếp mảng bằng cách thực hiện một loạt các **cú lật bánh kếp**.*

In one pancake flip we do the following steps:
*Trong một lần lật bánh kếp, chúng ta thực hiện các bước sau:*

*   Choose an integer `k` where `1 <= k <= arr.length`.
    *   *Chọn một số nguyên `k` sao cho `1 <= k <= arr.length`.*
*   Reverse the sub-array `arr[0...k-1]` (0-indexed).
    *   *Đảo ngược mảng con `arr[0...k-1]` (chỉ số bắt đầu từ 0).*

For example, if `arr = [3,2,1,4]` and we performed a pancake flip choosing `k = 3`, we reverse the sub-array `[3,2,1]`, so `arr` changes to `[1,2,3,4]`.
*Ví dụ, nếu `arr = [3,2,1,4]` và chúng ta thực hiện một cú lật bánh kếp chọn `k = 3`, chúng ta đảo ngược mảng con `[3,2,1]`, do đó `arr` thay đổi thành `[1,2,3,4]`.*

Return *an array of the* `k`*-values corresponding to a sequence of pancake flips that sort* `arr`. Any valid answer that sorts the array within `10 * arr.length` flips will be judged as correct.
*Trả về *một mảng các giá trị* `k` *tương ứng với một chuỗi các cú lật bánh kếp giúp sắp xếp* `arr`. Bất kỳ câu trả lời hợp lệ nào sắp xếp mảng trong vòng `10 * arr.length` lần lật sẽ được coi là đúng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [3,2,4,1]
**Output:** [4,2,4,3]
**Explanation:** 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After k=4: arr = [1, 4, 2, 3]
After k=2: arr = [4, 1, 2, 3]
After k=4: arr = [3, 2, 1, 4]
After k=3: arr = [1, 2, 3, 4], which is sorted.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,2,3]
**Output:** []
**Explanation:** The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 100`
*   `1 <= arr[i] <= arr.length`
*   All integers in `arr` are unique (i.e. `arr` is a permutation of the integers from `1` to `arr.length`).

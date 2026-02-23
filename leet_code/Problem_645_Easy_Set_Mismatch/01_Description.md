# Result for Set Mismatch
# *Kết quả cho bài toán Tập hợp Sai lệch*

## Description
## *Mô tả*

You have a set of integers `nums`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `nums` was duplicated to another number in the set, which results in **repetition of one number** and **loss of another number**.
*Bạn có một tập hợp các số nguyên `nums`, ban đầu chứa tất cả các số từ `1` đến `n`. Thật không may, do một số lỗi, một trong các số trong `nums` đã bị trùng lặp sang một số khác trong tập hợp, dẫn đến việc **lặp lại một số** và **mất một số khác**.*

You are given an integer array `nums` representing the data status of this set after the error.
*Bạn được cho một mảng số nguyên `nums` đại diện cho trạng thái dữ liệu của tập hợp này sau khi xảy ra lỗi.*

Find the number that occurs twice and the number that is missing and return them in the form of an array.
*Hãy tìm số xuất hiện hai lần và số bị thiếu, sau đó trả về chúng dưới dạng một mảng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,2,4]
**Output:** [2,3]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,1]
**Output:** [1,2]

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 10^4`
*   `1 <= nums[i] <= 10^4`

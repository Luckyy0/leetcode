# Result for Remove Element
# *Kết quả cho bài toán Xóa Phần Tử*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` **in-place**. The order of the elements may be changed. Then return the number of elements in `nums` which are not equal to `val`.
*Cho một mảng số nguyên `nums` và một số nguyên `val`, hãy xóa tất cả các lần xuất hiện của `val` trong `nums` **tại chỗ**. Thứ tự của các phần tử có thể bị thay đổi. Sau đó trả về số lượng phần tử trong `nums` không bằng `val`.*

Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:
*Gọi số lượng phần tử trong `nums` không bằng `val` là `k`, để được chấp nhận, bạn cần làm những việc sau:*

1.  Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
    *Thay đổi mảng `nums` sao cho `k` phần tử đầu tiên của `nums` chứa các phần tử không bằng `val`. Các phần tử còn lại của `nums` không quan trọng cũng như kích thước của `nums`.*
2.  Return `k`.
    *Trả về `k`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,2,2,3]`, `val = 3`
**Output:** `2`, `nums = [2,2,_,_]`
**Explanation:** Your function should return k = 2, with the first two elements of nums being 2.
***Giải thích:** Hàm của bạn nên trả về k = 2, với hai phần tử đầu tiên của nums là 2.*

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,1,2,2,3,0,4,2]`, `val = 2`
**Output:** `5`, `nums = [0,1,4,0,3,_,_,_]`
**Explanation:** Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
***Giải thích:** Hàm của bạn nên trả về k = 5, với năm phần tử đầu tiên của nums chứa 0, 0, 1, 3, và 4.*

## Constraints:
## *Ràng buộc:*

*   `0 <= nums.length <= 100`
*   `0 <= nums[i] <= 50`
*   `0 <= val <= 100`

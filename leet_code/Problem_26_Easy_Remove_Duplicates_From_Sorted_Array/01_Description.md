# Result for Remove Duplicates from Sorted Array
# *Kết quả cho bài toán Xóa Các Phần Tử Trùng Lặp khỏi Mảng Đã Sắp Xếp*

## Description
## *Mô tả*

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only **once**. The relative order of the elements should be kept the **same**.
*Cho một mảng số nguyên `nums` được sắp xếp theo **thứ tự không giảm**, hãy xóa các phần tử trùng lặp **tại chỗ** sao cho mỗi phần tử duy nhất chỉ xuất hiện **một lần**. Thứ tự tương đối của các phần tử nên được giữ **nguyên**.*

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.
*Vì không thể thay đổi độ dài của mảng trong một số ngôn ngữ, bạn phải đặt kết quả vào **phần đầu** của mảng `nums`. Cụ thể hơn, nếu có `k` phần tử sau khi xóa các phần tử trùng lặp, thì `k` phần tử đầu tiên của `nums` sẽ chứa kết quả cuối cùng. Không quan trọng bạn để lại những gì sau `k` phần tử đầu tiên.*

Return `k` after placing the final result in the first `k` slots of `nums`.
*Trả về `k` sau khi đặt kết quả cuối cùng vào `k` vị trí đầu tiên của `nums`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,1,2]`
**Output:** `2`, `nums = [1,2,_]`
**Explanation:** Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
***Giải thích:** Hàm của bạn nên trả về k = 2, với hai phần tử đầu tiên của nums lần lượt là 1 và 2.*

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`
**Output:** `5`, `nums = [0,1,2,3,4,_,_,_,_,_]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 3 * 10^4`
*   `-100 <= nums[i] <= 100`
*   `nums` is sorted in **non-decreasing** order.
    *`nums` được sắp xếp theo thứ tự **không giảm**.*

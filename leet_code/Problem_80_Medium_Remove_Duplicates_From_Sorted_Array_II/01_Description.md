# Result for Remove Duplicates from Sorted Array II
# *Kết quả cho bài toán Loại Bỏ Phần Tử Trùng Lặp II*

## Description
## *Mô tả*

Given an integer array `nums` sorted in **non-decreasing order**, remove some duplicates **in-place** such that each unique element appears **at most twice**. The **relative order** of the elements should be kept the same.
*Cho một mảng số nguyên `nums` được sắp xếp theo **thứ tự không giảm**, hãy loại bỏ một số phần tử trùng lặp **tại chỗ** sao cho mỗi phần tử duy nhất xuất hiện **tối đa hai lần**. **Thứ tự tương đối** của các phần tử nên được giữ nguyên.*

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.
*Vì không thể thay đổi độ dài của mảng trong một số ngôn ngữ, thay vào đó bạn phải đặt kết quả vào **phần đầu tiên** của mảng `nums`. Chính thức hơn, nếu có `k` phần tử sau khi loại bỏ các phần tử trùng lặp, thì `k` phần tử đầu tiên của `nums` sẽ chứa kết quả cuối cùng. Việc bạn để gì sau `k` phần tử đầu tiên không quan trọng.*

Return `k` *after placing the final result in the first `k` slots of `nums`*.
*Trả về `k` *sau khi đặt kết quả cuối cùng vào `k` ô đầu tiên của `nums`***.*

Do **not** allocate extra space for another array. You must do this by **modifying the input array in-place** with O(1) extra memory.
*KHÔNG** cấp phát thêm không gian cho một mảng khác. Bạn phải thực hiện việc này bằng cách **sửa đổi mảng đầu vào tại chỗ** với bộ nhớ bổ sung O(1).*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,1,1,2,2,3]`
**Output:** `5, nums = [1,1,2,2,3,_]`
**Explanation:** Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [0,0,1,1,1,1,2,3,3]`
**Output:** `7, nums = [0,0,1,1,2,3,3,_,_]`
**Explanation:** Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 3 * 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `nums` is sorted in **non-decreasing order**.

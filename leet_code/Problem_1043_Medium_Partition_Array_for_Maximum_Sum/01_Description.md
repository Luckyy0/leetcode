# Partition Array for Maximum Sum
# *Phân tách mảng để Tổng Lớn nhất*

## Description
## *Mô tả*

Given an integer array `arr`, partition the array into (contiguous) subarrays of length at most `k`. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
*Cho một mảng các số nguyên `arr`. Phân tách (chia cắt) mảng này thành các mảng con (nằm liên tiếp đứng cạnh nhau) với độ dài của mỗi mảng con tối đa là `k`. Sau khi băm tỏi chia cắt xong, đặc quyền của mỗi mảng con là tất cả các phần tử bên trong nó được hô biến "thay hình đổi dạng" thành Cục Giá trị Lớn nhất (Max) lọt thỏm trong không gian riêng của mảng con đó.*

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
*Hãy vắt kiệt và trả về TổNG KHỔNG LỒ NHẤT toàn mảng đạt được sau khi chia chác như trên. Những bộ thử Test Cases được đảm bảo sao cho Kết Quả Tối Thượng nằm trọn gọn không nứt vỡ trong ranh giới kiểu số nguyên 32-bit (`int`).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [1,15,7,9,2,5,10], k = 3
**Output:** 84
**Explanation:** 
*Giải thích:*
The array creatively partitions into [1,15,7], [9], [2,5,10].
*Mảng bị Chặt Dao băm làm 3 khúc: [1, 15, 7], Khúc hai [9], Khúc ba [2, 5, 10]. Lưu ý không Khúc nào dài quá k=3!*
Then each piece balloons to its local leader's value -> [15,15,15] + [9] + [10,10,10].
*Tới lượt Bơm Thuốc Kích Thích! Mỗi khúc chọn đứa Béo Nhất bắt cả nhà nở theo Dáng Nó: Khúc 1 Béo nhất 15 thành [15, 15, 15]. Khúc 2 đơn độc [9]. Khúc 3 béo nhất 10 nổ ra [10, 10, 10].*
Total sum: 15+15+15+9+10+10+10 = 84.
*Móc đít cộng rốn lại: TỔNG VÀNG = 84.*

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
**Output:** 83

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [1], k = 1
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 500`
*   `0 <= arr[i] <= 10^9`
*   `1 <= k <= arr.length`

# Missing Element in Sorted Array
# *Phần Tử Bị Thiếu Trong Mảng Đã Sắp Xếp*

## Description
## *Mô tả*

**NOTE**: This is a LeetCode Premium problem.
**LƯU Ý:** Đây là một bài toán được liệt kê trong danh sách Độc Quyền (Premium) của hệ thống LeetCode.

Given a strictly increasing array `nums` of uniquely sorted integers and a positive integer `k`, return the `kth` missing number starting from the leftmost number of the array.
*Bạn được nhận một mảng số nguyên `nums` có tổ chức cực kỳ nề nếp (được sắp xếp sẵn Căng Cứng Tăng Dần Nghiêm Ngặt, cam đoan các số đều Độc Nhất vô nhị, không đụng hàng). Kèm theo đó là một lá bùa Khát Vọng mang tên số nguyên dương `k`.*
*Điều Mệnh: Mọi dãy số Tự Nhiên Khép Kín vốn Phải Chạy Dọc Điền Liên Tiếp Từng con Vạch Số. Nhưng Dãy Này Ở Ruột Rỗng Trống Rỗng Mất Vài Khúc Chữ Số Thất Lạc Nào Đó (Bị Nhảy Cóc, Hỏng Mắt Xích). Bổn Phận Của Cậu là Khởi hành đi bằng đôi chân điểm Dấu Bắt Đầu Bám Chặt Từ Cái Móng Số (Tức phần tử Ngoài Nhất Bên Trái mảng `nums[0]`) và Đếm So... Bắt Chết ra Bằng Được Con Số "THẤT LẠC" Bị Bỏ Quên Nằm Ở Vị Trí THỨ `k` (k-th).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,7,9,10], k = 1
**Output:** 5
**Explanation:** 
*Giải thích:*
The missing numbers are [5,6,8,...], hence the 1st missing number is 5.
*Điểm Khởi Hành Trái Cùng Là Số `4`. Càng Chạy Thì Lộ Ra Bầy Nhện Bị Rơi Khỏi Ánh Mắt Tuyến Tính là các Hố Tối `[5, 6, 8, ...]`. Mệnh lệnh Vớt Số Thiếu Hụt Chết Yểu TẠI Vị Trí Đầu Tiên `k = 1`. Đáp Án Dính Chắc Gọi Tên: Số Thiếu Khất 5.*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [4,7,9,10], k = 3
**Output:** 8
**Explanation:** 
*Giải thích:*
The missing numbers are [5,6,8,...], hence the 3rd missing number is 8.
*Từ Nguồn Vết Nứt `[5, 6, 8, 11, ...]`. Mục tiêu Đào Bới Số Thất Tung Xếp Hạng Bi Lạc Mép Vị Trí Thứ 3 `k = 3`. Số Trượt Cửa 3 Đang Báo Bắt là Cái Gương Mặt: 8.*

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1,2,4], k = 3
**Output:** 6
**Explanation:** 
*Giải thích:*
The missing numbers are [3,5,6,7,...], hence the 3rd missing number is 6.
*Cuộn Giáp Dây Chuyền `nums = [1, 2, 4]`. Khởi Vạch 1. Kho Hạt Đứt Rớt Nằm Tơi Bời Dưới Bàn `[3, 5, 6, 7, 8...]`. Tầm Cầu Nắm Mệnh Hồn Rụng Khúc Mép `k = 3`. Nhắm So Gạch Nổi: Điểm Rơi Kẹp Khóa Thứ 3 Trúng Chỉ: 6.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 50000`
*   `1 <= nums[i] <= 10^7`
*   `nums` is sorted in strictly increasing order.
*   `1 <= k <= 10^8`

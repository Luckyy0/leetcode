# Previous Permutation With One Exchange
# *Hoán Vị Liền Trước Chỉ Với Một Lần Đổi Chỗ*

## Description
## *Mô tả*

Given an array of positive integers `arr` (not necessarily distinct), return the **lexicographically largest permutation** that is strictly smaller than `arr`, that can be made with **exactly one swap** of two elements. If it cannot be done, then return the same array.
*Cho một mảng lưu trữ các số nguyên dương `arr` (không nhất thiết phải là các số khác biệt nhau). Nhiệm vụ của bạn là hãy trả về một mảng chứa **hoán vị sắp xếp lớn nhất theo thứ tự từ điển** thỏa mãn điều kiện NÓ PHẢI NHỎ HƠN NGHIÊM NGẶT mảng gốc `arr`, với một ràng buộc khắc nghiệt: Bạn CHỈ ĐƯỢC PHÉP thực hiện **chính xác 1 Lần Tráo Đổi vị trí** (Swap) của 2 phần tử bất kỳ. Nếu tình thế bế tắc không thể tạo ra mảng nào nhỏ hơn nữa, thì hãy ngậm ngùi trả về y chang mảng gốc ban đầu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [3,2,1]
**Output:** [3,1,2]
**Explanation:** 
*Giải thích:*
Swapping 2 and 1.
*Bốc tráo vị trí của số 2 (ở index 1) và số 1 (ở index 2). Mảng thành [3,1,2]. Mảng này là mảng liền kề nhỏ hơn [3,2,1].*

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,1,5]
**Output:** [1,1,5]
**Explanation:** 
*Giải thích:*
This is already the smallest permutation.
*Mảng này vốn dĩ đã là hoán vị đực xếp nhỏ bé nhất có thể rồi [1,1,5]. Không có cách nào swap 1 phát mà khiến nó thụt lùi nhỏ hơn được nữa. Lệnh vô hiệu, trả về nguyên xi.*

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [1,9,4,6,7]
**Output:** [1,7,4,6,9]
**Explanation:** 
*Giải thích:*
Swapping 9 and 7.
*Ta lôi cổ hai phần tử số 9 (đang nắm index 1) và phần tử số 7 (góc index 4) tráo đổi chỗ cho nhau. Mảng biến hình thành [1,7,4,6,9], vừa khéo lọt chuẩn yêu cầu!*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 10^4`
*   `1 <= arr[i] <= 10^4`

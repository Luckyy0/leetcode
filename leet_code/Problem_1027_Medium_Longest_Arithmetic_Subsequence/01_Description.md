# Result for Longest Arithmetic Subsequence
# *Kết quả cho bài toán Chuỗi con Dãy Số Học Dài Nhất*

## Description
## *Mô tả*

Given an array `nums` of integers, return *the length of the longest arithmetic subsequence in* `nums`.
*Cho một mảng các số nguyên `nums`, hãy trả về độ dài của **chuỗi con** cấp số cộng (dãy số học) dài nhất tồn tại bên trong `nums`.*

**Note** that:
*Lưu ý rằng:*
*   A **subsequence** is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
    *   *Một chuỗi con (subsequence) là mảng nhận được nhờ vào việc xóa đi một vài phần tử (kể cả không xóa) từ mảng ban đầu, nhưng KHÔNG ĐƯỢC PHÉP TRÁO ĐỔI thứ tự của những người sống sót.*
*   A sequence `seq` is arithmetic if `seq[i + 1] - seq[i]` are all the same value (for `0 <= i < seq.length - 1`).
    *   *Một danh sách `seq` được vinh danh là **Dãy cấp số cộng** (số học) nếu khoảng cách hiệu số `seq[i + 1] - seq[i]` luôn đóng đinh một con số (tức là Bước nhảy Công Sai d đồng đều, không được lúc chẵn lúc lẻ).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [3,6,9,12]
**Output:** 4
**Explanation:**  The whole array is an arithmetic sequence with steps of length = 3.
*Giải thích: Điểm xuất phát từ 3 nhảy lên 6 (+3), từ 6 nhảy vọt lên 9 (+3), cắn rốn nhảy tới 12 (+3). Toàn bộ mảng dài 4 tụ họp thành dãy số học tuyệt trần Công sai 3!*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [9,4,7,2,10]
**Output:** 3
**Explanation:**  The longest arithmetic subsequence is [4,7,10].
*Giải thích: Ta cấu véo lấy chọn 3 nhân vật: 4, 7, và 10. Khoảng cách cố định $+3$. Chú ý ta vứt bỏ 9 và 2. Chuỗi con mập nhất có chiều dài 3 khối ngọc.*

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [20,1,15,3,10,5,8]
**Output:** 4
**Explanation:**  The longest arithmetic subsequence is [20,15,10,5].
*Giải thích: Lần này chọn dãy Nhảy Giật lùi! Từ 20 tuột xuống 15 (-5), rơi xuống 10 (-5), và nằm úp mặt ở 5 (-5). Quãng đường dài 4 trạm. Bước âm hoàn toàn hợp lệ trong cấp số cộng.*

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 1000`
*   `0 <= nums[i] <= 500`

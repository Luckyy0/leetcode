# Result for Uncrossed Lines
# *Kết quả bài toán Những Đường Thẳng Không Cắt Nhau*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2`. We write the integers of `nums1` and `nums2` (in the order they are given) on two separate horizontal lines.
*Bạn được cung cấp hai mảng số nguyên `nums1` và `nums2`. Giả sử chúng ta viết các con số của `nums1` và `nums2` (nằm y xì tuần tự như thứ tự mảng nạp vào) lên hai đường kẻ ngang tách biệt nằm song song với nhau.*

We may draw connecting lines: a straight line connecting two numbers `nums1[i]` and `nums2[j]` such that:
*Chúng ta được phép cầm bút kẻ các đường nối thẳng thớm: Một đường thẳng dính kết hai con số `nums1[i]` (nằm hàng trên) với `nums2[j]` (nằm hàng dưới) với điều kiện tiên quyết:*
*   `nums1[i] == nums2[j]`, and
    *- Cặp số nằm hai đầu mút của đường thẳng kẻ BẮT BUỘC PHẢI GIỐNG NHAU Y HỆT.*
*   the line we draw does not intersect any other connecting (non-horizontal) line.
    *- Đường thẳng chúng ta vừa phóng qua KHÔNG YẾU KÉM BẬ BẸ ĐÂM CẮT CHEO LÉO PHÁ BỈNH qua bất kỳ một đường nối non yếu nào khác đã kẻ trước đó! (Tóm lại: Các đường kẻ không được phép giao cắt chéo cánh nhau)*

Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
*Xin khắc cốt ghi tâm: Hai đường dây KHÔNG ĐƯỢC PHÉP CHẠM CHÁP GIAO NHAU dù chỉ là chung đụng Ở HAI ĐẦU MÚT CHẤM (Điều này ám chỉ: Một con số MẢNH GHÉP bất kì chỉ có đặc quyền trung thành Thuộc Về ĐÚNG MỘT SỢI DÂY KẾT NỐI DUY NHẤT. Cấm bắt cá hai tay).*

Return *the maximum number of connecting lines we can draw in this way*.
*Yêu cầu báo cáo: Trả về **SỐ LƯỢNG ĐƯỜNG KẺ NỐI NHIỀU NHẤT (CỰC ĐẠI)** mà chúng ta có khả năng chăng ra được một cách hoàn mĩ dựa trên các định luật ràng buộc ngặt nghèo trên.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums1 = [1,4,2], nums2 = [1,2,4]
**Output:** 2
**Explanation:** We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2] = 2 to nums2[1] = 2.
*Giải thích: Hàng trên [1, 4, 2], Hàng dưới [1, 2, 4].*
*Chúng ta có thể vẽ tối đa 2 đường Nối Không Giao Cắt (Ví dụ nối 1-1 thẳng đứng và nối 4-4 chéo thẳng hoạc 2-2).*
*Chúng ta không thiết nào dệt được 3 sợi. Vì nếu cố chấp Nối Thằng 4 (vị trí 1 hàng trên) với thằng 4 (vị trí 2 hàng dưới), sợi dây đó SẼ ĐỤNG ĐỨT CHÉO CÁNH NÁT BÉT với sợi nối Thằng 2 (vị trí 2 hàng trên) chạy thấu sang thằng 2 (vị trí 1 hàng dưới).*

## Example 2:
## *Ví dụ 2:*

**Input:** nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
**Output:** 3
*Giải thích: Vắt sỏi 3 đường đàng hoàng.*

## Example 3:
## *Ví dụ 3:*

**Input:** nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
**Output:** 2
*Giải thích: Đường cắm được 2 phát an toàn.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums1.length, nums2.length <= 500`
*   `1 <= nums1[i], nums2[j] <= 2000`

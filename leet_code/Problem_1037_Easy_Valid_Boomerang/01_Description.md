# Result for Valid Boomerang
# *Kết quả bài toán Boomerang Hợp Lệ*

## Description
## *Mô tả*

Given an array `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane, return `true` if these points are a **boomerang**.
*Bạn được cung cấp một mảng `points` chứa đúng 3 phần tử, trong đó mỗi `points[i] = [xi, yi]` đại diện cho một tọa độ điểm chấm trên mặt phẳng trục tọa độ X-Y (hệ tọa độ Descartes). Hãy trả về cờ `true` nếu và chỉ nếu 3 điểm này ghép nối lại tạo thành một cái **Chiếc Boomerang** (Chiếc phi tiêu săn bắn cong vút của thổ dân).*

A boomerang is a set of three points that are all distinct and not in a straight line.
***Định nghĩa sấm truyền về Boomerang Hợp Lệ:** Một cái Boomerang chính hiệu phải là một tập hợp gồm đúng ba điểm thỏa mãn HAI điều kiện sống còn:*
*1. Tất cả 3 điểm phải hoàn toàn ĐỘC LẬP TÁCH RỜI nhau (Không có điểm nào bị trùng tọa độ đè lên điểm khác).*
*2. Ba điểm này tuyệt đối KHÔNG ĐƯỢC PHÉP xếp hàng nằm thẳng đuột trên cùng một đường thẳng (tức là không thẳng hàng).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** points = [[1,1],[2,3],[3,2]]
**Output:** true
*Giải thích: Điểm thứ nhất (1,1), điểm thứ hai (2,3), điểm thứ ba (3,2). Vẽ lên giấy: Tụi này lệch qua lệch lại tạo thành một hình tam giác ngoằn ngoèo! 3 điểm khác nhau, và không đống đinh trên 1 đường thẳng. Là Boomerang Rõ Cạp Thật!*

## Example 2:
## *Ví dụ 2:*

**Input:** points = [[1,1],[2,2],[3,3]]
**Output:** false
*Giải thích: Đưa (1,1), (2,2) và (3,3). Trời đất! Cắm ba cái chấm này lên trục tọa độ, lấy cây thước kẽ phát là Xuyên Táo Gắn Cả 3 điểm Chết Định trên Trục Tọa Độ nghiêng góc 45 độ (Đường chéo Thẳng tắp). Ba điểm đè chung MỘT ĐƯỜNG THẲNG! Phi Boomerang Thẳng Tưng Thế Giết Gió Nào Bay Về? -> Sai Bét (False).*

---

## Constraints:
## *Ràng buộc:*

*   `points.length == 3` *(Mảng có Cứng đét Rập Khuôn Đúng 3 Toạ Độ Đứng chặng).*
*   `points[i].length == 2` *(Khung Không gian 2 Chiều OXY dẹp lét).*
*   `0 <= xi, yi <= 100` *(Tọa độ vỏn vẹn Trị dương Khỏ Nhỏ gọn từ 0 Thấu 100).*

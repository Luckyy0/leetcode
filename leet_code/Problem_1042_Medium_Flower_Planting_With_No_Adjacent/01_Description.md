# Flower Planting With No Adjacent
# *Trồng Hoa Không Cách Nhau*

## Description
## *Mô tả*

You have `n` gardens, labeled from `1` to `n`, and an array `paths` where `paths[i] = [x_i, y_i]` describes a bidirectional path between garden `x_i` to garden `y_i`. In each garden, you want to plant one of 4 types of flowers.
*Bạn làm chủ `n` khu vườn, được đánh số danh tính từ `1` đến `n`. Bạn được giao một bản đồ danh sách `paths` nơi `paths[i] = [x_i, y_i]` miêu tả những con đường đất nối hai chiều qua lại mượt mà giữa khu vườn `x_i` và vườn `y_i`. Đang vào mùa Xuân, trong mỗi mảnh rào bạn cần phải trồng Gieo Trái một trong 4 loại Giống Hoa thần bí.*

All gardens have **at most 3** paths coming into or leaving it.
*Tất cả các khu vườn đều chỉ có **NHIỀU NHẤT là 3** con đường đâm vào ngoặt ra kết nối nó.*

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
*Cái giá phải trả của Tạo Hóa Ràng Buộc là: Bạn phải chọn Nhặt đúng Chủng Hoa cho từng vựa Vườn sao cho, Bất Cứ Hai Vườn Nào Thông Cửa Trực Tiếp Đường Nhau thì KHÔNG ĐỰỢC PHÉP TRỒNG LOÀI HOA THUỘC CÙNG MỘT MẦU MẪU CHỦNG LOẠI!*

Return **any** such a choice as an array `answer`, where `answer[i]` is the type of flower planted in the `(i+1)`th garden. The flower types are denoted `1`, `2`, `3`, or `4`. It is guaranteed an answer exists.
*Hãy trả về **bài giải bất kỳ nào cũng được** bằng Mảng kết quả `answer`, nơi định nghĩa `answer[i]` chứa Xốp Nhựa tên Hoa gieo xuống Khu vườn Cục bộ Số `(i+1)`. Các Giống Hoa được Đặt Kí hiệu Tên Vén Chữ Lạnh tanh là `1`, `2`, `3`, hoặc `4`. Đề tự Đóng Dấu Cam Kết Chắc Chắn 100% Thuật Toán Luôn Có Lối Mở Thoát Tồn Tại Ít Nhất 1 Cách Giải Ráp Hoa Thành Công.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, paths = [[1,2],[2,3],[3,1]]
**Output:** [1,2,3]
**Explanation:** 
*Giải thích:*
Gardens 1 and 2 have different types. Gardens 2 and 3 have different types. Gardens 3 and 1 have different types. Thus, [1,2,3] is a valid answer.
*Vườn Nhất trồng loại 1, Vườn Nhị đập loại 2. Hai vườn Cửa Kề Láng Giềng Khác Giống Ăn Rơ. Vườn Ba Lắp loại 3. Cả 3 Sáng Giá! Other answers works too like [2,3,4].*

## Example 2:
## *Ví dụ 2:*

**Input:** n = 4, paths = [[1,2],[3,4]]
**Output:** [1,2,1,2]

## Example 3:
## *Ví dụ 3:*

**Input:** n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
**Output:** [1,2,3,4]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^4`
*   `0 <= paths.length <= 2 * 10^4`
*   `paths[i].length == 2`
*   `1 <= x_i, y_i <= n`
*   `x_i != y_i`
*   Every garden has **at most 3** paths connected to it.
*   *Mỗi khu vườn có **TỐI ĐA 3** con đường dắt mối rủ rỉ với nó.*

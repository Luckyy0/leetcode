# Campus Bikes
# *Xe Đạp Khuôn Viên*

## Description
## *Mô tả*

**NOTE**: This is a LeetCode Premium problem.
**LƯU Ý:** Đây là một bài toán được liệt kê trong danh sách Độc Quyền (Premium) của hệ thống LeetCode.

On a campus represented on the X-Y plane, there are `n` workers and `m` bikes, with `n <= m`.
*Tại một phân khu ký túc xá rộng lớn được phác họa trên bề mặt phẳng tọa độ đa chiều X-Y, đang có mặt đúng `n` anh công nhân (workers) lảng vảng và `m` chiếc xe đạp (bikes) vứt lung tung, trong điều kiện chắc nịch là `n <= m` (Số xe luôn dư dả hoặc vừa đủ cho người).*

You are given an array `workers` of length `n` where `workers[i] = [xi, yi]` is the coordinate of the `ith` worker. You are also given an array `bikes` of length `m` where `bikes[j] = [xj, yj]` is the coordinate of the `jth` bike. All the given coordinates are unique.
*Bạn được nhận một mảng danh sách trích lục Tọa Độ các tay nhân viên mang tên `workers` với chiều dài `n`, ngầm hiểu theo gốc `workers[i] = [xi, yi]` chính là Cột mốc tọa độ vĩ tuyến của anh công nhân thứ `i`. Phía bên kia chiến tuyến, lại có thêm mảng lưu vị trí bãi `bikes` (xe đạp) dài `m`, với `bikes[j] = [xj, yj]` bám định vị trí chiếc xe thứ `j`. Mọi điểm tọa độ trong cả hai bản đồ này là Tuyệt Đói Độc Nhất (Không ai đè chân lên nhau).*

We assign a bike to each worker. To do this, we sort the pairs `(worker, bike)` by the Manhattan distance between each worker and their assigned bike in ascending order.
If multiple `(worker, bike)` pairs have the same shortest Manhattan distance, we choose the pair with the smallest worker index. If there are multiple ways to do that, we choose the pair with the smallest bike index. Repeat this process until there are no available workers.
*Điều Mệnh: Tiêu điểm cấp bách là phải Ban Phát chia đủ xe đạp cho TỪNG người TẤT CẢ công nhân. Quy Trình Vét Bóc Bắt Đội như sau:*
*Ta tung lệnh Tính Toàn Bộ Cước Chạy (Khoảng cách Manhattan) giữa TẤT CẢ Các cặp `(worker, bike)` Chéo Nhau. Sau đó, **Lôi Ra Sắp Xếp Trật Tự Chúng Theo Chiều Cước Phí Tăng Dần (Thằng nào Rẻ Chạy Gần Cự Li Nhất Sẽ Được Quyền Chọn Sớm Nhất - Ưu Tiên 1)**.*
*Trong Tình Cảnh Tranh Cướp Nảy Lửa (Khoảng cách Bằng Khít Nhau):*
*Luật 2: Anh công nhân nào rớt Số Chỉ Mục Danh Bạ Nhỏ Hơn (Tức Số Báo Danh Vị Trí Worker Index Thấp Hơn) Lập Tức Bốc Hàng Chớp Cơ Hội.*
*Luật 3 Đảo Lên Ngược Nữa (Tiếp tục Cạnh Tranh Rớt Đồng Đều Mức Hai): Thì Cái Chiếc Xe Chỉ Mục Gốc Nhỏ Tính Bé Hơn Rơi Điểm Nhanh Tới Tay Nguời Chờ! Lặp Rả Rích Quy Củ Cho Tới Khi Kho Lính Rỗng Xe Đủ!*

Return an array `answer` of length `n`, where `answer[i]` is the index (0-indexed) of the bike that the `ith` worker is assigned to.
*Sủng Cục Phân Tích: Bắn Ra một Mảng Khế Ước Ghi Nhận Kết Quả Giải Khát tên `answer` dài đúng `n`, với quy ước `answer[i]` chỉ thẳng vào Mặt cái Bảng Tên Chiếc Xe (`bike index`) mà gã công nhân thứ `i` VỚ BỞ ÔM TRỌN.*
*(Khoảng cách Manhattan được tính là: `|x1 - x2| + |y1 - y2|`).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
**Output:** [1,0]
**Explanation:** 
*Giải thích:*
Worker 1 grabs Bike 0 as they are closest (without ties). Then Worker 0 picks Bike 1. So the output is [1,0].
*Tên Công nhân Thứ 1 lụm Chớp Cọc Liền Chiếc Xe gốc 0 do Hai Tên Này Dính Khoảng Cách Méo Ngắn Nhất (Không Bị Đụng Điểm Nào Hết Tới Chướng Ngại). Vét Lưới Tiếp Lại Vòng Là Tên Công Đầu Rắn Số 0 Chỉ Còn Biết Vét Tù Mù Chiếc Xe Dư 1 Kéo Đi. Gông Lết Output Trổ Ra Dưới Cuối Cùng Là: Dây Trói `[1, 0]` (Worker 0 lấy Bike 1, Worker 1 Nhét Bike 0).*

---

## Constraints:
## *Ràng buộc:*

*   `n == workers.length`
*   `m == bikes.length`
*   `1 <= n <= m <= 1000`
*   `0 <= xi, yi, xj, yj < 1000`

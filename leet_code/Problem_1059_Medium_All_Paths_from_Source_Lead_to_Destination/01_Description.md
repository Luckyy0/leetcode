# All Paths from Source Lead to Destination
# *Mọi Nẻo Đường Từ Nguồn Đều Dẫn Về Đích Đến*

## Description
## *Mô tả*

**NOTE**: This is a LeetCode Premium problem.
**LƯU Ý:** Đây là một bài toán được liệt kê trong danh sách Độc Quyền (Premium) của hệ thống LeetCode.

Given the `edges` of a directed graph where `edges[i] = [ai, bi]` indicates there is an edge between nodes `ai` and `bi`, and two nodes `source` and `destination` of this graph, determine whether or not all paths starting from `source` eventually, end at `destination`, that is:
*Được cấp thẻ vào một mạng lưới đồ thị có hướng (directed graph), trong đó mảng `edges[i] = [ai, bi]` đóng vai trò vạch mặt chỉ tên một con đường một chiều xiết lối nối thẳng từ trạm `ai` phi tới ga `bi`. Lệnh trên áp xuống giao cho bạn hai cột mốc cốt tử: Trạm Xuất Phát `source` và Boong Ke Cứu Cánh Cuối Cùng `destination`.* 
*Bổn phận là hãy đi dò la, rọi đèn quét mìn để Trả Lời Cương Quyết: Liệu Rằng CÓ ĐÚNG LÀ MỌI Nẻo Tuyến Đi Nào Lóc Cóc Bắt Nguồn Từ Họng Cửa `source` CHẮC CHẮN Đều PHẢI Rớt Khựng Lọt Thỏm ĐÁP THẲNG VÀO Đúng Cái Lỗ `destination` Được Hay Không?* 

Sự Chắc Chắn 100% Này Đòi Hỏi Thỏa Mãn Đồng Loạt 3 Luật Thép:
1.  **At least one path exists from the source node to the destination node.**
    *   *Sống phải có đường mòn: Ít nhất phải tồn tại Dấu Vết Của Tối Thiểu MỘT CON ĐƯỜNG Máu xé gió Nối Thẳng Dọc Từ `source` Đụng Độ Được `destination`. Điểm mù Tịt Nọc Lệnh Biệt Vô Âm Tín -> Phế Bỏ Toàn Mạng Bị Đánh Tạch.*
2.  **If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.**
    *   *Ngõ Cụt Là Phải Bắt Đúng Tủ Đích: NẾU Bất cứ cái đường nào mò mẫm từ Nguồn `source` mà Xui Xẻo Lạc Trôi chui thụt lọt thỏm vào một Cái Boong Ke Giêng Nào Đó KÍN MÍT, KHÔNG CÒN 1 ĐƯỜNG RA (no outgoing edges - Đáy Cụt)... Cái nắp hầm Đáy Cụt đó KHÔNG ĐƯỢC PHÉP LÀ AI KHÁC Ngoài Chính Thằng `destination`! Rớt vào Lỗ Tử Đích Lạ Hoắc Nào Nữa Khác Tức Xổng Vòng Đảo Lệch -> Phế Bỏ.*
3.  **The number of possible paths from source to destination is a finite number.**
    *   *Số Lượng Nẻo Dẫn Lên Đích Phải Là HỮU HẠN: Nghĩa là CẤM TUYỆT ĐỐI Mọi Hành Vi DẪN TỚI VÒNG LẶP (Cycle). Lạc Lỏng Lẩn Quẩn Xoay Vòng Vô Hạn Không Bao Giờ Tới Đích Là Sự Phản Bội -> Phế Bỏ.*

Return `true` if and only if all roads from source lead to destination.
*Quăng ấn Lệnh Chấp Thuận `true` NẾU VÀ CHỈ NẾU tất cả mọi cánh cửa Tuyến Mạch đều thỏa màng Luật Phủi Cuối Cùng dẫn Mọi Não Vào Nước Đích Của Đế Chế Lỗ.* 

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
**Output:** false
**Explanation:** 
*Giải thích:*
It is possible to reach and get stuck on both node 1 and node 2.
*Chỉ đường Trạm Nguồn = 0, đích = 2.* 
*Đường 1: Thẳng Gắn Mắt 0 -> 2 (Lọt Đích Khớp Chốc Lát Bịt Lối Thoát).*
*Đường 2: Xổng Bỏ Nước Chạy Mã 0 -> 1. Tịt ngòi! Mà Điểm Khựng Cụt 1 này Lại Mép Phải LÀ Cái Thằng Lỗ Cuối Đích Ngắm (Số 2). Vậy Luật 2 Bị Phá Vỡ Tung Tóe Cặn Hầm Lạ.* Trả Lệnh Hủy Mõm: `False`.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
**Output:** false
**Explanation:** 
*Giải thích:*
We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
*Nguồn 0, Đích 3.*
*Nhánh 1: 0 -> 3 (Yên vị).*
*Nhánh 2: Xõa Nọc Lội Điểm 0 -> 1 -> 2 -> 1 -> 2... Ô Chu Choa Ma Cà Rồng! Đội 1 và 2 tạo thành Vòng Tròn Luẩn Quẩn Đuôi (Cycle). Vi phạm Cặn Nhựa Luật 3 (Đòi Hữu Hạn Tạch Hồn).* Trả Lệnh Bê Bết Hủy Chém: `False`.

## Example 3:
## *Ví dụ 3:*

**Input:** n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
**Output:** true
**Explanation:** 
*Giải thích:*
All paths from Node 0 lead effectively securely optimally safely gracefully sensibly beautifully brilliantly natively neatly comfortably to Node 3.
*(Xóa hệ rác Tiếng Anh).*
All paths logically lead correctly cleanly organically explicitly to intuitively natively Node 3 purely.
*Tất cả mọi nẻo Đục Khoét rỉ Tai từ số 0, dù Là Bẻ Lái Sang 1 (0 -> 1 -> 3) Hay Lảng Vảng Né Đuờng Sang Tuyến 2 (0 -> 2 -> 3)... Chung Quy Rút Cuối, Chỉ Có Rụng Vào Rốn Hút Của Thằng 3 Này Mà Cụt Móng (Thằng Đích Tuyệt Chạm Không Cửa Ra). Mọi Đạo Luật Cực Đoan Được Thỏa! Trục Xới `True` Cương Quyết.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10000`
*   `0 <= edges.length <= 10000`
*   `0 <= source, destination <= n - 1`

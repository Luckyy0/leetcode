# Number of Valid Subarrays
# *Số Lượng Mảng Con Hợp Lệ*

## Description
## *Mô tả*

**NOTE**: This is a LeetCode Premium problem.
**LƯU Ý:** Đây là một bài toán được liệt kê trong danh sách Độc Quyền (Premium) của hệ thống LeetCode.

Given an integer array `nums`, return the number of non-empty **continuous subarrays** with the leftmost element of the subarray not larger than other elements in the subarray.
*Được cấp cho một mảng số nguyên `nums`. Hãy lùng sục và trả về TỔNG SỐ LƯỢNG các "Mảng con liên tiếp" (Continuous Subarrays) khác rỗng thỏa mãn một Luật Thép Chống Lấn Lướt: Kẻ Tiên Phong (Tức phần tử nằm ở Mũi Trái Cùng của cái mảng con đó) **TUYỆT ĐỐI KHÔNG ĐƯỢC LỚN HƠN** bất kỳ phần tử đàn em nào khác đứng phía sau nó trong phạm vi cái mảng con ấy.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,4,2,5,3]
**Output:** 11
**Explanation:** 
*Giải thích:*
There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
*Ta vét lưới được Tổng cộng 11 băng nhóm Mảng Con vượt qua vòng kiểm duyệt. Tại các mảng này, Kẻ Đứng Đầu (Đứa Trái Cùng) luôn ngoan ngoãn giữ chỉ số lùn tịt nhất, không lộn xộn quát nạt trèo ngóc lên đầu đám lính đứng sau:*
*[1], [4], [2], [5], [3], [1,4], [2,5], [1,4,2], [2,5,3], [1,4,2,5], [1,4,2,5,3].*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [3,2,1]
**Output:** 3
**Explanation:** 
*Giải thích:*
The 3 valid subarrays are: [3],[2],[1].
*Chuỗi gốc đang là một chiếc cầu tuột trượt dốc không phanh. Do đó, KHÔNG có một Mảng ghép cặp kép nào lọt cửa kiểm duyệt (vì Mũi Trái toàn là những thằng Bự Khổ khinh thường ép đám nhỏ sau). Suy ra: Chỉ có 3 Tên độc thân đứng riêng lẻ rải rác tự lập Mảng Con Mũi Nhọn Cụt là Hợp Lệ! (Gồm [3], [2], [1]).*

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [2,2,2]
**Output:** 6
**Explanation:** 
*Giải thích:*
There are 6 valid subarrays: [2],[2],[2],[2,2],[2,2],[2,2,2].
*Trong một dãy Bằng Vai Phải Lứa "Phát Xít Đầu Cắt Moi". Bất kỳ thằng nào Cầm Cờ thì Mũi Trái của nó bét nhất cũng "Chỉ Được Tính Bằng" những thằng Sau. Không Thằng nào Cao Hơn thằng nào (Thỏa điều kiện Non-decreasing - Nhỏ Hơn Hoặc Bằng Mũi Trái). Kết Quả Phùng mang Trợn má Có 6 Nhóm Ghép!*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 50000`
*   `0 <= nums[i] <= 100000`

# 1282. Group the People Given the Group Size They Belong To / Nhóm Mọi người Dựa trên Kích thước Nhóm Họ thuộc về

## Problem Description / Mô tả bài toán
`groupSizes[i]` is size of group that person `i` belongs to.
Return list of groups such that everyone is in a group of correct size.
Guaranteed valid solution.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hashing / Bucketing
Group people by their desired size.
`Map<Integer, List<Integer>>` where key is size, value is list of people.
Iterate `groupSizes`. Add `i` to `map[size]`.
If list for `size` reaches `size`, move it to result and start new list.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Grouping and Flushing
Use a helper map (or array) to collect people based on their required group size. Iterate through the input array. For each person `i` with group size `s`, add `i` to the bucket corresponding to `s`. Check if the bucket size equals `s`. If it does, the group is complete; add this bucket to the result list and clear the bucket for future people requiring the same size. Since a valid solution is guaranteed, no people will be left over.
Sử dụng bản đồ trợ giúp (hoặc mảng) để thu thập mọi người dựa trên kích thước nhóm yêu cầu của họ. Lặp lại qua mảng đầu vào. Đối với mỗi người `i` có kích thước nhóm `s`, hãy thêm `i` vào nhóm tương ứng với `s`. Kiểm tra xem kích thước nhóm có bằng `s` không. Nếu có, nhóm đã hoàn tất; thêm nhóm này vào danh sách kết quả và xóa nhóm để sử dụng cho những người trong tương lai yêu cầu cùng kích thước. Vì giải pháp hợp lệ được đảm bảo, sẽ không có người nào bị bỏ lại.

---

# 947. Most Stones Removed with Same Row or Column / Số lượng Đá nhiều nhất bị loại bỏ cùng Hàng hoặc Cột

## Problem Description / Mô tả bài toán
On a 2D plane, we place `n` stones at some integer coordinate points. Each coordinate point may have at most one stone.
Trên một mặt phẳng 2D, chúng ta đặt `n` viên đá tại một số điểm tọa độ nguyên. Mỗi điểm tọa độ có thể có tối đa một viên đá.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Một viên đá có thể được loại bỏ nếu nó có cùng hàng hoặc cùng cột với một viên đá khác chưa bị loại bỏ.

Return the largest possible number of stones that can be removed.
Hãy trả về số lượng đá đơn tối đa có thể loại bỏ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Connected Components (Union-Find) / Thành phần Kết nối (Union-Find)
Two stones are connected if they share a row or a column.
Hai viên đá được kết nối nếu chúng có cùng hàng hoặc cột.

Key insight:
For a connected component of size `S`, we can remove `S - 1` stones, leaving only 1 stone remaining.
Đối với một thành phần kết nối có kích thước `S`, chúng ta có thể loại bỏ `S - 1` viên đá, chỉ để lại 1 viên duy nhất.

Total stones removed = `TotalStones - NumberOfConnectedComponents`.

Algorithm:
1. Treat each row and each column as a node.
2. For each stone at `(r, c)`, union row `r` and column `c`.
3. Count the number of disjoint sets.

### Complexity / Độ phức tạp
- **Time**: O(N alpha(N)) or O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Component Consolidation
Abstract the physical stones into nodes in a connectivity graph based on their row and column coordinates. The maximum removal count is achieved by reducing each interconnected cluster to a single representative stone.
Trừu tượng hóa các viên đá vật lý thành các nút trong đồ thị kết nối dựa trên tọa độ hàng và cột của chúng. Số lượng loại bỏ tối đa đạt được bằng cách giảm mỗi cụm liên kết với nhau thành một viên đá đại diện duy nhất.

---

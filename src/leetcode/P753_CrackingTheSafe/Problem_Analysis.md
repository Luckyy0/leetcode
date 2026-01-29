# 753. Cracking the Safe / Phá Khóa An toàn

## Problem Description / Mô tả bài toán
A safe has a password that is a sequence of `n` digits where each digit can be in the range `[0, k - 1]`.
Một chiếc két sắt có mật khẩu là một chuỗi `n` chữ số, trong đó mỗi chữ số có thể nằm trong phạm vi `[0, k - 1]`.

The safe opens when the last `n` digits typed match the password. You can type as many digits as you want.
Két sắt mở ra khi `n` chữ số cuối cùng được nhập khớp với mật khẩu. Bạn có thể nhập bao nhiêu chữ số tùy thích.

Return any string of minimum length that is guaranteed to open the safe at some point during the typing.
Trả về bất kỳ chuỗi nào có độ dài tối thiểu được đảm bảo sẽ mở được két sắt tại một thời điểm nào đó trong khi nhập.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### De Bruijn Sequence / Chuỗi De Bruijn
This problem asks for a De Bruijn sequence B(k, n), which contains every possible string of length `n` from an alphabet of size `k` as a substring exactly once.
Bài toán này yêu cầu tìm một chuỗi De Bruijn B(k, n), chứa mọi chuỗi có độ dài `n` khả thi từ bảng chữ cái kích thước `k` dưới dạng một chuỗi con đúng một lần.

A De Bruijn sequence can be found by finding a **Hamiltonian path** in a De Bruijn graph, or more efficiently, an **Eulerian circuit** in a related graph.
Chuỗi De Bruijn có thể được tìm thấy bằng cách tìm một **đường đi Hamiltonian** trong đồ thị De Bruijn, hoặc hiệu quả hơn là một **chu trình Eulerian** trong đồ thị liên quan.

Algorithm (Hierholzer's or DFS):
1. States are prefixes of length `n-1`.
2. From each state, follow an edge for each digit `0...k-1`.

### Complexity / Độ phức tạp
- **Time**: O(k^n).
- **Space**: O(k^n).

---

## Analysis / Phân tích

### Approach: DFS for Eulerian Path
Construct the sequence using DFS. Start with `n-1` zeros. From the current prefix, try adding digits `0` to `k-1` to form a new combination. If the combination hasn't been visited, recurse and then append the digit to the result.
Xây dựng chuỗi bằng DFS. Bắt đầu với `n-1` số không. Từ tiền tố hiện tại, hãy thử thêm các chữ số từ `0` đến `k-1` để tạo ra một tổ hợp mới. Nếu tổ hợp đó chưa được truy cập, hãy đệ quy và sau đó thêm chữ số đó vào kết quả.

---

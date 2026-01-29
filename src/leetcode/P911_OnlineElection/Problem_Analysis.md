# 911. Online Election / Bầu cử Trực tuyến

## Problem Description / Mô tả bài toán
Design an algorithm that tracks the winner of an election at any given time.
Thiết kế một thuật toán theo dõi người chiến thắng trong một cuộc bầu cử tại bất kỳ thời điểm nào.

The winner is the person who has the most votes at that time. If there is a tie, the most recent vote determines the winner.
Người chiến thắng là người có nhiều phiếu bầu nhất tại thời điểm đó. Nếu có sự trùng lặp, phiếu bầu gần đây nhất sẽ quyết định người chiến thắng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Precomputation and Binary Search / Tính toán trước và Tìm kiếm Nhị phân
The votes happen at specific times `times[i]`.
Phép bầu cử diễn ra vào các thời điểm cụ thể `times[i]`.

Algorithm:
1. Iterate through the votes and maintain a current `leader` for each time point `i`.
   - Use a `count` map for each candidate.
2. Store the leaders in an array `leaders` where `leaders[i]` is the winner at `times[i]`.
3. `q(t)`: Find the largest `times[i] <= t` using binary search (upper bound style).
4. Return `leaders[i]`.

### Complexity / Độ phức tạp
- **Construction**: O(N).
- **Query**: O(log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Timeline Snapshotting
Record the state of the leadership at every historical voting event. Since outcomes are immutable once recorded, searching for the winner at a future timestamp reduces to finding the most recent recorded snapshot.
Ghi lại trạng thái lãnh đạo tại mọi sự kiện bỏ phiếu trong lịch sử. Vì kết quả không đổi sau khi được ghi lại, việc tìm kiếm người chiến thắng tại một dấu mốc thời gian trong tương lai sẽ quy về việc tìm kiếm ảnh chụp (snapshot) được ghi lại gần đây nhất.

---

# 1024. Video Stitching / Ghép nối Video

## Problem Description / Mô tả bài toán
You are given a series of video clips from a sporting event that lasted `time` seconds. These video clips can be overlapping with each other and have varied lengths.
Bạn được cho một loạt các video clip từ một sự kiện thể thao kéo dài `time` giây. Các video clip này có thể chồng chéo lên nhau và có độ dài khác nhau.

Each video clip `clips[i]` is an interval: it starts at `clips[i][0]` and ends at `clips[i][1]`.
Mỗi video clip `clips[i]` là một khoảng: nó bắt đầu tại `clips[i][0]` và kết thúc tại `clips[i][1]`.

Return the minimum number of clips needed to cover the entire interval `[0, time]`. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy / Jump Game Variation / Tham lam / Biến thể trò chơi Nhảy
This is exactly like Jump Game II, but with intervals.
Đây chính xác giống như Jump Game II, nhưng với các khoảng.

Algorithm:
1. `maxReach[i]` = maximum end time of a clip starting at `i`.
   - Preprocess clips to fill `maxReach`.
2. Current coverage `end = 0`, `farthest = 0`, `clips = 0`.
3. Iterate `i` from 0 to `time - 1`:
   - `farthest = max(farthest, maxReach[i])`.
   - If `i == end`:
     - `clips++`.
     - `end = farthest`.
     - If `end >= time`, return `clips`.
4. If loop finishes and `end < time`, return -1.

### Complexity / Độ phức tạp
- **Time**: O(T + N), where T is time, N is number of clips.
- **Space**: O(T).

---

## Analysis / Phân tích

### Approach: Range Extension
Iteratively extend the covered range. At each step, select the clip that starts within the currently covered area and extends the furthest to the right. This greedy choice minimizes the total clips needed to bridge the gap to the target time.
Mở rộng phạm vi được bao phủ theo từng bước. Tại mỗi bước, chọn clip bắt đầu trong khu vực hiện được bao phủ và mở rộng xa nhất về bên phải. Lựa chọn tham lam này giảm thiểu tổng số clip cần thiết để lấp đầy khoảng trống đến thời gian đích.

---

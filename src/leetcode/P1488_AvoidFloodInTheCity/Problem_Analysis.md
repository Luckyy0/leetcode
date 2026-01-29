# 1488. Avoid Flood in The City / Tránh Lũ lụt trong Thành phố

## Problem Description / Mô tả bài toán
Array `rains`. `rains[i] > 0`: rains over lake `rains[i]`. `rains[i] == 0`: dry a lake.
Constraint: if lake full and rains again -> flood.
Construct `ans` array.
- If rain `x`: `ans[i] = -1`.
- If dry: `ans[i]` is lake ID to dry.
Prevent floods.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Sets / Deques
Need to dry a lake BEFORE it rains again.
If lake `x` rained at day `d1` and rains again at `d2` ($d1 < d2$), we must find a dry day `dry_day` such that `d1 < dry_day < d2`.
To optimize, pick the EARLIEST valid dry day after `d1`. This saves later dry days for later emergencies.
Use `TreeSet` of available dry days.
When rain on lake `x`:
If `x` already full (map stores `last_rain_day[x]`):
  Find smallest `dry_day` in set > `last_rain_day[x]`.
  If none, return empty (impossible).
  Use `dry_day`. Remove from set. Set `ans[dry_day] = x`.
  Update `last_rain_day[x] = current_day`.
Else:
  `last_rain_day[x] = current_day`.
If `rains[i] == 0`: Add `i` to `dry_days` set. `ans[i] = 1` (default, can be anything).

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: TreeSet for Dry Days
We iterate through the rains.
If it rains on lake x (`rains[i] > 0`):
  Check if lake x is already full (found in `fullLakes` map).
  If yes:
    We need to dry it some day between `lastRainDay = fullLakes[x]` and today `i`.
    Find smallest index in `dryDays` (TreeSet) that is greater than `lastRainDay`. `dryDays.higher(lastRainDay)`.
    If such day exists:
      Use it (`ans[day] = x`), remove from set.
      Update `fullLakes[x] = i`.
    Else: Impossible -> return empty array.
  Else:
    `fullLakes[x] = i`.
  `ans[i] = -1`.
If no rain (`rains[i] == 0`):
  Add `i` to `dryDays`.
  `ans[i] = 1`. (Filler).
Lặp lại qua các cơn mưa.
Nếu mưa trên hồ x:
  Kiểm tra xem hồ x đã đầy chưa (tìm thấy trong bản đồ `fullLakes`).
  Nếu có:
    Chúng ta cần làm khô nó vào một ngày nào đó giữa `lastRainDay` và ngày hôm nay `i`.
    Tìm chỉ số nhỏ nhất trong `dryDays` (TreeSet) lớn hơn `lastRainDay`. `dryDays.higher(lastRainDay)`.

---

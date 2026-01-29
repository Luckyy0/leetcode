# 1097. Game Play Analysis V / Phân tích Chơi Game V

## Problem Description / Mô tả bài toán
Table `Activity`: `player_id`, `device_id`, `event_date`, `games_played`.
Write an SQL query to report the Day 1 retention of players.
Day 1 retention: For each install date (minimum event_date for player), calculate the install date, counting number of players installed on that day, and Day 1 retention rate (fraction of players who logged in the day after install).
Dữ liệu giữ chân Ngày 1: Đối với mỗi ngày cài đặt (ngày sự kiện tối thiểu cho người chơi), tính ngày cài đặt, đếm số lượng người chơi đã cài đặt vào ngày đó và tỷ lệ giữ chân Ngày 1 (tỷ lệ người chơi đã đăng nhập vào ngày sau khi cài đặt).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Self Join and Aggregation
1. Identify `install_date` for each player: `MIN(event_date)`.
2. Count total players per `install_date`.
3. Count players who logged in on `install_date + 1`.
   - Left Join original table on `player_id` and `date = install_date + 1`.

Query Structure:
- Subquery: `PlayerInstall` (player_id, install_date).
- Join `PlayerInstall` with `Activity` (A) on `p.player_id` and `a.event_date = p.install_date + 1`.
- Group by `install_date`.

---

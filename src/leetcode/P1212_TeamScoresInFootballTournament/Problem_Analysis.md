# 1212. Team Scores in Football Tournament / Điểm Đội trong Giải bóng đá

## Problem Description / Mô tả bài toán
Tables `Teams` (team_id, team_name) and `Matches` (match_id, host_team, guest_team, host_goals, guest_goals).
Win: 3 points. Draw: 1 point. Loss: 0 points.
Calculate points for each team. Sort by points desc, team_name asc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Unions / Joining / Hợp nhất SQL / Nối
1. Calculate points from perspective of host.
   - `CASE WHEN host > guest THEN 3 WHEN host = guest THEN 1 ELSE 0 END`.
2. Calculate points from perspective of guest.
   - `CASE WHEN guest > host THEN 3 ...`.
3. Union all scores.
4. Join with Teams to get all teams (even if 0 matches).
5. Group by team and sum.

---

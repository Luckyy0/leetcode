# 1194. Tournament Winners / Những Người chiến thắng Giải đấu

## Problem Description / Mô tả bài toán
Tables: `Players` (player_id, group_id), `Matches` (match_id, first_player, second_player, first_score, second_score).
Winner of each group is the player with the highest total score.
Tie-break: lowest `player_id`.
Return `group_id`, `player_id`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Score Aggregation and Ranking
1. Unpivot matches to get `(player, score)`.
   - Select first, score union all select second, score.
2. Sum score per player.
3. Join with Players to get group.
4. Rank players within group by score desc, id asc.
5. Select rank 1.

---

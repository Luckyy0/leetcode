# 512. Game Play Analysis II / Phân Tích Lượt Chơi II

## Problem Description / Mô tả bài toán
Write an SQL query to report the **device_id** that the player used for their **first login**.
Hãy viết một truy vấn SQL để báo cáo **device_id** mà người chơi đã sử dụng cho **lần đăng nhập đầu tiên** của họ.

The table `Activity` schema is the same as P511.

### Example:
Output should contain `player_id` and the `device_id` from the first login record.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery or Window Functions / Truy vấn con hoặc Hàm cửa sổ
Since we need a non-aggregated column (`device_id`) associated with an aggregated value (`MIN(event_date)`), we need to join or filter.

SQL Algorithm 1 (Subquery):
1. Select rows from `Activity` where `(player_id, event_date)` matches the result of P511.

SQL Algorithm 2 (Window Function):
1. Use `RANK()` or `ROW_NUMBER()` partitioned by `player_id` and ordered by `event_date`.
2. Select rows where rank is 1.

---

## Analysis / Phân tích

### Approach: Filtered Row Retrieval

**Algorithm**:
1.  Identify first login per player.
2.  Filter the main table to retrieve associated device ID.

---

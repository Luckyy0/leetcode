# Analysis for Game Play Analysis III
# *Phân tích cho bài toán Phân tích Trò chơi III*

## 1. Problem Essence & Running Total
## *1. Bản chất vấn đề & Tổng Chạy*

### The Challenge
### *Thách thức*
Calculating cumulative sum of `games_played` partitioned by `player_id` and ordered by `event_date`.

### Strategy: Window Function
### *Chiến lược: Hàm Cửa sổ*

1.  **Function:** `SUM(games_played) OVER (...)`.
2.  **Partition:** `PARTITION BY player_id`.
3.  **Order:** `ORDER BY event_date`.
4.  **Frame:** Default is `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`, which works perfectly here.

---

## 2. Approach: SQL Window Function
## *2. Hướng tiếp cận: Hàm Cửa sổ SQL*

### Logic
### *Logic*
`SELECT player_id, event_date, SUM(games_played) OVER (PARTITION BY player_id ORDER BY event_date) AS games_played_so_far FROM Activity`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Conciseness:** Standard SQL feature.
    *Súc tích: Tính năng chuẩn của SQL.*
*   **Performance:** database engines optimize window functions efficiently.
    *Hiệu năng: Công cụ cơ sở dữ liệu tối ưu hóa các hàm cửa sổ một cách hiệu quả.*

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Use `SUM() OVER(PARTITION BY ... ORDER BY ...)`.
*Sử dụng `SUM() OVER(PARTITION BY ... ORDER BY ...)`.*

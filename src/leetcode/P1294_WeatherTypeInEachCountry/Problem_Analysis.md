# 1294. Weather Type in Each Country / Loại Thời tiết ở Mỗi Quốc gia

## Problem Description / Mô tả bài toán
Tables `Countries` (country_id, country_name) and `Weather` (country_id, weather_state, day).
Weather type for Nov 2019:
- avg <= 15: Cold
- avg >= 25: Hot
- else: Warm
Find weather type for each country.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Case
1. Filter `day` between '2019-11-01' and '2019-11-30'.
2. Group by `country_id`.
3. Compute `AVG(weather_state)`.
4. Use `CASE WHEN` to label.

---

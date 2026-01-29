# 1495. Friendly Movies Streamed Last Month / Phim Thân thiện Được Phát trực tuyến Tháng trước

## Problem Description / Mô tả bài toán
Tables `TVProgram` (program_date, content_id, channel), `Content` (content_id, title, Kids_content, content_type).
Find distinct titles of `Kids_content = 'Y'` and `content_type = 'Movies'` streamed in `June 2020`.
Order? No specific order required.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Filtering and Join
Join Program and Content.
Filter date range `2020-06-01` to `2020-06-30`.
Filter `Kids_content = 'Y'` and `content_type = 'Movies'`.
Select DISTINCT title.

---

# 1322. Ads Performance / Hiệu suất Quảng cáo

## Problem Description / Mô tả bài toán
Table `Ads`: `ad_id`, `user_id`, `action` ('Clicked', 'Viewed', 'Ignored').
CTR = Clicked / (Clicked + Viewed) * 100.
Ignored actions are not counted in denominator.
If denominator is 0, CTR is 0.
Round to 2 decimal places.
Order by CTR desc, ad_id asc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Conditional Aggregation
Group by `ad_id`.
Sum `action = 'Clicked'` as Clicks.
Sum `action = 'Viewed'` as Views.
Compute formula.
Handle divide by zero.

---

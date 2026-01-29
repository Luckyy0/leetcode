# 1333. Filter Restaurants by Vegan-Friendly, Price and Distance / Lọc Nhà hàng theo Thân thiện với Người ăn chay, Giá cả và Khoảng cách

## Problem Description / Mô tả bài toán
Array `restaurants`: `[id, rating, veganFriendly, price, distance]`.
Filters:
- `veganFriendly` (1/0). If input is 1, only show vegan (1). If input 0, show all.
- `maxPrice`: price <= maxPrice.
- `maxDistance`: distance <= maxDistance.
Sort by rating desc, id desc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Filtering and Sorting
Iterate list.
Apply filters.
Collect valid restaurants.
Sort using Comparator.
Return IDs.

---

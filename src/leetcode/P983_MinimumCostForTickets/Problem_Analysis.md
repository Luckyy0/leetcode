# 983. Minimum Cost For Tickets / Chi phí Tối thiểu cho các tấm vé

## Problem Description / Mô tả bài toán
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array `days`.
Bạn đã lên kế hoạch cho một số chuyến du lịch bằng tàu hỏa trước một năm. Các ngày trong năm mà bạn sẽ đi được cho dưới dạng mảng số nguyên `days`.

Train tickets are sold in three different ways:
- a **1-day** pass: `costs[0]`
- a **7-day** pass: `costs[1]`
- a **30-day** pass: `costs[2]`

Return the minimum cost to travel every day in your list of `days`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i]` = minimum cost of travel up to day `i`.
`dp[i]` = chi phí đi lại tối thiểu tính đến ngày thứ `i`.

Algorithm:
1. Use a set for quick lookup of travel days.
2. For each day `i` from 1 to 365:
   - If `i` is not a travel day: `dp[i] = dp[i-1]`.
   - If `i` IS a travel day:
     - `dp[i] = min(`
       - `dp[max(0, i-1)] + costs[0]`,
       - `dp[max(0, i-7)] + costs[1]`,
       - `dp[max(0, i-30)] + costs[2]`
     - `)`

### Complexity / Độ phức tạp
- **Time**: O(MaxDay) = O(365).
- **Space**: O(MaxDay).

---

## Analysis / Phân tích

### Approach: Day-by-Day optimization
Model the travel calendar as a series of budgeting decisions. For each mandatory travel day, evaluate the cost-effectiveness of buying a new short-term pass versus having been covered by a longer-term pass purchased previously.
Mô phỏng lịch trình du lịch như một loạt các quyết định lập ngân sách. Đối với mỗi ngày du lịch bắt buộc, hãy đánh giá hiệu quả chi phí của việc mua một thẻ ngắn hạn mới so với việc đã được đài thọ bởi một thẻ dài hạn được mua trước đó.

---

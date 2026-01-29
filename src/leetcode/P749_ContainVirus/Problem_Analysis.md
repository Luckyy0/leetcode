# 749. Contain Virus / Ngăn chặn Virus

## Problem Description / Mô tả bài toán
A virus is spreading on an `m x n` grid. You are given an integer matrix `isInfected` where `1` represents an infected cell and `0` represents an uninfected cell.
Một con virus đang lây lan trên một lưới `m x n`. Bạn được cấp một ma trận số nguyên `isInfected` trong đó `1` biểu thị một ô bị nhiễm và `0` biểu thị một ô chưa bị nhiễm.

Every night, you can build walls around **one** region of infected cells. A wall prevents that specific region from spreading. The regions you don't wall off will spread to all their 4-directionally adjacent uninfected cells.
Mỗi đêm, bạn có thể xây tường bao quanh **một** vùng chứa các ô bị nhiễm. Một bức tường ngăn vùng cụ thể đó lây lan. Các vùng bạn không xây tường sẽ lây lan sang tất cả các ô chưa bị nhiễm lân cận theo 4 hướng.

Goal: Build walls around the region that would infect the most uninfected cells on the next day. Return the total number of walls used.
Mục tiêu: Xây tường bao quanh vùng sẽ lây nhiễm nhiều ô nhất vào ngày hôm sau. Trả về tổng số bức tường đã sử dụng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-Region BFS/DFS / BFS/DFS đa vùng
This is a greedy simulation problem.
Đây là một bài toán mô phỏng tham lam.

Step-by-step:
1. Identify all disjoint infected regions.
2. For each region, calculate:
   - How many uninfected cells it will infect tomorrow.
   - How many walls are needed to contain it today.
3. Pick the region that poses the most threat (infects the most unique neighbors).
4. Add its wall count to the result and mark it as "contained" (e.g., set cells to 2).
5. Let all other infected regions spread.
6. Repeat until no more infections occur.

### Complexity / Độ phức tạp
- **Time**: O((M * N)^2).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Greedy Threat Containment
Simulate night by night. Each time, prioritize the region that would claim the most new territory. Count the perimeter length for that region specifically.
Mô phỏng từng đêm một. Mỗi lần, ưu tiên vùng sẽ chiếm được nhiều lãnh thổ mới nhất. Tính toán độ dài chu vi cho riêng vùng đó.

---

# 1125. Smallest Sufficient Team / Đội Đầy đủ Nhỏ nhất

## Problem Description / Mô tả bài toán
In a project, you have a list of required `req_skills`.
You have a list of `people`. The `i-th` person has a list of `people[i]` skills.
Return any sufficient team of the smallest possible size, represented by the index of each person.
A sufficient team is a set of people such that for every required skill, there is at least one person in the team who has that skill.
Trong một dự án, bạn có một danh sách các `req_skills` cần thiết.
Bạn có một danh sách `people`. Người thứ `i` có một danh sách các kỹ năng `people[i]`.
Trả về bất kỳ đội đầy đủ nào có kích thước nhỏ nhất có thể, được đại diện bởi chỉ số của mỗi người.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask Dynamic Programming / Quy hoạch Động với Bitmask
Skills sizes <= 16. Bitmask is perfect.
`dp[mask]` = minimum people indices to cover skill mask `mask`.
This needs storing lists, potentially large memory?
Actually array size 65536 is small. Storing `List<Integer>` is feasible.
Better: `dp[mask]` = index of last person added to achieve this state.
And `parent[mask]` = previous state.
Or iterate people and update all states.

Algorithm:
1. Map skills to IDs 0..M-1.
2. Initialize `dp` map/array. `dp[0] = new ArrayList<>()`.
   - Or just `dp` array where `dp[mask]` stores the list of people.
3. Iterate people:
   - Convert person skills to `skillMask`.
   - For each existing `state` in `dp`:
     - `combined = state | skillMask`.
     - If `combined` not seen or `dp[combined].size() > dp[state].size() + 1`:
       - `dp[combined] = dp[state] + personID`.
4. Return `dp[(1<<M) - 1]`.

Optimization: Iterate existing states in random order? No, copy keys first.

### Complexity / Độ phức tạp
- **Time**: O(N * 2^M). N people, 2^M states.
- **Space**: O(2^M * M). Storing lists.

---

## Analysis / Phân tích

### Approach: Bitmask DP with Team Tracking
Map each required skill to a bit position. Use DP where `dp[mask]` represents the smallest team covering the skill set `mask`. Iterate through each person, calculating their skill contribution. Update achievable skill states by merging the person with existing team configurations. Since M <= 16, a $2^{16}$ state space is manageable.
Ánh xạ từng kỹ năng cần thiết tới một vị trí bit. Sử dụng DP trong đó `dp[mask]` đại diện cho đội nhỏ nhất bao gồm bộ kỹ năng `mask`. Lặp qua từng người, tính toán sự đóng góp kỹ năng của họ. Cập nhật các trạng thái kỹ năng có thể đạt được bằng cách hợp nhất người đó với các cấu hình đội hiện có.

---

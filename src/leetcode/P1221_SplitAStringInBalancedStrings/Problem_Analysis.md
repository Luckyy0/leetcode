# 1221. Split a String in Balanced Strings / Chia một Chuỗi thành các Chuỗi Cân bằng

## Problem Description / Mô tả bài toán
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
Given a balanced string `s`, split it into a maximum amount of split balanced strings.
Return the maximum amount of split balanced strings.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Counting / Đếm Tham lam
Iterate through the string. Keep a balance counter.
Ideally +1 for 'L', -1 for 'R'.
When balance becomes 0, we found a balanced substring. Increment answer.
Reset? No need, just keep iterating. The greedy choice (cutting as soon as balanced) is optimal because waiting longer might merge two balanced strings into one, reducing count.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Balance Counter
Iterate through the string maintaining a balance counter (e.g., +1 for 'R', -1 for 'L'). Whenever the counter returns to zero, it signifies that the current segment (from the last zero-balance point) is a balanced string. Increment the result count. This greedy strategy works because splitting immediately when balanced never prevents future splits (since the remaining suffix is guaranteed to be balanced if the whole is).
Duyệt qua chuỗi duy trì bộ đếm cân bằng (ví dụ: +1 cho 'R', -1 cho 'L'). Bất cứ khi nào bộ đếm trở về 0, điều đó biểu thị rằng đoạn hiện tại (từ điểm cân bằng 0 cuối cùng) là một chuỗi cân bằng. Tăng số lượng kết quả. Chiến lược tham lam này hoạt động vì việc chia tách ngay lập tức khi cân bằng không bao giờ ngăn cản các lần chia tách trong tương lai (vì hậu tố còn lại được đảm bảo cân bằng nếu toàn bộ là cân bằng).

---

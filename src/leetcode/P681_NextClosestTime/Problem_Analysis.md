# 681. Next Closest Time / Thời gian Gần nhất Tiếp theo

## Problem Description / Mô tả bài toán
Given a time represented in the format `"HH:MM"`, form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
Cho một thời gian được biểu diễn dưới dạng `"HH:MM"`, hãy tạo thời gian gần nhất tiếp theo bằng cách tái sử dụng các chữ số hiện tại. Không có giới hạn về số lần một chữ số có thể được tái sử dụng.

You may assume the given time is valid and does not contain `*`. For example, `"19:34"`, `"23:59"` are all valid. `"28:60"` is not valid.
Bạn có thể giả định thời gian đã cho là hợp lệ và không chứa `*`. Ví dụ, `"19:34"`, `"23:59"` đều hợp lệ. `"28:60"` không hợp lệ.

Return the next closest time. If the current time is `23:59`, the next closest time could be `"22:22"`.
Trả về thời gian gần nhất tiếp theo. Nếu thời gian hiện tại là `23:59`, thời gian gần nhất tiếp theo có thể là `"22:22"`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Exhaustive Permutation / Liệt kê Hoán vị
Since there are only 4 digits and each can be one of the original digits, there are at most `4^4 = 256` possible times.
Vì chỉ có 4 chữ số và mỗi chữ số có thể là một trong các chữ số ban đầu, nên có tối đa `4^4 = 256` thời gian khả thi.

Algorithm:
1. Extract unique digits from the input.
2. Generate all possible combinations of 4 digits.
3. Validate if the combination represents a valid time (HH < 24 and MM < 60).
4. Calculate the time difference from the current time.
5. Find the time with the smallest positive difference (modulo 24 hours).

### Complexity / Độ phức tạp
- **Time**: O(1) - The number of possibilities is fixed (256).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Simulation through Minutes
Convert the input time to minutes from the start of the day. Iterate minute by minute forward. For each minute, check if the string representation uses only the digits available from the original time. The first match is the answer.
Chuyển đổi thời gian đầu vào thành số phút kể từ đầu ngày. Lặp lại từng phút về phía trước. Đối với mỗi phút, hãy kiểm tra xem chuỗi biểu thị có chỉ sử dụng các chữ số có sẵn từ thời gian ban đầu hay không. Kết quả khớp đầu tiên là câu trả lời.

---

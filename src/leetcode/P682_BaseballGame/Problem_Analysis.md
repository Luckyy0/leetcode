# 682. Baseball Game / Trò chơi Bóng chày

## Problem Description / Mô tả bài toán
You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
Bạn đang ghi điểm cho một trò chơi bóng chày với những quy tắc kỳ lạ. Trò chơi bao gồm nhiều vòng, trong đó điểm số của các vòng trước có thể ảnh hưởng đến điểm số của các vòng sau.

At the beginning of the game, you start with an empty record. You are given a list of strings `ops`, where `ops[i]` is the ith operation you must apply to the record and is one of the following:
Bắt đầu trò chơi, bạn bắt đầu với một kỷ lục trống. Bạn được cung cấp một danh sách các chuỗi `ops`, trong đó `ops[i]` là thao tác thứ i bạn phải áp dụng cho kỷ lục và là một trong những điều sau:

1. `x` - Record a new score of `x`.
2. `"+"` - Record a new score that is the sum of the previous two scores.
3. `"D"` - Record a new score that is double the previous score.
4. `"C"` - Invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record.
Trả về tổng của tất cả các điểm số ghi được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack Data Structure / Cấu trúc dữ liệu Ngăn xếp
Operations like `"C"` (remove last), `"D"` (use last), and `"+"` (use last two) naturally map to a Stack.
Các thao tác như "C" (xóa cái cuối), "D" (sử dụng cái cuối), và "+" (sử dụng hai cái cuối) ánh xạ một cách tự nhiên vào Ngăn xếp.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of operations.
- **Space**: O(N) to store the scores in a list or stack.

---

## Analysis / Phân tích

### Approach: Stack-based Processing
Use an `ArrayList` or `Stack` to store each valid score as it is recorded. For each operation, perform the logic (add, remove, double, or sum) and finally compute the total sum.
Sử dụng `ArrayList` hoặc `Stack` để lưu trữ từng điểm số hợp lệ khi nó được ghi lại. Đối với mỗi thao tác, hãy thực hiện logic (thêm, xóa, gấp đôi hoặc tính tổng) và cuối cùng tính tổng số điểm.

---

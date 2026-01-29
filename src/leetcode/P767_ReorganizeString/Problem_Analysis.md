# 767. Reorganize String / Sắp xếp lại Chuỗi

## Problem Description / Mô tả bài toán
Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same.
Cho một chuỗi `s`, hãy sắp xếp lại các ký tự của `s` sao cho không có hai ký tự lân cận nào giống nhau.

Return any possible rearrangement of `s` or return an empty string "" if not possible.
Trả về bất kỳ cách sắp xếp lại nào có thể của `s` hoặc trả về chuỗi trống "" nếu không thể thực hiện được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Max-Heap / Tham lam với Heap cực đại
The most frequent character must be placed first, ideally separated by other characters.
Ký tự xuất hiện thường xuyên nhất phải được đặt trước, lý tưởng nhất là được ngăn cách bởi các ký tự khác.

Condition for impossibility: If the frequency of any character is greater than `(N + 1) / 2`.
Điều kiện không thể thực hiện: Nếu tần suất của bất kỳ ký tự nào lớn hơn `(N + 1) / 2`.

Algorithm:
1. Count character frequencies.
2. Put all characters into a Max-Heap based on frequency.
3. In each step, poll the two most frequent characters.
4. Append them to result, decrement counts, and re-insert into heap.

### Complexity / Độ phức tạp
- **Time**: O(N log A) where N is string length and A is alphabet size (26).
- **Space**: O(A).

---

## Analysis / Phân tích

### Approach: Most-Frequent First Strategy
Always prioritize the character with the highest remaining count. By picking the top two, we guarantee no two identical characters end up together.
Luôn ưu tiên ký tự có số lượng còn lại cao nhất. Bằng cách chọn hai ký tự đứng đầu, chúng ta đảm bảo không có hai ký tự giống nhau nào nằm cạnh nhau.

---

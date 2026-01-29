# 1052. Grumpy Bookstore Owner / Chủ cửa hàng Sách Cáu kỉnh

## Problem Description / Mô tả bài toán
There is a bookstore owner that has a store open for `n` minutes. Every minute, some number of customers enter the store. You are given an integer array `customers` of length `n` where `customers[i]` is the number of the customers that enter the store at the start of the `i-th` minute and all those customers leave after the end of that minute.
Có một chủ cửa hàng sách mở cửa trong `n` phút. Mỗi phút, một số lượng khách hàng vào cửa hàng. Bạn được cho một mảng số nguyên `customers` có độ dài `n` trong đó `customers[i]` là số lượng khách hàng vào cửa hàng khi bắt đầu phút thứ `i` và tất cả những khách hàng đó rời đi sau khi kết thúc phút đó.

On some minutes, the bookstore owner is grumpy. You are given a binary array `grumpy` where `grumpy[i]` is `1` if the bookstore owner is grumpy during the `i-th` minute, and is `0` otherwise.
Vào một số phút, chủ cửa hàng sách cáu kỉnh. Bạn được cho một mảng nhị phân `grumpy` trong đó `grumpy[i]` là `1` nếu chủ cửa hàng sách cáu kỉnh trong phút thứ `i`, và là `0` nếu ngược lại.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
Khi chủ cửa hàng sách cáu kỉnh, khách hàng của phút đó không hài lòng, ngược lại họ hài lòng.

The bookstore owner knows a secret technique to keep themselves not grumpy for `minutes` consecutive minutes, but can only use it once.
Chủ cửa hàng sách biết một kỹ thuật bí mật để giữ cho bản thân không cáu kỉnh trong `minutes` phút liên tiếp, nhưng chỉ có thể sử dụng nó một lần.

Return the maximum number of customers that can be satisfied throughout the day.
Trả về số lượng khách hàng tối đa có thể được làm hài lòng trong suốt cả ngày.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Total Satisfied = (Originally Satisfied) + (Recovered Satisfied).
Ideally, we maximize the Recovered Satisfied.
Recovered Satisfied in a window = Sum of `customers[i]` where `grumpy[i] == 1`.

Algorithm:
1. Calculate `baseSatisfaction`: Sum of `customers[i]` where `grumpy[i] == 0`.
2. Use a sliding window of size `minutes`.
3. Calculate `recovered[i]` = `customers[i]` if `grumpy[i] == 1` else 0.
4. Find the window with max sum of `recovered`.
5. Result = `baseSatisfaction + maxRecoveredWindow`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Delta Maximization
First, tally the guaranteed satisfaction from non-grumpy minutes. Then, apply a sliding window of size X to identify the interval where suppressing grumpiness yields the highest additional satisfaction (i.e., saving the most customers who would otherwise be lost).
Đầu tiên, tính tổng mức độ hài lòng được đảm bảo từ những phút không cáu kỉnh. Sau đó, áp dụng cửa sổ trượt kích thước X để xác định khoảng thời gian mà việc kìm nén sự cáu kỉnh mang lại sự hài lòng bổ sung cao nhất (tức là, cứu được nhiều khách hàng nhất, những người mà nếu không sẽ bị mất).

---

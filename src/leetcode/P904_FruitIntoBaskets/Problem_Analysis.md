# 904. Fruit Into Baskets / Trái cây vào Giỏ

## Problem Description / Mô tả bài toán
You have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Bạn có hai chiếc giỏ, và mỗi giỏ chỉ có thể chứa một loại trái cây duy nhất. Không có giới hạn về số lượng trái cây mà mỗi giỏ có thể chứa.

Given an array `fruits` of integers, return the maximum amount of fruit you can collect while complying with the rule.
Cho một mảng số nguyên `fruits`, hãy trả về lượng trái cây tối đa bạn có thể thu thập trong khi tuân thủ quy tắc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Longest Subarray with at most 2 distinct elements / Cửa sổ trượt / Mảng con dài nhất có tối đa 2 phần tử khác nhau
This is a standard sliding window problem.
Đây là một bài toán cửa sổ trượt tiêu chuẩn.

Algorithm:
1. Initialize `left = 0`, `maxLen = 0`.
2. Use a `HashMap` to store counts of fruits in the current window.
3. For each `right` from 0 to `n-1`:
   - Add `fruits[right]` to map.
   - While `map.size() > 2`:
     - Decrement count of `fruits[left]`.
     - Remove from map if count is 0.
     - `left++`.
   - Update `maxLen = max(maxLen, right - left + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (map size is at most 3).

---

## Analysis / Phân tích

### Approach: Flexible Window Adjustment
Scan the orchard linearly. Whenever a third fruit type is encountered, shrink the start of the collection range until the variety count returns to two. The maximum width attained during this process is the answer.
Quét vườn cây một cách tuyến tính. Bất cứ khi nào gặp loại trái cây thứ ba, hãy thu hẹp điểm bắt đầu của phạm vi thu thập cho đến khi số lượng loại trái cây quay trở lại mức hai. Chiều rộng tối đa đạt được trong quá trình này chính là câu trả lời.

---

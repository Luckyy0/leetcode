# 1. Two Sum / Tổng Hai Số

## Problem Description / Mô tả bài toán
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
Cho một mảng các số nguyên `nums` và một số nguyên `target`, trả về chỉ số của hai số sao cho tổng của chúng bằng `target`.

You may assume that each input would have **exactly one solution**, and you may not use the *same* element twice.
Bạn có thể giả định rằng mỗi đầu vào sẽ có **chính xác một giải pháp**, và bạn không được sử dụng *cùng một* phần tử hai lần.

You can return the answer in any order.
Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.

### Example 1:
```text
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

### Example 2:
```text
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

### Example 3:
```text
Input: nums = [3,3], target = 6
Output: [0,1]
```

## Constraints / Ràng buộc
- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists. / Chỉ tồn tại một câu trả lời hợp lệ.

---

## Analysis / Phân tích

### Approach 1: Brute Force / Vét cạn
- **Idea**: Use two nested loops to check every pair of elements.
- **Ý tưởng**: Sử dụng hai vòng lặp lồng nhau để kiểm tra mọi cặp phần tử.
- **Time Complexity**: O(n^2). For each element, we try to find its complement by looping through the rest of the array.
- **Space Complexity**: O(1).

### Approach 2: Hash Map (Optimized) / Bảng băm (Tối ưu)
- **Idea**: We can solve this in one pass. While iterating through the array, we check if `target - current_value` exists in the map. If it exists, we found the pair. If not, we store the current value and its index in the map.
- **Ý tưởng**: Chúng ta có thể giải quyết trong một lần duyệt. Trong khi duyệt qua mảng, ta kiểm tra xem `target - giá_trị_hiện_tại` có tồn tại trong map không. Nếu có, ta đã tìm thấy cặp. Nếu không, ta lưu giá trị hiện tại và chỉ số của nó vào map.
- **Time Complexity**: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) average time.
- **Space Complexity**: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

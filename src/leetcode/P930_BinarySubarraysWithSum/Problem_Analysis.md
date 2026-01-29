# 930. Binary Subarrays With Sum / Mảng con Nhị phân có Tổng cho trước

## Problem Description / Mô tả bài toán
Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum `goal`.
Cho một mảng nhị phân `nums` và một số nguyên `goal`, hãy trả về số lượng các mảng con không rỗng có tổng bằng `goal`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum and Hashmap / Tổng tiền tố và Hashmap
Algorithm:
1. Maintain `currentSum` (count of 1s seen so far).
2. Maintain a map of frequency of prefix sums.
3. For each element:
   - `currentSum += nums[i]`.
   - Result += `countSubarraysWithSum(currentSum - goal)`.
   - Update frequency map with `currentSum`.

### Sliding Window (atMostK - atMostK-1) / Cửa sổ trượt
This can also be solved in O(1) extra space using the sliding window subtraction trick.
Bài toán này cũng có thể được giải bằng O(1) không gian bổ sung bằng cách sử dụng mẹo trừ cửa sổ trượt.

---

## Analysis / Phân tích

### Approach: Difference of At-Most
Transform the "exactly goal" requirement into a "at most goal" minus "at most goal-1" calculation. This allows the use of a simple monotonic sliding window, which is more space-efficient than maintaining a full prefix-sum frequency map.
Chuyển đổi yêu cầu "chính xác mục tiêu" thành tính toán "tối đa mục tiêu" trừ đi "tối đa mục tiêu-1". Điều này cho phép sử dụng cửa sổ trượt đơn điệu đơn giản, giúp tiết kiệm không gian hơn so với việc duy trì một bản đồ tần suất tổng tiền tố đầy đủ.

---

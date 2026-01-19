# 128. Longest Consecutive Sequence / Dãy Liên Tiếp Dài Nhất

## Problem Description / Mô tả bài toán
Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.
Cho một mảng số nguyên chưa sắp xếp `nums`, trả về độ dài của dãy các phần tử liên tiếp dài nhất.

You must write an algorithm that runs in **O(n)** time.
Bạn phải viết một thuật toán chạy trong thời gian **O(n)**.

### Example 1:
```text
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Its length is 4.
```

### Example 2:
```text
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

## Constraints / Ràng buộc
- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Why Not Sorting? / Tại sao Không Sắp xếp?
- Sorting would give O(N log N) time.
- Problem requires O(N) time.
- Need a different approach.

### HashSet Insight / Hiểu biết về HashSet
Using a HashSet gives O(1) lookup:
Sử dụng HashSet cho tra cứu O(1):

1.  Put all numbers in HashSet.
2.  For each number, if it's a **sequence start** (no num-1 in set):
    - Count consecutive numbers starting from it.
3.  Track maximum length.

### Identifying Sequence Start / Xác định Điểm Bắt đầu Dãy
A number `n` is the **start of a sequence** if `n-1` is NOT in the set.
Một số `n` là **đầu của một dãy** nếu `n-1` KHÔNG có trong tập hợp.

**Why this is O(N)?**
- Each number is visited at most twice:
    - Once when checking if it's a start.
    - Once when extending a sequence from a start.
- Total operations = O(N).

### Visual Example / Ví dụ Trực quan
```
nums = [100, 4, 200, 1, 3, 2]
Set = {100, 4, 200, 1, 3, 2}

Check each number:
- 100: 99 not in set → START! Count: 100 → length 1
- 4: 3 in set → not a start
- 200: 199 not in set → START! Count: 200 → length 1
- 1: 0 not in set → START! Count: 1,2,3,4 → length 4 ✓
- 3: 2 in set → not a start
- 2: 1 in set → not a start

Max length = 4
```

---

## Analysis / Phân tích

### Approach: HashSet with Sequence Start Detection / HashSet với Phát hiện Điểm Bắt đầu

**Algorithm**:
```
set = HashSet(nums)
maxLength = 0

for num in nums:
    if (num - 1) not in set:  // This is a sequence start
        currentNum = num
        length = 1
        
        while (currentNum + 1) in set:
            currentNum++
            length++
        
        maxLength = max(maxLength, length)

return maxLength
```

### Complexity / Độ phức tạp
- **Time**: O(N) - each number processed at most twice.
- **Space**: O(N) - for HashSet.

---

## Edge Cases / Các trường hợp biên
1.  **Empty array**: Return 0.
2.  **Single element**: Return 1.
3.  **All same elements**: Return 1.
4.  **Duplicates**: HashSet handles naturally.

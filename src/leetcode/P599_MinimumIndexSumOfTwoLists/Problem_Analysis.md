# 599. Minimum Index Sum of Two Lists / Tổng Chỉ Số Tối Thiểu Của Hai Danh Sách

## Problem Description / Mô tả bài toán
Given two arrays of strings `list1` and `list2`, find the **common strings with the least index sum**.
Cho hai mảng chuỗi `list1` và `list2`, tìm các **chuỗi chung có tổng chỉ số nhỏ nhất**.

A **common string** is a string that appeared in both `list1` and `list2`.
Một **chuỗi chung** là một chuỗi xuất hiện trong cả `list1` và `list2`.

A **common string with the least index sum** is a common string such that if it appeared at `list1[i]` and `list2[j]` then `i + j` should be the minimum value among all the common strings.
Một **chuỗi chung với tổng chỉ số nhỏ nhất** là một chuỗi chung sao cho nếu nó xuất hiện tại `list1[i]` và `list2[j]` thì `i + j` phải là giá trị tối thiểu trong số tất cả các chuỗi chung.

Return all the common strings with the least index sum. Return the answer in any order.
Trả về tất cả các chuỗi chung với tổng chỉ số nhỏ nhất. Trả về câu trả lời theo bất kỳ thứ tự nào.

### Example 1:
```text
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: Discovered "Shogun" at index 0 and 3. Sum = 3.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap / HashMap
1. Store words of `list1` in a Map: `Word -> Index`.
2. Iterate through `list2`. For each word, check if it exists in Map.
   - If yes, calculate `sum = i + j`.
   - Track `minSum`.
   - If `sum < minSum`: clear result list, add word, update `minSum`.
   - If `sum == minSum`: add word to result list.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(N * L) where L is avg string length.

---

## Analysis / Phân tích

### Approach: Hash Map Lookup

**Algorithm**:
1.  Map list1 elements to their indices.
2.  Iterate list2.
3.  Check intersection.
4.  Maintain minimum index sum logic to build result list.

---

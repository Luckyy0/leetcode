# 475. Heaters / Máy Sưởi

## Problem Description / Mô tả bài toán
Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
Mùa đông đang đến! Trong cuộc thi này, nhiệm vụ đầu tiên của bạn là thiết kế một máy sưởi tiêu chuẩn với một bán kính sưởi ấm cố định để sưởi ấm cho tất cả các ngôi nhà.

Every house can be warmed, as long as the house is within the heater's warm radius range. 
Mỗi ngôi nhà có thể được sưởi ấm nếu nó nằm trong phạm vi bán kính sưởi ấm của máy sưởi.

Given the positions of `houses` and `heaters` on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
Cho vị trí của các ngôi nhà `houses` và các máy sưởi `heaters` trên một đường thẳng nằm ngang, hãy trả về bán kính sưởi ấm tối thiểu của các máy sưởi sao cho tất cả các ngôi nhà đều được bao phủ.

### Example 1:
```text
Input: houses = [1,2,3], heaters = [2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
```

### Example 2:
```text
Input: houses = [1,2,3,4], heaters = [1,4]
Output: 1
Explanation: The two heater were placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
```

## Constraints / Ràng buộc
- `1 <= houses.length, heaters.length <= 3 * 10^4`
- `1 <= houses[i], heaters[i] <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search for Each House / Tìm kiếm nhị phân cho mỗi ngôi nhà
Each house must be warmed by at least one heater. To minimize the radius, each house should be warmed by its **nearest** heater. The overall radius must be at least the maximum of these individual minimum distances.

Algorithm:
1. Sort the `heaters` array.
2. For each `house` in `houses`:
   - Use binary search (`Arrays.binarySearch`) to find the position of the house in the `heaters` array.
   - If the house is found at index `idx`, its distance to the nearest heater is `0`.
   - If the house is not found, the search returns `-(insertion_point + 1)`.
     - Let `i = -(res + 1)`.
     - The nearest heaters are at `heaters[i-1]` (if `i > 0`) and `heaters[i]` (if `i < heaters.length`).
     - Calculate the distance to both and pick the minimum: `minDistance = min(house - heaters[i-1], heaters[i] - house)`.
3. The result is the maximum of all `minDistance` values.

### Complexity / Độ phức tạp
- **Time**: O(M log M + N log M) where M is heaters length and N is houses length.
- **Space**: O(1) beyond sorting.

---

## Analysis / Phân tích

### Approach: Closest Heater Search

**Algorithm**:
1.  Sort heaters.
2.  Binary search for each house.
3.  Calculate distances to adjacent heaters.
4.  Capture global minimum radius required.

---

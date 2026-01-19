# 218. The Skyline Problem / Bài Toán Đường Chân Trời

## Problem Description / Mô tả bài toán
A city's **skyline** is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return **the skyline** formed by these buildings collectively.
**Đường chân trời** của một thành phố là đường viền bên ngoài của hình bóng được tạo ra bởi tất cả các tòa nhà trong thành phố đó khi nhìn từ xa. Cho vị trí và chiều cao của tất cả các tòa nhà, hãy trả về **đường chân trời** được tạo ra bởi tập hợp các tòa nhà này.

The geometric information of each building is given in the array `buildings` where `buildings[i] = [left_i, right_i, height_i]`:
Thông tin hình học của mỗi tòa nhà được cung cấp trong mảng `buildings` trong đó `buildings[i] = [left_i, right_i, height_i]`:

- `left_i` is the x coordinate of the left edge of the `i-th` building.
- `right_i` is the x coordinate of the right edge of the `i-th` building.
- `height_i` is the height of the `i-th` building.

You may assume all buildings are perfect rectangles grounded on a flat surface at height 0.
Bạn có thể giả định rằng tất cả các tòa nhà là hình chữ nhật hoàn hảo đặt trên bề mặt phẳng ở độ cao 0.

The skyline should be represented as a list of "key points" **sorted by their x-coordinate** in the form `[[x1,y1],[x2,y2],...]`. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and marks the end of the skyline right after the last building.
Đường chân trời nên được biểu diễn dưới dạng danh sách các "điểm chính" **được sắp xếp theo tọa độ x** ở dạng `[[x1,y1],[x2,y2],...]`. Mỗi điểm chính là điểm cuối bên trái của một đoạn ngang trong đường chân trời ngoại trừ điểm cuối cùng trong danh sách, điểm này luôn có tọa độ y là 0 và đánh dấu sự kết thúc của đường chân trời ngay sau tòa nhà cuối cùng.

### Example 1:
```text
Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
```

### Example 2:
```text
Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]
```

## Constraints / Ràng buộc
- `1 <= buildings.length <= 10^4`
- `0 <= left_i < right_i <= 2^31 - 1`
- `1 <= height_i <= 2^31 - 1`
- `buildings` is sorted by `left_i` in non-decreasing order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sweep Line Algorithm / Thuật toán Quét Đường
We can imagine scanning a vertical line across the x-axis from left to right. The height of the skyline changes only at the **edges** (left or right) of the buildings.

**Events**:
For each building `[L, R, H]`, we have two events:
1.  **Enter Event**: At `x = L`, a building of height `H` starts.
2.  **Leave Event**: At `x = R`, a building of height `H` ends.

**Processing**:
1.  Sort all events by `x`. 
    - If `x` is same, process **starts** before **ends** (to handle adjacent buildings correctly).
    - If two starts have same `x`, process higher height first.
    - If two ends have same `x`, process lower height first.
2.  Use a **Max-Heap (Priority Queue)** to store the heights of currently active buildings.
3.  Iterate through sorted events:
    - If start event: Push height to heap.
    - If end event: Remove height from heap.
    - Check the current max height in the heap.
    - If the max height changes compared to the previous max height, add a key point `[x, currentMaxHeight]`.

**Optimization for Removal**:
Standard PriorityQueue removal is O(N). We can use a TreeMap or a Lazy Removal strategy with a second heap to improve this, or just accept O(N) since heap size is small on average (number of overlapping buildings).
Actually, for constraints N=10^4, O(N^2) worst case is acceptable but risky. Map<Height, Count> (Using TreeMap) gives O(log N) removal.

---

## Analysis / Phân tích

### Approach: Sweep Line with TreeMap

**Algorithm**:
1.  Create points: `(L, -H)` for start, `(R, H)` for end. Sorting trick: `start` events have negative height to distinguish and sort properly.
2.  Sort points:
    - Primary: `x` coordinate.
    - Secondary: `height`.
        - If both start: `(-H)` ensures larger height comes first.
        - If both end: `(H)` ensures smaller height comes first.
        - If one start one end: Start `(-H)` comes before End `(H)`.
3.  Use `TreeMap<Integer, Integer>` as a multiset for active heights: `height -> count`.
4.  Initially add `0` to TreeMap (ground).
5.  `prevMax = 0`.
6.  Loop through points:
    - If start (`h < 0`): Add `-h` to map.
    - If end (`h > 0`): Remove `h` from map (decrement count).
    - `currMax = map.lastKey()`.
    - If `currMax != prevMax`:
        - Add `[x, currMax]` to result.
        - `prevMax = currMax`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) - Sorting takes O(N log N), TreeMap operations take O(log N) for each of 2N points.
- **Space**: O(N) - To store points and map entries.

---

## Edge Cases / Các trường hợp biên
1.  **Adjacent Buildings**: `[0,2,3], [2,5,3]`. Result `[[0,3], [5,0]]`.
2.  **Containment**: One building inside another.
3.  **Same start/end**: Sorting order handles this.

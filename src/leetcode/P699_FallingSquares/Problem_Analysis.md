# 699. Falling Squares / Các khối vuông đang rơi

## Problem Description / Mô tả bài toán
There are several squares being dropped onto the X-axis of a 2D plane. You are given a 2D integer array `positions` where `positions[i] = [left_i, sideLength_i]` represents the `ith` square with a side length `sideLength_i` that is dropped with its left edge aligned with X-coordinate `left_i`.
Có một vài hình vuông đang được thả xuống trục X của một mặt phẳng 2D. Bạn được cung cấp một mảng số nguyên 2D `positions` trong đó `positions[i] = [left_i, sideLength_i]` đại diện cho hình vuông thứ `i` với độ dài cạnh `sideLength_i` được thả xuống với cạnh trái của nó căn chỉnh với tọa độ X `left_i`.

Each square is dropped one by one from an infinite height. After all squares are dropped, return a list where each element represents the maximum height reached by any square so far.
Mỗi hình vuông được thả từng cái một từ độ cao vô hạn. Sau khi tất cả các hình vuông được thả xuống, hãy trả về một danh sách trong đó mỗi phần tử đại diện cho độ cao tối đa mà bất kỳ hình vuông nào đạt được cho đến nay.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Tracking / Theo dõi Khoảng
When a square `[left, left + side]` falls, it lands on top of existing squares in that range.
Khi một hình vuông `[left, left + side]` rơi xuống, nó sẽ nằm trên các hình vuông hiện có trong phạm vi đó.

Its base height will be the maximum height already present in `[left, left + side]`.
Độ cao cơ sở của nó sẽ là độ cao tối đa đã có sẵn trong `[left, left + side]`.

Algorithm:
1. Maintain a list of intervals with their current heights.
2. For each new square:
   - Find all overlapping intervals.
   - The square's new top height is `maxHeightInIntervals + sideLength`.
   - Update the global maximum height.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the number of squares.
- **Space**: O(N) to store current heights.

---

## Analysis / Phân tích

### Approach: Brute Force Interval Search
Because N is small (1000), an O(N^2) approach checking overlaps with all previous squares is acceptable. For each new square, find the max height of all intersecting squares already placed.
Vì N nhỏ (1000), phương pháp O(N^2) kiểm tra sự chồng chéo với tất cả các hình vuông trước đó là có thể chấp nhận được. Đối với mỗi hình vuông mới, hãy tìm độ cao tối đa của tất cả các hình vuông giao nhau đã được đặt.

---

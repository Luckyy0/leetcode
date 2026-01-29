# 702. Search in a Sorted Array of Unknown Size / Tìm kiếm trong Mảng được Sắp xếp có Kích thước Không xác định

## Problem Description / Mô tả bài toán
This is an interactive problem.
Đây là một bài toán tương tác.

You have a sorted array of unique elements and an unknown size. You can only access the array through an `ArrayReader` interface, which has a function `get(k)` that returns the element at index `k`.
Bạn có một mảng đã sắp xếp gồm các phần tử duy nhất và kích thước không xác định. Bạn chỉ có thể truy cập mảng thông qua giao diện `ArrayReader`, có hàm `get(k)` trả về phần tử tại chỉ số `k`.

If the index `k` is out of bounds of the array, `ArrayReader.get(k)` returns `2^31 - 1`.
Nếu chỉ số `k` nằm ngoài phạm vi của mảng, `ArrayReader.get(k)` sẽ trả về `2^31 - 1`.

Given a `target` value, return its index if it exists in the array, otherwise return `-1`.
Cho một giá trị `target`, hãy trả về chỉ số của nó nếu nó tồn tại trong mảng, ngược lại trả về `-1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Exponential Search / Tìm kiếm theo Số mũ
Since the size is unknown, we first need to find a range `[left, right]` that contains the target.
Vì kích thước chưa biết, trước tiên chúng ta cần tìm một phạm vi `[left, right]` chứa mục tiêu.

1. Start with `right = 1`.
2. As long as `reader.get(right)` is less than target, double `right`: `right = right * 2`.
3. Once we have a bound, use Binary Search within `[right / 2, right]`.

### Complexity / Độ phức tạp
- **Time**: O(log T) where T is the index of the target.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Range Discovery + Binary Search
We efficiently find an upper bound by doubling the index. Then, we perform a standard binary search. Out-of-bounds values (`Integer.MAX_VALUE`) naturally higher than target will correctly shrink the search space.
Chúng ta tìm giới hạn trên một cách hiệu quả bằng cách nhân đôi chỉ số. Sau đó, chúng ta thực hiện tìm kiếm nhị phân tiêu chuẩn. Các giá trị ngoài phạm vi (`Integer.MAX_VALUE`) cao hơn mục tiêu một cách tự nhiên sẽ thu hẹp không gian tìm kiếm một cách chính xác.

---

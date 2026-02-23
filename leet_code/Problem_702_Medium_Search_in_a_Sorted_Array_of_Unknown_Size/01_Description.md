# Result for Search in a Sorted Array of Unknown Size
# *Kết quả cho bài toán Tìm kiếm trong Mảng đã sắp xếp có Kích thước Không xác định*

## Description
## *Mô tả*

This is an interactive problem.
*Đây là một bài toán tương tác.*

You have a sorted array of unique elements and an unknown size. You can only access the array through an `ArrayReader` interface, which has a function `get(k)` that returns the value at index `k`.
*Bạn có một mảng đã sắp xếp gồm các phần tử duy nhất và kích thước không xác định. Bạn chỉ có thể truy cập mảng thông qua giao diện `ArrayReader`, giao diện này có hàm `get(k)` trả về giá trị tại chỉ số `k`.*

If the index `k` is out of bounds, `ArrayReader.get(k)` returns `2^31 - 1`.
*Nếu chỉ số `k` nằm ngoài phạm vi, `ArrayReader.get(k)` trả về `2^31 - 1`.*

You are also given an integer `target`. Return the index `k` such that `reader.get(k) == target`. If `target` does not exist, return `-1`.
*Bạn cũng được cho một số nguyên `target`. Hãy trả về chỉ số `k` sao cho `reader.get(k) == target`. Nếu `target` không tồn tại, trả về `-1`.*

You must write an algorithm with $O(\log T)$ time complexity, where $T$ is the actual index of the target.
*Bạn phải viết một thuật toán với độ phức tạp thời gian $O(\log T)$, trong đó $T$ là chỉ số thực sự của mục tiêu.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= target <= 10^4`
*   The array and `target` elements are integers in the range `[-10^4, 10^4]`.

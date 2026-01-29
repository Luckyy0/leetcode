# 981. Time Based Key-Value Store / Cửa trữ Giá trị-Khóa dựa trên Thời gian

## Problem Description / Mô tả bài toán
Design a time-based key-value data structure that can store multiple values for the same key at different timestamps and retrieve the key's value at a certain timestamp.
Thiết kế một cấu trúc dữ liệu khóa-giá trị dựa trên thời gian có thể lưu trữ nhiều giá trị cho cùng một khóa tại các dấu thời gian khác nhau và lấy giá trị của khóa tại một dấu thời gian nhất định.

Methods:
- `set(key, value, timestamp)`: Stores the key with its value and timestamp.
- `get(key, timestamp)`: Returns the value such that `timestamp_prev <= timestamp` and `timestamp_prev` is maximal.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search (TreeMap or Sorted List) / Tìm kiếm Nhị phân (TreeMap hoặc Danh sách sắp xếp)
Algorithm:
1. Use a `Map<String, TreeMap<Integer, String>>` to store keys and their values over time.
2. `set`: Simply put the value in the TreeMap.
3. `get`: Use `floorKey(timestamp)` to find the largest timestamp $\le$ given timestamp.

Alternatively, store timestamps in a `List` (since they are added in increasing order) and use `Collections.binarySearch`.

### Complexity / Độ phức tạp
- **Set**: O(log N) with TreeMap, O(1) with List.
- **Get**: O(log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Historical versioning
Maintain a chronological record for each key. By utilizing a sorted structure, we can efficiently perform "point-in-time" queries, identifying the most recent state of a key before or at the requested moment.
Duy trì hồ sơ theo trình tự thời gian cho mỗi khóa. Bằng cách sử dụng cấu trúc đã sắp xếp, chúng ta có thể thực hiện hiệu quả các truy vấn "tại một thời điểm", xác định trạng thái gần đây nhất của một khóa trước hoặc tại thời điểm được yêu cầu.

---

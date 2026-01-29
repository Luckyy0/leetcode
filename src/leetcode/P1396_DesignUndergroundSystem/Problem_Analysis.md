# 1396. Design Underground System / Thiết kế Hệ thống Tàu điện ngầm

## Problem Description / Mô tả bài toán
Design `UndergroundSystem`.
- `checkIn(id, stationName, t)`
- `checkOut(id, stationName, t)`
- `getAverageTime(startStation, endStation)`
Average time between stations.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hash Maps
Map1: `checkIns`: `id -> {startStation, startTime}`.
Map2: `travelTimes`: `startStation + "->" + endStation -> {totalTime, totalTrips}`.
On `checkIn`: Update Map1.
On `checkOut`:
- Retrieve `startStation`, `startTime` from Map1.
- Calc `time = t - startTime`.
- Update Map2 for route `start -> end`. Add `time` to total, increment count.
- Remove from Map1.
On `getAverage`: Retrieve from Map2, return `totalTime / totalTrips`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all ops.
- **Space**: O(N + S^2) where N is active users, S is stations.

---

## Analysis / Phân tích

### Approach: Two HashMaps
Maintain `checkIns` map to track users currently in transit. Key: userId, Value: (stationName, time).
Maintain `travelData` map to accumulate travel statistics between pairs of stations. Key: "startStation->endStation", Value: (totalTime, count).
`checkOut` computes the travel duration and updates the statistics for the specific route. `getAverageTime` simply computes the average from the stored statistics.
Duy trì bản đồ `checkIns` để theo dõi người dùng hiện đang di chuyển. Khóa: userId, Giá trị: (stationName, time).
Duy trì bản đồ `travelData` để tích lũy số liệu thống kê du lịch giữa các cặp nhà ga. Khóa: "startStation->endStation", Giá trị: (totalTime, count).
`checkOut` tính toán thời lượng di chuyển và cập nhật thống kê cho tuyến đường cụ thể. `getAverageTime` chỉ cần tính trung bình từ các số liệu thống kê đã lưu trữ.

---

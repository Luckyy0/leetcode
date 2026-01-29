# 1418. Display Table of Food Orders in a Restaurant / Hiển thị Bảng Đơn đặt hàng Thực phẩm trong Nhà hàng

## Problem Description / Mô tả bài toán
Input: List of orders `[customerName, tableNumber, foodItem]`.
Output: Table.
Columns: "Table", sorted food items.
Rows: sorted by table number. Cells: count of food items.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hash Maps and Sorting
Map `TableNumber -> Map<FoodItem, Count>`.
Set `FoodItems` to collect unique foods. Sort them.
Sort `TableNumber`.
Construct output.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Nested Maps + Sorting
Use a `TreeMap<Integer, Map<String, Integer>>` to store data grouped by table (automatically sorted map keys).
Use a `TreeSet<String>` to collect unique food items (automatically sorted).
Iterate orders to populate map and set.
Build the result list. Header: "Table", then food items.
Rows: Table number, then counts (default 0).
Convert table number to String.
Sử dụng `TreeMap<Integer, Map<String, Integer>>` để lưu trữ dữ liệu được nhóm theo bảng (các khóa bản đồ được sắp xếp tự động).
Sử dụng `TreeSet<String>` để thu thập các mặt hàng thực phẩm độc đáo (được sắp xếp tự động).
Lặp lại các đơn đặt hàng để điền vào bản đồ và thiết lập.
Xây dựng danh sách kết quả. Tiêu đề: "Bàn", sau đó là các mặt hàng thực phẩm.
Hàng: Số bàn, sau đó là số đếm (mặc định 0).

---

# 1389. Create Target Array in the Given Order / Tạo Mảng Mục tiêu theo Thứ tự Đã cho

## Problem Description / Mô tả bài toán
Arrays `nums` and `index`.
Insert `nums[i]` at `index[i]` in target array.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / List Insertion
Use a List (ArrayList). Iterate `i`, call `list.add(index[i], nums[i])`.
Convert back to array.

### Complexity / Độ phức tạp
- **Time**: O(N^2) due to shifting elements.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: List Insert
Simply iterate through the input arrays and insert elements into an `ArrayList` at the specified indices. Java's `ArrayList.add(index, element)` handles shifting automatically. Finally, convert the list to an array.
Chỉ cần lặp qua các mảng đầu vào và chèn các phần tử vào một `ArrayList` tại các chỉ số được chỉ định. `ArrayList.add(index, element)` của Java xử lý việc dịch chuyển tự động. Cuối cùng, chuyển đổi danh sách thành một mảng.

---

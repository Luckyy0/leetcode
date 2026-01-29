# 1352. Product of the Last K Numbers / Tích của K Số Cuối cùng

## Problem Description / Mô tả bài toán
Design `ProductOfNumbers`.
- `add(num)`: Appends num to stream.
- `getProduct(k)`: Returns product of last k.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Product with Reset on Zero
Store prefix products in list `prefix`. `prefix[i] = product(nums[0]...nums[i])`.
Product of last `k` is `prefix[n-1] / prefix[n-1-k]`.
Issue: Zeros.
If `num == 0`:
- Reset prefix list to `[1]`.
- Maintain correct count of elements seen since last zero.
- If `k > count`, answer is 0 (because zero is in the range).
- If `k <= count`, use prefix division.

### Complexity / Độ phức tạp
- **Time**: add O(1), getProduct O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix Products List
Maintain an ArrayList of prefix products. Initialize with `1`.
When adding a number `num`:
- If `num == 0`: Clear the list and reset it to `[1]`.
- If `num > 0`: Add `num * last_element` to the list.
When querying `getProduct(k)`:
- Let `n` be the size of the list. `n-1` is the number of elements added since last 0.
- If `k >= n` (meaning the range includes the last zero reset, or we haven't added enough numbers - impossible per constraints?), return `0`.
  - Wait, list size is `count + 1`. If `k < size`, valid non-zero range. If `k >= size`, it means we must have crossed a zero.
- Return `list.get(size - 1) / list.get(size - 1 - k)`.
Duy trì một ArrayList của các tích tiền tố. Khởi tạo với `1`.
Khi thêm một số `num`:
- Nếu `num == 0`: Xóa danh sách và đặt lại thành `[1]`.
- Nếu `num > 0`: Thêm `num * last_element` vào danh sách.
Khi truy vấn `getProduct(k)`:
- Gọi `n` là kích thước của danh sách. `n-1` là số lượng phần tử được thêm kể từ số 0 cuối cùng.
- Nếu `k >= n`, trả về `0`.
- Trả về `list.get(size - 1) / list.get(size - 1 - k)`.

---

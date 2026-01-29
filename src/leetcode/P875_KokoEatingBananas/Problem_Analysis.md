# 875. Koko Eating Bananas / Koko Ăn Chuối

## Problem Description / Mô tả bài toán
Koko loves to eat bananas. There are `n` piles of bananas. The `ith` pile has `piles[i]` bananas. The guards will be back in `h` hours.
Koko thích ăn chuối. Có `n` nải chuối. Nải thứ `i` có `piles[i]` quả chuối. Các lính gác sẽ quay lại sau `h` giờ.

Koko can decide her bananas-per-hour eating speed `k`. Each hour, she chooses some pile and eats `k` bananas. If the pile has less than `k`, she finishes it and doesn't eat more during that hour.
Koko có thể quyết định tốc độ ăn chuối mỗi giờ là `k`. Mỗi giờ, cô ấy chọn một nải và ăn `k` quả. Nếu nải có ít hơn `k` quả, cô ấy ăn hết nải đó và không ăn thêm trong giờ đó.

Return the minimum integer `k` such that she can eat all bananas within `h` hours.
Trả về số nguyên `k` nhỏ nhất sao cho cô ấy có thể ăn hết tất cả chuối trong vòng `h` giờ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm kiếm Nhị phân trên Kết quả
If Koko can finish all bananas with speed `k`, she can also finish with any speed `k' > k`.
Nếu Koko có thể ăn hết chuối với tốc độ `k`, cô ấy cũng có thể hoàn thành với bất kỳ tốc độ `k' > k` nào.
This monotonic property allows binary search.

Algorithm:
1. Search range: `low = 1`, `high = max(piles)`.
2. For a speed `mid`:
   - Calculate total hours required: `sum(ceil(piles[i] / mid))`.
   - If `totalHours <= h`, try smaller speed (`high = mid`).
   - Else, try larger speed (`low = mid + 1`).

### Complexity / Độ phức tạp
- **Time**: O(N log(max(Piles))).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Goal-Oriented Binary Search
The problem asks for the lower bound of a feasible range. By testing middle values and calculating the aggregate time penalty for each eating rate, we pinpoint the minimum speed that satisfies the time constraint.
Bài toán yêu cầu tìm giới hạn dưới của một phạm vi khả thi. Bằng cách thử các giá trị ở giữa và tính toán tổng hình phạt thời gian cho mỗi tốc độ ăn, chúng ta xác định được tốc độ tối thiểu thỏa mãn ràng buộc về thời gian.

---

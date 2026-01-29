# 1058. Minimize Rounding Error to Meet Target / Giảm thiểu Sai số Làm tròn để Đạt Mục tiêu

## Problem Description / Mô tả bài toán
Given an array of prices `[p_1, p_2, ..., p_n]` and a `target`, round each price `p_i` to `Floor(p_i)` or `Ceil(p_i)` such that the sum of the rounded array equals `target`. Each operation has a partial rounding error `|rounded - p_i|`.
Cho một mảng giá `[p_1, p_2, ..., p_n]` và một `target`, hãy làm tròn mỗi giá `p_i` thành `Floor(p_i)` hoặc `Ceil(p_i)` sao cho tổng của mảng đã làm tròn bằng `target`. Mỗi thao tác có sai số làm tròn một phần `|rounded - p_i|`.

Return the smallest possible total rounding error. If it is impossible, return "-1".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Selection / Lựa chọn Tham lam
Let `floorSum` be the sum of floors.
Let `ceilSum` be the sum of ceils.
If `target < floorSum` or `target > ceilSum`, impossible.

Let `k = target - floorSum`. We need to choose exactly `k` numbers to round up (ceil), and `n-k` numbers to round down (floor).
Cost of rounding up: `Ceil(x) - x` = `1 - frac(x)` (if not integer).
Cost of rounding down: `x - Floor(x)` = `frac(x)`.

We want to minimize Total Error = Sum(chosen for ceil: `1 - frac`) + Sum(chosen for floor: `frac`).
Difference: `Cost(ceil) - Cost(floor) = (1-frac) - frac = 1 - 2*frac`.
We should choose items where `Cost(ceil) - Cost(floor)` is minimized (most negative). High `frac` means `1-2*frac` is small.
So we pick items with largest fractional parts to round up.

Special case: Integers have `frac=0`, cost 0 for both (since floor=ceil). Don't count them in `k`. `k` is strict needed sum increase.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Fractional Residue Priority
Calculate the baseline sum using only floor operations. Determine the deficit $K$ needed to reach the target. To cover this deficit efficiently, select exactly $K$ numbers to round up (ceil) instead of down. To minimize error, prioritize rounding up numbers that are already closest to their ceiling (largest fractional part).
Tính tổng cơ sở chỉ sử dụng các thao tác làm tròn xuống (floor). Xác định mức thâm hụt $K$ cần thiết để đạt được mục tiêu. Để bù đắp sự thâm hụt này một cách hiệu quả, hãy chọn chính xác $K$ số để làm tròn lên (ceil) thay vì làm tròn xuống. Để giảm thiểu sai số, hãy ưu tiên làm tròn lên các số đã gần nhất với trần của chúng (phần thập phân lớn nhất).

---

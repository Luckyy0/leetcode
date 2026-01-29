# 672. Bulb Switcher II / Máy nhấn bóng đèn II

## Problem Description / Mô tả bài toán
There is a room with `n` bulbs labeled from 1 to `n` that all are initially on. You can perform four types of operations:
Có một căn phòng với `n` bóng đèn được đánh số từ 1 đến `n` ban đầu đều đang bật. Bạn có thể thực hiện bốn loại thao tác:

1. Flip all the bulbs. / Đảo ngược tất cả các bóng đèn.
2. Flip bulbs with even labels. / Đảo ngược bóng đèn có nhãn chẵn.
3. Flip bulbs with odd labels. / Đảo ngược bóng đèn có nhãn lẻ.
4. Flip bulbs with labels `j = 3k + 1` (1, 4, 7, ...). / Đảo ngược bóng đèn có nhãn `j = 3k + 1`.

Given `n` bulbs and `presses` operations, return the number of different possible statuses of the `n` bulbs.
Cho `n` bóng đèn và `presses` thao tác, hãy trả về số lượng các trạng thái khác nhau có thể có của `n` bóng đèn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pattern Recognition / Nhận diện Quy luật
The behavior of bulbs repeats every 6 bulbs (LCM of 2 and 3). However, we only need to look at the first 3 bulbs to distinguish all cases.
Hành vi của các bóng đèn lặp lại sau mỗi 6 bóng đèn (BCNN của 2 và 3). Tuy nhiên, chúng ta chỉ cần nhìn vào 3 bóng đèn đầu tiên để phân biệt tất cả các trường hợp.

If `presses` is large, the number of states converges to a small constant.
Nếu `presses` lớn, số lượng trạng thái sẽ hội tụ về một hằng số nhỏ.

Cases:
- `presses = 0`: 1 state (all ON).
- `n = 1`: 2 states (1, 3, 4 are same; 2 skips). Actually, only 2 states possible: ON/OFF.
- `n = 2`:
  - `presses = 1`: 3 states.
  - `presses >= 2`: 4 states.
- `n >= 3`:
  - `presses = 1`: 4 states.
  - `presses = 2`: 7 states.
  - `presses >= 3`: 8 states.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Constant Case Analysis
Identify the results based on the small values of `n` and `presses`.
Xác định kết quả dựa trên các giá trị nhỏ của `n` và `presses`.

---

# Result for Koko Eating Bananas
# *Kết quả cho bài toán Koko Ăn Chuối*

## Description
## *Mô tả*

Koko loves to eat bananas. There are `n` piles of bananas, the `i`-th pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.
*Koko rất thích ăn chuối. Có `n` nải chuối, nải thứ `i` có `piles[i]` quả. Các lính canh đã đi và sẽ quay lại sau `h` giờ.*

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.
*Koko có thể quyết định tốc độ ăn chuối mỗi giờ là `k`. Mỗi giờ, cô ấy chọn một nải chuối và ăn `k` quả từ nải đó. Nếu nải đó có ít hơn `k` quả, cô ấy sẽ ăn hết và sẽ không ăn thêm bất kỳ quả chuối nào nữa trong giờ đó.*

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
*Koko muốn ăn chậm nhưng vẫn muốn ăn hết tất cả số chuối trước khi lính canh quay lại.*

Return *the minimum integer `k` such that she can eat all the bananas within `h` hours*.
*Trả về *số nguyên `k` nhỏ nhất sao cho cô ấy có thể ăn hết tất cả số chuối trong vòng `h` giờ*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** piles = [3,6,7,11], h = 8
**Output:** 4

## Example 2:
## *Ví dụ 2:*

**Input:** piles = [30,11,23,4,20], h = 5
**Output:** 30

## Example 3:
## *Ví dụ 3:*

**Input:** piles = [30,11,23,4,20], h = 6
**Output:** 23

---

## Constraints:
## *Ràng buộc:*

*   `1 <= piles.length <= 10^4`
*   `piles.length <= h <= 10^9`
*   `1 <= piles[i] <= 10^9`

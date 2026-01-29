# 881. Boats to Save People / Thuyền Cứu người

## Problem Description / Mô tả bài toán
You are given an array `people` where `people[i]` is the weight of the `ith` person, and an infinite number of boats where each boat can carry a maximum weight of `limit`.
Bạn được cấp một mảng `people` trong đó `people[i]` là trọng lượng của người thứ `i` và số lượng thuyền vô hạn, mỗi thuyền có thể chở trọng lượng tối đa là `limit`.

Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most `limit`.
Mỗi chiếc thuyền chở tối đa hai người cùng lúc, miễn là tổng trọng lượng của những người đó tối đa là `limit`.

Return the minimum number of boats to carry every given person.
Hãy trả về số lượng thuyền ít nhất để chở tất cả những người đã cho.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Two Pointers / Tham lam với Hai con trỏ
The goal is to pair the heaviest person with the lightest person possible.
Mục tiêu là ghép cặp người nặng nhất với người nhẹ nhất có thể.

Algorithm:
1. Sort the `people` array.
2. Initialize `i = 0` (lightest) and `j = n - 1` (heaviest).
3. While `i <= j`:
   - Always take the heaviest person `j`. One boat used.
   - If `people[i] + people[j] <= limit`, the lightest person can also fit in the same boat. Increment `i`.
   - Decrement `j`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(log N) for sorting overhead.

---

## Analysis / Phân tích

### Approach: Marginal Pairing
By attempting to "fit" the lightest person alongside the heaviest person in each boat, we maximize the utilization of each boat's two-person capacity. If the combination exceeds the limit, the heaviest person must occupy a boat alone.
Bằng cách cố gắng "xếp" người nhẹ nhất cùng với người nặng nhất trong mỗi chiếc thuyền, chúng ta tối đa hóa việc sử dụng sức chứa hai người của mỗi chiếc thuyền. Nếu sự kết hợp vượt quá giới hạn, người nặng nhất phải đi thuyền một mình.

---

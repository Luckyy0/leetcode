# 825. Friends Of Appropriate Ages / Bạn bè ở Độ tuổi Thích hợp

## Problem Description / Mô tả bài toán
There are `n` persons on a social media website. Each person has an age.
Có `n` người trên một trang mạng xã hội. Mỗi người có một độ tuổi.

A person `x` will NOT send a friend request to person `y` if any of these conditions are true:
Người `x` sẽ KHÔNG gửi lời mời kết bạn cho người `y` nếu bất kỳ điều kiện nào sau đây là đúng:
1. `age[y] <= 0.5 * age[x] + 7`
2. `age[y] > age[x]`
3. `age[y] > 100 && age[x] < 100`

Return the total number of friend requests made.
Hãy trả về tổng số lời mời kết bạn được thực hiện.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency counting and Range logic / Đếm tần suất và Logic phạm vi
The number of people is large ($2 \cdot 10^4$), but ages are small ($1-120$).
Số lượng người lớn, nhưng độ tuổi nhỏ ($1-120$).

We can count the frequency of each age.
Chúng ta có thể đếm tần suất của mỗi độ tuổi.

Condition: `x` sends to `y` if `y` is in range `(0.5 * age[x] + 7, age[x]]`.
Note: if the lower bound is greater than or equal to the upper bound, no requests are sent.

Algorithm:
1. Count people for each age: `count[121]`.
2. For each age `x` (1 to 120):
   - For each age `y` (1 to 120):
     - Check the conditions.
     - If satisfied, `requests += count[x] * (count[y] - (x == y ? 1 : 0))`.

### Complexity / Độ phức tạp
- **Time**: O(A^2 + N) where A is max age (120) and N is number of persons.
- **Space**: O(A).

---

## Analysis / Phân tích

### Approach: Age Bucket Optimization
Instead of checking every pair of users, we check every pair of age values. Since the variety of ages is extremely limited, this drastically reduces the number of operations.
Thay vì kiểm tra mọi cặp người dùng, chúng ta kiểm tra mọi cặp giá trị tuổi. Vì sự đa dạng về lứa tuổi cực kỳ hạn chế, điều này làm giảm đáng kể số lượng thao tác.

---

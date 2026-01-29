# 458. Poor Pigs / Những Chú Heo Đáng Thương

## Problem Description / Mô tả bài toán
There are `buckets` buckets of liquid, where **exactly one** of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not.
Có `buckets` xô đựng chất lỏng, trong đó có **đúng một** xô có độc. Để tìm ra xô nào có độc, bạn cho một số lượng lợn nhất định uống chất lỏng để xem chúng có chết hay không.

- You can feed a pig liquid from any number of buckets at once.
- The outcome (death) will happen after `minutesToDie` minutes.
- You have `minutesToTest` minutes in total.

Given `buckets`, `minutesToDie`, and `minutesToTest`, return the **minimum** number of pigs needed to find the poisonous bucket within the allotted time.
Cho `buckets`, `minutesToDie`, và `minutesToTest`, hãy trả về số lượng lợn **tối thiểu** cần thiết để tìm ra xô có độc trong thời gian quy định.

### Example 1:
```text
Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
Output: 2
Explanation: 2 pigs can test 4 buckets in 15 minutes. 
(Pig 1 drinks 1,2; Pig 2 drinks 1,3. If 1 dies, pig 1,2 die. If 2 dies, pig 1 dies. If 3 dies, pig 2 dies. If 4 dies, neither die).
Wait, the actual logic is base-P representation.
```

### Example 2:
```text
Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
Output: 5
```

## Constraints / Ràng buộc
- `1 <= buckets <= 1000`
- `1 <= minutesToDie <= minutesToTest <= 1000`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Information Theory (Base-P Representation) / Lý thuyết thông tin
Let `T = minutesToTest / minutesToDie`. This is the number of **rounds** of testing we can perform.
Each pig can provide information based on which round it dies in, or if it survives all rounds.
So, each pig can represent `T + 1` states.

If we have `n` pigs, total possible states (buckets we can distinguish) is `(T + 1)^n`.
We need `(T + 1)^n >= buckets`.

Solving for `n`:
`n >= log(buckets) / log(T + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Logarithmic Bound

**Algorithm**:
1.  Calculate `rounds = minutesToTest / minutesToDie`.
2.  Calculate `states = rounds + 1`.
3.  Calculate `pigs = ceil(log(buckets) / log(states))`.

---

# Analysis for Pairs of Songs With Total Durations Divisible by 60
# *Phân tích cho bài toán Cặp bài hát có tổng chia hết cho 60*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an array `time`, find the number of pairs `(i, j)` where `i < j` and `(time[i] + time[j]) % 60 == 0`.
*Cho một mảng `time`, tìm số cặp `(i, j)` sao cho `i < j` và `(time[i] + time[j]) % 60 == 0`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The goal is about divisibility. We don't care about the absolute song duration, only its remainder when divided by 60 (`time[i] % 60`).
- If `a % 60 == x` and `b % 60 == y`, then `(a + b) % 60 == 0` if and only if `(x + y) % 60 == 0`.
- Thus, for any song with remainder `r`, we need to find how many previously seen songs have a remainder of `(60 - r) % 60`.
*Mục tiêu là kiểm tra tính chia hết. Chúng ta không quan tâm thời lượng tuyệt đối mà chỉ quan tâm phần dư của nó khi chia cho 60 (`time[i] % 60`). Nếu `a % 60 == x` và `b % 60 == y`, thì `(a + b) % 60 == 0` khi và chỉ khi `(x + y) % 60 == 0`. Do đó, với mỗi bài hát có số dư `r`, ta cần tìm xem đã có bao nhiêu bài hát đằng trước mang số dư `(60 - r) % 60`.*

---

## 2. Strategy 1: Naive (Two Pointers / Nested Loops)
## *2. Chiến lược 1: Ngây thơ (Hai con trỏ / Vòng lặp lồng nhau)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to simply check every possible pair of songs and see if their sum is a multiple of 60.
*Ý tưởng ngây thơ là kiểm tra mọi cặp bài hát có thể có và xem liệu tổng của chúng có phải là bội số của 60 hay không.*

```java
public class Solution {
    public int numPairsDivisibleBy60Naive(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

- **Weakness (Điểm yếu):** We are checking every possible pair. The number of pairs is $N(N-1)/2$. So the time complexity is $O(N^2)$. With the constraint $N = 6 \times 10^4$, $N^2$ is roughly $3.6 \times 10^9$, which is too slow and will cause a Time Limit Exceeded (TLE) error.
  *Chúng ta kiểm tra mọi cặp. Số cặp là $N(N-1)/2$. Vậy độ phức tạp thời gian là $O(N^2)$. Với ràng buộc $N = 6 \times 10^4$, $N^2$ xấp xỉ $3.6 \times 10^9$, quá chậm và sẽ gây ra lỗi TLE (Quá giới hạn thời gian).*

---

## 3. Strategy 2: Optimal (Hash Map / Frequency Array)
## *3. Chiến lược 2: Tối ưu (Bảng băm / Mảng tần suất)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of checking every pair, we can maintain the count of frequencies of each remainder (from 0 to 59). As we iterate through the `time` array, for each song, we compute its remainder `r = t % 60`. We know exactly what remainder is needed to complement it: it's `(60 - r) % 60`. We add the frequency of this required remainder to our total count, and then we increment the frequency of our current remainder `r` for future songs to pair with. This replaces the inner loop with a constant-time $O(1)$ array lookup!
*Thay vì kiểm tra mọi cặp, chúng ta đếm tần suất của mỗi phần dư (từ 0 đến 59). Khi duyệt qua mảng `time`, với mỗi bài hát, ta lấy phần dư của nó là `r = t % 60`. Chúng ta biết chính xác phần dư bù để tạo thành cặp là `(60 - r) % 60`. Ta lấy tần suất xuất hiện của phần dư bù này cộng thẳng vào tổng số cặp, rồi mới đưa tần suất của `r` hiện tại lên 1 cho các bài hát sau sử dụng. Điều này thay thế vòng lặp bên trong bằng phép tra cứu mảng độ phức tạp tĩnh $O(1)$!*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Remainder Array:** Create an array `remainders` of size 60 initialized to `0` to keep track of the counts of each remainder. Counter `pairs = 0`.
    *   *Khởi tạo mảng Số dư: Khởi tạo mảng `remainders` cỡ 60 mang số 0 để theo dõi các phần dư. Bộ đếm `pairs = 0`.*
2.  **Iterate and Pair:** Loop through each `t` in `time`.
    *   *Lặp và Ghép cặp: Lặp mỗi biến `t` trong mảng `time`.*
    - Calculate `r = t % 60`.
      *Tính `r = t % 60`.*
    - The target remainder we want to find in the pool is `target = (60 - r) % 60` (the `% 60` resolves the case when `r == 0`).
      *Gót dư phần khuyết đang cần tìm trong kho là `target = (60 - r) % 60`  (phép `% 60` xử lý triệt chừng hợp phần dư 0 thì không ra số 60).*
    - Add `remainders[target]` to `pairs`.
      *Cộng `remainders[target]` vào `pairs`.*
    - Increment our pool: `remainders[r]++`.
      *Đẩy phần tử này vào kho: `remainders[r]++`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        
        for (int t : time) {
            int r = t % 60;
            // The complement that adds up to a multiple of 60
            int complement = (60 - r) % 60;
            
            // Add pairs formed with previous matching elements
            count += remainders[complement];
            
            // Increment the frequency of the current remainder for future elements
            remainders[r]++;
        }
        
        return count;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of songs. We only do one linear scan through the array of length $N$, with $O(1)$ array lookups.
    *   **Độ phức tạp thời gian:** $O(N)$ với $N$ là tổng số lượng các bài hát. Chúng ta chỉ quét mảng đúng 1 lượt, việc tra bảng tần suất tốn $O(1)$.*
*   **Space Complexity:** $O(1)$. The auxiliary array `remainders` always has exactly length 60, irrespective of $N$. So it takes constant memory space constraints.
    *   **Độ phức tạp không gian:** $O(1)$. Mảng đếm phụ trợ `remainders` lúc nào cũng dài chẵn 60 ô, hoàn toàn không dính dáng đến số $N$. Vì vật nó chiếm chuẩn bộ nhớ tĩnh constant.*

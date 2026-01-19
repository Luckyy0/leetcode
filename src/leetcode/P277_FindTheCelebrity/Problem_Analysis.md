# 277. Find the Celebrity / Tìm Người Nổi Tiếng

## Problem Description / Mô tả bài toán
Suppose you are at a party with `n` people (labeled from `0` to `n - 1`) and among them, there may exist one celebrity. The definition of a celebrity is that all the other `n - 1` people know him/her but he/she knows any of them.
Giả sử bạn đang ở một bữa tiệc với `n` người (được dán nhãn từ `0` đến `n - 1`) và trong số đó, có thể tồn tại một người nổi tiếng. Định nghĩa về một người nổi tiếng là tất cả `n - 1` người khác đều biết anh ta/cô ta nhưng anh ta/cô ta không biết bất kỳ ai trong số họ.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
Bây giờ bạn muốn tìm xem ai là người nổi tiếng hoặc xác minh rằng không có ai. Điều duy nhất bạn được phép làm là đặt các câu hỏi như: "Chào A. Bạn có biết B không?" để lấy thông tin xem A có biết B không. Bạn cần tìm ra người nổi tiếng (hoặc xác minh rằng không có ai) bằng cách đặt ít câu hỏi nhất có thể (theo nghĩa tiệm cận).

You are given a helper function `boolean knows(a, b)` which tells you whether A knows B. Implement a function `int findCelebrity(n)`. There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return `-1`.
Bạn được cung cấp một hàm trợ giúp `boolean knows(a, b)` cho biết A có biết B hay không. Triển khai một hàm `int findCelebrity(n)`. Sẽ có chính xác một người nổi tiếng nếu anh ta/cô ta tham gia bữa tiệc. Trả về nhãn của người nổi tiếng nếu có người nổi tiếng trong bữa tiệc. Nếu không có người nổi tiếng, trả về `-1`.

### Example 1:
```text
Input: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
```

### Example 2:
```text
Input: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
Output: -1
```

## Constraints / Ràng buộc
- `n == graph.length`
- `n == graph[i].length`
- `2 <= n <= 100`
- `graph[i][j]` is 0 or 1.
- `graph[i][i] == 1`

**Follow up**: If the maximum number of allowed calls to the API `knows` is `3 * n`, could you find a solution without exceeding the limit?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two-Pass Logic
1.  **Candidate Identification (Pass 1)**:
    - We maintain a `candidate`, initially `0`.
    - Iterate `i` from `1` to `n-1`.
    - Check `knows(candidate, i)`.
    - If `candidate` knows `i`, then `candidate` CANNOT be the celebrity (celebrity knows nobody). But `i` *could* be. So we switch `candidate = i`.
    - If `candidate` does NOT know `i`, then `i` CANNOT be the celebrity (everyone knows celebrity). So `candidate` stays.
    - After one pass, we have exactly one `candidate` who *might* be a celebrity. Everyone "left" of `candidate` was rejected because they knew `candidate`. Everyone "right" of `candidate` was rejected because `candidate` didn't know them (wait, if we switch, it means old candidate knew new one. So new one is potentially unknown by nobody so far? Yes).

2.  **Verification (Pass 2)**:
    - Verify the candidate against everyone else.
    - Check if `knows(candidate, i)` (should be false for all `i != candidate`).
    - Check if `knows(i, candidate)` (should be true for all `i != candidate`).
    - Note: We can optimize slightly. In Pass 1, we established relationships. But simply re-checking is O(N) calls, total O(2N) or O(3N).

### Complexity / Độ phức tạp
- **Time**: O(N) calls to `knows`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pass

**Edge Case**:
- No celebrity: Pass 2 filters this out.

(Note: Since I don't have the `Relation` class, I will define a mock class to simulate).

---

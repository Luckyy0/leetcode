# Result for Find the Celebrity
# *Kết quả cho bài toán Tìm Người nổi tiếng*

## Description
## *Mô tả*

Suppose you are at a party with `n` people labeled from `0` to `n - 1` and among them, there may exist one celebrity. The definition of a celebrity is that all the other `n - 1` people know the celebrity, but the celebrity does not know any of them.
*Giả sử bạn đang ở một bữa tiệc với `n` người được dán nhãn từ `0` đến `n - 1` và trong số họ, có thể tồn tại một người nổi tiếng. Định nghĩa về người nổi tiếng là tất cả `n - 1` người khác đều biết người nổi tiếng, nhưng người nổi tiếng không biết bất kỳ ai trong số họ.*

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
*Bây giờ bạn muốn tìm ra ai là người nổi tiếng hoặc xác minh rằng không có ai. Việc duy nhất bạn được phép làm là đặt các câu hỏi như: "Chào A. Bạn có biết B không?" để lấy thông tin về việc A có biết B hay không. Bạn cần tìm ra người nổi tiếng (hoặc xác minh không có ai) bằng cách đặt càng ít câu hỏi càng tốt (theo nghĩa tiệm cận).*

You are given a helper function `bool knows(a, b)` that tells you whether A knows B. Implement a function `int findCelebrity(n)`, your function should minimize the number of calls to `knows`.
*Bạn được cung cấp một hàm trợ giúp `bool knows(a, b)` cho bạn biết A có biết B hay không. Hãy triển khai hàm `int findCelebrity(n)`, hàm của bạn nên giảm thiểu số lần gọi đến `knows`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `graph = [[1,1,0],[0,1,0],[1,1,1]]`
**Output:** `1`
**Explanation:** There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

## Example 2:
## *Ví dụ 2:*

**Input:** `graph = [[1,0,1],[1,1,0],[0,1,1]]`
**Output:** `-1`
**Explanation:** There is no celebrity.

## Constraints:
## *Ràng buộc:*

*   `n == graph.length`
*   `n == graph[i].length`
*   `2 <= n <= 100`
*   `graph[i][j]` is `0` or `1`.
*   `graph[i][i] == 1`

**Follow up:** If the maximum number of allowed calls to the API `knows` is `3 * n`, could you find a solution without exceeding the limit?
**Câu hỏi mở rộng:** Nếu số lượng cuộc gọi tối đa cho phép đến API `knows` là `3 * n`, bạn có thể tìm ra giải pháp mà không vượt quá giới hạn không?

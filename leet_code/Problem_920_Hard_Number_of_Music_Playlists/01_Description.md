# Result for Number of Music Playlists
# *Kết quả cho bài toán Số lượng Danh sách Phát nhạc*

## Description
## *Mô tả*

Your music player contains `n` different songs. You want to listen to `goal` songs (not necessarily different) during your trip. To avoid boredom, you will create a playlist so that:
*Trình phát nhạc của bạn chứa `n` bài hát khác nhau. Bạn muốn nghe `goal` bài hát (không nhất thiết phải khác nhau) trong chuyến đi của mình. Để tránh sự nhàm chán, bạn sẽ tạo một danh sách phát sao cho:*

*   Every song is played at least once.
    *   *Mỗi bài hát được phát ít nhất một lần.*
*   A song can only be played again only if `k` other songs have been played.
    *   *Một bài hát chỉ có thể được phát lại nếu `k` bài hát khác đã được phát.*

Given `n`, `goal`, and `k`, return *the number of possible playlists that you can create*. Since the answer can be very large, return it **modulo** `10^9 + 7`.
*Cho `n`, `goal`, và `k`, hãy trả về *số lượng danh sách phát có thể tạo ra*. Vì câu trả lời có thể rất lớn, hãy trả về nó **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, goal = 3, k = 1
**Output:** 6
**Explanation:** There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2, goal = 3, k = 0
**Output:** 6
**Explanation:** There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], [1, 2, 2].

## Example 3:
## *Ví dụ 3:*

**Input:** n = 2, goal = 3, k = 1
**Output:** 2
**Explanation:** There are 2 possible playlists: [1, 2, 1], [2, 1, 2].

---

## Constraints:
## *Ràng buộc:*

*   `0 <= k < n <= goal <= 100`

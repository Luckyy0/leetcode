# 920. Number of Music Playlists / Số lượng Danh sách nhạc

## Problem Description / Mô tả bài toán
Find the number of music playlists of length `l` such that:
Tìm số lượng danh sách phát nhạc có độ dài `l` sao cho:
1. Every song of `n` different songs is played at least once.
Mỗi bài hát trong số `n` bài hát khác nhau được phát ít nhất một lần.
2. A song can only be played again after `k` other songs have been played.
Một bài hát chỉ có thể được phát lại sau khi `k` bài hát khác đã được phát.

Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i][j]` = number of playlists of length `i` using `j` different songs.
`dp[i][j]` = số lượng danh sách phát độ dài `i` sử dụng `j` bài hát khác nhau.

Transition:
1. New unique song added:
   `dp[i][j] += dp[i-1][j-1] * (n - (j-1))`
   (We pick one of the `n - (j-1)` remaining songs).
2. Existing song repeated:
   `dp[i][j] += dp[i-1][j] * max(0, j - k)`
   (We pick one of the `j` songs already used, but `k` of them were used recently and are unavailable).

### Complexity / Độ phức tạp
- **Time**: O(L * N).
- **Space**: O(L * N) or O(N).

---

## Analysis / Phân tích

### Approach: State-Based Combinatorics
Iteratively build playlists. At each step, decide whether to introduce a novel song or repeat an old one. The history constraint (K) acts as a subtraction on the set of available repetition candidates.
Xây dựng danh sách phát một cách lặp lại. Ở mỗi bước, quyết định xem nên giới thiệu một bài hát mới hay lặp lại bài hát cũ. Ràng buộc lịch sử (K) đóng vai trò là một phép trừ trên tập hợp các ứng viên lặp lại hiện có.

---

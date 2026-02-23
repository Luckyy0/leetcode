# Result for Video Stitching
# *Kết quả cho bài toán Nối Cắt Video*

## Description
## *Mô tả*

You are given a series of video clips from a sporting event that lasted `time` seconds. These video clips can be overlapping with each other and have varying lengths.
*Bạn được cung cấp một loạt các đoạn video clip từ sự kiện thể thao kéo dài đúng chuẩn `time` giây. Các đoạn video này có thể chồng chéo lên nhau và có độ dài ngắn khác nhau.*

Each video clip is described by an array `clips` where `clips[i] = [start_i, end_i]` indicates that the ith clip started at `start_i` and ended at `end_i`.
*Mỗi mảng tệp video clip được ghi chép bằng bộ khung `clips` trong đó `clips[i] = [start_i, end_i]` diễn tả rằng đoạn clip thứ $i$ được quay từ mốc `start_i` giây vắt ngang đến điểm kết thúc `end_i` giây.*

We can cut these clips into segments freely.
*For example, a clip `[0, 7]` can be cut into segments `[0, 1] + [1, 3] + [3, 7]`.*
*Chúng ta được quyền chẻ nhỏ các đoạn phim tự do thoái mái.*
*Ví dụ, một clip dài cục mịch `[0, 7]` xẻ cái nhép nát vụn ra thành `[0, 1] + [1, 3] + [3, 7]` ngon ơ.*

Return *the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event* `[0, time]`. If the task is impossible, return `-1`.
*Nhiệm vụ: Trả về **SỐ LƯỢNG CLIP TỐI THIỂU (Ít Nhất)** cần rút ra khỏi kho để có thể "tiêm ráp" chúng lại thành một dải băng liền tù tì bao phủ trọn vẹn toàn bộ sự kiện thể thao từ `[0, time]`. Giả sử công cuộc thất thủ (thiếu cảnh, hụt phim dứt đoạn), lẳng lặng trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
**Output:** 3
**Explanation:** 
We take the clips [0,2], [8,10], and [1,9]; a total of 3 clips.
Then, we can reconstruct the sporting event as follows:
- We cut [1,9] into segments [1,2] + [2,8] + [8,9].
- Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
*Giải thích: Đội săn phim túm lấy 3 dải [0,2], [8,10] và cuộn phim bự [1,9]. Đem xóp mẻ thớt ra ráp vá: mảnh [0,2] lót đường, lấy cuộn bự chẻ ruột che mọt khuyết mảng [2,8]. Cuối cùng dùng cục mảnh ráp [8,10] bịt chóp. Trọn vẹn mốc 0 - 10! Chỉ cần nhặt nhạnh khéo 3 cái nách clip là đủ.*

## Example 2:
## *Ví dụ 2:*

**Input:** clips = [[0,1],[1,2]], time = 5
**Output:** -1
**Explanation:** 
We cannot cover [0,5] with only [0,1] and [1,2].
*Giải thích: Đội quay phim lười biếng, quay cảnh rớt mốc dở dang, có ghép kiểu gì cũng chỉ lết thướt được từ 0 đến 2. Quãng từ 2 tới 5 mù tịt bóng đêm. Thất thủ văng cục báo `-1`.*

## Example 3:
## *Ví dụ 3:*

**Input:** clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
**Output:** 3
**Explanation:** 
We can take clips [0,4], [4,7], and [6,9] to cover the entire duration [0,9].
*Giải thích: 3 cuộn phim dũng sĩ này đã ráp đủ.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= clips.length <= 100`
*   `0 <= start_i <= end_i <= 100`
*   `1 <= time <= 100`

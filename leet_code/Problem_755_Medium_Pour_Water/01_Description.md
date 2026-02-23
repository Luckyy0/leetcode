# Result for Pour Water
# *Kết quả cho bài toán Đổ Nước*

## Description
## *Mô tả*

You are given an elevation map represents as an integer array `heights` where `heights[i]` representing the height of the terrain at index `i`. The width at each index is `1`. You are also given two integers `volume` and `k`. `volume` represents the available water in cubic units, and `k` represents the index where the water is originally poured.
*Bạn được cho một bản đồ độ cao dưới dạng mảng số nguyên `heights`, trong đó `heights[i]` đại diện cho chiều cao của địa hình tại chỉ số `i`. Chiều rộng tại mỗi chỉ số là `1`. Bạn cũng được cung cấp hai số nguyên `volume` và `k`. `volume` đại diện cho lượng nước có sẵn tính bằng đơn vị khối, và `k` là chỉ số nơi nước được đổ xuống ban đầu.*

At each step, water drops fall at index `k`. A droplet first attempts to move left, then right, then if neither is possible, it stays at its current position.
*Tại mỗi bước, các giọt nước rơi xuống tại chỉ số `k`. Một giọt nước trước tiên cố gắng di chuyển sang trái, sau đó sang phải, nếu không bên nào được thì nó sẽ ở lại vị trí hiện tại.*

Rules for moving **left**:
*   The droplet moves to the left if the height of the left neighbor is **less than** the height of the current position.
*   Ideally, the droplet moves to the lowest point to the left. If there are multiple indices with the same lowest height, it chooses the one closest to `k`.
*   Eventually, if it is placed at index `i`, then `heights[i]` increases by 1.
*Quy tắc di chuyển sang **trái**:*
*   *Giọt nước di chuyển sang trái nếu chiều cao của hàng xóm bên trái **thấp hơn** chiều cao của vị trí hiện tại.*
*   *Lý tưởng nhất, giọt nước di chuyển đến điểm thấp nhất bên trái. Nếu có nhiều chỉ số có cùng chiều cao thấp nhất, nó chọn chỉ số gần `k` nhất.*
*   *Cuối cùng, nếu nó được đặt tại chỉ số `i`, thì `heights[i]` tăng thêm 1.*

Rules for moving **right** (similar to left, but used if left movement is not possible):
*   Droplet moves right if right neighbor is lower.
*Quy tắc di chuyển sang **phải** (tương tự bên trái, nhưng chỉ dùng nếu không thể di chuyển sang trái):*
*   *Giọt nước di chuyển sang phải nếu hàng xóm bên phải thấp hơn.*

If the droplet cannot move left or right to a lower ground, it stays at the current position (index where it is currently considering, which might be `k` or some `i` where it got stuck but is actually a local minimum plateau).
*Nếu giọt nước không thể di chuyển sang trái hoặc phải đến vùng đất thấp hơn, nó sẽ ở lại vị trí hiện tại.*

Return `heights` after pouring `volume` units of water.
*Trả về `heights` sau khi đổ `volume` đơn vị nước.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** heights = [2,1,1,2,1,2,2], volume = 4, k = 3
**Output:** [2,2,2,3,2,2,2]
**Explanation:**
1. Droplet falls at index 3 (height 2).
   - Left check: idx 2 (1) < 2. Move to 2.
   - Idx 1 (1) not < 1. Stop at 2? No, continuing left...
   - Actually, rule is: "eventually falls to lowest point".
   - The detailed logic: find the *best* index to the left.
   - Indices: 3(h=2) -> 2(h=1) -> 1(h=1). Idx 0(h=2).
   - The lowest in the range 3..0 that is validly reachable is height 1. Closeness rule: further is better? No, "closest to k" is for TIES?
   - Wait, standard description: "It flows to index i < K such that heights[i] is minimal. If multiple such i exist, smallest distance to K? No, usually it flows until it can't, then settles. But 'simulates' usually means check immediate neighbors.
   - Let's re-read carefully: "If the height of the left neighbor is less than... moves left". It keeps moving left as long as `height[left] <= height[curr]`. Then among the path, finds the **last** index with minimal height?
   - Actually the rule is simpler: Find the lowest index `L` in the left connected component such that height is decreasing or flat. If `heights[L] < heights[K]`, fill `L`. Ideally closest to K? No, water fills the *dip*. So if we have `2, 1, 0, 1, 2` and pour at center `0`, it stays. If pour at left `2`, it goes to `0`.
   - Let's abide by the specific simulation logic:
     1. Go left as far as possible while `h[i-1] <= h[i]`. Find the index `best` such that `h[best]` is minimal. If `h[best] < h[K]`, pour there.
     2. If not, go right as far as possible while `h[i+1] <= h[i]`. Find `best` with minimal height. If `h[best] < h[K]`, pour there.
     3. Else pour at `K`.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= heights.length <= 100`
*   `0 <= heights[i] <= 99`
*   `0 <= volume <= 2000`
*   `0 <= k < heights.length`

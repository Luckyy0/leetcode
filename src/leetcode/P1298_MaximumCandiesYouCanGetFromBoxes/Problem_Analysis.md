# 1298. Maximum Candies You Can Get from Boxes / Số Kẹo Tối đa Bạn có thể Nhận từ các Hộp

## Problem Description / Mô tả bài toán
Given `n` boxes. Some are `open` (1), some closed (0).
Box `i` has `candies[i]`, `keys[i]` (list of boxes key opens), `containedBoxes[i]` (boxes inside).
Start with `initialBoxes`.
Get maximum candies.
Rules:
- Can open box if you have it AND (it is open OR you have key).
- When open, you get candies, keys, and inner boxes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS simulation
Maintain states:
- `haveBox`: set of boxes in possession (found inside others or initial).
- `haveKey`: set of keys found.
- `processed`: boxes opened.
Queue `q`: boxes ready to be opened (have box AND (open or have key)).
When pulling `curr` from queue:
1. Add candies.
2. Add keys. For each new key `k`, if we `haveBox[k]` and not processed `k`, check if we can open `k`. If yes, add `k` to q.
3. Add inner boxes. For each new box `b`, `haveBox[b] = true`. If (open or `haveKey[b]`) and not processed, add `b` to q.

Simplification:
Just put reachable boxes into "possession".
If `status[box] == 1` or `keys contains box`, it becomes "available".
Use explicit Queue for "available to open" boxes.
If we find a box but no key yet, store it.
If we find a key but box not found yet, store key.
Check intersection of `foundBoxes` and `(openBoxes + foundKeys)`.

### Complexity / Độ phức tạp
- **Time**: O(N + TotalEdges).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: BFS with State Tracking
Use a Queue for boxes that are currently available to be opened (i.e., we possess the box AND we have access to open it - either it's already open or we have its key).
Maintain arrays/sets: `boxFound` (we possess this box), `keyFound` (we have this key), `opened` (processed).
Start by iterating `initialBoxes`. Mark them found. If a box is open or we have its key (initially keys are empty unless provided differently - wait, problem doesn't give initial keys, only boxes), add to Queue.
While Queue is not empty:
- Pop a box. Collect its candies.
- Process its keys: mark keys as found. If we possess the corresponding box (`boxFound[k]`) and it wasn't opened/queued, adding key makes it available -> add to Queue.
- Process contained boxes: mark boxes as found. If the box is open or we already have its key, add to Queue.
Ensure each box enters Queue only once.
Sử dụng Hàng đợi cho các hộp hiện có sẵn để mở (nghĩa là chúng ta sở hữu hộp VÀ chúng ta có quyền truy cập để mở nó - hoặc nó đã mở hoặc chúng ta có chìa khóa).
Duy trì mảng/tập hợp: `boxFound` (chúng ta sở hữu hộp này), `keyFound` (chúng ta có chìa khóa này), `opened` (đã xử lý).
Bắt đầu bằng cách lặp lại `initialBoxes`. Đánh dấu chúng được tìm thấy. Nếu hộp đang mở hoặc chúng ta có chìa khóa (ban đầu chìa khóa trống trừ khi được cung cấp khác - chờ đã, bài toán không cung cấp chìa khóa ban đầu, chỉ có hộp), hãy thêm vào Hàng đợi.
Trong khi Hàng đợi không trống:
- Lấy một hộp. Thu thập kẹo.
- Xử lý các chìa khóa: đánh dấu chìa khóa được tìm thấy. Nếu chúng ta sở hữu hộp tương ứng (`boxFound[k]`) và nó chưa được mở/xếp hàng, việc thêm chìa khóa làm cho nó có sẵn -> thêm vào Hàng đợi.
- Xử lý các hộp bên trong: đánh dấu các hộp được tìm thấy. Nếu hộp đang mở hoặc chúng ta đã có chìa khóa, hãy thêm vào Hàng đợi.
Đảm bảo mỗi hộp chỉ vào Hàng đợi một lần.

---

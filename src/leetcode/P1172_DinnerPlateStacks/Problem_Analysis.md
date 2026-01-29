# 1172. Dinner Plate Stacks / Ngăn xếp Đĩa Ăn tối

## Problem Description / Mô tả bài toán
Implement `DinnerPlates` class.
- `DinnerPlates(int capacity)`: max capacity of stack.
- `void push(int val)`: pushes `val` into leftmost non-full stack.
- `int pop()`: pops from rightmost non-empty stack.
- `int popAtStack(int index)`: pops from stack at `index`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Treeset for Indices / List of Stacks / Treeset cho Chỉ số / Danh sách Ngăn xếp
We need:
1. Efficiently find leftmost non-full stack for `push`. -> `TreeSet<Integer> availableStacks`.
2. Efficiently find rightmost non-empty stack for `pop`. -> Maintain `List<Stack>` and remove empty stacks from tail? Or just `List`.
3. Track empty slots for reuse.

Data Structures:
- `List<Stack<Integer>> stacks`.
- `TreeSet<Integer> openSlots`: Indices of stacks that have space.
- `capacity`.

Operations:
- `push`:
  - If `openSlots` is empty: Create new stack, index `s.size()`. Push. If new stack full, don't add to `openSlots`. Else add.
    - Actually new stack has size 1 < capacity (unless capacity=1, then full).
  - If `openSlots` not empty: Getting `idx = openSlots.first()`. Push to `stacks.get(idx)`. If full, remove from `openSlots`.
- `popAtStack(idx)`:
  - If invalid idx or stack empty, return -1.
  - Pop.
  - Add `idx` to `openSlots` (since it now has space).
  - Return val.
- `pop()`:
  - Find rightmost non-empty stack.
  - Iterate from end of list?
  - `popAtStack(lastIdx)`. Then maintain list size (remove trailing empty stacks).

### Complexity / Độ phức tạp
- **Time**: All ops O(log N) due to TreeSet (or O(1) amortized if optimal). Actually O(log N) is safe.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Heap/TreeSet Management
Maintain a list of stacks to store elements. Use a `TreeSet` (or Min-Heap) to track indices of stacks that have available space (are not full). This allows `push` to quickly find the leftmost available stack. For `pop`, access the last stack in the list, removing it if it becomes empty. For `popAtStack`, remove the element and add the stack index to the `TreeSet` since a slot has opened up. Clean up trailing empty stacks lazily or eagerly to ensure `pop` targets the correct non-empty stack.
Duy trì một danh sách các ngăn xếp để lưu trữ các phần tử. Sử dụng `TreeSet` (hoặc Min-Heap) để theo dõi các chỉ số của các ngăn xếp có không gian trống (không đầy). Điều này cho phép `push` nhanh chóng tìm thấy ngăn xếp có sẵn ngoài cùng bên trái. Đối với `pop`, truy cập ngăn xếp cuối cùng trong danh sách, xóa nó nếu nó trở nên trống. Đối với `popAtStack`, hãy xóa phần tử và thêm chỉ số ngăn xếp vào `TreeSet` vì một khe cắm đã mở ra. Dọn dẹp các ngăn xếp trống theo sau một cách lười biếng hoặc háo hức để đảm bảo `pop` nhắm mục tiêu đúng ngăn xếp không trống.

---

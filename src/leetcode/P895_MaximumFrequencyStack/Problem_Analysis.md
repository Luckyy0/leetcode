# 895. Maximum Frequency Stack / Ngăn xếp Tần suất Tối đa

## Problem Description / Mô tả bài toán
Design a stack-like data structure that supports pushing and popping, but `pop` always removes the most frequent element. If there's a tie, the element closest to the top of the stack is chosen.
Thiết kế cấu trúc dữ liệu giống ngăn xếp hỗ trợ đẩy (push) và lấy ra (pop), nhưng `pop` luôn loại bỏ phần tử xuất hiện thường xuyên nhất. Nếu có sự trùng lặp về tần suất, phần tử gần đỉnh ngăn xếp nhất sẽ được chọn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-level Stacks / Ngăn xếp nhiều cấp
We need to efficiently track:
1. Frequency of each element.
2. Group of elements by their frequencies.

Algorithm:
1. `Map<Integer, Integer> freq`: stores `element -> frequency`.
2. `Map<Integer, Stack<Integer>> group`: stores `frequency -> stack of elements with that frequency`.
3. `maxFreq`: tracks the current maximum frequency.

When pushing `x`:
- Update `freq[x]`.
- Add `x` to `group[freq[x]]`.
- Update `maxFreq`.

When popping:
- `x = group[maxFreq].pop()`.
- Decrement `freq[x]`.
- If `group[maxFreq]` is empty, decrement `maxFreq`.

### Complexity / Độ phức tạp
- **Time**: O(1) for both push and pop.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Frequency-Bucket Organization
Instead of re-sorting or searching, we physically separate elements into buckets based on their current frequency. Since a single element instance only belongs to one frequency level at a time, this layered structure ensures constant time access to the correct candidate.
Thay vì sắp xếp lại hoặc tìm kiếm, chúng ta phân tách vật lý các phần tử thành các ngăn chứa dựa trên tần số hiện tại của chúng. Vì một phiên bản phần tử duy nhất chỉ thuộc về một mức tần suất tại một thời điểm, cấu trúc phân lớp này đảm bảo quyền truy cập trong thời gian cố định tới ứng viên chính xác.

---

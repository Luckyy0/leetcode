# 380. Insert Delete GetRandom O(1) / Chèn Xóa Lấy Ngẫu Nhiên O(1)

## Problem Description / Mô tả bài toán
Implement the `RandomizedSet` class:
- `RandomizedSet()` Initializes the `RandomizedSet` object.
- `bool insert(int val)` Inserts an item `val` into the set if not present. Returns `true` if the item was not present, `false` otherwise.
- `bool remove(int val)` Removes an item `val` from the set if present. Returns `true` if the item was present, `false` otherwise.
- `int getRandom()` Returns a random element from the current set of elements. Each element must have the **same probability** of being returned.

You must implement the functions of the class such that each function works in **average** `O(1)` time complexity.

### Example 1:
```text
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
```

## Constraints / Ràng buộc
- `-2^31 <= val <= 2^31 - 1`
- At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
- There will be at least one element in the data structure when `getRandom` is called.

---

## Theoretical Foundation / Cơ sở lý thuyết

### ArrayList + HashMap / ArrayList + Bảng Băm
To support `getRandom` in O(1), we need array-like indexing (contiguous storage preferred to pick `index` in `0..size-1`). `ArrayList` is good.
To support `insert` and `remove` in O(1) (check existence, find location), we need `HashMap`.
Key Idea:
- `HashMap<Value, Index>` maps the value to its index in the `ArrayList`.
- `ArrayList<Value>` stores the values.
- `insert(val)`: Check Map. Put `(val, list.size)` in Map. Add `val` to List.
- `remove(val)`: Check Map. Get `index`.
    - **Swap with last element**: To remove from middle in O(1), overwrite `list[index]` with `list[last]`. Update Map for the swapped element (`list[last]` gets new index `index`).
    - Remove last element from List. Remove `val` from Map.
- `getRandom()`: `list.get(random.nextInt(size))`.

### Complexity / Độ phức tạp
- **Time**: Average O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: HashMap + ArrayList Swap

**Algorithm**:
1.  `Map<Integer, Integer> map`. `List<Integer> list`. `Random rand`.
2.  `insert`: if in map, return false. Add to list end. Map `val -> size-1`.
3.  `remove`: if not in map, return false.
    - `idx = map.get(val)`.
    - `lastVal = list.get(size-1)`.
    - `list.set(idx, lastVal)`.
    - `map.put(lastVal, idx)`.
    - `list.remove(size-1)`.
    - `map.remove(val)`.
4.  `getRandom`: `list.get(rand.nextInt(size))`.

---

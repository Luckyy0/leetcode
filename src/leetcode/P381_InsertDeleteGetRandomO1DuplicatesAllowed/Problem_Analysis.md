# 381. Insert Delete GetRandom O(1) - Duplicates allowed / Chèn Xóa Lấy Ngẫu Nhiên O(1) - Cho Phép Trùng Lặp

## Problem Description / Mô tả bài toán
Implement the `RandomizedCollection` class:
- `RandomizedCollection()` Initializes the `RandomizedCollection` object.
- `bool insert(int val)` Inserts an item `val` into the multiset if not present. Returns `true` if the item was not present, `false` otherwise.
- `bool remove(int val)` Removes an item `val` from the multiset if present. Returns `true` if the item was present, `false` otherwise. Note that if `val` has multiple occurrences in the multiset, we only remove one of them.
- `int getRandom()` Returns a random element from the current multiset of elements (it's guaranteed that at least one element exists when this method is called). The probability of each element being returned is **linearly related** to the number of same values the multiset contains.

You must implement the functions of the class such that each function works in **average** `O(1)` time complexity.

### Example 1:
```text
Input
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]
Output
[null, true, false, true, 2, true, 1]
Explanation
RandomizedCollection collection = new RandomizedCollection();
collection.insert(1);   // return true since the collection does not contain 1.
                        // Inserts 1 to the collection. Collection now contains [1].
collection.insert(1);   // return false since the collection contains 1.
                        // Inserts another 1 to the collection. Collection now contains [1, 1].
collection.insert(2);   // return true since the collection does not contain 2.
                        // Inserts 2 to the collection. Collection now contains [1, 1, 2].
collection.getRandom(); // getRandom should return 1 with the probability 2/3, and 2 with the probability 1/3.
collection.remove(1);   // return true since the collection contains 1.
                        // Removes 1 from the collection. Collection now contains [1, 2].
collection.getRandom(); // getRandom should return 1 or 2 both with the probability 1/2.
```

## Constraints / Ràng buộc
- `-2^31 <= val <= 2^31 - 1`
- At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
- There will be at least one element in the data structure when `getRandom` is called.

---

## Theoretical Foundation / Cơ sở lý thuyết

### ArrayList + HashMap<Value, Set<Index>>
To handle duplicates, the Map must store *all* indices for a value.
`Map<Integer, Set<Integer>> map`.
`ArrayList<Entry>` list. Entry stores value (and maybe index, but set handles logic).
Actually, list just needs values.
- `insert(val)`: Add to list. Add index `list.size()-1` to `map.get(val)`.
- `remove(val)`:
    - Check if exists. Get the Set of indices.
    - Pick *any* index to remove (e.g., iterator().next()). Let's say `idxToRemove`.
    - Swap logic:
        - `lastElement = list.get(lastIdx)`.
        - `list.set(idxToRemove, lastElement)`.
        - Update map for `lastElement`: remove `lastIdx`, add `idxToRemove`. (Be careful if `lastElement == val`).
        - Remove `idxToRemove` from `map.get(val)`.
        - `list.remove(lastIdx)`.
- `getRandom()`: `list.get(random)`. Linear probability handled by duplicates in list.

### Complexity / Độ phức tạp
- **Time**: O(1) average. Set operations O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Map to Set of Indices

**Algorithm**:
1.  `Map<Integer, Set<Integer>> idxMap`. `List<Integer> nums`.
2.  `insert(val)`:
    - `nums.add(val)`.
    - `idxMap.get(val).add(nums.size() - 1)`.
    - Return `idxMap.get(val).size() == 1`.
3.  `remove(val)`:
    - If `!idxMap.contains(val)` return false.
    - `removeIdx` = `idxMap.get(val).iterator().next()`.
    - `lastIdx` = `nums.size() - 1`.
    - `lastVal` = `nums.get(lastIdx)`.
    - Swap logic:
        - `nums.set(removeIdx, lastVal)`.
        - Update `idxMap.get(lastVal)`: remove `lastIdx`, add `removeIdx`.
        - `idxMap.get(val)`: remove `removeIdx`.
        - `nums.remove(lastIdx)`.
        - Cleanup `idxMap` if set empty? Not strictly required but good practice.
    - Be careful if `val == lastVal`. Removing `lastIdx` and adding `removeIdx` might conflict if we remove `removeIdx` later.
    - Order:
        - `idxMap.get(val).remove(removeIdx)`.
        - If `removeIdx != lastIdx`:
            - `idxMap.get(lastVal).remove(lastIdx)`.
            - `idxMap.get(lastVal).add(removeIdx)`.
            - `nums.set(removeIdx, lastVal)`.
        - `nums.remove(lastIdx)`.
        - Clean `idxMap.get(val)` if empty.

---

# 244. Shortest Word Distance II / Khoảng Cách Từ Ngắn Nhất II

## Problem Description / Mô tả bài toán
Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
Thiết kế một cấu trúc dữ liệu được khởi tạo với một mảng chuỗi, và sau đó nó phải trả lời các truy vấn về khoảng cách ngắn nhất giữa hai chuỗi khác nhau từ mảng.

Implement the `WordDistance` class:
- `WordDistance(String[] wordsDict)` initializes the object with the strings array `wordsDict`.
- `int shortest(String word1, String word2)` returns the shortest distance between `word1` and `word2`.

### Example 1:
```text
Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]
```

## Constraints / Ràng buộc
- `1 <= wordsDict.length <= 3 * 10^4`
- `1 <= wordsDict[i].length <= 10`
- `word1` and `word2` are in `wordsDict`.
- `word1 != word2`
- At most `5000` calls will be made to `shortest`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Preprocessing with Hash Map / Tiền xử lý với Hash Map
Since we have multiple queries, doing an O(N) scan for each query (like in Problem 243) represents O(Q * N) total time, which might be slow if Q is large (though constraints say Q=5000, N=30000, 1.5*10^8 ops is slightly risky but maybe acceptable. Optimization is better).

**Optimized Approach**:
1.  **Constructor**: Store the indices of each word in a `HashMap<String, List<Integer>>`.
    - `makes` -> `[1, 4]`
    - `coding` -> `[3]`
2.  **Query**: Retrieve the two lists of indices (`L1` and `L2`).
    - Use a **Two Pointers** approach (similar to merging sorted lists) to find the minimum difference.
    - `i` points to `L1`, `j` points to `L2`.
    - `dist = abs(L1[i] - L2[j])`.
    - If `L1[i] < L2[j]`, increment `i` (try to bring L1 closer).
    - Else, increment `j`.

### Complexity / Độ phức tạp
- **Time**:
    - Constructor: O(N) to build map.
    - Query: O(K + L) where K and L are frequencies of the words. In worst case O(N), but usually much smaller.
- **Space**: O(N) to store all indices.

---

## Analysis / Phân tích

### Approach: Map + Two Pointers

**Algorithm**:
1.  `Map<String, List<Integer>> map`.
2.  In `WordDistance`: iterate words, map `word` -> `list.add(index)`.
3.  In `shortest(w1, w2)`:
    - `l1 = map.get(w1)`, `l2 = map.get(w2)`.
    - Loop `i` and `j` while valid:
        - `min = min(min, abs(l1.get(i) - l2.get(j)))`.
        - Increment pointer of the smaller index.

---

## Edge Cases / Các trường hợp biên
1.  **Duplicate words**: Handled by list of indices.
2.  **Far apart**: Logic holds.

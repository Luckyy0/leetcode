# 269. Alien Dictionary / Từ Điển Người Ngoài Hành Tinh

## Problem Description / Mô tả bài toán
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
Có một ngôn ngữ ngoài hành tinh mới sử dụng bảng chữ cái tiếng Anh. Tuy nhiên, thứ tự các chữ cái là không xác định với bạn.

You are given a list of strings `words` from the alien language's dictionary, where the strings in `words` are **sorted lexicographically** by the rules of this new language.
Bạn được cung cấp một danh sách các chuỗi `words` từ từ điển của ngôn ngữ ngoài hành tinh đó, trong đó các chuỗi trong `words` được **sắp xếp theo thứ tự từ điển** theo quy tắc của ngôn ngữ mới này.

Return a string of the unique letters in the new alien language sorted in **lexicographically increasing order** by the new language's rules. If there is no solution, return `""`. If there are multiple solutions, return **any of them**.
Trả về một chuỗi các chữ cái duy nhất trong ngôn ngữ ngoài hành tinh mới, được sắp xếp theo **thứ tự từ điển tăng dần** theo quy tắc của ngôn ngữ mới. Nếu không có giải pháp, trả về `""`. Nếu có nhiều giải pháp, hãy trả về **bất kỳ giải pháp nào trong số đó**.

### Example 1:
```text
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
```

### Example 2:
```text
Input: words = ["z","x"]
Output: "zx"
```

### Example 3:
```text
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
```

## Constraints / Ràng buộc
- `1 <= words.length <= 100`
- `1 <= words[i].length <= 100`
- `words[i]` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Topological Sort (Kahn's Algorithm) / Sắp Xếp Topo
This problem can be modeled as finding a topological ordering of a Directed Acyclic Graph (DAG).
- Nodes: Unique characters appearing in `words`.
- Edges: Order relations derived from adjacent words.
    - If `wordA` comes before `wordB` (and `wordA` is not a prefix of `wordB`), the first differing character implies an order.
    - Example: "wrt", "wrf". First diff at index 2: `t` comes before `f`. Edge `t -> f`.

**Algorithm**:
1.  **Build Graph**:
    - Build adjacency list `map` and `inDegree` map.
    - Initialize all unique chars in `words` with in-degree 0.
    - Iterate `i` from 0 to `N-2`. Compare `words[i]` and `words[i+1]`.
    - Find first mismatched char `c1 != c2`. Add edge `c1 -> c2`. Increment in-degree of `c2`.
    - **Crucial Edge Case**: If `words[i+1]` is a prefix of `words[i]` (e.g., "abc", "ab"), this is invalid ordering (longer word should be after shorter word if prefix matches). Return `""`. Only if prefix matches and length[i] > length[i+1].
2.  **Topological Sort (BFS)**:
    - Queue all nodes with in-degree 0.
    - While queue not empty:
        - Pop `u`, append to result.
        - For each neighbor `v` of `u`:
            - `inDegree[v]--`.
            - If `inDegree[v] == 0`, push to queue.
3.  **Check Completeness**:
    - If result length != number of unique characters, there is a cycle (or incomplete graph implies cycle). Return `""`.
    - Else return result string.

### Complexity / Độ phức tạp
- **Time**: O(C) where C is total characters (to build graph) + O(V+E) sort. Since chars <= 26, V+E is small. Total time effectively O(C).
- **Space**: O(1) (26 chars maps).

---

## Analysis / Phân tích

### Approach: Kahn's Algorithm

**Algorithm**:
1.  Extract unique chars to init data structures.
2.  Loop adjacent words to build edges. Check "prefix invalid" case.
3.  Standard Kahn's.
4.  Verify size of result.

---

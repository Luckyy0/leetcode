# Analysis for Group Anagrams
# *Phân tích cho bài toán Nhóm Các Từ Đảo Chữ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of strings `strs`. *Mảng các chuỗi `strs`.*
*   **Output:** List of lists of strings. *Danh sách các danh sách chuỗi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `strs.length` up to $10^4$.
*   Maximum word length is 100.
*   Only lowercase English letters.
*   *Độ dài của `strs` lên tới $10^4$.*
*   *Độ dài từ tối đa là 100.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: HashMap with Sorted String Keys
### *Hướng tiếp cận: Bảng băm với Khóa là Chuỗi đã Sắp xếp*

*   **Intuition:** Two strings are anagrams if and only if their sorted versions are identical. We can use a HashMap where the key is the sorted string and the value is a list of its anagrams.
*   *Ý tưởng: Hai chuỗi là đảo chữ của nhau khi và chỉ khi phiên bản đã sắp xếp của chúng là giống hệt nhau. Chúng ta có thể sử dụng một HashMap trong đó khóa là chuỗi đã sắp xếp và giá trị là danh sách các từ đảo chữ của nó.*

*   **Algorithm Steps:**
    1.  Initialize a `HashMap<String, List<String>>`.
    2.  For each string `s` in `strs`:
        *   Convert `s` to a char array, sort it, and convert it back to a string `key`.
        *   If `key` is not in the map, add it with a new list.
        *   Add `s` to the list corresponding to `key`.
    3.  Return the values of the map as a list.

*   **Complexity:**
    *   Time: $O(N \cdot K \log K)$, where $N$ is number of strings and $K$ is max length of string.
    *   Space: $O(N \cdot K)$.

### Dry Run
### *Chạy thử*
`["eat", "tea", "tan"]`
1.  "eat" -> sorted "aet". Map: `{"aet": ["eat"]}`
2.  "tea" -> sorted "aet". Map: `{"aet": ["eat", "tea"]}`
3.  "tan" -> sorted "ant". Map: `{"aet": ["eat", "tea"], "ant": ["tan"]}`
Result: `[["eat", "tea"], ["tan"]]`.

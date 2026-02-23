# Analysis for Groups of Special-Equivalent Strings
# *Phân tích cho bài toán Nhóm các Chuỗi có Tính chất Đẳng trị Đặc biệt*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Group strings that can be transformed into each other by swapping characters at *even* indices or swapping characters at *odd* indices.
*Nhóm các chuỗi có thể biến đổi thành nhau bằng cách hoán đổi các ký tự ở vị trí *chẵn* hoặc hoán đổi các ký tự ở vị trí *lẻ*.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Swapping at even indices means the **set of characters at even positions remains invariant** (only their order changes).
- Swapping at odd indices means the **set of characters at odd positions remains invariant**.
- Therefore, two strings are special-equivalent if and only if:
  1. Their even-indexed characters are the same (multiset-wise).
  2. Their odd-indexed characters are the same (multiset-wise).
*Hoán đổi ở vị trí chẵn có nghĩa là **tập hợp các ký tự ở vị trí chẵn không thay đổi**. Tương tự cho vị trí lẻ. Do đó, hai chuỗi là đẳng trị nếu tập hợp ký tự chẵn của chúng giống nhau VÀ tập hợp ký tự lẻ của chúng giống nhau.*

---

## 2. Strategy: Canonical Signature
## *2. Chiến lược: Chữ ký Chính tắc*

### Signature Construction
### *Xây dựng Chữ ký*
For each string, create a signature representing its invariant properties.
- Count frequency of characters at even indices (26 integers).
- Count frequency of characters at odd indices (26 integers).
- Combine these 52 integers into a string or list as the unique key.
*Với mỗi chuỗi, tạo một chữ ký đại diện cho các thuộc tính bất biến của nó. Đếm tần suất ký tự tại vị trí chẵn (26 số). Đếm tần suất tại vị trí lẻ (26 số). Kết hợp 52 số này thành một khóa duy nhất.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Set:** Use a `HashSet<String>` to store unique signatures.
    *   **Khởi tạo Tập hợp:** Sử dụng `HashSet` để lưu các chữ ký duy nhất.*

2.  **Iterate Words:** For each word:
    - Create two count arrays: `odd[26]` and `even[26]`.
    - Loop through characters. If index `% 2 == 0`, increment `even`. Else increment `odd`.
    - Generate a string key: `Arrays.toString(even) + Arrays.toString(odd)`.
    - Add to Set.
    *   **Duyệt từ:** Với mỗi từ, đếm ký tự chẵn/lẻ. Tạo chuỗi khóa từ hai mảng đếm. Thêm vào Set.*

3.  **Return Size:** The size of the Set is the number of groups.
    *   **Trả về Kích thước:** Kích thước của Set chính là số lượng nhóm.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numSpecialEquivGroups(String[] words) {
    Set<String> seen = new HashSet<>();
    for (String s : words) {
        int[] count = new int[52]; // First 26 for even, next 26 for odd
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (i % 2 == 0) {
                count[charIdx]++;
            } else {
                count[charIdx + 26]++;
            }
        }
        seen.add(Arrays.toString(count));
    }
    return seen.size();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot K)$, where $N$ is the number of words and $K$ is the length of each word.
    *   **Độ phức tạp thời gian:** $O(N \cdot K)$.*
*   **Space Complexity:** $O(N \cdot K)$ to store the set of signatures.
    *   **Độ phức tạp không gian:** $O(N \cdot K)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Identifying the invariants under transformation (even/odd character counts) allows reducing the problem to simple signature grouping.
*Việc xác định các bất biến dưới phép biến đổi (số lượng ký tự chẵn/lẻ) cho phép quy bài toán về việc nhóm theo chữ ký đơn giản.*

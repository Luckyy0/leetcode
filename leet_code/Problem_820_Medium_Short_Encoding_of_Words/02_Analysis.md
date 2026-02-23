# Analysis for Short Encoding of Words
# *Phân tích cho bài toán Mã hóa ngắn cho các từ*

## 1. Problem Essence & Suffix Relationship
## *1. Bản chất vấn đề & Mối quan hệ Hậu tố*

### THE CHALLENGE
### *Thách thức*
We need to find the minimum length of a reference string that can encode all words. A word `A` can be "absorbed" into the encoding of word `B` if `A` is a **suffix** of `B`. For example, "me" is a suffix of "time", so they can both be represented by "time#".
*Chúng ta cần tìm độ dài tối thiểu của chuỗi tham chiếu có thể mã hóa tất cả các từ. Một từ `A` có thể được "hấp thụ" vào mã hóa của từ `B` nếu `A` là **hậu tố** của `B`. Ví dụ, "me" là hậu tố của "time", vì vậy cả hai có thể được đại diện bởi "time#".*

---

## 2. Strategy: Suffix Removal using a Set
## *2. Chiến lược: Loại bỏ hậu tố bằng Tập hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Unique Words:** Put all words into a `HashSet` to handle duplicates and allow fast removals.
    *   **Từ duy nhất:** Đưa tất cả các từ vào một `HashSet` để xử lý các từ trùng lặp và cho phép xóa nhanh.*

2.  **Filter Suffixes:** For each word in the set:
    - Iterate through all its possible proper suffixes (from length 1 up to `length - 1`).
    - If a suffix exists in the `HashSet`, remove it because it is already covered by the current word.
    *   **Lọc hậu tố:** Với mỗi từ trong tập hợp, duyệt qua tất cả các hậu tố thực sự của nó (từ độ dài 1 đến `length - 1`). Nếu một hậu tố tồn tại trong `HashSet`, hãy xóa nó vì nó đã được bao phủ bởi từ hiện tại.*

3.  **Sum Lengths:** Calculate the sum of lengths of the remaining words in the `HashSet`.
    - Add 1 for each word (to account for the `#` character).
    *   **Tính tổng độ dài:** Tính tổng độ dài của các từ còn lại trong `HashSet`. Cộng thêm 1 cho mỗi từ (để tính ký tự `#`).*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minimumLengthEncoding(String[] words) {
    Set<String> set = new HashSet<>(Arrays.asList(words));
    
    // For each word, remove all its possible suffixes from the set
    for (String word : words) {
        for (int i = 1; i < word.length(); i++) {
            set.remove(word.substring(i));
        }
    }
    
    // Sum length of words + 1 for each '#'
    int totalLength = 0;
    for (String s : set) {
        totalLength += s.length() + 1;
    }
    return totalLength;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sum w_i^2)$, where $w_i$ is the length of word $i$. For each word, we generate and lookup its suffixes. Given max length 7, this is very fast.
    *   **Độ phức tạp thời gian:** $O(\sum w_i^2)$, với $w_i$ là độ dài từ thứ $i$. Với độ dài tối đa là 7, thuật toán này rất nhanh.*
*   **Space Complexity:** $O(\sum w_i)$, to store the words in the `HashSet`.
    *   **Độ phức tạp không gian:** $O(\sum w_i)$, để lưu trữ các từ trong `HashSet`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `["time", "me", "bell"]`
1. Set: `{"time", "me", "bell"}`
2. Process "time":
   - Suffixes: "ime", "me", "e".
   - "me" is in set. **Remove "me"**.
3. Process "bell":
   - Suffixes: "ell", "ll", "l".
   - None in set.
4. Final Set: `{"time", "bell"}`
5. Length = (4 + 1) + (4 + 1) = 10.
**Result:** 10.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a `HashSet` to filter out suffixes is a clean and efficient approach, especially given the small constraint on word lengths. For much larger word lengths, a Trie built on reversed words would be a more memory-efficient alternative.
*Sử dụng `HashSet` để lọc bỏ các hậu tố là một cách tiếp cận sạch sẽ và hiệu quả. Nếu độ dài từ lớn hơn nhiều, một cây Trie xây dựng trên các từ đảo ngược sẽ là giải pháp thay thế tiết kiệm bộ nhớ hơn.*

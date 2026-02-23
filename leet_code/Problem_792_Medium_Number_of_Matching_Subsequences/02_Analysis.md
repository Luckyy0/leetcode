# Analysis for Number of Matching Subsequences
# *Phân tích cho bài toán Số lượng Chuỗi con Khớp*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### The Challenge
### *Thách thức*
Checking if `word` is subsequence of `s` takes $O(len(s))$. Total naive time: $O(words \cdot s)$.
With $S=50000$ and $W=5000$, total ops $2.5 \cdot 10^8$. Might be TLE or very slow.
*Kiểm tra ngây thơ mất $O(W \cdot S)$, có thể bị quá thời gian.*

We need to process `s` once and advance all words simultaneously.
*Chúng ta cần xử lý `s` một lần và tiến tất cả các từ đồng thời.*

---

## 2. Strategy: Bucket Queue (Inverted Index)
## *2. Chiến lược: Hàng đợi Thùng (Chỉ mục Đảo ngược)*

### Algorithm
### *Thuật toán*

1.  **Buckets:** Create 26 buckets (Queues). `buckets[c]` stores pairs `(wordIndex, charIndex)` waiting for character `c`.
    OR simpler: Store the suffix of the word (or iterator).
    Let's store `(Iterator)` or just `String` waiting for next char.
    Actually, to avoid string slicing (expensive), store `(wordIndex, charIndex)`.
    *   **Thùng:** Tạo 26 thùng. `buckets[c]` lưu các cặp `(wordIndex, charIndex)` đang chờ ký tự `c`.*

2.  **Initialize:** Check first char of each word. Put pair `(i, 0)` into bucket corresponding to `words[i][0]`.
    *   **Khởi tạo:** Kiểm tra ký tự đầu tiên. Đặt vào thùng tương ứng.*

3.  **Process S:** Iterate through each char `c` in `s`.
    - Retrieve the entire list/queue from `buckets[c]`.
    - Clear `buckets[c]` (important! we are consuming these requests).
    - For each waiter `(wordIndex, charIndex)`:
        - Increment `charIndex`.
        - If `charIndex == words[wordIndex].length()`: Found a match! Increment result.
        - Else: The word now waits for `nextChar = words[wordIndex][charIndex]`. Put into `buckets[nextChar]`.
    *   **Xử lý S:** Duyệt qua `s`. Với mỗi ký tự `c`, lấy danh sách chờ từ `buckets[c]`. Với mỗi từ trong đó, tiến thêm 1 bước. Nếu hết từ -> Match. Nếu chưa -> Chuyển sang thùng của ký tự tiếp theo.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int numMatchingSubseq(String s, String[] words) {
    ArrayList<Integer>[] heads = new ArrayList[26]; // Or Queue
    // Actually storing 'Node' {wordIndex, charIndex}
    // Optimization: Since words[i].length is small (50), maybe simple object works.
    
    // Init buckets
    for(int i=0; i<26; i++) heads[i] = new ArrayList<>();
    
    for(int i=0; i<words.length; i++) {
        heads[words[i].charAt(0) - 'a'].add(new Node(i, 0));
    }
    
    int ans = 0;
    for(char c : s.toCharArray()) {
        ArrayList<Node> waiting = heads[c - 'a'];
        heads[c - 'a'] = new ArrayList<>(); // Reset bucket for new waiters
        
        for(Node node : waiting) {
            String w = words[node.wordIdx];
            node.charIdx++;
            if(node.charIdx == w.length()) {
                ans++;
            } else {
                char next = w.charAt(node.charIdx);
                heads[next - 'a'].add(node);
            }
        }
    }
    return ans;
}

class Node {
    int wordIdx;
    int charIdx;
    Node(int w, int c) { wordIdx = w; charIdx = c; }
}
```

Wait, `ArrayList` clear/reallocate overhead?
Better to use `ArrayDeque` or swap references.
Or `pos[26]` storing indices? No, dynamic lists.
Using built-in `LinkedList` or creating a custom simple queue is best.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S + \sum len(words))$. Every character in every word is processed at most once (when it matches `s`).
    *   **Độ phức tạp thời gian:** $O(S + \sum len(words))$.*
*   **Space Complexity:** $O(words)$. Store pointers.
    *   **Độ phức tạp không gian:** $O(words)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**S:** "abc", **Words:** ["a", "ac"]
1. Init:
   - Bucket 'a': `(0,0)`, `(1,0)`
2. Process 'a':
   - Pop `(0,0)`. Next idx 1. Len 1. Match! (Ans=1).
   - Pop `(1,0)`. Next idx 1. Char 'c'. Bucket 'c' add `(1,1)`.
3. Process 'b':
   - Bucket 'b' empty.
4. Process 'c':
   - Pop `(1,1)`. Next idx 2. Len 2. Match! (Ans=2).
**Result:** 2.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The bucket queue method (processing `S` once) is optimal. Avoid creating substrings; use indices.
*Phương pháp hàng đợi thùng (xử lý `S` một lần) là tối ưu. Tránh tạo chuỗi con; sử dụng chỉ số.*

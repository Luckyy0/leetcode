# Analysis for Partition Labels
# *Phân tích cho bài toán Phân vùng Nhãn*

## 1. Problem Essence & Last Occurrence
## *1. Bản chất vấn đề & Lần xuất hiện Cuối cùng*

### The Challenge
### *Thách thức*
If a partition contains the character 'a', it must contain *all* occurrences of 'a'. This implies that if a part starts at index `i`, it must extend at least until the **last occurrence** of `s[i]`. As we extend the partition, we might encounter other characters (e.g., 'b') whose last occurrences are even further. The partition must extend to the maximum of these last occurrences.
*Nếu một phân vùng chứa ký tự 'a', nó phải chứa *tất cả* các lần xuất hiện của 'a'. Điều này ngụ ý rằng nếu một phần bắt đầu tại chỉ số `i`, nó phải kéo dài ít nhất đến **lần xuất hiện cuối cùng** của `s[i]`. Khi mở rộng phân vùng, ta có thể gặp các ký tự khác (ví dụ: 'b') mà lần xuất hiện cuối cùng của chúng còn xa hơn. Phân vùng phải kéo dài đến giá trị lớn nhất trong số các lần xuất hiện cuối cùng này.*

---

## 2. Strategy: Greedy Extension
## *2. Chiến lược: Mở rộng Tham lam*

### Algorithm
### *Thuật toán*

1.  **Precompute Last Indices (Tính trước Chỉ số Cuối):**
    Iterate through `s` once and store the last index of each character in an array `last[26]`.
    *Duyệt qua `s` một lần và lưu chỉ số cuối cùng của mỗi ký tự vào mảng `last[26]`.*

2.  **Iterate and Extend (Duyệt và Mở rộng):**
    - Maintain `start` (start of current partition) and `end` (current required end of partition).
    - Loop through `i` from `0` to `len-1`.
    - Update `end = max(end, last[s[i]])`.
    - If `i == end`, it means we have reached the point where all characters encountered so far have their last occurrences inside or at `i`. This is a valid cut point!
    - Add `end - start + 1` to result.
    - Set `start = i + 1` for the next partition.
    *   **Duyệt và Mở rộng:** Duy trì `start` và `end`. Cập nhật `end` theo chỉ số cuối của ký tự hiện tại. Nếu `i == end`, ta đã tìm thấy điểm cắt hợp lệ. Lưu kích thước và bắt đầu phân vùng mới.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); ++i) {
        last[s.charAt(i) - 'a'] = i;
    }
    
    int j = 0, anchor = 0;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
        j = Math.max(j, last[s.charAt(i) - 'a']);
        // If current index reaches the furthest needed index
        // Nếu chỉ số hiện tại chạm đến chỉ số xa nhất cần thiết
        if (i == j) {
            ans.add(i - anchor + 1);
            anchor = i + 1;
        }
    }
    return ans;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes over the string.
    *   **Độ phức tạp thời gian:** $O(N)$. Hai lần duyệt qua chuỗi.*
*   **Space Complexity:** $O(1)$ (array of size 26).
    *   **Độ phức tạp không gian:** $O(1)$ (mảng kích thước 26).*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**String:** `ababcbacadefegde...`
1. Last indices: a:8, b:5, c:7, d:14, e:15, f:11, ...
2. Start `i=0` ('a'). `end = last['a'] = 8`.
3. `i=1` ('b'). `end = max(8, last['b']=5) = 8`.
4. ...
5. `i=8` ('a'). `end = 8`.
6. `i == end`. Cut! Length `8 - 0 + 1 = 9`. New start `9`.
7. `i=9` ('d'). `end = 14`.
8. `i=10` ('e'). `end = 15`.
...
9. `i=15` ('e'). `end = 15`. Cut! Length `15 - 9 + 1 = 7`.
**Result:** `[9, 7, ...]`.

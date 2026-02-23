# Analysis for Find And Replace in String
# *Phân tích cho bài toán Tìm và Thay thế trong Chuỗi*

## 1. Problem Essence & Simultaneity
## *1. Bản chất vấn đề & Tính đồng thời*

### THE CHALLENGE
### *Thách thức*
We need to apply multiple replacements to a string `s` based on indices and matching source strings. Importantly, the replacements happen "simultaneously", meaning that the original indices are always relevant to the input string `s`. Because the targets can have different lengths than the sources, a naive sequential replacement would shift the indices, breaking the logic.
*Chúng ta cần áp dụng nhiều phép thay thế cho chuỗi `s` dựa trên chỉ số và chuỗi nguồn khớp. Quan trọng là các phép thay thế diễn ra "đồng thời", nghĩa là các chỉ số ban đầu luôn liên quan đến chuỗi gốc `s`. Vì các chuỗi thay thế có thể có độ dài khác chuỗi nguồn, việc thay thế tuần tự ngây thơ sẽ làm lệch chỉ số.*

---

## 2. Strategy: Pre-Mapping Replacements
## *2. Chiến lược: Ánh xạ trước các thay thế*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Map Operations:** Create an array `match` of size `s.length`. For each operation $i$, check if `s` contains `sources[i]` at `indices[i]`. If it matches, store the index $i$ of the operation in `match[indices[i]]`.
    *   **Ánh xạ thao tác:** Tạo một mảng `match` kích thước bằng độ dài `s`. Với mỗi thao tác $i$, kiểm tra xem `s` có chứa `sources[i]` tại vị trí `indices[i]` không. Nếu khớp, lưu chỉ số $i$ vào `match[indices[i]]`.*

2.  **Iterative Construction:** Traverse string `s` from index 0 to `N-1`:
    - If `match[k]` contains an operation index $i$:
        - Append `targets[i]` to a `StringBuilder`.
        - Fast-forward the current index $k$ by the length of `sources[i]`.
    - Else:
        - Append the original character `s[k]` to the `StringBuilder`.
        - Increment $k$ by 1.
    *   **Xây dựng tuần tự:** Duyệt qua chuỗi `s`. Nếu tại vị trí `k` có một thao tác thay thế hợp lệ (đã lưu trong mảng `match`), ta thêm chuỗi mục tiêu vào kết quả và nhảy vọt chỉ số `k`. Ngược lại, ta giữ nguyên ký tự cũ.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    int n = s.length();
    int[] match = new int[n];
    Arrays.fill(match, -1);
    
    for (int i = 0; i < indices.length; i++) {
        if (s.startsWith(sources[i], indices[i])) {
            match[indices[i]] = i;
        }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ) {
        if (match[i] >= 0) {
            // Valid replacement
            int opIdx = match[i];
            sb.append(targets[opIdx]);
            i += sources[opIdx].length();
        } else {
            // Keep original character
            sb.append(s.charAt(i));
            i++;
        }
    }
    return sb.toString();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + K \cdot L)$, where $N$ is string length, $K$ is number of operations, and $L$ is max length of sources. We check each operation once and traverse $s$ once.
    *   **Độ phức tạp thời gian:** $O(N + K \cdot L)$, ta kiểm tra từng thao tác một lần và duyệt chuỗi `s` một lần.*
*   **Space Complexity:** $O(N + K \cdot L)$ to store the mapping and the final string.
    *   **Độ phức tạp không gian:** $O(N + K \cdot L)$ để lưu trữ dữ liệu ánh xạ và chuỗi kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]`
1. `match` initialization: `[-1, -1, -1, -1]`.
2. Op 0: `s[0...0] == "a"`? Yes. `match[0] = 0`.
3. Op 1: `s[2...3] == "cd"`? Yes. `match[2] = 1`.
4. String construction:
   - i=0: Found `match[0]=0`. Append "eee". $i = 0 + 1 = 1$.
   - i=1: `match[1]=-1`. Append "b". $i = 2$.
   - i=2: Found `match[2]=1`. Append "ffff". $i = 2 + 2 = 4$.
**Result:** "eeebffff"

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting the operations by index is another common approach, but using a mapping array of size $N$ is simpler and handles the requirement that replacements occur at fixed original indices without worrying about ordering.
*Việc sắp xếp các thao tác theo chỉ số là một cách tiếp cận phổ biến khác, nhưng sử dụng một mảng ánh xạ kích thước $N$ sẽ đơn giản hơn và xử lý tốt yêu cầu thay thế tại các vị trí gốc mà không cần lo lắng về thứ tự.*

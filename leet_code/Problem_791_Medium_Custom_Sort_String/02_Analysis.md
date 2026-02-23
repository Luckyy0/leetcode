# Analysis for Custom Sort String
# *Phân tích cho bài toán Sắp xếp Chuỗi Tùy chỉnh*

## 1. Problem Essence & Counting
## *1. Bản chất vấn đề & Đếm*

### The Challenge
### *Thách thức*
We need to reconstruct `s` such that characters appear in the priority defined by `order`. Characters not in `order` can go anywhere (usually appended at the end).
*Chúng ta cần xây dựng lại `s` sao cho các ký tự xuất hiện theo thứ tự ưu tiên được định nghĩa bởi `order`. Các ký tự không có trong `order` có thể đặt ở bất cứ đâu (thường là nối vào cuối).*

Basically, bucket sort based on `order`.
*Về cơ bản, đây là sắp xếp theo thùng (bucket sort) dựa trên `order`.*

---

## 2. Strategy: Frequency Map
## *2. Chiến lược: Bản đồ Tần suất*

### Algorithm
### *Thuật toán*

1.  **Count:** Count frequency of each char in `s` using an array `count[26]`.
    *   **Đếm:** Đếm tần suất mỗi ký tự trong `s` bằng mảng `count[26]`.*

2.  **Build from Order:**
    - Iterate through `order`.
    - For each char `c` in `order`: Append `c` to result `count[c]` times. Set `count[c] = 0`.
    *   **Xây dựng từ Order:** Duyệt qua `order`. Với mỗi ký tự `c`, thêm `c` vào kết quả `count[c]` lần. Đặt `count[c] = 0`.*

3.  **Append Remaining:**
    - Iterate through buckets 'a' to 'z'.
    - If `count[c] > 0` (chars not in `order`), append them.
    *   **Thêm phần còn lại:** Duyệt qua các thùng từ 'a' đến 'z'. Nếu `count[c] > 0`, thêm chúng vào.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public String customSortString(String order, String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    
    StringBuilder sb = new StringBuilder();
    for (char c : order.toCharArray()) {
        while (count[c - 'a'] > 0) {
            sb.append(c);
            count[c - 'a']--;
        }
    }
    
    for (int i = 0; i < 26; i++) {
        while (count[i] > 0) {
            sb.append((char)('a' + i));
            count[i]--;
        }
    }
    return sb.toString();
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S + O)$. Pass through `s` once, pass through `order` once, pass through alphabet (26) once.
    *   **Độ phức tạp thời gian:** $O(S + O)$.*
*   **Space Complexity:** $O(1)$. Array of size 26.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Order:** "cba", **S:** "abcd"
1. Count: a:1, b:1, c:1, d:1.
2. Scan Order:
   - 'c': Count 1. SB: "c". Count['c']=0.
   - 'b': Count 1. SB: "cb". Count['b']=0.
   - 'a': Count 1. SB: "cba". Count['a']=0.
3. Scan Remaining:
   - 'd': Count 1. SB: "cbad".
**Result:** "cbad".

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple counting array is efficient and clean.
*Mảng đếm đơn giản là hiệu quả và gọn gàng.*

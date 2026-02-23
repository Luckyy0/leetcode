# Analysis for Reorder Data in Log Files
# *Phân tích cho bài toán Sắp xếp lại Dữ liệu trong Tệp Nhật ký*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Sort logs based on specific rules: Letter-logs first (sorted by content then ID), Digit-logs last (stable order).
*Sắp xếp nhật ký dựa trên quy tắc: Nhật ký chữ cái trước (sắp xếp theo nội dung rồi đến ID), Nhật ký số sau (giữ nguyên thứ tự).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need a custom comparator.
- First, distinguish between Letter-log and Digit-log. Check the first character after the first space.
- If both are Letter-logs:
  - Compare content (substring after first space).
  - If content is same, compare identifiers (substring before first space).
- If one is Letter-log and one is Digit-log: Letter-log comes first (is smaller).
- If both are Digit-logs: Keep original order. This implies our sort must be **stable**. Java's `Arrays.sort` is stable for objects.
*Cần bộ so sánh tùy chỉnh. Phân biệt loại nhật ký bằng ký tự sau dấu cách đầu tiên. Nếu cả hai là chữ cái: so sánh nội dung, nếu bằng nhau so sánh ID. Chữ cái đứng trước số. Nếu cả hai là số: giữ nguyên thứ tự (Java sort ổn định).*

---

## 2. Strategy: Custom Comparator
## *2. Chiến lược: Bộ so sánh Tùy chỉnh*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Comparator Logic:**
    - Split each log into 2 parts: `id` and `content`. Finding the first space index helps.
    - Check if `content` starts with a digit or letter.
    - Case 1: Both Letter-logs. Compare `content`. If `0`, compare `id`.
    - Case 2: One Letter, One Digit. Letter is "smaller" (comes first).
    - Case 3: Both Digit. Return `0` (maintain relative order).
    *   **Logic So sánh:** Tách ID và nội dung. Kiểm tra loại. Xử lý 3 trường hợp: Cả hai chữ cái, Một chữ một số, Cả hai số.*

2.  **Sort:** `Arrays.sort(logs, comparator)`.
    *   **Sắp xếp:** `Arrays.sort`.*

3.  **Return:** `logs`.
    *   **Trả về:** `logs`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Find index of first space
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');
                
                // Get identifiers and contents
                String id1 = s1.substring(0, index1);
                String content1 = s1.substring(index1 + 1);
                String id2 = s2.substring(0, index2);
                String content2 = s2.substring(index2 + 1);
                
                // Check if contents start with digit
                boolean isDigit1 = Character.isDigit(content1.charAt(0));
                boolean isDigit2 = Character.isDigit(content2.charAt(0));
                
                // Case 1: Both are letter-logs
                if (!isDigit1 && !isDigit2) {
                    int cmp = content1.compareTo(content2);
                    if (cmp != 0) return cmp;
                    return id1.compareTo(id2);
                }
                
                // Case 2: One letter, one digit
                // Letter-log comes before Digit-log
                if (!isDigit1 && isDigit2) return -1;
                if (isDigit1 && !isDigit2) return 1;
                
                // Case 3: Both are digit-logs
                // Keep original order
                return 0;
            }
        });
        
        return logs;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L \cdot \log N)$, where $N$ is number of logs and $L$ is max length of a log. Comparing strings takes $O(L)$. Sorting takes $O(N \log N)$.
    *   **Độ phức tạp thời gian:** $O(N \cdot L \cdot \log N)$.*
*   **Space Complexity:** $O(N \cdot L)$ or $O(L)$ depending on implementation of sort and substring creation. Java's `substring` creates new strings.
    *   **Độ phức tạp không gian:** $O(L)$ hoặc $O(N \cdot L)$ do tạo chuỗi con.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a custom comparator is the standard and most readable way. Stable sort is crucial for digit logs.
*Sử dụng bộ so sánh tùy chỉnh là cách chuẩn và dễ đọc nhất. Sắp xếp ổn định là rất quan trọng đối với nhật ký số.*

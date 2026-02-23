# Analysis for Unique Email Addresses
# *Phân tích cho bài toán Địa chỉ Email Duy nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Normalize email addresses by processing '.' and '+' in the local name part.
*Chuẩn hóa địa chỉ email bằng cách xử lý '.' và '+' trong phần tên cục bộ.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Split email into `local` and `domain` by '@'.
- In `local`:
  - Ignore everything after the first `+`.
  - Remove all `.`.
- `domain` remains unchanged.
- Recombine `local + "@" + domain` and add to a Set.
- Return Set size.
*Tách email thành `tên cục bộ` và `tên miền` bằng '@'. Trong `tên cục bộ`: bỏ qua mọi thứ sau `+` đầu tiên, xóa tất cả `.`. `Tên miền` giữ nguyên. Kết hợp lại và đưa vào Set. Trả về kích thước Set.*

---

## 2. Strategy: String Processing + Set
## *2. Chiến lược: Xử lý Chuỗi + Tập hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** For each email.
    *   **Duyệt:** Từng email.*

2.  **Split:** Find the position of '@'.
    *   **Tách:** Tìm vị trí '@'.*

3.  **Process Local:**
    - Take substring before '@'.
    - Find first '+'. If exists, take substring before it.
    - Remove all '.' from the resulting string.
    *   **Xử lý Tên cục bộ:** Lấy chuỗi con trước '@'. Cắt bỏ phần sau '+'. Xóa '.'.*

4.  **Combine:** `processedLocal + "@" + domain`.
    *   **Kết hợp:** `tên cục bộ đã xử lý + "@" + tên miền`.*

5.  **Store:** Add to HashSet.
    *   **Lưu trữ:** Thêm vào HashSet.*

6.  **Return:** `set.size()`.
    *   **Trả về:** `set.size()`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);
            
            // Process local name
            // 1. Ignore everything after '+'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }
            
            // 2. Remove all '.'
            local = local.replace(".", "");
            
            uniqueEmails.add(local + domain);
        }
        
        return uniqueEmails.size();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$, where $N$ is number of emails and $L$ is max length.
    *   **Độ phức tạp thời gian:** $O(N \cdot L)$.*
*   **Space Complexity:** $O(N \cdot L)$ for the Set.
    *   **Độ phức tạp không gian:** $O(N \cdot L)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple string manipulation using `substring`, `indexOf`, and `replace`.
*Thao tác chuỗi đơn giản bằng cách sử dụng `substring`, `indexOf` và `replace`.*

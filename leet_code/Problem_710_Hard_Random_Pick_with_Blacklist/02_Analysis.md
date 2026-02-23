# Analysis for Random Pick with Blacklist
# *Phân tích cho bài toán Chọn Ngẫu nhiên với Danh sách Đen*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
$N$ can be as large as $10^9$, so we cannot store all valid numbers. However, the blacklist size $B$ is small ($10^5$). The total number of valid integers is $W = N - B$. We want to pick a random index in $[0, W - 1]$. If the picked index happens to be a blacklisted number, we need to map it to a valid number in the range $[W, N - 1]$.
*$N$ có thể lên tới $10^9$, nên ta không thể lưu tất cả các số hợp lệ. Tuy nhiên, `blacklist` khá nhỏ ($10^5$). Tổng số các số hợp lệ là $W = N - B$. Ta muốn chọn ngẫu nhiên trong $[0, W-1]$. Nếu chỉ số được chọn thuộc danh sách đen, ta cần ánh xạ nó tới một số hợp lệ trong đoạn còn lại $[W, N-1]$.*

---

## 2. Strategy: Blacklist Remapping
## *2. Chiến lược: Ánh xạ lại Danh sách Đen*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Divide the Range:** Split $N$ into two parts: $[0, W - 1]$ and $[W, N - 1]$, where $W = N - blacklist.length$.
2.  **Identify Targets:** Find all valid numbers (not in blacklist) that reside in the "top" range $[W, N - 1]$. Let's call these "available targets".
3.  **Map Blacklist items in lower range:** 
    - For every $b \in blacklist$ such that $b < W$:
    - Map $b$ to one of the "available targets" from the top range.
4.  **Pick:**
    - Generate a random integer $r \in [0, W - 1]$.
    - If $r$ is a key in our map, return `map.get(r)`.
    - Else, return $r$.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - Constructor: $O(B \log B)$ or $O(B)$ depending on implementation.
    - Pick: $O(1)$.
    * **Độ phức tạp thời gian:** $O(B)$ khởi tạo, $O(1)$ chọn số.*
*   **Space Complexity:** $O(B)$ to store the remapping.
    * **Độ phức tạp không gian:** $O(B)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Remapping is a powerful technique to handle "holes" in a range while maintaining $O(1)$ query time. By effectively "shifting" the forbidden items to the end of the range, we can treat the reduced range as a continuous block of valid candidates.
*Ánh xạ lại là kỹ thuật mạnh mẽ để xử lý các "lỗ hổng" trong một phạm vi. Bằng cách đẩy các mục bị cấm về cuối, ta có thể coi phạm vi thu nhỏ là một khối liên tục các ứng viên hợp lệ.*
---
*Sự công bằng (Equally likely) trong một môi trường bị hạn chế (Blacklist) yêu cầu một sự tinh tế trong sắp đặt. Thay vì né tránh những vùng cấm, ta xây dựng những cây cầu ánh xạ (Remapping) dẫn lối từ bóng tối sang ánh sáng. Dữ liệu dạy ta rằng bằng cách quy hoạch lại không gian (Range dividing) và chỉ định những kẻ đại diện (Targets), ta có thể thực hiện những lựa chọn tức thì mà không bao giờ vi phạm những giới hạn đã định.*
Fairness (Equally likely) in a restricted environment (Blacklist) requires a subtlety in arrangement. Instead of avoiding forbidden zones, we build mapping bridges (Remapping) leading from darkness to light. Data teaches us that by replanning space (Range dividing) and designating representatives (Targets), we can make instant choices without ever violating set limits.

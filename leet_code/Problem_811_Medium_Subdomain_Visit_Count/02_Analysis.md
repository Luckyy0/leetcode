# Analysis for Subdomain Visit Count
# *Phân tích cho bài toán Đếm lượt truy cập tên miền phụ*

## 1. Problem Essence & Domain Hierarchies
## *1. Bản chất vấn đề & Phân cấp tên miền*

### The Challenge
### *Thách thức*
The problem asks us to aggregate visit counts for all possible subdomains derived from a list of full domains. A full domain like `a.b.c` implies visits to `a.b.c`, `b.c`, and `c`. We must handle various levels of subdomains and multiple entries that might contribute to the same subdomain.
*Bài toán yêu cầu chúng ta tổng hợp số lượt truy cập cho tất cả các tên miền phụ có thể có từ một danh sách các tên miền đầy đủ. Một tên miền đầy đủ như `a.b.c` ngụ ý các lượt truy cập vào `a.b.c`, `b.c`, và `c`. Chúng ta phải xử lý các cấp độ tên miền phụ khác nhau và nhiều mục nhập có thể cùng đóng góp vào một tên miền phụ.*

---

## 2. Strategy: HashMap for Aggregation
## *2. Chiến lược: Sử dụng HashMap để tổng hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate through Input:** For each string in `cpdomains`:
    - Split the string by space to separate the `count` and the `fullDomain`.
    - Convert `count` to an integer.
    *   **Duyệt qua đầu vào:** Với mỗi chuỗi trong `cpdomains`, tách chuỗi bằng khoảng trắng để lấy `số_lượng` và `tên_miền_đầy_đủ`. Chuyển `số_lượng` sang kiểu số nguyên.*

2.  **Generate Subdomains:**
    - For a domain like `discuss.leetcode.com`, find all fragments:
      - `discuss.leetcode.com`
      - `leetcode.com` (after the first `.`)
      - `com` (after the second `.`)
    - We can do this by iteratively finding the index of the next `.` character.
    *   **Tạo tên miền phụ:** Với một tên miền như `discuss.leetcode.com`, tìm tất cả các mảnh: `discuss.leetcode.com`, `leetcode.com`, và `com`. Ta có thể làm điều này bằng cách tìm vị trí của ký tự `.` tiếp theo.*

3.  **Update Counts:**
    - Use a `HashMap<String, Integer>` where the key is the subdomain and the value is the accumulated count.
    - For each generated subdomain, add the `count` to its current value in the map.
    *   **Cập nhật số lượng:** Sử dụng một `HashMap<String, Integer>` với khóa là tên miền phụ và giá trị là số lượt truy cập tích lũy. Thêm `số_lượng` vào giá trị hiện tại trong bản đồ cho mỗi tên miền phụ được tạo ra.*

4.  **Format Result:**
    - Convert the entries in the HashMap back into the required `"count domain"` string format.
    *   **Định dạng kết quả:** Chuyển đổi các mục trong HashMap trở lại định dạng chuỗi `"số_lượng tên_miền"` theo yêu cầu.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> counts = new HashMap<>();
    for (String cpdomain : cpdomains) {
        // Split space
        int spaceIdx = cpdomain.indexOf(' ');
        int count = Integer.parseInt(cpdomain.substring(0, spaceIdx));
        String domain = cpdomain.substring(spaceIdx + 1);
        
        // Process the full domain and its parents
        while (true) {
            counts.put(domain, counts.getOrDefault(domain, 0) + count);
            int dotIdx = domain.indexOf('.');
            if (dotIdx == -1) break;
            domain = domain.substring(dotIdx + 1);
        }
    }
    
    List<String> result = new ArrayList<>();
    for (String domain : counts.keySet()) {
        result.add(counts.get(domain) + " " + domain);
    }
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$, where $L$ is the total length of all strings in `cpdomains`. Each character is visited a constant number of times during string splitting and subdomain extraction.
    *   **Độ phức tạp thời gian:** $O(L)$, với $L$ là tổng độ dài của các chuỗi. Mỗi ký tự được duyệt qua một số lần cố định.*
*   **Space Complexity:** $O(L)$, as in the worst case, every subdomain could be unique and stored in the HashMap.
    *   **Độ phức tạp không gian:** $O(L)$, vì trong trường hợp xấu nhất, mọi tên miền phụ đều duy nhất và được lưu trong HashMap.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `["900 google.mail.com"]`
1. Split: count=900, domain="google.mail.com".
2. Subdomains:
   - "google.mail.com" -> Map: {"google.mail.com": 900}
   - "mail.com" -> Map: {"google.mail.com": 900, "mail.com": 900}
   - "com" -> Map: {"google.mail.com": 900, "mail.com": 900, "com": 900}
**Result:** `["900 google.mail.com", "900 mail.com", "900 com"]`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a `HashMap` is the most efficient way to aggregate counts. Iteratively stripping the leftmost part of the domain string using `indexOf('.')` is a clean way to find all parent domains.
*Sử dụng `HashMap` là cách hiệu quả nhất để tổng hợp số lượng. Việc lặp đi lặp lại việc loại bỏ phần bên trái nhất của chuỗi tên miền bằng `indexOf('.')` là cách sạch sẽ để tìm tất cả các tên miền cha.*

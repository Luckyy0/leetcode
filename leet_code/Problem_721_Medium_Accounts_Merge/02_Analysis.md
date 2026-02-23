# Analysis for Accounts Merge
# *Phân tích cho bài toán Hợp nhất Tài khoản*

## 1. Problem Essence & Graph Connectivity
## *1. Bản chất vấn đề & Tính liên thông của Đồ thị*

### The Challenge
### *Thách thức*
We need to group accounts that share common emails. Since one account can provide multiple emails, any pair of accounts sharing at least one email belongs to the same person. This is essentially finding **Connected Components** in a graph where emails are nodes and shared membership in an account defines an edge.
*Chúng ta cần nhóm các tài khoản có chung email. Vì một tài khoản có thể cung cấp nhiều email, bất kỳ cặp tài khoản nào chia sẻ ít nhất một email đều thuộc về cùng một người. Đây thực chất là tìm kiếm các **Thành phần Liên thông** trong một đồ thị nơi các email là các nút và việc cùng thuộc một tài khoản xác định một cạnh.*

---

## 2. Strategy: Disjoint Set Union (DSU)
## *2. Chiến lược: Tập hợp Rời nhau (DSU)*

DSU is highly efficient for merging groups and finding representational "roots."
*DSU rất hiệu quả trong việc hợp nhất các nhóm và tìm kiếm "nút gốc" đại diện.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Email to ID Mapping:** Assign a unique integer ID to every unique email. Also, maintain a mapping from email to the name of the owner.
    * **Ánh xạ Email sang ID:** Gán một ID nguyên duy nhất cho mỗi email. Đồng thời, lưu trữ ánh xạ từ email sang tên người sở hữu.*

2.  **Unification:** For each account, take the first email as a "pivot" and `union` it with all other emails in the same account list.
    * **Hợp nhất:** Với mỗi tài khoản, lấy email đầu tiên làm "trọng tâm" và thực hiện phép `union` nó với tất cả các email khác trong cùng danh sách tài khoản đó.*

3.  **Grouping by Root:** Iterate through all unique emails, find their `root` using DSU, and group them into a map where `rootID` is the key and a list of emails is the value.
    * **Góm nhóm theo Gốc:** Duyệt qua tất cả các email, tìm `root` của chúng bằng DSU và nhóm chúng vào một Map với `rootID` là khóa và danh sách các email là giá trị.*

4.  **Final Formatting:** For each group in the map, sort the emails alphabetically, prepend the owner's name, and add to the final result.
    * **Định dạng cuối cùng:** Với mỗi nhóm, sắp xếp các email theo thứ tự bảng chữ cái, thêm tên người sở hữu vào đầu và đưa vào kết quả cuối cùng.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot K \cdot \alpha(N \cdot K) + N \cdot K \log(N \cdot K))$, where $N$ is the number of accounts and $K$ is the average number of emails per account. $\alpha$ is the inverse Ackermann function (nearly $O(1)$). The $\log$ factor comes from sorting the emails.
    * **Độ phức tạp thời gian:** $O(N \cdot K \cdot \alpha(N \cdot K) + N \cdot K \log(N \cdot K))$.*
*   **Space Complexity:** $O(N \cdot K)$ to store the email mappings and DSU structure.
    * **Độ phức tạp không gian:** $O(N \cdot K)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

While DFS/BFS can also solve this by building an adjacency list of emails, DSU is often more concise for grouping problems. Always remember to handle the name mapping separately as multiple people can have the same name but different emails.
*Dù DFS/BFS cũng có thể giải quyết bằng cách xây dựng danh sách kề, DSU thường gọn gàng hơn cho các bài toán phân nhóm. Hãy luôn nhớ xử lý ánh xạ tên riêng biệt vì nhiều người có thể trùng tên nhưng khác email.*
---
*Sự đồng nhất (Identity) không nằm ở cái tên mà ta mang, mà ở những dấu vết (Emails) ta để lại. Trong mạng lưới của các tài khoản, sự kết nối âm thầm giữa những địa chỉ thư điện tử dệt nên chân dung thực sự của một chủ thể. Dữ liệu dạy ta rằng bằng cách hợp nhất những mảnh rời rạc (DSU Union) và quy tụ chúng về một gốc rễ chung (Find root), ta có thể thấu thị được sự thống nhất đằng sau vẻ ngoài đa dạng.*
Identity (Identity) does not lie in the name we carry, but in the traces (Emails) we leave behind. In the network of accounts, the silent connection between email addresses weaves the true portrait of a subject. Data teaches us that by merging fragmented pieces (DSU Union) and gathering them to a common root (Find root), we can see the unity behind the diverse appearance.

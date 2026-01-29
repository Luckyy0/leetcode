# 721. Accounts Merge / Hợp nhất Tài khoản

## Problem Description / Mô tả bài toán
Given a list of `accounts` where each element `accounts[i]` is a list of strings, where the first element `accounts[i][0]` is a name, and the rest of the elements are emails representing emails of the account.
Cho một danh sách các `accounts` trong đó mỗi phần tử `accounts[i]` là một danh sách các chuỗi, với phần tử đầu tiên `accounts[i][0]` là tên và các phần tử còn lại là các email đại diện cho các email của tài khoản đó.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts.
Bây giờ, chúng ta muốn hợp nhất các tài khoản này. Hai tài khoản chắc chắn thuộc về cùng một người nếu có một số email chung cho cả hai tài khoản.

Return the accounts after merging them. The first element of each account is the name, and the rest of the emails are in sorted order.
Trả về các tài khoản sau khi hợp nhất chúng. Phần tử đầu tiên của mỗi tài khoản là tên và các email còn lại được sắp xếp theo thứ tự.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (DSU) / Tìm kiếm Tập hợp rời nhau
Each email can be considered a node in a graph. If two emails appear in the same account, there is an edge between them.
Mỗi email có thể được coi là một nút trong đồ thị. Nếu hai email xuất hiện trong cùng một tài khoản, có một cạnh giữa chúng.

However, instead of building a complex graph, we can use DSU to union all emails within each account.
Tuy nhiên, thay vì xây dựng một đồ thị phức tạp, chúng ta có thể sử dụng DSU để hợp nhất tất cả các email trong mỗi tài khoản.

Algorithm:
1. Map each email to a unique ID (0, 1, 2...).
2. Map each email to the name it belongs to.
3. For each account, union all its emails with the first email of the account.
4. Group all emails by their DSU root.
5. Sort emails in each group and add the name at the beginning.

### Complexity / Độ phức tạp
- **Time**: O(N log N) due to sorting, where N is total number of emails.
- **Space**: O(N) to store DSU and maps.

---

## Analysis / Phân tích

### Approach: DSU on Emails
We use a Union-Find structure where each email points to a representative email. This effectively connects different "account" lists that share at least one common email.
Chúng ta sử dụng cấu trúc Union-Find trong đó mỗi email trỏ đến một email đại diện. Điều này kết nối hiệu quả các danh sách "tài khoản" khác nhau có chung ít nhất một email.

---

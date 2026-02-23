# Result for Accounts Merge
# *Kết quả cho bài toán Hợp nhất Tài khoản*

## Description
## *Mô tả*

Given a list of `accounts` where each element `accounts[i]` is a list of strings, where the first element `accounts[i][0]` is a name, and the rest of the elements are emails representing emails of the account.
*Cho một danh sách các `accounts` trong đó mỗi phần tử `accounts[i]` là một danh sách các chuỗi, với phần tử đầu tiên `accounts[i][0]` là tên, và các phần tử còn lại là các email đại diện cho tài khoản đó.*

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
*Bây giờ, chúng ta muốn hợp nhất các tài khoản này. Hai tài khoản chắc chắn thuộc về cùng một người nếu có ít nhất một email chung giữa cả hai. Lưu ý rằng ngay cả khi hai tài khoản có cùng tên, chúng có thể thuộc về những người khác nhau. Một người có thể có bất kỳ số lượng tài khoản nào ban đầu, nhưng tất cả các tài khoản của họ chắc chắn có cùng tên.*

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in **sorted order**. The accounts themselves can be returned in any order.
*Sau khi hợp nhất các tài khoản, hãy trả về kết quả theo định dạng: phần tử đầu tiên của mỗi tài khoản là tên, và các phần tử còn lại là các email được **sắp xếp theo thứ tự**. Bản thân các tài khoản có thể được trả về theo bất kỳ thứ tự nào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
**Output:** [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
**Explanation:**
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as there are no common emails.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= accounts.length <= 1000`
*   `2 <= accounts[i].length <= 10`
*   `1 <= accounts[i][j].length <= 30`
*   `accounts[i][0]` consists of English letters.
*   `accounts[i][j]` (for j > 0) is a valid email.

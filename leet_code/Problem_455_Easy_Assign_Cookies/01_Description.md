# Result for Assign Cookies
# *Kết quả cho bài toán Phân phối Bánh quy*

## Description
## *Mô tả*

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
*Giả sử bạn là một bậc phụ huynh tuyệt vời và muốn cho con cái mình một ít bánh quy. Tuy nhiên, bạn chỉ nên cho mỗi đứa trẻ tối đa một chiếc bánh.*

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with; and each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign the cookie `j` to the child `i`, and the child `i` will be content. Your goal is to **maximize** the number of your content children and output the maximum number.
*Mỗi đứa trẻ `i` có một mức độ ham muốn `g[i]`, đó là kích thước tối thiểu của chiếc bánh quy mà đứa trẻ sẽ thấy hài lòng; và mỗi chiếc bánh quy `j` có kích thước `s[j]`. Nếu `s[j] >= g[i]`, chúng ta có thể giao chiếc bánh `j` cho đứa trẻ `i`, và đứa trẻ `i` sẽ thấy hài lòng. Mục tiêu của bạn là **tối đa hóa** số lượng trẻ hài lòng và trả về con số đó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `g = [1,2,3], s = [1,1]`
**Output:** `1`
**Explanation:** You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

## Example 2:
## *Ví dụ 2:*

**Input:** `g = [1,2], s = [1,2,3]`
**Output:** `2`
**Explanation:** You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.

## Constraints:
## *Ràng buộc:*

*   `1 <= g.length <= 3 * 10^4`
*   `0 <= s.length <= 3 * 10^4`
*   `1 <= g[i], s[j] <= 2^{31} - 1`

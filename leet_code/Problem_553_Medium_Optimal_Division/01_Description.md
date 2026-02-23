# Result for Optimal Division
# *Kết quả cho bài toán Chia Tối ưu*

## Description
## *Mô tả*

You are given an integer array `nums`. The adjacent integers in `nums` will perform the float division. For example, for `nums = [2,3,4]`, this expression would be `"2/3/4"`.
*Bạn được cho một mảng số nguyên `nums`. Các số nguyên liền kề trong `nums` sẽ thực hiện phép chia số thực. Ví dụ, với `nums = [2,3,4]`, biểu thức này sẽ là `"2/3/4"`.*

*   However, you can add any number of parenthesis at any position to change the priority of operations. You want to add these parentheses such that the value of the expression after the evaluation is maximum.
    *Tuy nhiên, bạn có thể thêm bất kỳ số lượng dấu ngoặc đơn nào tại bất kỳ vị trí nào để thay đổi thứ tự ưu tiên của các phép toán. Bạn muốn thêm các dấu ngoặc này sao cho giá trị của biểu thức sau khi tính toán là lớn nhất.*

Return *the corresponding expression that has the maximum value in string format*.
*Trả về *biểu thức tương ứng có giá trị lớn nhất ở định dạng chuỗi*.*

**Note:** your expression should not contain redundant parenthesis.
***Lưu ý:** biểu thức của bạn không được chứa các dấu ngoặc đơn dư thừa.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1000,100,10,2]`
**Output:** `"1000/(100/10/2)"`
**Explanation:** 1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the other possible expressions are:
1000/(100/10)/2 = (1000/10)/2 = 50
1000/(100/(10/2)) = 1000/(100/5) = 1000/20 = 50
1000/100/10/2 = ((1000/100)/10)/2 = 0.5
1000/100/(10/2) = (1000/100)/5 = 0.2

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,3,4]`
**Output:** `"2/(3/4)"`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [2]`
**Output:** `"2"`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10`
*   `2 <= nums[i] <= 1000`
*   There is only one optimal division for the given input.
*   *Chỉ có một phép chia tối ưu cho đầu vào được cho.*

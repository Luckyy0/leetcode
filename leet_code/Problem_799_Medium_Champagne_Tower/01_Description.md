# Result for Champagne Tower
# *Kết quả cho bài toán Tháp Sâm panh*

## Description
## *Mô tả*

We stack glasses in a pyramid, where the **first** row has `1` glass, the **second** row has `2` glasses, and so on until the **100th** row. Each glass holds one cup of champagne.
*Chúng ta xếp các ly thành hình kim tự tháp, với hàng **đầu tiên** có `1` ly, hàng **thứ hai** có `2` ly, và tiếp tục cho đến hàng thứ **100**. Mỗi ly chứa được một cốc sâm panh.*

Then, some champagne is poured into the first glass at the top. When the topmost glass is full, any excess liquid poured will fall equally onto the glass immediately to the left and right of it. When those glasses become full, any excess champagne will fall equally onto their left and right glasses, and so on. (A glass at the bottom edge has its excess liquid fall onto the floor.)
*Sau đó, một lượng sâm panh được đổ vào ly đầu tiên ở đỉnh. Khi ly trên cùng đầy, bất kỳ chất lỏng dư thừa nào sẽ rơi đều xuống các ly ngay phía dưới bên trái và bên phải của nó. Khi các ly đó đầy, chất lỏng dư thừa lại rơi đều xuống các ly bên dưới chúng, và cứ tiếp tục như vậy.*

For example, after one cup of champagne is poured, the top glass is full. After two cups of champagne are poured, the two glasses on the second row are half full, while the top glass is still full. After ten cups of champagne are poured, some row of glasses is full, and some cups will be partially full.
*Ví dụ, sau khi đổ một cốc, ly trên cùng đầy. Sau khi đổ hai cốc, hai ly ở hàng thứ hai đầy một nửa, trong khi ly trên cùng vẫn đầy.*

Given how many cups have been poured, return how full the `j`-th glass of the `i`-th row is (both `i` and `j` are 0-indexed.)
*Cho biết số cốc đã đổ, hãy trả về mức độ đầy của ly thứ `j` ở hàng thứ `i` (cả `i` và `j` đều bắt đầu từ 0).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** poured = 1, query_row = 1, query_glass = 1
**Output:** 0.00000
**Explanation:** We poured 1 cup of champagne to the top glass of the tower (which is row 0, glass 0). That glass is now full. There is no extra champagne that fell to any other glass.

## Example 2:
## *Ví dụ 2:*

**Input:** poured = 2, query_row = 1, query_glass = 1
**Output:** 0.50000
**Explanation:** We poured 2 cups of champagne to the top glass of the tower (which is row 0, glass 0). There is one cup of extra champagne after the top glass has been full. That one cup flows equally to the two glasses on the next row, and each glass is half full.

## Example 3:
## *Ví dụ 3:*

**Input:** poured = 100000009, query_row = 33, query_glass = 17
**Output:** 1.00000

---

## Constraints:
## *Ràng buộc:*

*   `0 <= poured <= 10^9`
*   `0 <= query_glass <= query_row < 100`

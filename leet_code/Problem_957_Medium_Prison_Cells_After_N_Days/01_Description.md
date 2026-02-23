# Result for Prison Cells After N Days
# *Kết quả cho bài toán Tế bào Nhà tù sau N Ngày*

## Description
## *Mô tả*

There are `8` prison cells in a row and each cell is either occupied or vacant.
*Có `8` tế bào nhà tù thành một hàng và mỗi tế bào hoặc bị chiếm đóng hoặc bị bỏ trống.*

On each day, whether the cell is occupied or vacant changes according to the following rules:
*Vào mỗi ngày, việc tế bào bị chiếm đóng hay bị bỏ trống thay đổi theo các quy tắc sau:*

*   If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    *   *Nếu một tế bào có hai hàng xóm liền kề đều bị chiếm đóng hoặc đều bị bỏ trống, thì tế bào đõ trở nên bị chiếm đóng.*
*   Otherwise, it becomes vacant.
    *   *Ngược lại, nó trở nên bị bỏ trống.*

(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
*(Lưu ý rằng vì nhà tù là một hàng, nên tế bào đầu tiên và cuối cùng trong hàng không thể có hai hàng xóm liền kề.)*

We describe the current state of the prison in the following way: `cells[i] == 1` if the `i`th cell is occupied, else `cells[i] == 0`.
*Chúng ta mô tả trạng thái hiện tại của nhà tù theo cách sau: `cells[i] == 1` nếu tế bào thứ `i` bị chiếm đóng, ngược lại `cells[i] == 0`.*

Given the initial state of the prison, return *the state of the prison after* `n` *days (and* `n` *such changes described above)*.
*Cho trạng thái ban đầu của nhà tù, hãy trả về *trạng thái của nhà tù sau* `n` *ngày (và* `n` *thay đổi như mô tả ở trên)*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** cells = [0,1,0,1,1,0,0,1], n = 7
**Output:** [0,0,1,1,0,0,0,0]
**Explanation:** 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

## Example 2:
## *Ví dụ 2:*

**Input:** cells = [1,0,0,1,0,0,1,0], n = 1000000000
**Output:** [0,0,1,1,1,1,1,0]

---

## Constraints:
## *Ràng buộc:*

*   `cells.length == 8`
*   `cells[i]` is either `0` or `1`.
*   `1 <= n <= 10^9`

# Distant Barcodes
# *Khoảng Cách Mã Vạch Mã Hóa*

## Description
## *Mô tả*

In a warehouse, there is a row of barcodes, where the `ith` barcode is `barcodes[i]`.
*Tại một nhà kho khổng lồ, lô hàng đang được dán một dãy dài các tem mã vạch, trong đó cái mã vạch xếp thứ `i` cõng trên lưng mình con số định danh `barcodes[i]`.*

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.
*Sứ mệnh của bạn là đập đi Tráo Xếp lại trật tự toàn bộ cái đống mã vạch hỗn tạp này, tuân thủ một Nguyên Tắc Cách Ly Nghiêm Ngặt: **TUYỆT ĐỐI KHÔNG để bất kỳ HAI cái mã vạch nào giống hệt nhau được quyền đứng cạnh kề vai sát cánh nhau**.*
*Bạn có quyền được xổ ra ĐÁP ÁN BẤT KỲ miễn là nó thỏa phương trình điều kiện trên. Phía Vũ trụ Lõi Ràng Buộc cũng đã nháy mắt thề thốt xác nhận RẰNG: Việc xếp đội hình này chắc chắn 100% luôn luôn tồn tại nẻo thoát (luôn có Cách Giải Quyết).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** barcodes = [1,1,1,2,2,2]
**Output:** [2,1,2,1,2,1]
**Explanation:** 
*Giải thích:*
*Bạn cũng hoàn toàn có thể trả về một Đội hình hợp lệ khác tỉ như: `[1,2,1,2,1,2]`.*

## Example 2:
## *Ví dụ 2:*

**Input:** barcodes = [1,1,1,1,2,2,3,3]
**Output:** [1,3,1,3,1,2,1,2]
**Explanation:** 
*Giải thích:*
*Con số 1 là thằng sừng sỏ nhất đông quân nhất. Cắm cọc chẻ cừ rải đều chúng ra trước, rồi lấy rào 2 và 3 đắp phanh nhét vào các khe nứt xen kẽ.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= barcodes.length <= 10000`
*   `1 <= barcodes[i] <= 10000`

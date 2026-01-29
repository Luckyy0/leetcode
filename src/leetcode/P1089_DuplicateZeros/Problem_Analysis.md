# 1089. Duplicate Zeros / Nhân bản Số không

## Problem Description / Mô tả bài toán
Given a fixed-length integer array `arr`, duplicate each occurrence of zero, shifting the remaining elements to the right.
Cho một mảng số nguyên có độ dài cố định `arr`, nhân bản mỗi lần xuất hiện của số không, dịch chuyển các phần tử còn lại sang phải.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array **in place** and do not return anything.
Lưu ý rằng các phần tử vượt quá độ dài của mảng ban đầu sẽ không được ghi. Thực hiện các sửa đổi trên đối với mảng đầu vào **tại chỗ** và không trả về bất cứ thứ gì.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pass (Count then Write) / Hai lần Duyệt (Đếm rồi Ghi)
The array length is fixed.
If we insert 0, elements shift. Some elements "fall off".
We need to know which element ends up at the last position `arr[n-1]`.
Pass 1: Find how many zeros are in the part of array that will "survive".
Actually, simulate the "virtual" expansion.
Iterate `i` and keep track of `virtual_index`. If `arr[i] == 0`, `virtual_index += 2`, else `+= 1`.
Stop when `virtual_index` reaches `n`.
This tells us the `effective_len` of the original array that fits.

Pass 2: Iterate backwards from the last "surviving" element and write to the end of array.

Edge case: If the last surviving element is `0` but it cannot be fully duplicated because only 1 space left at the end.
(e.g., `[0, ...], n=2`. If virtual length hits `n+1` due to a zero, then the second zero of pair falls off).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two-Pass Expansion
Pass 1: Determine the effective range of the original array elements that will fit in the final array. Keep track of the number of zeros encountered to map the original index to the destination index. Handle the boundary case where a zero might be straddled (duplicated but only one fits) specially.
Pass 2: Iterate backwards from the last valid element, placing numbers in their calculated new positions (copying zeros twice, others once). Working backwards prevents overwriting elements before they are processed.
Vòng 1: Xác định phạm vi hiệu quả của các phần tử mảng ban đầu sẽ nằm gọn trong mảng cuối cùng. Theo dõi số lượng số 0 gặp phải để ánh xạ chỉ số ban đầu đến chỉ số đích. Xử lý trường hợp biên nơi một số 0 có thể bị cắt (nhân đôi nhưng chỉ vừa một số) một cách đặc biệt.
Vòng 2: Lặp ngược lại từ phần tử hợp lệ cuối cùng, đặt các số vào vị trí mới đã tính toán của chúng (sao chép số 0 hai lần, các số khác một lần). Làm việc ngược lại ngăn ghi đè lên các phần tử trước khi chúng được xử lý.

---

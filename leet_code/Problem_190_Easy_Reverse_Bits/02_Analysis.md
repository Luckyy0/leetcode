# Analysis for Reverse Bits
# *Phân tích cho bài toán Đảo ngược Bit*

## 1. Problem Essence & Bit Manipulation
## *1. Bản chất vấn đề & Thao tác Bit*

### The Task
### *Nhiệm vụ*
We have a 32-bit integer. We need to swap the first bit with the last, the second with the second-to-last, and so on.
*Chúng ta có một số nguyên 32-bit. Chúng ta cần hoán đổi bit đầu tiên với bit cuối cùng, bit thứ hai với bit áp chót, v.v.*

### Java Specifics
### *Đặc thù Java*
In Java, integers are signed (using 2's complement). However, bitwise operators (`<<`, `>>`, `>>>`, `&`, `|`, `^`) ignore the sign and treat the number as a sequence of 32 bits. The only thing to watch out for is the right shift:
- `>>` preserves the sign bit (Arithmetic shift).
- `>>>` fills with zeros (Logical shift).
For this problem, since we want to treat it as unsigned bits shifting around, `>>>` is generally safer theoretically, though we are mostly constructing a *new* integer so shifting logic on the input is key.
*Trong Java, số nguyên có dấu (sử dụng bù 2). Tuy nhiên, các toán tử bitwise bỏ qua dấu và coi số như một chuỗi 32 bit. Điều duy nhất cần lưu ý là phép dịch phải: `>>` giữ lại bit dấu, `>>>` điền thêm số 0.*

---

## 2. Approach: Iterative Bitwise Construction
## *2. Hướng tiếp cận: Xây dựng Bitwise lặp lại*

### Logic
### *Logic*
We treat the result `res` as a stack/queue of bits.
1.  Initialize `res = 0`.
2.  Loop from `i = 0` to `31` (32 times):
    - Shift `res` to the left (`res <<= 1`) to make room for the new bit.
    - Get the Last Significant Bit (LSB) of `n`: `n & 1`.
    - Add this LSB to `res`: `res += (n & 1)` (or `res | (n & 1)`).
    - Shift `n` to the right to process the next bit: `n >>= 1` (or `n >>>= 1`).
    *Lưu ý: Đối với bit cuối cùng, chúng ta không cần dịch `res` thêm một lần nữa, nhưng logic vòng lặp thông thường sẽ dịch `res` trước khi thêm bit, vì vậy sau 32 vòng lặp, bit thêm vào đầu tiên sẽ được dịch sang trái 31 lần.*

**Correct Loop Order:**
- Start loop.
- `res <<= 1`.
- `res = res | (n & 1)`.
- `n >>= 1`.
- End loop.
*Thứ tự đúng: Dịch đích sang trái, cộng bit cuối của nguồn, dịch nguồn sang phải.*

---

## 3. Alternative Approach: Divide and Conquer (Byte Manipulation)
## *3. Hướng tiếp cận thay thế: Chia để trị (Thao tác Byte)*

If we call this function many times, we can cache the reverse of every byte (8 bits).
Since a 32-bit integer is 4 bytes, we can:
1.  Split `n` into 4 bytes.
2.  Reverse each byte using a lookup table (cache).
3.  Reassemble the bytes in reverse order.
*Nếu gọi hàm này nhiều lần, chúng ta có thể cache kết quả đảo ngược của mỗi byte (8 bit). Vì số nguyên 32-bit là 4 byte, chúng ta có thể: 1. Tách `n` thành 4 byte. 2. Đảo ngược mỗi byte bằng bảng tra cứu. 3. Lắp ráp lại các byte theo thứ tự đảo ngược.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. It's essentially $O(32)$, which is constant.
    *Độ phức tạp thời gian: $O(1)$. Về bản chất là $O(32)$.*
*   **Space Complexity:** $O(1)$. We only use a result variable.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = ...0011` (decimal 3)

1.  i=0: `res` shifts left (0). `n&1` is 1. `res` becomes 1. `n` becomes `...001`.
2.  i=1: `res` shifts left (10 = 2). `n&1` is 1. `res` becomes 11 (3). `n` becomes `...000`.
3.  i=2...31: `res` keeps shifting left. `n` is 0, so adding 0.
4.  Result: `1100...00` (The two 1s moved to the most significant positions).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bit manipulation problems are all about being comfortable with `&`, `|`, `<<`, and `>>`. The most confusing part for Java developers is usually the input signedness. Remember: **bits are just bits**. `-3` is just `1111...1101`. Treat it as a pattern, not a number.
*Các bài toán thao tác bit chủ yếu là về việc thành thạo `&`, `|`, `<<`, và `>>`. Phần gây nhầm lẫn nhất đối với lập trình viên Java thường là dấu của đầu vào. Hãy nhớ: **bit chỉ là bit**. `-3` chỉ là `1111...1101`. Hãy coi nó như một mẫu hình, không phải một con số.*
---
*Đảo ngược một con số giống như nhìn vào gương; giá trị thay đổi, nhưng bản chất nhị phân vẫn vẹn nguyên.*
Reversing a number is like looking in a mirror; the value changes, but the binary essence remains intact.

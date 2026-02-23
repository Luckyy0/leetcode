# Analysis for Remove All Adjacent Duplicates In String
# *Phân tích bài toán Xóa Tất Cả Các Ký Tự Lặp Cạnh Nhau Trong Chuỗi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A string is given where we can actively repeatedly remove any pair of identical adjacent characters until no such pairs exist anywhere. We must return the final state of the string after this process concludes fully.
*Cho một chuỗi. Cứ thấy 2 chữ cái giống hệt nhau đứng liền kề nhau là ta sẽ xóa bỏ cả cặp. Hai đoạn chuỗi sau đó tiếp tục kết dính lại. Cứ thế lặp lại hành động này cho đến khi không còn cặp nào bị trùng sát nhau. Chuỗi kí tự nào sẽ là kết quả cuối cùng?*

---

## 2. Strategy: Optimal (Stack Data Structure)
## *2. Chiến lược: Tối ưu (Cấu trúc dữ liệu Ngăn Xếp)*

### Logic and Rules
### *Lý luận và Quy tắc*

This is the quintessential textbook example of a **Stack** data structure problem. When we iterate through the characters of the string sequentially:
*Bài toán tháo gỡ này mang tính hình mẫu chuẩn mực của Cấu Trúc Ngăn Xếp (Stack). Khi duyệt qua từng ký tự trên một chuỗi tuần tự:*

1. If the stack is NOT empty AND the current character perfectly matches the character currently sitting at the absolute TOP of the stack, this is a DUPLICATE ALERT!
*1. Nếu cấu trúc Ngăn Xếp đang chứa ký tự (không rỗng), đồng thời ký tự Đỉnh của Ngăn xếp lại giống hệt với ký tự hiện tại ta đang duyệt, đây là tín hiệu báo động một cặp Dư Thừa!*

2. We POP the element from the stack and DO NOT add the current character. Both effectively disappear.
*2. Xử lý triệt để: Rút bỏ kí tự Tầng Chóp khỏi Ngăn Xếp (lệnh bóc dỡ `pop()`). Đồng thời không đưa kí tự hiện tại vào nữa. Kết quả là cả một cặp bị tiêu hủy hoàn toàn.*

3. If it is a DIFFERENT character, or the stack is empty, we securely PUSH the current character onto the stack!
*3. Trường hợp ký tự lệch mặt không khớp (khác biệt), hoặc Ngăn xếp đang rỗng không: Tiến hành nhét thẳng chữ cái hiện tại này đẩy Chóp xếp trồng lên trên (`push()`).*

Finally, forcefully empty the remaining characters in the stack structure back into a string. The leftover characters formulate the absolute answer accurately.
*Cuối cùng: Trút rổ, quét thu hồi những gì còn đọng lại xót lách chưa bị huỷ từ cấu trúc vỏ Vét để tạo thành Chuỗi kết quả đọng đóng cọc Cuối cùng.*

### Java Optimal Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char currentBox : s.toCharArray()) {
            int currentLength = stack.length();
            
            // So Khớp Đỉnh Xếp - So Chạm - Thải Gỡ!
            if (currentLength > 0 && stack.charAt(currentLength - 1) == currentBox) {
                // Kích Nổ Gạt Bỏ Gốc Tại Đỉnh Nòng (Xoáy Pop)
                stack.deleteCharAt(currentLength - 1);
            } else {
                // Nhập Kho Ngăn Xếp Đáy (Đẩy Push Trụ)
                stack.append(currentBox);
            }
        }
        
        // Trả Xác Thành Quả Rút Kết
        return stack.toString();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We sequentially iterate identically through the total $N$ characters strictly once. Pushing into and explicitly popping safely from the stack optimally takes uniform constant time functionally $O(1)$. Total is firmly linear.
    *   **Độ phức tạp thời gian:** $O(N)$. Quy trình này trượt thân kiểm tra tuyến tính MỘT LẦN toàn thể $N$ ký tự liền mạch. Mỗi giao dịch Push vứt Đáy hay Pop Mở Đỉnh Ngăn Xếp Tốn Kịch Chỉ Phí Chuẩn Gốc $O(1)$. Nên Tổng Nhãn là $O(N)$!
*   **Space Complexity:** $O(N)$. The dynamic stack specifically expands inherently tightly taking memory. In the absolute worst case safely explicitly accurately logically realistically effectively (Example: no duplicates flawlessly natively!), taking space bounded logically explicitly to $N$.
    *   **Độ phức tạp không gian:** $O(N)$. `StringBuilder` (Vai trò Ngăn Xếp Cắm RAM) hấp thụ Dữ liệu nén Trữ. Trường hợp Đụng chuỗi Đục Đáy không cạ sát trùng nào, Dài Trái Phình Ống chóp Lưu đúng Kích Dài của N. Mang Phí Vỏ Bụng $O(N)$. Mát Lòng!*

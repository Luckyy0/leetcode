# Analysis for Remove Outermost Parentheses
# *Phân tích cho bài toán Bóc vỏ Dấu Ngoặc Lớp Ngoài Cùng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A "primitive" valid parenthesis string is a self-enclosed block that cannot be split into two smaller valid blocks cleanly (e.g., `(())` is primitive, but `()()` isn't because you can cut it in half). The task requires us to partition a long string into such primitive chunks, and strictly strip exactly one outer layer of `()` from each chunk, then stitch what's left.
*Một mảng "mầm nguyên thủy" (primitive) là một khối bao đóng chặt khít không thể chẻ nhỏ ra thành hai mảng phụ lỏng lẻo (vd: `(())` là nguyên thủy nguyên khối, nhưng `()()` thì không vì nó chẻ đôi dễ dàng). Bài toán dụ dỗ chúng ta xẻ chuỗi tổ chảng ra thành các khối mầm đá đó, lột bỏ CHÍNH XÁC đúng 1 lớp giáp vỏ `()` bao bọc ngoài cùng mỗi khối, rồi ráp ruột non lại với nhau.*

---

## 2. Strategy 1: Naive (Two-Pass Splitting & Stripping)
## *2. Chiến lược 1: Ngây thơ (Cắt riêng rẽ và Lột vỏ)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea strictly follows the logical steps of the problem description:
1. Parse the string `s` from left to right, hunting for valid primitive chunks.
2. We keep a `balance` counter (`(` adds 1, `)` subtracts 1). Whenever `balance` hits `0`, we have perfectly isolated a primitive block. We substring it out into a List!
3. Iterate over the List of primitive substrings, manually slice off the first and last character `substring(1, block.length() - 1)`, and concatenate them to a final output string.
*Ý tưởng ngây thơ sẽ ngoan ngoãn bắt chước lời giải thích của đề bài:*
*1. Quét chuỗi `s` từ trái dọc sang phải, đi ngắm nghía tìm cách lôi lốc từng ổ "mầm đá" ra.*
*2. Tính sổ một biến đếm `balance` cân bằng (gặp `(` cộng 1, xuống `)` trừ 1). Gặt hái lúc bảng biến chạy về số `0`, lúc đó một mảng khối kín đã hình thành! Cắt nhéo nó ném vào Bảng danh sách.*
*3. Quét vòng 2 lôi nguyên mẻ trong Bảng danh sách ra, tự bóc vỏ gọt đuôi mảnh `substring(1, block.length() - 1)`, sau đó ép tụ lợp lại vào bức tranh kết quả dài.*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String removeOuterParenthesesNaive(String s) {
        List<String> primitives = new ArrayList<>();
        int balance = 0;
        int startIndex = 0;
        
        // Cắt khúc rã rễ
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') balance++;
            else balance--;
            
            if (balance == 0) {
                primitives.add(s.substring(startIndex, i + 1));
                startIndex = i + 1;
            }
        }
        
        // Bóc vỏ rồi ráp
        StringBuilder sb = new StringBuilder();
        for (String block : primitives) {
            sb.append(block.substring(1, block.length() - 1));
        }
        return sb.toString();
    }
}
```

- **Weakness (Điểm yếu):** We do multiple string slicing operations `substring()`, generating a flurry of short-lived string objects on the Java Heap, provoking intense Garbage Collection. We loop twice and use an auxiliary List, scaling relatively slowly.
  *Khá bám sát và hoạt động tốt, nhưng chúng ta cứ vung tay múa kiếm chém hàm khởi mảng `substring()` lung tung. Việc chèn, chặt chuỗi này sản sinh rác lắt nhắt siêu tốc trên Heap, bắt máy dọn rác (GC) chạy hộc máu. Quét chập chéo 2 lần kèm cấp RAM cho List, hiệu suất trượt thoái đi đáng kể.*

---

## 3. Strategy 2: Optimal (One-Pass Balance Tracking)
## *3. Chiến lược 2: Tối ưu (Quét Lướt Đếm Cân Bằng Một Chạm)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Do we *really* need to carefully split it into chunks, then slice the chunks, then re-glue them back? ABSOLUTELY NOT! 
We can bypass the chunking entirely by simply conditionally ignoring the very first `(` and the very last `)` of a localized primitive block directly as we iterate string `s`.
Using the same `balance` counter:
- When examining `(`, we first check the *current* `balance` counter. If `balance > 0`, it guarantees that this `(` is nestled deeply **inside** a block, thus it is NOT the outermost shell! We proudly append it. Then we increment `balance++`. (If `balance` was `0`, it's the outermost trigger! We skip appending and purely do `balance++`).
- When examining `)`, we first *decrement* `balance--`! If the newly calculated `balance > 0`, it signifies there are still open brackets, meaning this `)` sits firmly **inside** the block and is strictly NOT the outermost shell matching to 0! We append it.
*Chúng ta MÂY MÙ gì mà phải cực nhọc chẻ nó ra rồi mới gọt vỏ rồi lại chắp vá mảng cơ chứ? KHÔNG HỀ!*
*Ta có thể chơi chiêu trốn nợ ngầm: Vẫn cứ lướt tay qua cả chiều dọc chữ. Chỉ Cần Nhất Quyết Lờ Đi, Cấm cửa nối dính cái chóp vỏ `(` mở hàng đầu tiên, và cấm cửa con ốc nhốt `)` khóa hàng cuối cùng ở Rãnh block!*
*Phát pháo bằng cục biến đếm quen thuộc `balance`:*
*- Xét thấy dấu `(`, ta đứng ngó trước cái cân nặng `balance`. Nếu `balance > 0`, nó chắc mẩm rằng con ngoặc này bị NHỐT THỤT SÂU bên trong lõi mảng rồi (vỏ kén đã bung từ trước), chẳng phải vỏ lớp viền cực đoạn ngoài cùng đâu. Nối nó vô đống nháp Result. Cuối bước mới tăng `balance++`. (Ai dè nếu `balance == 0`, mèn đét ơi, hắn chính là Lớp Vỏ Đại Công Tước khai mạc, ngó xéo qua mặt khỏi nối rồi vọt lẹ tăng `balance++`).*
*- Ngược lại rớt lấy gặp `)`, TA TRỪ NỢ LÚC ĐÓ LUÔN `balance--`. Giả sử trừ dứt xong `balance` VẪN HƠN MÚC 0 (`balance > 0`). Tức là cánh cổng ngoặc mở ngoài xa xăm kia còn chưa chốt gài vĩnh viễn, con `)` này vẫn chưa đóng dấu Lớp Vỏ Phong Ấn Tận Cùng! Nối con `)` vô.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Nếu chóp balance đã lớn hơn 0, con `(` này nằm thụt trong hang
                if (balance > 0) {
                    result.append(c);
                }
                balance++; // Sau khi dòm dính thì mới dâng nấc balance
            } else { // c == ')'
                balance--; // Bắt được `)` thì xẹp balance trước
                // Nếu dập balance xuống mà tháp vẫn trụ lớn hơn 0, con `)` này chưa phải Vỏ khóa
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ mathematically tight. The single unified loop traverses the string exactly once. The character array extraction and `StringBuilder.append()` handle work precisely sequentially $N$ operations. Purely blazing fast.
    *   **Độ phức tạp thời gian:** $O(N)$ khép kín chặt chẽ! Chỉ duy nhất một đường cày đi dọc thẳng hàng tới khi đụng rào mảng hết chuỗi. Trích xuất thành thạo đan len với `append()` diễn biến suôn mượt mờ nhân ảnh.*
*   **Space Complexity:** $O(N)$. Because strings in Java are immutable, returning a brand new string obligates setting aside a `StringBuilder` memory tank carrying up to almost $N$ isolated characters long. Standard structural space.
    *   **Độ phức tạp không gian:** $O(N)$. Yêu sách của mảng String Java là đặc tính "Không thể biến hình" Immutable, trả một cuộn dây câu mới toanh thì đương nhiên phải chừa ra nguyên 1 bình oxy `StringBuilder` dài cỡ N để ép khí đè nén. Điều kiện tĩnh vật lý bắt buộc.*

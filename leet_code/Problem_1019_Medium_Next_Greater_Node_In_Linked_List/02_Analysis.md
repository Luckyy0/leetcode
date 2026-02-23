# Analysis for Next Greater Node In Linked List
# *Phân tích cho bài toán Nút Lớn hơn Tiếp theo trong Danh sách Liên kết*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a singular Linked List, for each node, find the value of the very next node structurally downstream that boasts a strictly larger value. Retain original array order for returning. If no larger node sits down the line, slap down `0`.
*Cho một Danh sách liên kết một chiều, yêu cầu tìm số đo của Nút lớn hơn đầu tiên xuất hiện phía sau mỗi phần tử. Bảo lưu nguyên vẹn thứ tự vốn có của chùm để xuất dạng chuỗi mảng kết quả. Mò không thấy ai lớn hơn thì nhét vô `0`.*

---

## 2. Strategy 1: Naive (Double Iteration)
## *2. Chiến lược 1: Ngây thơ (Lặp dây chuyền ké)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy simulates a human looking forward. Stand at the current linked node, deploy a runner node heading down the list looking for a bigger value. When found, log it and step to the next node. Because we don't know the exact length in advance, we use a dynamic `ArrayList` to collect results, then convert it to an `int[]`.
*Chiến lược ngây thơ làm y chang cách người trần mắt thịt làm. Neo chân ở nút hiện tại, phóng phi tiêu một con trỏ chạy quét về phía trước lùng sục số đo lớn hơn. Thấy là tóm ngay và ghi vào Danh sách, sau đó rút chân sang nút kế và lặp lại. Vì danh sách liên kết không báo trước số lượng cụ thể, ta nhét vào `ArrayList` rồi mới đẩy xuất ra thành mảng cố định `int[]`.*

```java
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Solution {
    public int[] nextLargerNodesNaive(ListNode head) {
        ArrayList<Integer> resultList = new ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            ListNode runner = current.next;
            int nextLarger = 0;
            
            while (runner != null) {
                if (runner.val > current.val) {
                    nextLarger = runner.val;
                    break;
                }
                runner = runner.next;
            }
            
            resultList.add(nextLarger);
            current = current.next;
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
```

- **Weakness (Điểm yếu):** Running a secondary pointer from every node creates a strict $O(N^2)$ time complexity. If the structure is strictly monotonically decreasing (like `10^4, 10^4-1, 10^4-2...`), the runner will pointlessly sweep the entire remaining list without ever finding a larger node, wasting $\sim 5 \times 10^7$ iterations. This forces significant performance degradation and risks Time Limit Exceeded (TLE) against the $10^4$ cap.
  *Cứ mỗi nút đứng neo chân là lại cắt cử một con trỏ phụ vác balô quét từ đầu cuối, gây nên thời gian tồi tệ $O(N^2)$. Giả sử chuỗi rớt dốc kiểu "Giá giảm đều đặn", con trỏ phụ sẽ phải cày bục mặt quét tuốt luột cả dây chuyền mà rốt cuộc vẫn hoài công vô ích vì chả có ai lớn hơn. Cạn kiệt 50 triệu bước quét thừa thãi. Ăn ngay lỗi phung phí tài nguyên TLE tại $N = 10^4$.*

---

## 3. Strategy 2: Optimal (Monotonic Stack)
## *3. Chiến lược 2: Tối ưu (Ngăn xếp Đơn điệu)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of eagerly scanning forward from every spot, we use a **Monotonic Decreasing Stack** (`Ngăn xếp giảm dần`) to aggressively track numbers whose "Next Greater Element" hasn't been found yet. 
First, we traverse the linked list completely into a standard `ArrayList` to get $O(1)$ index access.
Iterate through the array. Wait, we don't store values in the stack; we store the **indexes** of elements currently searching for their champion.
If the current array value is LARGER than the value at the index sitting on the top of the stack, congratulations! We instantly found the exact "Next Greater Node" for that topmost index. Pop that index and permanently record the current value in our answer array. 
The beauty lies in the fact that one incoming giant number can simultaneously resolve the search queues of a dozen smaller indices trapped in the stack at once! Fast, efficient, magical.
*Thay vì hăm hở lao lên phía trước từ mỗi chốt, bọn mình chiêu mộ một **Ngăn Xếp Giảm Dần** (`Monotonic Stack`) ôm chặt những phần tử đang mỏi mòn chưa tìm thấy đại ca lớn hơn đứng chắn trước mặt.*
*B1: Bưng nguyên chuỗi liên kết vào lại một Mảng `ArrayList` để lấy quyền tra cứu thần tốc $O(1)$.*
*B2: Quét mảng tử phải qua. Ủa không, cái Hay của ngăn xếp là KHÔNG LƯU giá trị, CÁI NÓ LƯU LÀ INDEX (Chỉ số thứ tự). Chỉ số của những kẻ đang bơ vơ. Nếu Số hiện hành TỪNG BƯỚC một LỚN HƠN cái giá trị đứng ở Index rớt tận trên đỉnh Ngăn xếp, CHÚC MỪNG BẠN! Con đẻ của Index kia LÀ PHÉP LỚN HƠN CHÍNH XÁC XUẤT HIỆN SAU!*
*Lôi Index đó vứt xuống, rập khuôn số lớn đó vô kết quả. Cú huých siêu đẳng nằm ở chỗ một con voi số bự nhảy vào có thể càn quét, giải thoát cho hàng vạn con chuột nhắt đang giam mình trong chóp Stack ngay tắp lự!*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Flatten Linked List:** Traverse `head` and dump all values into an `ArrayList` `values`. 
    *   *Kéo cuộn mảng: Nhào bột đầu `head` đổ ngập dữ liệu thẳng vào Mảng thô `values`.*
2.  **Initialize Result & Stack:** Create `answer[]` matching size of `values` (defaults zero). Instantiate an integer Stack.
    *   *Khởi động Mảng Xuất: Nặn mảng trả về kích cỡ y chang `values` (chứa sẵn số `0`). Dựng cái Cột Stack.*
3.  **Process Elements:** For every `i` from $0$ to `values.size()`:
    *   As long as stack isn't empty AND current value `values[i]` > `values[stack.peek()]`:
        - A champion is found! `int resolvedIndex = stack.pop()`.
        - `answer[resolvedIndex] = values[i]`.
    *   Push current index `i` onto the stack so it eagerly waits for its champion.
    *   *Chiến trận: Vòng mỗi `i`. Miễn là Cột Stack chưa đổ sập VÀ `Số trên mảng > Số trên đỉnh Cột` -> Con Gấu to đã xuất hiện, túm xác đỉnh gỡ ra `int resolvedIndex`. Ấn đáp án bằng `answer[resolvedIndex] = values[i]`. Xong xui đẩy thằng `i` lên cột đứng chịu trận.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // Bước 1: Dàn phẳng mảng liên kết để lấy Index O(1)
        ArrayList<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        
        int n = values.size();
        int[] answer = new int[n];
        // Stack lưu trữ TỌA ĐỘ (Index) của những thằng chưa tìm thấy Đại ca
        Stack<Integer> stack = new Stack<>();
        
        // Bước 2: Vòng xoay định mệnh Monotonic Stack
        for (int i = 0; i < n; i++) {
            // Khi Gấu Bự values.get(i) xuất hiện, rà xem đỉnh tháp có ai nhỏ hơn không
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                int victimIndex = stack.pop(); // Tháo kẻ chịu trận
                answer[victimIndex] = values.get(i); // Lưu gán Gấu Bự làm đáp án cho hắn
            }
            
            // Nếu chưa hoặc đã chét đáp án, tự đưa mình lên Đài treo án chờ Gấu bự hơn mình
            stack.push(i);
        }
        
        // Tất cả Index còn sống dở chết dở sót lại trên đỉnh Stack mặc định ăn answer = 0 
        // Lệnh new int[] n đã set up bằng 0 sẵn nên không cần làm gì thêm!
        
        return answer;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ mathematically tight! While it looks like there's an inner `while` loop within a `for` loop, understand that every single element gets explicitly pushed onto the stack EXACTLY once, and popped EXACTLY once. Re-evaluations are strictly amortized linear operations totaling exactly $2N$ stack actions flat.
    *   **Độ phức tạp thời gian:** $O(N)$ khép kín chặt chẽ! Dù thấy lồng `while` với `for` nhưng bản chất, toàn bộ mạng lưới phần tử chỉ bị xách cổ leo lên Stack ĐÚNG 1 LẦN DƯY NHẤT và bị đá rớt khởi Stack ĐÚNG 1 LẦN. Chia bình quân thì các pha càn quét dư thừa tiêu biến thành 0. Tổng cộng 2$N$ phép toán (Push 1 - Pop 1).*
*   **Space Complexity:** $O(N)$. Holding the flattened array takes up $O(N)$ length. Keeping waiting items in the worst-case monotonic stack (continually decreasing elements `5,4,3,2,1...`) holds maximally $O(N)$ indices. Standard overall.
    *   **Độ phức tạp không gian:** $O(N)$. Chỗ bưng mảng phẳng để lấy vị trí Index xài hết $O(N)$. Lúc chứa những ứng cử viên chờ trong Cột Stack dở dở ương ương, nếu xui rủi dãy đi lùi từ ngọn (gấu bự mất hút), mảng Stack sẽ trĩu nặng tới N mống. Mức trung bình cân bằng hệ thống.*

# Analysis for Sum of Root To Leaf Binary Numbers
# *Phân tích cho bài toán Tổng các Số Nhị phân từ Gốc xuống Lá*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Traverse a Binary Tree from its root down perfectly to each individual leaf explicitly. Along any given singular straight path downwards (like beads on a string), gather all `0` and `1` bits. When finally stepping upon a literal leaf node (signified by both left and right children being `null`), the bits collected in sequence fundamentally represent an unvarnished Binary Number string! Evaluate that specific sequence of bits to calculate its Decimal equivalent mathematically. Process all distinct paths mathematically and aggregate a total sum.
*Cơn ác mộng bẻ lái Cây Nhị Phân: Ta buộc phải trườn dọc theo một Dây Chuyền đi từ Nút Mẹ (Gốc) tút lút đi thẳng tuốt luột xuống từng Tán Lá Nhỏ cách biệt (Nút lá - là cái nút nghèo nàn bị tước mất cành trái nhánh phải). Đang lướt trên đường này, cướp luôn mọi ký tự `0` và `1` mà mình giẫm trúng theo trục dọc. Đến khi mỏi chân đụng Lá vạch đích, đống ký tự bị cuỗm trên đai lưng tạo thành một con số Nhị phân trọn vẹn! Dịch số nhị phân ấy ra hệ thập phân Hệ Số 10. Chốt sổ tất cả các số thu hoạch được trên mọi chặng đường lá. Tính tổng.*

---

## 2. Strategy 1: Naive (String Path Accumulator)
## *2. Chiến lược 1: Ngây thơ (Lưu trữ Chuỗi Dây)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea passes a `String` variable downwards during a Depth-First Search (DFS) or Preorder traversal. Whenever we visit a node, we enthusiastically concatenate `pathString += node.val`. When we logically detect a Leaf (both children naturally `null`), we convert the fully constructed binary string `pathString` string accurately into a base-10 numerical integer using Java's built-in `Integer.parseInt(pathString, 2)`.
*Ý tưởng ngây ngô và dễ dãi nhất là cứ việc quẳng cho mỗi đường đi (DFS) một cái cuộn băng `String`. Đụng vô bất cứ nút nào là mình vứt cái bit đó vào băng (`chuỗi = chuỗi + node.val`). Chạy lúp xúp ngửi thấy mùi cụt đường của Nút Lá (Nút vô sinh không đẻ được con Trái/Con Phải), mình lấy ngay hàm thần thánh của thư viện Java `Integer.parseInt(cái_chuỗi_Kia, 2)` ép xác cái chuỗi Nhị phân thành Số thập phân. Thảy vào hũ Tổng là xong.*

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    int totalSum = 0;
    
    public int sumRootToLeafNaive(TreeNode root) {
        dfs(root, "");
        return totalSum;
    }
    
    private void dfs(TreeNode node, String path) {
        if (node == null) return;
        
        path += node.val;
        
        // Nếu đây là nụ hoa Lá (không có hai nhánh tẻ nào)
        if (node.left == null && node.right == null) {
            totalSum += Integer.parseInt(path, 2);
        } else {
            // Còn nhánh nhánh thì cứ loang chuỗi tiếp
            dfs(node.left, path);
            dfs(node.right, path);
        }
    }
}
```

- **Weakness (Điểm yếu):** String concatenation in tightly nested recursion loops is notorious for catastrophically spamming memory. Every simple `+` operation creates a BRAND NEW cloned `String` object on the heap! Then, calling `parseInt(..., 2)` forcefully executes a heavy parsing validation loop sequence over again! While conceptually sound, algorithmically it scales terribly, acting profoundly slow. Space and Time complexes heavily degrade when a tree gets arbitrarily skewed or heavily branched.
  *Ngây thơ như một bài thơ nhưng thảm khốc về Hiệu suất Bộ Nhớ! Không hiểu nổi cái rác vứt ra từ hành động `path + node.val` nó nhức nhối tới cỡ nào đâu. Cứ đè nhấn `+` là Java lại sản sinh vung vãi rác rưởi tạo thêm một Đối tượng `String` MỚI TOANH ra bãi rác Heap! Gom một bụng rác dài thoằng, rồi cuối chu trình lại gọi cái búa tạ `parseInt()` vô nghĩa đập nát cái chuỗi ấy để tự nó quét lại toán học một lần nữa! Chạy chậm như Rùa Bò, Rác rưởi phình to. Thiếu tinh tế trong khoa học dữ liệu.*

---

## 3. Strategy 2: Optimal (Bitwise Left-Shift Accumulator)
## *3. Chiến lược 2: Tối ưu (Dịch Bit Tích Tụ Sâu)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why construct an arbitrary sequence text "String" only to strictly parse the binary math later when we can do the binary math on-the-fly perfectly instantly?
As we walk vertically deep parsing down a graph, the bit string functionally acts identically to mathematically multiplying the previous accumulated numerical value by $2$ and unconditionally adding the new structural node bit.
Using purely binary Bitwise operators:
`Current_Number = (Previous_Number << 1) | Node.val`
Or simple math:
`Current_Number = (Previous_Number * 2) + Node.val`

We uniquely pass this singular slim integer *literally passed by value internally* down the recursive tree stack. Extremely lightweight! When we precisely hit a structural leaf, we confidently return this accumulated integer explicitly. Backtracking aggregates the recursively returned numerical sums neatly upward seamlessly! Zero strings attached. Pure CPU registers doing lightning-fast boolean algebra.
*Tại cớ sự vất vả chi mà mải mê xâu từng kí tự thành Sợi Giây Text để lúc Tắt còi mới hộc tốc dịch mẻ nó ra Số Học? Mình hoàn toàn dư sức VỪA ĐI VỪA TÍNH NGAY CHỚP NHOÁNG bám sát tốc độ ánh sáng!*
*Lượn lọt thỏm xuống sâu, Bản chất của một chuỗi hệ Nhị Phân khi nạp thêm Bit Mới vào Dấu Chân Bò giống hệt lúc ta nhân Chữ Số Tích Trữ (Accumulator) lên $2$ lần, và tọng thêm cái cục Bit Mới lụm được dính vào đít nó.*
*Rõ ràng 2 tay 2 súng Dịch Bit:*
`Cục_Đỡ_Đạn_Hiện_Tại = (Cục_Đỡ_Cũ << 1) | Node.val` (hoặc Cục_cũ * 2 + Node.val).

*Khoác lên mình độc 1 biến Số Nguyên mảnh dẻ vứt thẳng ẻ xuống Tháp Chồng Đệ Quy `pass by value` (Truyền trị chứ không truyền tham chiếu ảo). Nhẹ Tựa Lông Hồng! Đến đáy tháp - Đụng Nút Lá? Cười mỉm ngạo nghễ ném thẳng cái tổng `Cục_Đỡ_Hiện_Tại` ngon lành cành đào này thối ngược lại chóp trên. Đệ Quy sẽ tự ôm các cục đó ở 2 ngã rẽ cộng vào rổ $O(1)$. Tạm biệt chuỗi, Tạm biệt Parsing. Tông phái Bào phần cứng CPU (Shift bit) chạy rẹt rẹt thần tốc!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // Mở màn, số nguyên tích trữ (accumulator) khởi thủy xuất phát từ 0
        return dfsSum(root, 0);
    }
    
    private int dfsSum(TreeNode node, int localSum) {
        // Nhảy vực ngã cụt (Base case rớt ra ngoài cây)
        if (node == null) return 0;
        
        // Vừa dịch bit sang trái 1 bậc (*2) vừa nhét Bit mới trúng thực bằng Phép (Or |) hoặc Cộng (+)
        localSum = (localSum << 1) | node.val;
        
        // Cú đáp đụng Nút Lá (Tức là Nút này Cụt Rễ Trái và Cáo Chung Rễ Phải)
        if (node.left == null && node.right == null) {
            return localSum; // Trả lại con số Thập Phân Tinh Túy được mài dũa hoàn thiện
        }
        
        // Chưa phải Lá, ngã ba đường sinh đôi, gộp tổng con đường Nhánh Trái cộng đường Nhánh Phải
        return dfsSum(node.left, localSum) + dfsSum(node.right, localSum);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ tight mathematically! To effectively count every single unique path aggregate, the Depth First Search seamlessly touches strictly every discrete existing internal and external structural node identically EXACTLY once. The Bitwise Shift `<< 1` evaluates at exactly $O(1)$ constant limits, resolving almost immediately within CPU core channels.
    *   **Độ phức tạp thời gian:** $O(N)$ thắt chặt không trượt phát nào! Muốn thâu tóm nhặt nhạnh tổng từng sợi tơ trên mạng lá, Đệ quy Bổ Ngầm (DFS) sẽ điểm danh TRỌN VẸN MỖI NÚT CHÍNH XÁC MỘT CHẠM! Trút sạch thao tác, Phép Dịch chuyển Bit `<< 1` là trò mèo $O(1)$ vớ vẩn đối với CPU hệ nhị phân, bay vụt nhanh hơn chớp mắt.*
*   **Space Complexity:** $O(H)$ loosely where $H$ indicates strictly the height of the Binary Tree (which scales from logarithmic $O(\log N)$ perfectly balanced, up to structural limit $O(N)$ skewed pathological arrays tree lists). Represents implicitly exactly the invisible memory call stack boundary frames depth limits dynamically allocated by the Java framework itself per recursive scope drill-down context!
    *   **Độ phức tạp không gian:** $O(H)$ dập dềnh tương đối với độ thả dây thòng lọng $H$ là Chiều Cao Của Tháp Cây! (Có thể ngoan ngoãn thu nhỏ đẹm khít $O(\log N)$ nếu Cây Tỏa Đều, Hoặc tha hóa biến tướng dãn dài loằng ngoằng rớt thảm tít tắp $O(N)$ nếu Cây chọc lủng ruột như 1 đường tăm xỉa răng Lệch Xéo Trái/Phải Toàn Diện). Bộ nhớ ảo ở đây KHÔNG LƯU MẢNG NÀO SẤT! Nó hoàn toàn đến từ Trụ Chống lưng Đệ Quy Recursion Stack gồng trên vai của bộ máy biên dịch Java (JVM) để nhét ngữ cảnh! Rất rẻ.*

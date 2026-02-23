# Analysis for Binary Tree Maximum Path Sum
# *Phân tích cho bài toán Tổng Đường Đi Tối Đa Trên Cây Nhị Phân*

## 1. Problem Understanding & Core Dilemma
## *1. Hiểu đề & Tình huống khó khăn cốt lõi*

### Defining a "Path"
### *Định nghĩa một "Đường đi"*
*   A path is a continuous sequence of nodes connected by edges.
    *Một đường đi là một chuỗi liên tục các nút được nối với nhau bằng các cạnh.*
*   Unlike many tree problems that ask for paths from root-to-leaf, this problem allows paths to start and end **anywhere**.
    *Không giống như nhiều bài toán về cây yêu cầu đường đi từ gốc đến lá, bài toán này cho phép đường đi bắt đầu và kết thúc ở **bất cứ đâu**.*
*   A path can "arch" through a node (e.g., LeftChild -> Parent -> RightChild), but once it arches, it cannot go back up to the Parent's own parent, because that would require visiting the Parent node twice, which is prohibited.
    *Một đường đi có thể "uốn vòm" qua một nút (ví dụ: ConTrái -> Cha -> ConPhải), nhưng một khi đã uốn vòm, nó không thể quay ngược lên cha của nút Cha đó, vì điều đó sẽ yêu cầu truy cập nút Cha hai lần, điều này bị cấm.*

### The Decision at Each Node
### *Quyết định tại mỗi nút*
At any node `X`, we have two separate interests:
*Tại bất kỳ nút `X` nào, chúng ta có hai mối quan tâm riêng biệt:*
1.  **Local Maximum Path:** The path that uses `X` as the highest point (Left subtree gain + X + Right subtree gain). This arch might be the global answer.
    *Đường đi tối đa cục bộ: Đường đi sử dụng `X` làm điểm cao nhất (Lợi nhuận cây con trái + X + Lợi nhuận cây con phải). Vòm này có thể là câu trả lời toàn cục.*
2.  **Returnable Gain:** The maximum contribution `X` can provide to its parent. This can only take **one** side (X + max(Left gain, Right gain)).
    *Lợi nhuận có thể trả về: Đóng góp tối đa mà `X` có thể cung cấp cho cha của nó. Điều này chỉ có thể lấy **một** phía (X + max(Lợi nhuận trái, Lợi nhuận phải)).*

---

## 2. Approach: Recursive DFS (Post-order Traversal)
## *2. Hướng tiếp cận: DFS Đệ quy (Duyệt theo thứ tự sau)*

### Logic
### *Logic*
1.  We use a global variable `maxSum` to keep track of the highest path sum found so far.
    *Chúng ta sử dụng một biến toàn cục `maxSum` để theo dõi tổng đường đi cao nhất được tìm thấy cho đến nay.*
2.  We implement a recursive function `maxGain(node)`:
    -   Base Case: If `node == null`, return 0.
    -   Recursively calculate `leftGain` and `rightGain`.
    -   **CRITICAL:** If a gain is negative, we treat it as 0 (ignoring that branch completely).
    -   Current "arch" sum = `node.val + leftGain + rightGain`.
    -   Update `maxSum = max(maxSum, currentArchSum)`.
    -   Return to parent: `node.val + max(leftGain, rightGain)`.

### Why ignore negative gains?
### *Tại sao bỏ qua lợi nhuận âm?*
If the maximum sum reachable through a certain subtree is negative, adding it to our current path will only decrease the total. Thus, it is always better to "cut" that branch off (treat gain as 0).
*Nếu tổng tối đa có thể đạt được thông qua một cây con nhất định là số âm, việc thêm nó vào con đường hiện tại sẽ chỉ làm giảm tổng số. Do đó, tốt hơn hết là luôn "cắt" nhánh đó đi (coi lợi nhuận là 0).*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We visit each node in the tree exactly once during the post-order traversal. Each visit involves constant-time calculations.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta truy cập mỗi nút trong cây đúng một lần trong quá trình duyệt theo thứ tự sau. Mỗi lần truy cập bao gồm các phép tính thời gian hằng số.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This space is used by the recursion stack. In the worst case (skewed tree), this is $O(N)$. In the average/balanced case, it is $O(\log N)$.
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây. Không gian này được sử dụng bởi ngăn xếp đệ quy. Trong trường hợp xấu nhất (cây bị lệch), đây là $O(N)$. Trong trường hợp trung bình/cân bằng, nó là $O(\log N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Input:** `[-10, 9, 20, null, null, 15, 7]`

1.  `maxGain(9)` -> Returns 9. `maxSum` updated to 9.
2.  `maxGain(15)` -> Returns 15. `maxSum` updated to 15.
3.  `maxGain(7)` -> Returns 7. `maxSum` remains 15.
4.  `maxGain(20)`:
    -   `leftGain = 15`, `rightGain = 7`.
    -   `ArchSum = 20 + 15 + 7 = 42`.
    -   `maxSum` updated to 42.
    -   Return `20 + max(15, 7) = 35`.
5.  `maxGain(-10)`:
    -   `leftGain = 9`, `rightGain = 35`.
    -   `ArchSum = -10 + 9 + 35 = 34`.
    -   `maxSum` remains 42.

**Final Result:** 42

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This problem elegantly combines tree traversal with the "maximum subarray sum" (Kadane's) logic. The key insight is separating the value **returned** to the parent from the value **tracked** globally. Mastering this pattern is essential for many "Hard" level binary tree problems.
*Bài toán này kết hợp một cách thanh lịch giữa duyệt cây với logic "tổng mảng con tối đa" (thuật toán Kadane). Điểm mấu chốt là tách biệt giá trị **được trả về** cho cha khỏi giá trị **được theo dõi** toàn cục. Nắm vững mô hình này là điều cần thiết cho nhiều bài toán cây nhị phân cấp độ "Khó".*
---
*Đôi khi con đường tốt nhất không bắt đầu từ gốc, nhưng mọi con đường đều cần một nền móng vững chắc từ bên dưới.*
Sometimes the best path doesn't start from the root, but every path needs a solid foundation from below.

# Analysis for Word Ladder
# *Phân tích cho bài toán Tìm Thang Từ*

## 1. Mathematical Modeling
## *1. Mô Hình Hóa Toán Học*

### Graph Transformation
### *Biến Đổi Đồ Thị*
*   The problem can be perfectly modeled as finding the shortest path in an unweighted graph where:
    *Bài toán có thể được mô hình hóa hoàn hảo dưới dạng tìm đường đi ngắn nhất trong một đồ thị không trọng số, trong đó:*
    -   **Nodes:** Each word in `wordList` plus `beginWord`.
        *Nút: Mỗi từ trong `wordList` cộng với `beginWord`.*
    -   **Edges:** An edge exists between any two words that differ by exactly one character.
        *Cạnh: Một cạnh tồn tại giữa bất kỳ hai từ nào khác nhau đúng một chữ cái.*
*   Since all edges have equal weight (1 step), Breadth-First Search (BFS) is the optimal algorithm to find the shortest path.
    *Vì tất cả các cạnh có trọng số bằng nhau (1 bước), Tìm kiếm theo chiều rộng (BFS) là thuật toán tối ưu để tìm đường đi ngắn nhất.*

---

## 2. Approach 1: Simple BFS
## *2. Hướng Tiếp Cận 1: BFS Đơn Giản*

### Logic
### *Logic*
1.  Initialize a `Queue` with `beginWord`.
2.  Maintain a `Set` for unvisited words (initialized with `wordList`).
3.  For each word, try changing each of its $L$ characters to all 26 possible English letters.
4.  If a resulting word is in the unvisited set:
    -   Add it to the queue.
    -   Remove it from the unvisited set (to prevent cycles and re-processing).
5.  Keep track of the "level" or "distance" from the start.

### Complexity
### *Độ Phức Tạp*
*   **Time Complexity:** $O(N \cdot L \cdot 26)$. For each word ($N$), we iterate through each of its length ($L$) and try 26 characters.
*   **Space Complexity:** $O(N \cdot L)$.

---

## 3. Approach 2: Bidirectional BFS (Optimal)
## *3. Hướng Tiếp Cận 2: BFS Hai Chiều (Tối Ưu)*

### Logic
### *Logic*
In a standard BFS, the search area grows exponentially like a circle $A = \pi \cdot R^2$. By starting the search from both the `beginWord` and the `endWord` simultaneously, we can significantly reduce the total number of nodes visited.
*Trong một phép duyệt BFS tiêu chuẩn, vùng tìm kiếm tăng theo hàm mũ giống như một hình tròn $A = \pi \cdot R^2$. Bằng cách bắt đầu tìm kiếm từ cả `beginWord` và `endWord` đồng thời, chúng ta có thể giảm đáng kể tổng số nút được truy cập.*

Two search fronts will meet in the middle. The total area covered would be $2 \cdot \pi \cdot (R/2)^2 = \frac{1}{2} \cdot \pi \cdot R^2$, which is half the search area of a unidirectional BFS.
*Hai mặt trận tìm kiếm sẽ gặp nhau ở giữa. Tổng diện tích được bao phủ sẽ là $2 \cdot \pi \cdot (R/2)^2 = \frac{1}{2} \cdot \pi \cdot R^2$, bằng một nửa vùng tìm kiếm của BFS một chiều.*

---

## 4. Implementation Nuances
## *4. Sắc Thái Triển Khai*

*   **Fast Lookups:** Always use a `HashSet` for word lookups. $O(1)$ lookup time is crucial when we are doing $L \cdot 26$ checks per word.
    *Tra Cứu Nhanh: Luôn sử dụng `HashSet` để tra cứu từ. Thời gian tra cứu $O(1)$ là cực kỳ quan trọng khi chúng ta đang thực hiện $L \cdot 26$ lần kiểm tra cho mỗi từ.*
*   **Level Management:** In BFS, we can either use a `null` delimiter or use a `size` loop (`int size = q.size()`) to differentiate between levels.
    *Quản Lý Tầng: Trong BFS, chúng ta có thể sử dụng dấu phân cách `null` hoặc sử dụng vòng lặp `size` (`int size = q.size()`) để phân biệt giữa các tầng.*

---

## 5. Complexity Summary
## *5. Tóm Tắt Độ Phức Tạp*

*   **Time Complexity:** $O(M^2 \times N)$, where $M$ is the length of words and $N$ is the total number of words in `wordList`. (More precisely $O(N \cdot M \cdot 26)$).
    *Độ phức tạp thời gian: $O(M^2 \times N)$, trong đó $M$ là độ dài của từ và $N$ là tổng số từ trong `wordList`. (Chính xác hơn là $O(N \cdot M \cdot 26)$).*
*   **Space Complexity:** $O(M \times N)$, to store the word list and the BFS queue.
    *Độ phức tạp không gian: $O(M \times N)$, để lưu trữ danh sách từ và hàng đợi BFS.*

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bidirectional BFS is much faster in practice for Word Ladder problems on large datasets. It is a highly respected optimization in interviews. Even the regular BFS is efficient enough for this problem, but understanding the "search space reduction" is what distinguishes a top-tier engineer.
*BFS hai chiều nhanh hơn nhiều trong thực tế đối với các bài toán Tìm Thang Từ trên các tập dữ liệu lớn. Đây là một sự tối ưu hóa rất được tôn trọng trong phỏng vấn. Ngay cả BFS thông thường cũng đủ hiệu quả cho bài toán này, nhưng hiểu được việc "giảm không gian tìm kiếm" là điều phân biệt một kỹ sư hàng đầu.*
---
*Đôi khi gặp nhau ở giữa là cách nhanh nhất để nối liền hai thế giới khác biệt.*
Sometimes meeting in the middle is the fastest way to connect two different worlds.

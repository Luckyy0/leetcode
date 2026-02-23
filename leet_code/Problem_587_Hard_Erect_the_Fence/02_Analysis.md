# Analysis for Erect the Fence
# *Phân tích cho bài toán Dựng Hàng rào*

## 1. Problem Essence & The Geometry of Enclosure
## *1. Bản chất vấn đề & Hình học của sự Bao vây*

### The Challenge
### *Thách thức*
Given a set of points (trees), we need to find the smallest convex polygon that encloses all points. This is the classic **Convex Hull** problem.
*Cho một tập hợp các điểm (cây), chúng ta cần tìm đa giác lồi nhỏ nhất bao quanh tất cả các điểm. Đây là bài toán **Vỏ lồi** (Convex Hull) kinh điển.*

Special Requirement: Unlike some Convex Hull algorithms that only return vertices, we must return **all points** that lie on the perimeter, including those on straight edges between vertices.
*Yêu cầu đặc biệt: Không giống như một số thuật toán Vỏ lồi chỉ trả về các đỉnh, chúng ta phải trả về **tất cả các điểm** nằm trên chu vi, bao gồm cả những điểm nằm trên các cạnh thẳng giữa các đỉnh.*

---

## 2. Strategy: Monotone Chain Algorithm (Andrew's Algorithm)
## *2. Chiến lược: Thuật toán Chuỗi Đơn điệu (Thuật toán Andrew)*

The Monotone Chain algorithm is efficient $O(N \log N)$ and stable. It constructs the hull in two parts: the Lower Hull and the Upper Hull.
*Thuật toán Chuỗi đơn điệu có hiệu quả $O(N \log N)$ và ổn định. Nó xây dựng vỏ theo hai phần: Vỏ dưới và Vỏ trên.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Sorting:** Sort the points primarily by x-coordinate, and secondarily by y-coordinate.
    * **Sắp xếp:** Sắp xếp các điểm chủ yếu theo tọa độ x, và thứ yếu theo tọa độ y.*

2.  **Cross Product Helper:** Define a function `crossProduct(a, b, c)` to determine the turn direction of three points.
    * **Hàm bổ trợ Tích có hướng:** Định nghĩa một hàm `crossProduct(a, b, c)` để xác định hướng rẽ của ba điểm.*
    - A positive value indicates a left turn, negative a right turn, and zero means they are collinear (straight).
    - *Giá trị dương chỉ hướng rẽ trái, âm chỉ hướng rẽ phải, và số không nghĩa là chúng đồng hàng (thẳng).*

3.  **Build Lower Hull:** Iterate through sorted points and maintain a stack. 
    * **Xây dựng Vỏ dưới:** Duyệt qua các điểm đã sắp xếp và duy trì một ngăn xếp.*
    - For each point, while the stack has $\ge 2$ points and the turn to the current point is a "right turn" (cross product < 0), pop the stack.
    - *Đối với mỗi điểm, trong khi ngăn xếp có $\ge 2$ điểm và hướng rẽ đến điểm hiện tại là "rẽ phải" (tích có hướng < 0), hãy lấy điểm ra khỏi ngăn xếp.*

4.  **Build Upper Hull:** Iterate through sorted points in reverse and repeat the logic.
    * **Xây dựng Vỏ trên:** Duyệt qua các điểm đã sắp xếp theo thứ tự ngược lại và lặp lại logic.*

5.  **Handling Collinear Points:** Since we need all points on the fence, we use `<= 0` in our cross-product check carefully to keep collinear points.
    * **Xử lý các điểm đồng hàng:** Vì chúng ta cần tất cả các điểm trên hàng rào, chúng ta sử dụng `<= 0` trong việc kiểm tra tích có hướng một cách cẩn thận để giữ lại các điểm đồng hàng.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Robustness:** The Monotone Chain algorithm naturally handles duplicate points and vertical lines well.
    * **Tính mạnh mẽ:** Thuật toán Chuỗi đơn điệu xử lý tốt các điểm trùng lặp và các đường thẳng đứng một cách tự nhiên.*
*   **Completeness:** By using a `Set` to store the final points from both Lower and Upper hulls, we avoid duplicate entries for the endpoints.
    * **Tính đầy đủ:** Bằng cách sử dụng một `Set` để lưu trữ các điểm cuối cùng từ cả vỏ dưới và vỏ trên, chúng ta tránh được các mục nhập trùng lặp cho các điểm mút.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to the initial sorting. The construction of the hull itself is $O(N)$ as each point is pushed and popped at most once.
    * **Độ phức tạp thời gian:** $O(N \log N)$ do bước sắp xếp ban đầu. Việc xây dựng vỏ tốn $O(N)$ vì mỗi điểm được đẩy vào và lấy ra tối đa một lần.*
*   **Space Complexity:** $O(N)$ to store the sorted list and the result set.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ danh sách đã sắp xếp và tập hợp kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Points:** A, B, C, D (Sorted left to right)
- Start Lower Hull: [A] -> [A, B] -> [A, B, C].
- If turn A->B->C is right, B is "inside" the fence. Remove B. Hull becomes [A, C].
- Continue until all points are processed for both top and bottom.
- The boundary points remaining in the stack form the fence.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For Convex Hull problems, Monotone Chain is often preferred over Graham Scan due to its simplicity in handling collinear points and sorting requirements.
*Đối với các bài toán Vỏ lồi, Chuỗi đơn điệu thường được ưu tiên hơn Quét Graham nhờ sự đơn giản trong việc xử lý các điểm đồng hàng và các yêu cầu sắp xếp.*
---
*Hàng rào (Fence) là sự ranh giới bảo vệ những gì quý giá bên trong. Để tìm ra một chu vi tối ưu nhất, ta phải dũng cảm loại bỏ những yếu tố nằm sâu trong vùng an toàn (Interior points) và chỉ giữ lại những điểm tựa vững chãi nhất trên đường biên (Boundary). Sự tinh giản (Convexity) chính là hình thái mạnh mẽ nhất của sự bao bọc.*
A fence (Fence) is the protective boundary of what is precious inside. To find an optimal perimeter, one must bravely remove the elements lying deep in the safe zone (Interior points) and only keep the strongest foundations on the border (Boundary). Simplicity (Convexity) is the strongest form of enclosure.

# Analysis for Design Twitter
# *Phân tích cho bài toán Thiết kế Twitter*

## 1. Problem Essence & Multi-source Merging
## *1. Bản chất vấn đề & Hợp nhất Đa nguồn*

### The Challenge
### *Thách thức*
Managing relationships (follow/unfollow) and content (tweets) while efficiently generating a merged feed of the 10 most recent posts.

### Strategy: OOP + Priority Queue
### *Chiến lược: OOP + Hàng đợi Ưu tiên*
1.  **Data Models:**
    - `Tweet`: Contains `tweetId` and a global `timestamp`.
    - `User`: Contains a set of `followees` and a linked list of `tweets`.
2.  **Core Operations:**
    - `postTweet`: Simply add a `Tweet` object to the head of the user's list ($O(1)$).
    - `follow/unfollow`: Update the `HashSet` of followees ($O(1)$).
    - `getNewsFeed`: The core problem.
        - Iterate through all followees (including the user).
        - Use a **Priority Queue** (Max-Heap) to merge the sorted tweet lists (since each list is already sorted by time).
        - This is the "Merge K Sorted Lists" pattern, limited to 10 elements.

---

## 2. Approach: Linked List + Max-Heap
## *2. Hướng tiếp cận: Danh sách liên kết + Max-Heap*

### Logic
### *Logic*
(See Core Operations above). The use of a linked list (or equivalent) for tweets ensures that the most recent are processed first.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Scalable Merge:** Merging K lists is $O(K \log K)$ per element extracted. For 10 elements, it's $O(K)$.
    *Hợp nhất có thể mở rộng: Hợp nhất K danh sách cực kỳ hiệu quả cho 10 phần tử.*
*   **Lazy Fed:** News feed is generated on-demand.
    *Bảng tin lười: Bảng tin chỉ được tạo khi có yêu cầu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `postTweet`, `follow`, `unfollow`: $O(1)$.
    - `getNewsFeed`: $O(K + 10 \log K)$ where $K$ is number of followees.
    *Độ phức tạp thời gian: O(1) cho hầu hết các hàm, O(K) cho news feed.*
*   **Space Complexity:** $O(N + T)$ where $N$ is users and $T$ is total tweets.
    *Độ phức tạp không gian: $O(N + T)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operation:** `getNewsFeed(1)`
1. User 1 follows: [2, 3].
2. Lists:
   - User 1: [T10, T5]
   - User 2: [T12, T8]
   - User 3: [T11, T6]
3. Max-Heap init: [T10, T12, T11].
4. Extracted: T12. Add T8 to heap.
5. Extracted: T11. Add T6 to heap.
... continue until 10 or all lists empty.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

PriorityQueue for merging is the most robust approach.
*Sử dụng PriorityQueue để hợp nhất là cách tiếp cận mạnh mẽ nhất.*
---
*Twitter dạy chúng ta rằng trong một biển thông tin khổng lồ (total tweets), chỉ những gì mới mẻ (recent 10) và có liên kết (followees) mới thực sự mang lại giá trị cho trải nghiệm của mỗi cá nhân.*
Twitter teaches us that in a vast sea of information (total tweets), only what is fresh (recent 10) and connected (followees) truly brings value to each individual's experience.

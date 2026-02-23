# Analysis for Split Array into Consecutive Subsequences
# *Phân tích cho bài toán Chia mảng thành các Dãy con Liên tiếp*

## 1. Problem Essence & Greedy Distribution
## *1. Bản chất vấn đề & Phân phối Tham lam*

### The Challenge
### *Thách thức*
We need to group all numbers into consecutive sequences of length $\ge 3$. Since the array is sorted, we can process numbers incrementally and decide where each goes.
*Chúng ta cần nhóm tất cả các số thành các dãy liên tiếp có độ dài $\ge 3$. Vì mảng đã sắp xếp, chúng ta có thể xử lý các số theo thứ tự tăng dần và quyết định mỗi số sẽ đi về đâu.*

The core tension is: when we see a number `x`, should it extend an existing sequence or start a new one?
*Mâu thuẫn cốt lõi là: khi thấy số `x`, nó nên kéo dài một dãy hiện có hay bắt đầu một dãy mới?*

---

## 2. Strategy: Greedy with Frequency and Needs Maps
## *2. Chiến lược: Tham lam với Bản đồ Tần suất và Nhu cầu*

We use two maps to track the state:
- `freq`: Count of each number currently available.
- `needs`: `needs[x]` is the number of active sequences ending at `x-1` that are waiting for `x`.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Frequencies:** Fill the `freq` map first.
    * **Đếm Tần suất:** Điền vào bản đồ `freq` trước.*

2.  **Greedy Decisions:** For each number `x` in the array:
    * **Quyết định Tham lam:** Đối với mỗi số `x`:*
    - If `freq[x] == 0`, skip (it was already consumed).
    - **Step 2.1 (Priority - Extend):** If any existing sequence needs `x` (`needs[x] > 0`):
        - Use `x`. Decrement `freq[x]`. 
        - The sequence now ends at `x`, so it needs `x+1`. Decrement `needs[x]`, increment `needs[x+1]`.
    - **Step 2.2 (Fallback - Start New):** If we can't extend, try starting a new sequence: `x, x+1, x+2`.
        - Check if `freq[x+1]` and `freq[x+2]` are both $> 0$.
        - If yes: Use all three. Decrement `freq[x], freq[x+1], freq[x+2]`.
        - The sequence now needs `x+3`. Increment `needs[x+3]`.
    - **Step 2.3 (Failure):** If neither works, it's impossible. Return `false`.

3.  **Result:** If all numbers are processed, return `true`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Greedy Choice:** Extending an existing sequence is always equal to or better than starting a new one. Why? Because starting a new one "sacrifices" two more numbers (`x+1`, `x+2`) to meet the length-3 requirement.
    * **Lựa chọn Tham lam:** Việc kéo dài một dãy hiện có luôn tốt hơn hoặc bằng việc bắt đầu một dãy mới. Vì việc bắt đầu dãy mới sẽ "hy sinh" thêm hai số để đáp ứng yêu cầu độ dài 3.*
*   **Efficiency:** $O(N)$ with HashMap lookups (or $O(N)$ with an array if values are small).
    * **Hiệu suất:** $O(N)$ với tra cứu HashMap.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the array twice (once for frequency, once for greedy).
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store frequencies and needs in maps.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 2, 3, 3, 4, 5]
1. x=1: freq[1]>0. Can't extend. Start new [1,2,3]. freq[1,2,3]--. needs[4]=1.
2. x=2, 3: freq is 0, skip.
3. x=3: freq[3]>0. Can't extend (needs[3]=0). Start new [3,4,5]. freq[3,4,5]--. needs[6]=1.
4. Finished successfully!
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "partitioning" problems with local constraints (like consecutive numbers), Greedy is often faster than DP. The key is identifying the correct priority: usually, "maintaining the status quo" (extending) should come before "creating something new".
*Đối với các bài toán "phân hoạch", Tham lam thường nhanh hơn DP. Chìa khóa là xác định mức độ ưu tiên: "duy trì trạng thái hiện tại" nên đứng trước "tạo ra cái mới".*
---
*Sự phân chia (Split) hiệu quả đòi hỏi sự bổ khuyết (Needs). Trong dòng chảy của các dãy số, mỗi phần tử `x` có thể là sự cứu rỗi cho một dãy đang chờ đợi (needs), hoặc là hạt giống cho một hành trình mới (Start new). Dữ liệu dạy ta rằng bằng cách ưu tiên những gì đang dang dở (Priority - Extend), ta có thể tận dụng tối đa tài nguyên và tạo nên một hệ thống bền vững.*
Effective partitioning (Split) requires compensation (Needs). In the flow of number sequences, each element `x` can be a savior for a waiting sequence (needs), or a seed for a new journey (Start new). Data teaches us that by prioritizing what is unfinished (Priority - Extend), we can maximize resources and create a sustainable system.

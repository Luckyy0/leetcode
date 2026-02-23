# Analysis for Permutation in String
# *Phân tích cho bài toán Hoán vị trong Chuỗi*

## 1. Problem Essence & The Signature of Permutations
## *1. Bản chất vấn đề & Chữ ký của các Hoán vị*

### The Challenge
### *Thách thức*
We need to find if string `s2` contains a substring that is a permutation of `s1`.
*Chúng ta cần tìm xem chuỗi `s2` có chứa một chuỗi con là một hoán vị của `s1` hay không.*

A permutation is defined simply by character frequency. Two strings are permutations of each other if they have the same length and the same counts for every letter of the alphabet.
*Một hoán vị được định nghĩa đơn giản bởi tần suất ký tự. Hai chuỗi là hoán vị của nhau nếu chúng có cùng độ dài và cùng số lượng cho mỗi chữ cái trong bảng chữ cái.*

---

## 2. Strategy: Sliding Window with Frequency Counters
## *2. Chiến lược: Cửa sổ trượt với Bộ đếm Tần suất*

Since we are looking for a substring of a fixed length (`s1.length()`), we can use a "sliding window" that moves through `s2`.
*Vì chúng ta đang tìm kiếm một chuỗi con có độ dài cố định (`s1.length()`), chúng ta có thể sử dụng một "cửa sổ trượt" di chuyển qua `s2`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Preprocessing:** Use an integer array of size 26 (`counts`) to store the character balance between the window and `s1`.
    * **Tiền xử lý:** Sử dụng một mảng số nguyên kích thước 26 (`counts`) để lưu trữ sự cân bằng ký tự giữa cửa sổ và `s1`.*
    - Subtract 1 for each character in `s1`.
    - *Trừ đi 1 cho mỗi ký tự trong `s1`.*
    - Add 1 for each character in the initial window of `s2` (length `n1`).
    - *Cộng thêm 1 cho mỗi ký tự trong cửa sổ ban đầu của `s2` (độ dài `n1`).*

2.  **Initial Check:** If the `counts` array is all zeros, it means the character frequencies match exactly. Return `true`.
    * **Kiểm tra ban đầu:** Nếu mảng `counts` toàn bộ là số không, điều đó có nghĩa là các tần suất ký tự khớp chính xác. Trả về `true`.*

3.  **Sliding:** Move the window one character at a time.
    * **Trượt:** Di chuyển cửa sổ mỗi lần một ký tự.*
    - **Add** the incoming character (at the right edge) to the counter.
    - * **Thêm** ký tự đi vào (tại mép phải) vào bộ đếm.*
    - **Subtract** the outgoing character (at the left edge) from the counter.
    - * **Trừ** ký tự đi ra (tại mép trái) khỏi bộ đếm.*
    - After each slide, check if the `counts` array is all zeros.
    - *Sau mỗi lần trượt, hãy kiểm tra xem mảng `counts` có toàn bộ là số không hay không.*

4.  **Optimization (Matches Count):** Instead of checking the array of 26 zeros every time, you can maintain a single `matches` variable representing how many characters out of 26 are currently at zero.
    * **Tối ưu hóa (Số lượng trùng khớp):** Thay vì kiểm tra mảng 26 số không mỗi lần, bạn có thể duy trì một biến `matches` duy nhất đại diện cho việc có bao nhiêu ký tự trong số 26 hiện đang ở mức không.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Fixed Space:** Regardless of the string lengths, we only ever use an array of size 26.
    * **Không gian cố định:** Bất kể độ dài chuỗi là bao nhiêu, chúng ta chỉ luôn sử dụng một mảng kích thước 26.*
*   **Linear Time:** Each character in `s2` is touched once when entering the window and once when leaving.
    * **Thời gian tuyến tính:** Mỗi ký tự trong `s2` được chạm vào một lần khi vào cửa sổ và một lần khi rời đi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L_1 + L_2)$. $L_1$ to initialize the counts, and $L_2$ to slide the window across `s2`.
    * **Độ phức tạp thời gian:** $O(L_1 + L_2)$. $L_1$ để khởi tạo các bộ đếm, và $L_2$ để trượt cửa sổ qua `s2`.*
*   **Space Complexity:** $O(1)$. We always use a constant size of 26 to store character counts.
    * **Độ phức tạp không gian:** $O(1)$. Chúng ta luôn sử dụng một kích thước hằng số 26 để lưu trữ số lượng ký tự.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `s1 = "ab", s2 = "eidbaooo"`
1. `s1` counts: `a:-1, b:-1`.
2. Initial window "ei": `a:-1, b:-1, e:1, i:1`. No match.
3. Slide window to "id": `e:0, i:1, d:1, a:-1, b:-1`.
4. Slide window to "db": `i:0, d:1, b:0, a:-1`.
5. Slide window to "ba": `d:0, b:0, a:0`. **Success!**
6. All counts are zero. Return `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sliding window with frequency counters is the most efficient pattern for problems involving permutations or anagrams in substrings.
*Cửa sổ trượt với bộ đếm tần suất là mô hình hiệu quả nhất cho các bài toán liên quan đến hoán vị hoặc đảo chữ trong các chuỗi con.*
---
*Mọi sự hoán đổi (Permutation) chỉ là sự thay đổi về trật tự, không phải về bản chất. Khi ta giữ vững tần suất (Frequency) các yếu tố cốt lõi, dù chúng xuất hiện ở đâu trong một chuỗi sự kiện (s2), ta vẫn có thể nhận ra dấu ấn nguyên bản (s1).*
Every swap (Permutation) is just a change in order, not in nature. When we maintain the frequency (Frequency) of core elements, no matter where they appear in a sequence of events (s2), we can still recognize the original signature (s1).

# Analysis for Bold Words in String
# *Phân tích cho bài toán Từ In đậm trong Chuỗi*

## 1. Problem Essence & Boolean Masking
## *1. Bản chất vấn đề & Mặt nạ Bool*

### The Challenge
### *Thách thức*
We need to merge overlapping intervals of "bold" characters. Since the string length is small ($N \le 500$), we can simply mark each character as "bold" or "not bold" using a boolean array.
*Chúng ta cần gộp các khoảng chồng lấp của các ký tự "in đậm". Vì độ dài chuỗi nhỏ, ta có thể đánh dấu từng ký tự là "in đậm" hoặc không bằng một mảng boolean.*

---

## 2. Strategy: Boolean Mask & Construction
## *2. Chiến lược: Mặt nạ Bool & Xây dựng Chuỗi*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Marking:**
    - Create `boolean[] isBold` of size `N`.
    - Retrieve all occurrences of each word in `s`.
    - For each occurrence starting at `i` with length `len`, set `isBold[k] = true` for `k` in `[i, i + len - 1]`.
    *   **Đánh dấu:** Tạo mảng boolean. Tìm tất cả lần xuất hiện của từ khóa và đánh dấu `true` cho các vị trí tương ứng.*

2.  **String Construction:**
    - Iterate through `s` from `0` to `N-1`.
    - If `isBold[i]` is true and (i=0 or `isBold[i-1]` is false), append `<b>`.
    - Append `s.charAt(i)`.
    - If `isBold[i]` is true and (i=N-1 or `isBold[i+1]` is false), append `</b>`.
    *   **Xây dựng Chuỗi:** Duyệt qua chuỗi. Nếu bắt đầu vùng đậm, thêm thẻ mở. Thêm ký tự. Nếu kết thúc vùng đậm, thêm thẻ đóng.*

3.  **Optimization:**
    - Finding occurrences: Since constraints are small, `s.indexOf(word, start)` works fine. Or naive nested loop.
    *   **Tối ưu:** Dùng `indexOf` hoặc vòng lặp lồng nhau.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(W \cdot N \cdot L)$, where $W$ is number of words, $N$ is string length, $L$ is word length. With given constraints ($50 \times 500 \times 10$), this is $\approx 250,000$ ops, very fast.
    *   **Độ phức tạp thời gian:** $O(W \cdot N \cdot L)$.*
*   **Space Complexity:** $O(N)$ for the boolean array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**s="aabcd", words=["ab", "bc"]**
1. "ab" at index 1. Mark `isBold[1], isBold[2]` -> T.
2. "bc" at index 2. Mark `isBold[2], isBold[3]` -> T.
3. isBold: `[F, T, T, T, F]`.
4. Build:
   - i=0 (F): "a"
   - i=1 (T, prev F): "a<b>a"
   - i=2 (T): "a<b>ab"
   - i=3 (T, next F): "a<b>abc</b>"
   - i=4 (F): "a<b>abc</b>d"
**Result:** "a<b>abc</b>d".

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple masking is cleaner than managing a list of Interval objects because we don't need to handle sorting/merging logic explicitly; the array does it implicitly.
*Phương pháp mặt nạ đơn giản hơn việc quản lý danh sách các khoảng vì ta không cần xử lý logic sắp xếp/gộp một cách tường minh; mảng đã làm điều đó ngầm định.*
---
*Những điểm nhấn (Bold words) trong văn bản cần được làm nổi bật một cách liền mạch. Thay vì chắp vá từng mảnh nhỏ (Individual tags), ta tô đậm cả một vùng liên tục (Merged intervals). Dữ liệu dạy ta rằng bằng cách sử dụng một tấm bản đồ trạng thái đơn giản (Boolean mask), ta có thể hợp nhất sự phức tạp của những sự kiện chồng lấp thành một trải nghiệm mượt mà.*
Highlights (Bold words) in text need to be emphasized seamlessly. Instead of patching together small pieces (Individual tags), we bold entire continuous regions (Merged intervals). Data teaches us that by using a simple state map (Boolean mask), we can unify the complexity of overlapping events into a smooth experience.

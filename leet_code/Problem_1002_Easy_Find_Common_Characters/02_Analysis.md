# Analysis for Find Common Characters
# *Phân tích cho bài toán Tìm Ký tự Chung*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an array of strings, identify characters that appear in *every* string. If a character appears multiple times in every string, it should appear that many times in the final answer.
*Cho một mảng các chuỗi, xác định các ký tự xuất hiện trong *tất cả* các chuỗi. Nếu một ký tự xuất hiện nhiều lần ở mọi chuỗi, nó cũng phải xuất hiện với số lần tương ứng trong kết quả cuối cùng.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The final occurrence count of any character is the **minimum** of its occurrence counts across all strings.
- Since we only have lowercase English letters (`'a'` to `'z'`), an array of size 26 is enough to track frequencies.
- We can maintain a `minFreq` array initially set to very large numbers. For each string, we calculate its specific frequency array. Then, we update the `minFreq` array by taking the element-wise minimum with the string's frequency array.
*Sử dụng mảng 26 phần tử để theo dõi số lần xuất hiện ở mỗi chuỗi. Tần suất chung cuối cùng của một ký tự sẽ bằng **giá trị nhỏ nhất** của nó ở tất cả các chuỗi.*

---

## 2. Strategy: Array Intersection (Minimum Frequency)
## *2. Chiến lược: Giao thoa Mảng (Tần suất Nhỏ nhất)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Array:** `int[] minFreq = new int[26]; Arrays.fill(minFreq, Integer.MAX_VALUE);`
    *   **Khởi tạo mảng:** Một mảng `minFreq` gán với giá trị lớn nhất.*

2.  **Iterate Words:** Loop through each string `word` in `words`.
    - Create `int[] currentFreq = new int[26];`
    - Loop through each character in `word` and increment `currentFreq[char - 'a']`.
    - Loop 0 to 25: `minFreq[i] = Math.min(minFreq[i], currentFreq[i]);`
    *   **Lặp qua từng TỪ:** Tạo mảng tần suất riêng rẽ, rồi đè cái giá trị Nhỏ Nhất vào mảng `minFreq` tổng.*

3.  **Construct Result:** Create a `List<String> result`. Loop 0 to 25. For each index `i`, loop `minFreq[i]` times and add `(char) ('a' + i)` to the result list.
    *   **Khởi tạo Kết quả:** Dựa vào `minFreq` xây dựng chuỗi kết quả String List.*

4.  **Return:** `result`.
    *   **Trả về:** `result`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        for (String word : words) {
            int[] currentFreq = new int[26];
            for (char c : word.toCharArray()) {
                currentFreq[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], currentFreq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$ where $N$ is the number of strings and $L$ is their average length. Updating the minimum takes 26 operations per word, which is $O(1)$. Total characters processed sets the complexity limit.
    *   **Độ phức tạp thời gian:** $O(N \cdot L)$. Do duyệt qua từng ký tự một lần.*
*   **Space Complexity:** $O(1)$ constant space for frequency arrays (size 26) exclusive of output space.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple tracking using $26$-sized index arrays is always the fastest and lowest memory footprint for character counting problems on constrained alphabets.
*Cách dùng mảng chỉ mục nhỏ $26$ phần tử luôn nhanh nhất và gọn nhất đối với các bảng hệ trục mẫu tự tiếng Anh thu hẹp.*

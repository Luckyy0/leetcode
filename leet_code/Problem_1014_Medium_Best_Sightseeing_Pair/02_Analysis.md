# Analysis for Best Sightseeing Pair
# *Phân tích cho bài toán Cặp đôi Ngắm cảnh Tốt nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Maximize the equation `values[i] + values[j] + i - j` subject to the constraint $i < j$.
*Tìm giá trị lớn nhất cho phương trình `values[i] + values[j] + i - j` với điều kiện $i < j$.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The formula blends two separate elements dependent on `i` and `j`. It's hard to evaluate together. Let's group terms by index mathematically:
  `(values[i] + i) + (values[j] - j)`
- If we iterate through the right-side pointer `j`, the term `(values[j] - j)` is a locally locked constant. Therefore, to maximize the entire sum at this step, we precisely need to pair it with the HIGHEST `(values[i] + i)` witnessed previously.
*Công thức gốc pha trộn hai thực thể chạy song song `i` và `j`. Nó gài rắc rối. Nên hãy áp dụng toán học gom nhóm chúng theo từng biến:*
`(values[i] + i) + (values[j] - j)`
*Khi ta thả lỏng chỉ số bên phải `j` quét qua mảng, ở bất kì bước nào, đại lượng `(values[j] - j)` là một hằng số cố định. Để đẩy bộc phá tổng cục diện sum bay lên trời, ta bắt buộc phải đi săn mồi và ghép với đại lượng `(values[i] + i)` TO NHẤT trong bóng tối sau lưng nó.*

---

## 2. Strategy 1: Naive (Nested Loops)
## *2. Chiến lược 1: Ngây thơ (Duyệt vòng lặp lồng)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy evaluates absolutely every sightseeing pair combination $(i, j)$ using a slow nested loop.
*Chiến lược ngây thơ đem lôi tuột mọi tổ hợp bộ đôi ngắm cảnh $(i, j)$ vào một cái bẫy vòng lặp lồng chéo để tra hỏi điểm số từng đứa.*

```java
public class Solution {
    public int maxScoreSightseeingPairNaive(int[] values) {
        int maxScore = 0;
        int n = values.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int score = values[i] + values[j] + i - j;
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        
        return maxScore;
    }
}
```

- **Weakness (Điểm yếu):** We repeatedly pair pairs linearly, landing at exactly $O(N^2)$ algorithmic time complexity. With constraint sizes of $5 \times 10^4$, squaring implies looping roughly $2.5 \times 10^9$ times. Overwhelming calculations induce guaranteed Time Limit Exceeded (TLE) errors.
  *Chúng ta chắp vá qua lặp lại như chạy thoi, làm độ phức tạp đóng đinh ở hệ số $O(N^2)$. Với quy mô $5 \times 10^4$ điểm đi phượt, bình phương số vòng lọt tới mốc 2 tỷ 5 chu trình khổng lồ. Tốc độ vắt kiệt phần cứng rớt đài ngay lập tức vào chạn TLE.*

---

## 3. Strategy 2: Optimal (One-Pass Max Trailing)
## *3. Chiến lược 2: Tối ưu (Duyệt 1 chạm dò tìm max gót)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Instead of calculating `(values[i] + i)` repetitively for every single `j`, we completely un-nest the search block. We deploy an aggregator variable, say `max_i`, that solely acts to permanently save the *maximum historic score of the left-end point* as it sweeps left-to-right holding data!
- Stand at `j`, observe the current total `max_i + values[j] - j`, update `max_score` if larger.
- Step moving right, quickly see if the index `j` we just stood on offers a newer, juicier, higher `values[j] + j` peak! If yes, override `max_i` with it!
This technique annihilates the secondary loop block, condensing the procedure down to brilliant linear efficiency $O(N)$.
*Thay vì ngồi tính `(values[i] + i)` rập khuôn một cách vô vị cho mỗi cái vòng trượt `j`, chúng ta đập nhuyễn cái còng số 8 ấy. Điều động một biến theo thám `max_i` chuyên làm nhiệm vụ duy nhất: chép lại và nhớ dai dẳng cái *kỷ lục khổng lồ nhất của điểm gốc trái* trong lúc quét mảng.*
*- Đứng chễm chệ ở `j`, kiểm kê tiền cược `max_i + values[j] - j`, đớp miếng tổng to nhất.*
*- Bước xéo sang phải tẹo, lật ngược xem cái mảnh đất `j` mình vừa thả dấu giày ấy có ngon ăn và tạo kỷ lục `values[j] + j` mới không? Ngon thì thâu tóm vào kỷ lục `max_i` ngay lập tức!*
*Chiêu thức khôn ngoan này búng tay xóa sổ toàn bộ vòng lặp cồng kềnh, đẩy hiệu năng về đường truyền thần tốc $O(N)$.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // Lưu trữ hằng số (value[i] + i) lớn nhất đã thấy
        int maxI = values[0] + 0;
        int maxScore = 0;
        
        for (int j = 1; j < values.length; j++) {
            // Giá trị tại j là (values[j] - j) 
            // Ghép cập nhật với Quán quân i lớn nhất trong quá khứ
            maxScore = Math.max(maxScore, maxI + values[j] - j);
            
            // Xong vòng j hiện có, nếu bản thân j mà to cộm hơn Quán quân cũ, phế truất quán quân!
            maxI = Math.max(maxI, values[j] + j);
        }
        
        return maxScore;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is numbers of array `values`. Only a single linear loop drives across the array elements perfectly once. Blazing fast!
    *   **Độ phức tạp thời gian:** $O(N)$. Chỉ một vòng quét thẳng trục duy nhất nuốt chửng dứt điểm mảng giá trị. Rất nhanh và rất tối ưu!*
*   **Space Complexity:** $O(1)$. Bare isolated scalar pointer tracking is employed (No Arrays, Lists created).
    *   **Độ phức tạp không gian:** $O(1)$. Chỉ dùng 2 biến thám tử theo dõi mồi mà không cấp phát ra bộ sinh mảng rác mới.*

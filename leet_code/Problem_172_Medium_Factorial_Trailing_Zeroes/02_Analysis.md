# Analysis for Factorial Trailing Zeroes
# *Phân tích cho bài toán Số chữ số 0 tận cùng của giai thừa*

## 1. Problem Essence & Prime Factorization
## *1. Bản chất vấn đề & Phân tích thừa số nguyên tố*

### What creates a trailing zero?
### *Điều gì tạo ra số 0 tận cùng?*
A trailing zero is created whenever we multiply by **10**. Since $10 = 2 \times 5$, the number of trailing zeroes in $n!$ is determined by the number of pairs of $(2, 5)$ in the prime factorization of $n!$.
*Một số 0 tận cùng được tạo ra bất cứ khi nào chúng ta nhân với **10**. Vì $10 = 2 \times 5$, số lượng chữ số 0 tận cùng trong $n!$ được quyết định bởi số lượng các cặp $(2, 5)$ trong phân tích thừa số nguyên tố của $n!$.*

### The Limiting Factor
### *Yếu tố giới hạn*
In the sequence of numbers from $1$ to $n$, multiples of 2 occur every 2 steps ($2, 4, 6, 8, 10, ...$), while multiples of 5 occur every 5 steps ($5, 10, 15, 20, ...$). 
Clearly, factors of 2 are much more abundant than factors of 5. Therefore, the number of $(2, 5)$ pairs is exactly equal to the **number of factors of 5**.
*Trong dãy số từ 1 đến $n$, bội số của 2 xuất hiện sau mỗi 2 bước, trong khi bội số của 5 xuất hiện sau mỗi 5 bước. Rõ ràng, thừa số 2 dồi dào hơn nhiều so với thừa số 5. Do đó, số lượng cặp $(2, 5)$ chính bằng **số lượng thừa số 5**.*

---

## 2. Approach: Legendre's Formula (Counting 5s)
## *2. Hướng tiếp cận: Công thức Legendre (Đếm số 5)*

We need to count how many times 5 appears as a factor in $n!$.
- Some numbers have one factor of 5: $5, 10, 15, 20...$ (Multiples of 5).
- Some numbers have two factors of 5: $25, 50, 75...$ (Multiples of $5^2 = 25$).
- Some have three: $125, 250...$ (Multiples of $5^3 = 125$).
*Chúng ta cần đếm xem số 5 xuất hiện bao nhiêu lần như một thừa số trong $n!$.*
*- Một số số có một thừa số 5 (bội của 5).*
*- Một số số có hai thừa số 5 (bội của 25).*
*- Tương tự cho 125, 625, v.v.*

### Standard Formula
### *Công thức tiêu chuẩn*
The total number of trailing zeroes is:
$$Count = \lfloor \frac{n}{5} \rfloor + \lfloor \frac{n}{25} \rfloor + \lfloor \frac{n}{125} \rfloor + \dots$$
We iterate while $n/5^k > 0$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Mathematical Elegance:** We avoid calculating $n!$ itself, which would be impossible for $n=10000$ as it exceeds all primitive data types (thousands of digits long). 
    *Sự trang nhã về toán học: Chúng ta tránh việc tính toán trực tiếp $n!$, điều vốn là bất khả thi đối với $n=10000$ vì nó vượt quá mọi kiểu dữ liệu nguyên thủy.*
*   **Logarithmic Time:** Instead of checking every number from 1 to $n$, we divide $n$ by powers of 5. This makes the algorithm extremely fast.
    *Thời gian Logarit: Thay vì kiểm tra từng số, chúng ta chia $n$ cho các lũy thừa của 5. Điều này khiến thuật toán cực kỳ nhanh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_5 N)$. The number of steps is the number of times we can divide $n$ by 5 until it reaches 0.
    *Độ phức tạp thời gian: $O(\log_5 N)$. Số bước chính là số lần chúng ta có thể chia $n$ cho 5 cho đến khi bằng 0.*
*   **Space Complexity:** $O(1)$. We only use a single variable to accumulate the result.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 100`

1.  `100 / 5 = 20`. (There are 20 multiples of 5: 5, 10, 15... 100).
2.  `100 / 25 = 4`. (There are 4 multiples of 25: 25, 50, 75, 100. Each contributes an **extra** factor of 5).
3.  `100 / 125 = 0`. (Stop).
4.  `Total = 20 + 4 = 24`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Factorial Trailing Zeroes is a classic brain teaser that separates those who try to calculate the value from those who look at the underlying prime structure. In competitive programming and interviews, always look for the "bottleneck" factor. Here, 5 is the bottleneck. The recursive or iterative implementation of Legendre's formula is the only correct way to solve this in logarithmic time.
*Số 0 tận cùng của giai thừa là một câu hỏi đố trí tuệ kinh điển giúp phân biệt những người cố gắng tính toán giá trị với những người nhìn vào cấu trúc nguyên tố bên dưới. Trong lập trình thi đấu, hãy luôn tìm kiếm "thừa số giới hạn". Ở đây, 5 là yếu tố giới hạn.*
---
*Đôi khi vẻ ngoài của một con số khổng lồ chỉ đơn giản là sự lặp lại của những đơn vị nhỏ bé nhất đằng sau hậu trường.*
Sometimes the appearance of a giant number is simply the repetition of the smallest units behind the scenes.

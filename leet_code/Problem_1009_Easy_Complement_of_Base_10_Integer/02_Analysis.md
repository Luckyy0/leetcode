# Analysis for Complement of Base 10 Integer
# *Phân tích cho bài toán Bù của số nguyên cơ số 10*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an integer `n`, find its complement by flipping all bits in its binary representation. Note that leading zeros are ignored (e.g., $5$ is `101`, not `00000101`).
*Cho một số nguyên `n`, tìm giá trị bù bằng cách lật tất cả các bit trong biểu diễn nhị phân của nó. Bỏ qua các số 0 ở đầu (ví dụ: $5$ là `101`, chứ không phải `00000101`).*

---

## 2. Strategy 1: Naive (String Manipulation)
## *2. Chiến lược 1: Ngây thơ (Xử lý chuỗi)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

Convert the integer `n` to a binary string, then manually iterate over the string to construct a new string by flipping `'0'` to `'1'` and `'1'` to `'0'`. Finally, convert the output string back to a base-10 integer.
*Đổi số `n` thành chuỗi nhị phân, sau đó tự duyệt qua chuỗi để tạo chuỗi mới lật ngược `'0'` thành `'1'` và `'1'` thành `'0'`. Kết thúc thì đổi chuỗi kết quả đó về lại hệ cơ số 10.*

```java
public class Solution {
    public int bitwiseComplementNaive(int n) {
        if (n == 0) return 1;
        
        String binaryStr = Integer.toBinaryString(n);
        StringBuilder flipped = new StringBuilder();
        
        for (char c : binaryStr.toCharArray()) {
            if (c == '0') {
                flipped.append('1');
            } else {
                flipped.append('0');
            }
        }
        
        return Integer.parseInt(flipped.toString(), 2);
    }
}
```

- **Weakness (Điểm yếu):** String creation, appending, and parsing operations are slow and allocate extra memory. It ignores the fact that computers are designed to do this specific level of bitwise manipulation directly on the CPU hardware.
  *Việc tạo chuỗi, nối chuỗi và chuyển giải tốn thời gian và cấp phát thêm nhiều bộ nhớ. Cách này bỏ ngỏ hoàn toàn sự thật là máy tính được chế tạo ra để làm toán trên bit trực tiếp ngay trên bộ xử lý trung tâm (CPU).*

---

## 3. Strategy 2: Optimal (Bitwise XOR Toggle)
## *3. Chiến lược 2: Tối ưu (Dùng Cổng XOR Toán tử bit)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

To flip bits, the most elegant hardware operation is the XOR operator (`^`). Any bit XORed with `1` will flip (`1 ^ 1 = 0`, `0 ^ 1 = 1`). 
So, if `n = 5` (which is `101`), we just need a mask of all ones of the exact same bit-length, which is `111` (or 7). 
Then, `101 ^ 111 = 010` (which is 2).
We simply find the mask by shifting `1` to the left until it exceeds `n`, generating the all-ones mask, then XOR `n` with this mask.
*Để lật bit, phép tính phần cứng tuyệt vòi nhất chính là cổng XOR (`^`). Bất kỳ bit nào XOR với `1` cũng sẽ bị đảo nghịch. Ví dụ: với `n = 5` (`101`), ta chỉ cần tạo một mặt nạ (mask) toàn bit `1` có độ dài tương đương, tức là `111` (số 7). Rồi tính `101 ^ 111 = 010` (tức là 2).*
*Ta tạo mặt nạ bằng cách liên tục dời bit `1` sang trái rồi trừ 1 đi tới khi nó trùm vừa khít `n`.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Handle Exception:** If `n == 0`, just return `1`.
    *   *Xử lý ngoại lệ: Nếu `n == 0`, trả thẳng về `1`.*
2.  **Generate Mask:** Find the length of `n`'s binary form. Alternatively, calculate the smallest power of 2 that is greater than `n`. Then subtract 1 to get a mask of all `1`s.
    *   *Tạo mặt nạ: Tìm lũy thừa của 2 nhỏ nhất nhưng lớn hơn phần tử `n`. Xong lấy lũy thừa đó trừ đi 1 để nhận về mặt nạ tràn viền số 1.*
    - Example for `n = 10` (binary `1010`): Power of 2 greater than 10 is 16 (`10000`). 16 - 1 = 15 (`1111`).
3.  **Perform XOR:** Return `n ^ mask`.
    *   *Triển khai lệnh XOR: Trả về `n ^ mask`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        
        int mask = 1;
        // Shift bits until mask covers exactly the same number of bits as N
        while (mask <= n) {
            mask = (mask << 1) | 1; 
        }
        
        // XOR flips the bits securely
        return n ^ mask;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$ or technically $O(1)$. Since integer variables only have 32 bits, the `while` loop runs at most 32 times.
    *   **Độ phức tạp thời gian:** $O(\log N)$ hay về kỹ thuật là $O(1)$. Một số nguyên Integer chỉ chứa tối đa 32 bit, vậy vòng lặp chạy dữ lắm 32 vòng.*
*   **Space Complexity:** $O(1)$. Just an extra variable for the `mask`.
    *   **Độ phức tạp không gian:** $O(1)$. Chỉ dùng 1 biến số chừa lưu mặt nạ.*

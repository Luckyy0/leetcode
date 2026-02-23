# Analysis for Special Binary String
# *Phân tích cho bài toán Chuỗi Nhị phân Đặc biệt*

## 1. Problem Essence & Parenthesis Isomorphism
## *1. Bản chất vấn đề & Sự đẳng cấu với Ngoặc đơn*

### The Analogy
### *Sự tương tự*
The properties of a "Special Binary String" (count of 1s equals 0s, prefix 1s $\ge$ 0s) are exactly the definition of a **Valid Parenthesis String** if we treat `1` as `(` and `0` as `)`.
*Các thuộc tính của "Chuỗi Nhị phân Đặc biệt" (số lượng 1 bằng 0, tiền tố 1 $\ge$ 0) chính xác là định nghĩa của **Chuỗi Ngoặc đơn Hợp lệ** nếu ta coi `1` là `(` và `0` là `)`.*

### Hierarchy
### *Phân cấp*
Since every special string must start with `1` and end with `0` (equivalent to starting with `(` and ending with `)`), any special string `S` can be decomposed into `1` + `Inner` + `0`. The `Inner` part itself is a concatenation of one or more special substrings.
*Vì mọi chuỗi đặc biệt phải bắt đầu bằng `1` và kết thúc bằng `0` (tương đương với bắt đầu bằng `(` và kết thúc bằng `)`), bất kỳ chuỗi `S` nào cũng có thể được phân tách thành `1` + `Bên trong` + `0`. Phần `Bên trong` chính nó là sự nối tiếp của một hoặc nhiều chuỗi con đặc biệt.*

The operation "swap two consecutive special substrings" implies that for any sequence of adjacent special substrings at the same level of depth, we can rearrange them in **any order**. To maximize the string lexicographically, we simply need to sort these substrings in **descending order**.
*Thao tác "hoán đổi hai chuỗi con đặc biệt liên tiếp" ngụ ý rằng với bất kỳ dãy chuỗi con đặc biệt nào kề nhau ở cùng một độ sâu, ta có thể sắp xếp lại chúng theo **bất kỳ thứ tự nào**. Để tối đa hóa chuỗi về mặt từ điển, ta chỉ cần sắp xếp các chuỗi con này theo **thứ tự giảm dần**.*

---

## 2. Strategy: Recursive Parsing & Sorting
## *2. Chiến lược: Phân tích Đệ quy & Sắp xếp*

### Algorithm
### *Thuật toán*

1.  **Decomposition (Phân rã):**
    Iterate through the string `S`. Maintain a `balance` counter (`+1` for '1', `-1` for '0'). Whenever `balance` returns to 0, we have identified a complete special substring (a "chunk").
    *Duyệt qua chuỗi `S`. Duy trì biến đếm `balance` (`+1` cho '1', `-1` cho '0'). Bất cứ khi nào `balance` trở về 0, ta đã xác định được một chuỗi con đặc biệt hoàn chỉnh (một "khối").*

2.  **Recursion (Đệ quy):**
    For each identified chunk (e.g., `1` + `M` + `0`), the inner part `M` might also contain nested special strings. We recursively call the function on `M` to make it lexicographically largest.
    *Với mỗi khối được xác định (ví dụ: `1` + `M` + `0`), phần bên trong `M` cũng có thể chứa các chuỗi đặc biệt lồng nhau. Ta gọi đệ quy hàm trên `M` để biến nó thành lớn nhất về mặt từ điển.*
    
    The transformed chunk becomes `1` + `makeLargest(M)` + `0`.
    *Khối sau khi biến đổi trở thành `1` + `makeLargest(M)` + `0`.*

3.  **Sorting (Sắp xếp):**
    After processing all chunks at the current level, sort them in descending order.
    *Sau khi xử lý tất cả các khối ở cấp độ hiện tại, sắp xếp chúng theo thứ tự giảm dần.*

4.  **Reassembly (Lắp ráp):**
    Concatenate the sorted chunks to form the result.
    *Nối các khối đã sắp xếp để tạo thành kết quả.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public String makeLargestSpecial(String s) {
    List<String> specialSubstrings = new ArrayList<>();
    int count = 0, start = 0;
    
    // Identify top-level special substrings
    // Xác định các chuỗi con đặc biệt ở cấp cao nhất
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1') count++;
        else count--;
        
        if (count == 0) {
            // Found a chunk: "1" + inner + "0"
            // Inner is substring(start + 1, i)
            // Recurse on inner part
            String inner = s.substring(start + 1, i);
            String optimizedChunk = "1" + makeLargestSpecial(inner) + "0";
            
            specialSubstrings.add(optimizedChunk);
            start = i + 1;
        }
    }
    
    // Sort descending to maximize lexicographical value
    // Sắp xếp giảm dần để tối đa hóa giá trị từ điển
    Collections.sort(specialSubstrings, Collections.reverseOrder());
    
    // Join them
    return String.join("", specialSubstrings);
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. In the worst case (deeply nested or many small chunks), sorting and string creation can take quadratic time. $N \le 50$, so this is negligible.
    *   **Độ phức tạp thời gian:** $O(N^2)$. Trong trường hợp xấu nhất (lồng nhau sâu hoặc nhiều khối nhỏ), việc sắp xếp và tạo chuỗi có thể mất thời gian bậc hai. $N \le 50$, nên điều này không đáng kể.*
*   **Space Complexity:** $O(N^2)$ for recursion stack and string storage.
    *   **Độ phức tạp không gian:** $O(N^2)$ cho ngăn xếp đệ quy và lưu trữ chuỗi.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `s = "11011000"`

1.  **Parse components:**
    - `i=0` ('1'), Bal=1
    - `i=1` ('1'), Bal=2
    - `i=2` ('0'), Bal=1
    - ...
    - `i=7` ('0'), Bal=0.
    - Whole string is one chunk: `1` + `101100` + `0`.
    
2.  **Recurse on Inner:** `M = "101100"`
    - Scan `M`:
        - `10` -> Bal=0. Chunk 1: `10`. Inner `""`. Result: `1`+`""`+`0` = `10`.
        - `1100` -> Bal=0. Chunk 2: `1100`. Inner `10`. Recurse `makeLargest("10")` -> `10`. Result: `1`+`10`+`0` = `1100`.
    - Components of `M`: `["10", "1100"]`.
    - Sort Descending: `["1100", "10"]`.
    - Join `M'`: `"110010"`.

3.  **Finalize:**
    - Outer chunk becomes `1` + `110010` + `0` = `"11100100"`.

**Result:** `"11100100"`.

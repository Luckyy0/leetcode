# Analysis for Maximum Frequency Stack
# *Phân tích cho bài toán Ngăn xếp Tần suất Tối đa*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Implement a stack that supports `push` and `pop`. The `pop` operation must remove the **most frequent** element. If there's a tie, remove the one **closest to the top** (most recently pushed).
*Triển khai ngăn xếp hỗ trợ `push` và `pop`. Thao tác `pop` phải loại bỏ phần tử **xuất hiện thường xuyên nhất**. Nếu hòa, loại bỏ phần tử **gần đỉnh nhất** (mới được đẩy vào nhất).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need to track the frequency of each element.
- We need to group elements by their frequency to know which ones have the current max frequency.
- For elements with the sam frequency, we need to respect the stack order (LIFO).
*Chúng ta cần theo dõi tần suất của mỗi phần tử. Cần nhóm các phần tử theo tần suất để biết phần tử nào đang có tần suất cao nhất. Với các phần tử cùng tần suất, cần tuân thủ thứ tự ngăn xếp (LIFO).*

---

## 2. Strategy: Stack of Stacks (Group by Frequency)
## *2. Chiến lược: Ngăn xếp của các Ngăn xếp (Nhóm theo Tần suất)*

### Data Structures
### *Cấu trúc dữ liệu*
1.  `freqMap`: `Map<Integer, Integer>`. Maps element value -> current frequency.
    *   `freqMap`: Ánh xạ giá trị phần tử -> tần suất hiện tại.*
2.  `groupMap`: `Map<Integer, Stack<Integer>>`. Maps frequency `k` -> Stack of elements that have reached frequency `k`.
    *   `groupMap`: Ánh xạ tần suất `k` -> Ngăn xếp chứa các phần tử đã đạt đến tần suất `k`.*
3.  `maxFreq`: Integer. Tracks the current maximum frequency in the stack.
    *   `maxFreq`: Theo dõi tần suất tối đa hiện tại.*

### Algorithm Steps
### *Các bước thuật toán*

#### Push(val):
1.  Get current frequency `f` of `val` from `freqMap`.
2.  Increment frequency: `f = f + 1`. Update `freqMap`.
3.  Update `maxFreq` if `f > maxFreq`.
4.  Push `val` onto the stack at `groupMap[f]`.
    *   Why? This records that this specific instance of `val` is the $f$-th occurrence. By pushing it to the stack for frequency $f$, we ensure it's popped only after all later occurrences (which would be at higher frequencies or later in the same stack) are processed.
    *   *Tại sao? Điều này ghi lại rằng lần xuất hiện này của `val` là lần thứ $f$. Bằng cách đẩy nó vào ngăn xếp cho tần suất $f$, ta đảm bảo nó chỉ được lấy ra sau khi các lần xuất hiện sau này đã được xử lý.*

#### Pop():
1.  Get the stack corresponding to `maxFreq` from `groupMap`.
2.  Pop `val` from this stack.
3.  Decrement frequency of `val` in `freqMap`.
4.  If the stack for `maxFreq` becomes empty, decrement `maxFreq`.
5.  Return `val`.

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, f);
        
        if (f > maxFreq) {
            maxFreq = f;
        }
        
        groupMap.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = groupMap.get(maxFreq);
        int val = stack.pop();
        
        freqMap.put(val, maxFreq - 1);
        
        if (stack.isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for both `push` and `pop`. Map operations and Stack operations are constant time.
    *   **Độ phức tạp thời gian:** $O(1)$ cho cả hai thao tác. Các thao tác trên Map và Stack là hằng số.*
*   **Space Complexity:** $O(N)$, where $N$ is the number of elements pushed. Each push adds an entry to a stack in `groupMap`.
    *   **Độ phức tạp không gian:** $O(N)$, mỗi lần push thêm một mục vào ngăn xếp trong `groupMap`.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Visualizing the problem as "layers" of frequency stacks is key. The first occurrence of '5' is in stack 1. The second occurrence of '5' is in stack 2. This naturally handles the "most frequent" and "closest to top" requirements simultaneously.
*Hình dung bài toán như các "lớp" ngăn xếp tần suất là chìa khóa. Lần xuất hiện đầu tiên của '5' ở ngăn xếp 1. Lần thứ hai ở ngăn xếp 2. Điều này tự động xử lý cả hai yêu cầu "thường xuyên nhất" và "gần đỉnh nhất".*

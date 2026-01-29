# 810. Chalkboard XOR Game / Trò chơi XOR trên Bảng

## Problem Description / Mô tả bài toán
You are given an array of integers `nums`. Alice and Bob are taking turns to erase one number from the chalkboard.
Bạn được cho một mảng số nguyên `nums`. Alice và Bob lần lượt xóa một con số khỏi bảng.

If erasing a number causes the bitwise XOR sum of all numbers remaining on the chalkboard to become 0, then that player loses.
Nếu việc xóa một con số khiến tổng XOR của tất cả các con số còn lại trên bảng trở thành 0, thì người chơi đó sẽ thua.

If the bitwise XOR sum is already 0 when the game starts, Alice wins immediately.
Nếu tổng XOR đã là 0 khi trò chơi bắt đầu, Alice thắng ngay lập tức.

Assume both players play optimally. Return `true` if Alice wins.
Giả sử cả hai người chơi đều chơi tối ưu. Trả về `true` nếu Alice thắng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Game Theory / XOR Property / Lý thuyết Trò chơi / Thuộc tính XOR
Alice wins if:
1. Initial XOR sum is 0.
Tổng XOR ban đầu là 0.
2. The total number of elements `nums.length` is **even**.
Tổng số lượng phần tử `nums.length` là **chẵn**.

Why?
If `XOR != 0`, and the number of elements is even, Alice can always find a number to remove that keeps the remaining XOR non-zero. Bob will eventually be forced to remove a number that makes XOR 0, or he will run out of numbers first.
Nếu `XOR != 0` và số lượng phần tử là chẵn, Alice luôn có thể tìm thấy một con số để xóa mà vẫn giữ được giá trị XOR khác 0. Bob cuối cùng sẽ bị buộc phải xóa một con số khiến XOR bằng 0 hoặc hết số trước.

### Complexity / Độ phức tạp
- **Time**: O(N) to calculate XOR.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Parity and Initial State Check
The outcome of the XOR game depends on whether the player starting can force a non-zero remaining sum. Analysis shows and even count of numbers guarantees a win for the first player if the initial sum isn't already 0.
Kết quả của trò chơi XOR phụ thuộc vào việc người chơi bắt đầu có thể tạo ra một tổng còn lại khác không hay không. Phân tích cho thấy số lượng số chẵn đảm bảo chiến thắng cho người chơi đầu tiên nếu tổng ban đầu chưa bằng 0.

---

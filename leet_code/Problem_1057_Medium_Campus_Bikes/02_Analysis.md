# Analysis for Campus Bikes
# *Phân tích bài toán Xe Đạp Khuôn Viên*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We have a set of workers and a set of bikes on a 2D grid. We need to assign one bike to each worker. The assignment must strictly follow three prioritized rules:
1. Always assign the currently available worker-bike pair with the absolute shortest Manhattan distance.
2. If there's a tie in distance, favor the worker with the smaller index.
3. If there's a tie in distance AND worker index, favor the bike with the smaller index.
*Toàn cảnh: Ta được trao một lưới 2D, trên đó rải rác nhóm 'Công nhân' (workers) và các 'Bãi xe đạp' (bikes). Nhiệm vụ là gán đúng 1 chiếc xe cho 1 người, luôn tuân thủ nghiêm ngặt 3 luật ưu tiên:*
*1. Bất kỳ cặp (Người - Xe) nào có Khoảng cách Manhattan NHỎ NHẤT thì đều phải được gán trước tiên.*
*2. Khi xảy ra đụng độ (hai cặp có khoảng cách bằng nhau): Ưu tiên cho Công Nhân có Chỉ số (Worker Index) nhỏ hơn.*
*3. Đụng độ cả Khoảng Cách lẫn Index Công Nhân: Dành sự ưu tiên cho chiếc Xe có Chỉ số (Bike Index) nhỏ hơn.*

Constraints: Up to 1000 workers and 1000 bikes. Max distance is around 2000.
*Ràng buộc: Bài toán cung cấp tối đa 1000 công nhân và 1000 chiếc xe. Quãng đường Manhattan tối đa cho phép chỉ kìm hãm ở mức dưới 2000.*

---

## 2. Strategy: Brute Force (Sorting All Pairs)
## *2. Chiến lược: Trâu Cày (Sắp xếp TẤT CẢ tổ hợp cặp)*

### Naive Logic
### *Lý luận thô sơ*
The most straightforward approach is to calculate the Manhattan distance for all possible pairs between every worker and every bike.
We store these combinations as objects or arrays in a large list, and then we strictly sort this list based on the 3 rules.
*Cách giải ngây thơ và dễ nghĩ ra nhất là tiến hành đo khoảng cách thủ công cho TẤT CẢ mọi cặp tổ hợp Công nhân - Xe đạp có thể xảy ra trên bàn cờ. Sau đó, ta quăng toàn bộ danh sách kết quả (gồm [Khoảng cách, ID_Công_Nhân, ID_Xe]) vào một mảng List khổng lồ và gọi hàm `Sort()` sắp xếp lại toàn bộ theo đúng 3 bộ luật.*

**Drawbacks (Điểm yếu):**
Generating all $N \times M$ pairs means we create $1000 \times 1000 = 10^6$ (1 million) pairs. Sorting this massive list using a custom comparator takes $O(N \cdot M \log(N \cdot M))$ time. Given the constraints, taking a logarithm over a million coupled with object creation overhead results in sluggish execution and a massive memory footprint, heavily threatening a TLE (Time Limit Exceeded).
*Tạo toàn bộ $N \times M$ cặp đồng nghĩa với sinh ra 1 Triệu Tổ Hợp trên bộ nhớ. Vác 1 Triệu đối tượng này đi Sắp Xếp (với độ phức tạp $N \log N$ của mảng lớn) sẽ phá nát Tài nguyên CPU và RAM. Hệ thống sẽ rơi vào trạng thái rùa bò và dễ sập Lỗi Quá Giờ (TLE).*

---

## 3. Strategy: Optimal (Bucket Sort)
## *3. Chiến lược: Tối ưu (Sắp Xếp Theo Rổ - Bucket Sort)*

### Logic and Rules
### *Lý luận và Quy tắc*

**The Breakthrough: Limited Distance Range.**
**Điểm Đột Phá: Vùng Giới Hạn Khoảng Cách Quá Nhỏ.**
The maximum possible Manhattan distance between any coordinate points cleanly bounded within `[0, 999]` is exactly $999 + 999 = 1998$.
*Theo toán lý, trục không gian 2D khép kín trong biên độ tọa độ `[0, 999]` dẫn đến Quãng đường Manhattan xa nhất giữa 2 điểm bất kỳ chỉ chạm tối đa tới mức: $(999 - 0) + (999 - 0) = 1998$.*

Because the distances are just integers from 0 to 2000, we can use an array of lists: a classic **Bucket Sort**. This replaces the massive bottleneck of $O(K \log K)$ sorting.
*Dựa vào việc khoảng cách luôn là những con số nguyên nằm trọn trong Cột Mốc từ 0 đến 2000, ta có thể đổi hướng từ Sắp xếp mảng chậm chạp sang một Mảng gắn Danh sách trực tiếp (Thuật toán Sắp Xếp Xô Nhựa - **Bucket Sort**) xóa sổ hoàn toàn rào cản Logarit LogK.*

1.  **Generate All Pairs:** Calculate the distance for every pair `(worker, bike)`. Loop workers `i` on the outside, and bikes `j` on the inside to inherently respect tie-breaking rules natively.
    * *1. Trải Lưới Quét Cặp Tổ Hợp: Tiến hành tính khoảng cách cho mọi tổ hợp đối tượng chéo. Chìa khóa thiết thực là xếp lặp phần công nhân ở ngoài bọc, vòng lặp xe vào trong lõi. Lệnh này đảm bảo từ trong trứng nước, các số liệu sẽ đi vào danh sách theo đúng chuẩn luật đụng hàng (index nhỏ vào trước sẽ chốt trước).*
2.  **Bucket Them:** Place the pair `[worker_index, bike_index]` into the bucket array exactly at the index matching their `distance`.
    * *2. Đưa Dữ Liệu Vào Xô Đựng: Trỏ các mảng Thùng (Bucket Array) với Index chính là Giá trị khoảng cách. Thả thông số `[worker, bike]` vào rổ List đó.*
3.  **Process Buckets progressively from distance 0 to 2000:** Walk sequentially through the buckets. If a worker hasn't got a bike yet, and the specific bike is not yet taken, safely construct the link and assign it.
    * *3. Xét Duyệt Các Xô Chứa: Quét mảng dần đều từ khoảng đáy 0 vung lên tận mốc trần 2000. Nếu tại giỏ hàng nào mà bắt gặp anh công nhân còn đang trống xe VÀ chiếc xe liên kết đó lại chưa dán tên ai lấy, ta trực tiếp ghim chốt cặp đôi này lại làm thành quả!*

### Java Optimal Implementation Let
### *Triển khai giải pháp Java Tối Ưu*

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int wSize = workers.length;
        int bSize = bikes.length;
        
        // Mảng 2001 Cái Xô. Chỉ số mảng = Khoảng cách.
        @SuppressWarnings("unchecked")
        List<int[]>[] buckets = new List[2001];
        
        // Bước 1: Quét toàn bộ tổ hợp cặp worker - bike
        for (int w = 0; w < wSize; w++) {
            for (int b = 0; b < bSize; b++) { 
                int manhattanDist = Math.abs(workers[w][0] - bikes[b][0]) + Math.abs(workers[w][1] - bikes[b][1]);
                
                // Khởi tạo List Rỗng nếu Xô đó chưa từng được động tới
                if (buckets[manhattanDist] == null) {
                    buckets[manhattanDist] = new ArrayList<>();
                }
                buckets[manhattanDist].add(new int[]{w, b});
            }
        }
        
        int[] result = new int[wSize];
        Arrays.fill(result, -1); // Khởi tạo -1 nghĩa là mảng Rỗng, chưa có xe
        
        boolean[] bikeAssigned = new boolean[bSize];
        int assignedCount = 0; 
        
        // Bước 2: Duyệt từng Xô từ bé đến lớn để chốt hạ quyền lấy xe theo Khoảng cách
        for (int dist = 0; dist < 2001; dist++) {
            if (buckets[dist] == null) continue;
            
            // Bung khóa các List trong xô nhỏ (Ưu điểm mảng tạo ra có sẵn Worker bé đi chung Bike Bé do vòng lặp Array ban đầu)
            for (int[] pair : buckets[dist]) {
                int wIndex = pair[0];
                int bIndex = pair[1];
                
                // Trống Mâm + Ghế Rảnh -> Chốt ngồi!
                if (result[wIndex] == -1 && !bikeAssigned[bIndex]) {
                    result[wIndex] = bIndex;       
                    bikeAssigned[bIndex] = true;      
                    assignedCount++;
                    
                    if (assignedCount == wSize) {
                        return result; // Đủ quân thì đóng mảng
                    }
                }
            }
        }
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times M)$. Generating pairs and traversing the bucket array takes strictly linear time operations with respect to the bounds of the created grid pairs.
    *   **Độ phức tạp thời gian:** $O(N \times M)$. Tạo toàn bồ các tổ hợp lưới gán sẽ làm tiêu tốn vòng lặp quét đủ qua lượng $N \times M$. Thao tác Duyệt lại tuần tự qua 2001 tầng xô đựng mảng trong array cũng diễn ra thực tiễn bằng con số tịnh tiến. Loại trừ cấu trúc Logarit, ta đẩy tốc độ lên cao nhất.*
*   **Space Complexity:** $O(N \times M)$. The structural array buckets optimally handles storing all logically combined pairings within the network pairs efficiently.
    *   **Độ phức tạp không gian:** $O(N \times M)$. Mở không gian các dữ liệu danh sách mảng lồng chéo qua xô chứa bucket yêu cầu nạp trọn bộ RAM tỉ lệ thuận theo số lượng bộ đôi lưới liên kết đã tạo ra.*

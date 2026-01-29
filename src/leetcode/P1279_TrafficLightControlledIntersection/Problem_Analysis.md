# 1279. Traffic Light Controlled Intersection / Ngã tư Điều khiển bởi Đèn Giao thông

## Problem Description / Mô tả bài toán
Design `TrafficLight` class.
`carArrived(carId, roadId, direction, turnGreen, crossCar)`.
`roadId`: 1 or 2.
Control traffic lights to allow cars to cross.
- Traffic light on road A is green -> cars on A can cross.
- If car on B arrives, switch light if possible.
Problem ensures `crossCar` only runs when light is green for that road.
Constraints: Must avoid deadlock, ensure fairness/progress.
But wait, the method signature requires passing `turnGreen` runnable.
Basically serialize access and switch lights.
Usually a simplified concurrency problem.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Concurrency / Synchronization
State: `currentGreenRoad`. Initially 1.
`carArrived`:
- Synchronized method/block.
- Check `roadId`.
- If `roadId != currentGreenRoad`.
  - Call `turnGreen`. Update `currentGreenRoad`.
- Call `crossCar`.

### Complexity / Độ phức tạp
- **Time**: O(1) per car (plus waiting).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Synchronized Switching
Maintain a variable `greenRoad` indicating which road currently has the green light. When a car arrives on `roadId`, acquire a lock (using `synchronized`). Check if `greenRoad` matches `roadId`. If not, invoke `turnGreen` to switch the light and update `greenRoad`. Finally, invoke `crossCar`. Since the method is synchronized, only one car processes the light logic at a time, ensuring safety. (Though multiple cars can cross simultaneously if they are on the green road, the problem interface calls `carArrived` sequentially or we just need to ensure `turnGreen` is called correctly before crossing. `synchronized` ensures strict ordering of processing).
Duy trì một biến `greenRoad` cho biết con đường nào hiện đang có đèn xanh. Khi một chiếc xe đến `roadId`, hãy lấy khóa (sử dụng `synchronized`). Kiểm tra xem `greenRoad` có khớp với `roadId` hay không. Nếu không, hãy gọi `turnGreen` để chuyển đèn và cập nhật `greenRoad`. Cuối cùng, gọi `crossCar`. Vì phương thức được đồng bộ hóa, mỗi lần chỉ có một xe xử lý logic đèn, đảm bảo an toàn. (Mặc dù nhiều xe có thể băng qua cùng lúc nếu chúng đang ở trên đường xanh, giao diện bài toán gọi `carArrived` tuần tự hoặc chúng ta chỉ cần đảm bảo `turnGreen` được gọi chính xác trước khi băng qua. `synchronized` đảm bảo thứ tự xử lý nghiêm ngặt).

---

# Result for Freedom Trail
# *Kết quả cho bài toán Đường mòn Tự do*

## Description
## *Mô tả*

In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.
*Trong trò chơi điện tử Fallout 4, nhiệm vụ "Road to Freedom" yêu cầu người chơi đến một mặt số kim loại gọi là "Freedom Trail Ring" và sử dụng mặt số để đánh vần một từ khóa cụ thể để mở cửa.*

So, given a string `ring`, which represents the code engraved on the outer ring and another string `key`, which represents the keyword you need to spell. You need to find the **minimum** number of steps in order to spell all the characters in the keyword.
*Vì vậy, cho một chuỗi `ring`, đại diện cho mã được khắc trên vòng ngoài và một chuỗi khác `key`, đại diện cho từ khóa bạn cần đánh vần. Bạn cần tìm số bước **tối thiểu** để đánh vần tất cả các ký tự trong từ khóa.*

Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string `key` one by one by rotating the ring clockwise or anticlockwise to make each character of the string `key` aligned at 12:00 direction and then by pressing the center button.
*Ban đầu, ký tự đầu tiên của vòng được căn chỉnh ở hướng 12:00. Bạn cần đánh vần từng ký tự trong chuỗi `key` bằng cách xoay vòng theo chiều kim đồng hồ hoặc ngược chiều kim đồng hồ để làm cho mỗi ký tự của chuỗi `key` căn chỉnh ở hướng 12:00 và sau đó nhấn nút trung tâm.*

At the stage of rotating the ring to spell the key character `key[i]`:
1.  You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string `ring`'s characters at the 12:00 direction, where this character must equal to the character `key[i]`.
2.  If the character `key[i]` has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character `key[i + 1]`.

*Ở giai đoạn xoay vòng để đánh vần ký tự khóa `key[i]`:*
1.  *Bạn có thể xoay vòng theo chiều kim đồng hồ hoặc ngược chiều kim đồng hồ một vị trí, tính là 1 bước. Mục đích cuối cùng của việc xoay là căn chỉnh một trong các ký tự của chuỗi `ring` ở hướng 12:00, tại đó ký tự này phải bằng ký tự `key[i]`.*
2.  *Nếu ký tự `key[i]` đã được căn chỉnh ở hướng 12:00, bạn cần nhấn nút trung tâm để đánh vần, điều này cũng tính là 1 bước. Sau khi nhấn, bạn có thể bắt đầu đánh vần ký tự tiếp theo `key[i + 1]`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `ring = "godding", key = "gd"`
**Output:** `4`
**Explanation:**
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `ring = "godding", key = "godding"`
**Output:** `13`

## Constraints:
## *Ràng buộc:*

*   `1 <= ring.length, key.length <= 100`
*   `ring` and `key` consist of only lowercase English letters.
*   It is guaranteed that the last character of `ring` is not aligned at the 12:00 direction initially. (This constraint seems confusing/irrelevant or specific to how rotation is described, effectively `ring` is circular).

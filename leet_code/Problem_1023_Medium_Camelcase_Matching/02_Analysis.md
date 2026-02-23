# Analysis for Camelcase Matching
# *Phân tích cho bài toán Khớp mẫu Kiểu lạc đà (Camelcase)*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A query matches a pattern if you can insert ONLY LOWERCASE letters into the pattern to reproduce the query. What does this mean strictly?
1. All characters in the `pattern` must appear in the `query` in the **exact same order**.
2. Any *extra* characters in the `query` that are NOT part of the `pattern` **MUST be lowercase**. If the query holds an extra UPPERCASE letter that the pattern doesn't explicitly ask for, the match instantly fails!
*Một chuỗi câu hỏi được xem là Khớp Mẫu nếu bạn chỉ được phép nhét ĐỘC CHỮ IN THƯỜNG vào khuôn mẫu để phóng to nó thành y hệt câu hỏi. Phân tách rạch ròi quy luật:*
*1. Toàn bộ quân lính nằm trong `pattern` phải lòi mặt đủ quân số trong `query`, và bám **chính xác trật tự y hệt**.*
*2. Bất cứ tên lính đánh thuê dôi dư (ký tự vãng lai) nào chui lọt trong `query` mà cái `pattern` không hề tuyển gắt gao thì **CHẮC CHẮN PHẢI LÀ CHỮ IN THƯỜNG (LOWERCASE)**. Giả dụ câu hỏi tòi ra một gã CHỮ HOA bự chảng khê nặc mà cái mẫu không kêu gọi, vụ hợp đồng vặn rã lồng đổ máu thất bại lập tức `false`!*

---

## 2. Strategy 1: Naive (Regex Engine)
## *2. Chiến lược 1: Ngây thơ (Cưa Cột Biểu thức Chính quy Regex)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to literally interpret the rule "insert lowercase anywhere" by dynamically constructing a Regular Expression (Regex).
If the pattern is `FB`, we generate a regex like `^[a-z]*F[a-z]*B[a-z]*$`. Then we simply feed every query into `query.matches(regex)`.
*Ý tưởng bồng bột: Biểu diễn máy đánh chữ quy chuẩn rập khuôn "Nhét chữ nhỏ bất kể đâu" bằng công cụ rèn chữ Biểu Thức Chính Quy (Tiếng Anh: Regex).*
*Giả sử mẫu khuôn là `FB`, ta đẻ ra đoạn Regex ảo là `^[a-z]*F[a-z]*B[a-z]*$`. Rồi ta quăng thẳng tay mọi đứa câu hỏi vào mồm cỗ máy `query.matches(regex)` để chờ kết quả.*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatchNaive(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        // Định dạng Regex: Trước, giữa và sau mỗi chữ được phép là dãy kí tự thường [a-z]*
        StringBuilder regexBuilder = new StringBuilder("^[a-z]*");
        for (char c : pattern.toCharArray()) {
            regexBuilder.append(c).append("[a-z]*");
        }
        regexBuilder.append("$");
        String regex = regexBuilder.toString();
        
        for (String q : queries) {
            ans.add(q.matches(regex));
        }
        return ans;
    }
}
```

- **Weakness (Điểm yếu):** While conceptually elegant, using a heavy Regex Engine under the hood compiles complex finite automata state machines behind the scenes. It's incredibly heavyweight and mathematically much slower than simple raw array character comparisons. Also introduces unnecessary syntax escaping risks if dealing with non-alphabetics. 
  *Trông bộ giáp này bóng láng thẩm mỹ đấy, nhưng Cỗ Máy Regex dưới hệ điều hành sẽ phải tốn công vật lộn đẻ ra máy trạng thái (Automata Finite State Machine) nặng trịch lù lù! Tốc độ chạy toán học bị bóp chẹt so với so sánh chuỗi thô (mảng ký tự) truyền thống cực kỳ nhiều. Lại còn hay bị gậy ông đập lưng ông nếu có ký tự lạ không lường.*

---

## 3. Strategy 2: Optimal (Two Pointers)
## *3. Chiến lược 2: Tối ưu (Hai Con Trỏ Lái Song Song)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

We just deploy basic Two Pointers (`i` on query, `j` on pattern). We iterate `i` through the query:
- If `query[i] == pattern[j]`, great! The characters matched! We advance both `i` and `j`. (Be careful not to overflow `j` beyond pattern length).
- If they don't match, this `query[i]` MUST be an extra character. According to the strict rules, any extra character **must** be lowercase:
  - If it's explicitly lowercase (`Character.isLowerCase()`), we simply ignore it and move `i` forward (skip extra lowercase).
  - If it's notoriously UPPERCASE, it violated the golden rule! Immediate mismatch `return false`.
- Finally, after completely traversing the query, we check if `j` managed to successfully reach the very end of the pattern (`j == pattern.length()`). If it did, it signifies we found all required pattern chars. If not, the query was missing core parts.
*Ta chỉ việc xuất chinh chiêu thức cơ bản Hai Con Trỏ (`i` lướt màn chữ Câu hỏi, `j` nín thở dòm Chữ Mẫu). Ta thả trỏ `i` trượt cạn qua từng con chữ trong mảng câu hỏi:*
*- Lỡ may `query[i] == pattern[j]`, LÊN ĐỈNH! Khớp nhau rồi! Ta kéo tuột tay cả 2 con `i` và `j` bò tới dòng chữ tiếp theo ăn mừng. (Lưu ý né rào khỏi tràn độ dài mảng `j`).*
*- Khác mọt chữ (không khớp), thì con `query[i]` CHỈ LÀ PHẦN THỪA dăm ba cọng rác. Chiếu theo Mệnh lệnh Luật: Bất kể cọng rác nào dư **LUÔN ĐƯỢC ÉP LÀ CHỮ THƯỜNG**:*
  *- Phát hiện mặt mũi nó Tý hon Thường (`isLowerCase()`), tặc lưỡi bỏ qua, giục con `i` múc qua chậu mới (vượt chữ thừa).*
  *- Lật mặt Thấy nó In Hoa Sừng Sững (`UPPERCASE`), Vi Phạm Nội Quy Cốt Tử! Dập dao chém đứt luôn kết quả `return false` tắp lự.*
*- Kết án: Rảo bộ chán chê qua rào Lời câu hỏi, ngoái đầu trỏ ngó xem con `j` của mẫu có vác cái thân qua tới mốc cuối đường không (`j == pattern.length()`)? Qua lọt 100% thì báo tin vui, rụng đuôi thì mếu!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }
        
        return result;
    }
    
    private boolean isMatch(String query, String pattern) {
        int patternIndex = 0;
        int patternLen = pattern.length();
        
        for (char c : query.toCharArray()) {
            // NẾU CÓ TRÙNG: Đi đôi Con trỏ `pattern` thong dong 1 nấc lấn bước
            if (patternIndex < patternLen && c == pattern.charAt(patternIndex)) {
                patternIndex++;
            } 
            // NẾU LỆCH PHA LỆCH SÓNG: Kẻ lậu vé này BẮT BUỘC có thân thế In Hoa? -> Chém!
            else if (Character.isUpperCase(c)) {
                return false; 
            }
            // Còn nếu nó chữ nhỏ li ti (Lower), ta mặc nhiên Ỉm Bỏ Bước Qua không thèm hỏi
        }
        
        // Hoàn cảnh trớ trêu: Hết câu hỏi mà pattern chưa chạy hết vòng thì là Thiếu Đuôi, Chết dở
        return patternIndex == patternLen;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(Q \times L)$ where $Q$ is the number of queries mapping and $L$ is the maximum length string literal belonging to a single query. We just do exactly one single forward manual string scanning pass independently evaluating each character against its pattern index peer pointer. Supersonic hardware bounds $O(N)$ total characters.
    *   **Độ phức tạp thời gian:** $O(Q \times L)$ trong đó $Q$ nôm na là đại lượng lượng chùm câu hỏi cộm lên và $L$ chiều dài căng sức của câu mồi. Chẳng làm gì hơn ngoài rà duy nhất Một Cú Máy Dò kim loại thẳng tiến. Nôm na là bằng $O(N)$ tống kết ký tự cực xát và láng mịn như nhung.*
*   **Space Complexity:** $O(Q)$. The only dynamic memory allocated belongs to the returning explicitly demanded output `List<Boolean>` size identical mathematically to exactly identically count queries! In-place logical checks bypass allocation entirely locally.
    *   **Độ phức tạp không gian:** $O(Q)$. Vùng tĩnh trân duy nhất trích nhựa ra nằm ở tờ Khai Báo Cáo Buổi Sinh Hoạt `List<Boolean>` chôn gốc bắt buộc trùng khớp lượng Câu trạm xét $Q$! Bản thân cái cưa lốc toán logic check tại gốc cắt tuyệt đối Cấp Mảng Phụ. Xoắn ngôi $O(1)$ chóp Phụ trợ!*

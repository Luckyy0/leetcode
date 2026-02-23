# Analysis for Word Pattern
# *Phân tích cho bài toán Mẫu Từ*

## 1. Problem Essence & Bijection
## *1. Bản chất vấn đề & Song ánh*

### The Requirement
### *Yêu cầu*
Pattern: `char` -> `word`.
Bijection:
1.  Every distinct `char` maps to a distinct `word`.
2.  Every distinct `word` maps back to that distinct `char`.
3.  Lengths must match (number of chars vs number of words).

### Strategy: Two Maps or One Map + Value Set
### *Chiến lược: Hai Map hoặc Một Map + Value Set*
1.  Split `s` into `words`.
2.  Check `pattern.length == words.length`.
3.  Iterate `i`:
    - `c = pattern[i]`. `w = words[i]`.
    - Check if `c` is mapped.
        - If yes: `map.get(c)` MUST equal `w`. Else False.
    - Check if `c` is NOT mapped.
        - Does `w` already exist as a value? (Reverse check).
        - If yes: False (Two chars map to same word).
        - Else: `map.put(c, w)`.

### Optimized Strategy: Single Map of Objects
### *Chiến lược Tối ưu: Một Map các Đối tượng*
Use a single Map `<Object, Integer>` storing the *last index* seen.
Put `c` and `w` into map.
Returns previous value.
If `map.put(c, i) != map.put(w, i)`, then pattern doesn't match?
Wait. Keys might collide if we don't distinguish types (e.g. 'a' char vs "a" string).
Better: Two Maps logic is clearest.

---

## 2. Approach: HashMap and HashSet
## *2. Hướng tiếp cận: HashMap và HashSet*

### Logic
### *Logic*
1.  Split string `s`. Length check.
2.  `Map<Character, String> charToWord`.
3.  `Set<String> usedWords` (or `Map<String, Character>`).
4.  Loop:
    - If `charToWord` has `c`: check value.
    - Else: Check if `usedWords` has `w`. If yes -> False. Else add to map and set.
5.  All good -> True.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Explicit Mapping:** Tracks the 1-to-1 relationship strictly.
    *Ánh xạ rõ ràng: Theo dõi chặt chẽ mối quan hệ 1-1.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where N is string length (splitting + hashing).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(M)$ unique words.
    *Độ phức tạp không gian: $O(M)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "abba", "dog cat cat dog"
1.  a -> dog. Map: `{a:dog}`, Set: `{dog}`.
2.  b -> cat. Map: `{a:dog, b:cat}`, Set: `{dog, cat}`.
3.  b -> cat. Map has b. Value "cat" == "cat". OK.
4.  a -> dog. Map has a. Value "dog" == "dog". OK.
True.

**Input:** "abba", "dog cat cat fish"
...
4.  a -> fish. Map has a. Value "dog" != "fish". False.

**Input:** "abba", "dog dog dog dog"
1.  a -> dog. Map: `{a:dog}`, Set: `{dog}`.
2.  b -> dog. Map no b. Set HAS "dog". False. (Cannot map 'b' to 'dog', 'a' already took it).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard bijection check using Map + Set (or two Maps).
*Kiểm tra song ánh tiêu chuẩn dùng Map + Set (hoặc hai Map).*
---
*Một mối quan hệ bền vững (pattern) đòi hỏi sự trung thành từ cả hai phía (bijection). Không ai được bắt cá hai tay.*
A lasting relationship (pattern) requires loyalty from both sides (bijection). No one should play both sides.

# Analysis for Unique Word Abbreviation
# *Phân tích cho bài toán Viết tắt Từ Duy nhất*

## 1. Problem Essence & HashMap
## *1. Bản chất vấn đề & HashMap*

### The Abbreviation Logic
### *Logic Viết tắt*
- Length $\le 2$: `s` itself.
- Length $> 2$: `s[0] + (len-2) + s[len-1]`.

### The "Unique" Definition
### *Định nghĩa "Duy nhất"*
Valid if:
1.  Abbr NOT in dictionary.
2.  Abbr IN dictionary, BUT only associated with `word` itself (no other words share it).

Example "cake" (c2e) in dict.
- Query "cake": True (Only "cake" maps to c2e).
- Query "cane": False ("cake" maps to c2e, and "cane" != "cake").
Example "deer", "door" (both d2r).
- Query "deer": False (Because "door" also maps to d2r).

### Strategy: Map Abbr -> Set of Words? Or Boolean?
### *Chiến lược: Ánh xạ Abbr -> Tập hợp từ? Hay Boolean?*
We need to know if *other* words map to the *same* abbr.
Map `String (abbr) -> String (word)`.
- If we see a new abbr, store the word.
- If we see an existing abbr, check if the stored word is the same.
    - If same: Do nothing.
    - If different: Mark as "collision" (e.g., store empty string or special value).

Wait, the input dictionary might contain duplicates? "a", "a".
If dict has `["a", "a"]`, query "a" -> is unique? Yes.
So we should probably store a Set of words for each abbr, OR simplify.
If `map` stores the *first* word encountered. If a *different* word comes with same abbr, mark as Invalid (e.g., "").
If same word comes again, ignore.

---

## 2. Approach: HashMap of Abbr to Word
## *2. Hướng tiếp cận: HashMap của Abbr sang Word*

### Logic
### *Logic*
1.  `Map<String, String> map`.
2.  Constructor: Iterate dictionary.
    - `a = abbr(s)`.
    - If `a` not in map: `map.put(a, s)`.
    - Else: If `map.get(a)` != `s`, put `map.put(a, "")` (Collision marker).
3.  `isUnique(word)`:
    - `a = abbr(word)`.
    - If `!map.containsKey(a)`: Return True.
    - Else: Return `map.get(a).equals(word)`. (If it was collision "", equals falls. If it was same word, returns true).

### Edge Case
### *Trường hợp biên*
Dict: `["a", "a"]`. Word: `"a"`.
- 1st "a": map put "a" -> "a".
- 2nd "a": map get "a" is "a", equals. Do nothing.
- Query "a": map get "a" is "a". Return true. Correct.

Dict: `["a", "b"]`. (Both abbr "a", "b" -> length 1 -> themselves? Wait definition says len-2. So "a" -> "a").
- 1st "a": put "a"->"a".
- 2nd "b": put "b"->"b".
Query "c": True.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fast Lookup:** $O(1)$ average time.
*   **Collision Handling:** Simplified to a single string check.
    *Tra cứu nhanh: Thời gian trung bình O(1). Xử lý va chạm: Đơn giản hóa thành kiểm tra chuỗi đơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Constructor $O(N \cdot L)$, `isUnique` $O(L)$.
    *Độ phức tạp thời gian: Constructor O(N \cdot L).*
*   **Space Complexity:** $O(N \cdot L)$.
    *Độ phức tạp không gian: O(N \cdot L).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Dict:** `["deer", "door", "cake", "card"]`
- "deer" -> "d2r". Map: `{"d2r": "deer"}`.
- "door" -> "d2r". Collision! "door" != "deer". Map: `{"d2r": ""}`.
- "cake" -> "c2e". Map: `{"d2r": "", "c2e": "cake"}`.
- "card" -> "c2d". Map: `{"d2r": "", "c2e": "cake", "c2d": "card"}`.

**Query:**
- "dear" -> "d2r". Map gets "". `"" != "dear"`. False.
- "cart" -> "c2t". Not in map. True.
- "cane" -> "c2e". Map gets "cake". `"cake" != "cane"`. False.
- "make" -> "m2e". Not in map. True.
- "cake" -> "c2e". Map gets "cake". `"cake" == "cake"`. True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Straightforward Hash Map application.
*Ứng dụng Hash Map trực tiếp.*
---
*Sự độc đáo (Unique) không chỉ là sự khác biệt hoàn toàn (không ai giống mình), mà còn là sự duy nhất trong chính nhóm định danh của mình.*
Uniqueness is not just complete difference (no one like me), but also being the sole entity within one's own identity group.

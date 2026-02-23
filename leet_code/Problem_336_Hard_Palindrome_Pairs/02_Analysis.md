# Analysis for Palindrome Pairs
# *Phân tích cho bài toán Cặp Palindrome*

## 1. Problem Essence & String Matching
## *1. Bản chất vấn đề & Khớp Chuỗi*

### The Challenge
### *Thách thức*
Concatenate $A + B$. Palindrome check is slow. $O(N^2 \cdot L)$ is too slow (5000^2 * 300).
We need something closer to $O(N \cdot L^2)$.

### Strategy: Hash Map + Suffix/Prefix Check
### *Chiến lược: Hash Map + Kiểm tra Hậu tố/Tiền tố*
Put all words in Map `word -> index`.
For each word `w`:
Split `w` into `L + R`.
1.  If `L` is palindrome, find `reverse(R)` in map.
    If found at `j` (and `j != i`): `(j, i)` is candidate?
    Wait. `reverse(R) + L + R`. Since `L` is Pal, `L = rev(L)`.
    `rev(R) + L + R`. Check reverse: `rev(R) + rev(L) + R`. Matches?
    Condition: `L` is palindrome. We look for word `X = reverse(R)`.
    Then `X + w` = `rev(R) + (L + R)`.
    Reverse is `rev(L+R) + rev(rev(R)) = rev(R) + rev(L) + R`.
    Since `rev(L) == L`, they are equal.
    So, if `L` is palindrome: `(map.get(rev(R)), i)` is valid.
2.  If `R` is palindrome, find `reverse(L)` in map.
    Let `X = reverse(L)`.
    Then `w + X` = `(L + R) + rev(L)`.
    Reverse is `rev(rev(L)) + rev(L+R) = L + rev(R) + rev(L)`.
    Since `rev(R) == R`, they are equal.
    So, if `R` is palindrome: `(i, map.get(rev(L)))` is valid.

### Edge Cases
### *Trường hợp góc*
- Empty string: If `""` exists, it pairs with any Palindrome `P`.
  `P + ""` works. `"" + P` works.
  Our logic handles this?
  Split `P`: L="", R="P". L is Pal. Find `rev(R)=rev(P)=P` (not useful).
  Split `P`: L="P", R="". R is Pal. Find `rev(L)=rev(P)`. If `rev(P)` exists.
  Wait. If `""` is in map.
  Using `w=""`. L="", R="". L pal -> find `rev("")` -> finds itself. `i!=j` prevents self-pair.
  Using `w="aba"`.
  L="", R="aba". `L` Pal. Find `rev("aba")`="aba".
  L="aba", R="". `R` Pal. Find `rev("aba")`.
  This logic requires iteration over all possible splits (0 to length).
  Need to handle `L.length=0` and `R.length=0` carefully to avoid duplicates.
  Usually iterate `k` from 0 to `len`.
  `str1 = w.substring(0, k)`, `str2 = w.substring(k)`.
  If `isPal(str1)`: find `rev(str2)`. If exists `j`, add `(j, i)`.
  If `isPal(str2)`: find `rev(str1)`. If exists `j`, add `(i, j)`.
  Avoid duplicate for empty split (k=0 vs k=len).
  Only run strict `k=0` on one branch or filter. But `map.get` returns index.
  If matching `""` (index `emptyIdx`):
  k=0: `str1=""`, `str2="aba"`. `isPal("")`->True. Find `rev("aba")` ("aba"? No "aba" isn't in map usually, unless palindrome... wait).
  Example: `w="aba"`, `map={"aba":0, "":1}`.
  k=0: s1="", s2="aba". s1 Pal. Find `rev(aba)`="aba" (idx 0). Pair `(0, 0)` skip (`i!=j`).
  k=3: s1="aba", s2="". s2 Pal. Find `rev("aba")`="aba". Pair `(0, 0)` skip.
  We need to find `""` (idx 1).
  If `w="aba"`.
  k=0: s1="", s2="aba". s1 Pal. Find `rev("aba")`... this requires "aba" to be in map.
  Wait. We look for word that IS `rev(str2)`.
  We want `X + w` or `w + X`.
  If `w="aba"`, `map` has `""`.
  k=0: s1="", s2="aba". s1 Pal. Target: `rev("aba")="aba"`. Not `""`.
  k=3: s1="aba", s2="". s2 Pal. Target: `rev("aba")="aba"`. Not `""`.
  It seems checking `rev(s2)` or `rev(s1)` finds non-empty matches.
  What about `""`?
  `w=""`.
  k=0: s1="", s2="". s1 Pal. Find `rev("")`="". Match `""`. Skip self.
  To find `"" + "aba"`:
  Process `w="aba"`.
  It seems we should look for `rev(s2)` if `s1` is Pal. (Yields `X + w`).
  Find `rev(s1)` if `s2` is Pal. (Yields `w + X`).
  If `w="aba"`.
  Case 2: s2="" is Pal. Target `rev("aba")`. No.
  Case 1: s1="" is Pal. Target `rev("aba")`. No.
  We seem to miss `""`.
  Ah. `rev(s1)` where `s1="aba"` is "aba".
  Does `map` contain "aba"? Yes idx 0.
  So `(0, 0)` skip.
  Where does `""` come in?
  If `w=""`. s1="", s2="".
  Loop `w="aba"`.
  k=0: s1="", s2="aba". s1 Pal. Target `rev("aba")`.
  k=3: s1="aba", s2="". s2 Pal. Target `rev("aba")`.
  Wait. I logic flawed.
  Word `w="ssl"`. Split `ss`, `l`. `ss` Pal. Target `rev("l")="l"`. Map has "l" (idx 5). Pair `(5, 0)`. `lssl`. Correct.
  Word `w="lss"`. Split `l`, `ss`. `ss` Pal. Target `rev("l")=l`. Map has "l". Pair `(0, 5)`. `lssl`? No `w+X`. `lss` + `l` = `lssl`.
  Okay.
  What about `""`?
  `w="aba"`.
  Split `aba`, ``. s2 Pal. Target `rev("aba")`. Map has "aba". Self.
  Split ``, `aba`. s1 Pal. Target `rev("aba")`. Map has "aba". Self.
  Wait. `""` is index 1.
  When processing `w=""`:
  s1="", s2="".
  If map has `"aba"`, `rev("") = ""`. Just finds itself.
  When processing `w="aba"`:
  We check splits.
  But we need to find `""` index.
  `rev(s2)` where `s2` is `aba`. `rev` is `aba`.
  `rev(s1)` where `s1` is `aba`. `rev` is `aba`.
  It seems `""` is special case?
  Or: `str1` and `str2`.
  If `str2` empty, `str1="aba"`. `str2=""` (Pal). Target `rev("aba")`.
  If `str1` empty, `str1=""` (Pal). `str2="aba"`. Target `rev("aba")`.
  This doesn't find `""`!
  Ah. `aba` + `""` = `aba`. Only Pal if `aba` is Pal.
  If `aba` is Pal, then pairing with `""` is valid.
  So if `w` is Pal, and `""` exists, add both `(w, "")` and `("", w)`.
  My general logic:
  If `s2=""`. `s2` is Pal. Target `rev(s1)`.
  If `w="aba"`. s1="aba", s2="". Target `rev("aba")`.
  This finds OTHER words that equal `rev("aba")`.
  It doesn't find `""`.
  To find `""`, we need target to be `""`.
  This implies `rev(s1) == ""` => `s1 == ""`.
  So `s1=""`. And `s2="aba"`.
  If `s2` is Pal (is `aba` Pal? Yes). Then Target `rev(s1)==""`.
  Yes! `map.get("")` exists. So `(i, emptyIdx)` is added. `aba` + `""`.
  Also `s1=""` is Pal. Target `rev(s2)="aba"`. (Finds other `aba`).
  Wait. `s1` is Pal? Yes. Target `rev(s2)`.
  If `s1=""`, `s2="aba"`. `s1` Pal. Target `rev("aba")`.
  I need to check `s2` Pal to add `(i, emptyIdx)`.
  I need to check `s1` Pal to add `(emptyIdx, i)`.
  Correct.
  Just ensure `k` ranges from `0` to `len` (inclusive of empty parts).
  And avoid duplicate pairs if logic covers both.
  Usually iterate `k=0` to `len`. `s1=[0,k)`, `s2=[k, len)`.
  k=0: s1="", s2="full".
  k=len: s1="full", s2="".
  Valid.

---

## 2. Approach: HashMap Iteration
## *2. Hướng tiếp cận: Duyệt HashMap*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** Check splits ($O(L)$) instead of all pairs ($O(N)$). Total $O(N \cdot L^2)$.
    *Hiệu quả: Kiểm tra phân tách ($O(L)$) thay vì tất cả các cặp ($O(N)$).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L^2)$.
    *Độ phức tạp thời gian: $O(N \cdot L^2)$.*
*   **Space Complexity:** $O(N \cdot L)$.
    *Độ phức tạp không gian: $O(N \cdot L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["abcd", "dcba"]`
Map: `abcd:0, dcba:1`.
1. `w="abcd"`.
   k=0: s1="", s2="abcd". s1 Pal. Target `rev("abcd")="dcba"`. Found idx 1. Pair (1, 0). ("dcba"+"abcd").
   k=1: "a", "bcd". s1 Pal. Tgt "dcb". No.
   ...
   k=4: "abcd", "". s2 Pal. Tgt "dcba". Found idx 1. Pair (0, 1). ("abcd"+"dcba").
All found.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap + Split Logic.
*HashMap + Logic Phân tách.*
---
*Đôi khi để tìm được một nửa hoàn hảo (palindrome pair), ta phải tự chia cắt bản thân (split) thành nhiều mảnh và tìm kiếm những mảnh ghép tương thích (reverse match) từ người khác.*
Sometimes to find a perfect half (palindrome pair), we have to split ourselves into pieces and look for compatible fragments (reverse match) from others.

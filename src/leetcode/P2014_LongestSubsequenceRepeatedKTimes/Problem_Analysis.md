# Problem Analysis: Longest Subsequence Repeated k Times

## Problem Description
String `s`, int `k`.
Find longest subsequence of `s` that appears at least `k` times.
If multiple same length, lexicographically largest.
Note: Constraints `s.length` 16000. `k` ?
BUT "n < k * 8" -> length of result is small? No.
Actually constraints: "s contains only lowercase English letters".
Small alphabet. Result length?
Key constraint: `n < k * 8`? No.
Constraints: `n <= 16000`. `k <= 2000`.
But usually result length is small because if a char appears < k times, it can't be used.
Chars appearing >= k times are few.
If `s` has length N, max occurrences of any char is N.
If we can repeat a subsequence L times, then `L * k <= N`. So length of subsequence is at most `N/k`.
However, `N` up to 16000.
Wait, look at constraints more carefully.
Usually `s` length is small or specific property.
Actually: `n <= 16000`, `k`...
Wait, standard constraints: The length of the longest subsequence is very small (<= 7 usually)?
Wait. If we have 'a' appearing 16000 times, k=2000. 'aaaa...' length 8.
Max length is `16000 / 2000 = 8` if k is large.
If `k` is small? `k=1`. Then whole string.
Actually `k` constraint might be specific. But generally `N` is small or `k` is large relative to potential length.
Let's check "Longest Subsequence Repeated k Times" constraints on LeetCode. Usually limit length $\approx 7$.
Why? 26 chars. We can BFS generate subsequences.
Level 1: single chars with count >= k.
Level 2: append chars, check if subseq exists k times.
Since we want Lexicographically Largest, we can traverse/BFS. BFS gives shortest? No, we prioritize length.
We want MAX length. BFS layer by layer gives length 1, 2, ...
We want Lexicographically largest for max length.
So explore length 1, then length 2...
At each level, keep only valid subsequences.
There are not many valid subsequences because valid subsequences are "dense" in occurrences.
Algorithm:
1. Count frequency of each char. Keep chars with freq >= k.
2. BFS: Queue of strings. Initially empty string.
3. Try appending each valid char. Check if new string is a subsequence of `s` repeat k times.
4. "Subsequence `sub` repeated k times": Does `sub` appear k times disjointly?
   No. "Subsequence repeated k times" usually means `sub` is a subsequence of `s`, and `sub` can be formed `k` times?
   Actually "Find the longest subsequence of s that appears at least k times".
   Usually means: can we find `sub` as a subsequence in `s` such that if we removed the characters used, we could finding it again...?
   No. "A string `sub` is a subsequence repeated `k` times if `sub` concatenated `k` times is a subsequence of `s`".
   Example: s = "letsleet", k=2. "let" -> "letlet" in s?
   "let" indices: 0,1,2. "let" indices: 4,5,6.
   So yes. It is equivalent to checking if `sub * k` is a subsequence of `s`.
   Max length of `sub` is `N / k`.
   With `N=16000`. If `k` is small, `sub` can be long?
   Actually, problem constraints usually ensure `sub` length is small (<= 7). It is a known property of this specific LeetCode problem (constraints on N or chars make it small). Usually N is around 16000 but the "hot" characters are limited.
   Wait, if k=1, ans is `s`. Length 16000.
   But checking if `sub` is subsequence takes `O(N)`.
   If we generate all subsequences, too many.
   The constraint "length < 8" is usually derived or stated.
   Ah, maybe `k` is large enough?
   Or characters with freq >= k are few.
   Let's assume BFS.
   Check: `check(sub)`: iterate `s` and match `sub` k times. Or just match one `sub` repeatedly.
   Wait, does "subsequence repeated k times" mean `sub` is a subsequence? No.
   It means `sub` concatenated `k` times is a subsequence.
   Correct.
   We perform BFS. Queue of valid `sub`.
   In BFS, propagate `current_string`. Append 26 chars. Check valid.
   Since we want Lexicographically largest for max length, maybe keep tracking best found.
   Does search space explode?
   If result has length 7, $26^7$ is big.
   But we prune those that can't be formed repeated k times.

## Implementation Details
-   `check(String sub, int k)`: checks if `sub` repeated k times is subseq of `s`.
-   BFS.

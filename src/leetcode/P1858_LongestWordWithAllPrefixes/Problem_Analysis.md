# Problem Analysis: Longest Word With All Prefixes

## Problem Description
String array `words`.
Find longest word such that all its prefixes are present in `words`.
Lexicographically smallest tie-breaker.

## Analysis

1.  **Trie / Set**:
    -   Insert all words into Set.
    -   Sort words (length desc, lex asc)?? Or just iterate.
    -   Or use Trie.
        -   Insert all. mark `isEnd`.
        -   DFS on Trie.
        -   Only traverse edge if child node `isEnd` is true.
        -   Track depth.
    -   DFS is cleaner.
    -   Or Check Logic:
        -   Filter words: A word is valid if for every prefix length `1..len-1`, the substring exists.
        -   Sort words by length? Or just iterate all and check.
        -   Checking takes `len` cost. Total `sum(len)`.
        -   Set approach:
            -   Valid words set. Initialize with empty string? No.
            -   Sort words by length.
            -   Iterate. If `word.substring(0, len-1)` is in valid_set (or empty), add word to valid_set. Update max len.
            -   Must handle lexicographical. Sort: length ASC, but logic needs prefix available.
            -   Prefix is shorter. So sorting by length ASC means we always process prefix before word.
            -   If prefix in set, add current.

2.  **Implementation**:
    -   `res = ""`
    -   Sort words.
    -   `Set<String> valid`. `valid.add("")`.
    -   Loop words.
    -   `parent = word.sub(0, len-1)`.
    -   if `valid.contains(parent)`:
        -   `valid.add(word)`.
        -   Update `res` (check length and lex).

## Implementation Details
-   Sort. Set.

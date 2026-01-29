# Problem Analysis: Maximum Font to Fit a Sentence in a Screen

## Problem Description
Given a `text` string, `w, h` (screen dimensions), and `fonts` (integer array of font sizes).
Also given `FontInfo` interface:
-   `getHeight(int fontSize)`
-   `getWidth(int fontSize, char c)`
Find the largest font size from `fonts` such that `text` fits in the screen. If none, return -1.

## Analysis

1.  **Monotonicity**:
    -   Larger fonts take more space. If a font fits, all smaller fonts fit. If it doesn't fit, all larger fonts fail.
    -   Use Binary Search on indices of `fonts`.

2.  **Fitting Logic**:
    -   To check if `text` fits with `fontSize`:
        -   Get `rowHeight = getHeight(fontSize)`.
        -   If `rowHeight > h`, fail.
        -   Simulate word wrapping.
        -   Split `text` into words (assuming space delimiter? Problem says "a sentence", "contains multiple words"). Usually this implies simple space separation? Actually, the width of a character counts. The problem usually doesn't specify wrapping by word, but typically "Fit a Sentence" implies typical text layout. However, common variations exist.
        -   Assuming standard word wrapping: We can break lines only at spaces? Or character wrapping? The LeetCode problem "Sentence Screen Fitting" (P418) allows breaking at spaces. Usually P1618 is "Maximum Font to Fit a Sentence...". Constraints say "sentences".
        -   Wait, standard logic: We place character by character. If width exceeds W, move to next line? No, usually valid word wrapping avoids breaking words.
        -   Let's assume "word wrapping" (can't break words).
        -   Width calculation: iterate words.
        -   `currentLineWidth`.
        -   For `word` in `words`:
            -   Calculate `wordWidth`.
            -   If `wordWidth > w`: return false (word too long for single line).
            -   If `currentLineWidth + wordWidth <= w`: add to line. `currentLineWidth += wordWidth`.
            -   Else (needs new line): `lines++`. `currentLineWidth = wordWidth`. Initialize new line.
            -   Note: Spaces. Usually need to add space width between words.
    -   Checking total lines: `if lines * rowHeight <= h` return true.

3.  **Complexity**:
    -   Binary Search: $O(\log F)$.
    -   Check: $O(N)$ (N = text length or num words).
    -   Total: $O(N \log F)$.

## Implementation Details
-   Need `FontInfo` mock for compilation? Usually I define interface.
-   Assume `text` single spaces.
-   Be careful with initial line count (1).

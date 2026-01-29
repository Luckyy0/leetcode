# Problem Analysis: Number of Valid Words in a Sentence

## Problem Description
String `sentence`. Split by space.
Valid word:
-   Only lowercase, hyphens, punctuation ('!', '.', ',').
-   No digits.
-   At most one hyphen. If present, must be surrounded by letters.
-   At most one punctuation. If present, must be at END of token.

## Analysis

1.  **Regex / Manual Check**:
    -   Split by space. Skip empty tokens.
    -   For each token, validate rules.
    -   Rule breakdown:
        1.  Start/End: check chars.
        2.  Hyphen count <= 1. Punctuation count <= 1.
        3.  Hyphen check: index `i`. `i > 0` and `i < len-1`. `token[i-1]` is letter, `token[i+1]` is letter.
        4.  Punctuation check: index `i`. `i == len-1`.
        5.  No digits.

## Implementation Details
-   Loop tokens.

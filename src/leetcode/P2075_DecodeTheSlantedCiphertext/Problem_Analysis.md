# Problem Analysis: Decode the Slanted Ciphertext

## Problem Description
Encoded string `encodedText`. Rows `rows`.
Grid dimensions: `rows` x `cols`. Total chars = `rows * cols`.
`encodedText` fills grid row by row.
Decoded text: Start (0, 0). Move (r+1, c+1) diagonal to right.
Wrap around? No, "The matrix is slanted...".
Usually start (0, 0), (1, 1)... (r, r)...
But text continues?
Wait, "Original text" is placed in a matrix.
"Encoded text" is reading row-by-row.
"Slanted Ciphertext": Reading starts at top-left, goes diagonal down-right `(r+1, c+1)`.
When hitting bottom, does it wrap?
Problem says: "You need to decode it".
Wait. The "original text" characters are placed... ONE char per cell?
Yes.
Usually implies:
Reading logic: Start `(0, 0)`. Then `(0, 1)` ?
Original text -> Matrix -> Encoded (row-by-row).
Matrix filled by... original text?
Re-read: "Original text... placed...".
Usually:
1. Matrix is `rows` x `cols`.
2. Original text filled... how?
   - "in a slanted way"? No.
   - Wait. Diagram shows:
   - Original "I love LeetCode"
   - Matrix filled... row by row? No.
   - Encoded is row by row.
   - So Original must be along diagonals!
   - (0, 0), (1, 1), (2, 2)... when bottom reached -> next diagonal starting at (0, 1)?
   - "Indices (row, col) as follows: (0,0), (1,1)... then ... (0,1), (1,2)..."
   - So OriginalText = M[0][0] + M[1][1]... + M[0][1] + M[1][2]...
   - EncodedText = M[0][0] + M[0][1]... + M[1][0]...
   - We are given EncodedText. We construct Matrix.
   - Then traverse Diagonals to get Original.
   - Finally remove trailing spaces.

## Analysis

1.  **Reconstruction**:
    -   Length `L`. `cols = L / rows`.
    -   To read Original:
    -   Loop `start_col` from 0 to `cols - 1`.
    -   Loop `r` from 0 to `rows - 1`. `c = start_col + r`.
    -   If `c >= cols` break diagonal?
    -   Index in Encoded (which is linear mapping of matrix): `r * cols + c`.
    -   Append char.
    -   Trailing spaces removal (right trim).

## Implementation Details
-   StringBuilder.
-   Trim Right.

# Problem Analysis: Design Authentication Manager

## Problem Description
Tokens. `timeToLive`.
`generate(tokenId, currentTime)`.
`renew(tokenId, currentTime)`: updates expiry if token exists and not expired.
`countUnexpiredTokens(currentTime)`.

## Analysis

1.  **HashMap**:
    -   Map `tokenId -> expiryTime`.
    -   Expiry = creation/renewal time + timeToLive.
    -   `generate`: put.
    -   `renew`: get. If > currentTime, update.
    -   `count`: Iterate values. If > currentTime, count. (Can optimize with cleanup?)
    -   Constraints usually allow $O(N)$ for count if N small, or lazy removal.
    -   Given constraints (calls), iteration is fine if map isn't huge.

2.  **Cleanup**:
    -   Remove expired tokens during count? Or just ignore.
    -   Simply map logic.

## Implementation Details
-   `Map<String, Integer> expiry`.

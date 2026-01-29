# Problem Analysis: Ad-Free Sessions

## Problem Description
Table `Playback` (session_id, customer_id, start_time, end_time).
Table `Ads` (ad_id, customer_id, timestamp).
Return all sessions that did not show any ads.
An ad is shown if `timestamp` is within `[start_time, end_time]` for same customer.

## Analysis

1.  **Anti-Join**:
    -   Find sessions where EXISTS an ad.
    -   Select sessions NOT IN that set.
    -   Or `LEFT JOIN` Ads on matching criteria, filter where `ad_id` is NULL.

## Implementation Details
-   SQL.

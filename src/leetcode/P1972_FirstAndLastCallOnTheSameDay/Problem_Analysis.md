# Problem Analysis: First and Last Call On the Same Day

## Problem Description
Table `Calls` (caller_id, recipient_id, call_time).
Identify users whose first call and last call *on any given day* were with the **same person**.
Actually "whose first and last call of the day are with the same person".
Wait. "Identify the users...". It reports distinct users.
If a user makes calls on multiple days, do they need to satisfy this on ALL days? Or ANY day? or AT LEAST ONE day?
Usually "Write an SQL query to report the user IDs such that...". This implies filtering users who satisfy the condition universally or specifically.
Let's re-read standard problem statement carefully (simulated).
"Report the IDs of the users whose first and last calls on **any** day were with the same person."
This phrasing is ambiguous. It could mean "Show me users u, where there exists a day d, such that first_call(u, d).other == last_call(u, d).other".
Or "Show me users u, where FOR ALL days d they talked, first == last".
Checking LeetCode P1972 title/description...
"First and Last Call On the Same Day".
SQL problem.
Usually: Normalize calls (u, v, t) -> (u, v, t) UNION (v, u, t). Consider participation.
For each user, for each day, find first call/recipient and last call/recipient.
If first_recipient == last_recipient, then user satisfies condition for that day.
The question likely asks for **distinct users** who satisfy this on **at least one day**? Or **every day**? Or simply listing `user_id` for each day?
Usually "Report the user_id".
Let's assume "distinct user_ids who have **at least one day** where first and last calls are with same person".
Wait, recent problems like this often ask for "those whose first and last call on EVERY day they made calls...".
But let's look at the example cases usually.
If a user makes only 1 call on a day, first=last. Same person. Satisfies.
Let's assume "For each day, check condition. Return distinct users who satisfied it on *some* day" is most likely.
However, P1972 is a hard SQL. Maybe "Report all pairs (user_id)?"
Actually, the most consistent interpretation: "Report the IDs of the users whose first and last calls on **any** day were with the same person." -> `DISTINCT user_id`.
BUT, there is a nuance: "Find the users whose first and last call on **all days they made calls** were with the same person" vs "on **any** day".
Given "First and Last Call On the Same Day", I will assume "Report distinct users where on **any single day** (exists day), the first and last recipient are same".
Actually, checking similar problems: usually it's "For each user, find the ...".
Let's implement the "Normalized calls -> Group by User, Day -> Compare Min Time Recipient vs Max Time Recipient -> Filter -> Distinct users".

## Analysis
1.  **Normalize**: (caller, recipient, date) UNION (recipient, caller, date).
2.  **Rank**: For each user, day, rank calls by time to find first and last.
3.  **Compare**: Check if `recipient` of rank 1 == `recipient` of rank N.
4.  **Select**: Distinct users.

## Implementation Details
-   CTE.

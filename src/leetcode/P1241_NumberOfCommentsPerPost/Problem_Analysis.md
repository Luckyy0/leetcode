# 1241. Number of Comments per Post / Số lượng Bình luận cho mỗi Bài đăng

## Problem Description / Mô tả bài toán
Table `Submissions`: `sub_id`, `parent_id`.
If `parent_id` is null, it's a post.
If `parent_id` is not null, it's a comment on that parent.
For each post, count number of unique comments (unique `sub_id` that are comments on this post).
Result: `post_id`, `number_of_comments`.
Ordered by `post_id`.
Note: Comments on comments are not mentioned, assume simple post-comment struct. Or recursive?
"Each row is a unique submission". `parent_id` refers to direct parent.
If `parent_id` is null, it is a post.
We want count of comments for each POST.
Usually LeetCode simple version: comments directly pointing to post.
Or comments pointing to post OR pointing to comment of post?
Problem usually implies simpler model: `parent_id` points to post.
Wait. Let's assume standard requirement: Find only comments whose parent is the post.

Re-checking typical logic for Problem 1241: `parent_id` is null -> Post.
We return `post_id` and count of distinct `sub_id` where `parent_id = post_id`.
Also include posts with 0 comments.
Make sure to handle duplicate entries in table if any (problem says each row is submission, maybe duplicates exist in data dump?). Actually "The table may contain duplicate rows." - DISTINCT is needed.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Self-Join / Left Join
1. Identify Posts: `SELECT DISTINCT sub_id FROM Submissions WHERE parent_id IS NULL`.
2. Left Join with Comments: `Submissions S2 ON S1.sub_id = S2.parent_id`.
3. Count distinct S2.sub_id.

---

package leetcode.P355_DesignTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    /**
     * Problem 355: Design Twitter
     * Approach: OO Design + Heap Merge K Sorted Lists
     * 
     * Time Complexity: O(10 * log F) for getNewsFeed
     * Space Complexity: O(Users + Tweets)
     */
    public static class Twitter {

        private static int timestamp = 0;

        private class Tweet {
            int id;
            int time;
            Tweet next;

            Tweet(int id) {
                this.id = id;
                this.time = timestamp++;
                this.next = null;
            }
        }

        private class User {
            int id;
            Set<Integer> followed;
            Tweet tweetHead;

            User(int id) {
                this.id = id;
                this.followed = new HashSet<>();
                this.followed.add(id); // Follow self
                this.tweetHead = null;
            }

            void post(int id) {
                Tweet t = new Tweet(id);
                t.next = tweetHead;
                tweetHead = t;
            }

            void follow(int id) {
                followed.add(id);
            }

            void unfollow(int id) {
                if (id != this.id) {
                    followed.remove(id);
                }
            }
        }

        private Map<Integer, User> userMap;

        public Twitter() {
            userMap = new HashMap<>();
            // Reset timestamp if static or use instance var?
            // LeetCode creates new instance for each test case, so timestamp should likely
            // be reset or instance var.
            // But problem desc says "Initializes your twitter object".
            // Since timestamp is static, it persists across test cases in local environment
            // if we don't reset.
            // For proper "single run" simulation, static is fine. But better practice:
            // instance var or reset.
            // I'll make timestamp static but note. Actually, let's make it instance.
            // But classes like Tweet need access. Inner classes access instance vars.
        }

        private int time = 0; // Instance timestamp

        // Redefine Tweet to use instance time if needed, or pass it.
        // Or simpler: Tweet stores time.

        private User getUser(int id) {
            if (!userMap.containsKey(id)) {
                userMap.put(id, new User(id));
            }
            return userMap.get(id);
        }

        public void postTweet(int userId, int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.time = this.time++; // Use instance time

            User u = getUser(userId);
            t.next = u.tweetHead;
            u.tweetHead = t;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId))
                return res;

            User u = userMap.get(userId);
            Set<Integer> followedIds = u.followed;

            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

            for (int followeeId : followedIds) {
                if (userMap.containsKey(followeeId)) {
                    Tweet head = userMap.get(followeeId).tweetHead;
                    if (head != null) {
                        pq.offer(head);
                    }
                }
            }

            int n = 0;
            while (!pq.isEmpty() && n < 10) {
                Tweet t = pq.poll();
                res.add(t.id);
                n++;

                if (t.next != null) {
                    pq.offer(t.next);
                }
            }

            return res;
        }

        public void follow(int followerId, int followeeId) {
            User u = getUser(followerId);
            getUser(followeeId); // Ensure followee exists in map?
            u.follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            User u = getUser(followerId);
            u.unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // postTweet(1, 5)
        twitter.postTweet(1, 5);

        // getNewsFeed(1) -> [5]
        System.out.println(twitter.getNewsFeed(1));

        // follow(1, 2)
        twitter.follow(1, 2);

        // postTweet(2, 6)
        twitter.postTweet(2, 6);

        // getNewsFeed(1) -> [6, 5] (6 is newer)
        System.out.println(twitter.getNewsFeed(1));

        // unfollow(1, 2)
        twitter.unfollow(1, 2);

        // getNewsFeed(1) -> [5]
        System.out.println(twitter.getNewsFeed(1));
    }
}

package leetcode.P1348_TweetCountsPerFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TweetCounts {
    private Map<String, List<Integer>> tweets;

    public TweetCounts() {
        tweets = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        tweets.computeIfAbsent(tweetName, k -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = 60;
        if (freq.equals("hour"))
            delta = 3600;
        else if (freq.equals("day"))
            delta = 86400;

        int intervals = (endTime - startTime) / delta + 1;
        int[] counts = new int[intervals];

        List<Integer> times = tweets.get(tweetName);
        if (times != null) {
            for (int t : times) {
                if (t >= startTime && t <= endTime) {
                    int bucket = (t - startTime) / delta;
                    counts[bucket]++;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int c : counts)
            res.add(c);
        return res;
    }
}

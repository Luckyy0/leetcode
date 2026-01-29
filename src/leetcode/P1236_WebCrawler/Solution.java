package leetcode.P1236_WebCrawler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

interface HtmlParser {
    public List<String> getUrls(String url);
}

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        visited.add(startUrl);
        result.add(startUrl);
        q.offer(startUrl);

        while (!q.isEmpty()) {
            String curr = q.poll();
            for (String next : htmlParser.getUrls(curr)) {
                if (!visited.contains(next) && getHostname(next).equals(hostname)) {
                    visited.add(next);
                    result.add(next);
                    q.offer(next);
                }
            }
        }

        return result;
    }

    private String getHostname(String url) {
        // http://hostname/path
        // split by / -> [http:, "", hostname, path...]
        String[] parts = url.split("/");
        return parts[2];
    }
}

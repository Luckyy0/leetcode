package leetcode.P1242_WebCrawlerMultithreaded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

interface HtmlParser {
    public List<String> getUrls(String url);
}

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        // Custom thread pool needed? LeetCode environment might restrict simple
        // threads.
        // Actually simple standard implementation usually works.
        // But need to join threads.

        List<String> currentLevel = new ArrayList<>();
        currentLevel.add(startUrl);

        // Use a fixed thread pool or cached.
        // 64 threads? Or number of available processors?
        ExecutorService executor = Executors.newFixedThreadPool(64);

        while (!currentLevel.isEmpty()) {
            List<String> nextLevel = Collections.synchronizedList(new ArrayList<>());
            List<Runnable> tasks = new ArrayList<>();

            for (String url : currentLevel) {
                tasks.add(() -> {
                    List<String> links = htmlParser.getUrls(url);
                    for (String link : links) {
                        if (getHostname(link).equals(hostname) && visited.add(link)) {
                            nextLevel.add(link);
                        }
                    }
                });
            }

            // Execute all tasks
            // Can use invokeAll if Callable, but Runnable is fine with manual tracking or
            // latch.
            // Using logic manually without future list is tricky with waiting.
            // Best is to use invokeAll on Callables if returning list, or just wait for
            // termination?
            // We can't terminate executor per level.

            // Simplified: Use a Loop with Future or CountDownLatch.
            // Better: Stream parallel? No, HtmlParser might be blocking.

            // Let's use invokeAll with Callable<List<String>> if we want structure,
            // or just submit and track Futures.

            // Actually simpler to just wait?
            try {
                // We must collect from tasks.
                // Re-structure:
                List<java.util.concurrent.Callable<Void>> callables = new ArrayList<>();
                for (String url : currentLevel) {
                    callables.add(() -> {
                        for (String link : htmlParser.getUrls(url)) {
                            if (getHostname(link).equals(hostname) && visited.add(link)) {
                                nextLevel.add(link);
                            }
                        }
                        return null;
                    });
                }
                executor.invokeAll(callables);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            currentLevel = nextLevel;
        }

        executor.shutdown();

        return new ArrayList<>(visited);
    }

    private String getHostname(String url) {
        int idx = url.indexOf('/', 7); // skip http://
        return (idx != -1) ? url.substring(7, idx) : url.substring(7);
    }
}

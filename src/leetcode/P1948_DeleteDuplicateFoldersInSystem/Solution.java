package leetcode.P1948_DeleteDuplicateFoldersInSystem;

import java.util.*;

public class Solution {
    class TrieNode {
        String name;
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted = false;

        TrieNode(String n) {
            name = n;
        }
    }

    Map<String, Integer> serialCount = new HashMap<>();
    // To mark nodes, we might need to store nodes by serial too
    Map<String, List<TrieNode>> serialToNodes = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("/");

        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String p : path) {
                curr.children.putIfAbsent(p, new TrieNode(p));
                curr = curr.children.get(p);
            }
        }

        serialize(root);

        for (Map.Entry<String, List<TrieNode>> entry : serialToNodes.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (TrieNode node : entry.getValue()) {
                    node.deleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        collect(root, currentPath, result);

        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty())
            return "";

        List<String> keyList = new ArrayList<>(node.children.keySet());
        Collections.sort(keyList);

        StringBuilder sb = new StringBuilder();
        for (String key : keyList) {
            TrieNode child = node.children.get(key);
            String childSerial = serialize(child);
            sb.append('(').append(child.name).append(childSerial).append(')');
        }

        String serial = sb.toString();
        serialCount.put(serial, serialCount.getOrDefault(serial, 0) + 1);
        serialToNodes.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);

        return serial;
    }

    private void collect(TrieNode node, List<String> currentPath, List<List<String>> result) {
        if (node.deleted)
            return;

        if (!currentPath.isEmpty()) { // Don't add root "/" logic usually, or root is virtual
            // Usually paths in output don't include virtual root?
            // Input e.g. ["a"], ["a","b"]. Root is implicit.
            // My traverse starts at virtual root.
            result.add(new ArrayList<>(currentPath));
        }

        for (String key : node.children.keySet()) {
            TrieNode child = node.children.get(key);
            currentPath.add(child.name);
            collect(child, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}

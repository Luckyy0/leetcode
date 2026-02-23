package leet_code.Problem_588_Hard_Design_In_Memory_File_System;

import java.util.*;

public class FileSystem {

    /**
     * Node representing either a file or a directory.
     */
    class Node {
        boolean isFile = false;
        Map<String, Node> children = new HashMap<>(); // Directory contents
        StringBuilder content = new StringBuilder(); // File content
    }

    private Node root;

    public FileSystem() {
        root = new Node();
    }

    /**
     * Lists directory or returned file name.
     */
    public List<String> ls(String path) {
        Node curr = root;
        List<String> result = new ArrayList<>();

        if (!path.equals("/")) {
            String[] parts = path.split("/");
            for (int i = 1; i < parts.length; i++) {
                curr = curr.children.get(parts[i]);
            }

            // If it's a file, return only its name
            if (curr.isFile) {
                result.add(parts[parts.length - 1]);
                return result;
            }
        }

        // If it's a directory, return all sub-entries
        result.addAll(curr.children.keySet());
        Collections.sort(result);
        return result;
    }

    /**
     * Creates directory tree.
     */
    public void mkdir(String path) {
        Node curr = root;
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; i++) {
            if (!curr.children.containsKey(parts[i])) {
                curr.children.put(parts[i], new Node());
            }
            curr = curr.children.get(parts[i]);
        }
    }

    /**
     * Adds content to a file, creating it if necessary.
     */
    public void addContentToFile(String filePath, String content) {
        Node curr = root;
        String[] parts = filePath.split("/");
        for (int i = 1; i < parts.length; i++) {
            if (!curr.children.containsKey(parts[i])) {
                curr.children.put(parts[i], new Node());
            }
            curr = curr.children.get(parts[i]);
        }
        curr.isFile = true;
        curr.content.append(content);
    }

    /**
     * Reads content of a file.
     */
    public String readContentFromFile(String filePath) {
        Node curr = root;
        String[] parts = filePath.split("/");
        for (int i = 1; i < parts.length; i++) {
            curr = curr.children.get(parts[i]);
        }
        return curr.content.toString();
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        System.out.println("ls /: " + fs.ls("/")); // ["a"]
        System.out.println("read /a/b/c/d: " + fs.readContentFromFile("/a/b/c/d")); // "hello"
    }
}

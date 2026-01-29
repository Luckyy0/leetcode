package leetcode.P588_DesignInMemoryFileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileSystem {

    class FileNode {
        boolean isFile = false;
        Map<String, FileNode> children = new HashMap<>();
        StringBuilder content = new StringBuilder();
        String name;

        FileNode(String name) {
            this.name = name;
        }
    }

    FileNode root;

    public FileSystem() {
        root = new FileNode("/");
    }

    public List<String> ls(String path) {
        FileNode node = traverse(path);
        List<String> result = new ArrayList<>();

        if (node.isFile) {
            result.add(node.name);
        } else {
            result.addAll(node.children.keySet());
            Collections.sort(result);
        }
        return result;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        FileNode node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        FileNode node = traverse(filePath);
        return node.content.toString();
    }

    private FileNode traverse(String path) {
        String[] parts = path.split("/");
        FileNode curr = root;

        for (String part : parts) {
            if (part.isEmpty())
                continue;

            curr.children.putIfAbsent(part, new FileNode(part));
            curr = curr.children.get(part);
        }

        return curr;
    }
}

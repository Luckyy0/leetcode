package leetcode.P1166_DesignFileSystem;

import java.util.HashMap;
import java.util.Map;

class FileSystem {
    Map<String, Integer> paths;

    public FileSystem() {
        paths = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (paths.containsKey(path))
            return false;

        int lastSlash = path.lastIndexOf('/');
        if (lastSlash > 0) { // Not top level (top level /a has lastSlash at 0)
            String parent = path.substring(0, lastSlash);
            if (!paths.containsKey(parent))
                return false;
        }

        paths.put(path, value);
        return true;
    }

    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

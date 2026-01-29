package leetcode.P1600_ThroneInheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThroneInheritance {

    class Node {
        String name;
        List<Node> children;
        boolean isDead;

        Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isDead = false;
        }
    }

    private Node root;
    private Map<String, Node> map;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName);
        map = new HashMap<>();
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName);
        parent.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        if (map.containsKey(name)) {
            map.get(name).isDead = true;
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(root, order);
        return order;
    }

    private void dfs(Node node, List<String> order) {
        if (!node.isDead) {
            order.add(node.name);
        }

        for (Node child : node.children) {
            dfs(child, order);
        }
    }
}

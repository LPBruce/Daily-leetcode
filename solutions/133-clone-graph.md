### 题目
**难度**：中等
详细内容见：[clone-graph](https://leetcode-cn.com/problems/clone-graph/)


### 题解
DFS算法:
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> visited = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        return dfs(node);       
    }

    public Node dfs(Node node) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cloneNode);
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(dfs(neighbor));
        }
        return cloneNode;
    }
}
```

BFS:
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap<Node, Node>();

        Queue<Node> queue  = new LinkedList<Node>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<Node>()));
        while(!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor:n.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
```

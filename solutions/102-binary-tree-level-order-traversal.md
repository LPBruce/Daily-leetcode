### 题目
**难度**：中等
详细内容见：[binary-tree-level-order-traversal](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)


### 题解
BFS: 层序遍历在BFS基础上实现，这个题关键在于怎么实现层序操作，在BFS基础上，通过for循环遍历同一层

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

package class_05;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code_04_UnionFind {

    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;  //k：child  v：father
        public HashMap<Node, Integer> sizeMap;   //node节点所在集合共有多少节点

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);  //每个node对应自己的代表节点
                sizeMap.put(node, 1);  //每个节点添加长度1
            }
        }

        private Node findHead(Node node) {
            //非递归
            Stack<Node> stack = new Stack<>();
            Node cur = node;
            Node parent = cur;
            while (cur != parent) {
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), parent);
            }
            return parent;

//              递归法
//            Node father = fatherMap.get(node);
//            if (father != node) {
//                father = findHead(father);
//            }
//            fatherMap.put(node, father);
//            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }

    }

    public static void main(String[] args) {

    }

}

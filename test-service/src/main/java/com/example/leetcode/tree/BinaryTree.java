package com.example.leetcode.tree;

import com.example.leetcode.linkedList.ListNode;

import java.util.*;

/**
 * @author chenyile
 * @date 2023/2/4  15:54
 * @description:
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根节点
    public Node root;
    //记录树中元素的个数
    private int N;

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    //向树中添加元素的个数key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else if (cmp < 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //查询指定树x中指定key对应的value
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            return get(x.left, key);
        } else if (cmp < 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }

    //删除指定树x中key对应的value,并返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            // 待删除节点左子树为空的情况
            if (x.left == null) {
                Node rightNode = x.right;
                x.right = null;
                N--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (x.right == null) {
                Node leftNode = x.left;
                x.left = null;
                N--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            Node successor = min(x.right);
            successor.left = x.left;
            successor.right = removeMin(x.right);
            x = successor;
        }
        return x;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {

            Node rightNode = node.right;
            node.right = null;
            N--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //找出整个树中最大的键
    public Key max() {
        return max(root).key;
    }

    //找出指定树x中最大键所在的节点
    public Node max(Node x) {
        if (x == null) {
            return null;
        }
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }


    //找出整个树中最小的键
    public Key min() {
        return min(root).key;
    }

    //找出指定树x中最小键所在的节点
    public Node min(Node x) {
        if (x == null) {
            return null;
        }
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    //先序遍历获取整个树中所有的键
    public List<Key> preErgodic() {
        List<Key> keys = new LinkedList<>();
        preErgodic(root, keys);
        return keys;
    }

    public void preErgodic(Node x, List<Key> keys) {
        //把x节点的key放入到keys中
        if (x == null) {
            return;
        }
        keys.add(x.key);
        //递归遍历x节点的左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        //递归遍历x节点的右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    //中序遍历获取整个树中所有的键
    public List<Key> middleErgodic() {
        List<Key> keys = new LinkedList<>();
        middleErgodic(root, keys);
        return keys;
    }

    public void middleErgodic(Node x, List<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            middleErgodic(x.left, keys);
        }
        keys.add(x.key);
        if (x.right != null) {
            middleErgodic(x.right, keys);
        }
    }


    //二分搜索树的层序遍历
    public List<Key> levelOrder() {
        List<Key> result = new ArrayList<>();
        LinkedList<Node> tempNodeList = new LinkedList<>();
        tempNodeList.add(root);
        while (!tempNodeList.isEmpty()) {
            Node node = tempNodeList.remove();
            result.add(node.key);
            if (node.left != null) {
                tempNodeList.add(node.left);
            }
            if (node.right != null) {
                tempNodeList.add(node.right);
            }
        }
        return result;
    }
}

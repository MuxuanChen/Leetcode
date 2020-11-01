package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-22
 */
public class Postorder590 {
    /**
     * 方法一：递归
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        postRecursive(root, res);
        return res;
    }

    private void postRecursive(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                postRecursive(node, res);
            }
        }

        res.add(root.val);
    }


    /**
     * 方法二：循环
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }

        doLoop(root, res);
        return res;
    }

    private void doLoop(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            doLoop(child, res);
        }

        res.add(node.val);
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

package com.leetcode.solutions.classic;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class C129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // solution 1
    // much neat code by classic structure
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        return dfs(root, 0, 0);
    }

    public int dfs(TreeNode node, int num, int sum){
        if(node == null) return sum;

        num = num*10 + node.val;

        // leaf
        if(node.left == null && node.right == null) {
            sum += num;
            return sum;
        }

        // left subtree + right subtree
        sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
        return sum;
    }

    // solution 2
    // DFS solution which put all the DFS paths into a list, each path start with root, sum the total
//    public int sumNumbers(TreeNode root) {
//        int result = 0;
//        if(root==null)
//            return result;
//
//        ArrayList<ArrayList<TreeNode>> all = new ArrayList<ArrayList<TreeNode>>();
//        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
//        l.add(root);
//        dfs(root, l, all);
//
//        for(ArrayList<TreeNode> a: all){
//            StringBuilder sb = new StringBuilder();
//            for(TreeNode n: a){
//                sb.append(String.valueOf(n.val));
//            }
//            int currValue = Integer.valueOf(sb.toString());
//            result = result + currValue;
//        }
//
//        return result;
//    }
//
//    public void dfs(TreeNode n, ArrayList<TreeNode> l,  ArrayList<ArrayList<TreeNode>> all){
//        if(n.left==null && n.right==null){
//            ArrayList<TreeNode> t = new ArrayList<TreeNode>();
//            t.addAll(l);
//            all.add(t);
//        }
//
//        if(n.left!=null){
//            l.add(n.left);
//            dfs(n.left, l, all);
//            l.remove(l.size()-1);
//        }
//
//        if(n.right!=null){
//            l.add(n.right);
//            dfs(n.right, l, all);
//            l.remove(l.size()-1);
//        }
//
//    }

    // my solution, also works
//    public int sumNumbers(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        if (root.left == null && root.right == null)
//            return root.val;
//
//        int sum = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        List<TreeNode> list = new ArrayList<>();
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (!list.isEmpty()) {
//                for (int i = list.size() - 1; i >= 0; i --) {
//                    if (isParent(list.get(i), node))
//                        break;
//                    else
//                        list.remove(i);
//                }
//            }
//
//            if (isLeaf(node)) {
//                int temp = 0;
//                for (TreeNode tempNode: list) {
//                    temp = temp * 10 + tempNode.val;
//                }
//                temp = temp * 10 + node.val;
//                sum += temp;
//            } else {
//                list.add(node);
//            }
//
//            if (node.right != null)
//                stack.push(node.right);
//            if (node.left != null)
//                stack.push(node.left);
//        }
//
//        return sum;
//    }
//
//    private boolean isLeaf(TreeNode node) {
//        return node.left == null && node.right == null;
//    }
//
//    private boolean isParent(TreeNode node1, TreeNode node2) {
//        return node1.left == node2 || node1.right == node2;
//    }

    public static void main(String[] strings) {
        C129 c = new C129();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        int sum = c.sumNumbers(root);
        System.out.println(sum);
    }
}

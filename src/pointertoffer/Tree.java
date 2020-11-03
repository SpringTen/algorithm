package pointertoffer;


import java.util.*;

public class Tree {

    private static int maxW = 0;

    public static int widthOfBinaryTree(TreeNode root) {
        /**
         假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
         用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
         节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
         加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
         **/
        dfs(root, 1, 1, new ArrayList<>());
        return maxW;
    }

    private static void dfs(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) return;
        if(level > left.size()) left.add(index);
        maxW = Math.max(maxW, index - left.get(level-1) + 1);
        dfs(r.left, level+1, index*2, left);
        dfs(r.right, level+1, index*2+1, left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode() { }
    }

    public static TreeNode sortBinaryTree(TreeNode node,int i){


        if(node == null){
            node = new TreeNode(i);
            return node;
        }
        else{
            if(i <= node.val){

                node.left =  sortBinaryTree(node.left, i);
            }
            else{
                node.right = sortBinaryTree(node.right,i);
            }

            return node;
        }

    }


    // 获取最大宽度
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                TreeNode t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }

    public static void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,1,6,7,4};
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sortBinaryTree(root, arr[i]);
        }
//        preOrder(root);
        System.out.println(widthOfBinaryTree(root));
    }
}

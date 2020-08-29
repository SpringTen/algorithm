package pointertoffer;

import pointertoffer.Node.TreeNode;

import java.util.Arrays;

/**
 * @author lizhanzhan
 * @date 2020/8/2
 * @explanation 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree07 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) {
            return null;
        }
        int root = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode roots = new TreeNode(root);
        roots.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index),
                Arrays.copyOfRange(inorder, 0, index));
        roots.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length),
                Arrays.copyOfRange(inorder, 1 + index, inorder.length));
        return roots;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = BuildTree07.buildTree(preorder, inorder);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}

package pointertoffer;

import pointertoffer.Node.ListNode;

/**
 * @author lizhanzhan
 * @date 2020/8/2
 * @explanation 从头到尾打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint06 {
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int len = 0;
        ListNode index = head;
        while (index != null) {
            ++len;
            index = index.next;
        }
        int[] res = new int[len];
        int i = len - 1;
        while (head != null) {
            res[i--] = head.val;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = null;
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        int[] ints = ReversePrint06.reversePrint(node1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

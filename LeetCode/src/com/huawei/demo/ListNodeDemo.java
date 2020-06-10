package com.huawei.demo;

public class ListNodeDemo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(3);
        l1.next=listNode;
        listNode.next=listNode1;

        ListNode l2 = new ListNode(5);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);
        l2.next=listNode2;
        listNode2.next=listNode3;

        addTwoNumbers(l1,l2);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

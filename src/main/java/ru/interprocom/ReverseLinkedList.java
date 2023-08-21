package ru.interprocom;

public class ReverseLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode prev = null;
            ListNode next = head.next;
            while (next != null) {
                head.next = prev;
                prev = head;
                head = next;
                next = head.next;
            }
            head.next = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //natural
        ListNode iter = node1;
        while (iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
        //reverse
        iter = reverseList(node1);
        while (iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }
}

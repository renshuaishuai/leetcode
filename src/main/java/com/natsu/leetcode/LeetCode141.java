package com.natsu.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 链表是否有环
 * @author shuaishuai.ren
 * @since 2020-10-09
 */
public class LeetCode141 {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            //慢指针移一步
            slow = slow.next;
            //快指针移两步
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(-1);
        head.next.next.next = head;

        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

package com.leetcode.solutions.linkedlist;

public class C92 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;

        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0);//first's next points to mth
        ListNode second = new ListNode(0);//second's next points to (n+1)th

        int i=0;
        ListNode p = head;
        while(p!=null){
            i++;
            if(i==m-1){
                prev = p;
            }

            if(i==m){
                first.next = p;
            }

            if(i==n){
                second.next = p.next;
                p.next = null;// break condition
            }

            p= p.next;
        }
        if(first.next == null)
            return head;

        // reverse list [m, n]
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;

        while(p1!=null && p2!=null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if(prev!=null)
            prev.next = p1;
        else
            return p1;

        return head;
    }

    public static void main(String[] strings) {
        C92 c = new C92();
        ListNode root = new C92.ListNode(1);
        root.next = new C92.ListNode(2);
        root.next.next = new C92.ListNode(3);
        root.next.next.next = new C92.ListNode(4);
        root.next.next.next.next = new C92.ListNode(5);
        ListNode res = c.reverseBetween(root, 2, 4);
        System.out.println(res);
    }
}

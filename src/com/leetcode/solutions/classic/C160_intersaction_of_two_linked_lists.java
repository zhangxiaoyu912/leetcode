package com.leetcode.solutions.classic;

public class C160_intersaction_of_two_linked_lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // the tricky part is the non-overlap part has different length
        // chop the diff to that can loop two list in even speed
        int len1 = 0;
        int len2 = 0;
        ListNode p1=headA, p2=headB;
        if (p1 == null || p2 == null)
            return null;

        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 !=null){
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1=headA;
        p2=headB;

        if(len1 > len2){
            diff = len1-len2;
            int i=0;
            while(i<diff){
                p1 = p1.next;
                i++;
            }
        }else{
            diff = len2-len1;
            int i=0;
            while(i<diff){
                p2 = p2.next;
                i++;
            }
        }

        while(p1 != null && p2 != null){
            if(p1.val == p2.val){
                return p1;
            }else{

            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;

        // my solution, which use extra memory
//         if (headA == null || headB == null)
//             return null;

//         ListNode nodeA = headA;
//         ListNode nodeB = headB;
//         Set<Integer> set = new HashSet<>();
//         while(nodeA != null && nodeB != null) {
//             int valA = nodeA.val;
//             int valB = nodeB.val;
//             if (set.contains(valA))
//                 return nodeA;
//             else
//                 set.add(valA);

//             if (set.contains(valB))
//                 return nodeB;
//             else
//                 set.add(valB);

//             nodeA = nodeA.next;
//             nodeB = nodeB.next;
//         }

//         while (nodeA != null) {
//             int valA = nodeA.val;
//             if (set.contains(valA))
//                 return nodeA;
//             else
//                 set.add(valA);

//             nodeA = nodeA.next;
//         }

//         while (nodeB != null) {
//             int valB = nodeB.val;
//             if (set.contains(valB))
//                 return nodeB;
//             else
//                 set.add(valB);

//             nodeB = nodeB.next;
//         }

//         return null;
    }
}

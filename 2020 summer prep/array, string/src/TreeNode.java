


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        val = x;
    }
};



//
//
//public class ListNode {
//    int value = 0;
//    ListNode next;
//
//    ListNode(int value) {
//        this.value = value;
//    }
//}

//    public static void reorder(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode secondHalf = reverse(slow);
//        ListNode secondHalfHead = secondHalf;
//        ListNode FirstHalfHead = head;
//        while (FirstHalfHead.next.next != null) {
//
//            ListNode temp = FirstHalfHead.next;
//            FirstHalfHead.next = secondHalfHead;
//            FirstHalfHead = temp;
//
//            ListNode secondHeadNext = secondHalfHead.next;
//            secondHalfHead.next = temp;
//            if(secondHalfHead==secondHeadNext) break;
//            FirstHalfHead = temp;
//            secondHalfHead = secondHeadNext;
//
//        }
//    }

//    private static ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        while(head!=null){
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;
//    }
//
//
//
//}
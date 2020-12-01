import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();

        list1.insert(0);
        list1.insert(1);
       // list1.insert(2);
        list1.insert(1);
        list1.insert(5);

//        LinkedList list2 = new LinkedList();
//        list2.insert(5);
//        list2.insert(6);
//        list2.insert(7);
       // list.printList();
      //  removeDuplicates2(list);
//        IntegerWrapper wrap = new IntegerWrapper();
//        System.out.println(findKthElement(list,4,wrap));
       // LinkedList result = new LinkedList();
       //  partition(list,5);
        list1.printList();
       // list2.printList();
        LinkedList result = new LinkedList();
        System.out.println(isPalindrome(list1.head));

    }

    public static class Result{
        LinkedList.ListNode rnode;
        boolean isPalin;

        Result(){
            rnode = null;
            isPalin = true;
        }

        Result(LinkedList.ListNode n, boolean p){
            rnode = n;
            isPalin = p;
        }
    }
    private static boolean isPalindrome(LinkedList.ListNode l1){
        Result r = isPalindromeHelper(l1,5);
        return r.isPalin;
    }

    private static Result isPalindromeHelper(LinkedList.ListNode head, int length){
        if(head ==null || length == 0) return new Result();
        if(length == 1) return new Result(head.next,true);
        if(length == 2) return new Result(head.next.next,head.value==head.next.value);

        Result r = isPalindromeHelper(head.next, length-2);

        if(r.rnode==null || r.isPalin==false) return r;
        else{
            r.isPalin = head.value== r.rnode.value;
            r.rnode = r.rnode.next;
            return r;
        }
    }

//    private static Result isPalindrome(LinkedList.ListNode l1){
//        LinkedList.ListNode fast = l1;
//        LinkedList.ListNode slow = l1;
//        LinkedList.ListNode cur = l1;
//        while(fast!=null && fast.next!=null){
//            slow= slow.next;
//            fast = fast.next.next;
//        }
//        Stack<Integer> stack = new Stack<>();
//        while(cur!=slow){
//            stack.push(cur.value);
//            cur = cur.next;
//        }
//
//        if(fast != null) {
//            slow= slow.next;
//        }
//        while(!stack.isEmpty() && slow!=null){
//            int top = stack.peek();
//            stack.pop();
//            if(top!= slow.value) return false;
//            slow = slow.next;
//        }
//
//        if(!stack.isEmpty() || slow!=null) return false;
//        return true;
//    }
    private static LinkedList.ListNode addLists( LinkedList.ListNode l1, LinkedList.ListNode l2, int carry) {

        if(l1==null && l2==null) {
            if(carry!=0){
                return new LinkedList.ListNode(carry);
            }
            else return null;

        }
       int value = carry;
       if(l1!=null) value+=l1.value;
       if(l2!=null) value+=l2.value;

       LinkedList.ListNode cur = new LinkedList.ListNode();
        cur.value = value%10;
        carry = value>=10? 1:0;
        cur.next = addLists(l1 != null?l1.next:null,l2!=null?l2.next:null,carry);
        return cur;

    }

    public static int linkedListToInt(LinkedList.ListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.value;
    }



   // public static int calculateNum ()
    public static void removeDuplicates(LinkedList list){
        if(list.head==null) return;
        LinkedList.ListNode cur = list.head;
        LinkedList.ListNode prev = null;
        Hashtable table = new Hashtable();
        while(cur!=null){
            if(table.containsKey(cur.value)) {
                prev.next = cur.next;
            }else{
                table.put(cur.value,true);
                prev = cur;

            }
            cur = cur.next;
        }

    }

    // No Buffer Allowed
    public static void removeDuplicates2(LinkedList list){
        if(list.head==null) return;
        LinkedList.ListNode cur = list.head;
        LinkedList.ListNode fast = null;


        while(cur!=null){
            fast= cur;
            while(fast.next!=null){
                if(fast.next.value == cur.value){
                    fast.next = fast.next.next;
                    //break;
                }else{
                    fast= fast.next;
                }

            }
            cur = cur.next;
        }
    }

    public static int findKthElement(LinkedList list, int k, IntegerWrapper wrap) {
        if (list.head == null) return 0;
        LinkedList.ListNode n = findKthElementhelper(list.head , k,  wrap);
        return n.value;
    }

    public static LinkedList.ListNode findKthElementhelper(LinkedList.ListNode node, int k, IntegerWrapper wrap) {
      if(node==null) return null;
        LinkedList.ListNode n = findKthElementhelper( node.next, k, wrap);
        wrap.i += 1;
        if(wrap.i == k) return node;
        else return n;

    }

    public static void partition(LinkedList list, int x){


        LinkedList.ListNode BeforeStart = null;
        LinkedList.ListNode BeforeEnd = null;
        LinkedList.ListNode AfterStart = null;
        LinkedList.ListNode AfterEnd = null;

        LinkedList.ListNode cur = list.head;

        while(cur!=null){

            if(cur.value < x){
                if(BeforeStart==null){
                    BeforeStart = cur;
                    BeforeEnd = BeforeStart;

                }else{
                    BeforeEnd.next = cur;
                    BeforeEnd = BeforeEnd.next;
                }

            }else{
                if(AfterStart==null){
                    AfterStart = cur;
                    AfterEnd = AfterStart;

                }else{
                    AfterEnd.next = cur;
                    AfterEnd = AfterEnd.next;
                }
            }
            cur = cur.next;
        }

        list.head = BeforeStart;
        AfterEnd.next = null;
        BeforeEnd.next = AfterStart;

    }
}

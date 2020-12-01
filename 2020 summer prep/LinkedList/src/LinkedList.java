public class LinkedList {

    ListNode head;
    ListNode tail;
    static  class ListNode {

    int value;
    ListNode next;

    ListNode() {
        value = 0;
        next = null;
    }

    ListNode(int v) {
        value = v;
        next = null;
    }

   }

   public void insert(int data){
       ListNode node = new ListNode(data);

        if(head==null) {
            head = node;
        }else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            tail = cur;
        }
   }

    public void printList(){

            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.value + "->");
                cur = cur.next;
            }
        System.out.println("null");
        System.out.println();
        }

}

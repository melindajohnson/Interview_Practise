public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        q.enqueue(n1);
        q.enqueue(n2);
        q.enqueue(n3);
        Node result = q.dequeue();
        System.out.println(result.data);
        Node result2 = q.dequeue();
        System.out.println(result2.data);
        q.enqueue(n4);
        Node result3 = q.dequeue();
        System.out.println(result3.data);
    }

    public static class Node{
       int data;
       Node next;

       Node(int n){
           data = n;
           next = null;
       }
    }

    public static class Stack {
        Node top;


        public Node peek() {
            return top;
        }

        public boolean isEmpty() {
            return  top==null;
        }

        public void push(Node n) {
            n.next = top;
            top = n;
        }

        public Node pop() {
            if(top!=null){
                Node n = top;
                top = n.next;
                return n;
            }

          return null;
        }
    }

    public static class Queue {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
       // Node back;

        public Node dequeue(){
           if(!stack2.isEmpty()){
              return stack2.pop();
           }else{
               while(!stack1.isEmpty()){
                   stack2.push(stack1.pop());
               }
               return stack2.pop();
           }
        }

        public  void enqueue(Node n){
            stack1.push(n);
        }
    }
}

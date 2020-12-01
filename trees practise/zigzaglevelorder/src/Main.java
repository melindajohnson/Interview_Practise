import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
    }

    // so determine if a tree is height balanced
    //the abs(difference in height between the left subtree and the right sub tree)  <=1


    int getHeight(Node n){
        if(n ==null) return -1;
        return 1+ Math.max(getHeight(n.left),getHeight(n.right));
    }

    boolean isBalancedTreen2( Node n){
        if(n==null) return true;

        int leftHeight = getHeight(n.left);
        int rightHeight = getHeight(n.right);
        return(Math.abs(leftHeight-leftHeight)<=1 && isBalancedTree(n.left) && isBalancedTree(n.right))
    }


    boolean isBalancedTreen(Node n){
        if(n==null) return true;

        return calculateHeight(n)!=-1?true:false;
    }


    int calculateHeight(Node n){
        if(n ==null) return 0;
        int leftHeight = calculateHeight(n.left);
        int rightHeight = calculateHeight(n.right);
        if(leftHeight==-1 || rightHeight==-1 || Math.abs(leftHeight-rightHeight)>1) return -1;
        return 1+ Math.max(leftHeight,rightHeight);
    }



     List<List<int>> ZigZaglevelOrderTraversal(Node n){
        List<> TreeList = new List<>();
        boolean zig = true;

        if(n==null) return TreeList;
         Stack<Node> currentLevel = new Stack<>();
         Stack<Node> nextLevel = new Stack<>();

         currentLevel.push(n);
         while(!currentLevel.isEmpty()){
             List<> LevelList = new List<>();
             while (!currentLevel.isEmpty()){
                 Node n = currentLevel.pop();
                 if(zig) {
                     if (n.left != null) {
                         nextLevel.push(n.left);
                     }
                     if (n.right != null) {
                         nextLevel.push(n.right);
                     }
                 }else{

                     if (n.right != null) {
                         nextLevel.push(n.right);
                     }
                     if (n.left != null) {
                         nextLevel.push(n.left);
                     }
                 }
             }
             zig = !zig;
             Stack<Node> temp = nextLevel;
             nextLevel = currentLevel;
             currentLevel = temp;
             TreeList.add(LevelList);
         }


     }


    preOrder 3 9 20 15 7

    inorder 9 3 15 20 7
            lrt right


   int preIndex

   int search(int inorder[], int start, int end, int value){
        int i
        for(i = start; i<end ;i++){
            if(inorder[i]==value)
                return i;
        }
        return i;
   }

   Node buildTree(int inorder[], int postOrder[], int inStart, int inEnd){

     if(inStart > inEnd) return null;

     Node n = new Node(preOrder[preIndex++]);

     if(inEnd==inStart){
         return n;
     }

     int inIndex = search(inorder, inStart,inEnd, n.data);
     n.left = buildTree(inorder, postOrder, inStart, inIndex-1);
     n.right =buildTree(inorder, postOrder, inIndex+1, inEnd);

     return n;
   }































    List<List<int>> ZigZagTraversal() {

        List<> TreeList = new List<>();
        // if null then return
        if (rootNode == null) {
            return TreeList;
        }

        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            List<> levelList = new List<>();
            {
                while (!currentLevel.isEmpty()) {
                    // pop out of stack
                    Node node = currentLevel.pop();
                    levelList.add(node.data);

                    // store data according to current
                    // order.
                    if (leftToRight) {
                        if (node.leftChild != null) {
                            nextLevel.push(node.leftChild);
                        }

                        if (node.rightChild != null) {
                            nextLevel.push(node.rightChild);
                        }
                    } else {
                        if (node.rightChild != null) {
                            nextLevel.push(node.rightChild);
                        }

                        if (node.leftChild != null) {
                            nextLevel.push(node.leftChild);
                        }
                    }
                }
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                TreeList.add(levelList);
            }
        }
    }


}
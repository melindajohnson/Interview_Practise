import java.util.ArrayList;
import java.util.List;

class Result {

        public TreeNode node;
        public boolean isAncestor;
    public Result() {
        node = null;
        isAncestor = false;
    }
        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }


    public static Result commonAncestorHelper(TreeNode root, int p, int q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root.val == p && root.val == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root.val == p || root.val == q) {
            /* If we’re currently at p or q, and we also found one of those
             * nodes in a subtree, then this is truly an ancestor and the
             * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor(TreeNode root, int p, int q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }
}
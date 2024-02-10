package Trees;

import java.util.ArrayList;
import java.util.List;

class Right {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, ans, 0);
        return ans;
    }

    public void rightView(TreeNode node, List<Integer> ans, int level) {
        if (node == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(node.val);
        }

        // For left view swap functions
        rightView(node.right, ans, level + 1);
        rightView(node.left, ans, level + 1);
    }
}

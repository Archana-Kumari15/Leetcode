class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){ // left h
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) 
                pred = pred.right;
                if(pred.right == null){  // link
                    pred.right = curr;
                    curr = curr.left;
                }
                else{                    // unlink
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        else{                            // left nhi h
            ans.add(curr.val);
            curr = curr.right;
        }
    }
        return ans;
    }
}
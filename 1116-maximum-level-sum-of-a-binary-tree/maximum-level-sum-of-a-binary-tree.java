class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int maxSum = Integer.MIN_VALUE;
        int resultlvl = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currlvl = 1;
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            for(int i = 0; i<n ; i++){
                TreeNode temp = q.peek();
                q.poll();
                sum += temp.val;
                if(temp.left != null)
                   q.add(temp.left);
                if(temp.right != null)
                   q.add(temp.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                resultlvl = currlvl; 
            }
            currlvl++;
        }
        return resultlvl;
    }
}
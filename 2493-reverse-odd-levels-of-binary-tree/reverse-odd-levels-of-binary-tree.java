class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            List<TreeNode> levelnode = new ArrayList<>();
            for(int i = 0; i<n ; i++){
                TreeNode temp = q.poll();
                levelnode.add(temp);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        if(level % 2 == 1){
            int i = 0;
            int j = levelnode.size()-1;
            while(i<j){
                int tempval = levelnode.get(i).val;
                levelnode.get(i).val = levelnode.get(j).val;
                levelnode.get(j).val = tempval;
                i++;
                j--;
            }
         }
         level++;
        }
        return root;
    }
}
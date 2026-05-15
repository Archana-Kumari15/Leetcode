class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public void dfs(TreeNode root, int level){
        if(root == null) return;
        map.put(level, map.getOrDefault(level, 0) + root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    public int maxLevelSum(TreeNode root) {
        dfs(root,1);
        int maxSum = Integer.MIN_VALUE;
        int resultlvl = 0;
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();
            if(sum > maxSum){
                maxSum = sum;
                resultlvl = level;
            }
        }
        return resultlvl;
    }
}
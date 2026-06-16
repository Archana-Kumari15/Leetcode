class Solution {
    int[] level = new int[1000001];
    int[] height = new int[1000001];
    int[] lvlMaxHt = new int[1000001];
    int[] lvlSecondMaxHt = new int[1000001];
    
    public int findMax(TreeNode root,int l){
        if(root == null) return 0;
        level[root.val] = l;
        height[root.val] = Math.max(findMax(root.left,l+1),findMax(root.right,l+1)) + 1;
        if(lvlMaxHt[l] < height[root.val]){
            lvlSecondMaxHt[l] = lvlMaxHt[l];
            lvlMaxHt[l] = height[root.val];
        }
        else if(lvlSecondMaxHt[l] < height[root.val]){
            lvlSecondMaxHt[l] = height[root.val];
        }
        return height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        findMax(root,0);
        int[] result = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int node = queries[i];
            int L = level[node];
            result[i]  = L + (lvlMaxHt[L] == height[node] ? lvlSecondMaxHt[L] : lvlMaxHt[L]) - 1;
        }
        return result;
    }
}
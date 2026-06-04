class Solution {
    int goodleaf;
    public List<Integer> solve(TreeNode root, int distance){
        List<Integer> curr = new ArrayList<>();
        if(root == null) return curr;
        if(root.left == null && root.right == null){
            curr.add(1);
            return curr;
        }
        List<Integer> leftd = solve(root.left,distance);
        List<Integer> rightd = solve(root.right,distance);
        for(int l : leftd){
            for(int r : rightd){
                if((l != 0 && r != 0) && l+r <= distance){
                    goodleaf++;
                }
            }
        }
        
        for(int l : leftd){
            if(l != 0 && l+1 <= distance){
                curr.add(l+1);
            }
        }
        for(int r : rightd){
            if(r != 0 && r+1 <= distance){
                curr.add(r+1);
            }
        }
        return curr;
    }
    public int countPairs(TreeNode root, int distance) {
        goodleaf = 0;
        solve(root,distance);
        return goodleaf;
    }
}
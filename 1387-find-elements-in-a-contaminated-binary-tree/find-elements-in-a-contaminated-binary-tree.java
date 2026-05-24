class FindElements {
    static Set<Integer> set;
    public void dfs(TreeNode root, int x){
        if(root == null) return;
        root.val = x;
        set.add(x);
        dfs(root.left,2*x+1);
        dfs(root.right,2*x+2);
    }
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfs(root,0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}


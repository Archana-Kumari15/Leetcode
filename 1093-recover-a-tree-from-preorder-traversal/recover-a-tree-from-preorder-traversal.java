class Solution {
    int n;
    int i = 0;
    public TreeNode solve(String s,int depth){
        if(i >= n) return null;
        int j = i;
        while(j < n && s.charAt(j) == '-') j++;
        int dash = j-i;
        if(dash != depth) return null;
        i = j;
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
    }
        TreeNode root = new TreeNode(num);
        root.left = solve(s,depth+1);
        root.right = solve(s,depth+1);
        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        
        return solve(traversal,0);
    }
}
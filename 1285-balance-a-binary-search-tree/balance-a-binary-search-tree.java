class Solution {
    public void inorder(TreeNode root, List<Integer> vec){
        if(root == null) return;
        inorder(root.left,vec);
        vec.add(root.val);
        inorder(root.right,vec);
    }
    public TreeNode construct(int l, int r, List<Integer> vec){
        if(l > r) return null;
        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(vec.get(mid));
        root.left = construct(l,mid-1,vec);
        root.right = construct(mid+1,r,vec);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vec = new ArrayList<>();
        inorder(root,vec);
        int l = 0;
        int r = vec.size() - 1;
        return construct(l,r,vec);
    }
}
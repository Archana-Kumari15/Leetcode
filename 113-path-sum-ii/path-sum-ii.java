class Solution {
    static List<List<Integer>> result;
    public void fill(TreeNode root,int sum, List<Integer> temp,int target){
        if(root == null) return;
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        fill(root.left,sum,temp,target);
        fill(root.right,sum,temp,target);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        fill(root,sum,temp,target);
        return result;
    }
}
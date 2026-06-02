class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] des : descriptions){
            int parent = des[0];
            int child = des[1];
            int isleft = des[2];
            if(!map.containsKey(parent)){
                map.put(parent,new TreeNode(parent));
            }
             if(!map.containsKey(child)){
                map.put(child,new TreeNode(child));
            }
            if(isleft == 1){
                map.get(parent).left = map.get(child);
            }else{
                map.get(parent).right = map.get(child);
            }
            set.add(child);
        }
        for(int[] des : descriptions){
            int parent = des[0];
            if(!set.contains(parent)){
                return map.get(parent);
            }
        }
        return null;
    }
}
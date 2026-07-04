class Solution {
     Map<Integer,Integer> map = new HashMap<>();
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        dfs(root.right);
    }
    public int[] findMode(TreeNode root) {
      dfs(root);
      List<Integer> list = new ArrayList<>();
      int maxFreq = 0;
      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();
         if (freq > maxFreq) {
                maxFreq = freq;
                list.clear();
                list.add(key);
            } else if (freq == maxFreq) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
      }
    }

class Solution {
    private int countMinSwap(List<Integer> list) {

        int n = list.size();

        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(list.get(i), i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (list.get(i).equals(sorted.get(i))) {
                continue;
            }

            int correctIdx = map.get(sorted.get(i));

            int currVal = list.get(i);
            int correctVal = list.get(correctIdx);

            Collections.swap(list, i, correctIdx);

            map.put(currVal, correctIdx);
            map.put(correctVal, i);

            swaps++;
        }

        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int res = 0;

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> vec = new ArrayList<>();
            for(int i = 0; i<n ; i++){
                TreeNode temp = q.poll();
                vec.add(temp.val);

                if(temp.left!=null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            } 
            res += countMinSwap(vec);
        }
        return res;   
    }
}
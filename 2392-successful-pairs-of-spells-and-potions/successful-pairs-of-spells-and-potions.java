class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            long spell = spells[i];
            long required = (success + spell -1)/spell;
            int index = lowerBound(potions,required);
            result[i]= m - index;
        }
       return result;
    }
    public int lowerBound(int[] potions,long required){
        int left=0, right=potions.length;
        while(left <right){
            int mid = left + (right-left)/2;
            if(potions[mid] >= required){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
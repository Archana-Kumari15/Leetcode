class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = num.length-1;
        if(i>j) return res;
        for(int k =1; k<=num.length; k++){
            if(num[i] + num[j] == target){
                res[0] = i+1;
                res[1] = j+1;
                
            }
            else if(num[i] + num[j] > target){
                j--;
            }else{
                i++;
            }
        }
        
        return res;
    }
}
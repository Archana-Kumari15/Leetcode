class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
               if( min > arr[i]){
                    min = arr[i];
                }
                else if(arr[i] - min > max){
                    max = arr[i] - min;
                } 
            }
            return max;
        }
        
    }

class Solution {
    public int countDistinctIntegers(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
            set.add(reverse(arr[i]));
        }
        return set.size();
    }
    public int reverse(int n){
        int r=0;
        while(n!=0){
            r=r*10 + n%10;
            n /= 10;
        }
        return r;
    }
}
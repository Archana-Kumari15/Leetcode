class Solution {
    public int digitsum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int swap = 0;
        int n = nums.length;
        Integer[] sorted = new Integer[n];
        for(int i = 0; i<n ; i++){
            sorted[i] = nums[i];
        }
        
        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitsum(a);
            int sumB = digitsum(b);

            if (sumA == sumB)
                return Integer.compare(a, b);

        return Integer.compare(sumA, sumB);
        });

        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<n ; i++){
            map.put(sorted[i],i);
        }

        int[] arr = nums.clone();
        
        for(int i = 0; i<n ; i++){
            while(map.get(arr[i]) != i){
            int correctIdx = map.get(arr[i]);
            int temp = arr[i];
            arr[i] = arr[correctIdx];
            arr[correctIdx] = temp;
            swap++;
            }
        }

        return swap;
    }
}
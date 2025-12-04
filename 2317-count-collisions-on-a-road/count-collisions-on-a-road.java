class Solution {
    public int countCollisions(String directions) {
      boolean flag = false;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);

            if (c == 'R') {
                count++;
            } 
            else if (c == 'L') {
                if (flag && count == 0) {
                    ans += 1;
                } 
                else if (count > 0) {
                    ans += (count + 1);
                    count = 0;
                    flag = true;
                }
            } 
            else { 
                flag = true;
                if (count > 0) {
                    ans += count;
                    count = 0;
                }
            }
        }

        return ans;
    }
}
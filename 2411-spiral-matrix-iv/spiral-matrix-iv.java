class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
       // if(head == null || head.next == null) return head;
        int[][] arr = new int[m][n];
        for(int i = 0; i<m ; i++){
           for(int j = 0; j<n ; j++){
            arr[i][j] = -1;
           }
        }
        int top = 0;  int left = 0;
        int right = n-1; int bottom = m-1;
        ListNode curr = head;
        while(curr != null && top <= bottom && left <= right){

            for(int i = left; i <= right && curr != null ; i++){
               arr[top][i] = curr.val;
               curr = curr.next;
            }
              top++;

            for(int j = top ; j <= bottom && curr != null ; j++){
               arr[j][right] = curr.val;
               curr = curr.next;
            } 
              right--;
               
            for(int j = right; j >= left && curr != null; j--){
               arr[bottom][j] = curr.val;
               curr = curr.next;
            }
              bottom--;
              
            for(int i = bottom ; i >= top && curr != null ; i--){
               arr[i][left] = curr.val;
               curr = curr.next;
            }
              left++;    
        }
        return arr;
    }
}
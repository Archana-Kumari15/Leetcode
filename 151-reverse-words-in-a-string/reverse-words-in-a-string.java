class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int n = arr.length;
        int write = 0;
        while(i < n){
            while(i < n && arr[i] == ' ') i++;
            while(i < n && arr[i] != ' ') arr[write++] = arr[i++];
            while(i < n && arr[i] == ' ') i++;
            if(i < n) arr[write++] = ' ';
        }
        reverse(arr,0,write-1);
        int start = 0;
        for(int j = 0; j <= write; j++){
            if(j == write || arr[j] == ' '){
                reverse(arr,start,j-1);
                start = j+1;
            }
        }
        return new String(arr,0,write);
    }

    public void reverse(char[] arr,int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

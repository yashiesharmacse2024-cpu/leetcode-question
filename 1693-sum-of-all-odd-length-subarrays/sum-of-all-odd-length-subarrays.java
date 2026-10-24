class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
           
            int left = i + 1;
          
            int right = n - i;
            
            
            int totalSubarrays = left * right;
            
           
            int oddSubarraysCount = (totalSubarrays + 1) / 2;
            
           
            totalSum += oddSubarraysCount * arr[i];
        }
        
        return totalSum;
    }
}
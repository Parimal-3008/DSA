class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n =arr.length;
        int dp[] = new int[n];
        if(n<=2)
            return 0;
        for(int i=1;i<n;i++)
        {
            dp[i-1]=arr[i]-arr[i-1];
        }
        int sum=0;
        int prev=dp[0];int count=01;dp[n-1]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
        {
            if(prev==dp[i])
            {
                count++;
            }
            else
            {
                prev=dp[i];
                if(count>=2)
                {
                    int temp = count-1;
                    System.out.println(count+" "+sum);
                    sum+=(temp*(temp+1)/2);
                }
                count=1;
            }
        }
        return sum;
    }
}
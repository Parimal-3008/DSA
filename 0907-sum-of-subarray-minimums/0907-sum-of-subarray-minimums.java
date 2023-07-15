class Solution {
    public int sumSubarrayMins(int[] arr) {
       int[] right = new int[arr.length];
        int[] left = new int[arr.length];
        call1(arr,right);
        call2(arr,left);        
        long ans = 0;
        long mod = 1000000007;
        for(int i=0;i<arr.length;i++)
        {
            long temp =  right[i]*left[i];
            temp= (temp*(long)arr[i])%mod;
            ans = (ans+temp)%mod;
            while(ans<0)
                ans+=mod;
        }
        return (int)ans;        
    }
    public void call1(int[] arr, int[] dp)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            dp[i]=arr.length;
            while(!st.isEmpty())
            {
               if(arr[st.peek()]<=arr[i])
               {
                   dp[i]=st.peek();
                   break;
               }
                else
                    st.pop();
            }
            dp[i]-=i;
            st.push(i);
            
        }
    }
    public void call2(int[] arr, int[] dp)
    {
         Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            dp[i]=-1;
            while(!st.isEmpty())
            {
               if(arr[st.peek()]<arr[i])
               {
                   dp[i]=st.peek();
                   break;
               }
                else
                    st.pop();
            }
            dp[i]=i-dp[i];
            st.push(i);
            
        }
    }
}
/*
Right: 1 
*/
// right[]: 1 4 4 4 ->  0 3 3 3
// left[]: -1 -1 1 2 -> 0 0 2 3
    // 3+4+

// 4 3 3 4 5
// -1 0 1 0 -1
// right: 3 2 2 3 4
// left:  0 1 2 1 0
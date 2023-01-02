class Solution {
  int mod = 1000000007;
     public String longestPrefix(String str) {
        char arr[]= str.toCharArray();
      int ans =-1;int n = arr.length;
      
      long sum1 =0;
      long pre[]= new long[n];
      pre[0]=(int)(arr[0]-'a');
      for(int i=1;i<n;i++)
        pre[i]=pre[i-1]+(int)(arr[i]-'a');
      long sum2 =0;
      long nul = 1;
      for(int i=0;i<arr.length-1;i++)
      {
        int c1 = str.charAt(i)-'a';
        int c2 = str.charAt(n-1-i)-'a';
        sum1= ((sum1*26) + c1)% mod;
        sum2= (sum2 + (nul*c2))% mod;
        nul = nul*26 %mod;
        if(sum1 ==sum2)
          ans = i;
        
        
      }
      if(ans ==-1)
        return "";
      return str.substring(0,ans+1);
    }
}
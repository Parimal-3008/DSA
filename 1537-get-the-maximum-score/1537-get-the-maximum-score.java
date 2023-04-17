class Solution {
  long mod = 1000000007;
    public int maxSum(int[] arr1, int[] arr2) {
        Map<Integer,Integer> mp1 = new HashMap<>();
        Map<Integer,Integer> mp2 = new HashMap<>();
      for(int i=0;i<arr1.length;i++)
      {
        mp1.put(arr1[i],i);
      }
      for(int i=0;i<arr2.length;i++)
      {
        mp2.put(arr2[i],i);
      }
      long dp[][]= new long[Math.max(arr1.length,arr2.length)][3];
      for(long i[]:dp)
        Arrays.fill(i,-1);
      return (int)(Math.max(call(arr1,arr2,0,1,mp1,mp2,dp),call(arr1,arr2,0,2,mp1,mp2,dp))%mod);
    }
 public long call(int[] arr1, int[] arr2, int i, int j,Map<Integer,Integer> mp1, Map<Integer,Integer> mp2,long[][] dp)
  {
   if((j==1 && i>=arr1.length) || (j==2 && i>= arr2.length))
     return 0;
     long a = 0;
     long b = 0;
   if(dp[i][j]!=-1)
     return dp[i][j];
    if(j==1)
     {
       a = arr1[i] + call(arr1,arr2,i+1,1,mp1,mp2,dp);
      if(mp2.containsKey(arr1[i]))
        b = arr1[i]+ call(arr1,arr2,mp2.get(arr1[i])+1,2,mp1,mp2,dp);
      else
        b = arr1[i];
     }
     else
     {
       a = arr2[i]+ call(arr1,arr2,i+1,2,mp1,mp2,dp);
      if(mp1.containsKey(arr2[i]))
        b = arr2[i]+ call(arr1,arr2,mp1.get(arr2[i])+1,1,mp1,mp2,dp);
      else
        b = arr2[i];
     }
   while(a<0)
     a+=mod;
   while(b<0)
     b+=mod;
     // System.out.println(j+" "+i+" "+a+" "+b);
     return dp[i][j]=Math.max(a,b);
     
   }
}
class Solution {
    public boolean isMatch(String s, String p) {
        char arr1[]= s.toCharArray();
      char arr2[]= p.toCharArray();
      char prev='.';int count =0;
      for(int i=0;i<arr2.length;i++)
      {
        if(arr2[i]==prev && prev=='*')
        {arr2[i]='.';count++;}
        else
          prev=arr2[i];
      }
      char arr3[]= new char[arr2.length-count];
      int j=0;
      for(int i=0;i<arr2.length;i++)
      {
        if(arr2[i]!='.')
          arr3[j++]=arr2[i];
      }
      for(char i:arr3)
        System.out.print(i);
    
      int dp[][]= new int[arr1.length][arr2.length];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      
      int p2 = call(arr1,arr3,0,0,dp);
      return p2!=0;
    }
  public int call(char[] arr1, char[] arr2,int i, int j, int[][] dp)
  {
    if(i==arr1.length && j==arr2.length)
      return 1;
    if(i==arr1.length)
    {
      for(int i1=j;i1<arr2.length;i1++)
      {
        if(arr2[i1]!='*')
          return 0;
      }
     return 1;
    }
    if(j== arr2.length)
      return 0;
    if(dp[i][j]!=-1)
    return dp[i][j];
    
    if(arr1[i]==arr2[j] || arr2[j]=='?')
       return dp[i][j]= call(arr1,arr2,i+1,j+1,dp);
    else if(arr2[j]=='*')
    {      
       int a = call(arr1,arr2,i+1,j,dp);
       int b = call(arr1,arr2,i+1,j+1,dp);
       int c = call(arr1,arr2,i,j+1,dp);
      // System.out.println(a+b+c);
       return dp[i][j]=a+b+c;
    }
    else
      return dp[i][j]= 0;
  }
}
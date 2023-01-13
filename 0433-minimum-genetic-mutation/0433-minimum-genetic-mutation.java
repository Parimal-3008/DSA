class Solution {
    public int minMutation(String s1, String s2, String[] arr) {
      boolean st[]= new boolean[arr.length];
      int k=0;
      for(int i=0;i<8;i++)
      {
        if(s1.charAt(i)!=s2.charAt(i))
          k++;
      }
      int o = call(s1,s2,arr,st,0);
      
      if(o==Integer.MAX_VALUE|| arr.length==0)
        return -1;
      return o;        
    }
  public int call(String s1,String s2,String[] arr, boolean[] st,int curr)
  {
       if(s1.equals(s2))
         return curr;
   
    int a = Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++)
    {
      if(st[i])
        continue;
      int count =0;
      for(int j=0;j<arr[i].length();j++)
      {
        if(s1.charAt(j)!=arr[i].charAt(j))
          count++;          
      }
      if(count ==1)
      {
        st[i]=true;
        a= Math.min(a,call(arr[i],s2,arr,st,curr+1));
        st[i]=false;
      }
    }
    return a;
    
    
  }
}
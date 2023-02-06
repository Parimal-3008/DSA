class Solution {
    public int equalSubstring(String s, String t, int k) {
        int l =0; int r = t.length();
       int ans = 0;
       while(l<=r)
       {
         int mid = (l+r)/2;
         if(ispossible(mid,s,t,k))
         {
           ans = mid;
           l = mid+1;
         }
         else
           r = mid-1;
       }
      return ans;
    }
  public boolean ispossible(int mid, String str1,String str2, int k)
  {
    int curr =0;
    char arr1[]= str1.toCharArray();
    char arr2[]= str2.toCharArray();
    for(int i=0;i<mid;i++)
    {
      if(arr1[i]!=arr2[i])
        curr+=Math.abs((int)arr1[i]-(int)arr2[i]);

    }
    if(curr<=k) return true;
    for(int i=mid;i<arr1.length;i++)
    {
      if(arr1[i-mid]!=arr2[i-mid])
       curr-=Math.abs((int)arr1[i-mid]-(int)arr2[i-mid]);
      if(arr1[i]!=arr2[i])
        curr+=Math.abs((int)arr1[i]-(int)arr2[i]);
      if(curr<=k)
        return true;
    }
    return false;
  }
}
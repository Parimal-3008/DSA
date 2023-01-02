class Solution {
    public int numberOfSubstrings(String s) {
        char arr[] = s.toCharArray();
      int a =0; int b =0; int c =0;
      int ans =0;
      for(int l=0,r=0;r<arr.length;r++)
      {
        if(arr[r]=='a')a++;
        else if(arr[r]=='b')b++;
        else if(arr[r]=='c')c++;
        while(a>0 && b>0 && c>0 )
        {
           ans = ans+ arr.length-r;
          if(arr[l]=='a')a--;
        else if(arr[l]=='b')b--;
        else if(arr[l]=='c')c--;
          l++;
        }
      }
      return ans;
    }
}
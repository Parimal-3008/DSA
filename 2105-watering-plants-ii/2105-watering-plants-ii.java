class Solution {
    public int minimumRefill(int[] arr, int alice, int bob) {
        int i=0 ; int j = arr.length-1;
        int a=alice;int b= bob;
       int ans =0;
      while(i<=j)
      {
        if(i==j)
        {
          if(Math.max(a,b)<arr[i])
            ans++;
          break;
        }
        if(a<arr[i])
        {
          a=alice;
          ans++;
        }
        a-=arr[i];
        if(b<arr[j])
        {
          b=bob;
          ans++;
        }
        b-=arr[j];
        i++;j--;
      }
      return ans;
    }
}
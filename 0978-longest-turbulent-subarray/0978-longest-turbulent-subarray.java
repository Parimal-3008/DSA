class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int j=0;
        char prev  = '.';
        for(int i=1;i<arr.length;i++)
        {
            if(prev=='.')
            {
                if(arr[i-1]>arr[i])
                    prev='s';
                else if(arr[i-1]<arr[i])
                    prev='l';
                else
                  {
                    prev='.';
                    j=i;
                  }
                ans = Math.max(ans,i-j+1);
                
            }
            else if(prev=='l')
            {
                 if(arr[i-1]>arr[i])
                    prev='s';
                else if(arr[i-1]==arr[i])
                    {
                    prev='.';
                    j=i;
                   }
                else
                  {
                    prev='l';
                    j=i-1;
                  }
                ans = Math.max(ans,i-j+1);
            }
            else
            {
                if(arr[i-1]<arr[i])
                    prev='l';
                 else if(arr[i-1]==arr[i])
                    {
                    prev='.';
                    j=i;
                   }
                 else
                  {
                    prev='s';
                    j=i-1;
                  }
                ans = Math.max(ans,i-j+1);
            }
        }
        return ans;
    }
}
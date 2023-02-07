class Solution {
    public int longestNiceSubarray(int[] arr) {
      int max = 1;
      int prev = 0;
      int temp[]= new int[32];
      for(int i=0;i<arr.length;i++)
      {
        String str = Integer.toBinaryString(arr[i]);
        int k = 31;
        for(int j=str.length()-1;j>=0;j--)
        {
          if(str.charAt(j)=='1')
            temp[k]++;
          k--;
        }
        // System.out.print(str+"::::::::::::");
        // for(int k2:temp)
        //     System.out.print(k2+" ");
        //   System.out.println();
        if(check(temp))
        {          
            for(int j=prev;j<i;j++)
            {
                str = Integer.toBinaryString(arr[j]);
              k=31;
              for(int p=str.length()-1;p>=0;p--)
              {
                if(str.charAt(p)=='1')
                   temp[k]--;
                k--;
              }
              if(!check(temp))
              {
                prev = j+1;
                max = Math.max(max,i-prev+1);
                break;
                // System.out.println(prev +" "+i);
              }
              
            }
        }          
          max = Math.max(max,i-prev+1);
        }
      return max;
        
    }
  public boolean check(int arr[])
  {
    for(int i:arr)
    {
      if(i>1)
        return true;
    }
    return false;
  }
}
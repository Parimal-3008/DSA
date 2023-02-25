class Solution {
    public int bagOfTokensScore(int[] arr, int k) {
      Arrays.sort(arr);
      int i=0;int j = arr.length-1;
      int score = 0;
      int max =0;
      
      while(i<=j)
      {
        if(arr[i]<=k)
        {
          System.out.println(i+" "+k);
          k-=arr[i];score++;
          max=Math.max(max,score);
          i++;
        }
        else
        {
          if(score>0)
          {
            k+=arr[j];
            score--;
            j--;
          }
          else
            break;
        }
        
      }
      return max;
        
    }
}
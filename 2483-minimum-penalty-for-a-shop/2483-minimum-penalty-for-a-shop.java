class Solution {
    public int bestClosingTime(String str) {
      char[] arr= str.toCharArray();
      int count =0;
      int ind =arr.length;
      for(char i:arr)
      {
        if(i=='N')
          count++;
      }
      int max =count;
      for(int i=arr.length-1;i>=0;i--)
      {
        if(arr[i]=='N')
        {
          count--;
         if(max>=count)
         {
           max = count;ind =i;
         }
        }
        else
          count++;
      }
      return ind;
      
        
    }
}
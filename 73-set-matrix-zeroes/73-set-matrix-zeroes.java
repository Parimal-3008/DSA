class Solution {
    public void setZeroes(int[][] arr) {
      int st1=0;
      int st2=0;
      for(int i=01;i<arr.length;i++)
       if(arr[i][0]==0)
        st1=01;    
      for(int j=01;j<arr[0].length;j++)
        if(arr[0][j]==0)
          st2=01;     
      for(int i=01;i<arr.length;i++)
           for(int j=1;j<arr[0].length;j++)
             if(arr[i][j]==0)
            {
              arr[i][0]=0;
              arr[0][j]=0;
            }      
      for(int i=01;i<arr.length;i++)
      {
        for(int j=01;j<arr[0].length;j++)
        {
          if(arr[i][0]==0)
            arr[i][j]=0;
        }
      }
      for(int i=01;i<arr[0].length;i++)
        for(int j=01;j<arr.length;j++)
        {
          if(arr[0][i]==0)
            arr[j][i]=0;
        }
      //System.out.println(st1+".."+st2);
      if(arr[0][0]==0)
      {
        for(int i=0;i<arr.length;i++)
          arr[i][0]=0;
        for(int i=0;i<arr[0].length;i++)
          arr[0][i]=0;
        return;
      }
       if(st2==1)
      {
         Arrays.fill(arr[0],0);
      }
      if(st1==1)
      {
       for(int j=0;j<arr.length;j++)
         arr[j][0]=0;
      }
    }
}
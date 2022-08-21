class Solution {
    public List<List<String>> solveNQueens(int n) {
        int arr[][]= new int[n][n];
      List<List<String>> list = new ArrayList<>();
      
        call (arr,0,list,n);
        
      return list;        
    }
  public void call(int[][] arr,int i,List<List<String>> list,int n)
  {
    if(n==0)
    {
      List<String> l = new ArrayList<>();
      for(int p=0;p<arr.length;p++)
      {
        String str="";
           for(int q=0;q<arr.length;q++)
         {
             if(arr[p][q]==1)
             str+= "Q";
           else
             str+=".";
         }
        l.add(str);
      }
      list.add(l);
    
      return;     
    }
    if(i==arr.length || n<0)
      return;
    
    for(int p=0;p<arr.length;p++)
    {
        if(check(i,p,arr))
        {
          arr[i][p]=1;
          call(arr,i+1,list,n-1);
          arr[i][p]=0;
        }
    }    
  }
  public boolean check(int i,int j, int arr[][])
  {
    for(int p=0;p<arr.length;p++)
    {
      if(arr[i][p]==1 || arr[p][j]==1)
        return false;
    }
    int p=1;int n = arr.length;
    int i1=i;int j1=j;
    while(i1<n && j1<n)
    {
     
      if(arr[i1][j1]==1)
        return false;
       i1+=p;j1+=p;
      
    }
    p=1;j1=j;i1=i;
    while(i1<n && j1>=0)
    {
     
      if(arr[i1][j1]==1)
        return false;
       i1+=p;j1-=p;
    

    }
     p=1;j1=j;i1=i;
    while(i1>=0 && j1>=0)
    {
      
      if(arr[i1][j1]==1)
        return false;
      i1-=p;j1-=p;
     

    }
     p=1;j1=j;i1=i;
    while(i1>=0 && j1<n)
    {
     
      if(arr[i1][j1]==1)
        return false;
       j1+=p;i1-=p;
     

    }
    return true;
  }
    
}
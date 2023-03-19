class Solution {
    public List<Boolean> canMakePaliQueries(String str, int[][] q) {
      int n = str.length();
      int arr[][]= new int[n][26];
      for(int i=0;i<str.length();i++)
      {
         char ch = str.charAt(i);
        if(i!=0)
        {
           for(int j=0;j<26;j++)
             arr[i][j]=arr[i-1][j];
        }
        arr[i][ch-'a']++;
      }
      List<Boolean> list = new ArrayList<>();
      for(int[] i:q)
      {
        int a = i[0];
        int b = i[1];
        int k = i[2];
        int[] arr2 = new int[26];
        if(a!=0)
        {
          for(int j=0;j<26;j++)
          {
            arr2[j]=arr[b][j]-arr[a-1][j];
          }
        }
        else
        {
          for(int j=0;j<26;j++)
            arr2[j]=arr[b][j];
        }
        int odd=0;
        for(int j:arr2)
        {
          if(j%2==1)
            odd++;
        }
       if(odd<=1)
          list.add(true);
        else
        {
           odd--;
          if((odd+1)/2>k)
            list.add(false);
          else
            list.add(true);
        }
      }
      return list;
        
    }
}
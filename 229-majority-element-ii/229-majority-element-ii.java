class Solution {
    public List<Integer> majorityElement(int[] arr) {
      int n = arr.length;
      List<Integer> list= new ArrayList<>();
      if(n==0)
        return list;
        
        int a= arr[0];int c1=0;
        int b =arr[0];int c2=0;
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]==a)
          c1++;
        else if(arr[i]==b)
          c2++;
        else if(c1==0)
        {
          c1=1;
          a=arr[i];
        }
        else if(c2==0)
        {
          c2=1;
          b= arr[i];
        }
        else
        {
          c1--;
          c2--;
        }
      }
      c1=0;
      c2=0;
      for(int i:arr)
      {
        if(i==a)
          c1++;
        else if(i==b)
          c2++;
      }
      if(c1>n/3)
        list.add(a);
      if(c2>n/3)
        list.add(b);
      return list;
    }
}
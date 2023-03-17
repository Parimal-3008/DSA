class Solution {
    public int latestTimeCatchTheBus(int[] arr1, int[] arr2, int k) {
        Arrays.sort(arr1);
      Arrays.sort(arr2);
      if(arr2[0]>arr1[arr1.length-1])
        return arr1[arr1.length-1];
      int j=0;
     int curr=0;
      List<Integer> list = new ArrayList<>();
      int tot=0;
      for(int i=0;i<arr2.length;i++)
      {
        if(curr==k)
        {
          j++;
           if(tot==k*arr1.length)
              return call(list);
           if(j==arr1.length)
            {
             
            System.out.println(curr+";;"+list+" "+tot);
             return call(list);
            }
          curr=0;
        }
        if(arr1[j]>=arr2[i])
        {
          list.add(arr2[i]);tot++;
          curr++;
        }
        else
        {
          j++;
          i--;
          if(j==arr1.length)
          {
            System.out.println(curr+":::::::"+list+" "+tot);
            if(tot==k*arr1.length)
              return call(list);
            if(curr<k)
            {
              if(list.get(tot-1)<arr1[j-1])
                return arr1[j-1];
              else
                return call(list);
            }
          }
          curr=0;
          
        }
      }
            System.out.println(curr+"......."+list+" "+tot);
       if(j<arr1.length-1)
        return arr1[arr1.length-1];
      if(curr<k)
      {
        if(list.get(tot-1)==arr1[j])
          return call(list);
        return arr1[j];
      }
     
          return call(list);
    }
   public int call(List<Integer> list)
   {
       for(int i=list.size()-2;i>=0;i--)
      {
         int a = list.get(i);
        int b = list.get(i+1);
        if(b-1==a)
          continue;
        return b-1;
      }
      return list.get(0)-1;
   }
}
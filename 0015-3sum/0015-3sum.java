class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
      for(int i=0;i<arr.length;i++)
      {
          int search = -arr[i];
          if(i-1>=0 && arr[i]==arr[i-1])
              continue;
          int j=i+1;int k = arr.length-1;
          while(j<k)
          {
              if(j==i)
              {
                  j++;continue;
              }
              if(k==i)
              {
                  k--;continue;
              }
              int sum = arr[j]+arr[k];
              if(sum>search)
                  k--;
              else if(sum<search)
                  j++;
              else
              {
                  List<Integer> temp = new ArrayList<>();
                  temp.add(arr[i]);temp.add(arr[j]);temp.add(arr[k]);
                  res.add(temp);
                  int p1= arr[j];int q1=arr[k];
                  while(j<k && arr[j]==p1)
                    j++;
                  while(j<k && arr[k]==q1)
                  k--;
                 // break;
              }
          }
      }
        return res;
    }
}
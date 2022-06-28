class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>(){
          public int compare(int a[], int b[])
          {
            int res = Integer.compare(a[0],b[0]);
            if(res==0)
              res = Integer.compare(a[1],b[1]);
            return res;
          }
        });
      // for(int[] i:arr)
      // {
      //   System.out.println(i[0]+" "+i[1]);
      // }
      List<int[]> list = new ArrayList<>();
      int prev =arr[0][0];
      int curr=arr[0][1];
      for(int i=1;i<arr.length;i++)
      {
           if(arr[i][0]>curr)
           {
             int[] temp= new int[2];
             temp[0]=prev;temp[1]=curr;
             list.add(temp);
             prev=arr[i][0];
             curr=arr[i][1];
           }
           else if(arr[i][0]<=curr && arr[i][1]>curr)
           {
             curr = arr[i][1];
           }
      }
      int[] temp= new int[2];
             temp[0]=prev;temp[1]=curr;
             list.add(temp);
      int[][] ans = new int[list.size()][2];
      for(int i=0;i<list.size();i++)
      {
        int resr[]= list.get(i);
        ans[i][0]=resr[0];
        ans[i][1]=resr[1];
      }

      return ans;
    }
}
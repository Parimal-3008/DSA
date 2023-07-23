class Solution {
    public int[] findRedundantConnection(int[][] arr) {
     List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=arr.length;i++)
            list.add(new ArrayList<>());
        for(int i[]:arr)
        {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
             boolean vis[]= new boolean[arr.length+1];
            Arrays.fill(vis,false);
            boolean st = check(list,vis,i[0],-1);
            
            if(st)
            {
                // System.out.println(list);
               return i;
            }
        }
//         for(int i=0;i<arr.length;i++)
//         {
//             list.get(arr[i][0]).remove(Integer.valueOf(arr[i][1]));
//             list.get(arr[i][1]).remove(Integer.valueOf(arr[i][0]));
            
//              list.get(arr[i][0]).add(arr[i][1]);
//             list.get(arr[i][1]).add(arr[i][0]);
            
//         }
        int[] tme={-1,-1};
        return tme;
    }
    public boolean check(List<List<Integer>> list,boolean[] vis, int i,int prev)
    {
       vis[i]=true;
        // if(list.get(i).isEmpty())
        //     return true;
        // // boolean ans = true;
        for(int j:list.get(i))
        {
            if(vis[j]==false)
            {
                if(check(list,vis,j,i))
                    return true;
            }
            else if(j!=prev)
                return true;
        }
        return false;
    }
}
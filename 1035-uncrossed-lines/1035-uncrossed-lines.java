class Solution {
    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        Map<Integer,TreeSet<Integer>> mp1 = new HashMap<>();
         Map<Integer,TreeSet<Integer>> mp2 = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(!mp1.containsKey(arr1[i]))
            {
                TreeSet<Integer> list = new TreeSet<>();
                list.add(i);
                mp1.put(arr1[i],list);
            }
            else
            {
                TreeSet<Integer> list = mp1.get(arr1[i]);
                list.add(i);
                mp1.put(arr1[i],list);
            }
        }
        for(int i=0;i<arr2.length;i++)
        {
            if(!mp2.containsKey(arr2[i]))
            {
                TreeSet<Integer> list = new TreeSet<>();
                list.add(i);
                mp2.put(arr2[i],list);
            }
            else
            {
                TreeSet<Integer> list = mp2.get(arr2[i]);
                list.add(i);
                mp2.put(arr2[i],list);
            }
        }
        int[][] dp = new int[arr1.length+10][arr2.length+10];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return call(0,-1,mp1,mp2,arr1,arr2,dp);
    }
public int call(int i,int j,Map<Integer,TreeSet<Integer>> mp1,Map<Integer,TreeSet<Integer>> mp2,int[] arr1,int[] arr2,int[][] dp)
{
    if(i==arr1.length || j == arr2.length)
        return 000;
     int a  =0;
    if(dp[i][j+1]!=-1)
        return dp[i][j+1];
    if(mp2.containsKey(arr1[i])) //pick
     {    
         TreeSet<Integer> s1 = mp2.get(arr1[i]);
        Integer ind =  s1.higher(j);
      if(ind!=null && ind.intValue()>j)
      a = 1+ call(i+1,ind.intValue(),mp1,mp2,arr1,arr2,dp);
        
     }
    //notpick
    int b = call(i+1,j,mp1,mp2,arr1,arr2,dp);
    return dp[i][j+1]=Math.max(a,b);
}
}